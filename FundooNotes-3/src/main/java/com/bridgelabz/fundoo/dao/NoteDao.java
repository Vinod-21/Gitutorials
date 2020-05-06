package com.bridgelabz.fundoo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.fundoo.dto.NotesDto;
import com.bridgelabz.fundoo.model.Notes;

public interface NoteDao extends JpaRepository<Notes, Long> {


	int insertNote(Notes note);
		
	
}
