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
		
		// getBlockchainStatus : Blockchain �������� ��ȸ, �������� ��ü��  getBestheight�޼ҵ带 ����ϸ� �ֽ� ��Ϲ�ȣ�� �� �� �ִ�, ���� getBestBlockHash�޼ҵ�� �ֽ� ����� �ؽø� ��ȯ.
		// ����� �ؽô� ����� ������ ��ȸ�Ҷ� ID�� ��밡��
		BlockchainStatus status = coinstack.getBlockchainStatus();
		assertNotNull(status);
		System.out.println("- BlockChainStatus");
		System.out.println("  bestBlockHash: "+status.getBestBlockHash());
		System.out.println("  bestHeight: "+status.getBestHeight());
		System.out.println("");
	}
	
	public void testTransactions() throws IOException, CoinStackException {
		
		System.out.println("## Transactions");
		
		// BestBlock ��ȸ
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
		
		// ��ü Transaction ��ȸ 
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
		
		// Address ��ȸ , Balance ��� 
		String YOUR_MUSICBLOCKCHAIN_ADDRESS = "1GutVUYpSjGWXy4R8hALiuC6WB7Dy9CFmJ";
		
		System.out.println("- Address: "+YOUR_MUSICBLOCKCHAIN_ADDRESS);
		
		long balance = coinstack.getBalance(YOUR_MUSICBLOCKCHAIN_ADDRESS);
		System.out.println("- Balance: "+balance);
		
		//�ּҴ� ��Ʈ������ ��� �ְų� OP_RETURN �����͸� ��� �ִ�.Ư�� �ּҿ��� �Ͼ ��Ʈ���� �ŷ� ���� �Ǵ� OP_RETURN �������� ������ ��ȸ�ϴ� ���
		//���� ������ ��������Ʈ�� �ŷ� ������ ����ϰ� ����
		System.out.println("- MyMusicTransactions");
		String[] txIds = coinstack.getTransactions(YOUR_MUSICBLOCKCHAIN_ADDRESS);
		for (String txId : txIds) {
			System.out.println("  txIds[]: "+txId);
		}
		System.out.println("");
		
		//unspent outputs ��ȸ
		//�ڽ��� �ּҿ� �ش��ϴ� Transaction output�� �� ���� ����, 
		//�� ������ Spent ouput, 
		//�ٸ� �� ������ �Ϲ������� UTXO�� �Ҹ��� Unspent output
		//���ο� �ŷ��� ����� ���ؼ��� �� UTXO�� input���� �Է��ؾ� �ϴµ�, 
		//���ν��ÿ����� �̸� ���� Ư�� �ּҿ� ������ UTXO���� ��ȸ�ϴ� ���
		//��, ���Ը��� ������� ���� Ʈ����� �ŷ����(�ŷ������� �������ؼ� ������� ���� �ŷ������ ��ȿ�� output���� ���)
		
		/*Output[] outputs = coinstack.getUnspentOutputs(YOUR_MUSICBLOCKCHAIN_ADDRESS);
		System.out.println("unspent outputs"); 
		for (Output utxo: outputs) { 
		    System.out.println(utxo.getValue());
		}*/

	}
	//���� ������ Ʈ����� ���� �� ����
	/*public void testTransactionBuilder() throws IOException, CoinStackException {
		//Ʈ����� ����(Ʈ������� �̿��Ͽ� Ư�� ���ü�� �ּҷ� ��Ʈ������ �����ϰų�, �����͸� ����)
		//���ο� Ʈ������� ����� ���ؼ��� �ϴ� input���� ����� unspent output�� ��ȸ�Ͽ� ��� ������ �ܰ� Ȯ��
		//SDK�� ���Ե� transaction builder�� �̿��ϸ� Ʈ����� ������ �ڵ����� unspent output�� ��ȸ
		//unspent output�� SDK�� �ڵ������� ������ �� �׸��� ����Ű�� �����Ͽ� ������ unspent output�� �������� ����
		
		// create a target address to send
		
		//String toPrivateKeyWIF = ECKey.createNewPrivateKey();
		String toPrivateKeyWIF = "KwHvqxng9gUDyDLxY4rnyMPsUiuj8ozrP9y4QHPjP8X3ApjjSW4U"; //�����̺�Ű
		String toAddress = ECKey.deriveAddress(toPrivateKeyWIF);

		// create a transaction 
		
		//***********************Ʈ����� ����********************************
		long amount = io.blocko.coinstack.Math.convertToSatoshi("0.0002");
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
	}
*/
}
