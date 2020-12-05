package dotin.librarymanagement.service.personservice;

import dotin.librarymanagement.model.Person;
import dotin.librarymanagement.repository.PersonRepositoryImpl;
import dotin.librarymanagement.service.formateditor.Editor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepositoryImpl personRepository;
    private final Editor editor;

    public PersonService(PersonRepositoryImpl personRepository, Editor editor) {
        this.personRepository = personRepository;
        this.editor = editor;
    }

    @Transactional
    public Person savePerson(Person person) {
        person.setCardId(editor.randomNumberProducer(person.getNationalCode()));
        personRepository.save(person);
        return person;
    }

    public List<Person> finAll() {
        return personRepository.findAll();
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
