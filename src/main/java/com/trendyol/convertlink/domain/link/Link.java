package com.trendyol.convertlink.domain.link;

import com.trendyol.convertlink.domain.ShortLinkAlreadyExistException;
import com.trendyol.convertlink.domain.link.deepLinkGenerators.HomePageDeepLinkGenerator;
import com.trendyol.convertlink.domain.link.webUrlGenerators.HomePageWebUrlGenerator;
import com.trendyol.convertlink.domain.shared.AggregateRoot;
import com.trendyol.convertlink.domain.shared.Id;
import com.trendyol.convertlink.domain.shared.LinkGenerator;
import lombok.Getter;

import java.util.List;
import java.util.function.Predicate;

@Getter
public class Link extends AggregateRoot<Id> {
    private WebUrl webUrl;
    private DeepLink deepLink;
    private ShortLink shortLink;

    public Link(Id id) {
        super(id);
    }

    public ShortLink convert(WebUrl webUrl, Predicate<WebUrl> isAlreadyExist) throws ShortLinkAlreadyExistException {
        if (isAlreadyExist.test(webUrl)) throw new ShortLinkAlreadyExistException();

        shortLink = new ShortLink(BaseUrl.BASE_SHORT_LINK + ShortLinkCodeGenerator.generateRandom());
        return shortLink;
    }

    public ShortLink convert(DeepLink deepLink, Predicate<DeepLink> isAlreadyExist) throws ShortLinkAlreadyExistException {
        if (isAlreadyExist.test(deepLink)) throw new ShortLinkAlreadyExistException();

        shortLink = new ShortLink(BaseUrl.BASE_SHORT_LINK + ShortLinkCodeGenerator.generateRandom());
        return shortLink;
    }

    public WebUrl convert(DeepLink deepLink,
                          PageType pageType, List<LinkGenerator<DeepLink, String>> generators) {

        LinkGenerator<DeepLink, String> generator = generators.stream()
                .filter(g -> g.isMatch(pageType))
                .findFirst()
                .orElse(new HomePageWebUrlGenerator());

        String webUrlString = generator.generate(deepLink);

        webUrl = new WebUrl(webUrlString);
        return webUrl;
    }

    public DeepLink convert(WebUrl webUrl,
                            PageType pageType, List<LinkGenerator<WebUrl, String>> generators) {

        LinkGenerator<WebUrl, String> generator = generators.stream()
                .filter(g -> g.isMatch(pageType))
                .findFirst()
                .orElse(new HomePageDeepLinkGenerator());

        String deepLinkString = generator.generate(webUrl);

        deepLink = new DeepLink(deepLinkString);
        return deepLink;
    }
}
