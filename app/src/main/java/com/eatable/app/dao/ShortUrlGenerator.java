package com.eatable.app.dao;

import com.eatable.app.dto.UrlDto;

import java.util.List;

public interface ShortUrlGenerator {

    public String generateShortUrl(String url);

    public String redirectShorUlr(String url);

    public List<UrlDto> getAllUrls();
}
