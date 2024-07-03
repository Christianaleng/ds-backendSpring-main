package gr.hua.dit.dsproject.services;

import gr.hua.dit.dsproject.entities.User;
import gr.hua.dit.dsproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User student) {
        return userRepository.save(student);
    }

    // Other service methods go here
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

}