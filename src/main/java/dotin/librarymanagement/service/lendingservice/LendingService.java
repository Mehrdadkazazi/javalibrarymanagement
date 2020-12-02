package dotin.librarymanagement.service.lendingservice;

import dotin.librarymanagement.entity.Book;
import dotin.librarymanagement.entity.LendingModel;
import dotin.librarymanagement.entity.Person;
import dotin.librarymanagement.repository.LendingBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LendingService {

    @Autowired
    LendingBookRepository lendingBookRepository;

    public boolean insertDocumentData(LendingModel lendingModel) {
        if (checkPersonLendingStatus(lendingModel.getUserId())) {
            lendingBookRepository.insertData(lendingModel);
            return true;
        } else {
            return false;
        }
    }

    public void changeBookStatus(Long bookId) {
        lendingBookRepository.updateBookStatus(bookId);
    }

    public boolean checkPersonLendingStatus(Long userId) {
        Person person = lendingBookRepository.searchPersonLendingStatus(userId);
        if (person.getBookList().size() < 3) {
            return true;
        } else {
            return false;
        }
    }

    public Book findSavedBook(Book book) {
        return lendingBookRepository.findSavedBook(book);
    }

    public void changeStatus(Book book) {
        lendingBookRepository.changeStatus(book);
    }
}
