package com.trendyol.convertlink.infrastructure.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "SECTION")
public class Section {

    @Id
    @NotNull
    @Column(name = "SECTION_ID", nullable = false)
    private String id;

    @NotNull
    @Column(name = "SECTION_NAME", nullable = false)
    private String name;

}
