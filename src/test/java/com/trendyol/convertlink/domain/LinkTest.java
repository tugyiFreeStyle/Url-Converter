package com.trendyol.convertlink.domain;

import com.trendyol.convertlink.TestBase;
import com.trendyol.convertlink.TestConsts;
import com.trendyol.convertlink.domain.link.*;
import com.trendyol.convertlink.domain.shared.Id;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class LinkTest extends TestBase {

    @ParameterizedTest
    @MethodSource(TestConsts.Domain.TEST_CLASS_SOURCE + "#createDeepLinkTestArguments")
    public void should_return_deepLink_when_convert(String webUrlString,
                                                    PageType pageType,
                                                    String expected) {

        WebUrl webUrl = new WebUrl(webUrlString);

        Link sut = new Link(Id.generate());

        DeepLink deepLink = sut.convert(webUrl, pageType, deepLinkGenerators);

        assertThat(deepLink.getValue()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource(TestConsts.Domain.TEST_CLASS_SOURCE + "#createWebUrlArguments")
    public void should_return_web_url_when_convert(String deepLinkString,
                                                   PageType pageType,
                                                   String expected) {

        DeepLink deepLink = new DeepLink(deepLinkString);

        Link sut = new Link(Id.generate());

        WebUrl webUrl = sut.convert(deepLink, pageType, webUrlGenerators);

        assertThat(webUrl.getValue()).isEqualTo(expected);
    }

    @Test
    public void should_throw_already_exist_when_convert() {
        DeepLink deepLink = new DeepLink("ty://Page=Product&ContentId=12");

        Link sut = new Link(Id.generate());

        assertThatThrownBy(()->sut.convert(deepLink, l -> true)).isInstanceOf(ShortLinkAlreadyExistException.class);
    }

    @Test
    public void should_return_unique_short_link_when_convert() {

        List<String> results = new ArrayList<>();

        IntStream.range(0, 100).forEach(i ->
        {
            DeepLink deepLink = new DeepLink("ty://Page=Product&ContentId=" + i);

            Link sut = new Link(Id.generate());

            ShortLink shortLink = null;

            try {
                shortLink = sut.convert(deepLink, l -> false);
            } catch (ShortLinkAlreadyExistException e) {
            }

            results.add(shortLink.getCode());
        });

        long expectedCount = results.stream().distinct().count();

        assertThat(expectedCount).isEqualTo(100);
    }
}
