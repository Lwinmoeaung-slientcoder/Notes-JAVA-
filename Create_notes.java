import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Create_notes {
	private	Connection con;
	private	Statement st;
	private ResultSet rs;
	String url="jdbc:mysql://localhost:3306/inventory";
	String db_username="root";
	String db_pass="";
	String note,date;
	int userid;
	JButton bt1,bt2;
	JLabel jl1,jl2,jl3,jl4;
	JTextField jtxt2;
	JTextArea jtxt1;
	
	
	public Create_notes()  {
		JFrame frame=new JFrame();
		frame.setTitle("Create Notes");
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(600,200);
		frame.setLayout(null);
		
		jl1=new JLabel("Record Your Notes");
		jl1.setBounds(180,20,200,50);
		jl1.setFont(new Font("Courier", Font.BOLD,18));
		
		jl2=new JLabel("Notes");
		jl2.setBounds(150,110,100,50);
		
		jl4=new JLabel("date");
		jl4.setBounds(154,200,100,50);
		
		jtxt1=new JTextArea();
		jtxt1.setBounds(230,90,150,100);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date today_date = new Date();
		   
		jtxt2=new JTextField(dateFormat.format(today_date));
		jtxt2.setBounds(230,210,150,30);
		
		bt1=new JButton("Back");
		bt1.setBounds(130,300,100,30);
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						frame.dispose();
						new Login();
				
			}
		});
		
		bt2=new JButton("Create");
		bt2.setBounds(330,300,100,30);
		bt2.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				note=jtxt1.getText();
				date=jtxt2.getText();
				db_con();
				
		}
	});
		
		
		frame.add(jl1);
		frame.add(jl2);
		frame.add(jl4);
		frame.add(bt1);
		frame.add(bt2);
		frame.add(jtxt1);
		frame.add(jtxt2);
		frame.setVisible(true);
	
	}
	void db_con() {
		try {
		System.out.print("Hello"+userid);
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,db_username,db_pass);
			st=con.createStatement();
			st.executeUpdate("insert into notes(userid,note,date) values ('"+userid+"','"+note+"','"+date+"')"); 
			
			 
			con.close();
			} catch (Exception e) {
				System.out.println("Error :"+e);
				}
			}
	
		public void setuserid(int id) {
			System.out.println("ok"+id);
			userid=id;
				this.userid=userid;
		}
	
	//Main Method
		public static void main(String[] args) {
		new Create_notes();
			
	}

}
