package com.hexahealth.controller;

import com.hexahealth.model.Doctor;
import com.hexahealth.model.User;
import com.hexahealth.service.DoctorService;
import com.hexahealth.service.UserService;
import org.hibernate.metamodel.mapping.ordering.ast.DomainPathContinuation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addDoctor(@RequestBody Doctor doctor){
                /*
                    {
                        "name" : "piastri",
                        "specialisation" : "ENT",
                        "user" : {
                            "username" : "piastri@gmail.com",
                            "password" : "piastri@123"
                        }
                    }
                 */
        try{
            User user = doctor.getUser();
            user = userService.save(user);
            doctor.setUser(user);
            return ResponseEntity.ok(doctorService.save(doctor));
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<?> addDoctor(@RequestBody Doctor doctor, @PathVariable int id){
                /*
                        {
                        "name" : "",
                        "specialisation" : ""
                         }
                 */
        try{
            User user = userService.findById(id);
            doctor.setUser(user);
            return ResponseEntity.ok(doctorService.save(doctor));
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
