package dotin.librarymanagement.identification.service;

import dotin.librarymanagement.identification.model.Person;
import dotin.librarymanagement.general.service.GenericService;

public interface UserManagementService extends GenericService<Person , Long> {

    Person findPerson(String username);
}
