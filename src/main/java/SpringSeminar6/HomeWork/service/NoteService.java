package SpringSeminar6.HomeWork.service;

import SpringSeminar6.HomeWork.model.Note;
import SpringSeminar6.HomeWork.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public Note addNote(Note note){
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id){
        return noteRepository.findById(id).orElseThrow(null);
    }

    public Note updateNote(Note note){
        Note noteById = getNoteById(note.getId());
        noteById.setDescription(note.getDescription());
        noteById.setTitle(note.getTitle());
        noteById.setLocal_date_time(LocalDateTime.now());
        return noteRepository.save(noteById);
    }

    public void deleteNoteById(Long id){
        noteRepository.deleteById(id);
    }
}
