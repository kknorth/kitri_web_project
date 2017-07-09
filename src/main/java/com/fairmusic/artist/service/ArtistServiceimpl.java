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


	@Override
	public boolean emailCheck(String email) {
		ArtistDAOimpl dao = new ArtistDAOimpl();
		boolean result = dao.emailCheck(email);
		return result;
	}



	@Override
	public artistDTO login(String email, String pass) {
		ArtistDAOimpl dao = new ArtistDAOimpl();
		artistDTO dto = dao.login(email, pass);
		return dto;
	}


	@Override
	public int pass_update(String email, String newPass) {
		ArtistDAOimpl dao = new ArtistDAOimpl();
		int result = dao.pass_update(email, newPass);
		return result;
	}

}
	


