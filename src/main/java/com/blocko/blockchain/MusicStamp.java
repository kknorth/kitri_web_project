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
		
		String testMusicHashHex = getMusicHashHex(); //���������͸� �ؽ��Ѱ�
		String stampId = testStampMusic(testMusicHashHex); // ���������� �ؽ��Ѱ����� ���ν����� �����ϴ� stampDcoument�� ������ ��´� �װ� StampId
		String stampHash = testGetStamp(stampId); // ���������� �ؽ� => ����������ID => ������id������ ���� ���� ������ ������ �ؽ����� �����´�.
		assertEquals(testMusicHashHex, stampHash);
		
		//hexHash: ff786d948022a3fa699ae0da8a307f39da78aa81dfc5643e831a4f3d84c825d6
		//stampId: 0c0310a449c805237f0ed636fe0f2328444fa8ff0148cc55c7377d19c187a93e-0
		System.out.println("");
	}
	//�����ڵ� �������� ����Ʈ�� �����ͼ� �� �� �ѷ��ش�(�ŷڼ�)
	@Test
	public void testGetStamp() throws Exception {
		System.out.println("@@ testGetStamp");
		String stampHash = testGetStamp("0c0310a449c805237f0ed636fe0f2328444fa8ff0148cc55c7377d19c187a93e-0");
		assertEquals("ff786d948022a3fa699ae0da8a307f39da78aa81dfc5643e831a4f3d84c825d6", stampHash);
		System.out.println("");
		
	}
	
	public String getMusicHashHex() {
		String music = "music"; // mp3�����Ͱ� �������϶�
		byte[] data = music.getBytes();
		byte[] hash = Sha256Hash.create(data).getBytes();
		String hexHash = Utils.HEX.encode(hash);
		return hexHash;
		//Hash�Ѱ��� txId��
	}
	
	public String testStampMusic(String hexHash) throws IOException, CoinStackException {
		System.out.println("hexHash: "+hexHash);
		String stampId = coinstack.stampDocument(hexHash);//������ Id�� ���ü������ �Ѿ��.(?)
														  //�ؽ����� �ڵ����� ���ü�ο� ��ϵȴ�
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
	//SHA-256 �ؽø� ���ü�ο� ����ϵ��� ��û
	//���� ��û ����� Ȯ���� �� �ִ� stamp ID�� ��ȯ �� ������ �����ڵ尪�� ���ü�ο� ���
	String privateKeyWIF = "KwHvqxng9gUDyDLxY4rnyMPsUiuj8ozrP9y4QHPjP8X3ApjjSW4U";//�����̺�Ű
	String music = "music";
	byte[] data = music.getBytes();
	String hash = Codecs.SHA256.digestEncodeHex(data);

	String stampId = coinstack.stampDocument(privateKeyWIF, hash);
	System.out.println(stampId);
	
	
	//Get stamp status
	//Stamp ��û ���¸� Ȯ��, Stamp�� ����� transaction hash�� output, confirmation ���¸� ��ȯ
	Stamp stamp = coinstack.getStamp("YOUR_STAMP_ID_VALUE");
	System.out.println(stamp.getHash());

	if("YOUR_STAMP_HASH".equals(stamp.getHash())){
	    System.out.println("Right");
	} else {
	    System.out.println("Wrong");
	}
}*/
}
