package com.schoolofnet.MultiTenant.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolofnet.MultiTenant.model.Note;
import com.schoolofnet.MultiTenant.repository.NoteRepository;

@Service
public class NoteService {

	@PersistenceContext
	public EntityManager entityManager;
	@Autowired
	private NoteRepository noteRepository;
	
	public NoteService(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}
	
	public List<Note> findAll() {
		return noteRepository.findAll();
	}
	
	public Note create(Note note) {
		return noteRepository.save(note);
	}
}

/**
 *                   NOTES
 * ID     TITLE                  TENANT_ID
 * 1      Note 1     1/LEONAN/!#@!*DGHASD/12312SADasdb43j
 * 2      Note 2     2/LUIZ/!#@!*DGHASD/12312SADasdb23b
 * 
 *                   HEADERS
 * Authorization TOKEN
 * X-Tenant      1/LEONAN/!#@!*DGHASD/12312SADasdb43j
 */

/**
 * Request do usuário ->
 * Identificação do header ->
 * Formação do contexto (TenantContext) ->
 * Execução e validação do filtro na model ->
 * Execução do método requisitado ->
 * Resposta ao usuário /
 */