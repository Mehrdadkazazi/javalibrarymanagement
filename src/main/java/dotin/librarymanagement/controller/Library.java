package dotin.librarymanagement.controller;

import dotin.librarymanagement.controller.generic.GenericController;
import dotin.librarymanagement.model.Book;
import dotin.librarymanagement.service.bookservice.BookService;
import dotin.librarymanagement.service.generic.GenericService;
import dotin.librarymanagement.viewmodel.BookViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class Library extends GenericController<BookViewModel, Book, Long> {

    private BookService bookService;

    @Autowired
    public Library(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    protected GenericService<Book, Long> getRelatedService() {
        return bookService;
    }

    @Override
    protected Class<BookViewModel> getViewModelClass() {
        return BookViewModel.class;
    }

    @Override
    protected Class<Book> getModelClass() {
        return Book.class;
    }
}
