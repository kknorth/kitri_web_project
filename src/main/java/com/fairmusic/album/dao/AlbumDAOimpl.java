package com.fairmusic.album.dao;

import static com.fairmusic.fw.AlbumQuery.*;
import static com.fairmusic.fw.DBUtil.close;
import static com.fairmusic.fw.DBUtil.getConnection;
import static com.fairmusic.fw.DBUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fairmusic.dto.albumDTO;

public class AlbumDAOimpl implements AlbumDAO{

	@Override
	public int createAlbum(albumDTO album) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result= 0;
		try {

			con = getConnection();
			ptmt = con.prepareStatement(albuminsert);
			ptmt.setString(1, album.getAlbum_code());
			ptmt.setString(2, album.getAlbum_title());
			ptmt.setString(3, album.getArtist_code());
			ptmt.setString(4, album.getAlbum_image());
			ptmt.setString(5, album.getAlbum_date());
			ptmt.setString(6, album.getAlbum_dc());

			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(null, ptmt, con);
		}
		return result;
	}

}
