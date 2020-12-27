package dotin.librarymanagement.identification.repository;

import dotin.librarymanagement.identification.model.Person;
import dotin.librarymanagement.general.reporitory.GenericDao;

public interface UserManagementDao extends GenericDao<Person , Long> {
    Person findPerson(String username);
}
