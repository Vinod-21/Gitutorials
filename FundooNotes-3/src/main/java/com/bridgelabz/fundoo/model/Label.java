package com.bridgelabz.fundoo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "userlabel")
public class Label {
	@Id
	@Column(name = "label_id")
	private long labelId;

	@Column(name = "label_name")
	private String labelName;

	@Column(name = "created")
	private LocalDateTime created;

	@Column(name = "modified")
	private LocalDateTime modified;

// 	private long userId;

	public Label() {
		super();
	}

	public long getLabelId() {
		return labelId;
	}

	public void setLabelId(long labelId) {
		this.labelId = labelId;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	/*
	 * public long getUserId() { return userId; }
	 * 
	 * public void setUserId(long userId) { this.userId = userId; }
	 */

	@Override
	public String toString() {
		return "Label [labelId=" + labelId + ", labelName=" + labelName + ", created=" + created + ", modified="
				+ modified + "]";
	}

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Notes> Notes;

	public List<Notes> getNotes() {
		return Notes;
	}

	public void setNotes(List<Notes> notes) {
		Notes = notes;
	}

}
