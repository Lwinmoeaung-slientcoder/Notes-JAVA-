import java.sql.*;

public class Register_db{
	boolean Result;
	private Connection con;
	private Statement st;
	String url="jdbc:mysql://localhost:3306/inventory";
	String db_username="root";
	String db_password="";
	String user,pass,phone;
	
	 Register_db(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,db_username,db_password);
			st=con.createStatement();  
			  
			 
			
			 
		}catch(Exception e) {
			System.out.println("Error :"+e);
		}	
	}
	
	public void setValue(String username, String password, String ph) throws SQLException {
		user=username;
		pass=password;
		phone=ph;
		st.executeQuery("insert into login(username,password,phone)values('"+user+"','"+pass+"','"+phone+"')");
		this.Result=true;
		//this.testing=user+pass+phone;
	}

	public boolean getValue() {
		return Result;
		//return testing;
	}
	public static void main(String args[]) {
		new Register_db();
	}
}
