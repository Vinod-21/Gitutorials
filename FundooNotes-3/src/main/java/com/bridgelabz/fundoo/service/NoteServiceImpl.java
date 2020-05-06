package com.bridgelabz.fundoo.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bridgelabz.fundoo.configuration.JasonWebToken;
import com.bridgelabz.fundoo.dao.NoteDaoImpl;
import com.bridgelabz.fundoo.dto.NotesDto;
import com.bridgelabz.fundoo.model.Label;
import com.bridgelabz.fundoo.model.Notes;

@Component
public class NoteServiceImpl implements NoteService {

	@Autowired
	NoteDaoImpl noteDao;

	@Autowired
	JasonWebToken jwt;

	@Override
	@Transactional
	public int insertNote(NotesDto note, String token) {
		System.out.println("service insertNote got hitted");
		System.out.println(note.getTitle());
		int result = 0;

		long id = jwt.decodeJWT(token);

		Notes theNote = new Notes();
		BeanUtils.copyProperties(note, theNote);
		theNote.setTitle(note.getTitle());
		theNote.setDesription(note.getDescription());

		System.out.println("service notes starts");
		System.out.println(theNote);
		result = noteDao.insertNote(theNote);
		System.out.println("result is" + " ----->" + result);
		System.out.println("service notes end");
		if (result == 1) {
			return result;
		}
		return result;
	}

	@Transactional
	public Notes updateNote(Notes note) {
		Notes theNotes = noteDao.updateNote(note);
		System.out.println("printing service notes object!!!!!!!!!!!!!");
		System.out.println(theNotes);
		return theNotes;
	}

	@Transactional
	public void deleteNote(int id) {
		System.out.println("service of delete working");
		noteDao.deleteNote(id);
		System.out.println("delete of service executed");
	}

	@Transactional
	public Notes getById(int id) {
		System.out.println("getby id service impl method evoked");
		Notes n1 = noteDao.getById(id);
		System.out.println("printing now the object in serviceimpl class");
		System.out.println(n1);
		return n1;

	}

}
