package com.fairmusic.audio.dao;

import java.util.ArrayList;

import com.fairmusic.dto.audioDTO;

public interface AudioDAO {
	public int createAudio(audioDTO audio);
	public audioDTO selectAudio(String audio_code);
	public ArrayList<audioDTO> myAudioList(String artist_code);
}
