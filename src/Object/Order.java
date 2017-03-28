package Object;

//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Model.ConnectDB;

public class Order {
	private int id_order;
	private int id_account;
	private int id_document;
	private String create_time;
	private String receive_time;
	private int status;
	public Order() {
		super();
	}
	public Order(int id_order, int id_account, int id_document, String create_time, String receive_time, int status) {
		super();
		this.id_order = id_order;
		this.id_account = id_account;
		this.id_document = id_document;
		this.create_time = create_time;
		this.receive_time = receive_time;
		this.status = status;
	}
	public int getId_order() {
		return id_order;
	}
	public void setId_order(int id_order) {
		this.id_order = id_order;
	}
	public int getId_account() {
		return id_account;
	}
	public void setId_account(int id_account) {
		this.id_account = id_account;
	}
	public int getId_document() {
		return id_document;
	}
	public void setId_document(int id_document) {
		this.id_document = id_document;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getReceive_time() {
		return receive_time;
	}
	public void setReceive_time(String receive_time) {
		this.receive_time = receive_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	public static ArrayList<Order> getAllOrder() throws Exception{
		 ArrayList<Order> lst = new ArrayList<Order>();
		 String strSQL = "select * from orders";
		 ConnectDB conn = new ConnectDB();
		 try 
		 {
			 ResultSet rs = conn.getStatement().executeQuery(strSQL);
			 while(rs.next()){
				 int ordID = rs.getInt("id_order");
				
				 int accID = rs.getInt("id_account");
				 int docID = rs.getInt("id_document");
				 String create = rs.getString("create_time");
				 String recieve = rs.getString("receive_time");
			
				 int stat = rs.getInt("status");
				 Order ord = new Order(ordID, accID, docID, create, recieve, stat);
				 
				 lst.add(ord);
			 }
		 } catch (Exception e) 
		 {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		 }
		 conn.closeConnet();
		 return lst;
	}
	
	public static void insertOrder(String[] arr, int acc, String recieve, String create) throws Exception
	{
		
		ConnectDB con = new ConnectDB();
		for(String s : arr)
		{
		String query="insert into orders(id_account,id_document,create_time,receive_time,status) values(?,?,?,?,2)";
				
				
	
		PreparedStatement ps=con.openConnect().prepareStatement(query);  // generates sql query
		ps.setInt(1, acc);
		ps.setInt(2, Integer.parseInt(s));
		ps.setString(3, create);
		ps.setString(4, recieve);
		//ps.setInt(5, Integer.parseInt(s));
		ps.executeUpdate(); // execute it on test database
		System.out.println("successfuly inserted");
		
		
		
		}
		//ps.close();
		con.closeConnet();

	}
	
	public static void updateOrderStatus(String[] arr,int stat) throws Exception
	{
		
		ConnectDB con = new ConnectDB();
		for(String s : arr)
		{
		String query="update documents set  status=? where id_document=?";
				
		PreparedStatement ps=con.openConnect().prepareStatement(query);  // generates sql query
		ps.setInt(1, stat);
		ps.setInt(2, Integer.parseInt(s));
	
		ps.executeUpdate(); // execute it on test database
		System.out.println("update inserted");
		
		
		
		}
		//ps.close();
		con.closeConnet();

	}
	
	public static void updateStatus(int idord,int stat) throws Exception
	{
		
		ConnectDB con = new ConnectDB();
	
		String query="update orders set  status=? where id_order=?";
				
		PreparedStatement ps=con.openConnect().prepareStatement(query);  // generates sql query
		ps.setInt(1, stat);
		ps.setInt(2, idord);
	
		ps.executeUpdate(); // execute it on test database
		System.out.println("update inserted");
		
		//ps.close();
		con.closeConnet();

	}
	
	public static int idDoc(int idord) throws Exception
	{	int id = 0;
		 String sql = "select o.id_document from orders o where id_order=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, idord);
		 ResultSet rs = ps.executeQuery();
		 if(rs.next()){
			 id = rs.getInt("o.id_document");
		 }
		 return id;
	}
	
	public static void deleteDocumentByID(int id) throws SQLException, Exception{
		 String sql = "delete from documents where id_document=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 
		 ps.setInt(1, id);
		 ps.executeUpdate();
		 
	}
	 
	 
	public static Document getDocumentByID(int docID)throws Exception{
		 String sql = "select * from documents where id_document=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, docID);
		 ResultSet rs = ps.executeQuery();
		 Document doc = null;
		 if(rs.next()){
			 int id_document = rs.getInt("id_document");
			 String document_name = rs.getString("document_name");	
			 int idcate = rs.getInt("idcate");
			 int id_teacher = rs.getInt("id_teacher");
			 float point = rs.getFloat("point");
			 String student = rs.getString("student");
			 int id_business = rs.getInt("id_business");
			 int id_class = rs.getInt("id_class");
			 int status = rs.getInt("status");
			 doc = new Document(id_document, document_name, idcate, id_teacher, point, student, id_business, id_class, status);
		 }
		 return doc;
	}
	

	
	public static void updateDocument(Document doc) throws SQLException, Exception{
		 String sql = "update documents set  document_name=?, idcate=?,id_teacher=?,point=?,student=?,id_business=?, id_class=?, status=? where id_document=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 	ps.setString(1, doc.getDocument_name());
			ps.setInt(2, doc.getIdcate());
			ps.setInt(3, doc.getId_teacher());
			ps.setFloat(4, doc.getPoint());
			ps.setString(5, doc.getStudent());
			ps.setInt(6, doc.getId_business());
			ps.setInt(7, doc.getId_class());
			ps.setInt(8, doc.getStatus());
			ps.setInt(9, doc.getId_document());
			ps.executeUpdate(); // execute it on test database
			System.out.println("successfuly updated");
		 
	}
	
	public static ArrayList<Document> getOrderDocument(String[] arr) throws Exception{
		 ArrayList<Document> lst = new ArrayList<Document>();
		 for(String s: arr)
		 {
		 String strSQL = "select * from documents where id_document="+s;
		 ConnectDB conn = new ConnectDB();
		 try 
		 {
			 ResultSet rs = conn.getStatement().executeQuery(strSQL);
			 while(rs.next()){
				 int dID = rs.getInt("id_document");
				 String dName = rs.getString("document_name");
				 int cID = rs.getInt("idcate");
				 int tID = rs.getInt("id_teacher");
				 String stud = rs.getString("student");
				 float point = rs.getFloat("point");
				 int bID = rs.getInt("id_business");
				 int clID = rs.getInt("id_class");
				 int stat = rs.getInt("status");
				 Document doc = new Document(dID, dName, cID, tID, point, stud, bID, clID, stat);
				 
				 lst.add(doc);
			 }
		 } catch (Exception e) 
		 {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		 }
		 
		 //conn.closeConnet();
		 }
		 return lst;
	}
	
	public static void main(String agrs[]) throws SQLException, Exception
	 {
		 //Document doc = new Document(1, "Test", 1,1,(float) 7.1,"hihi",3,1,0);
		 //insertDocument(doc);
		 //Document doc = new Document(2, "Test 2", 1,1,(float) 7.1,"keke",3,1,0);
		 //updateDocument(doc);
		//deleteDocumentByID(3);
		 //Document doc =  getDocumentByID(2);
		// System.out.println(doc.getId_document());
		 //System.out.println(doc.getDocument_name());
		/*	String[] arr = {"4","5","6"};
		 //ArrayList<Document> doc =  getOrderDocument(arr);
		 //List<Document> list = null;
			
			try {
				list = Document.getAllDocument();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for(Document doc1 :doc)
		{
			System.out.println(doc1.getId_document());
			System.out.println(doc1.getDocument_name());
			System.out.println(doc1.getStudent());
		}*/
		Date dNow = new Date();
	      SimpleDateFormat ft = 
	      new SimpleDateFormat ("yyyy-MM-dd  hh:mm:ss");
	      String[] arr = {"4","5","6"};
	    
		String creDate =ft.format(dNow);
		System.out.print(creDate);
		insertOrder(arr, 1, ft.format(dNow), ft.format(dNow));
		System.out.println("stat: "+ idDoc(2));
	 } 
	
	
}
