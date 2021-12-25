package binhkk.test.service;

import binhkk.test.model.Department;
import binhkk.test.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentImplService implements IDepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public void save(Department department) {
departmentRepository.save(department);
    }

    @Override
    public void remove(Long id) {
departmentRepository.deleteById(id);
    }
}
