package com.my.jatayu.demo.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.jatayu.demo.jwt.JwtTokenResponse;
import com.my.jatayu.demo.jwt.JwtUtil;
import com.my.jatayu.demo.login.service.RegisterationService;
import com.my.jatayu.demo.modal.AuthRequest;
import com.my.jatayu.demo.modal.User;

@RestController
//@CrossOrigin(origins = "*")
public class LoginAndRegisterationController {

    @Autowired
    private RegisterationService registerationService;
//    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @PostMapping(path = "/registeration")
//    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<User> registerUser(@RequestBody User user) throws Exception {
         
        
        System.out.println("connected !!!!!!!");
        String userEmail = user.getEmailId();
        if(userEmail != null && !"".equals(userEmail)) {
            User fetchUserByEmailId = registerationService.fetchUserByEmailId(userEmail);
            if(fetchUserByEmailId != null) {
                throw new Exception("User with "+ userEmail+ " is aleray exists");
            }
        }
        ResponseEntity<User> respEntityUser = null;
        respEntityUser = new ResponseEntity<>(registerationService.saveUser(user), HttpStatus.OK);
        
        return respEntityUser;
    }
    
    @PostMapping(path="/login")
//    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        ResponseEntity<User> responseEntity = null;
        
        String tempEmailId= user.getEmailId();
        String tempPassword = user.getPassword();
        try {
            User userData = null;
            if(tempEmailId != null && tempPassword != null) {
               userData = registerationService.fetchUserByEmailAndPassword(tempEmailId, tempPassword);
               responseEntity = new ResponseEntity<>(userData, HttpStatus.OK);
            }
            if(userData == null) {
                throw new Exception("Bad credentials");
            }
        } catch(Exception e) {
            responseEntity = new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return responseEntity;
    }
    
  @PostMapping(path="/authentication")
//  @CrossOrigin(origins = "http://localhost:4200")
  public ResponseEntity<JwtTokenResponse> getnerateToken(@RequestBody AuthRequest authRequest) throws Exception {
      ResponseEntity<JwtTokenResponse> response = null;
      try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
      } catch(Exception ex) {
          response = new ResponseEntity<>(new JwtTokenResponse("invalid token", "invalid user name password"), HttpStatus.INTERNAL_SERVER_ERROR);
          throw new Exception("invalid user name or password");
      }
      response = new ResponseEntity<>(jwtUtil.generateToken(authRequest.getUsername()), HttpStatus.OK);
      return response;
  }
}
