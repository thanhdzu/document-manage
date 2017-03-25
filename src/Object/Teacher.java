package Object;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.ConnectDB;

public class Teacher {
	public Teacher() {
		super();
	}
	private int id_teacher;
	private String teacher_name;
	public int getId_teacher() {
		return id_teacher;
	}
	public void setId_teacher(int id_teacher) {
		this.id_teacher = id_teacher;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public Teacher(int id_teacher, String teacher_name) {
		super();
		this.id_teacher = id_teacher;
		this.teacher_name = teacher_name;
	}
	
	
	public static ArrayList<Teacher> getAllTeacher() throws Exception{
		 ArrayList<Teacher> lst = new ArrayList<Teacher>();
		 String strSQL = "select id_teacher, teacher_name from teacher";
		 ConnectDB conn = new ConnectDB();
		 try 
		 {
			 ResultSet rs = conn.getStatement().executeQuery(strSQL);
			 while(rs.next()){
				 int tID = rs.getInt("id_teacher");
				 String tName = rs.getString("teacher_name");
			
				
				 Teacher tea = new Teacher(tID, tName);
				 lst.add(tea);
			 }
		 } catch (Exception e) 
		 {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		 }
		 conn.closeConnet();
		 return lst;
	}
	
	public static void insertTeacher(String str) throws Exception
	{
		
		ConnectDB con = new ConnectDB();
		String query="insert into teacher(teacher_name) values(?)";
	
		PreparedStatement ps=con.openConnect().prepareStatement(query);  // generates sql query
		ps.setString(1, str);
		
		ps.executeUpdate(); // execute it on test database
		System.out.println("successfuly inserted");
		ps.close();
		con.closeConnet();

	}
	

	
	public static void deleteTeacherByID(int id) throws SQLException, Exception{
		 String sql = "delete from teacher where id_teacher=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, id);
		 ps.executeUpdate();
		 
	}
	 
	 
	public static Teacher getTeacherByID(int teaID)throws Exception{
		 String sql = "select * from teacher where id_teacher=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, teaID);
		 ResultSet rs = ps.executeQuery();
		 Teacher tea = null;
		 if(rs.next()){
			 int idtea = rs.getInt("id_teacher");
			 String teaname = rs.getString("teacher_name");	
			
			 tea = new Teacher(idtea, teaname);
		 }
		 return tea;
	}
	public static void updateTeacher(int tea, String teac) throws SQLException, Exception{
		 String sql = "update teacher set id_teacher=?, teacher_name=? where id_teacher=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, tea);
		 ps.setString(2, teac);
		 ps.setInt(3,tea);
		 ps.executeUpdate();
	}
	 public static void main(String agrs[]) throws Exception
	 {
		 
		 //insertTeacher("huhu");
		 //updateTeacher(2,"hihi");
		 //deleteTeacherByID(2);
		 Teacher tea =  getTeacherByID(1);
		 System.out.println(tea.getId_teacher());
		 System.out.println(tea.getTeacher_name());
		 List<Teacher> list = null;
			
			try {
				list = Teacher.getAllTeacher();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for(Teacher te:list)
		{
			System.out.println(te.getId_teacher());
			System.out.println(te.getTeacher_name());
		}
	 
}
}
