package com.example.giphyspring.Service;

import java.io.StringReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class GiphyService {

    @Value("${giphy.url}")
    private String giphyUrl;

    @Value("${giphy.api.key}")
    private String giphyApiKey;

    public List<String> getGif(String gifName, Integer limit, Integer offset) {

        String gifUrl = UriComponentsBuilder.fromUriString(giphyUrl)
                .queryParam("q", gifName)
                .queryParam("api_key", giphyApiKey)
                .queryParam("limit", limit)
                .queryParam("offset", offset)
                .toUriString();

        System.out.println(gifUrl);

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> res = template.getForEntity(gifUrl, String.class);
        String payload = res.getBody();

        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonObject result = reader.readObject();
        JsonArray data = result.getJsonArray("data");

        return data.stream()
                .map((v -> v.asJsonObject()))
                .map(v -> v.getJsonObject("images").getJsonObject("fixed_height").getString("url"))
                .toList();

    }

}
