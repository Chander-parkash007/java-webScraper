package com.Webscrapping.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Webscrapping.Model.ScrapResponse;
import com.Webscrapping.Service.ScraperService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Scrapcontroller {

    @Autowired
    private ScraperService scraperService;

    @GetMapping("/api/scrap")
    public ScrapResponse scrap(@RequestParam String url) throws IOException {
        return ScraperService.webScrapResponse(url);
    }
}
