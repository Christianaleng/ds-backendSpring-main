package gr.hua.dit.dsproject.controllers;

import gr.hua.dit.dsproject.dtos.UserDto;
import gr.hua.dit.dsproject.entities.Role;
import gr.hua.dit.dsproject.entities.User;
import gr.hua.dit.dsproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        super();
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
//    @GetMapping
//    public List<Student> getAllStudents(){
//        return StudentService;
//    }


    @PostMapping("/create")
    public ResponseEntity<User> createStudent(@RequestBody UserDto userdto) {
        User newUser = new User();
        newUser.setFirstname(userdto.getFirstname());
        newUser.setLastname(userdto.getLastname());
        newUser.setEmail(userdto.getEmail());
        newUser.setPassword(passwordEncoder.encode(userdto.getPassword()));
        newUser.setRole(Role.STUDENT);
        User savedUser = userService.save(newUser);
        return ResponseEntity.ok(savedUser);
    }


}
