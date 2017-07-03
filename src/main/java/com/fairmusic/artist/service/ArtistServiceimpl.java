package com.fairmusic.artist.service;

import com.fairmusic.artist.dao.ArtistDAOimpl;
import com.fairmusic.dto.artistDTO;

public class ArtistServiceimpl implements ArtistService{

	@Override
	public int regist(artistDTO artist) {
		ArtistDAOimpl dao = new ArtistDAOimpl();
		int result = dao.regist(artist);
		return result;
	}

}
