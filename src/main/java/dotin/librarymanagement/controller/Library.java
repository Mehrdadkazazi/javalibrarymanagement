package dotin.librarymanagement.controller;

import dotin.librarymanagement.entity.Book;
import dotin.librarymanagement.entity.ResponseObject;
import dotin.librarymanagement.service.bookservice.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class Library {

    private final BookService bookService;

    @Autowired
    public Library(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/save")
    @Transactional
    public ResponseObject insertData(@RequestBody Book book) {
        bookService.insertNewBook(book);
        return new ResponseObject(false, "person saved successfully");
    }

    @RequestMapping("/findAll")
    public List<Book> findAll(@RequestBody Book book) {
        return bookService.findAllBook(book);

    }

    @RequestMapping("/findAllByFilter")
    public List<Book> findAllByFilter(@RequestBody Book book) {
        return bookService.findAllByFilter(book);

    }

    @RequestMapping("update")
    public ResponseObject update(@RequestBody Book book) {
        bookService.update(book);
        return new ResponseObject(true, "update done ...");
    }

    @RequestMapping("delete")
    public ResponseObject delete(@RequestBody Book book) {
        bookService.delete(book.getId());
        return new ResponseObject(false, "book has benn deleted ...");
    }

    @RequestMapping("/searchFreeBooks")
    public Book searchLendingBook(@RequestBody Book book) {
        try {

            return bookService.searchFreeBooks(book);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseObject exceptionHandler(Exception e) {
        return new ResponseObject(true, e.getMessage());
    }
}
