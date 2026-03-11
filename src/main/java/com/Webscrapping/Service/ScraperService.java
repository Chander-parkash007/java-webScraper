package com.Webscrapping.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import com.Webscrapping.Model.ScrapResponse;

@Service
public class ScraperService {

    public static ScrapResponse webScrapResponse(String url) throws IOException {
        Document docs = Jsoup.connect(url).get();

        List<String> images = new ArrayList<>();
        List<String> videos = new ArrayList<>();
        List<String> links = new ArrayList<>();

        for (Element img : docs.select("img")) {
            String src = img.absUrl("src");
            if (!src.isEmpty()) {
                images.add(src);
            }
        }
        for (Element vid : docs.select("video")) {
            String src = vid.absUrl("src");
            if (!src.isEmpty()) {
                videos.add(src);
            }
        }
        for (Element link : docs.select("a[href]")) {
            String href = link.absUrl("href");
            if (!href.isEmpty()) {
                links.add(href);
            }
        }

        ScrapResponse response = new ScrapResponse();
        response.setImages(images);
        response.setLinks(links);
        response.setVideos(videos);

        return response;

    }
}
