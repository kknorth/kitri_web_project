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
			ptmt.setString(2, bitcoinAdress.getBitcoinAdress1());
			ptmt.setString(3, bitcoinAdress.getPrivatekey1());
			ptmt.setString(4, bitcoinAdress.getBitcoinAdress2());
			ptmt.setString(5, bitcoinAdress.getPrivatekey2());
			ptmt.setString(6, bitcoinAdress.getBitcoinAdress3());
			ptmt.setString(7, bitcoinAdress.getPrivatekey3());
			ptmt.setString(8, bitcoinAdress.getRighterName1());
			ptmt.setLong(9, bitcoinAdress.getRighterVal1());
			ptmt.setString(10, bitcoinAdress.getRighterName2());
			ptmt.setLong(11, bitcoinAdress.getRighterVal2());
			ptmt.setString(12, bitcoinAdress.getRighterName3());
			ptmt.setLong(13, bitcoinAdress.getRighterVal3());
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
				bitaddr =new BitcoinAdressDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getLong(9),rs.getString(10),
						rs.getLong(11),rs.getString(12),rs.getLong(13));
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
