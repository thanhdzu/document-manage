package Object;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.ConnectDB;


public class Category {
	private int idcate;
	private String catename;
	public Category() {
		super();
	}
	public int getIdcate() {
		return idcate;
	}
	
	public Category(int idcate, String catename) {
		super();
		this.idcate = idcate;
		this.catename = catename;
	}
	public void setIdcate(int idcate) {
		this.idcate = idcate;
	}
	public String getCatename() {
		return catename;
	}
	public void setCatename(String catename) {
		this.catename = catename;
	}
	
	public static ArrayList<Category> getAllCategory() throws Exception{
		 ArrayList<Category> lst = new ArrayList<Category>();
		 String strSQL = "select c.idcate,c.catename from categorys c";
		 ConnectDB conn = new ConnectDB();
		 try 
		 {
			 ResultSet rs = conn.getStatement().executeQuery(strSQL);
			 while(rs.next()){
				 int cID = rs.getInt("c.idcate");
				 String cName = rs.getString("c.catename");
			
				
				 Category cat = new Category(cID, cName);
				 lst.add(cat);
			 }
		 } catch (Exception e) 
		 {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		 }
		 conn.closeConnet();
		 return lst;
	}
	
	public static void insertCategory(String str) throws Exception
	{
		
		ConnectDB con = new ConnectDB();
		String query="insert into categorys(catename) values(?)";
	
		PreparedStatement ps=con.openConnect().prepareStatement(query);  // generates sql query
		ps.setString(1, str);
		
		ps.executeUpdate(); // execute it on test database
		//System.out.println("successfuly inserted");
		ps.close();
		con.closeConnet();

	}
	

	
	public static void deleteCategoryByID(int id) throws SQLException, Exception{
		 String sql = "delete from categorys where idcate=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, id);
		 ps.executeUpdate();
		 
	}
	 
	 
	public static Category getCategoryByID(int catID)throws Exception{
		 String sql = "select * from categorys where idcate=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, catID);
		 ResultSet rs = ps.executeQuery();
		 Category cat = null;
		 if(rs.next()){
			 int catid = rs.getInt("idcate");
			 String catname = rs.getString("catename");	
			
			 cat = new Category(catid, catname);
		 }
		 return cat;
	}
	public static void updateCategory(int cat, String catt) throws SQLException, Exception{
		 String sql = "update categorys set idcate=?, catename=? where idcate=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, cat);
		 ps.setString(2, catt);
		 ps.setInt(3,cat);
		 ps.executeUpdate();
	}
	 public static void main(String agrs[]) throws Exception
	 {
		 
		 //insertCategory("huhu");
		 //updateCategory(7,"hihi");
		 //deleteCategoryByID(7);
		 Category cate =  getCategoryByID(2);
		 System.out.println(cate.getIdcate());
		 System.out.println(cate.getCatename());
		 List<Category> list = null;
			
			try {
				list = Category.getAllCategory();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for(Category cat:list)
		{
			System.out.println(cat.idcate);
			System.out.println(cat.getCatename());
		}
	 }
}
