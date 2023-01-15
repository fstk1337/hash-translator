package tt.hashtranslator.model;

import java.util.Map;

public class WordApiRequest {
    private final String url;
    private final Map<String, String> params;

    public WordApiRequest(String url, String word, String hashType, String email, String code) {
        this.url = url;
        this.params = storeParams(word, hashType, email, code);
    }

    private Map<String, String> storeParams(String word, String hashType, String email, String code) {
        return Map.of("word", word, "hash_type", hashType, "email", email, "code", code);
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getParams() {
        return params;
    }
}
