package com.careerdevs.intro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class EmployeeController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/employee")
    public String getEmployeeMain(){
        return "Hello, Welcome to the Employee page";
    }

    @GetMapping("/employee/defaultEmployee")
    public Employee defaultEmployee(){
        return new Employee(42,"David","Jones");
    }

    @GetMapping("/employee/newEmployee")
    public Employee employeeRequest(@RequestParam(value="firstName",defaultValue = "First Name") String firstName,
                             @RequestParam(value="lastName",defaultValue = "Last Name") String lastName){
        return new Employee(
                counter.incrementAndGet(),
                String.format("First name is %s", firstName),
                String.format("Last name is %s", lastName)
        );
    }

    @GetMapping("/employee/{firstName}/{lastName}")
    public Employee employeePath(@PathVariable(value = "firstName")String firstName, @PathVariable(value = "lastName") String lastName){
        return new Employee(counter.incrementAndGet(),String.format("First name is %s", firstName),
                String.format("Last name is %s", lastName)
        );
    }
}
