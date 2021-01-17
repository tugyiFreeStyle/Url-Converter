package com.trendyol.convertlink.domain.link.webUrlGenerators;

import com.trendyol.convertlink.domain.link.BaseUrl;
import com.trendyol.convertlink.domain.link.DeepLink;
import com.trendyol.convertlink.domain.link.LinkAdaptor;
import com.trendyol.convertlink.domain.link.PageType;
import com.trendyol.convertlink.domain.shared.LinkGenerator;
import org.springframework.stereotype.Component;

@Component
public class ProductPageWebUrlGenerator implements LinkGenerator<DeepLink, String> {
    private final LinkAdaptor linkAdaptor;

    public ProductPageWebUrlGenerator(LinkAdaptor linkAdaptor) {
        this.linkAdaptor = linkAdaptor;
    }

    @Override
    public String generate(DeepLink input) {
        int productStartIndex = input.getValue().indexOf("ContentId=") + 10;

        String path = input.getValue().substring(productStartIndex);

        int productEndIndex = path.indexOf("&");

        String existingTemplate = linkAdaptor.getWebUrlTemplate(PageType.PRODUCT);

        if (productEndIndex == -1) {
            return BaseUrl.BASE_URL + existingTemplate.replace("{ContentId}", path);
        }

        String pId = path.substring(0, productEndIndex);

        return BaseUrl.BASE_URL + existingTemplate.replace("{ContentId}", pId) + "?" + path.substring(productEndIndex + 1)
                .replace("CampaignId", "boutiqueId")
                .replace("MerchantId", "merchantId");
    }

    @Override
    public boolean isMatch(PageType pageType) {
        return pageType == PageType.PRODUCT;
    }
}
