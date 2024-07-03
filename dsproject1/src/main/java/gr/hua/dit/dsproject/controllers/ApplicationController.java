package gr.hua.dit.dsproject.controllers;

import gr.hua.dit.dsproject.dtos.ApplicationDto;
import gr.hua.dit.dsproject.entities.Application;
import gr.hua.dit.dsproject.entities.User;
import gr.hua.dit.dsproject.services.ApplicationService;
import gr.hua.dit.dsproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;
    private UserService userService;

    public ApplicationController(ApplicationService applicationService, UserService userService) {
        this.applicationService = applicationService;
        this.userService = userService;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create")
    public ResponseEntity<Application> createApplication(@RequestBody ApplicationDto applicationDto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        User currentUser = userService.findByEmail(user.getEmail());
        Application application = new Application();
        application.setBachelorDegreeGrade(applicationDto.getBachelorDegreeGrade());
        application.setBachelorDegreeTitle(applicationDto.getBachelorDegreeTitle());
        application.setTeachers(applicationDto.getTeachers());
        application.setMastername(applicationDto.getMastername());
        application.setUser(currentUser);
        Application savedApplication = applicationService.save(application);
        return new ResponseEntity<>(savedApplication, HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<List<Application>> getAllApplications() {
//        List<Application> applications = applicationService.findAll();
//        return new ResponseEntity<>(applications, HttpStatus.OK);
//    }
      @CrossOrigin(origins = "http://localhost:3000")
      @GetMapping
        public ResponseEntity<List<ApplicationDto>> getAllApplications() {
          Authentication auth = SecurityContextHolder.getContext().getAuthentication();
          User user = (User) auth.getPrincipal();
          User currentUser = userService.findByEmail(user.getEmail());
          List<Application> applications = applicationService.findAll();
          List<ApplicationDto> applicationDtos = new ArrayList<>();
          for (Application application : applications) {
                ApplicationDto applicationDto = new ApplicationDto();
                // set the properties of the applicationDto object
                applicationDto.setBachelorDegreeTitle(application.getBachelorDegreeTitle());
                applicationDto.setBachelorDegreeGrade(application.getBachelorDegreeGrade());
                applicationDto.setTeachers(application.getTeachers());
                applicationDto.setMastername(application.getMastername());
                User userTemp = application.getUser();
                if(userTemp.getEmail().equals(currentUser.getEmail())) {
                    applicationDtos.add(applicationDto);
                }
            }
          return new ResponseEntity<>(applicationDtos, HttpStatus.OK);
        }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public ResponseEntity<List<ApplicationDto>> getApplications() {
        List<Application> applications = applicationService.findAll();
        List<ApplicationDto> applicationDtos = new ArrayList<>();
        for (Application application : applications) {
            ApplicationDto applicationDto = new ApplicationDto();
            // set the properties of the applicationDto object
            applicationDto.setBachelorDegreeTitle(application.getBachelorDegreeTitle());
            applicationDto.setBachelorDegreeGrade(application.getBachelorDegreeGrade());
            applicationDto.setTeachers(application.getTeachers());
            applicationDto.setMastername(application.getMastername());
            applicationDto.setId(application.getId());
            //User userTemp = application.getUser();
            applicationDtos.add(applicationDto);
        }
        return new ResponseEntity<>(applicationDtos, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable("id") Long id) {
        Application application = applicationService.findById(id);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ApplicationDto> getApplicationById(@PathVariable("id") Long id) {
//        Application application = applicationService.findById(id);
//
//        ApplicationDto applicationDto = new ApplicationDto();
//        applicationDto.setId(application.getId());
//        applicationDto.setBachelorDegreeTitle(application.getBachelorDegreeTitle());
//        applicationDto.setBachelorDegreeGrade(application.getBachelorDegreeGrade());
//        applicationDto.setTeachers(application.getTeachers().getName());
//
//        return new ResponseEntity<>(applicationDto, HttpStatus.OK);
//    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping ("/update/{id}")
    public ResponseEntity<Application> updateApplication(@PathVariable("id") Long id, @RequestBody ApplicationDto applicationDto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        User currentUser = userService.findByEmail(user.getEmail());
        Application application = applicationService.findById(id);
        application.setBachelorDegreeGrade(applicationDto.getBachelorDegreeGrade());
        application.setBachelorDegreeTitle(applicationDto.getBachelorDegreeTitle());
        application.setTeachers(applicationDto.getTeachers());
        application.setAcceptedbySecretary(applicationDto.isSetAcceptedbySecretary());
        application.setAcceptedbyTeacher(applicationDto.isSetAcceptedbyTeacher());
        application.setUser(currentUser);
        Application updatedApplication = applicationService.update(application);
        return new ResponseEntity<>(updatedApplication, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable("id") Long id) {
        applicationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


