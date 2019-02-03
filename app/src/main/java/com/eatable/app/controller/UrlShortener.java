package com.eatable.app.controller;

import com.eatable.app.dao.ShortUrlGenerator;
import com.eatable.app.dto.UrlDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/eatable/data", produces = "application/json")
public class UrlShortener {

    final String hostName = "localhost:8080";

    @Autowired
    ShortUrlGenerator shortUrlGenerator;

    @PostMapping("/short")
    public ResponseEntity generateShortUrl(@RequestParam String url) {
        return ResponseEntity.status(HttpStatus.OK).body("{\"url\":\"" + hostName + shortUrlGenerator.generateShortUrl(url) + "\"}");
    }

    @GetMapping("/")
    public ResponseEntity getAllUrls() {
        List<UrlDto> models = shortUrlGenerator.getAllUrls();
        return ResponseEntity.status(HttpStatus.OK).body(models);
    }
}
