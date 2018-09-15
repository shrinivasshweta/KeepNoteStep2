package com.stackroute.keepnote.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.keepnote.model.Note;

/*
 * This class is implementing the NoteDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus 
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */
@Repository
@Transactional
public class NoteDAOImpl implements NoteDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */
	@Autowired
	SessionFactory sessionFactory;
	
	public NoteDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Save the note in the database(note) table.
	 */

	public boolean saveNote(Note note) {
		sessionFactory.getCurrentSession().save(note);
		sessionFactory.getCurrentSession().flush();
		return true;
	}

	/*
	 * Remove the note from the database(note) table.
	 */

	public boolean deleteNote(int noteId) {
		if(getNoteById(noteId)==null) {
			return false;
		} else {
			sessionFactory.getCurrentSession().delete(getNoteById(noteId));
			sessionFactory.getCurrentSession().flush();
			return true;
		}
	}

	/*
	 * retrieve all existing notes sorted by created Date in descending
	 * order(showing latest note first)
	 */
	@SuppressWarnings("unchecked")
	public List<Note> getAllNotes() {
		String hql = "FROM Note note ORDER BY note.createdAt DESC";
		Query query = getSessionFactory().openSession().createQuery(hql);
		return query.getResultList();

	}

	/*
	 * retrieve specific note from the database(note) table
	 */
	public Note getNoteById(int noteId) {
		Note note = (Note)sessionFactory.getCurrentSession().get(Note.class, noteId);
		sessionFactory.getCurrentSession().flush();
		return note;
	}

	/* Update existing note */

	public boolean UpdateNote(Note note) {
		if(getNoteById(note.getNoteId())==null) {
			return false;
		} else {
			sessionFactory.getCurrentSession().clear();
			sessionFactory.getCurrentSession().update(note);
			sessionFactory.getCurrentSession().flush();
			return true;
		}
	}

}
