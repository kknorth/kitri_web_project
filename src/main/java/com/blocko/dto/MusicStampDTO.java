package com.blocko.dto;

import java.util.Date;

public class MusicStampDTO {
	String id;
	String musicName;
	String musicHash;
	String stampId;
	String txId;
	Date Timestamp;
	
	public MusicStampDTO(){}

	public MusicStampDTO(String id, String musicName, String musicHash,
			String stampId, String txId, Date timestamp) {
		super();
		this.id = id;
		this.musicName = musicName;
		this.musicHash = musicHash;
		this.stampId = stampId;
		this.txId = txId;
		Timestamp = timestamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getMusicHash() {
		return musicHash;
	}

	public void setMusicHash(String musicHash) {
		this.musicHash = musicHash;
	}

	public String getStampId() {
		return stampId;
	}

	public void setStampId(String stampId) {
		this.stampId = stampId;
	}

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public Date getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}
	
}
