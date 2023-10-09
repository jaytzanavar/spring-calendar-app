package dev.jaytzan.contentcalendar.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.jaytzan.contentcalendar.model.Content;
import dev.jaytzan.contentcalendar.repository.ContentCollectionRepository;
import dev.jaytzan.contentcalendar.repository.ContentSpingDataRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.InputStream;
import java.util.List;

//@Profile("!dev")
@Component
public class DataLoader implements CommandLineRunner {

    private  final ContentSpingDataRepository sdRepo;
    private final ObjectMapper objectMapper; // create objects out of json deserialize obj from json

    public DataLoader(ContentSpingDataRepository sdRepo, ObjectMapper objectMapper) {
        this.sdRepo = sdRepo;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Run mofo 😎");

        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")){
            sdRepo.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>() {
            }));
        }
    }
}
