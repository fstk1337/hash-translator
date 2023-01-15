package tt.hashtranslator.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "hashtranslator.api")
@Data
public class HashApiProperties {
    private String url;
    private String hashType;
    private String email;
    private String code;
}

// password
// https://md5decrypt.net/en/Api/api.php?hash=5f4dcc3b5aa765d61d8327deb882cf99&hash_type=md5&email=vit.shvaichuk@gmail.com&code=789366955397009f


// 265b8ddc0aadd705a580d6637a66676a
// https://md5decrypt.net/en/Api/api.php?word=periperi222&hash_type=md5&email=vit.shvaichuk@gmail.com&code=789366955397009f
