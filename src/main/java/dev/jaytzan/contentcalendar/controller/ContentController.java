package dev.jaytzan.contentcalendar.controller;


import dev.jaytzan.contentcalendar.model.Content;
import dev.jaytzan.contentcalendar.model.Status;
import dev.jaytzan.contentcalendar.repository.ContentCollectionRepository;
import dev.jaytzan.contentcalendar.repository.ContentSpingDataRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/controller")
@CrossOrigin
public class ContentController {
    // private final ContentCollectionRepository repository; // final:: once create it 's done

    private final ContentSpingDataRepository repositorySD;

    public ContentController(ContentCollectionRepository repository, ContentSpingDataRepository rSD) {
      //  this.repository = repository;
        this.repositorySD = rSD;
    }

    // make a request and find all the pieces of content in the system
    @GetMapping("")
    public List<Content> findAll() {
        return repositorySD.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repositorySD.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d'T'HH:mm:ss");


        Content newC = new Content(
                content.id(),
                content.title(),
                content.desc(),
                content.status(),
                content.contentType(),
                content.dateCreated(),
                content.dateUpdated(),
                content.url()
        );
        repositorySD.save(newC);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content,@PathVariable Integer id){
        if(!repositorySD.existsById(id))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ContentNot found!");
        }
        repositorySD.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void update(@PathVariable Integer id){
        repositorySD.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> fondByTitle(@PathVariable String keyword){
        return repositorySD.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status){
        return repositorySD.listByStatus(status);
    }
}
