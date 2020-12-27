package dotin.librarymanagement.identification.repository;

import dotin.librarymanagement.identification.model.Person;
import dotin.librarymanagement.general.reporitory.GenericDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class UserManagementDaoImpl extends GenericDaoImpl<Person , Long> implements UserManagementDao {

    @Override
    public Person findPerson(String username) {
        return null;
    }
}
