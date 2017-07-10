package com.blocko.dto;

public class BitcoinAdressDTO {
	String id;
	String bitcoinAdress;
	String privatekey;
	String rightName;
	int percent;
	
	public BitcoinAdressDTO(){}

	public BitcoinAdressDTO(String id, String bitcoinAdress, String privatekey,
			String rightName, int percent) {
		super();
		this.id = id;
		this.bitcoinAdress = bitcoinAdress;
		this.privatekey = privatekey;
		this.rightName = rightName;
		this.percent = percent;
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

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	
}
