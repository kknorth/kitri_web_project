package com.blocko.blockchain;
import static org.junit.Assert.*;

import org.junit.Test;

import io.blocko.apache.commons.codec.binary.Hex;
import io.blocko.coinstack.exception.CoinStackException;
import io.blocko.coinstack.*;


//개인키와 공개키 주소 생성?? 생성할 필요 없을거 같다.
public class GenerateKey {
	@Test
	public void testGenerateKey() throws CoinStackException {
		/*System.out.println("@@ testGenerateKey");
		String newPrivateKeyWIF = ECKey.createNewPrivateKey();
		String newPublicKey = Hex.encodeHexString(ECKey.derivePubKey(newPrivateKeyWIF));
		System.out.println("create privateKey: "+newPrivateKeyWIF);
		System.out.println("PublicKey: "+newPublicKey);
		System.out.println("");*/
		//create privateKey: KwHvqxng9gUDyDLxY4rnyMPsUiuj8ozrP9y4QHPjP8X3ApjjSW4U
		//PublicKey: 024b7c1346fa8932bc842f480fc568a8de44d4d411f0838bea1b7eb327a027971c
		
		/*System.out.println("@@ testGenerateKey");
		String privateKey = ECKey.createNewPrivateKey();
		String authorityAddress = ECKey.deriveAddress(privateKey);
		System.out.println("create privateKey: "+privateKey);
		System.out.println("derive authorityAddress: "+authorityAddress);
		System.out.println("");*/
		
	}
	//비트코인 주소는 이 공개키를 RIPEMD160(SHA256(K)) 함수로 다시 인코딩하여 생성, 개인키에서 비트코인 주소를 생성
	@Test
	public void testDeriveKey() throws CoinStackException {
		System.out.println("## testGenerateKey");
		String privateKey = "KwHvqxng9gUDyDLxY4rnyMPsUiuj8ozrP9y4QHPjP8X3ApjjSW4U";
		String MusicAddress = ECKey.deriveAddress(privateKey);
		System.out.println("MusicAddress: "+MusicAddress);
		assertEquals("1GutVUYpSjGWXy4R8hALiuC6WB7Dy9CFmJ", MusicAddress);
		System.out.println("");
		//MusicAddress: 1GutVUYpSjGWXy4R8hALiuC6WB7Dy9CFmJ
		
		/*System.out.println("## testGenerateKey");
		String privateKey = "L2yQ2ZY8SRnygwn2fagvYSgZ6JG2DfGDSs3GLZZrkCSCmPJrYEDt";
		String authorityAddress = ECKey.deriveAddress(privateKey);
		System.out.println("derive authorityAddress: "+authorityAddress);
		assertEquals("19gnTx1RNBQURAif1hY8vVcZ9Zdm81D2gk", authorityAddress);
		System.out.println("");*/
	}
}
