import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetRequest {

    static String URL = "https://speller.yandex.net/services/spellservice";
    static String text = "кллиентская част веб сервеса";

    public static void main(String[] args) {
        CloseableHttpResponse response = null;

        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet get = new HttpGet(URL + "/checkText?text=" + text.replaceAll("\\s", "+"));
            response = client.execute(get);
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
