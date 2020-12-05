package dotin.librarymanagement.controller;

import dotin.librarymanagement.configuration.PersonConfig;
import dotin.librarymanagement.model.Person;
import dotin.librarymanagement.model.ResponseObject;
import dotin.librarymanagement.service.personservice.PersonService;
import dotin.librarymanagement.viewmodel.PersonViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class Member {

    private PersonService personService;
    private PersonConfig personConfig;

    @Autowired
    public Member(PersonService personService, PersonConfig personConfig) {
        this.personService = personService;
        this.personConfig = personConfig;
    }

    private Logger logger = LoggerFactory.getLogger(Member.class);

    @PostMapping("/save")
    public ResponseObject save(@RequestBody PersonViewModel personViewModel) {
        logger.info("start method save() - {}", (new Object[]{this.getClass().getSimpleName()}));

        Person person = personConfig.viewToModel(personViewModel);

        logger.info("end method save() - {}", (new Object[]{this.getClass().getSimpleName()}));
        return new ResponseObject(false, "success", "", null);
    }

    @GetMapping("/findAll")
    public List<PersonViewModel> finAll() {
        logger.info("getRequest has been called : ");
        List<Person> personList = personService.finAll();
        return personConfig.modelToView(personList);
    }

    @PostMapping("/findAllByFilter")
    public PersonViewModel findAllByFilter(@RequestBody PersonViewModel personViewModel) {
        Person person = personConfig.viewToModel(personViewModel);
        List<Person> personList = personService.findAllByFilter(person);
        return personConfig.modelToView(person);
    }

    @PostMapping("/update")
    public ResponseObject update(@RequestBody Person person) {
        personService.updatePerson(person);
        return new ResponseObject(true, "success", "update successful", null);
    }

    @DeleteMapping("/deActivePerson{NATIONALCODE}")
    public ResponseObject delete(@RequestBody Person person) {
        personService.deActivePerson(person.getNationalCode());
        return new ResponseObject(false, "success", "person deactivated", null);
    }
}
