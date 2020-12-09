package dotin.librarymanagement.repository.book;

import dotin.librarymanagement.model.Book;
import dotin.librarymanagement.repository.share.GenericDaoImpl;
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

        Query query = entityManager.createQuery("select entity from Book entity");
        return query.getResultList();
    }
}
