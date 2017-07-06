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
		
		/*//Ʈ����� ����(Ʈ������� �̿��Ͽ� Ư�� ���ü�� �ּҷ� ��Ʈ������ �����ϰų�, �����͸� ����)
		//���ο� Ʈ������� ����� ���ؼ��� �ϴ� input���� ����� unspent output�� ��ȸ�Ͽ� ��� ������ �ܰ� Ȯ��
		//SDK�� ���Ե� transaction builder�� �̿��ϸ� Ʈ����� ������ �ڵ����� unspent output�� ��ȸ
		//unspent output�� SDK�� �ڵ������� ������ �� �׸��� ����Ű�� �����Ͽ� ������ unspent output�� �������� ����
		
		// create a target address to send
		
		//String toPrivateKeyWIF = ECKey.createNewPrivateKey();
		
		String toPrivateKeyWIF = "KwHvqxng9gUDyDLxY4rnyMPsUiuj8ozrP9y4QHPjP8X3ApjjSW4U"; //�����̺�Ű
		String toAddress = ECKey.deriveAddress(toPrivateKeyWIF);

		// create a transaction 
		
		//***********************Ʈ����� ����********************************
		long amount = io.blocko.coinstack.Math.convertToSatoshi("0.0002"); �Է°� �޾ƿ���
		long fee = io.blocko.coinstack.Math.convertToSatoshi("0.0001");
		
		//*****************************Data Ʈ�����*****************************
		//��Ʈ������ �����ϴ� ��� OP_RETURN �̶�� output script�� ����Ͽ� Ʈ����ǿ� �����͸� ���� ����!!!!!!!!!
		//���ν��� SDK�� ���Ե� transaction builder���� �����ϴ� �������̽��� ����Ͽ� ���ü�ο� ������ ����
		//stamping �� Open Assets ���� ����� OP_RETURN�� �̿�
		TransactionBuilder builder = new TransactionBuilder();
		builder.allowDustyOutput(true);
		builder.setData("DATA_AT_OP_RETURN ����� mp3������ �־�°� ������?".getBytes());
		builder.addOutput(toAddress, amount);
		builder.setFee(fee);
		 
		// sign the transaction using the private key
		String rawSignedTx = coinstack.createSignedTransaction(builder, "KwHvqxng9gUDyDLxY4rnyMPsUiuj8ozrP9y4QHPjP8X3ApjjSW4U"); //�����̺�Ű
		System.out.println(rawSignedTx);
		
		// send the signed transaction
		coinstack.sendTransaction(rawSignedTx);
		// transaction lookup
		String transactionId = TransactionUtil.getTransactionHash(rawSignedTx);
		System.out.println(transactionId);
		// ��ȸ�� Ʈ����� id�� ������ ����
*/	}
}
