package com.fairmusic.dto;

public class artistDTO {
	
	public artistDTO(String artist_code, String artist_id, String artist_pass,
			String artist_grade, String artist_balance, String artist_email,
			String artist_image, String artist_bit_address,
			String artist_self_introduction, String artist_alive) {
		super();
		this.artist_code = artist_code;
		this.artist_id = artist_id;
		this.artist_pass = artist_pass;
		this.artist_grade = artist_grade;
		this.artist_balance = artist_balance;
		this.artist_email = artist_email;
		this.artist_image = artist_image;
		this.artist_bit_address = artist_bit_address;
		this.artist_self_introduction = artist_self_introduction;
		this.artist_alive = artist_alive;
	}


	private String artist_code;
	private String artist_id;
	private String artist_pass;
	private String artist_grade;
	private String artist_balance;
	private String artist_email;
	private String artist_image;
	private String artist_bit_address;
	private String artist_self_introduction;
	private String artist_alive;
	public String getArtist_code() {
		return artist_code;
	}


	public void setArtist_code(String artist_code) {
		this.artist_code = artist_code;
	}


	public String getArtist_id() {
		System.out.println("asdfasdfasdfasdfasdf");
		return artist_id;
	}


	public void setArtist_id(String artist_id) {
		this.artist_id = artist_id;
	}


	public String getArtist_pass() {
		return artist_pass;
	}


	public void setArtist_pass(String artist_pass) {
		this.artist_pass = artist_pass;
	}


	public String getArtist_grade() {
		return artist_grade;
	}


	public void setArtist_grade(String artist_grade) {
		this.artist_grade = artist_grade;
	}


	public String getArtist_balance() {
		return artist_balance;
	}


	public void setArtist_balance(String artist_balance) {
		this.artist_balance = artist_balance;
	}


	public String getArtist_email() {
		return artist_email;
	}


	public void setArtist_email(String artist_email) {
		this.artist_email = artist_email;
	}


	public String getArtist_image() {
		return artist_image;
	}


	public void setArtist_image(String artist_image) {
		this.artist_image = artist_image;
	}


	public String getArtist_bit_address() {
		return artist_bit_address;
	}


	public void setArtist_bit_address(String artist_bit_address) {
		this.artist_bit_address = artist_bit_address;
	}


	public String getArtist_self_introduction() {
		return artist_self_introduction;
	}


	public void setArtist_self_introduction(String artist_self_introduction) {
		this.artist_self_introduction = artist_self_introduction;
	}


	public String getArtist_alive() {
		return artist_alive;
	}


	public void setArtist_alive(String artist_alive) {
		this.artist_alive = artist_alive;
	}


	@Override
	public String toString() {
		return "artistDTO [artist_code=" + artist_code + ", artist_id="
				+ artist_id + ", artist_pass=" + artist_pass
				+ ", artist_grade=" + artist_grade + ", artist_balance="
				+ artist_balance + ", artist_email=" + artist_email
				+ ", artist_image=" + artist_image + ", artist_bit_address="
				+ artist_bit_address + ", artist_self_introduction="
				+ artist_self_introduction + ", artist_alive=" + artist_alive
				+ "]";
	}
}
