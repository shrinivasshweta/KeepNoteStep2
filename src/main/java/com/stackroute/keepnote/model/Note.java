package com.stackroute.keepnote.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * The class "Note" will be acting as the data model for the note Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 */
@Entity
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int noteId;
	 @Column(nullable = false)
	private String noteTitle;
	 @Column(nullable = false)
	private String noteContent;
	 @Column(nullable = false)
	private String noteStatus;
	private LocalDateTime createdAt;



	/* All the getters/setters definition should be implemented here */
	public Note() {
		
	}
	
	public Note(int noteId, String noteTitle, String noteContent, String noteStatus, LocalDateTime createdAt) {
		super();
		this.noteId = noteId;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
		this.noteStatus = noteStatus;
		this.createdAt = createdAt;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContext) {
		this.noteContent = noteContext;
	}

	public String getNoteStatus() {
		return noteStatus;
	}

	public void setNoteStatus(String noteStatus) {
		this.noteStatus = noteStatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public boolean equals (Object o) {
	    if (!(o instanceof Note)) {
	        return false;
	    }
	    Note note = (Note)o;
	    return getNoteId()==note.getNoteId() &&
	           getNoteTitle().equals(note.getNoteTitle()) &&
	           getNoteContent().equals(note.getNoteContent())&&
	           getNoteStatus().equals(note.getNoteStatus());
	}
	
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result=1;
	    result = prime * result + Integer.toString(getNoteId()).hashCode();
	    result = prime * result + getNoteTitle().hashCode();
	    result = prime * result + getNoteContent().hashCode();
	    return result;
	}
}