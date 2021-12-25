package binhkk.test.service;

import binhkk.test.model.Staff;
import binhkk.test.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffImplService implements IStaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Iterable<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> findById(Long id) {
        return staffRepository.findById(id);
    }

    @Override
    public void save(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void remove(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    public Iterable<Staff> findByNameContaining(String name) {
        return staffRepository.findByNameContaining(name);
    }

    @Override
    public Iterable<Staff> findAllBySalaryGreaterThan(int salary) {
        return staffRepository.findAllBySalaryGreaterThan(2000);
    }

    @Override
    public Iterable<Staff> findTop3Salary() {
        return staffRepository.findTop3Salary();
    }


}
