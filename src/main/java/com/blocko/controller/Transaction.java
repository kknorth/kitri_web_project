package com.blocko.controller;

import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.ECKey;
import io.blocko.coinstack.TransactionBuilder;
import io.blocko.coinstack.TransactionUtil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blocko.api.API;
@WebServlet(name = "transaction", urlPatterns = { "/transaction" })
public class Transaction extends HttpServlet {
	CoinStackClient coinstack = API.createNewCoinStackClient();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		/*//트랜잭션 생성(트랜잭션을 이용하여 특정 블록체인 주소로 비트코인을 전송하거나, 데이터를 저장)
		//새로운 트랜잭션을 만들기 위해서는 일단 input으로 사용할 unspent output을 조회하여 사용 가능한 잔고를 확인
		//SDK에 포함된 transaction builder를 이용하면 트랜잭션 생성시 자동으로 unspent output을 조회
		//unspent output은 SDK가 자동적으로 지정해 줌 그리고 개인키로 서명하여 지정한 unspent output의 소유권을 증명
		
		// create a target address to send
		
		//String toPrivateKeyWIF = ECKey.createNewPrivateKey();
		
		String toPrivateKeyWIF = "KwHvqxng9gUDyDLxY4rnyMPsUiuj8ozrP9y4QHPjP8X3ApjjSW4U"; //프라이빗키
		String toAddress = ECKey.deriveAddress(toPrivateKeyWIF);

		// create a transaction 
		
		//***********************트랜잭션 결제********************************
		long amount = io.blocko.coinstack.Math.convertToSatoshi("0.0002"); 입력값 받아오기
		long fee = io.blocko.coinstack.Math.convertToSatoshi("0.0001");
		
		//*****************************Data 트랜잭션*****************************
		//비트코인을 전송하는 대신 OP_RETURN 이라는 output script를 사용하여 트랜잭션에 데이터를 저장 가능!!!!!!!!!
		//코인스택 SDK에 포함된 transaction builder에서 제공하는 인터페이스를 사용하여 블록체인에 데이터 저장
		//stamping 및 Open Assets 관련 기능은 OP_RETURN을 이용
		TransactionBuilder builder = new TransactionBuilder();
		builder.allowDustyOutput(true);
		builder.setData("DATA_AT_OP_RETURN 여기다 mp3파일을 넣어는게 맞을까?".getBytes());
		builder.addOutput(toAddress, amount);
		builder.setFee(fee);
		 
		// sign the transaction using the private key
		String rawSignedTx = coinstack.createSignedTransaction(builder, "KwHvqxng9gUDyDLxY4rnyMPsUiuj8ozrP9y4QHPjP8X3ApjjSW4U"); //프라이빗키
		System.out.println(rawSignedTx);
		
		// send the signed transaction
		coinstack.sendTransaction(rawSignedTx);
		// transaction lookup
		String transactionId = TransactionUtil.getTransactionHash(rawSignedTx);
		System.out.println(transactionId);
		// 조회한 트랜잭션 id로 스탬핑 고고싱
*/	}
}
