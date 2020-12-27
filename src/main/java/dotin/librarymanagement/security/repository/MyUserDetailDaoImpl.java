package dotin.librarymanagement.security.repository;

import dotin.librarymanagement.identification.model.Person;
import dotin.librarymanagement.general.reporitory.GenericDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class MyUserDetailDaoImpl extends GenericDaoImpl<Person, Long> implements MyUserDetailDao {

    private EntityManager entityManager;

    @Autowired
    public MyUserDetailDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Person findPerson(String username) {
        Query query = entityManager.createQuery("select entity from Person entity where entity.username=:username");

        query.setParameter("username", username);

        Person registeredPerson = (Person) query.getSingleResult();

        return registeredPerson;
    }
}
