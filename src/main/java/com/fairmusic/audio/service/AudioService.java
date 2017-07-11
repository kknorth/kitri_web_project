package com.fairmusic.audio.service;

import java.util.ArrayList;

import com.fairmusic.dto.audioDTO;

public interface AudioService {
	
	public int createAudio(audioDTO audio);
	public audioDTO selectAudio(String audio_code);
	public ArrayList<audioDTO> myAudioList(String artist_code);
}
