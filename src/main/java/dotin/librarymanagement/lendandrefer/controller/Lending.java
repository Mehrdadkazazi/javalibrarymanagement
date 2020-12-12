package dotin.librarymanagement.lendandrefer.controller;

import dotin.librarymanagement.library.model.Book;
import dotin.librarymanagement.lendandrefer.model.LendingModel;
import dotin.librarymanagement.general.model.ResponseObject;
import dotin.librarymanagement.lendandrefer.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lending")
public class Lending {

    LendingService lendingService;

    @Autowired
    public Lending(LendingService lendingService) {
        this.lendingService = lendingService;
    }

    @PostMapping("/lendingBook")
    public ResponseObject lendingToUser(@RequestBody LendingModel lendingModel) {
        if (lendingService.insertDocumentData(lendingModel)) {
            lendingService.changeBookStatus(lendingModel.getBookId());
            return new ResponseObject(true, "success", "lending Done ... ", null);
        } else {
            return new ResponseObject(false, "success", "the user get 3 book ...", null);
        }
    }

    @PostMapping("/findSavedBook")
    public Book findSavedBook(@RequestBody Book book) {
        return lendingService.findSavedBook(book);
    }

    @PostMapping("referBook")
    public ResponseObject referBook(@RequestBody Book book) {
        lendingService.referBook(book);
        return new ResponseObject(false, "success", "book referred ...", null);
    }
}
