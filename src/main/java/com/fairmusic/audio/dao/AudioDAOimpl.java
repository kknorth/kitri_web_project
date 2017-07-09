package com.fairmusic.audio.dao;

import static com.fairmusic.fw.AudioQuery.audioinsert;
import static com.fairmusic.fw.DBUtil.close;
import static com.fairmusic.fw.DBUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fairmusic.dto.audioDTO;

public class AudioDAOimpl implements AudioDAO{

	@Override
	public int createAudio(audioDTO audio) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result= 0;
		try {	
			con = getConnection();
			ptmt = con.prepareStatement(audioinsert);
			ptmt.setString(1, audio.getAudio_code());
			ptmt.setString(2, audio.getAudio_file());
			ptmt.setString(3, audio.getAudio_image());
			ptmt.setString(4, audio.getAudio_movie());
			ptmt.setString(5, audio.getAudio_title());
			ptmt.setString(6, audio.getArtist_code());
			ptmt.setString(7, audio.getAudio_jenre());
			ptmt.setString(8, audio.getAudio_detail());
			ptmt.setString(9, audio.getAlbum_code());
			ptmt.setString(10, audio.getAudio_copyrighter());
			ptmt.setString(11, audio.getAudio_price());
			ptmt.setString(12, audio.getAudio_alive());
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(null, ptmt, con);
		}
		return result;
	}

}
