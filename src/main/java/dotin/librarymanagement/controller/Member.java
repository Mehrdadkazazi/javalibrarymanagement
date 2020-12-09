package dotin.librarymanagement.controller;

import dotin.librarymanagement.controller.generic.GenericController;
import dotin.librarymanagement.model.Person;
import dotin.librarymanagement.service.generic.GenericService;
import dotin.librarymanagement.service.personservice.PersonService;
import dotin.librarymanagement.viewmodel.PersonViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class Member extends GenericController<PersonViewModel, Person, Long> {

    private PersonService personService;

    @Autowired
    public Member(PersonService personService) {
        this.personService = personService;
    }

    @Override
    protected GenericService<Person, Long> getRelatedService() {
        return personService;
    }

    @Override
    protected Class<PersonViewModel> getViewModelClass() {
        return PersonViewModel.class;
    }

    @Override
    protected Class<Person> getModelClass() {
        return Person.class;
    }
}
