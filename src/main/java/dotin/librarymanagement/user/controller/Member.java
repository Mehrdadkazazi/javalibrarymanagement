package dotin.librarymanagement.user.controller;

import dotin.librarymanagement.general.controller.GenericController;
import dotin.librarymanagement.user.model.Person;
import dotin.librarymanagement.general.service.GenericService;
import dotin.librarymanagement.user.service.PersonService;
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
