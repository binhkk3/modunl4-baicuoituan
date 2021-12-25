package binhkk.test.repository;

import binhkk.test.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {
Iterable<Staff> findByNameContaining (String name);
Iterable<Staff> findAllBySalaryGreaterThan(int salary);
@Modifying
    @Query(value = "select *from staff where salary = order by likes desc limit 3", nativeQuery = true)
    Iterable<Staff> findTop3Salary();
}
