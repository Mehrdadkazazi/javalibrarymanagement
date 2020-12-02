package dotin.librarymanagement.repository;

import dotin.librarymanagement.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonRepositoryImpl {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void save(Person person) {
        person.setActivation(1);
        entityManager.persist(person);
    }

    @Transactional
    public List<Person> findAll(Person person) {
        Query query = entityManager.createQuery("select entity from Person entity where entity.activation=: ent_activation");
        query.setParameter("ent_activation", 1);
        return query.getResultList();
    }

    @Transactional
    public List<Person> findAllByFilter(Person person) {
        Query query = entityManager.createQuery("select entity from Person entity where entity.activation=: ent_activation and (entity.cardId=:ent_cardId or entity.name=:ent_name or entity.family=:ent_family or entity.birthDate=:ent_birthDate or  entity.address=:ent_address or entity.role=:ent_role or entity.nationalCode=:ent_nationalCode)");

        query.setParameter("ent_activation", 1);
        query.setParameter("ent_cardId", person.getCardId());
        query.setParameter("ent_name", person.getName());
        query.setParameter("ent_family", person.getFamily());
        query.setParameter("ent_birthDate", person.getBirthDate());
        query.setParameter("ent_address", person.getAddress());
        query.setParameter("ent_role", person.getRole());
        query.setParameter("ent_nationalCode", person.getNationalCode());
        return query.getResultList();
    }

    @Transactional
    public void updatePerson(Person person) {
        Query query = entityManager.createQuery("update Person entity set entity.cardId=:ent_cardId , entity.name=:ent_name , entity.family=:ent_family , entity.birthDate=:ent_birthDate ,  entity.address=:ent_address , entity.role=:ent_role  where entity.nationalCode=:ent_nationalCode");
        query.setParameter("ent_cardId", person.getCardId());
        query.setParameter("ent_name", person.getName());
        query.setParameter("ent_family", person.getFamily());
        query.setParameter("ent_birthDate", person.getBirthDate());
        query.setParameter("ent_role", person.getRole());
        query.setParameter("ent_address", person.getAddress());
        query.setParameter("ent_nationalCode", person.getNationalCode());
        query.executeUpdate();
    }

    @Transactional
    public void deActivePerson(String nationalCode) {
        Query query = entityManager.createQuery("update Person entity set entity.activation=: ent_activation where entity.nationalCode =: ent_nationalCode");
        query.setParameter("ent_activation", 0);
        query.setParameter("ent_nationalCode", nationalCode);
        query.executeUpdate();
    }
}
