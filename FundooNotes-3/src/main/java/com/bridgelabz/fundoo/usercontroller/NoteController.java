package com.bridgelabz.fundoo.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoo.dao.NoteDaoImpl;
import com.bridgelabz.fundoo.dto.NotesDto;
import com.bridgelabz.fundoo.model.Notes;
import com.bridgelabz.fundoo.responses.NoteResponse;
import com.bridgelabz.fundoo.service.NoteServiceImpl;

@RestController
public class NoteController {

	@Autowired
	NoteServiceImpl noteService;

	@Autowired
	private Environment env;

	@PostMapping("/saveNote")
	public ResponseEntity<NoteResponse> createNote(@RequestBody NotesDto noteDto, @RequestHeader String token) {
System.out.println("notes createNote executed");
		ResponseEntity<NoteResponse> result;

		int res = noteService.insertNote(noteDto,token);

		if (res == 1) {
			result = ResponseEntity.status(HttpStatus.CREATED)
					.body(new NoteResponse(env.getProperty("201"), res, 200));
			return result;
		} else {
			result = ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
					.body(new NoteResponse(env.getProperty("102"), res, 401));
			return result;
		}

	}

	@PostMapping("/updateNote")
	public ResponseEntity<NoteResponse> updateNote(Notes note) {

		Notes theNotes = noteService.updateNote(note);

		return ResponseEntity.status(HttpStatus.CREATED).body(new NoteResponse(env.getProperty("201"), theNotes, 200));

	}

	@DeleteMapping("/deleteNote")
	public ResponseEntity<NoteResponse> deleteNote(Notes note, int id) {
		int res = id;
		if (res != 0) {
			noteService.deleteNote(id);
			ResponseEntity.status(HttpStatus.CREATED).body(new NoteResponse(env.getProperty("201"), note, 200));
		}
		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
				.body(new NoteResponse(env.getProperty("102"), note, 401));

	}

	@GetMapping("/getNote")
	public ResponseEntity<NoteResponse> getById(Notes note) {
		int id = (int) note.getNoteId();
		Notes theNotes = noteService.getById(id);
		if (theNotes != null) {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new NoteResponse(env.getProperty("201"), theNotes, 200));
		}
		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
				.body(new NoteResponse(env.getProperty("102"), theNotes, 401));

	}

}
