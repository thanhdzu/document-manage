package Object;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.ConnectDB;

public class Business {
	private int id_business;
	private String business_name;
	public int getId_business() {
		return id_business;
	}
	public void setId_business(int id_business) {
		this.id_business = id_business;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public Business(int id_business, String business_name) {
		super();
		this.id_business = id_business;
		this.business_name = business_name;
	}
	
	public Business() {
		super();
	}
	public static ArrayList<Business> getAllBusiness() throws Exception{
		 ArrayList<Business> lst = new ArrayList<Business>();
		 String strSQL = "select b.id_business,b.business_name from business b";
		 ConnectDB conn = new ConnectDB();
		 try 
		 {
			 ResultSet rs = conn.getStatement().executeQuery(strSQL);
			 while(rs.next()){
				 int bID = rs.getInt("b.id_business");
				 String bName = rs.getString("b.business_name");
			
				
				 Business bus = new Business(bID, bName);
				 lst.add(bus);
			 }
		 } catch (Exception e) 
		 {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		 }
		 conn.closeConnet();
		 return lst;
	}
	
	public static void insertBusiness(String str) throws Exception
	{
		
		ConnectDB con = new ConnectDB();
		String query="insert into business(business_name) values(N?)";
	
		PreparedStatement ps=con.openConnect().prepareStatement(query);  // generates sql query
		ps.setString(1, str);
		
		ps.executeUpdate(); // execute it on test database
		System.out.println("successfuly inserted");
		ps.close();
		con.closeConnet();

	}
	

	
	public static void deleteBusinessByID(int id) throws SQLException, Exception{
		 String sql = "delete from business where id_business=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, id);
		 ps.executeUpdate();
		 
	}
	 
	 
	public static Business getBusinessByID(int busID)throws Exception{
		 String sql = "select * from business where id_business=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, busID);
		 ResultSet rs = ps.executeQuery();
		 Business bus = null;
		 if(rs.next()){
			 int idbus = rs.getInt("id_business");
			 String busname = rs.getString("business_name");	
			
			 bus = new Business(idbus, busname);
		 }
		 return bus;
	}
	public static void updateBusiness(int bus, String buss) throws SQLException, Exception{
		 String sql = "update business set id_business=?, business_name=N? where id_business=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, bus);
		 ps.setString(2, buss);
		 ps.setInt(3,bus);
		 ps.executeUpdate();
	}
	 public static void main(String agrs[]) throws Exception
	 {
		 
		 //insertBusiness("huhu");
		 //updateBusiness(2,"hihi");
		 deleteBusinessByID(2);
		 Business bus =  getBusinessByID(1);
		 System.out.println(bus.getId_business());
		 System.out.println(bus.getBusiness_name());
		 List<Business> list = null;
			
			try {
				list = Business.getAllBusiness();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for(Business bu:list)
		{
			System.out.println(bu.getId_business());
			System.out.println(bu.getBusiness_name());
		}
	 
}
}
