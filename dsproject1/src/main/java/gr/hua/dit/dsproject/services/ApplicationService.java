package gr.hua.dit.dsproject.services;

import gr.hua.dit.dsproject.entities.Application;
import gr.hua.dit.dsproject.entities.User;
import gr.hua.dit.dsproject.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    public Application findById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

//    public List<Application> findByUsername(String firstName) {
//        List<Application> allApps = findAll();
//        List<Application> usersApps = new ArrayList<>();
//
//        for (Application app :
//                allApps) {
//            if (app.us)
//        }
//    }

    public Application update(Application application) {
        return applicationRepository.save(application);
    }

    public void delete(Long id) {
        applicationRepository.deleteById(id);
    }

}
