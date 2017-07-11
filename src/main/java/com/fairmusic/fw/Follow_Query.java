package com.fairmusic.fw;

public class Follow_Query {

		public static String FOLLOW_CHECK
		= "select * from fm_follow where artist_code = ? and artist_follow_code= ?";
		
		public static String FOLLOW_INSERT
		="insert into fm_follow values(?,?,1)";
		
		public static String FOLLOW_UNFOLLOW
		="update fm_follow set follow_good_alive=0 where artist_code = ? and artist_follow_code = ?";
		
		public static String FOLLOW_REFOLLOW
		="update fm_follow set follow_good_alive=1 where artist_code = ? and artist_follow_code = ?";
		
		public static String FOLLOW_SEARCH_FOLLOWING
		="select * from fm_follow where follow_good_alive=1 and artist_code= ?";
		
		public static String FOLLOW_SEARCH_FOLLOWER
		="select * from fm_follow where follow_good_alive=1 and artist_follow_code = ?";
}
