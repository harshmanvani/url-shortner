package com.url.shortner.Dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UrlMappingDto {

    private Long id;
    private String shortUrl;
    private String originalUrl;
    private int clickCount;
    private LocalDateTime createdDate;
    private String username;

}
