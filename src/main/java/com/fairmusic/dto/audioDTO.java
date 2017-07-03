package com.fairmusic.dto;

import java.sql.Date;

public class audioDTO {
	
	private String audio_code;
	private String audio_title;
	private String artist_code;
	private String audio_jenre;
	private String audio_image;
	private String audio_detail;
	private String album_code;
	private Date audio_date;
	private String audio_link;
	private String audio_price;
	private String audio_copyrighter;


	public audioDTO(){
		
	}


	public audioDTO(String audio_code, String audio_title, String artist_code,
			String audio_jenre, String audio_image, String audio_detail,
			String album_code, Date audio_date, String audio_link,
			String audio_price, String audio_copyrighter) {
		super();
		this.audio_code = audio_code;
		this.audio_title = audio_title;
		this.artist_code = artist_code;
		this.audio_jenre = audio_jenre;
		this.audio_image = audio_image;
		this.audio_detail = audio_detail;
		this.album_code = album_code;
		this.audio_date = audio_date;
		this.audio_link = audio_link;
		this.audio_price = audio_price;
		this.audio_copyrighter = audio_copyrighter;
	}


	public String getAudio_code() {
		return audio_code;
	}


	public void setAudio_code(String audio_code) {
		this.audio_code = audio_code;
	}


	public String getAudio_title() {
		return audio_title;
	}


	public void setAudio_title(String audio_title) {
		this.audio_title = audio_title;
	}


	public String getArtist_code() {
		return artist_code;
	}


	public void setArtist_code(String artist_code) {
		this.artist_code = artist_code;
	}


	public String getAudio_jenre() {
		return audio_jenre;
	}


	public void setAudio_jenre(String audio_jenre) {
		this.audio_jenre = audio_jenre;
	}


	public String getAudio_image() {
		return audio_image;
	}


	public void setAudio_image(String audio_image) {
		this.audio_image = audio_image;
	}


	public String getAudio_detail() {
		return audio_detail;
	}


	public void setAudio_detail(String audio_detail) {
		this.audio_detail = audio_detail;
	}


	public String getAlbum_code() {
		return album_code;
	}


	public void setAlbum_code(String album_code) {
		this.album_code = album_code;
	}


	public Date getAudio_date() {
		return audio_date;
	}


	public void setAudio_date(Date audio_date) {
		this.audio_date = audio_date;
	}


	public String getAudio_link() {
		return audio_link;
	}


	public void setAudio_link(String audio_link) {
		this.audio_link = audio_link;
	}


	public String getAudio_price() {
		return audio_price;
	}


	public void setAudio_price(String audio_price) {
		this.audio_price = audio_price;
	}


	public String getAudio_copyrighter() {
		return audio_copyrighter;
	}


	public void setAudio_copyrighter(String audio_copyrighter) {
		this.audio_copyrighter = audio_copyrighter;
	}


	@Override
	public String toString() {
		return "audioDTO [audio_code=" + audio_code + ", audio_title="
				+ audio_title + ", artist_code=" + artist_code
				+ ", audio_jenre=" + audio_jenre + ", audio_image="
				+ audio_image + ", audio_detail=" + audio_detail
				+ ", album_code=" + album_code + ", audio_date=" + audio_date
				+ ", audio_link=" + audio_link + ", audio_price=" + audio_price
				+ ", audio_copyrighter=" + audio_copyrighter + "]";
	}
	
	
	
}
