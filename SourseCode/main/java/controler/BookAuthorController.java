package org.libapp.libapp.controller;

import org.libapp.libapp.entity.BookAuthor;
import org.libapp.libapp.entity.BookAuthorId;
import org.libapp.libapp.service.BookWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-authors")
public class BookAuthorController {

    private final BookWriterService BookWriterService;

    @Autowired
    public BookAuthorController(BookWriterService BookWriterService) {
        this.BookWriterService = BookWriterService;
    }

    @GetMapping
    public List<BookAuthor> getAllBookAuthors() {
        return BookWriterService.getAllBookAuthors();
    }


    @PostMapping
    public BookAuthor createBookAuthor(@RequestBody BookAuthor bookAuthor) {
        return BookWriterService.addBookAuthor(bookAuthor);
    }


    @GetMapping("/{bookId}/{authorId}")
    public BookAuthor getBookAuthorById(@PathVariable Integer bookId, @PathVariable Integer authorId) {
        return BookWriterService.getBookAuthorById(new BookAuthorId(bookId, authorId));
    }


    @DeleteMapping("/{bookId}/{authorId}")
    public void deleteBookAuthor(@PathVariable Integer bookId, @PathVariable Integer authorId) {
        BookWriterService.deleteBookAuthor(new BookAuthorId(bookId, authorId));
    }
}
