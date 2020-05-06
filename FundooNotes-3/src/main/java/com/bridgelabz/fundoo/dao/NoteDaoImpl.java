 package com.bridgelabz.fundoo.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoo.dto.NotesDto;
import com.bridgelabz.fundoo.model.Notes;
import com.bridgelabz.fundoo.model.User;

@Repository
public class NoteDaoImpl implements NoteDao {
	@Autowired
	EntityManager entityManager;

	@Override
	public int insertNote(Notes theNote) {
		System.out.println("insertNote dao starts");
		System.out.println(theNote);
		int result = 0;
		Session session = entityManager.unwrap(Session.class);

		result = (int) session.save(theNote);
		if (result == 1) {

			return result;
		}

		return result;
	}

	public Notes getById(int id) {

		Session session = entityManager.unwrap(Session.class);
		Notes note = session.get(Notes.class, id);
		System.out.println("printing the note object");
		System.out.println(note);
		return note;

	}
	
	public Notes updateNote(Notes note) {
		
		Session session=entityManager.unwrap(Session.class);
		session.update(note);
		return note;
	}
	
	public void deleteNote(int id) {
		System.out.println("delete method of dao involkedd!!!!!!!!!!");
		Session session=entityManager.unwrap(Session.class);
		Notes theNotes=session.load(Notes.class, id);
		System.out.println("printing the theNotes from delete mehtod od dao");
		System.out.println(theNotes);
		session.delete(theNotes);
		System.out.println("delete of dao succedd");
		
		
	}

	@Override
	public List<Notes> findAll() {
		
		Session session = entityManager.unwrap(Session.class);
		Query<Notes> query = session.createQuery("FROM Notes", Notes.class);
		return query.getResultList();
	}

	@Override
	public List<Notes> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notes> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Notes> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Notes> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Notes> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Notes getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Notes> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Notes> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Notes> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Notes> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Notes> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Notes entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Notes> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Notes> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Notes> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Notes> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Notes> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
