package dotin.librarymanagement.identification.service;

import dotin.librarymanagement.identification.model.Person;
import dotin.librarymanagement.identification.repository.UserManagementDao;
import dotin.librarymanagement.general.reporitory.GenericDao;
import dotin.librarymanagement.general.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl extends GenericServiceImpl<Person , Long> implements UserManagementService {

    private UserManagementDao userManagementDao;

    @Autowired
    public UserManagementServiceImpl(UserManagementDao userManagementDao){
        this.userManagementDao = userManagementDao;
    }

    @Override
    public GenericDao<Person, Long> getRelatedDao() {
        return this.userManagementDao;
    }

    @Override
    public Person findPerson(String username) {
        return userManagementDao.findPerson(username);
    }
}
