package com.trendyol.convertlink.infrastructure.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "LINK")
public class LinkRecord {

    @Id
    @NotNull
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", nullable = false, updatable = false)
    private String id;

    @NotNull
    @Column(name = "SHORT_LINK", nullable = false)
    private String shortLink;

    @Column(name = "WEB_URL")
    private String webURL;

    @Column(name = "DEEP_LINK")
    private String deeplink;
}
