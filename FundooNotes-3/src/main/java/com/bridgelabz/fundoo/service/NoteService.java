package com.bridgelabz.fundoo.service;

import com.bridgelabz.fundoo.dto.NotesDto;
import com.bridgelabz.fundoo.model.Notes;

public interface NoteService {

	public int insertNote(NotesDto note,String token);
}
