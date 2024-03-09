package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.Note;
import org.example.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteServiceImplement implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Long id, Note note) {
        //получение заметки по id
        Note noteById = getNoteById(id);
        //обновление названия заметки
        noteById.setTitle(note.getTitle());
        //обновление текста заметки
        noteById.setContent(note.getContent());
        //сохранение обновленной заметки
        return noteRepository.save(noteById);
    }
    @Override
    public void deleteNoteById(Long id) {
        Note noteById = getNoteById(id);
        noteRepository.delete(noteById);
    }
}
