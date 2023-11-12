package com.iamneo.ebookstore.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailsRequest {
    private String title;
    private long price;
    private String language;
    private String printlength;
    private String publicationdate;
    private long review;
    private long quantity;
    private String category;
    private String author;
}
