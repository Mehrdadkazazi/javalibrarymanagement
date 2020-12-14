package dotin.librarymanagement.library.service;

import dotin.librarymanagement.library.model.Book;
import dotin.librarymanagement.library.reporitory.BookDao;
import dotin.librarymanagement.general.reporitory.GenericDao;
import dotin.librarymanagement.general.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl extends GenericServiceImpl<Book, Long> implements BookService {

    private BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public GenericDao<Book, Long> getRelatedDao() {
        return this.bookDao;
    }

    @Override
    public List<Book> findAll(Book book) {
        return bookDao.findAll(book);
    }

    @Override
    @Transactional
    public boolean delete(Book book) {
        return bookDao.delete(book);
    }

    @Override
    public boolean update(Book book) {
        List<Book> objectList = bookDao.findAll(book);
        Book singleResultBook = objectList.get(0);
        singleResultBook.setBookName(book.getBookName());
        singleResultBook.setAuthorName(book.getAuthorName());
        singleResultBook.setClassification(book.getClassification());
        return super.update(singleResultBook);
    }

    @Override
    public List<Book> findFreeBook(Book book) {
        return bookDao.findFreeBook(book);
    }
}

