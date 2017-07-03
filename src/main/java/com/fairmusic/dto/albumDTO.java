package com.fairmusic.dto;

import java.sql.Date;

public class albumDTO {


	private String album_code;
	private String album_title;
	private String artist_code;
	private String album_image;
	private String album_date;
	private String album_dc;
	
	
	public albumDTO(){}
	
	public albumDTO(String album_code, String album_title, String artist_code,
			String album_image, String album_date, String album_dc) {
		super();
		this.album_code = album_code;
		this.album_title = album_title;
		this.artist_code = artist_code;
		this.album_image = album_image;
		this.album_date = album_date;
		this.album_dc = album_dc;
	}

	public String getAlbum_code() {
		return album_code;
	}

	public void setAlbum_code(String album_code) {
		this.album_code = album_code;
	}

	public String getAlbum_title() {
		return album_title;
	}

	public void setAlbum_title(String album_title) {
		this.album_title = album_title;
	}

	public String getArtist_code() {
		return artist_code;
	}

	public void setArtist_code(String artist_code) {
		this.artist_code = artist_code;
	}

	public String getAlbum_image() {
		return album_image;
	}

	public void setAlbum_image(String album_image) {
		this.album_image = album_image;
	}

	public String getAlbum_date() {
		return album_date;
	}

	public void setAlbum_date(String album_date) {
		this.album_date = album_date;
	}

	public String getAlbum_dc() {
		return album_dc;
	}

	public void setAlbum_dc(String album_dc) {
		this.album_dc = album_dc;
	}

	@Override
	public String toString() {
		return "albumDTO [album_code=" + album_code + ", album_title="
				+ album_title + ", artist_code=" + artist_code
				+ ", album_image=" + album_image + ", album_date=" + album_date
				+ ", album_dc=" + album_dc + "]";
	}
	
	

}
