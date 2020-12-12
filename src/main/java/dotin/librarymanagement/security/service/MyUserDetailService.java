//package ir.dotin.educationProject.libraryManagement.service;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class MyUserDetailService implements UserDetailsService {
//    private static final String DEFAULT_PASSWORD = new BCryptPasswordEncoder().encode("admin");
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//
//        return new User("admin" , DEFAULT_PASSWORD , new ArrayList<>());
//    }
//}
