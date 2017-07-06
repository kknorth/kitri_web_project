package com.blocko.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import io.blocko.apache.commons.codec.binary.Hex;
import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.ECKey;
import io.blocko.coinstack.Math;
import io.blocko.coinstack.exception.CoinStackException;
import io.blocko.coinstack.exception.MalformedInputException;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.blocko.api.API;


 @WebServlet(name = "openasset", urlPatterns = { "/openasset" })
public class OpenAssetServletTest extends HttpServlet {
	CoinStackClient coinstack = API.createNewCoinStackClient();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		
		try {
			String newPrivateKey = ECKey.createNewPrivateKey();
			String MusicAddress = ECKey.deriveAddress(newPrivateKey);
			long balance = coinstack.getBalance(MusicAddress);
			
			System.out.println("MusicAddress: "+MusicAddress);
			System.out.println("create privateKey: "+newPrivateKey);
			System.out.println("balance: " + balance);
			request.setAttribute("MusicAddress", MusicAddress);
			request.setAttribute("balance", balance);
		} catch (MalformedInputException e) {
			e.printStackTrace();
		} catch (CoinStackException e) {
			
			e.printStackTrace();
		}
		
		RequestDispatcher rd =
				request.getRequestDispatcher("/OpenAsset/OpenAsset.jsp");
		rd.forward(request, response);
		

	}
	
	/*public static String deriveAssetAddressFromPrivateKey(String privateKey){
		String openAssetAddr = "";
		
		return openAssetAddr;
	}*/
	

	/*// Open Assets Issuance(발행)
	
	    public void testIssueAsset() throws Exception {
		 	
	        String privateKeyWIF = "KyJwJ3Na9fsgvoW2v4rVGRJ7Cnb2pG4yyQQvrGWvkpuovvMRE9Kb";
	        long assetAmount = 666;
	        String to = "akE2cSu1JuzpXNABPXSrwkWtgL4fiTNq1xz";
	        long fee = Math.convertToSatoshi("0.0002");
	        String rawTx = coloringEngine.issueAsset(privateKeyWIF, assetAmount, to, fee);
	        
	        assertNotNull(rawTx);

	        coinstack.sendTransaction(rawTx);
	    }
	
	// Open Assets Transfer(전송)
	 
	
	    public void testTransferAsset() throws Exception {
	        String privateKeyWIF = "KztgqWTCKS6dxuUnKcJnyiHtUqJ78k91P8Rn9oNrFLhgnRh3wiiE";

	        String assetID = "AKJFoih7ioqPXAHgnDzJvHE8x2FMcFerfv";
	        long assetAmount = 30;
	        String to = "akFNUeHPC59mrBw3E57bRjgKTdUZeMxeLur";//상대방에게 전송할 Asset주소
	        long fee = Math.convertToSatoshi("0.0002");
	        String rawTx = coloringEngine.transferAsset(privateKeyWIF, assetID, assetAmount, to, fee);

	        assertNotNull(rawTx);

	        coinstack.sendTransaction(rawTx);
	    }
*/
}
