package com.trendyol.convertlink;

import com.trendyol.convertlink.domain.TestDataProvider;
import com.trendyol.convertlink.domain.link.DeepLink;
import com.trendyol.convertlink.domain.link.LinkAdaptor;
import com.trendyol.convertlink.domain.link.PageType;
import com.trendyol.convertlink.domain.link.WebUrl;
import com.trendyol.convertlink.domain.link.deepLinkGenerators.HomePageDeepLinkGenerator;
import com.trendyol.convertlink.domain.link.deepLinkGenerators.ProductPageDeepLinkGenerator;
import com.trendyol.convertlink.domain.link.deepLinkGenerators.SearchPageDeepLinkGenerator;
import com.trendyol.convertlink.domain.link.deepLinkGenerators.SectionPageDeepLinkGenerator;
import com.trendyol.convertlink.domain.link.webUrlGenerators.HomePageWebUrlGenerator;
import com.trendyol.convertlink.domain.link.webUrlGenerators.ProductPageWebUrlGenerator;
import com.trendyol.convertlink.domain.link.webUrlGenerators.SearchPageWebUrlGenerator;
import com.trendyol.convertlink.domain.link.webUrlGenerators.SectionPageWebUrlGenerator;
import com.trendyol.convertlink.domain.shared.LinkGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {

    protected static LinkAdaptor linkAdaptor;

    protected static List<LinkGenerator<WebUrl, String>> deepLinkGenerators = new ArrayList<>();
    protected static List<LinkGenerator<DeepLink, String>> webUrlGenerators = new ArrayList<>();

    @BeforeAll
    protected static void setUp() {
        linkAdaptor = Mockito.mock(LinkAdaptor.class);

        Mockito.when(linkAdaptor.getDeepLinkTemplate(PageType.SECTION)).thenReturn("&SectionId={SectionId}");

        Mockito.when(linkAdaptor.getDeepLinkTemplate(PageType.PRODUCT)).thenReturn("&ContentId={ContentId}");

        Mockito.when(linkAdaptor.getDeepLinkTemplate(PageType.SEARCH)).thenReturn("&Query={QueryValue}");

        Mockito.when(linkAdaptor.getWebUrlTemplate(PageType.SECTION)).thenReturn("/butik/liste/{SectionName}");

        Mockito.when(linkAdaptor.getWebUrlTemplate(PageType.PRODUCT)).thenReturn("/brand/name-p-{ContentId}");

        Mockito.when(linkAdaptor.getWebUrlTemplate(PageType.SEARCH)).thenReturn("q={QueryValue}");

        TestDataProvider.getSections().entrySet().forEach(e ->
        {
            Mockito.when(linkAdaptor.getSectionId(e.getKey())).thenReturn(e.getValue());

            Mockito.when(linkAdaptor.getSectionName(e.getValue())).thenReturn(e.getKey());
        });

        deepLinkGenerators.add(new HomePageDeepLinkGenerator());

        deepLinkGenerators.add(new SectionPageDeepLinkGenerator(linkAdaptor));

        deepLinkGenerators.add(new ProductPageDeepLinkGenerator(linkAdaptor));

        deepLinkGenerators.add(new SearchPageDeepLinkGenerator(linkAdaptor));

        webUrlGenerators.add(new HomePageWebUrlGenerator());

        webUrlGenerators.add(new SectionPageWebUrlGenerator(linkAdaptor));

        webUrlGenerators.add(new ProductPageWebUrlGenerator(linkAdaptor));

        webUrlGenerators.add(new SearchPageWebUrlGenerator(linkAdaptor));
    }
}
