package com.blocko.service;

import java.util.ArrayList;

import com.blocko.dto.BitcoinAdressDTO;
import com.blocko.dto.MusicStampDTO;

public interface BlockoService {
	int insert(MusicStampDTO stamp);
	int bitcoinAdressInsert(BitcoinAdressDTO bitcoinAdress);
	ArrayList<BitcoinAdressDTO> bitcoinAdressSelect(String id);
	MusicStampDTO StampSelect(String id,String MusicHash);	
}
