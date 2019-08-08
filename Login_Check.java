import java.sql.*;

public class Login_Check {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	String url="jdbc:mysql://localhost:3306/inventory";
	String db_username="root";
	String db_pass="";
	private String name,pwd;
	int Login_user,Result;
	int id;
	
	Login_Check() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,db_username,db_pass);
			st=con.createStatement();  
			 rs=st.executeQuery("select * from login");  
			 
			
			 
		}catch(Exception e) {
			System.out.println("Error :"+e);
		}	
	}
	
	public int getResult() {
		return Login_user;
	}
	public void setResult(String user,String pass) throws SQLException {
		 while(rs.next()) {
			 id=rs.getInt("id");
			  name=rs.getString("username");
			  pwd=rs.getString("password");
			  if(user.equals(name)&&pass.equals(pwd)) {
				  
					Result=id;
					break;
				}
		 }
		
		this.Login_user=Result;
	}
	
	
	public static void main(String[] args) {
		new Login_Check();

	}
	
}
