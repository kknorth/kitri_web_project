package com.blocko.controller;

import io.blocko.bitcoinj.core.Sha256Hash;
import io.blocko.bitcoinj.core.Utils;
import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.exception.CoinStackException;
import io.blocko.coinstack.model.Stamp;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blocko.api.API;
import com.blocko.dto.MusicStampDTO;
import com.blocko.service.BlockoService;
import com.blocko.service.BlockoServiceImpl;

@WebServlet(name = "stampinsert", urlPatterns = { "/stampinsert" })
public class StampInsert extends HttpServlet {
	CoinStackClient coinstack = API.createNewCoinStackClient();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		//�������ε� ������ �μ�Ʈ�ǰ� ����� �ѹ�  ��޿� ����ش�. �׸��� ��� ���������� ���� ����Ʈ ��� �� Ŭ���� StampSelect �������� ���ü�� ������ ��������
		String id= "woo";
		String musicName = request.getParameter("musicName"); // mp3�����Ͱ� �������϶�
		byte[] data = musicName.getBytes();
		byte[] hash = Sha256Hash.create(data).getBytes();
		String MusicHash = Utils.HEX.encode(hash);
		System.out.println("���� �ؽ���: "+MusicHash);
		// ���� �ؽ����� �ѷ��ش�.
		try {
			String stampId = coinstack.stampDocument(MusicHash);
			System.out.println("������ �������� �� : "+stampId);
			
			//Stamp stamp = coinstack.getStamp(stampId); //"f706145581af043206600a9182357b59c57d37dcf232d44c276f8ce22016c4a1-0"
			
			//System.out.println("���ü�� Ʈ����� ��: "+stamp.getTxId());
			
			MusicStampDTO stampDTO = new MusicStampDTO(id, musicName, MusicHash, stampId);
			BlockoService service = new BlockoServiceImpl();		
			int result = service.insert(stampDTO);
			
			String msg = "";
			if(result>=1){
				msg = result+"�� - Music ���ü�� ���ԵǾ����ϴ�.";
			}else{
				msg = "���ü�� ���Խ���";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("MusicHash", MusicHash);
			request.setAttribute("stampId", stampId);
			//request.setAttribute("txId", stamp.getTxId());
		} catch (CoinStackException e) {
			e.printStackTrace();
		}finally{
			coinstack.close();
		}
		RequestDispatcher rd =
				request.getRequestDispatcher("/MusicUpload/musicstampinsert.jsp");
		rd.forward(request, response);
	}
}
