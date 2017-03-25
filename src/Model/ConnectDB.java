package Model;
import java.sql.*;
import java.util.ArrayList;

import javax.sql.*;

import Object.Category;
public class ConnectDB {
	Connection connect = null;
	Statement stmt = null;
	ResultSet rs = null;
	 
	/**
	 * Kiemk tra Driver ket noi co so du lieu
	 */
	 protected void hasDriver() throws Exception{
		 try 
		 {
			 Class.forName("com.mysql.jdbc.Driver");
		 } 
		 catch (ClassNotFoundException ex) {
			 
			 throw new Exception ("Invalid Driver!!Please check this drver....");
			 
		 }
	 }
	 
	 /**
	  * Ket noi co so du lieu
	  * 1 - Kiem tra ket noi
	  * 2 - Neu chua ket noi thi tao ket noi
	  * 3 - Tra ve ket qua la ket noi
	  * @return Connection
	  */
	  public Connection openConnect() throws Exception{
	 	 if(connect == null)
	 	 {
	 		 hasDriver();
	 		 String url = "jdbc:mysql://localhost/project";
	 	 
	 	 try 
	 	 {
	 		 this.connect = DriverManager.getConnection(url,"root","");
	 		 System.out.println("Connect success");
	 	 } catch (SQLException e) 
	 	 {
	 		 throw new Exception(e.getMessage() + "Connect failed to database .... ");
	 	 	}
	 	 }
	 	 return connect;
	  }
	  /**
	  * Make a Statement to execute the SQL statement
	  * @return Statement
	  */
	  public Statement getStatement() throws SQLException, Exception{
	 	 if(stmt == null)
	 	 {
	 		 stmt = openConnect().createStatement();
	 	 }
	 	 return stmt;
	  }

	  /**
	  * A method to close the connection.
	  * @throws SQLException
	  */
	  public void closeConnet() throws SQLException
	  {
	 	 if(rs != null && !rs.isClosed())
	 		 rs.close();
	 	 if(stmt != null)
	 		 stmt.close();
	 	 if(connect != null)
	 		 connect.close();
	  }
	  
	  /**
	   * Thuc Thi Insert, Delete, Update
	   * @param strSQL Query
	   * @return So dong bi anh huong boi cau lenh
	   */
	  public int executeUpdate(String strSQL) throws Exception{
	  	 int result = 0;
	  	 try 
	  	 {
	  		 result = getStatement().executeUpdate(strSQL);
	  	 } 
	  	 catch (Exception ex) {
	  		 throw new Exception(ex.getMessage() + " Error at: " + strSQL);
	  	 }
	  	 finally{
	  		 this.closeConnet();
	  	 }
	  	 return result;
	  }
	  
	//---------------------------------------------------------------------------------------------------------
	//----------------------------------------  Querry on Categorys table
	//---------------------------------------------------
	//---------------------------------------------------------------------------------------------------------
	public ArrayList<Category> getCategory() throws Exception{
		 ArrayList<Category> lst = new ArrayList<Category>();
		 String strSQL = "select * from categorys";
		 try 
		 {
			 rs = getStatement().executeQuery(strSQL);
			 while(rs.next()){
				 int cID = rs.getInt("idcate");
				 String cName = rs.getString("catename");
				 
				 Category cat = new Category(cID,cName);
				 
				 lst.add(cat);
			 }
		 } catch (Exception e) 
		 {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		 }
		 closeConnet();
		 return lst;
	}
	 
	public boolean insertCategory(Category cat) throws Exception
	{
		 String sql = "insert into categorys values(?,?)";
		 PreparedStatement pst = openConnect().prepareStatement(sql);
		 pst.setInt(1, cat.getIdcate());
		 pst.setString(2, cat.getCatename());
		
		 
		 return pst.executeUpdate() > 0;
	 
	}
	 
	public boolean deleteCategory(String categoryID) throws SQLException, Exception{
		 String sql = "delete from categorys where categoryID=?";
		 PreparedStatement pst = openConnect().prepareStatement(sql);
		 pst.setString(1, categoryID);
		return pst.executeUpdate()>0;
		 
	}
	 
	 
	 

	 
	public Category getCategoryByID(String catID)throws Exception{
		 String sql = "select * from categorys where categoryID=?";
		 PreparedStatement pst = openConnect().prepareStatement(sql);
		 pst.setString(1, catID);
		 ResultSet rs = pst.executeQuery();
		 Category cat = null;
		 if(rs.next()){
			 String catid = rs.getString("categoryID");
			 String catname = rs.getString("categoryName");	
			 
			 cat = new Category();
		 }
		 return cat;
	}
	public boolean updateCategory(String catID, Category cat) throws SQLException, Exception{
		 String sql = "update categorys set categoryID=?, categoryName=?,  where categoryID=?";
		 PreparedStatement pst = openConnect().prepareStatement(sql);
		 pst.setString(1, cat.getCatename());
	//	 pst.setString(2, cat.getCategoryName());
		// pst.setString(3, cat.getDescription());
		 pst.setString(4, catID);
		 return pst.executeUpdate()>0;
	}
	 
}
