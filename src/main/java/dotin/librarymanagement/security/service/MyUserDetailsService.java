package dotin.librarymanagement.security.service;

import dotin.librarymanagement.identification.model.Person;
import dotin.librarymanagement.security.repository.MyUserDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {


    private MyUserDetailDao myUserDetailDao;

    @Autowired
    public MyUserDetailsService(MyUserDetailDao myUserDetailDao) {
        this.myUserDetailDao = myUserDetailDao;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       Person userLoaded = myUserDetailDao.findPerson(userName);

        return new User(userName, userLoaded.getPassword(), new ArrayList<>());
    }
}
