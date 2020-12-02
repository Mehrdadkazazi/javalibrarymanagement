package dotin.librarymanagement.repository;

import dotin.librarymanagement.entity.Book;
import dotin.librarymanagement.entity.LendingModel;
import dotin.librarymanagement.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class LendingBookRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void insertData(LendingModel lendingModel) {
        try {
            entityManager.persist(lendingModel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Transactional
    public void updateBookStatus(Long id) {
        Query query = entityManager.createQuery("update Book entity set entity.status=:ent_status where entity.id=:ent_id");
        query.setParameter("ent_status", 1L);
        query.setParameter("ent_id", id);
        try {

            query.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Transactional
    public Person searchPersonLendingStatus(Long userId) {
        Query query = entityManager.createQuery("select entity from Person entity where entity.id=:ent_id");
        query.setParameter("ent_id", userId);
        return (Person) query.getSingleResult();
    }

    @Transactional
    public Book findSavedBook(Book book) {
        Query query = entityManager.createQuery("select entity from Book entity where entity.status=:ent_status and (entity.id=:ent_Id or entity.bookName=:ent_BookName or entity.isbn=:ent_Isbn or entity.authorName=:ent_AuthorName or entity.classification=:ent_Classification)");
        query.setParameter("ent_status", 1L);
        query.setParameter("ent_Id", book.getId());
        query.setParameter("ent_BookName", book.getBookName());
        query.setParameter("ent_Isbn", book.getIsbn());
        query.setParameter("ent_AuthorName", book.getAuthorName());
        query.setParameter("ent_Classification", book.getClassification());
        return (Book) query.getSingleResult();
    }

    @Transactional
    public void changeStatus(Book book) {
        Query query = entityManager.createQuery("update Book entity set entity.status=:ent_status where entity.id=:ent_id");
        query.setParameter("ent_status", 0L);
        query.setParameter("ent_id", book.getId());
        try {
            query.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
