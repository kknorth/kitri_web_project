package com.blocko.dto;

public class MusicStampDTO {
	String music;
	String user;
	String Timestamp;
	String musicHash;
	
	public MusicStampDTO(){}
	public MusicStampDTO(String music, String user, String timestamp,
			String strHash) {
		super();
		this.music = music;
		this.user = user;
		this.Timestamp = timestamp;
		this.musicHash = strHash;
	}
	@Override
	public String toString() {
		return "MusicStampDTO [music=" + music + ", user=" + user
				+ ", Timestamp=" + Timestamp + ", strHash=" + musicHash + "]";
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
	public String getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(String timestamp) {
		Timestamp = timestamp;
	}
	public String getMusicHash() {
		return musicHash;
	}
	public void setMusicHash(String musicHash) {
		this.musicHash = musicHash;
	}
	
}
