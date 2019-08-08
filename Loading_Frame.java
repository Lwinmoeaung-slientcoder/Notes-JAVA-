import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class Loading_Frame extends JFrame {
	JButton bt1,bt2;
	JLabel jl1,image;
	String path;
	
	Loading_Frame(){
		
		JFrame frame=new JFrame();
		frame.setTitle("Notes");
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(600,200);
		frame.setLayout(null);
		
		jl1=new JLabel("Welcome From Your Notes");
		jl1.setBounds(180,20,300,50);
		jl1.setFont(new Font("Courier", Font.BOLD,18));
	
		path="1.jpg";
		ImageIcon i=new ImageIcon(path);	
		image=new JLabel(i);
		image.setBounds(10,50,200,200);
		
		
		bt1=new JButton("Old User");
		bt1.setBounds(130,300,100,30);
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Login();
			
			}
		});
		
		bt2=new JButton("New User");
		bt2.setBounds(330,300,100,30);
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Register();
			}
		});
		frame.add(image);
		frame.add(jl1);
		frame.add(bt1);
		frame.add(bt2);
		frame.setVisible(true);
	}


	public static void main(String[] args) {
		new Loading_Frame();
		
	
	}

}
