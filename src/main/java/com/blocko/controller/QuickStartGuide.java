package com.blocko.controller;

import static org.junit.Assert.assertNotNull;
import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.ECKey;
import io.blocko.coinstack.TransactionBuilder;
import io.blocko.coinstack.TransactionUtil;
import io.blocko.coinstack.exception.CoinStackException;
import io.blocko.coinstack.model.Block;
import io.blocko.coinstack.model.BlockchainStatus;
import io.blocko.coinstack.model.Transaction;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.blocko.api.API;

public class QuickStartGuide {
	CoinStackClient coinstack = null;
	
	@Before
	public void befor(){
		coinstack = API.createNewCoinStackClient();
	}
	
	@After
	public void after(){
		coinstack.close();
	}
	
	@Test
	public void quickStartGuide() throws Exception {
		testBestBlock();
		testTransactions();
		testAddress();
		//testTransactionBuilder();
		//musicStamp();
	}
	public void testBestBlock() throws IOException, CoinStackException {
		System.out.println("@@ BestBlock");
		
		// getBlockchainStatus : Blockchain 상태정보 조회, 상태정보 객체에  getBestheight메소드를 사용하면 최신 블록번호를 알 수 있다, 또한 getBestBlockHash메소드는 최신 블록의 해시를 반환.
		// 블록의 해시는 블록의 정보를 조회할때 ID로 사용가능
		BlockchainStatus status = coinstack.getBlockchainStatus();
		assertNotNull(status);
		System.out.println("- BlockChainStatus");
		System.out.println("  bestBlockHash: "+status.getBestBlockHash());
		System.out.println("  bestHeight: "+status.getBestHeight());
		System.out.println("");
	}
	
	public void testTransactions() throws IOException, CoinStackException {
		
		System.out.println("## Transactions");
		
		// BestBlock 조회
		System.out.println("- Block");
		BlockchainStatus status = coinstack.getBlockchainStatus();
		String blockId = status.getBestBlockHash();
		System.out.println("  blockId: "+blockId);
		Block block = coinstack.getBlock(blockId);
		assertNotNull(block);
		System.out.println("blockId: " + block.getBlockId());
		System.out.println("parentId: " + block.getParentId());
		System.out.println("height: " + block.getHeight());
		System.out.println("time: " + block.getBlockConfirmationTime());
		
		// 전체 Transaction 조회 
		System.out.println("  - MusicTradeTransaction");
		String[] txIds = block.getTransactionIds();
		assertNotNull(txIds);
		for (int x=1, len=txIds.length; x<len; x++) {
			String txId = txIds[x];
			System.out.println("    - txId "+x+": "+txId);
			Transaction tx = coinstack.getTransaction(txId);
			assertNotNull(tx);
			System.out.println("      inputs.cnt: "+tx.getInputs().length);
			System.out.println("      outs.cnt: "+tx.getOutputs().length);
			if (x > 2) {
				break;
			}
		}
		System.out.println("");		
	}
	
	public void testAddress() throws IOException, CoinStackException {
		System.out.println("## MyAddress");
		
		// Address 조회 , Balance 출력 
		String YOUR_MUSICBLOCKCHAIN_ADDRESS = "1GutVUYpSjGWXy4R8hALiuC6WB7Dy9CFmJ";
		
		System.out.println("- Address: "+YOUR_MUSICBLOCKCHAIN_ADDRESS);
		
		long balance = coinstack.getBalance(YOUR_MUSICBLOCKCHAIN_ADDRESS);
		System.out.println("- Balance: "+balance);
		
		//주소는 비트코인을 담고 있거나 OP_RETURN 데이터를 담고 있다.특정 주소에서 일어난 비트코인 거래 내역 또는 OP_RETURN 데이터의 내용을 조회하는 기능
		//내가 결제한 뮤직리스트의 거래 내역을 출력하게 수정
		System.out.println("- MyMusicTransactions");
		String[] txIds = coinstack.getTransactions(YOUR_MUSICBLOCKCHAIN_ADDRESS);
		for (String txId : txIds) {
			System.out.println("  txIds[]: "+txId);
		}
		System.out.println("");
		
		//unspent outputs 조회
		//자신의 주소에 해당하는 Transaction output은 두 가지 종류, 
		//한 가지는 Spent ouput, 
		//다른 한 가지는 일반적으로 UTXO라 불리는 Unspent output
		//새로운 거래를 만들기 위해서는 이 UTXO를 input으로 입력해야 하는데, 
		//코인스택에서는 이를 위해 특정 주소와 연관된 UTXO들을 조회하는 기능
		//즉, 쉽게말해 사용하지 않은 트랜잭션 거래장부(거래내역을 보기위해서 사용하지 않은 거래기록은 유효한 output으로 사용)
		
		/*Output[] outputs = coinstack.getUnspentOutputs(YOUR_MUSICBLOCKCHAIN_ADDRESS);
		System.out.println("unspent outputs"); 
		for (Output utxo: outputs) { 
		    System.out.println(utxo.getValue());
		}*/

	}
	//뮤직 데이터 트랜잭션 생성 및 전송
	/*public void testTransactionBuilder() throws IOException, CoinStackException {
		//트랜잭션 생성(트랜잭션을 이용하여 특정 블록체인 주소로 비트코인을 전송하거나, 데이터를 저장)
		//새로운 트랜잭션을 만들기 위해서는 일단 input으로 사용할 unspent output을 조회하여 사용 가능한 잔고를 확인
		//SDK에 포함된 transaction builder를 이용하면 트랜잭션 생성시 자동으로 unspent output을 조회
		//unspent output은 SDK가 자동적으로 지정해 줌 그리고 개인키로 서명하여 지정한 unspent output의 소유권을 증명
		
		// create a target address to send
		
		//String toPrivateKeyWIF = ECKey.createNewPrivateKey();
		String toPrivateKeyWIF = "KwHvqxng9gUDyDLxY4rnyMPsUiuj8ozrP9y4QHPjP8X3ApjjSW4U"; //프라이빗키
		String toAddress = ECKey.deriveAddress(toPrivateKeyWIF);

		// create a transaction 
		
		//***********************트랜잭션 결제********************************
		long amount = io.blocko.coinstack.Math.convertToSatoshi("0.0002");
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
	}
*/
}
