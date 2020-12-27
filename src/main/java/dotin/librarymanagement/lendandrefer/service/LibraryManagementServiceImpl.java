package dotin.librarymanagement.lendandrefer.service;

import dotin.librarymanagement.library.model.Book;
import dotin.librarymanagement.lendandrefer.model.LendingModel;
import dotin.librarymanagement.member.model.Member;
import dotin.librarymanagement.lendandrefer.repository.LendingBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryManagementServiceImpl implements LibraryManagementService{

    private LendingBookRepository lendingBookRepository;

    @Autowired
    public LibraryManagementServiceImpl(LendingBookRepository lendingBookRepository) {
        this.lendingBookRepository = lendingBookRepository;
    }

    @Transactional
    public boolean insertDocumentData(LendingModel lendingModel) {
        if (checkPersonLendingStatus(lendingModel.getMemberId())) {
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
        Member member = lendingBookRepository.searchPersonLendingStatus(userId);
        List<Book> booksAssigned = new ArrayList<>();

        for (Book bookList : member.getBookList()){
            if (bookList.getStatus()==1){
                booksAssigned.add(bookList);
            }
        }

        if (booksAssigned.size() < 3) {
            return true;
        } else {
            return false;
        }
    }

    public List<Book> findSavedBook(Book book) {
        return lendingBookRepository.findSavedBook(book);
    }

    @Transactional
    public boolean referBook(Book book) {
        LendingModel lendingModel = new LendingModel();

        changeStatus(book);

        //deleteDataFromDocument(book, lendingModel);

        return true;

    }

    private void changeStatus(Book book) {
        lendingBookRepository.changeStatus(book);
    }

    private void deleteDataFromDocument(Book book, LendingModel lendingModel) {
        lendingBookRepository.deleteDataFromDocument(book);
    }
}
