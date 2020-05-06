package com.bridgelabz.fundoo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "notesfundo")
public class Notes {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="noteId")
	long noteId;
	 @Column(name="title")
	String title;
	@Column(name="desription")
	String desription;

	@Override
	public String toString() {
		return "Notes [id=" + noteId + ", title=" + title + ", desription=" + desription + "]";
	}

	// @Column
	/*
	 * private int isArchieved;
	 * 
	 * @Column private int isPinned;
	 * 
	 * @Column private int isTrashed;
	 * 
	 * @Column private LocalDateTime createdDateAndTime;
	 * 
	 * @Column private LocalDateTime upDateAndTime;
	 * 
	 * @Column private String colour;
	 * 
	 * @Column private String reminder;
	 */
	
	public String getTitle() {
		return title;
	}

	public long getNoteId() {
		return noteId;
	}

	public void setNoteId(long id) {
		this.noteId = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Label> listLabel;
	public List<Label> getListLabel() {
		return listLabel;
	}

	public void setListLabel(List<Label> listLabel) {
		this.listLabel = listLabel;
	}
}
