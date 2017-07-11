package com.fairmusic.album.service;

import java.util.ArrayList;

import com.fairmusic.dto.albumDTO;
import com.fairmusic.dto.audioDTO;

public interface AlbumService {
	public int createAlbum(albumDTO album);
	public ArrayList<albumDTO> myAlbumList(String artist_code);
}
