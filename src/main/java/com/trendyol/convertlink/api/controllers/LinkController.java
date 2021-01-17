package com.trendyol.convertlink.api.controllers;

import com.trendyol.convertlink.application.dtos.*;
import com.trendyol.convertlink.application.exceptions.InvalidRequestException;
import com.trendyol.convertlink.application.services.LinkAppService;
import com.trendyol.convertlink.domain.ShortLinkAlreadyExistException;
import com.trendyol.convertlink.domain.shared.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/links")
public class LinkController {

    private final LinkAppService linkAppService;

    @Autowired
    public LinkController(LinkAppService linkAppService) {
        this.linkAppService = linkAppService;
    }

    @PostMapping("/convert-to-deepLink")
    public ResponseEntity<DeepLinkFromWebUrlResponseDto> convertWebUrlToDeepLink(@RequestBody DeepLinkFromWebUrlRequestDto request) {
        return ResponseEntity.ok(linkAppService.convert(request));
    }

    @PostMapping("/convert-to-webUrl")
    public ResponseEntity<WebUrlFromDeepLinkResponseDto> convertDeepLinkToWebUrl(@RequestBody WebUrlFromDeepLinkRequestDto request) throws EntityNotFoundException {
        return ResponseEntity.ok(linkAppService.convert(request));
    }

    @PostMapping("/generate-shortLink")
    public ResponseEntity<GenerateShortLinkResponseDto> generateShortLink(@RequestBody GenerateShortLinkRequestDto request) throws ShortLinkAlreadyExistException {
        return ResponseEntity.ok(linkAppService.generate(request));
    }

    @PostMapping("/serve-shortLink")
    public ResponseEntity<ServeShortLinkResponseDto> serveShortLink(@RequestBody ServeShortLinkRequestDto request) throws InvalidRequestException {
        return ResponseEntity.ok(linkAppService.serve(request));
    }
}
