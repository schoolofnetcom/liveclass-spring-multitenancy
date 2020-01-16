package com.schoolofnet.MultiTenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolofnet.MultiTenant.model.Note;
import com.schoolofnet.MultiTenant.service.NoteService;

@RestController
@RequestMapping("/notes")
public class NotesController {
	
	@Autowired
	private NoteService noteService;
	
	public NotesController(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@GetMapping
	public List<Note> findAll() {
		return noteService.findAll();
	}
	
	@PostMapping
	public Note create(@RequestBody Note note) {
		return noteService.create(note);
	}
}
