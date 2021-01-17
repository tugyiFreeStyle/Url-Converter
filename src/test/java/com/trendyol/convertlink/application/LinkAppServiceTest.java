package com.trendyol.convertlink.application;

import com.trendyol.convertlink.TestBase;
import com.trendyol.convertlink.TestConsts;
import com.trendyol.convertlink.application.dtos.DeepLinkFromWebUrlRequestDto;
import com.trendyol.convertlink.application.dtos.DeepLinkFromWebUrlResponseDto;
import com.trendyol.convertlink.application.dtos.WebUrlFromDeepLinkRequestDto;
import com.trendyol.convertlink.application.dtos.WebUrlFromDeepLinkResponseDto;
import com.trendyol.convertlink.application.services.LinkAppService;
import com.trendyol.convertlink.application.services.impl.LinkAppServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkAppServiceTest extends TestBase {

    @ParameterizedTest
    @MethodSource(TestConsts.Application.TEST_CLASS_SOURCE + "#createDeepLinkTestArguments")
    public void should_convert_to_deepLink_when_convert(String webUrl, String excepted) {

        LinkAppService linkAppService = new LinkAppServiceImpl(deepLinkGenerators, webUrlGenerators, linkAdaptor, new PageTypeFinder());

        DeepLinkFromWebUrlRequestDto request = new DeepLinkFromWebUrlRequestDto();
        request.setWebURL(webUrl);

        DeepLinkFromWebUrlResponseDto response = linkAppService.convert(request);

        assertThat(response.getDeeplink()).isEqualTo(excepted);
    }

    @ParameterizedTest
    @MethodSource(TestConsts.Application.TEST_CLASS_SOURCE + "#createWebUrlArguments")
    public void should_convert_to_web_url_convert(String deepLink, String excepted) {

        LinkAppService linkAppService = new LinkAppServiceImpl(deepLinkGenerators, webUrlGenerators, linkAdaptor, new PageTypeFinder());

        WebUrlFromDeepLinkRequestDto request = new WebUrlFromDeepLinkRequestDto();
        request.setDeeplink(deepLink);

        WebUrlFromDeepLinkResponseDto response = linkAppService.convert(request);

        assertThat(response.getWebURL()).isEqualTo(excepted);
    }
}
