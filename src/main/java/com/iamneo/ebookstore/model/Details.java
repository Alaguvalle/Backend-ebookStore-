package com.iamneo.ebookstore.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="BookDetails")
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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
