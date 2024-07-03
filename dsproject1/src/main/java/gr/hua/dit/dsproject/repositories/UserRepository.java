package gr.hua.dit.dsproject.repositories;

import gr.hua.dit.dsproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<gr.hua.dit.dsproject.entities.User, Integer> {

 Optional<gr.hua.dit.dsproject.entities.User> findByEmail(String email);


}