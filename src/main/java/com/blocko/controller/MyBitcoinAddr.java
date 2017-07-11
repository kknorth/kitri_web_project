package com.blocko.controller;

import io.blocko.coinstack.exception.CoinStackException;
import io.blocko.coinstack.ECKey;
public class MyBitcoinAddr {
	public String PrivateKey() throws CoinStackException {
		String newPrivateKey ="";
		newPrivateKey = ECKey.createNewPrivateKey();
		return newPrivateKey;
	}
	public String MusicAddress() throws CoinStackException {
		String MusicAddress ="";
		String newPrivateKey = PrivateKey();
		MusicAddress = ECKey.deriveAddress(newPrivateKey);
		return MusicAddress;
	}
}
