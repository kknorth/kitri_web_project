package com.blocko.blockchain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.blocko.api.API;

import io.blocko.coinstack.exception.CoinStackException;
import io.blocko.coinstack.exception.MalformedInputException;
import io.blocko.coinstack.openassets.ColoringEngine;
import io.blocko.apache.commons.codec.binary.Hex;
import io.blocko.coinstack.*;
import io.blocko.coinstack.Math;

public class OpenAsset {
	CoinStackClient coinstack = null;
	ColoringEngine coloringEngine = new ColoringEngine(coinstack);
	@Before
	public void befor(){
		coinstack = API.createNewCoinStackClient();
	}
	
	@After
	public void after(){
		coinstack.close();
	}
	/*@Test
	public void testGenerateKey() throws CoinStackException {
		System.out.println("@@ testGenerateKey");
		String newPrivateKeyWIF = ECKey.createNewPrivateKey();
		System.out.println("create privateKey: "+newPrivateKeyWIF);
		System.out.println("");
		
		String AssetAddress = deriveAssetAddressFromPrivateKey(newPrivateKeyWIF);
		System.out.println("create AssetAddress: "+AssetAddress);
	}
	
	@Test
	public static String deriveAssetAddressFromPrivateKey(String privateKey){
		String AssetAddress="";
		try {
			AssetAddress = ECKey.deriveAddress(privateKey);
		} catch (MalformedInputException e) {
			e.printStackTrace();
		}
		return AssetAddress;	
	}
		// Asset ID 积己
	public static String createAssetID(byte[] inputScript){
		
		return null;
	}
	*/

	// Open Assets Issuance(惯青)
	 @Test
	    public void testIssueAsset() throws Exception {
		 	
	        String privateKeyWIF = "KyJwJ3Na9fsgvoW2v4rVGRJ7Cnb2pG4yyQQvrGWvkpuovvMRE9Kb";
	        long assetAmount = 666;
	        String to = "akE2cSu1JuzpXNABPXSrwkWtgL4fiTNq1xz";
	        long fee = Math.convertToSatoshi("0.0002");
	        String rawTx = coloringEngine.issueAsset(privateKeyWIF, assetAmount, to, fee);
	        
	        assertNotNull(rawTx);

	        coinstack.sendTransaction(rawTx);
	    }
	
	// Open Assets Transfer(傈价)
	 
	 @Test
	    public void testTransferAsset() throws Exception {
	        String privateKeyWIF = "KztgqWTCKS6dxuUnKcJnyiHtUqJ78k91P8Rn9oNrFLhgnRh3wiiE";

	        String assetID = "AKJFoih7ioqPXAHgnDzJvHE8x2FMcFerfv";
	        long assetAmount = 30;
	        String to = "akFNUeHPC59mrBw3E57bRjgKTdUZeMxeLur";//惑措规俊霸 傈价且 Asset林家
	        long fee = Math.convertToSatoshi("0.0002");
	        String rawTx = coloringEngine.transferAsset(privateKeyWIF, assetID, assetAmount, to, fee);

	        assertNotNull(rawTx);

	        coinstack.sendTransaction(rawTx);
	    }

}
