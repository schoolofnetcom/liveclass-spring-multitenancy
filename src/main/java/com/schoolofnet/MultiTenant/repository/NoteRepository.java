package com.schoolofnet.MultiTenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolofnet.MultiTenant.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
