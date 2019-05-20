package org.sang.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Component
@ConfigurationProperties(prefix = "book")
public class Book {
    private Integer id;
    private String name;
    private String author;
    private Float price;
}
