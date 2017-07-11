package com.fairmusic.fw;

public class AlbumQuery {
	
	public static String albuminsert = "insert into fm_album values(?,?,?,?,sysdate,?,?,?)";
	public static String select_albumlist = "select * from fm_album where artist_code = ?";
}
