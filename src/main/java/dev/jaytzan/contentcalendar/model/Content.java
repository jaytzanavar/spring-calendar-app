package dev.jaytzan.contentcalendar.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

// @Table(value="tbl_content")
public record Content(@Id
                      Integer id,
                      @NotBlank
                      // @Column("str_title")
                      String title,
                      @Column(value="description")
                      String desc,

                      Status status,
                      Type contentType,
                      LocalDateTime dateCreated,
                      LocalDateTime dateUpdated,
                      String url
) {
}


// DTO class transfer DATA server vice versa

// Enity store retreive data from DATa store

// Pojo class doesnt extend any other framework code !!