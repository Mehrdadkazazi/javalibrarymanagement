package dotin.librarymanagement.lendandrefer.controller;

import dotin.librarymanagement.general.controller.GenericController;
import dotin.librarymanagement.general.model.ResponseObject;
import dotin.librarymanagement.general.service.GenericService;
import dotin.librarymanagement.lendandrefer.model.LendingModel;
import dotin.librarymanagement.lendandrefer.service.LibraryManagementServiceImpl;
import dotin.librarymanagement.library.model.Book;
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
@RequestMapping("/libraryManagement")
public class LibraryManagement extends GenericController<BookViewModel, Book, Long> {

    private Logger logger = LoggerFactory.getLogger(GenericController.class);

    private ModelMapper modelMapper = new ModelMapper();

    private LibraryManagementServiceImpl libraryManagementServiceImpl;

    @Autowired
    public LibraryManagement(LibraryManagementServiceImpl libraryManagementServiceImpl) {
        this.libraryManagementServiceImpl = libraryManagementServiceImpl;
    }

    @PostMapping("/lendingBook")
    public ResponseObject lendingToUser(@RequestBody LendingModel lendingModel) {
        if (libraryManagementServiceImpl.insertDocumentData(lendingModel)) {
            libraryManagementServiceImpl.changeBookStatus(lendingModel.getBookId());
            return new ResponseObject(true, "success", "lending Done ... ", null);
        } else {
            return new ResponseObject(false, "success", "the member get 3 book ...", null);
        }
    }

    @PostMapping("/findSavedBook")
    public ResponseObject findSavedBook(@RequestBody BookViewModel bookViewModel) {
        logger.info("start method findSavedBook() - {}", (new Object[]{this.getClass().getSimpleName()}));

        Book model = modelMapper.map(bookViewModel, this.modelClass);

        List<Book> savedBook = libraryManagementServiceImpl.findSavedBook(model);

        Book responseViewModel = modelMapper.map(savedBook.size() > 0 ? savedBook.get(0) : 0, this.modelClass);

        return new ResponseObject(false , "200" , "success" , Collections.singletonList(responseViewModel));
    }

    @PostMapping("referBook")
    public ResponseObject referBook(@RequestBody BookViewModel bookViewModel) {
        logger.info("start method referBook() - {}", (new Object[]{this.getClass().getSimpleName()}));

        Book model = modelMapper.map(bookViewModel , this.modelClass);

        libraryManagementServiceImpl.referBook(model);

        return new ResponseObject(false, "success", "book referred ...", null);
    }

    @Override
    protected GenericService<Book, Long> getRelatedService() {
        return null;
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
