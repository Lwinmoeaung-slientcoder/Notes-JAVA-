import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class Login extends JFrame {
	JButton bt1,bt2;
	JLabel jl1,jl2,jl3;
	JTextField jtxt1,jtxt2;
	JPasswordField jpwd;
	
	Login(){
		JFrame frame=new JFrame();
		frame.setTitle("Login");
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(600,200);
		frame.setLayout(null);
		
		jl1=new JLabel("Login Form");
		jl1.setBounds(180,20,300,50);
		jl1.setFont(new Font("Courier", Font.BOLD,18));
		
		jl2=new JLabel("UserName");
		jl2.setBounds(150,110,100,50);
		jl3=new JLabel("Password");
		jl3.setBounds(150,160,100,50);
		
		jtxt1=new JTextField();
		jtxt1.setBounds(230,130,150,30);
		jpwd=new JPasswordField();
		jpwd.setBounds(230,170,150,30);
		
		bt1=new JButton("Back");
		bt1.setBounds(130,300,100,30);
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Loading_Frame();	
			}
		});
		
		bt2=new JButton("Login");
		bt2.setBounds(330,300,100,30);
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				String username=jtxt1.getText();
				String password=String.valueOf(jpwd.getPassword());
				Login_Check lc=new Login_Check();
				try {
					lc.setResult(username,password);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if(lc.getResult()>0) {
					JOptionPane.showMessageDialog(null, "Welcome");
					Create_notes cn=new Create_notes();				
					  cn.setuserid(lc.getResult());
					frame.dispose();
					new Create_notes();
				}else {
					JOptionPane.showMessageDialog(null, "Sorry try again!!");
				}
			}
		});
		
		frame.add(jl1);
		frame.add(jl2);
		frame.add(jl3);
		frame.add(bt1);
		frame.add(bt2);
		frame.add(jtxt1);
		frame.add(jpwd);
		frame.setVisible(true);
	}


	public static void main(String[] args) {
		new Login();
		
	
	}

}
