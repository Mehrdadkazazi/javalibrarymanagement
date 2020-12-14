package dotin.librarymanagement.lendandrefer.service;

import dotin.librarymanagement.library.model.Book;
import dotin.librarymanagement.lendandrefer.model.LendingModel;
import dotin.librarymanagement.user.model.Person;
import dotin.librarymanagement.lendandrefer.repository.LendingBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibraryManagementServiceImpl implements LibraryManagementService{

    private LendingBookRepository lendingBookRepository;

    @Autowired
    public LibraryManagementServiceImpl(LendingBookRepository lendingBookRepository) {
        this.lendingBookRepository = lendingBookRepository;
    }

    @Transactional
    public boolean insertDocumentData(LendingModel lendingModel) {
        if (checkPersonLendingStatus(lendingModel.getUserId())) {
            lendingBookRepository.insertData(lendingModel);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
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

    @Transactional
    public boolean referBook(Book book) {
        LendingModel lendingModel = new LendingModel();

        changeStatus(book);

        deleteDataFromDocument(book, lendingModel);

        return true;

    }

    private void changeStatus(Book book) {
        lendingBookRepository.changeStatus(book);
    }

    private void deleteDataFromDocument(Book book, LendingModel lendingModel) {
        lendingBookRepository.deleteDataFromDocument(book);
    }
}
