package main;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.List;


public class Main {
    public static final String URL = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {

        final CloseableHttpClient httpClient = HttpClients.createDefault();//создаем клиент

        final HttpUriRequest httpGet = new HttpGet(URL);

        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {

            List<PostFactsAboutCats> post = mapper.readValue(response.getEntity().getContent(),
                    new TypeReference<>() {
                    });

            post.stream()
                    .filter(value -> value.getUpvotes() > 0)
                    .forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
