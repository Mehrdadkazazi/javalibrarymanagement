package dotin.librarymanagement.security.repository;

import dotin.librarymanagement.identification.model.Person;
import dotin.librarymanagement.general.reporitory.GenericDao;

public interface MyUserDetailDao extends GenericDao<Person , Long> {
    Person findPerson(String username);
}
