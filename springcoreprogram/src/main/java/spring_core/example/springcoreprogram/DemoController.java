package spring_core.example.springcoreprogram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Employee emp;

// Constructor Injection
    @Autowired
    public DemoController(Employee emp){
        this.emp = emp;
    }
    // Setter Injection can also performed here too.
//    @Autowired
//    public void setController(Employee emp){
//        this.emp = emp ;
//    }
    @GetMapping("/")
    public String getEmployee(){
      return  emp.getEmployeeDetails();
    }
}
