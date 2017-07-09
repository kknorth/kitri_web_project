package com.fairmusic.artist.service;

import com.fairmusic.dto.artistDTO;

interface ArtistService {

	int regist(artistDTO artist);
	boolean emailCheck(String email);
	artistDTO login(String email, String pass);
	int pass_update(String email, String newPass);
}
