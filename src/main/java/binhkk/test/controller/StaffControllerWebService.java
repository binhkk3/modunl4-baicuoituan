package binhkk.test.controller;

import binhkk.test.model.Staff;
import binhkk.test.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/staff")
public class StaffControllerWebService {
@Autowired
    private IStaffService staffService;
    @GetMapping
    public ResponseEntity<Iterable<Staff>> findAllStaff(){
        Iterable<Staff> staffIterable =  (Iterable<Staff>) staffService.findAll();
        return new ResponseEntity<>(staffIterable, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Staff> findStaffById(@PathVariable Long id){
        Optional<Staff> staffOptional = staffService.findById(id);

        if (!staffOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staffOptional.get(),HttpStatus.CREATED);
    }
    @PostMapping
    public ResponseEntity<Staff> saveStaff(@RequestBody Staff staff) {
        staffService.save(staff);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id,@RequestBody Staff staff){
        Optional<Staff> staffOptional = staffService.findById(id);
        if (!staffOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        staff.setId(staffOptional.get().getId());
        staffService.save(staff);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Staff> deleteStaff(@PathVariable Long id){
        Optional<Staff> staffOptional = staffService.findById(id);

        if (!staffOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        staffService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

