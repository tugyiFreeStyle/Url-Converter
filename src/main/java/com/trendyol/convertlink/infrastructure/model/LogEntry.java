package com.trendyol.convertlink.infrastructure.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "CONVERT_LINK_LOG")
public class LogEntry {

    @Column(name = "REQUEST_URL", nullable = false)
    private String requestUrl;

    @Column(name = "REQUEST_BODY", nullable = false)
    private String requestBody;

    @Column(name = "RESPONSE_BODY", nullable = false)
    private String responseBody;

    @NotNull
    @Column(name = "CREATION_DATE", nullable = false)
    private Date creationDate;
}
