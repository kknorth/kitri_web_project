package com.blocko.service;

import java.util.ArrayList;

import com.blocko.dao.BlockoDAO;
import com.blocko.dao.BlockoDAOImpl;
import com.blocko.dto.MusicStampDTO;

public class BlockoServiceImpl implements BlockoService{

	@Override
	public int insert(MusicStampDTO stamp) {
		BlockoDAO dao = new BlockoDAOImpl();
		int dept = dao.insert(stamp);
		return dept;
	}

}
