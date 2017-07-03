package com.fairmusic.artist.dao;

import static com.fairmusic.fw.DBUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fairmusic.dto.artistDTO;
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
	

}
