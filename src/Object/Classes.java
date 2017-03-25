package Object;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.ConnectDB;

public class Classes {
	private int id_class;
	private String class_name;
	public int getId_class() {
		return id_class;
	}
	public void setId_class(int id_class) {
		this.id_class = id_class;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public Classes(int id_class, String class_name) {
		super();
		this.id_class = id_class;
		this.class_name = class_name;
	}
	
	public Classes() {
		super();
	}
	public static ArrayList<Classes> getAllClass() throws Exception{
		 ArrayList<Classes> lst = new ArrayList<Classes>();
		 String strSQL = "select c.id_class,c.class_name from class c";
		 ConnectDB conn = new ConnectDB();
		 try 
		 {
			 ResultSet rs = conn.getStatement().executeQuery(strSQL);
			 while(rs.next()){
				 int cID = rs.getInt("c.id_class");
				 String cName = rs.getString("c.class_name");
			
				
				 Classes cla = new Classes(cID, cName);
				 lst.add(cla);
			 }
		 } catch (Exception e) 
		 {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		 }
		 conn.closeConnet();
		 return lst;
	}
	
	public static void insertClass(String str) throws Exception
	{
		
		ConnectDB con = new ConnectDB();
		String query="insert into class(class_name) values(?)";
	
		PreparedStatement ps=con.openConnect().prepareStatement(query);  // generates sql query
		ps.setString(1, str);
		
		ps.executeUpdate(); // execute it on test database
		System.out.println("successfuly inserted");
		ps.close();
		con.closeConnet();

	}
	

	
	public static void deleteClassByID(int id) throws SQLException, Exception{
		 String sql = "delete from class where id_class=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, id);
		 ps.executeUpdate();
		 
	}
	 
	 
	public static Classes getClassByID(int claID)throws Exception{
		 String sql = "select * from class where id_class=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, claID);
		 ResultSet rs = ps.executeQuery();
		 Classes cla = null;
		 if(rs.next()){
			 int idcla = rs.getInt("id_class");
			 String claname = rs.getString("class_name");	
			
			 cla = new Classes(idcla, claname);
		 }
		 return cla;
	}
	public static void updateClass(int bus, String buss) throws SQLException, Exception{
		 String sql = "update class set id_class=?, class_name=? where id_class=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, bus);
		 ps.setString(2, buss);
		 ps.setInt(3,bus);
		 ps.executeUpdate();
	}
	 public static void main(String agrs[]) throws Exception
	 {
		 
		 //insertClass("huhu");
		 //updateClass(2,"hihi");
		 //deleteClassByID(2);
		 Classes cla =  getClassByID(1);
		 System.out.println(cla.getId_class());
		 System.out.println(cla.getClass_name());
		 List<Classes> list = null;
			
			try {
				list = Classes.getAllClass();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for(Classes cl:list)
		{
			System.out.println(cl.getId_class());
			System.out.println(cl.getClass_name());
		}
	 
}
}
