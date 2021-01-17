package com.trendyol.convertlink.infrastructure.model;

import com.sun.istack.NotNull;
import com.trendyol.convertlink.domain.link.PageType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "LINK_TEMPLATE")
public class LinkTemplate {

    @NotNull
    @Column(name = "PAGE_TYPE", nullable = false)
    private PageType pageType;

    @NotNull
    @Column(name = "WEB_URL_FORMAT", nullable = false)
    private String webUrlFormat;

    @NotNull
    @Column(name = "DEEP_LINK_FORMAT", nullable = false)
    private String deepLinkFormat;
}
