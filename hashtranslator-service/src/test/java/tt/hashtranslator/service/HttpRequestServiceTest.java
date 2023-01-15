package tt.hashtranslator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class HttpRequestServiceTest {

    @Test
    public void fakeStoreApiRequestTest() throws IOException {
        String url = "https://fakestoreapi.com/products/4";
        String response = HttpRequestService.makeGetRequest(url);
        assertEquals("{\"id\":4,\"title\":\"Mens Casual Slim Fit\",\"price\":15.99,\"description\":\"The color could be slightly different between on the screen and in practice. / Please note that body builds vary by person, therefore, detailed size information should be reviewed below on the product description.\",\"category\":\"men's clothing\",\"image\":\"https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg\",\"rating\":{\"rate\":2.1,\"count\":430}}", response);
    }

    @Test
    public void md5DecryptApiRequestTest() throws IOException {
        String url = "https://md5decrypt.net/en/Api/api.php?hash=5f4dcc3b5aa765d61d8327deb882cf99&hash_type=md5&email=vit.shvaichuk@gmail.com&code=789366955397009f";
        String response = HttpRequestService.makeGetRequest(url);
        assertEquals("password", response);
    }
}
