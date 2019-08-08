import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register{
	JButton bt1,bt2;
	JLabel jl1,jl2,jl3,jl4;
	JTextField jtxt1,jtxt2;
	JPasswordField jpwd;
	String username,password,ph;
	
	public Register() {
		JFrame frame=new JFrame();
		frame.setTitle("Register");
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(600,200);
		frame.setLayout(null);
		
		jl1=new JLabel("Register Form");
		jl1.setBounds(180,20,200,50);
		jl1.setFont(new Font("Courier", Font.BOLD,18));
		
		jl2=new JLabel("UserName");
		jl2.setBounds(150,110,100,50);
		jl3=new JLabel("Password");
		jl3.setBounds(150,160,100,50);
		jl4=new JLabel("Fav_color");
		jl4.setBounds(154,200,100,50);
		
		jtxt1=new JTextField();
		jtxt1.setBounds(230,130,150,30);
		jpwd=new JPasswordField();
		jpwd.setBounds(230,170,150,30);
		jtxt2=new JTextField();
		jtxt2.setBounds(230,210,150,30);
		
		bt1=new JButton("Back");
		bt1.setBounds(130,300,100,30);
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						frame.dispose();
						new Loading_Frame();
				
			}
		});
		
		bt2=new JButton("Create");
		bt2.setBounds(330,300,100,30);
		bt2.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				username=jtxt1.getText();
			//	password=String.valueOf(jpwd);
				password=new String(jpwd.getPassword());
				ph=jtxt2.getText();
				if(username.equals("")||password.equals("")||ph.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill all data.");
					
				}else {
				
				
			Register_db rdb=new Register_db();
			try {
				rdb.setValue(username,password,ph);
				System.out.println(rdb.getValue());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				if(rdb.getValue()==true) {
					JOptionPane.showMessageDialog(null, "Successfully...Now Login !!!!");
				}
			}
		}
	});
		
		
		frame.add(jl1);
		frame.add(jl2);
		frame.add(jl3);
		frame.add(jl4);
		frame.add(bt1);
		frame.add(bt2);
		frame.add(jtxt1);
		frame.add(jtxt2);
		frame.add(jpwd);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Register();

	}

}
