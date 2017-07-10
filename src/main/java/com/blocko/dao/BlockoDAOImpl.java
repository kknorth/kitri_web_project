package com.blocko.dao;


import static com.fairmusic.fw.BlockoQuery.*;
import static com.fairmusic.fw.DBUtil.close;
import static com.fairmusic.fw.DBUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.blocko.dto.BitcoinAdressDTO;
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
			ptmt.setString(1, stamp.getId());
			ptmt.setString(2, stamp.getMusicName());
			ptmt.setString(3, stamp.getMusicHash());
			ptmt.setString(4, stamp.getStampId());
			//ptmt.setString(5, stamp.getTxId());
			//ptmt.setString(6, stamp.getTimestamp());
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(null, ptmt, con);
		}
		return result;
	}

	@Override
	public int bitcoinAdressInsert(BitcoinAdressDTO bitcoinAdress) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result= 0;
		try {
			con = getConnection();
			ptmt = con.prepareStatement(BITCOINADDR_INSERT);
			ptmt.setString(1, bitcoinAdress.getId());
			ptmt.setString(2, bitcoinAdress.getBitcoinAdress());
			ptmt.setString(3, bitcoinAdress.getPrivatekey());
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(null, ptmt, con);
		}
		return result;
	}

	@Override
	public ArrayList<BitcoinAdressDTO> bitcoinAdressSelect(String id) {
		ArrayList<BitcoinAdressDTO> bitcoinaddr = new ArrayList<BitcoinAdressDTO>();
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		BitcoinAdressDTO bitaddr = null;
		try {
			con = getConnection();
			ptmt = con.prepareStatement(BITCOINADDR_SELECT);
			ptmt.setString(1,id);
			rs = ptmt.executeQuery();
			while(rs.next()){
				bitaddr =new BitcoinAdressDTO(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4),rs.getInt(5));
				bitcoinaddr.add(bitaddr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs, ptmt, con);
		}
		return bitcoinaddr;
		}

	@Override
	public MusicStampDTO StampSelect(String id, String MusicName) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		MusicStampDTO Stamp = null;
		try {
			con = getConnection();
			ptmt = con.prepareStatement(STAMP_SELECT);
			ptmt.setString(1,id);
			ptmt.setString(2,MusicName);
			rs = ptmt.executeQuery();
			if(rs.next()){
				Stamp =new MusicStampDTO(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs, ptmt, con);
		}
		return Stamp;
		}
}
