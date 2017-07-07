package com.blocko.dto;

public class BitcoinAdressDTO {
	String id;
	String bitcoinAdress;
	String privatekey;
	
	public BitcoinAdressDTO(){}
	public BitcoinAdressDTO(String id, String bitcoinAdress, String privatekey) {
		super();
		this.id = id;
		this.bitcoinAdress = bitcoinAdress;
		this.privatekey = privatekey;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBitcoinAdress() {
		return bitcoinAdress;
	}
	public void setBitcoinAdress(String bitcoinAdress) {
		this.bitcoinAdress = bitcoinAdress;
	}
	public String getPrivatekey() {
		return privatekey;
	}
	public void setPrivatekey(String privatekey) {
		this.privatekey = privatekey;
	}
	
	
}
