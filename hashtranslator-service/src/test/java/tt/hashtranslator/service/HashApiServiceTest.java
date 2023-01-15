package tt.hashtranslator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class HashApiServiceTest {
    private final HashApiService service;

    @Autowired
    public HashApiServiceTest(HashApiService service) {
        this.service = service;
    }

    @Test
    public void getWordFromApi() throws IOException {
        String hash = "5f4dcc3b5aa765d61d8327deb882cf99";
        String word = service.getWordFromApi(hash);
        assertEquals("password", word);
    }

    @Test
    public void generateHashFromApi() throws IOException {
        String word = "periperi222";
        String hash = service.generateHashFromApi(word);
        assertEquals("265b8ddc0aadd705a580d6637a66676a", hash);
    }
}
