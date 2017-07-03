package com.fairmusic.album.service;

import com.fairmusic.album.dao.AlbumDAO;
import com.fairmusic.album.dao.AlbumDAOimpl;
import com.fairmusic.dto.albumDTO;

public class AlbumServiceimpl implements AlbumService{

	@Override
	public int createAlbum(albumDTO album) {
		
		AlbumDAO dao = new AlbumDAOimpl();
			int result = dao.createAlbum(album);
			return result;
	}

	

}
