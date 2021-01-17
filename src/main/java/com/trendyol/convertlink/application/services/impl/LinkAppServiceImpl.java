package com.trendyol.convertlink.application.services.impl;

import com.trendyol.convertlink.application.PageTypeFinder;
import com.trendyol.convertlink.application.dtos.*;
import com.trendyol.convertlink.application.exceptions.InvalidRequestException;
import com.trendyol.convertlink.application.services.LinkAppService;
import com.trendyol.convertlink.domain.ShortLinkAlreadyExistException;
import com.trendyol.convertlink.domain.link.*;
import com.trendyol.convertlink.domain.shared.Id;
import com.trendyol.convertlink.domain.shared.LinkGenerator;
import com.trendyol.convertlink.infrastructure.model.LinkRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkAppServiceImpl implements LinkAppService {
    private final List<LinkGenerator<WebUrl, String>> deepLinkGenerators;
    private final List<LinkGenerator<DeepLink, String>> webUrlGenerators;
    private final LinkAdaptor linkAdaptor;
    private final PageTypeFinder pageTypeFinder;

    @Autowired
    public LinkAppServiceImpl(List<LinkGenerator<WebUrl, String>> deepLinkGenerators,
                              List<LinkGenerator<DeepLink, String>> webUrlGenerators, LinkAdaptor linkAdaptor, PageTypeFinder pageTypeFinder) {
        this.deepLinkGenerators = deepLinkGenerators;
        this.webUrlGenerators = webUrlGenerators;
        this.linkAdaptor = linkAdaptor;
        this.pageTypeFinder = pageTypeFinder;
    }

    @Override
    public DeepLinkFromWebUrlResponseDto convert(DeepLinkFromWebUrlRequestDto request) {

        WebUrl url = new WebUrl(request.getWebURL());

        DeepLink deepLink = getDeepLink(url);

        return DeepLinkFromWebUrlResponseDto.convertFrom(deepLink);
    }

    private DeepLink getDeepLink(WebUrl url) {
        PageType pageType = pageTypeFinder.find(url);
        return new Link(Id.generate()).convert(url, pageType, deepLinkGenerators);
    }

    @Override
    public WebUrlFromDeepLinkResponseDto convert(WebUrlFromDeepLinkRequestDto request) {

        DeepLink link = new DeepLink(request.getDeeplink());

        WebUrl webUrl = getWebUrl(link);

        return WebUrlFromDeepLinkResponseDto.convertFrom(webUrl);
    }

    private WebUrl getWebUrl(DeepLink link) {
        PageType pageType = pageTypeFinder.find(link);
        return new Link(Id.generate()).convert(link, pageType, webUrlGenerators);
    }

    @Override
    @Cacheable(value = "webAndDeepLinkCache", key = "#request.shortlink", condition = "#result != null")
    public ServeShortLinkResponseDto serve(ServeShortLinkRequestDto request) throws InvalidRequestException {

        ShortLink shortLink = new ShortLink(request.getShortlink());
        if (request.getShortlink() == null) {
            throw new InvalidRequestException("shortlink parameter could not be null");
        }

        LinkRecord links = linkAdaptor.getLinksAccordingTo(shortLink);
        return ServeShortLinkResponseDto.convertFrom(links);
    }


    @Override
    @Cacheable(value = "shortLinkCache", key = "#request.deeplink.concat(#request.webURL)", condition = "#result != null")
    public GenerateShortLinkResponseDto generate(GenerateShortLinkRequestDto request) throws ShortLinkAlreadyExistException {

        ShortLink shortLink = null;
        DeepLink deepLink = null;
        WebUrl webUrl = null;

        Link link = new Link(Id.generate());
        if (request.getWebURL() != null && request.getDeeplink() == null) {
            webUrl = new WebUrl(request.getWebURL());
            shortLink = link.convert(webUrl, this.linkAdaptor::isExist);
            deepLink = getDeepLink(webUrl);

        } else if (request.getDeeplink() != null && request.getWebURL() == null) {
            deepLink = new DeepLink(request.getDeeplink());
            shortLink = link.convert(deepLink, this.linkAdaptor::isExist);
            webUrl = getWebUrl(deepLink);
        }

        linkAdaptor.createLinkRecord(shortLink, deepLink, webUrl);
        return GenerateShortLinkResponseDto.convertFrom(shortLink);
    }
}
