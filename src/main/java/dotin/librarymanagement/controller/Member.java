package dotin.librarymanagement.controller;

import dotin.librarymanagement.model.ResponseObject;
import dotin.librarymanagement.model.Person;
import dotin.librarymanagement.service.personservice.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class Member {
    private final PersonService personService;

    @Autowired
    public Member(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/salam")
    public String welcome(){
        return "salam welcome....";
    }

    @RequestMapping("/save")
    public ResponseObject save(@RequestBody Person person) {
        personService.savePerson(person);
        return new ResponseObject(true, "save successful");

    }

    @RequestMapping("/findAll")
    public List<Person> finAll(@RequestBody Person person) {
        return personService.finAll(person);
    }


    @RequestMapping("/findAllByFilter")
    public List<Person> findAllByFilter(@RequestBody Person person) {
        return personService.findAllByFilter(person);
    }

    @RequestMapping("/updatePerson")
    public ResponseObject update(@RequestBody Person person) {
        personService.updatePerson(person);
        return new ResponseObject(true, "update successful");
    }

    @RequestMapping("/deActivePerson")
    public ResponseObject delete(@RequestBody Person person) {
        personService.deActivePerson(person.getNationalCode());
        return new ResponseObject(false, "person deactivated");
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseObject exceptionHandler(Exception e) {
        return new ResponseObject(true, e.getMessage());
    }
}
