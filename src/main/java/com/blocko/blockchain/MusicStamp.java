package com.blocko.blockchain;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.blocko.api.API;

import io.blocko.coinstack.*;
import io.blocko.coinstack.exception.CoinStackException;
import io.blocko.coinstack.model.*;
import io.blocko.bitcoinj.core.Sha256Hash;
import io.blocko.bitcoinj.core.Utils;


public class MusicStamp {
	CoinStackClient coinstack = null;
	
	@Before
	public void before() {
		coinstack = API.createNewCoinStackClient();
	}
	
	@After
	public void after() {
		coinstack.close();
	}
	
	public void testStamp() throws IOException, CoinStackException {
		System.out.println("## testGetStamp");
		
		String testMusicHashHex = getMusicHashHex(); //뮤직데이터를 해쉬한값
		String stampId = testStampMusic(testMusicHashHex); // 뮤직데이터 해쉬한값으로 코인스택이 제공하는 stampDcoument로 스탬프 찍는다 그게 StampId
		String stampHash = testGetStamp(stampId); // 뮤직데이터 해쉬 => 뮤직스탬핑ID => 스탬프id값으로 찍힌 뮤직 스탬프 데이터 해쉬값을 가져온다.
		assertEquals(testMusicHashHex, stampHash);
		
		//hexHash: ff786d948022a3fa699ae0da8a307f39da78aa81dfc5643e831a4f3d84c825d6
		//stampId: 0c0310a449c805237f0ed636fe0f2328444fa8ff0148cc55c7377d19c187a93e-0
		System.out.println("");
	}
	//음악코드 스탬프된 데이트를 가져와서 웹 상에 뿌려준다(신뢰성)
	@Test
	public void testGetStamp() throws Exception {
		System.out.println("@@ testGetStamp");
		String stampHash = testGetStamp("0c0310a449c805237f0ed636fe0f2328444fa8ff0148cc55c7377d19c187a93e-0");
		assertEquals("ff786d948022a3fa699ae0da8a307f39da78aa81dfc5643e831a4f3d84c825d6", stampHash);
		System.out.println("");
		
	}
	
	public String getMusicHashHex() {
		String music = "music"; // mp3데이터값 가져오니라
		byte[] data = music.getBytes();
		byte[] hash = Sha256Hash.create(data).getBytes();
		String hexHash = Utils.HEX.encode(hash);
		return hexHash;
		//Hash한값이 txId임
	}
	
	public String testStampMusic(String hexHash) throws IOException, CoinStackException {
		System.out.println("hexHash: "+hexHash);
		String stampId = coinstack.stampDocument(hexHash);//스탬프 Id가 블록체인으로 넘어간다.(?)
														  //해쉬값이 자동으로 블록체인에 등록된다
		assertNotNull(stampId);
		System.out.println("stampId: "+stampId);
		return stampId;
	}
	
	public String testGetStamp(String stampId) throws IOException, CoinStackException {
		Stamp stamp = coinstack.getStamp(stampId);
		assertNotNull(stamp);
		System.out.println("TxId: "+stamp.getTxId());
		System.out.println("OutputIndex: "+stamp.getOutputIndex());
		System.out.println("Confirmations: "+stamp.getConfirmations());
		System.out.println("Timestamp: "+stamp.getTimestamp());
		
		Transaction tx = coinstack.getTransaction(stamp.getTxId());
		assertNotNull(tx);
		Output[] outs = tx.getOutputs();
		assertNotNull(outs);
		assertTrue(outs.length > stamp.getOutputIndex());
		Output out = outs[stamp.getOutputIndex()];
		String strData = Utils.HEX.encode(out.getData());
		String strHash = strData.substring(4);
		System.out.println("strData: "+strData);
		System.out.println("strHash:     "+strHash);
		return strHash;
		
	}
	
	
	/*public void musicStamp() throws IOException, CoinStackException {
	//SHA-256 해시를 블록체인에 기록하도록 요청
	//차후 요청 결과를 확인할 수 있는 stamp ID를 반환 후 음악의 음악코드값을 블록체인에 등록
	String privateKeyWIF = "KwHvqxng9gUDyDLxY4rnyMPsUiuj8ozrP9y4QHPjP8X3ApjjSW4U";//프라이빗키
	String music = "music";
	byte[] data = music.getBytes();
	String hash = Codecs.SHA256.digestEncodeHex(data);

	String stampId = coinstack.stampDocument(privateKeyWIF, hash);
	System.out.println(stampId);
	
	
	//Get stamp status
	//Stamp 요청 상태를 확인, Stamp가 저장된 transaction hash와 output, confirmation 상태를 반환
	Stamp stamp = coinstack.getStamp("YOUR_STAMP_ID_VALUE");
	System.out.println(stamp.getHash());

	if("YOUR_STAMP_HASH".equals(stamp.getHash())){
	    System.out.println("Right");
	} else {
	    System.out.println("Wrong");
	}
}*/
}
