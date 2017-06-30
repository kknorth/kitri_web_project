package com.blocko.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.blocko.dto.MusicStampDTO;
import com.fairmusic.emp.dto.EmpDTO;

public interface BlockoService {
	int insert(MusicStampDTO stamp);
}
