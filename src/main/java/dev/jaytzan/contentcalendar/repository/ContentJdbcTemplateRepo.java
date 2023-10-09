package dev.jaytzan.contentcalendar.repository;

import dev.jaytzan.contentcalendar.model.Content;
import dev.jaytzan.contentcalendar.model.Status;
import dev.jaytzan.contentcalendar.model.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ContentJdbcTemplateRepo {
    // JDBC you have to write the SQL
    private final JdbcTemplate jdbcTemplate;

    public ContentJdbcTemplateRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Content mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new Content(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("desc"),
                Status.valueOf(rs.getString("status")),
                Type.valueOf(rs.getString("content_type")),
                rs.getObject("date_created", LocalDateTime.class),
                rs.getObject("date_updated", LocalDateTime.class),
                rs.getString("url")
                );
    }

    public List<Content> getAllCOntent(){
        String sql="SELECT * FROM Content";
        List<Content> contents = jdbcTemplate.query(sql, ContentJdbcTemplateRepo::mapRow);
        return contents;
    }

    public List<Content> getAllContent() {
        String sql = "SELECT * FROM Content";
        List<Content> contents = jdbcTemplate.query(sql, ContentJdbcTemplateRepo::mapRow);
        return contents;
    }

    public void createContent(String title, String desc, Status status, Type contentType, String URL) {
        String sql = "INSERT INTO Content (title, desc, status, content_type, date_created, URL) VALUES (?, ?, ?, ?, NOW(), ?)";
        jdbcTemplate.update(sql, title, desc, status, contentType, URL);
    }

    public void updateContent(int id, String title, String desc, Status status, Type contentType, String URL) {
        String sql = "UPDATE Content SET title=?, desc=?, status=?, content_type=?, date_updated=NOW(), url=? WHERE id=?";
        jdbcTemplate.update(sql, title, desc, status, contentType, URL, id);
    }

    public void deleteContent(int id) {
        String sql = "DELETE FROM Content WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public Content getContent(int id) {
        String sql = "SELECT * FROM Content WHERE id=?";
        Content content = jdbcTemplate.queryForObject(sql, new Object[]{id}, ContentJdbcTemplateRepo::mapRow);
        return content;
    }


}
