package com.blocko.dao;
import java.util.ArrayList;

import com.blocko.dto.BitcoinAdressDTO;
import com.blocko.dto.MusicStampDTO;
public interface BlockoDAO {
	int insert(MusicStampDTO stamp);
	int bitcoinAdressInsert(BitcoinAdressDTO bitcoinAdress);
	ArrayList<BitcoinAdressDTO> bitcoinAdressSelect(String id);
	MusicStampDTO StampSelect(String id, String MusicHash);	
}










