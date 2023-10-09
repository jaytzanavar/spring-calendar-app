package dev.jaytzan.contentcalendar.repository;

import dev.jaytzan.contentcalendar.model.Content;
import dev.jaytzan.contentcalendar.model.Status;
import dev.jaytzan.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    // may or not contain value .nullValueException
    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content newContent) {
        contentList.removeIf(c->c.id().equals(newContent.id()));
        contentList.add(newContent);
    }

    public boolean existsById(Integer id){
        return contentList.stream().filter(c-> c.id().equals((id))).count() ==1;
    }

    public void delete( Integer id){
         contentList.removeIf(c -> c.id().equals(id));
    }

    @PostConstruct
    private void init() {
        Content c = new Content(1, "my first blog post", "my firs blog post", Status.IDEA, Type.ARTICLE, null, null, "");

        contentList.add(c);
    }

}
