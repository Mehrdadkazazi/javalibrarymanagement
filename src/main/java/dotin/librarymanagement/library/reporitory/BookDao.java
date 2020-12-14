package dotin.librarymanagement.library.reporitory;

import dotin.librarymanagement.general.reporitory.GenericDao;
import dotin.librarymanagement.library.model.Book;

import java.util.List;

public interface BookDao extends GenericDao<Book, Long> {

    List<Book> findFreeBook(Book book);
}
