package dotin.librarymanagement.library.reporitory;

import dotin.librarymanagement.general.reporitory.GenericDaoImpl;
import dotin.librarymanagement.library.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDaoImpl extends GenericDaoImpl<Book, Long> implements BookDao {
    private Logger logger = LoggerFactory.getLogger(GenericDaoImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Book> findAll(Book book) {

        Query query = entityManager.createQuery("select entity from Book entity where entity.activation=: activation and (entity.id=:id or entity.bookName=:bookName or entity.isbn=:isbn or entity.authorName=:authorName or entity.classification=:classification)");
        query.setParameter("activation", 1l);
        query.setParameter("id", book.getId());
        query.setParameter("bookName", book.getBookName());
        query.setParameter("isbn", book.getIsbn());
        query.setParameter("authorName", book.getAuthorName());
        query.setParameter("classification", book.getClassification());
        List<Book> bookList = query.getResultList();
        return bookList;
    }

    @Override
    public boolean delete(Book book) {
        Query query = entityManager.createQuery("update Book entity set entity.activation=: activation where entity.id =: id");
        query.setParameter("activation", 0L);
        query.setParameter("id", book.getId());
        query.executeUpdate();
        return true;
    }

    @Override
    public List<Book> findFreeBook(Book book) {
        Query query = entityManager.createQuery("select entity from Book entity where entity.activation=: activation and entity.status=:status and (entity.id=:id or entity.bookName=:bookName or entity.isbn=:isbn or entity.authorName=:authorName or entity.classification=:classification)");
        query.setParameter("activation", 1l);
        query.setParameter("status", 0L);
        query.setParameter("bookName", book.getBookName());
        query.setParameter("id", book.getId());
        query.setParameter("isbn", book.getIsbn());
        query.setParameter("authorName", book.getAuthorName());
        query.setParameter("classification", book.getClassification());
        List<Book> bookObject = query.getResultList();


        logger.info("end method findFreeBook() - {}", (new Object[]{this.getClass().getSimpleName()}));

        return bookObject;
    }
}
