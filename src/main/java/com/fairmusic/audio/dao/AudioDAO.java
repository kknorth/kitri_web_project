package com.fairmusic.audio.dao;

import com.fairmusic.dto.audioDTO;

public interface AudioDAO {
	public int createAudio(audioDTO audio);
	public audioDTO selectAudio(String audio_code);
}
