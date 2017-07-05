package com.fairmusic.fw;

public class Query {

		public static String EMAIL_CHECK
		= "select * from fm_artist where artist_email = ?";
		public static String EMP_login
		= "select * from fm_artist where artist_email = ? and artist_pass =? ";
}
