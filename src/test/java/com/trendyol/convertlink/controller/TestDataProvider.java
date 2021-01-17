package com.trendyol.convertlink.controller;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestDataProvider {

    public static Stream<Arguments> linkArguments() {
        return Stream.of(
                Arguments.of("{\"webURL\":\"www.trendyol.com\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/butik/liste/kadin\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/butik/liste/erkek\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/butik/liste/supermarket\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/butik/liste/cocuk\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/casio/erkek-kol-saati-p-1925865\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/casio/erkek-kol-saati-p-1925865?boutiqueId=439892\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/casio/erkek-kol-saati-p-1925865?boutiqueId=439892&merchantId=105064\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/tum--urunler?q=elbise\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/tum--urunler?q=%C3%BCt%C3%VB\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/Hesabim/Favoriler\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/Hesabim/#/Siparislerim\"}", "/api/v1/links/generate-shortLink"),

                Arguments.of("{\"deeplink\":\"ty://Page=Home\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"deeplink\":\"ty://Page=Home&SectionId=1\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"deeplink\":\"ty://Page=Home&SectionId=2\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"deeplink\":\"ty://Page=Home&SectionId=3\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"deeplink\":\"ty://Page=Home&SectionId=4\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"deeplink\":\"ty://Page=Product&ContentId=1925865\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"deeplink\":\"ty://Page=Product&ContentId=1925865&CampaignId=436985\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"deeplink\":\"ty://Page=Product&ContentId=1925865&CampaignId=436985&MerchantId=152896\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"deeplink\":\"ty://Page=Product&ContentId=1925865&MerchantId=152896\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"deeplink\":\"ty://Page=Search&Query=elbise\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"deeplink\":\"ty://Page=Search&Query=%C3%BCt%C3%VB\"}", "/api/v1/links/generate-shortLink"),
                Arguments.of("{\"deeplink\":\"ty://Page=Favorites\"}", "/api/v1/links/generate-shortLink"),

                Arguments.of("{\"webURL\":\"www.trendyol.com\"}", "/api/v1/links/convert-to-deepLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/butik/liste/kadin\"}", "/api/v1/links/convert-to-deepLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/butik/liste/erkek\"}", "/api/v1/links/convert-to-deepLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/butik/liste/supermarket\"}", "/api/v1/links/convert-to-deepLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/butik/liste/cocuk\"}", "/api/v1/links/convert-to-deepLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/casio/erkek-kol-saati-p-1925865\"}", "/api/v1/links/convert-to-deepLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/casio/erkek-kol-saati-p-1925865?boutiqueId=439892\"}", "/api/v1/links/convert-to-deepLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/casio/erkek-kol-saati-p-1925865?boutiqueId=439892&merchantId=105064\"}", "/api/v1/links/convert-to-deepLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/tum--urunler?q=elbise\"}", "/api/v1/links/convert-to-deepLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/tum--urunler?q=%C3%BCt%C3%VB\"}", "/api/v1/links/convert-to-deepLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/Hesabim/Favoriler\"}", "/api/v1/links/convert-to-deepLink"),
                Arguments.of("{\"webURL\":\"www.trendyol.com/Hesabim/#/Siparislerim\"}", "/api/v1/links/convert-to-deepLink"),

                Arguments.of("{\"deeplink\":\"ty://Page=Home\"}", "/api/v1/links/convert-to-webUrl"),
                Arguments.of("{\"deeplink\":\"ty://Page=Home&SectionId=1\"}", "/api/v1/links/convert-to-webUrl"),
                Arguments.of("{\"deeplink\":\"ty://Page=Home&SectionId=2\"}", "/api/v1/links/convert-to-webUrl"),
                Arguments.of("{\"deeplink\":\"ty://Page=Home&SectionId=3\"}", "/api/v1/links/convert-to-webUrl"),
                Arguments.of("{\"deeplink\":\"ty://Page=Home&SectionId=4\"}", "/api/v1/links/convert-to-webUrl"),
                Arguments.of("{\"deeplink\":\"ty://Page=Product&ContentId=1925865\"}", "/api/v1/links/convert-to-webUrl"),
                Arguments.of("{\"deeplink\":\"ty://Page=Product&ContentId=1925865&CampaignId=436985\"}", "/api/v1/links/convert-to-webUrl"),
                Arguments.of("{\"deeplink\":\"ty://Page=Product&ContentId=1925865&CampaignId=436985&MerchantId=152896\"}", "/api/v1/links/convert-to-webUrl"),
                Arguments.of("{\"deeplink\":\"ty://Page=Product&ContentId=1925865&MerchantId=152896\"}", "/api/v1/links/convert-to-webUrl"),
                Arguments.of("{\"deeplink\":\"ty://Page=Search&Query=elbise\"}", "/api/v1/links/convert-to-webUrl"),
                Arguments.of("{\"deeplink\":\"ty://Page=Search&Query=%C3%BCt%C3%VB\"}", "/api/v1/links/convert-to-webUrl"),
                Arguments.of("{\"deeplink\":\"ty://Page=Favorites\"}", "/api/v1/links/convert-to-webUrl"),

                Arguments.of("{\"shortlink\":\"localhost:8080/abcdefgh\"}", "/api/v1/links/serve-shortLink"));
    }
}
