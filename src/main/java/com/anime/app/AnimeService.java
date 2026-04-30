package com.anime.app;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Service
public class AnimeService {

    private final WebClient client = WebClient.create("https://api.jikan.moe/v4");

    // ✅ CATEGORY / SEARCH (LIST)
    public List<Anime> byCategory(String cat){
        var res = client.get()
                .uri("/anime?q=" + cat)
                .retrieve()
                .bodyToMono(JikanResponse.class)
                .block();

        return res.getData().stream().limit(10)
                .map(a -> new Anime(
                        a.getTitle(),
                        a.getScore(),
                        a.getImages().getJpg().getImage_url(),
                        a.getMal_id()
                ))
                .limit(20).toList();
    }

    // ✅ DETAILS (FIXED)
    public JikanAnime details(int id){
        var res = client.get()
                .uri("/anime/" + id)
                .retrieve()
                .bodyToMono(JikanSingleResponse.class) // ✅ FIX
                .block();

        return res.getData(); // ✅ FIX
    }
}