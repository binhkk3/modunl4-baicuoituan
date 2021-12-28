package binhkk.test.service;

import binhkk.test.model.Staff;

public interface IStaffService extends IGeneralService<Staff>{
    Iterable<Staff> findByNameContaining (String name);
    Iterable<Staff> findAllBySalaryGreaterThan(int salary);
    Iterable<Staff> Top3Salary();

}
