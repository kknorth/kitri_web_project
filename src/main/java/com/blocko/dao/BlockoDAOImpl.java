package com.blocko.dao;


import static com.fairmusic.fw.BlockoQuery.*;
import static com.fairmusic.fw.DBUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.blocko.dto.MusicStampDTO;

public class BlockoDAOImpl implements BlockoDAO {

	@Override
	public int insert(MusicStampDTO stamp) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result= 0;
		try {
			con = getConnection();
			ptmt = con.prepareStatement(STAMP_INSERT);
			ptmt.setString(1, stamp.getUser());
			ptmt.setString(2, stamp.getMusic());
			ptmt.setString(3, stamp.getTimestamp());
			ptmt.setString(4, stamp.getMusicHash());
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(null, ptmt, con);
		}
		return result;
	}

}
