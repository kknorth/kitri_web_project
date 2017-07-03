package com.blocko.dto;

import java.util.Date;

public class MusicStampDTO {
	String music;
	String user;
	Date Timestamp;
	String musicHash;
	
	public MusicStampDTO(){}
	public MusicStampDTO(String music, String user, Date timestamp,
			String musicHash) {
		super();
		this.music = music;
		this.user = user;
		Timestamp = timestamp;
		this.musicHash = musicHash;
	}
	@Override
	public String toString() {
		return "MusicStampDTO [music=" + music + ", user=" + user
				+ ", Timestamp=" + Timestamp + ", musicHash=" + musicHash + "]";
	}
	public String getMusic() {
		return music;
	}
	public void setMusic(String music) {
		this.music = music;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Date getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}
	public String getMusicHash() {
		return musicHash;
	}
	public void setMusicHash(String musicHash) {
		this.musicHash = musicHash;
	}
	
	
}
