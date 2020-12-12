package dotin.librarymanagement.user.reporitory;

import dotin.librarymanagement.user.model.Person;
import dotin.librarymanagement.general.reporitory.GenericDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonDaoImpl extends GenericDaoImpl<Person, Long> implements PersonDao {
    private Logger logger = LoggerFactory.getLogger(GenericDaoImpl.class);

    private EntityManager entityManager;

    @Autowired
    public PersonDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Person> findAll(Person person) {
        Query query = entityManager.createQuery("select entity from Person entity where entity.activation =: activation and (entity.name=:name or entity.family=:family or entity.cardId=:cardId or entity.nationalCode=:nationalCode)");
        query.setParameter("activation", 1);
        query.setParameter("name", person.getName());
        query.setParameter("family", person.getFamily());
        query.setParameter("cardId", person.getCardId());
        query.setParameter("nationalCode", person.getNationalCode());
        return query.getResultList();
    }

    @Override
    public boolean delete(Person person) {
        Query query = entityManager.createQuery("update Person entity set entity.activation=: activation where entity.id =: id");
        query.setParameter("activation", 0);
        query.setParameter("id", person.getId());
        query.executeUpdate();
        return true;
    }
}
