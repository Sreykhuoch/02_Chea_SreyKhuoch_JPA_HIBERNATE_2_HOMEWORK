package co.istad.homework_jpa2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "findAllBook",
        query = "SELECT b FROM Book b")
@NamedQuery(name = "findBookByTitle",
        query = "SELECT b FROM Book b WHERE b.title LIKE :title")
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;
    private String description;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private LocalDate publicationYear;
}
