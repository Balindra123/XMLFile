package test1.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import test1.model.Student;

public class JDBCClient {

	public static void main(String[] args) {
		System.out.println("something is better thsn nothgingo");
		Student s1=new Student(3,"Micheal","mich@example.com","country homes");
		Connection connection=null;
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_db", "root", "12345678");

			Statement stmt = connection.createStatement();
		 
		String sql="insert into Students values("+s1.roll+",'" +s1.name+"','"+s1.email+"','"+s1.address+"')";
			//String sql="insert into Students values"
		          //  +"(1,'Balindra','balindra@exe.com','Nepal')";
			 
		 
		 
		
		 int i=stmt.executeUpdate(sql);
		 System.out.println("Row(s) inserted :"+i);
		 
		 printResult(stmt);
		 connection.close();
		 
	 }catch(Exception e) {
	 System.out.println(e);
	 }

	}
	public static void printResult(Statement stmt) throws SQLException {
		System.out.println("===============================\n");
		ResultSet rs = stmt.executeQuery("select * from Students");
		while (rs.next())
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)+rs.getString(3));
	}

}
