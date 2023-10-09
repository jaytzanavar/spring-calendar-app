package dev.jaytzan.contentcalendar.repository;

import dev.jaytzan.contentcalendar.model.Content;
import dev.jaytzan.contentcalendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ContentSpingDataRepository extends ListCrudRepository<Content, Integer> {

    List<Content> findAllByTitleContains(String keyword);

    @Query("""
            SELECT * FROM CONTENT
            WHERE STATUS = :status
            """)
    List<Content> listByStatus(@Param("status") Status status);
}
