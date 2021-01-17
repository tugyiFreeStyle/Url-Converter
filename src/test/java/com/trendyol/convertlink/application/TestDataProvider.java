package com.trendyol.convertlink.application;

import com.trendyol.convertlink.domain.link.PageType;
import com.trendyol.convertlink.domain.link.BaseUrl;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestDataProvider {
    private TestDataProvider() {
    }

    public static Stream<Arguments> createDeepLinkTestArguments() {
        return Stream.of(
                Arguments.of("www.trendyol.com", BaseUrl.BASE_DEEP_LINK + "Home"),
                Arguments.of("www.trendyol.com/Hesabim/Favoriler", BaseUrl.BASE_DEEP_LINK + "Home"),
                Arguments.of("www.trendyol.com/butik/liste/kadin", BaseUrl.BASE_DEEP_LINK + "Home&SectionId=1"),
                Arguments.of("www.trendyol.com/butik/liste/erkek", BaseUrl.BASE_DEEP_LINK + "Home&SectionId=2"),
                Arguments.of("www.trendyol.com/butik/liste/supermarket", BaseUrl.BASE_DEEP_LINK + "Home&SectionId=3"),
                Arguments.of("www.trendyol.com/butik/liste/cocuk", BaseUrl.BASE_DEEP_LINK + "Home&SectionId=4"),
                Arguments.of("www.trendyol.com/casio/erkek-kol-saati-p-1925865", BaseUrl.BASE_DEEP_LINK + "Product&ContentId=1925865"),
                Arguments.of("www.trendyol.com/casio/erkek-kol-saati-p-1925865?boutiqueId=439892", BaseUrl.BASE_DEEP_LINK + "Product&ContentId=1925865&CampaignId=439892"),
                Arguments.of("www.trendyol.com/casio/erkek-kol-saati-p-1925865?boutiqueId=439892&merchantId=105064", BaseUrl.BASE_DEEP_LINK + "Product&ContentId=1925865&CampaignId=439892&MerchantId=105064"),
                Arguments.of("www.trendyol.com/tum--urunler?q=elbise", BaseUrl.BASE_DEEP_LINK + "Search&Query=elbise"),
                Arguments.of("www.trendyol.com/tum--urunler?q=%C3%BCt%C3%VB", BaseUrl.BASE_DEEP_LINK + "Search&Query=%C3%BCt%C3%VB"),
                Arguments.of("www.trendyol.com/Hesabim/Favoriler", BaseUrl.BASE_DEEP_LINK + "Home"),
                Arguments.of("www.trendyol.com/Hesabim/#/Siparislerim", BaseUrl.BASE_DEEP_LINK + "Home"));
    }

    public static Stream<Arguments> createWebUrlArguments() {
        return Stream.of(
                Arguments.of("ty://Page=Home", BaseUrl.BASE_URL),
                Arguments.of("ty://Page=Home&SectionId=1", BaseUrl.BASE_URL + "/butik/liste/kadin"),
                Arguments.of("ty://Page=Home&SectionId=2", BaseUrl.BASE_URL + "/butik/liste/erkek"),
                Arguments.of("ty://Page=Home&SectionId=3", BaseUrl.BASE_URL + "/butik/liste/supermarket"),
                Arguments.of("ty://Page=Home&SectionId=4", BaseUrl.BASE_URL + "/butik/liste/cocuk"),
                Arguments.of("ty://Page=Product&ContentId=1925865", BaseUrl.BASE_URL + "/brand/name-p-1925865"),
                Arguments.of("ty://Page=Product&ContentId=1925865&CampaignId=436985", BaseUrl.BASE_URL + "/brand/name-p-1925865?boutiqueId=436985"),
                Arguments.of("ty://Page=Product&ContentId=1925865&CampaignId=436985&MerchantId=152896", BaseUrl.BASE_URL + "/brand/name-p-1925865?boutiqueId=436985&merchantId=152896"),
                Arguments.of("ty://Page=Product&ContentId=1925865&MerchantId=152896", BaseUrl.BASE_URL + "/brand/name-p-1925865?merchantId=152896"),
                Arguments.of("ty://Page=Search&Query=elbise", BaseUrl.BASE_URL + "q=elbise"),
                Arguments.of("ty://Page=Search&Query=%C3%BCt%C3%VB", BaseUrl.BASE_URL + "q=%C3%BCt%C3%VB"),
                Arguments.of("ty://Page=Favorites", BaseUrl.BASE_URL + ""),
                Arguments.of("ty://Page=Orders", BaseUrl.BASE_URL + ""));
    }

    public static Stream<Arguments> findDeepLinkPageTypeArguments() {
        return Stream.of(
                Arguments.of("ty://Page=Home", PageType.HOME),
                Arguments.of("ty://Page=Home&SectionId=1", PageType.SECTION),
                Arguments.of("ty://Page=Home&SectionId=2", PageType.SECTION),
                Arguments.of("ty://Page=Home&SectionId=3", PageType.SECTION),
                Arguments.of("ty://Page=Home&SectionId=4", PageType.SECTION),
                Arguments.of("ty://Page=Product&ContentId=1925865", PageType.PRODUCT),
                Arguments.of("ty://Page=Product&ContentId=1925865&CampaignId=436985", PageType.PRODUCT),
                Arguments.of("ty://Page=Product&ContentId=1925865&CampaignId=436985&MerchantId=152896", PageType.PRODUCT),
                Arguments.of("ty://Page=Product&ContentId=1925865&MerchantId=152896", PageType.PRODUCT),
                Arguments.of("ty://Page=Search&Query=elbise", PageType.SEARCH),
                Arguments.of("ty://Page=Search&Query=%C3%BCt%C3%VB", PageType.SEARCH),
                Arguments.of("ty://Page=Favorites", PageType.OTHERS),
                Arguments.of("ty://Page=Orders", PageType.OTHERS));
    }

    public static Stream<Arguments> findWebUrlTypeArguments() {
        return Stream.of(
                Arguments.of("www.trendyol.com", PageType.HOME),
                Arguments.of("www.trendyol.com/butik/liste/kadin", PageType.SECTION),
                Arguments.of("www.trendyol.com/butik/liste/erkek", PageType.SECTION),
                Arguments.of("www.trendyol.com/butik/liste/supermarket", PageType.SECTION),
                Arguments.of("www.trendyol.com/butik/liste/cocuk", PageType.SECTION),
                Arguments.of("www.trendyol.com/casio/erkek-kol-saati-p-1925865", PageType.PRODUCT),
                Arguments.of("www.trendyol.com/casio/erkek-kol-saati-p-1925865?boutiqueId=439892", PageType.PRODUCT),
                Arguments.of("www.trendyol.com/casio/erkek-kol-saati-p-1925865?boutiqueId=439892&merchantId=105064", PageType.PRODUCT),
                Arguments.of("www.trendyol.com/tum--urunler?q=elbise", PageType.SEARCH),
                Arguments.of("www.trendyol.com/tum--urunler?q=%C3%BCt%C3%VB", PageType.SEARCH),
                Arguments.of("www.trendyol.com/Hesabim/Favoriler", PageType.OTHERS),
                Arguments.of("www.trendyol.com/Hesabim/#/Siparislerim", PageType.OTHERS));
    }
}
