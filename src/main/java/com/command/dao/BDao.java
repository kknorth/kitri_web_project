package com.command.dao;

import static com.fairmusic.fw.DBUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.command.dto.BDto;

public class BDao {

	public void write(String bName, String bTitle, String bContent) {
		
		Connection con = null;
		PreparedStatement ptmt = null;
		
		
		try {
			con = getConnection();
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";
			ptmt = con.prepareStatement(query);
			ptmt.setString(1, bName);
			ptmt.setString(2, bTitle);
			ptmt.setString(3, bContent);
			int result = ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ptmt != null) ptmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public ArrayList<BDto> list() {
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		
		
		try {
			con = getConnection();
			String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
			ptmt = con.prepareStatement(query);
			rs = ptmt.executeQuery();
			
			while (rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ptmt != null) ptmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public BDto contentView(String strID) {
		upHit(strID);
		BDto dto = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		
		try {	
			con = getConnection();
			String query = "select * from mvc_board where bId = ?";
			ptmt = con.prepareStatement(query);
			ptmt.setInt(1, Integer.parseInt(strID));
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ptmt != null) ptmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public void modify(String bId, String bName, String bTitle, String bContent) {
		
		Connection con = null;
		PreparedStatement ptmt = null;
		
		try {
			con = getConnection();
		
			String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
			
			
			ptmt = con.prepareStatement(query);
			ptmt.setString(1, bName);
			ptmt.setString(2, bTitle);
			ptmt.setString(3, bContent);
			ptmt.setInt(4, Integer.parseInt(bId));
			int rn = ptmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ptmt != null) ptmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void delete(String bId) {
		Connection con = null;
		PreparedStatement ptmt = null;
		try {
			
			con = getConnection();
			String query = "delete from mvc_board where bId = ?";
			
			ptmt = con.prepareStatement(query);
			ptmt.setInt(1, Integer.parseInt(bId));
			int rn = ptmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ptmt != null) ptmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public BDto reply_view(String str) {
		BDto dto = null;
		
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			
			con = getConnection();
			String query = "select * from mvc_board where bId = ?";
			
			ptmt = con.prepareStatement(query);
			ptmt.setInt(1, Integer.parseInt(str));
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ptmt != null) ptmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dto;
	}
	
	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent) {
		replyShape(bGroup, bStep);
		Connection con = null;
		PreparedStatement ptmt = null;
		
		try {
			con = getConnection();
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
			
	
			ptmt = con.prepareStatement(query);
			ptmt.setString(1, bName);
			ptmt.setString(2, bTitle);
			ptmt.setString(3, bContent);
			ptmt.setInt(4, Integer.parseInt(bGroup));
			ptmt.setInt(5, Integer.parseInt(bStep) + 1);
			ptmt.setInt(6, Integer.parseInt(bIndent) + 1);
			
			int rn = ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ptmt != null) ptmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	private void replyShape( String strGroup, String strStep) {
		Connection con = null;
		PreparedStatement ptmt = null;
		
		try {
			con = getConnection();
			String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
		
			ptmt = con.prepareStatement(query);
			ptmt.setInt(1, Integer.parseInt(strGroup));
			ptmt.setInt(2, Integer.parseInt(strStep));
			
			int result = ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ptmt != null) ptmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	private void upHit( String bId) {
		Connection con = null;
		PreparedStatement ptmt = null;
		
		try {
			con = getConnection();
			String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
			ptmt = con.prepareStatement(query);
			ptmt.setString(1, bId);
			int rn = ptmt.executeUpdate();
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(ptmt != null) ptmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
		}
	}
}
