package com.blocko.controller;

import io.blocko.bitcoinj.core.Sha256Hash;
import io.blocko.bitcoinj.core.Utils;
import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.exception.CoinStackException;
import io.blocko.coinstack.model.Stamp;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blocko.api.API;
import com.blocko.dto.BitcoinAdressDTO;
import com.blocko.dto.MusicStampDTO;
import com.blocko.service.BlockoService;
import com.blocko.service.BlockoServiceImpl;

@WebServlet(name = "stampselect", urlPatterns = { "/stampselect" })
public class StampSelect extends HttpServlet {
	CoinStackClient coinstack = API.createNewCoinStackClient();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		//���� ���ε� ��ư ����Ʈ �������� �����̷�Ʈ �ȴ� �׸��� ����Ʈ�� �����ԵǸ� ���ü�� ������ ���
		//���ü�ο� ���ε� �ð��� �ֱ� ������ timestamp�� null���� �� �� �ִ�.
		String id= "woo";
		try {
			String musicName =request.getParameter("musicName");

			BlockoService service = new BlockoServiceImpl();
			MusicStampDTO musicstamp = service.StampSelect(id, musicName);
			
			Stamp stamp = coinstack.getStamp(musicstamp.getStampId());

			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
			String msg="";
			
			try {
				String Timestamp = dateFormat.format(stamp.getTimestamp());
				request.setAttribute("Timestamp", Timestamp);
			} catch (NullPointerException e) {
				msg = "���ü�� ������";
			}
			
			request.setAttribute("musicName",musicName);
			request.setAttribute("musicHash", musicstamp.getMusicHash());
			request.setAttribute("txId", stamp.getTxId());
			request.setAttribute("Confirmations", stamp.getConfirmations());
			request.setAttribute("msg", msg);
		} catch (CoinStackException e) {
			
			e.printStackTrace();
		}finally{
			coinstack.close();
		}

		RequestDispatcher rd =
				request.getRequestDispatcher("/MusicUpload/musicstampselect.jsp");
		rd.forward(request, response);
	}
}
