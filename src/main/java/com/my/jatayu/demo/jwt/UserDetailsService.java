package com.my.jatayu.demo.jwt;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.my.jatayu.demo.modal.User;
import com.my.jatayu.demo.repository.RegistrationRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private RegistrationRepository registrationRepository;
 
    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Optional<User> user =  registrationRepository.findByEmailId(emailId);
        
        
        user.orElseThrow(() -> new UsernameNotFoundException("user email not able to find: "+emailId));
        
        return user.map(MyUserDetails::new).get();
//        return new MyUserDetails(user);
    }

}
