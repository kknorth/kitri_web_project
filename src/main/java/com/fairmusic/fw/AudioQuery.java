package com.fairmusic.fw;

public class AudioQuery {

	public static String audioinsert ="insert into fm_audio values(?,?,?,?,?,?,?,?,?,sysdate,?,?,?)";
	public static String select_audio= "select * from fm_audio where audio_code = ?";
	public static String select_audiolist = "select * from fm_audio where artist_code = ?";
}
