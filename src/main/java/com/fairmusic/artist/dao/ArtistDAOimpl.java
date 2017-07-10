package com.fairmusic.artist.dao;

import static com.fairmusic.fw.DBUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fairmusic.dto.artistDTO;
import com.fairmusic.fw.DBUtil;

import static com.fairmusic.fw.Query.*;
public class ArtistDAOimpl implements ArtistDAO{



	@Override
	public int regist(artistDTO artist) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result= 0;
		try {
			con = getConnection();
			ptmt = con.prepareStatement("insert into fm_artist values(?,?,?,?,?,?,?,?,?,?)");
			ptmt.setString(1, artist.getArtist_code());
			ptmt.setString(2, artist.getArtist_id());
			ptmt.setString(3, artist.getArtist_pass());
			ptmt.setString(4, artist.getArtist_grade());
			ptmt.setString(5, artist.getArtist_balance());
			ptmt.setString(6, artist.getArtist_email());
			ptmt.setString(7, artist.getArtist_image());
			ptmt.setString(8, artist.getArtist_bit_address());
			ptmt.setString(9, artist.getArtist_self_introduction());
			ptmt.setString(10, artist.getArtist_alive());
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(null, ptmt, con);
		}
		return result;
	}
	
	@Override
	public boolean emailCheck(String email) {
		System.out.println("여기 디에이오"+email);
		Connection con = null;
		PreparedStatement ptmt = null;

		ResultSet rs = null;
		boolean result = false;
		try {
			con = DBUtil.getConnection();
			ptmt = con.prepareStatement(EMAIL_CHECK);
			ptmt.setString(1, email);

			rs = ptmt.executeQuery();
			if (rs.next()) {
				result = true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		System.out.println(result);
		return result;
	}

	@Override
	public artistDTO login(String email, String pass) {
		Connection con = null;
		PreparedStatement ptmt = null;
		artistDTO dto = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			ptmt = con.prepareStatement(EMP_login);
			ptmt.setString(1, email);
			ptmt.setString(2, pass);
			rs = ptmt.executeQuery();
			if (rs.next()) {
				dto = new artistDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return dto;
	}

	@Override
	public int pass_update(String email, String newPass) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result= 0;
		try {
			con = getConnection();
			ptmt = con.prepareStatement(Pass_update);
			ptmt.setString(1, newPass);
			ptmt.setString(2, email);
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(null, ptmt, con);
		}
		return result;
	}

	@Override
	public artistDTO getArtistDTO(String artist_code) {
		Connection con = null;
		PreparedStatement ptmt = null;
		artistDTO dto = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			ptmt = con.prepareStatement(Select_Artist);
			ptmt.setString(1, artist_code);
			rs = ptmt.executeQuery();
			if (rs.next()) {
				dto = new artistDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return dto;
	}	
	
}
