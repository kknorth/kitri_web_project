package com.fairmusic.audio.service;

import com.fairmusic.dto.audioDTO;

public interface AudioService {
	
	public int createAudio(audioDTO audio);
	public audioDTO selectAudio(String audio_code);

}
