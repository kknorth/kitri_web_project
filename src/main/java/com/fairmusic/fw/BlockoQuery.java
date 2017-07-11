package com.fairmusic.fw;

public class BlockoQuery {
	public static String STAMP_INSERT
	="insert into blockostamp values(?,?,?,?)";
	
	public static String STAMP_SELECT
	="select * from blockostamp where artist_code=? and audio_code= ?";
	
	public static String BITCOINADDR_INSERT
	="insert into bitcoinaddress values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static String BITCOINADDR_SELECT
	="select * from bitcoinaddress where artist_code= ?";
}
