package tt.hashtranslator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tt.hashtranslator.config.HashApiProperties;
import tt.hashtranslator.model.HashApiRequest;
import tt.hashtranslator.model.HashApiResponse;
import tt.hashtranslator.model.WordApiRequest;
import tt.hashtranslator.model.WordApiResponse;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
public class HashApiService {
    private final HashApiProperties properties;

    @Autowired
    public HashApiService(HashApiProperties properties) {
        this.properties = properties;
    }

    public String getWordFromApi(String hash) throws IOException {
        HashApiRequest request = createHashApiRequest(hash);
        HashApiResponse response = getHashApiResponse(request);
        return response.word();
    }

    public String generateHashFromApi(String word) throws IOException {
        WordApiRequest request = createWordApiRequest(word);
        WordApiResponse response = getWordApiResponse(request);
        return response.hash();
    }

    private HashApiRequest createHashApiRequest(String hash) {
        String url = properties.getUrl();
        String hashType = properties.getHashType();
        String email = properties.getEmail();
        String code = properties.getCode();
        return new HashApiRequest(url, hash, hashType, email, code);
    }

    private WordApiRequest createWordApiRequest(String word) {
        String url = properties.getUrl();
        String hashType = properties.getHashType();
        String email = properties.getEmail();
        String code = properties.getCode();
        return new WordApiRequest(url, word, hashType, email, code);
    }

    private HashApiResponse getHashApiResponse(HashApiRequest request) throws IOException {
        String apiUrl = request.getUrl();
        Map<String, String> params = request.getParams();
        String requestUrl = createFullApiUrl(apiUrl, params);
        String word = HttpRequestService.makeGetRequest(requestUrl);
        return new HashApiResponse(word);
    }

    private WordApiResponse getWordApiResponse(WordApiRequest request) throws IOException {
        String apiUrl = request.getUrl();
        Map<String, String> params = request.getParams();
        String requestUrl = createFullApiUrl(apiUrl, params);
        String hash = HttpRequestService.makeGetRequest(requestUrl);
        return new WordApiResponse(hash);
    }

    private String createFullApiUrl(String apiUrl, Map<String, String> params) {
        StringBuilder fullApiUrl = new StringBuilder(apiUrl + "?");
        for (Map.Entry<String, String> param: params.entrySet()) {
            fullApiUrl.append(param.getKey()).append('=').append(param.getValue()).append('&');
        }
        fullApiUrl.deleteCharAt(fullApiUrl.lastIndexOf("&"));
        return fullApiUrl.toString();
    }
}
