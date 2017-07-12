package com.comment.dto;

import java.sql.Timestamp;

public class BDto {

	int artist_code;
	String name;
	String title;
	String content;
	Timestamp fmdate;
	int hit;
	int group;
	int Step;
	int Indent;
	
	public BDto() {
		// TODO Auto-generated constructor stub
	}

	public BDto(int artist_code, String name, String title, String content,
			Timestamp fmdate, int hit, int group, int step, int indent) {
		super();
		this.artist_code = artist_code;
		this.name = name;
		this.title = title;
		this.content = content;
		this.fmdate = fmdate;
		this.hit = hit;
		this.group = group;
		Step = step;
		Indent = indent;
	}

	public int getArtist_code() {
		return artist_code;
	}

	public void setArtist_code(int artist_code) {
		this.artist_code = artist_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getFmdate() {
		return fmdate;
	}

	public void setFmdate(Timestamp fmdate) {
		this.fmdate = fmdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int getStep() {
		return Step;
	}

	public void setStep(int step) {
		Step = step;
	}

	public int getIndent() {
		return Indent;
	}

	public void setIndent(int indent) {
		Indent = indent;
	}
	
	
	
}
