package com.trendyol.convertlink.domain.link.deepLinkGenerators;

import com.trendyol.convertlink.domain.link.BaseUrl;
import com.trendyol.convertlink.domain.link.LinkAdaptor;
import com.trendyol.convertlink.domain.link.PageType;
import com.trendyol.convertlink.domain.link.WebUrl;
import com.trendyol.convertlink.domain.shared.LinkGenerator;
import org.springframework.stereotype.Component;

@Component
public class ProductPageDeepLinkGenerator implements LinkGenerator<WebUrl, String> {
    private final LinkAdaptor linkAdaptor;

    public ProductPageDeepLinkGenerator(LinkAdaptor linkAdaptor) {
        this.linkAdaptor = linkAdaptor;
    }

    @Override
    public String generate(WebUrl input) {

        int productStartIndex = input.getValue().indexOf("-p-") + 3;

        int productEndIndex = input.getValue().indexOf("?");

        String existingTemplate = linkAdaptor.getDeepLinkTemplate(PageType.PRODUCT);

        if (productEndIndex == -1) {
            String pId = input.getValue().substring(productStartIndex);
            return BaseUrl.BASE_DEEP_LINK + "Product" + existingTemplate.replace("{ContentId}", pId);
        }

        String pId = input.getValue().substring(productStartIndex, productEndIndex);

        String path = input.getValue().substring(productEndIndex + 1);

        return BaseUrl.BASE_DEEP_LINK + "Product" + existingTemplate.replace("{ContentId}", pId) + "&" + path
                .replace("boutiqueId", "CampaignId")
                .replace("merchantId", "MerchantId");
    }

    @Override
    public boolean isMatch(PageType pageType) {
        return pageType == PageType.PRODUCT;
    }
}
