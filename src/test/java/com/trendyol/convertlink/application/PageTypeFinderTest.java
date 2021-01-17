package com.trendyol.convertlink.application;

import com.trendyol.convertlink.TestConsts;
import com.trendyol.convertlink.domain.link.DeepLink;
import com.trendyol.convertlink.domain.link.PageType;
import com.trendyol.convertlink.domain.link.WebUrl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PageTypeFinderTest {

    @ParameterizedTest
    @MethodSource(TestConsts.Application.TEST_CLASS_SOURCE + "#findWebUrlTypeArguments")
    public void should_return_web_url_page_type(String webUrlString, PageType expectedType) {

        PageTypeFinder sut = new PageTypeFinder();

        WebUrl webUrl = new WebUrl(webUrlString);

        PageType result = sut.find(webUrl);

        assertThat(result).isEqualTo(expectedType);
    }

    @ParameterizedTest
    @MethodSource(TestConsts.Application.TEST_CLASS_SOURCE + "#findDeepLinkPageTypeArguments")
    public void should_return_deep_link_page_type(String deepLinkString, PageType expectedType) {

        PageTypeFinder sut = new PageTypeFinder();

        DeepLink deepLink = new DeepLink(deepLinkString);

        PageType result = sut.find(deepLink);

        assertThat(result).isEqualTo(expectedType);
    }
}
