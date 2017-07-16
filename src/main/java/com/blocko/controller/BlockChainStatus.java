package com.blocko.controller;

import static org.junit.Assert.assertNotNull;
import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.exception.CoinStackException;
import io.blocko.coinstack.model.Block;
import io.blocko.coinstack.model.BlockchainStatus;
import io.blocko.coinstack.model.Transaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blocko.api.API;
import com.blocko.dto.BlockChainStatusDTO;

@WebServlet(name = "BlockChainStatus", urlPatterns = { "/BlockChainStatus" })
public class BlockChainStatus extends HttpServlet {
	CoinStackClient coinstack = API.createNewCoinStackClient();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BlockchainStatus status;
		try {
			status = coinstack.getBlockchainStatus();
			String blockId = status.getBestBlockHash();
			System.out.println("  blockId: "+blockId);
			Block block = coinstack.getBlock(blockId);
			System.out.println("blockId: " + block.getBlockId());
			System.out.println("parentId: " + block.getParentId());
			System.out.println("height: " + block.getHeight());
			System.out.println("time: " + block.getBlockConfirmationTime());
			PrintWriter pw = response.getWriter();
			String parentId = block.getParentId();
			int height = block.getHeight();
			Date time = block.getBlockConfirmationTime();
			// 전체 Transaction 조회 
			System.out.println("  - MusicTradeTransaction");
			String[] txIds = block.getTransactionIds();
			BlockChainStatusDTO statusdto = null;
			for (int x=1, len=txIds.length; x<len; x++) {
				String txId = txIds[x];
				System.out.println("    - txId "+x+": "+txId);
				Transaction tx = coinstack.getTransaction(txId);
				System.out.println("      inputs.cnt: "+tx.getInputs().length);
				System.out.println("      outs.cnt: "+tx.getOutputs().length);
				if (x > 2) {
					break;
				}
				statusdto = new BlockChainStatusDTO(blockId, parentId, height, time);
			}
			request.setAttribute("statusdto", statusdto);
			
		} catch (CoinStackException e) {
			e.printStackTrace();
		}
		request.setAttribute("viewpath", "../blockchainstatus/blockchainstatus.jsp");
		RequestDispatcher rd =
				request.getRequestDispatcher("/layout/mainLayout.jsp");
		rd.forward(request, response);
	}
}
