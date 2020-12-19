package com.bdg.demo.airportMgmtJPA;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Stream;

@Component
@Transactional
public class DataLoader {

    private static final String passengersFile = "/root_resource/passengers.txt";
    private static final String companiesFile = "/root_resource/companies.txt";
    private static final String tripsFile = "/root_resource/trips.txt";
    private static final String passengerTripsFile = "/root_resource/passengers_trips.txt";

    public static void loadFromCsv(ResourceLoader resourceLoader, String sourceCsvFile,
                                   Function<String[], Object> objectMapper, JpaRepository repo) {

        Resource resource = resourceLoader.getResource("classpath:" + sourceCsvFile);

        try (Stream<String> stream = Files.lines(Paths.get(resource.getFile().getAbsolutePath()))) {
            stream.forEach(line -> {
                try {
                    String[] values = line.split(",");
                    Object entity = objectMapper.apply(values);
                    repo.save(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
