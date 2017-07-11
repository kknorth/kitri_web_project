package com.blocko.dto;

public class BitcoinAdressDTO {
	
	String audio_code;
	String bitcoinAdress1;
	String privatekey1;
	String bitcoinAdress2;
	String privatekey2;
	String bitcoinAdress3;
	String privatekey3;
	String righterName1;
	long righterVal1;
	String righterName2;
	long righterVal2;
	String righterName3;
	long righterVal3;

	public BitcoinAdressDTO(){}

	public BitcoinAdressDTO(String audio_code, String bitcoinAdress1,
			String privatekey1, String bitcoinAdress2, String privatekey2,
			String bitcoinAdress3, String privatekey3, String righterName1,
			long righterVal1, String righterName2, long righterVal2,
			String righterName3, long righterVal3) {
		super();
		this.audio_code = audio_code;
		this.bitcoinAdress1 = bitcoinAdress1;
		this.privatekey1 = privatekey1;
		this.bitcoinAdress2 = bitcoinAdress2;
		this.privatekey2 = privatekey2;
		this.bitcoinAdress3 = bitcoinAdress3;
		this.privatekey3 = privatekey3;
		this.righterName1 = righterName1;
		this.righterVal1 = righterVal1;
		this.righterName2 = righterName2;
		this.righterVal2 = righterVal2;
		this.righterName3 = righterName3;
		this.righterVal3 = righterVal3;
	}

	public String getId() {
		return audio_code;
	}

	public void setId(String id) {
		this.audio_code = id;
	}

	public String getBitcoinAdress1() {
		return bitcoinAdress1;
	}

	public void setBitcoinAdress1(String bitcoinAdress1) {
		this.bitcoinAdress1 = bitcoinAdress1;
	}

	public String getPrivatekey1() {
		return privatekey1;
	}

	public void setPrivatekey1(String privatekey1) {
		this.privatekey1 = privatekey1;
	}

	public String getBitcoinAdress2() {
		return bitcoinAdress2;
	}

	public void setBitcoinAdress2(String bitcoinAdress2) {
		this.bitcoinAdress2 = bitcoinAdress2;
	}

	public String getPrivatekey2() {
		return privatekey2;
	}

	public void setPrivatekey2(String privatekey2) {
		this.privatekey2 = privatekey2;
	}

	public String getBitcoinAdress3() {
		return bitcoinAdress3;
	}

	public void setBitcoinAdress3(String bitcoinAdress3) {
		this.bitcoinAdress3 = bitcoinAdress3;
	}

	public String getPrivatekey3() {
		return privatekey3;
	}

	public void setPrivatekey3(String privatekey3) {
		this.privatekey3 = privatekey3;
	}

	public String getRighterName1() {
		return righterName1;
	}

	public void setRighterName1(String righterName1) {
		this.righterName1 = righterName1;
	}

	public long getRighterVal1() {
		return righterVal1;
	}

	public void setRighterVal1(long righterVal1) {
		this.righterVal1 = righterVal1;
	}

	public String getRighterName2() {
		return righterName2;
	}

	public void setRighterName2(String righterName2) {
		this.righterName2 = righterName2;
	}

	public long getRighterVal2() {
		return righterVal2;
	}

	public void setRighterVal2(long righterVal2) {
		this.righterVal2 = righterVal2;
	}

	public String getRighterName3() {
		return righterName3;
	}

	public void setRighterName3(String righterName3) {
		this.righterName3 = righterName3;
	}

	public long getRighterVal3() {
		return righterVal3;
	}

	public void setRighterVal3(long righterVal3) {
		this.righterVal3 = righterVal3;
	}

}
