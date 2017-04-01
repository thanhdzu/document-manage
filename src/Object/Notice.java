package Object;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.ConnectDB;

public class Notice {
	private int id_notice;
	private String notice_info;
	private boolean status;
	
	public int getId_notice() {
		return id_notice;
	}

	public void setId_notice(int id_notice) {
		this.id_notice = id_notice;
	}

	public String getNotice_info() {
		return notice_info;
	}

	public void setNotice_info(String notice_info) {
		this.notice_info = notice_info;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Notice() {
		super();
	}

	public Notice(int id_notice, String notice_info, boolean status) {
		super();
		this.id_notice = id_notice;
		this.notice_info = notice_info;
		this.status = status;
	}
	
	public static ArrayList<Notice> getAllNotice() throws Exception{
		 ArrayList<Notice> lst = new ArrayList<Notice>();
		 String strSQL = "select id_notice, notice_info, status from notice";
		 ConnectDB conn = new ConnectDB();
		 try 
		 {
			 ResultSet rs = conn.getStatement().executeQuery(strSQL);
			 while(rs.next()){
				 int nID = rs.getInt("id_notice");
				 String nInfo = rs.getString("notice_info");
				 boolean stat = rs.getBoolean("status");
				
				 Notice notice = new Notice(nID, nInfo, stat);
				 lst.add(notice);
			 }
		 } catch (Exception e) 
		 {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		 }
		 conn.closeConnet();
		 return lst;
	}
	
	public static void insertNotice(String str) throws Exception
	{
		
		ConnectDB con = new ConnectDB();
		String query="insert into notice(notice_info,status) values(N?,1)";
	
		PreparedStatement ps=con.openConnect().prepareStatement(query);  // generates sql query
		ps.setString(1, str);
		
		ps.executeUpdate(); // execute it on test database
		System.out.println("successfuly inserted");
		ps.close();
		con.closeConnet();

	}
	

	
	public static void deleteNoticeByID(int id) throws SQLException, Exception{
		 String sql = "delete from notice where id_notice=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, id);
		 ps.executeUpdate();
		 
	}
	 
	 
	public static Notice getNoticeByID(int teaID)throws Exception{
		 String sql = "select * from notice where id_notice=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, teaID);
		 ResultSet rs = ps.executeQuery();
		 Notice notice = null;
		 if(rs.next()){
			 int idnotice = rs.getInt("id_notice");
			 String info = rs.getString("notice_info");	
			 boolean stat = rs.getBoolean("status");
			 notice = new Notice(idnotice, info, stat); 
		 }
		 return notice;
	}
	public static void updateNotice(int tea, String info, boolean stat) throws SQLException, Exception{
		 String sql = "update notice set notice_info=N? where id_notice=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setString(1, info);
		
		 ps.setInt(2,tea);
		 ps.executeUpdate();
	}
	public static void updateNoticeStatus(int id, boolean stat) throws SQLException, Exception{
		 String sql = "update notice set status=? where id_notice=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setBoolean(1, stat);
		 ps.setInt(2, id);
		
		 ps.executeUpdate();
	}
	 public static void main(String agrs[]) throws Exception
	 {
		 
		 //insertNotice("văn");
		 //updateNotice(1, "văn a", false);
		 //deleteNoticeByID(2);
		 Notice tea =  getNoticeByID(1);
		 System.out.println(tea.getId_notice());
		 System.out.println(tea.getNotice_info());
		 System.out.println(tea.isStatus());
		 List<Notice> list = null;
			
			try {
				list = Notice.getAllNotice();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for(Notice te:list)
		{
			System.out.println(te.getId_notice());
			System.out.println(te.getNotice_info());
		}
	 
}
}
