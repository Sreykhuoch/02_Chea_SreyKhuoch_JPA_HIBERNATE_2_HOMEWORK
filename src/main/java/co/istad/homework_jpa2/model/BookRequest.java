package co.istad.homework_jpa2.model;


import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    private String title;
    private String description;
    private String author;
    private LocalDate publicationYear;
}
