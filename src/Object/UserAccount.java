package Object;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.ConnectDB;

public class UserAccount {
	private int id_account;
	private String username;
	private String password;
	private String fullname;
	private String email;
	private String phone;
	private boolean level;
	
	public boolean isLevel() {
		return level;
	}
	public void setLevel(boolean level) {
		this.level = level;
	}
	public int getId_account() {
		return id_account;
	}
	public void setId_account(int id_account) {
		this.id_account = id_account;
	}
	public UserAccount() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public UserAccount(int id_account, String username, boolean level) {
		super();
		this.id_account = id_account;
		this.username = username;
		this.level = level;
	}
	
	
	public UserAccount(String username, String password, String fullname, String email, 
			String phone, boolean level) {
		super();
		
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
	
		this.phone = phone;
		this.level = level;
	}
	
	public UserAccount(String username, String password, String fullname, String email, 
			String phone, boolean level, int id_account) {
		super();
		
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
	
		this.phone = phone;
		this.level = level;
		this.id_account = id_account;
	}
	
	
	public UserAccount(int id_account, String username, String password, String fullname, String email, String phone,
			boolean level) {
		super();
		this.id_account = id_account;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.level = level;
	}
	public UserAccount(int id_account, String username, String fullname, String email, String phone) {
		super();
		this.id_account = id_account;
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
	
	}
	
	

	public UserAccount(int id_account, String username, String fullname, String email, String phone, boolean level) {
		super();
		this.id_account = id_account;
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.level = level;
	}

	public static ArrayList<UserAccount> getAllUser() throws Exception{
		 ArrayList<UserAccount> lst = new ArrayList<UserAccount>();
		 String strSQL = "select u.id_account,u.username, u.level from user u";
		 ConnectDB conn = new ConnectDB();
		 try 
		 {
			 ResultSet rs = conn.getStatement().executeQuery(strSQL);
			 while(rs.next()){
				 int uID = rs.getInt("u.id_account");
				 String uName = rs.getString("u.username");
				 boolean ulevel = rs.getBoolean("level");
				
				 UserAccount use = new UserAccount(uID, uName,ulevel);
				 lst.add(use);
			 }
		 } catch (Exception e) 
		 {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		 }
		 conn.closeConnet();
		 return lst;
	}
	
	public static void insertAccount(UserAccount user) throws Exception
	{
		
		ConnectDB con = new ConnectDB();
		String query="insert into user(username, password,fullname,email,phone,level) values(?,?,N?,?,?,?)";
	
		PreparedStatement ps=con.openConnect().prepareStatement(query);  // generates sql query
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getFullname());
		ps.setString(4, user.getEmail());
		ps.setString(5, user.getPhone());
		ps.setBoolean(6, user.isLevel());
		ps.executeUpdate(); // execute it on test database
		System.out.println("successfuly inserted");
		ps.close();
		con.closeConnet();

	}
	

	
	public static void deleteAccountByID(int id) throws SQLException, Exception{
		 String sql = "delete from user where id_account=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, id);
		 ps.executeUpdate();
		 
	}
	 
	 
	public static UserAccount getAccountByID(int acID)throws Exception{
		 String sql = "select * from user where id_account=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, acID);
		 ResultSet rs = ps.executeQuery();
		 UserAccount user = null;
		 if(rs.next()){
			 int id_account = rs.getInt("id_account");
			 String username = rs.getString("username");	
			 String password = rs.getString("password");
			 String fullname = rs.getString("fullname");
			 String email = rs.getString("email");
			 String phone = rs.getString("phone");
			 boolean level = rs.getBoolean("level");
			 user = new UserAccount(id_account, username, password,  fullname,  email,  phone,
						 level);
		 }
		 return user;
	}
	
	public static UserAccount getUserByID(int acID)throws Exception{
		 String sql = "select * from user where id_account=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, acID);
		 ResultSet rs = ps.executeQuery();
		 UserAccount user = null;
		 if(rs.next()){
			 int id_account = rs.getInt("id_account");
			 String username = rs.getString("username");	
			 String fullname = rs.getString("fullname");
			 String email = rs.getString("email");
			 String phone = rs.getString("phone");
			 user = new UserAccount(id_account, username, fullname,  email,  phone);
		 }
		 return user;
	}
	
	public static UserAccount getUserLogin(String uname, String pass)throws Exception{
		 String sql = "select * from user where username=? and password=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setString(1, uname);
		 ps.setString(2, pass);
		 ResultSet rs = ps.executeQuery();
		 UserAccount user = null;
		 if(rs.next()){
			 int id_account = rs.getInt("id_account");
			 String username = rs.getString("username");
			 String password = rs.getString("password");
			 String fullname = rs.getString("fullname");
			 String email = rs.getString("email");
			 String phone = rs.getString("phone");
			 boolean level = rs.getBoolean("level");
			 user = new UserAccount(id_account, username, password, fullname, email, phone, level);
		 }
		 return user;
	}
	
	public static void updatePassword(int id_acc, String pass) throws SQLException, Exception
	{
		String sql = "update user set password=? where id_account=?";
		ConnectDB conn = new ConnectDB();
		PreparedStatement ps= conn.openConnect().prepareStatement(sql);
		ps.setString(1, pass);
		ps.setInt(2, id_acc);
		ps.executeUpdate();
		System.out.print("successfuly updated password");
	}
	
	public static void updateAccount(UserAccount user) throws SQLException, Exception{
		 String sql = "update user set  username=?, password=?,fullname=?,email=?,phone=?,level=? where id_account=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			ps.setBoolean(6, user.isLevel());
			ps.setInt(7, user.getId_account());
			ps.executeUpdate(); // execute it on test database
			System.out.println("successfuly updated");
		 
	}
	
	public static void updateAccountNoPSW(UserAccount user) throws SQLException, Exception{
		 String sql = "update user set  fullname=?,email=?,phone=?,level=? where id_account=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 	//ps.setString(1, user.getUsername());
			ps.setString(1, user.getFullname());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setBoolean(4, user.isLevel());
			ps.setInt(5, user.getId_account());
			ps.executeUpdate(); // execute it on test database
			System.out.println("successfuly updated");
		 
	}
	
	public static void main(String agrs[]) throws SQLException, Exception
	 {
		 //UserAccount user = new UserAccount("tutu", "123456", "van a", "avd@mail.com", "123456789", false);
		 //insertAccount(user);
		 //UserAccount user = new UserAccount("tet", "000", "van a", "avd@mail.com", "123", false, 3);
		 //updateAccountNoPSW(user);
		//deleteAccountByID(3);
		 //UserAccount user =  getAccountByID(2);
		 //System.out.println(user.getId_account());
		 //System.out.println(user.getUsername());
		//updatePassword(3, "5555");
		 List<UserAccount> list = null;
			
			try {
				list = UserAccount.getAllUser();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for(UserAccount use:list)
		{
			System.out.println(use.getId_account());
			System.out.println(use.getUsername());
			System.out.println(use.isLevel());
		}
	 }
}
