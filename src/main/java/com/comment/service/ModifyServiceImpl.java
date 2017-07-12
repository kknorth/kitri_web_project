package com.comment.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commant.dao.BDao;

public class ModifyServiceImpl implements CommentService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDao  dao = new BDao();
		dao.modify(bId, bName, bTitle, bContent);
			
	}

}
