package gr.hua.dit.dsproject.repositories;

import gr.hua.dit.dsproject.dtos.ApplicationDto;
import gr.hua.dit.dsproject.entities.Application;
import gr.hua.dit.dsproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
