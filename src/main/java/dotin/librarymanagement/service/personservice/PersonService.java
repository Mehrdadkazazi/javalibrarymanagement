package dotin.librarymanagement.service.personservice;

import dotin.librarymanagement.model.Person;
import dotin.librarymanagement.repository.PersonRepositoryImpl;
import dotin.librarymanagement.service.formateditor.Editor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepositoryImpl personRepository;
    @Autowired
    Editor editor;

    public void savePerson(Person person) {
        person.setCardId(editor.randomNumberProducer(person.getNationalCode()));
        personRepository.save(person);
    }

    public List<Person> finAll(Person person) {
        return personRepository.findAll(person);
    }

    public List<Person> findAllByFilter(Person person) {
        return personRepository.findAllByFilter(person);
    }

    public void updatePerson(Person person) {
        personRepository.updatePerson(person);
    }

    public void deActivePerson(String item) {
        personRepository.deActivePerson(item);
    }
}
