package co.istad.homework_jpa2.controller;

import co.istad.homework_jpa2.model.Book;
import co.istad.homework_jpa2.model.BookRequest;
import co.istad.homework_jpa2.model.Response.ApiResponse;
import co.istad.homework_jpa2.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/students")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    @Operation(summary = "Create a new book")
    public ResponseEntity<?> createBook(@RequestBody BookRequest bookRequest){
        Book book =  bookRepository.createStudent(bookRequest);
        ApiResponse<?> apiResponse = new ApiResponse<>(
                "insert book successfully",
                HttpStatus.CREATED,
                201,
                book,
                LocalDateTime.now()
        );
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    @Operation(summary = "Get all book")
    public ResponseEntity<?> getAlllBook(){
        List<Book> allBook = bookRepository.getAllBook();
        ApiResponse<?> apiResponse = new ApiResponse<>(
                "Get all book successfully",
                HttpStatus.OK,
                201,
                allBook,
                LocalDateTime.now()
        );
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("{id}")
    @Operation(summary = "Update a book")
    public ResponseEntity<?> updateBook(@RequestBody BookRequest bookRequest, @PathVariable UUID id){
        Book book = bookRepository.updateBook(bookRequest, id);
        ApiResponse<?> apiResponse = new ApiResponse<>(
                "updated book successfully",
                HttpStatus.OK,
                201,
                book,
                LocalDateTime.now()
        );
        return ResponseEntity.ok(apiResponse);

    }

    @Operation(summary = "Delete a book")
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBook(@PathVariable UUID id){
        Book book = bookRepository.deleteBook(id);
        ApiResponse<?> apiResponse = new ApiResponse<>(
                "delete book successfully",
                HttpStatus.OK,
                201,
                book,
                LocalDateTime.now()
        );
        return ResponseEntity.ok(apiResponse);
    }


    @GetMapping("{id}")
    @Operation(summary = "Get a book by id")
    public ResponseEntity<?> getBookById(@PathVariable UUID id){
        Book book = bookRepository.getBookById(id);
        ApiResponse<?> apiResponse = new ApiResponse<>(
                " get book by id successfully",
                HttpStatus.OK,
                201,
                book,
                LocalDateTime.now()
        );
        return ResponseEntity.ok(book);
    }


    @GetMapping("title/{title}")
    @Operation(summary = "Get a book by title")
    public ResponseEntity<?> getBookByTitle(@RequestParam String title){
        List<Book> book = bookRepository.getBookByTitle(title);
        ApiResponse<?> apiResponse = new ApiResponse<>(
                " get book by title successfully",
                HttpStatus.OK,
                201,
                book,
                LocalDateTime.now()
        );
        return ResponseEntity.ok(book);
    }

}
