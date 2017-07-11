package com.fairmusic.follow.dao;

import java.util.ArrayList;

import static com.fairmusic.fw.Follow_Query.*;
import static com.fairmusic.fw.DBUtil.*;

import java.sql.*;

import com.fairmusic.dto.followDTO;

public class FollowDAOImpl implements FollowDAO {

	@Override
	public followDTO FOLLOW_CHECK(String me, String follower) {
		Connection con = null;
		PreparedStatement ptmt = null;
		followDTO dto = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			ptmt = con.prepareStatement(FOLLOW_CHECK);
			ptmt.setString(1, me);
			ptmt.setString(2, follower);
			rs = ptmt.executeQuery();
			if (rs.next()) {
				dto = new followDTO(rs.getString(1), rs.getString(2), rs.getString(3));
			}
			System.out.println("FOLLOW_CHECK(DAO) : "+dto);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ptmt, con);
		}
		return dto;
	}

	@Override
	public int FOLLOW_INSERT(String me, String follower) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result= 0;
		try {
			con = getConnection();
			ptmt = con.prepareStatement(FOLLOW_INSERT);
			ptmt.setString(1, me);
			ptmt.setString(2, follower);
			result = ptmt.executeUpdate();
			System.out.println(result+"�� �� ���� ���� (FOLLOW_INSERT)");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(null, ptmt, con);
		}
		return result;
		
	}

	@Override
	public int FOLLOW_UNFOLLOW(String me, String follower) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result= 0;
		try {
			con = getConnection();
			ptmt = con.prepareStatement(FOLLOW_UNFOLLOW);
			ptmt.setString(1, me);
			ptmt.setString(2, follower);
			result = ptmt.executeUpdate();
			System.out.println(result+"�� �� ���� ���� (FOLLOW_UNFOLLOW)");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(null, ptmt, con);
		}
		return result;
		
	}

	@Override
	public int FOLLOW_REFOLLOW(String me, String follower) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result= 0;
		try {
			con = getConnection();
			ptmt = con.prepareStatement(FOLLOW_REFOLLOW);
			ptmt.setString(1, me);
			ptmt.setString(2, follower);
			result = ptmt.executeUpdate();
			System.out.println(result+"�� �� ���� ���� (FOLLOW_REFOLLOW)");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(null, ptmt, con);
		}
		return result;
		
	}

	@Override
	public ArrayList<followDTO> FOLLOW_SEARCH_FOLLOWING(String me) {
		ArrayList<followDTO> list = new ArrayList<followDTO>();
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		followDTO dto = null;
		try {
			con = getConnection();
			ptmt = con.prepareStatement(FOLLOW_SEARCH_FOLLOWING);
			ptmt.setString(1, me);
			rs = ptmt.executeQuery();
			while (rs.next()) {

				dto = new followDTO(rs.getString(1), rs.getString(2),
						rs.getString(3));
				list.add(dto);
			}
			System.out.println("FOLLOW_SEARCH_FOLLOWING : " + list.size()+"�� �� ��ȸ ����");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ptmt, con);
		}
		return list;
	}

	@Override
	public ArrayList<followDTO> FOLLOW_SEARCH_FOLLOWER(String follower) {
		ArrayList<followDTO> list = new ArrayList<followDTO>();
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		followDTO dto = null;
		try {
			con = getConnection();
			ptmt = con.prepareStatement(FOLLOW_SEARCH_FOLLOWER);
			ptmt.setString(1, follower);
			rs = ptmt.executeQuery();
			while (rs.next()) {

				dto = new followDTO(rs.getString(1), rs.getString(2),
						rs.getString(3));
				list.add(dto);
			}
			System.out.println("FOLLOW_SEARCH_FOLLOWER : " + list.size()+"�� �� ��ȸ ����");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ptmt, con);
		}
		return list;
	}

}