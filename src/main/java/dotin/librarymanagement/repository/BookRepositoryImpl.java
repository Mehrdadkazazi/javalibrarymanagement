package dotin.librarymanagement.repository;

import dotin.librarymanagement.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookRepositoryImpl {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public boolean insert(Book book) {
        try {
            book.setStatus(0L);
            entityManager.merge(book);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "---------" + e.getMessage());
        }
        return true;
    }

    @Transactional
    public List<Book> findAll(Book book) {
        Query query = entityManager.createQuery("select entity from Book entity");
        return query.getResultList();
    }

    @Transactional
    public List<Book> finAllByFilter(Book book) {
        Query query = entityManager.createQuery("select entity from Book entity where entity.id=:ent_Id or entity.bookName=:ent_BookName or entity.isbn=:ent_Isbn or entity.authorName=:ent_AuthorName or entity.classification=:ent_Classification");
        query.setParameter("ent_Id", book.getId());
        query.setParameter("ent_BookName", book.getBookName());
        query.setParameter("ent_Isbn", book.getIsbn());
        query.setParameter("ent_AuthorName", book.getAuthorName());
        query.setParameter("ent_Classification", book.getClassification());
        return query.getResultList();
    }

    @Transactional
    public void updateBook(@RequestBody Book book) {
        Query query = entityManager.createQuery("update Book entity set entity.bookName=:ent_BookName  , entity.authorName=:ent_AuthorName , entity.classification=:ent_Classification where  entity.isbn=:ent_Isbn");
        query.setParameter("ent_BookName", book.getBookName());
        query.setParameter("ent_AuthorName", book.getAuthorName());
        query.setParameter("ent_Classification", book.getClassification());
        query.setParameter("ent_Isbn", book.getIsbn());
        query.executeUpdate();
    }

    @Transactional
    public void delete(Long item) {
        Book book = entityManager.find(Book.class, item);
        entityManager.remove(book);
    }

    @Transactional
    public Book searchFreeBooks(Book book) {
        Query query = entityManager.createQuery("select entity from Book entity where entity.status=:ent_status and (entity.id=:ent_Id or entity.bookName=:ent_BookName or entity.isbn=:ent_Isbn or entity.authorName=:ent_AuthorName or entity.classification=:ent_Classification)");
        query.setParameter("ent_status", 0L);
        query.setParameter("ent_Id", book.getId());
        query.setParameter("ent_BookName", book.getBookName());
        query.setParameter("ent_Isbn", book.getIsbn());
        query.setParameter("ent_AuthorName", book.getAuthorName());
        query.setParameter("ent_Classification", book.getClassification());
        return (Book) query.getSingleResult();
    }
}
