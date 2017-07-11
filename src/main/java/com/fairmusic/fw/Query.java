package com.fairmusic.fw;

public class Query {

		public static String EMAIL_CHECK
		= "select * from fm_artist where artist_email = ?";
		public static String EMP_login
		= "select * from fm_artist where ARTIST_EMAIL = ? and ARTIST_PASS =?";
		public static String Pass_update
		= "update fm_artist set artist_pass=? where artist_email=?";
		public static String Select_Artist
	      = "select * from fm_artist where artist_code = ?";
}

