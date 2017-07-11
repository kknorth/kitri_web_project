package com.fairmusic.audio.service;

import java.util.ArrayList;

import com.fairmusic.audio.dao.AudioDAO;
import com.fairmusic.audio.dao.AudioDAOimpl;
import com.fairmusic.dto.audioDTO;

public class AudioServiceimpl implements AudioService{

	@Override
	public int createAudio(audioDTO audio) {
		AudioDAO dao = new AudioDAOimpl();
		int result = dao.createAudio(audio);
		return result;
	}

	@Override
	public audioDTO selectAudio(String audio_code) {
		audioDTO dto = null;
		AudioDAO dao = new AudioDAOimpl();
		dto = dao.selectAudio(audio_code);
		return dto;
	}

	@Override
	public ArrayList<audioDTO> myAudioList(String artist_code) {
		AudioDAO dao = new AudioDAOimpl();
		ArrayList<audioDTO> dtolist = dao.myAudioList(artist_code);
		return dtolist;
	}

}
