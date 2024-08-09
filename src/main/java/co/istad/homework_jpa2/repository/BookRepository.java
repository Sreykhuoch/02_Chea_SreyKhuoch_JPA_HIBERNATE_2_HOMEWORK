package co.istad.homework_jpa2.repository;

import co.istad.homework_jpa2.model.Book;
import co.istad.homework_jpa2.model.BookRequest;
import jakarta.persistence.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Transactional
@Repository
public class BookRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Book createStudent(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setDescription(bookRequest.getDescription());
        book.setAuthor(bookRequest.getAuthor());
        book.setPublicationYear(bookRequest.getPublicationYear());

        entityManager.persist(book);
       return book;
    }

    public List<Book> getAllBook() {
       Query query = entityManager.createNamedQuery("findAllBook", Book.class);
       return query.getResultList();
    }

    public Book updateBook(BookRequest bookRequest, UUID id) {
        Book book = entityManager.find(Book.class, id);
        entityManager.detach(book);
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setDescription(bookRequest.getDescription());
        book.setPublicationYear(bookRequest.getPublicationYear());
        entityManager.merge(book);
        return book;
    }


    public Book deleteBook(UUID id) {
        Book findBook = entityManager.find(Book.class, id);
        entityManager.remove(findBook);
        return findBook;
    }

    public Book getBookById(UUID id) {
        Book bookById = entityManager.find(Book.class, id);
        return bookById;
    }

    public List<Book> getBookByTitle(String title) {
       Query query = entityManager.createNamedQuery("findBookByTitle",  Book.class)
               .setParameter("title", "%" + title + "%");
       return query.getResultList();
    }
}
