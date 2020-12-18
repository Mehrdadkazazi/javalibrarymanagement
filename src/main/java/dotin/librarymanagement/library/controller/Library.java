package dotin.librarymanagement.library.controller;

import dotin.librarymanagement.general.controller.GenericController;
import dotin.librarymanagement.general.model.ResponseObject;
import dotin.librarymanagement.general.service.GenericService;
import dotin.librarymanagement.library.model.Book;
import dotin.librarymanagement.library.service.BookService;
import dotin.librarymanagement.viewmodel.BookViewModel;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/books")
public class Library extends GenericController<BookViewModel, Book, Long> {

    private ModelMapper modelMapper = new ModelMapper();

    private Logger logger = LoggerFactory.getLogger(GenericController.class);

    private BookService bookService;

    @Autowired
    public Library(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    protected GenericService<Book, Long> getRelatedService() {
        return this.bookService;
    }

    @Override
    protected Class<BookViewModel> getViewModelClass() {
        return BookViewModel.class;
    }

    @Override
    protected Class<Book> getModelClass() {
        return Book.class;
    }

    @PostMapping("/findFreeBooks")
    public ResponseObject findFreeBooks(@RequestBody BookViewModel bookViewModel) {
        logger.info("start method findAll() - {}", (new Object[]{this.getClass().getSimpleName()}));

        Book model = modelMapper.map(bookViewModel, this.modelClass);

        List<Book> freeBook = bookService.findFreeBook(model);

        Book responseViewModel = modelMapper.map(freeBook.size() > 0 ? freeBook.get(0) : 0, this.modelClass);

        return new ResponseObject(false, "200", "success", Collections.singletonList(responseViewModel));
    }

}
