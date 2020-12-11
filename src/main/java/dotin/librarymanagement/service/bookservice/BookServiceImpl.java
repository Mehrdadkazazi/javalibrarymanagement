package dotin.librarymanagement.service.bookservice;

import dotin.librarymanagement.model.Book;
import dotin.librarymanagement.repository.book.BookDao;
import dotin.librarymanagement.repository.generic.GenericDao;
import dotin.librarymanagement.service.generic.GenericServiceImpl;
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
}

