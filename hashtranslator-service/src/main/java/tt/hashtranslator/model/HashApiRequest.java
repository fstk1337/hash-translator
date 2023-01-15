package tt.hashtranslator.model;

import java.util.Map;

public class HashApiRequest {
    private final String url;
    private final Map<String, String> params;

    public HashApiRequest(String url, String hash, String hashType, String email, String code) {
        this.url = url;
        this.params = storeParams(hash, hashType, email, code);
    }

    private Map<String, String> storeParams(String hash, String hashType, String email, String code) {
        return Map.of("hash", hash, "hash_type", hashType, "email", email, "code", code);
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getParams() {
        return params;
    }
}

