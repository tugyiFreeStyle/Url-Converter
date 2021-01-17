package com.trendyol.convertlink.domain;

import com.trendyol.convertlink.domain.link.PageType;
import com.trendyol.convertlink.domain.link.BaseUrl;
import org.junit.jupiter.params.provider.Arguments;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TestDataProvider {
    private TestDataProvider() {
    }

    public static Stream<Arguments> createWebUrlArguments() {
        return Stream.of(
                Arguments.of("ty://Page=Home", PageType.HOME, BaseUrl.BASE_URL),
                Arguments.of("ty://Page=Home&SectionId=1", PageType.SECTION, BaseUrl.BASE_URL + "/butik/liste/kadin"),
                Arguments.of("ty://Page=Home&SectionId=2", PageType.SECTION, BaseUrl.BASE_URL + "/butik/liste/erkek"),
                Arguments.of("ty://Page=Home&SectionId=3", PageType.SECTION, BaseUrl.BASE_URL + "/butik/liste/supermarket"),
                Arguments.of("ty://Page=Home&SectionId=4", PageType.SECTION, BaseUrl.BASE_URL + "/butik/liste/cocuk"),
                Arguments.of("ty://Page=Product&ContentId=1925865", PageType.PRODUCT, BaseUrl.BASE_URL + "/brand/name-p-1925865"),
                Arguments.of("ty://Page=Product&ContentId=1925865&CampaignId=436985", PageType.PRODUCT, BaseUrl.BASE_URL + "/brand/name-p-1925865?boutiqueId=436985"),
                Arguments.of("ty://Page=Product&ContentId=1925865&CampaignId=436985&MerchantId=152896", PageType.PRODUCT, BaseUrl.BASE_URL + "/brand/name-p-1925865?boutiqueId=436985&merchantId=152896"),
                Arguments.of("ty://Page=Product&ContentId=1925865&MerchantId=152896", PageType.PRODUCT, BaseUrl.BASE_URL + "/brand/name-p-1925865?merchantId=152896"),
                Arguments.of("ty://Page=Search&Query=elbise", PageType.SEARCH, BaseUrl.BASE_URL + "q=elbise"),
                Arguments.of("ty://Page=Search&Query=%C3%BCt%C3%VB", PageType.SEARCH, BaseUrl.BASE_URL + "q=%C3%BCt%C3%VB"),
                Arguments.of("ty://Page=Favorites", PageType.OTHERS, BaseUrl.BASE_URL + ""),
                Arguments.of("ty://Page=Orders", PageType.OTHERS, BaseUrl.BASE_URL + ""));
    }

    public static Stream<Arguments> createDeepLinkTestArguments() {
        return Stream.of(
                Arguments.of("www.trendyol.com", PageType.HOME, BaseUrl.BASE_DEEP_LINK + "Home"),
                Arguments.of("www.trendyol.com/butik/liste/kadin", PageType.SECTION, BaseUrl.BASE_DEEP_LINK + "Home&SectionId=1"),
                Arguments.of("www.trendyol.com/butik/liste/erkek", PageType.SECTION, BaseUrl.BASE_DEEP_LINK + "Home&SectionId=2"),
                Arguments.of("www.trendyol.com/butik/liste/supermarket", PageType.SECTION, BaseUrl.BASE_DEEP_LINK + "Home&SectionId=3"),
                Arguments.of("www.trendyol.com/butik/liste/cocuk", PageType.SECTION, BaseUrl.BASE_DEEP_LINK + "Home&SectionId=4"),
                Arguments.of("www.trendyol.com/casio/erkek-kol-saati-p-1925865", PageType.PRODUCT, BaseUrl.BASE_DEEP_LINK + "Product&ContentId=1925865"),
                Arguments.of("www.trendyol.com/casio/erkek-kol-saati-p-1925865?boutiqueId=439892", PageType.PRODUCT, BaseUrl.BASE_DEEP_LINK + "Product&ContentId=1925865&CampaignId=439892"),
                Arguments.of("www.trendyol.com/casio/erkek-kol-saati-p-1925865?boutiqueId=439892&merchantId=105064", PageType.PRODUCT, BaseUrl.BASE_DEEP_LINK + "Product&ContentId=1925865&CampaignId=439892&MerchantId=105064"),
                Arguments.of("www.trendyol.com/tum--urunler?q=elbise", PageType.SEARCH, BaseUrl.BASE_DEEP_LINK + "Search&Query=elbise"),
                Arguments.of("www.trendyol.com/tum--urunler?q=%C3%BCt%C3%VB", PageType.SEARCH, BaseUrl.BASE_DEEP_LINK + "Search&Query=%C3%BCt%C3%VB"),
                Arguments.of("www.trendyol.com/Hesabim/Favoriler", PageType.OTHERS, BaseUrl.BASE_DEEP_LINK + "Home"),
                Arguments.of("www.trendyol.com/Hesabim/#/Siparislerim", PageType.OTHERS, BaseUrl.BASE_DEEP_LINK + "Home"));
    }

    public static Map<PageType, String> getDeepLinkTemplates() {

        Map<PageType, String> templates = new HashMap<>();

        templates.put(PageType.HOME, "");
        templates.put(PageType.SECTION, "&SectionId={SectionId}");
        templates.put(PageType.PRODUCT, "&ContentId={ContentId}");
        templates.put(PageType.SEARCH, "&Query={QueryValue}");
        templates.put(PageType.OTHERS, "");

        return templates;
    }

    public static Map<PageType, String> getWebUrlTemplates() {

        Map<PageType, String> templates = new HashMap<>();

        templates.put(PageType.HOME, "");
        templates.put(PageType.SECTION, "/butik/liste/{SectionName}");
        templates.put(PageType.PRODUCT, "/brand/name-p-{ContentId}");
        templates.put(PageType.SEARCH, "q={QueryValue}");
        templates.put(PageType.OTHERS, "");

        return templates;
    }

    public static Map<String, Integer> getSections() {

        Map<String, Integer> sections = new HashMap();

        sections.put("kadin", 1);
        sections.put("erkek", 2);
        sections.put("supermarket", 3);
        sections.put("cocuk", 4);
        return sections;
    }


}
