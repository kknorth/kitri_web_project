package com.comment.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commant.dao.BDao;
import com.commant.dto.BDto;

public class ContentServiceImpl implements CommentService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String bId = request.getParameter("bId");
		BDao dao = new BDao();
		BDto dto = dao.contentView(bId);
		
		request.setAttribute("content_view", dto);
		
	}

}
