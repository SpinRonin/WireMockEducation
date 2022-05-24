import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

class Mock {

    //включаем Response Templating для получения данных из запроса (request.body) (request.query)
    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    //метод для конфигурации мок-сервиса
    private static WireMockConfiguration configure() {
        return WireMockConfiguration.wireMockConfig()
                .extensions(new ResponseTemplateTransformer(true));
    }

    public static void setUp() throws FileNotFoundException, UnsupportedEncodingException { //в данном методе настраивается мок сервер

        //настройка запроса get
        stubFor(get(urlPathMatching("/mock/get_employee"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\": \"227\" , \"fio\": \"Оби Ван Кеноби\", \"position\": \"Магистр-джедай\", \"number\": \"1\" }")));

        //настройка запроса delete
        stubFor(delete(urlPathMatching("/mock/delete_employee"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\": \"{{capitalize request.query.id}}\" , \"status\": \"DELETED\"}")));

        //настройка запроса post
        stubFor(post(urlPathMatching("/mock/create_employee"))
                .willReturn(aResponse()
                        .withStatus(201)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"fio\": \"{{jsonPath request.body '$.fio'}}\" , \"position\": \"{{jsonPath request.body '$.position'}}\", \"number\": \"{{jsonPath request.body '$.number'}}\", \"id\": \"{{randomValue type='UUID'}}\" }")));

        //скачивание файла
        stubFor(get(urlEqualTo("/mock/downloadFile"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBodyFile("the-file-name.txt")));

        //Headers в запросе и авторизация
        stubFor(post("/mock/resource")
                .withHeader("Content-Type", equalTo("application/xml"))
                .withBasicAuth("login", "password")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>Maybe try another header?</response>")));
        stubFor(post("/mock/resource")
                .withHeader("Content-Type", equalTo("application/json"))
                .withBasicAuth("login", "password")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"Yoda message\": \"Many things to learn you have!\"}")));

    }

    //запуск мок сервера, настройка порта через метод сonfigure
    public static void main(String[] args) throws Exception {
        WireMockServer wireMockServer = new WireMockServer(configure().port(8008));
        wireMockServer.start();
        WireMock.configureFor("localhost", 8008);
        setUp();
    }

}
