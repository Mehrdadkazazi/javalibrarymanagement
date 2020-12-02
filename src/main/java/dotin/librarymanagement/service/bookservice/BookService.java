package dotin.librarymanagement.service.bookservice;

import dotin.librarymanagement.entity.Book;
import dotin.librarymanagement.repository.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepositoryImpl bookRepositoryImpl;

    public void insertNewBook(Book book) {
        bookRepositoryImpl.insert(book);
    }

    public List<Book> findAllBook(Book book) {
        return bookRepositoryImpl.findAll(book);
    }

    public List<Book> findAllByFilter(Book book) {
        return bookRepositoryImpl.finAllByFilter(book);
    }

    public void update(Book book) {
        bookRepositoryImpl.updateBook(book);
    }

    public void delete(Long item) {
        bookRepositoryImpl.delete(item);
    }

    public Book searchFreeBooks(Book book){
        return bookRepositoryImpl.searchFreeBooks(book);
    }
}
