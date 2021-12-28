package binhkk.test.controller;

import binhkk.test.model.Department;
import binhkk.test.model.Staff;
import binhkk.test.service.IDepartmentService;
import binhkk.test.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/Department")
public class DepartmentContrllerWebService {
    @Autowired
    private IDepartmentService departmentService;
    @GetMapping
    public ResponseEntity<Iterable<Department>> findAllStaff(){
        Iterable<Department> departments =  (Iterable<Department>) departmentService.findAll();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }
}
