package com.fairmusic.artist.dao;

import com.fairmusic.dto.artistDTO;

interface ArtistDAO {
	int regist(artistDTO artist);
	boolean emailCheck(String email);	
	artistDTO login(String email,String pass);
	int pass_update(String email, String newPass);
	artistDTO getArtistDTO(String artist_code);
}
