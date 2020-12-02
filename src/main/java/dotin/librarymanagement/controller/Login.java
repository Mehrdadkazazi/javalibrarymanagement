//package ir.dotin.educationProject.libraryManagement.controller;
//
//import ir.dotin.educationProject.libraryManagement.configuration.SecurityConfiguration;
//import ir.dotin.educationProject.libraryManagement.service.MyUserDetailService;
//import AuthenticationRequest;
//import AuthenticationResponse;
//import ir.dotin.educationProject.libraryManagement.util.JwtUtil;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class Login {
//
//    private final AuthenticationManager authenticationManager;
//
//    private final JwtUtil jwtTokenUtil;
//
//    private final MyUserDetailService userDetailsService;
//
//    public Login(AuthenticationManager authenticationManager, JwtUtil jwtTokenUtil, MyUserDetailService userDetailsService) {
//        this.authenticationManager = authenticationManager;
//        this.jwtTokenUtil = jwtTokenUtil;
//        this.userDetailsService = userDetailsService;
//    }
//
//    @GetMapping("/hello")
//    public String welcome(){
//        return "welcome to project Admin ....";
//    }
//
//    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())
//            );
//
//        } catch (BadCredentialsException e) {
//
//            throw new Exception("incorrect userName or password", e);
//        }
//
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
//
//        final String jwt = jwtTokenUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));
//    }
//}
