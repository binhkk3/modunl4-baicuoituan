package binhkk.test.controller;

import binhkk.test.model.Department;
import binhkk.test.model.Staff;
import binhkk.test.service.IDepartmentService;
import binhkk.test.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/Staff")
public class StaffController {
    @Autowired
    private IStaffService staffService;
    @Autowired
    private IDepartmentService departmentService;

    @ModelAttribute("department")
    public Iterable<Department> departments() {
        return departmentService.findAll();
    }

    @GetMapping("")
    public String showLit(Model model, String key, String key2) {
        Iterable<Staff> staffIterable;
        if (key == null) {
            if (key2 == null) {
                staffIterable = staffService.findAll();
                model.addAttribute("staff", staffIterable);
                return "showlist";
            } else {
                staffIterable = staffService.findByNameContaining(key2);
                model.addAttribute("staff", staffIterable);
                return "showlist";
            }
        } else {
            switch (key) {
                case "a":
                    staffIterable = staffService.findAllBySalaryGreaterThan(2000);
                    model.addAttribute("staff", staffIterable);
                    return "showlist";

                case "c":
                    staffIterable = staffService.Top3Salary();
                    model.addAttribute("staff", staffIterable);
                    return "showlist";
                default:
                    staffIterable = staffService.findAll();
                    model.addAttribute("staff", staffIterable);
                    return "showlist";
            }
        }

//if (key==null){
//    if (key2==null){
//        Iterable<Staff> staffIterable = staffService.findAll();
//        model.addAttribute("staff", staffIterable);
//        return "showlist";
//    }
//    else {
//        Iterable<Staff> staffIterable = staffService.findAllBySalaryGreaterThan(2000);
//        model.addAttribute("staff", staffIterable);
//        return "showlist";
//    }
//
//}else {
//    Iterable<Staff> staffIterable = staffService.findByNameContaining(key);
//    model.addAttribute("staff", staffIterable);
//    return "showlist";
//}

    }

    @GetMapping("/add")
    public String showAdd() {
        return "add";
    }

    @PostMapping("/add")
    public String saveAdd(Staff staff, Long departmentId) {
        Optional<Department> department = departmentService.findById(departmentId);
        staff.setDepartment(department.get());
        staffService.save(staff);
        return "redirect:";
    }

}
