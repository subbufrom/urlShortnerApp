package com.eatable.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UrlDto {

    @JsonProperty("shorUrl")
    private String shortUrl;
    @JsonProperty("hits")
    private String hits;
    @JsonProperty("originalUrl")
    private String originalUrl;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }
}
