package dev.jaytzan.contentcalendar;

import dev.jaytzan.contentcalendar.config.ContentCalendarProperties;
import dev.jaytzan.contentcalendar.model.Content;
import dev.jaytzan.contentcalendar.model.Status;
import dev.jaytzan.contentcalendar.model.Type;
import dev.jaytzan.contentcalendar.repository.ContentSpingDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Arrays;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

     //   String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";

//        try {
//            Connection conn = DriverManager.getConnection(jdbcUrl, "postgres", "password");
//
//            if (!conn.isValid(0)) {
//                System.out.println("Unable to connect to db");
//                System.exit(0);
//            }
//
//            PreparedStatement preparedStatement = conn.prepareStatement(("select * from run"));
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                String title = rs.getString("title");
//                int miles = rs.getInt("miles");
//                System.out.println(title + ": " + miles);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//
//        }
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
        // System.out.println(restTemplate);

        // restTemplate.getForEntity('www.google.com')
    }

//    @Bean
//    CommandLineRunner commandLineRunner(ContentSpingDataRepository repository){
//        return args -> {
//            // insert data into the database
//            Content c = new Content(null, "Chat GPT", "All About CHat GPT", Status.IDEA, Type.VIDEO, LocalDateTime.now(), null, "");
//            repository.save(c);
//        };
//
//
//    }

}
