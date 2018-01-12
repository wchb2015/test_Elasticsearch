import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class TestClient {

    private static final Logger LOG = LoggerFactory.getLogger(TestClient.class);

    private final static JestClient client;

    private final static String ES_SERVER_URIS = "http://10.103.106.232:9200";

    static {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder(Arrays.asList(ES_SERVER_URIS.trim().split(",")))
                .multiThreaded(true)
                .readTimeout(300000)
                .build());
        client = factory.getObject();
    }

    @Test
    public void testClient() {
        LOG.info("client:{}", client);
    }

    @Test
    public void testExecuteSearch() {

    }

}
