package com.eatable.app.controller;

import com.eatable.app.dao.ShortUrlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class RedirectController {

    @Autowired
    ShortUrlGenerator shortUrlGenerator;

    @GetMapping(path = "/{value}")
    public RedirectView redirectUrl(@PathVariable String value) {

        String url = shortUrlGenerator.redirectShorUlr(value);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url);
        return redirectView;
    }


}
