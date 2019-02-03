package com.eatable.app.dao;

import com.eatable.app.dto.UrlDto;
import com.eatable.app.mongoEntity.UrlModel;
import com.eatable.app.repository.UrlModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ShortUrlGeneratorImpl implements ShortUrlGenerator {

    @Autowired
    UrlModelRepository urlModelRepository;

    @Override
    public String generateShortUrl(String url) {
        UrlModel urlModel = new UrlModel();
        int hashKey = generateHashKey(url);
        urlModel.setId("et" + hashKey);
        urlModel.setNoOfHits(0);
        urlModel.setOriginalUrl(url);
        urlModel.setShortUrl("et" + hashKey);
        urlModel.setCreatedTimeStamp(new Date());
        urlModel.setModifiedTimeStamp(new Date());
        urlModelRepository.save(urlModel);
        return "/et" + hashKey;
    }

    @Override
    public String redirectShorUlr(String url) {
        Optional<UrlModel> urlModel = urlModelRepository.findById(url);
        urlModel.get().setNoOfHits(urlModel.get().getNoOfHits());
        UrlModel urlModel1 = new UrlModel();
        urlModel1.setNoOfHits(urlModel.get().getNoOfHits() + 1);
        urlModel1.setShortUrl(urlModel.get().getShortUrl());
        urlModel1.setOriginalUrl(urlModel.get().getOriginalUrl());
        urlModel1.setId(urlModel.get().getId());
        urlModel1.setModifiedTimeStamp(new Date());
        urlModel1.setCreatedTimeStamp(urlModel.get().getCreatedTimeStamp());
        UrlModel model = urlModelRepository.save(urlModel1);

        if (Objects.nonNull(model))
            return model.getOriginalUrl();
        else
            return "NotFound";
    }

    @Override
    public List<UrlDto> getAllUrls() {
        List<UrlModel> models = urlModelRepository.findAll(orderByIdAsc());
        return models.stream().map(value -> {
            UrlDto urlDto = new UrlDto();
            urlDto.setHits(String.valueOf(value.getNoOfHits()));
            urlDto.setShortUrl(value.getId());
            urlDto.setOriginalUrl(extractOriginalUrl(value.getOriginalUrl()));
            return urlDto;
        }).collect(Collectors.toList());
    }

    private String extractOriginalUrl(String str) {
        if (str.length() > 60)
            return str.substring(0, 60) + "****";
        else return str;
    }

    private Sort orderByIdAsc() {
        return new Sort(Sort.Direction.DESC, "createdTimeStamp")
                .and(new Sort(Sort.Direction.DESC, "noOfHits"));
    }

    public int generateHashKey(String value) {
        return Math.abs(value.hashCode());
    }
}
