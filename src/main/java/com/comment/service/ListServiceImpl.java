package com.comment.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commant.dao.BDao;
import com.commant.dto.BDto;

public class ListServiceImpl implements CommentService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		request.setAttribute("list", dtos);
	}
}