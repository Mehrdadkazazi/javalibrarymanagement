package dotin.librarymanagement.library.service;

import dotin.librarymanagement.library.model.Book;
import dotin.librarymanagement.general.service.GenericService;

import java.util.List;


public interface BookService extends GenericService<Book, Long> {

   List <Book> findFreeBook (Book book);
}
