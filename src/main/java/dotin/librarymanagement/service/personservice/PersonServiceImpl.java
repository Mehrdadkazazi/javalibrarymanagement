package dotin.librarymanagement.service.personservice;

import dotin.librarymanagement.model.Person;
import dotin.librarymanagement.repository.person.PersonDao;
import dotin.librarymanagement.repository.generic.GenericDao;
import dotin.librarymanagement.service.converter.UniqCardIdCreator;
import dotin.librarymanagement.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl extends GenericServiceImpl<Person, Long> implements PersonService {

    private PersonDao personDao;
    private UniqCardIdCreator uniqCardIdCreator;

    @Autowired
    public PersonServiceImpl(PersonDao personDao, UniqCardIdCreator uniqCardIdCreator) {
        this.personDao = personDao;
        this.uniqCardIdCreator = uniqCardIdCreator;
    }

    @Override
    public GenericDao<Person, Long> getRelatedDao() {
        return this.personDao;
    }

    @Override
    public List<Person> findAll(Person person) {
        return personDao.findAll(person);
    }

    @Transactional
    @Override
    public boolean delete(Person person) {
        personDao.delete(person);
        return true;
    }

    @Override
    public boolean save(Person person) {
        String cardId = uniqCardIdCreator.randomNumberProducer(person.getNationalCode());
        person.setRegistrationDate(System.currentTimeMillis());
        person.setCardId(cardId);
        super.save(person);
        return true;
    }

    @Override
    public boolean update(Person person) {

        List<Person> personListObject = personDao.findAll(person);

        Person PersonObject = personListObject.get(0);
        PersonObject.setName(person.getName());
        PersonObject.setFamily(person.getFamily());
        PersonObject.setNationalCode(person.getNationalCode());
        PersonObject.setAddress(person.getAddress());
        PersonObject.setBirthDate(person.getBirthDate());

        super.update(PersonObject);

        return true;
    }
}
