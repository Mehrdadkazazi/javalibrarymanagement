package dotin.librarymanagement.controller;

import dotin.librarymanagement.model.Book;
import dotin.librarymanagement.model.LendingModel;
import dotin.librarymanagement.model.ResponseObject;
import dotin.librarymanagement.service.lendingservice.LendingService;
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
        lendingService.changeStatus(book);
        return new ResponseObject(false, "success", "book referred ...", null);
    }
}
