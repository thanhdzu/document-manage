package Object;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.ConnectDB;

public class Document {
	private int id_document;
	private String document_name;
	private int idcate;
	private int id_teacher;
	private float point;
	private String student;
	private int id_business;
	private int id_class;
	private int status;
	public Document() {
		super();
	}
	
	public Document(int id_document, String document_name, int idcate, int id_teacher, float point, String student,
			int id_business, int id_class, int status) {
		super();
		this.id_document = id_document;
		this.document_name = document_name;
		this.idcate = idcate;
		this.id_teacher = id_teacher;
		this.point = point;
		this.student = student;
		this.id_business = id_business;
		this.id_class = id_class;
		this.status = status;
	}

	public int getId_document() {
		return id_document;
	}
	public void setId_document(int id_document) {
		this.id_document = id_document;
	}
	
	public String getDocument_name() {
		return document_name;
	}
	public void setDocument_name(String document_name) {
		this.document_name = document_name;
	}
	public int getIdcate() {
		return idcate;
	}
	public void setIdcate(int idcate) {
		this.idcate = idcate;
	}
	public int getId_teacher() {
		return id_teacher;
	}
	public void setId_teacher(int id_teacher) {
		this.id_teacher = id_teacher;
	}
	public float getPoint() {
		return point;
	}
	public void setPoint(float point) {
		this.point = point;
	}
	
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public int getId_business() {
		return id_business;
	}
	public void setId_business(int id_business) {
		this.id_business = id_business;
	}
	public int getId_class() {
		return id_class;
	}
	public void setId_class(int id_class) {
		this.id_class = id_class;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	public static ArrayList<Document> getAllDocument() throws Exception{
		 ArrayList<Document> lst = new ArrayList<Document>();
		 String strSQL = "select * from documents";
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
		 conn.closeConnet();
		 return lst;
	}
	
	public static void insertDocument(Document doc) throws Exception
	{
		
		ConnectDB con = new ConnectDB();
		String query="insert into documents(document_name,idcate,id_teacher,point,student,id_business,id_class,status) values(?,?,?,?,?,?,?,?)";
	
		PreparedStatement ps=con.openConnect().prepareStatement(query);  // generates sql query
		//ps.setInt(1, doc.getId_document());
		ps.setString(1, doc.getDocument_name());
		ps.setInt(2, doc.getIdcate());
		ps.setInt(3, doc.getId_teacher());
		ps.setFloat(4, doc.getPoint());
		ps.setString(5, doc.getStudent());
		ps.setInt(6, doc.getId_business());
		ps.setInt(7, doc.getId_class());
		ps.setInt(8, doc.getStatus());
		ps.executeUpdate(); // execute it on test database
		System.out.println("successfuly inserted");
		ps.close();
		con.closeConnet();

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
	

	
	public static void main(String agrs[]) throws SQLException, Exception
	 {
		 //Document doc = new Document(1, "Test", 1,1,(float) 7.1,"hihi",3,1,0);
		 //insertDocument(doc);
		 //Document doc = new Document(2, "Test 2", 1,1,(float) 7.1,"keke",3,1,0);
		 //updateDocument(doc);
		//deleteDocumentByID(3);
		 Document doc =  getDocumentByID(2);
		 System.out.println(doc.getId_document());
		 System.out.println(doc.getDocument_name());
		
		 List<Document> list = null;
			
			try {
				list = Document.getAllDocument();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for(Document doc1 :list)
		{
			System.out.println(doc1.getId_document());
			System.out.println(doc1.getDocument_name());
			System.out.println(doc1.getStudent());
		}
	 }
	
}
