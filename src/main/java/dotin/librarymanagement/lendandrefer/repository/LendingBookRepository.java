package dotin.librarymanagement.lendandrefer.repository;

import dotin.librarymanagement.lendandrefer.model.LendingModel;
import dotin.librarymanagement.library.model.Book;
import dotin.librarymanagement.member.model.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class LendingBookRepository {
    @PersistenceContext
    EntityManager entityManager;

    public void insertData(LendingModel lendingModel) {
        try {
            entityManager.persist(lendingModel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateBookStatus(Long id) {
        Query query = entityManager.createQuery("update Book entity set entity.status=:status where entity.id=:id");
        query.setParameter("status", 1L);
        query.setParameter("id", id);
        try {

            query.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Member searchPersonLendingStatus(Long memberId) {
        Query query = entityManager.createQuery("select entity from Member entity where entity.id=:id");
        query.setParameter("id", memberId);
        return (Member) query.getSingleResult();
    }

    public List<Book> findSavedBook(Book book) {
        Query query = entityManager.createQuery("select entity from Book entity where entity.status=:status and (entity.id=:Id or entity.bookName=:BookName or entity.isbn=:Isbn or entity.authorName=:AuthorName or entity.classification=:Classification)");
        query.setParameter("status", 1L);
        query.setParameter("Id", book.getId());
        query.setParameter("BookName", book.getBookName());
        query.setParameter("Isbn", book.getIsbn());
        query.setParameter("AuthorName", book.getAuthorName());
        query.setParameter("Classification", book.getClassification());
        return query.getResultList();
    }

    public void changeStatus(Book book) {
        Query query = entityManager.createQuery("update Book entity set entity.status=:status where entity.id=:id");
        query.setParameter("status", 0L);
        query.setParameter("id", book.getId());
        try {
            query.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Transactional
    public void deleteDataFromDocument(Book book) {
        Book bookResponse = entityManager.find(Book.class, book.getId());

        if (bookResponse != null) {
            book.getMemberList().forEach(person -> {
                person.getBookList().remove(bookResponse);
            });

            entityManager.remove(bookResponse);
        }
    }
}
