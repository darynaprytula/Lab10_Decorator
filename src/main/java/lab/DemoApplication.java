package lab;

import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import java.util.stream.Stream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

    private static final int LIMIT = 10;

    public static void main(final String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Kyiv"));
        SpringApplication.run(DemoApplication.class, args);
        
    }

    @GetMapping("/list")
    public List<String> getRandomUUIDs() {
        return Stream.generate(UUID::randomUUID)
                .map(UUID::toString)
                .limit(LIMIT)
                .toList();
    }
}
