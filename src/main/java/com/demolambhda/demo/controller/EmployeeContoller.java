package com.demolambhda.demo.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
// import java.util.Properties;
// import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.demolambhda.demo.model.Employee;
import com.demolambhda.demo.service.EmpService;
import com.demolambhda.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
@Slf4j

@Controller
public class EmployeeContoller {

Employee emp= new Employee();
Employee emp1 =new Employee();
Employee emp3=new Employee();

@Autowired
EmpService empService;   

@Value( "${taxation.taxAmount}" )
private int TAX_AMNT;

@Value( "${taxation.taxCountry}" )
private String TAX_CNTRY;


@GetMapping(value ="/save")
@ResponseBody
public List<Employee>  saveEmp(){

    takeData();  

    return empService.findAll();
    
    }

    private void takeData() {
        emp.setDept("ATransport");    
        emp.setName("Vikas Kumar Sahu");
        emp.setPhone("8484847838");
        emp.setSal(104440);
    
        emp1.setDept("Cash");    
        emp1.setName("Vikas Kumar Sahu ");
        emp1.setPhone("938474848");
        emp1.setSal(105642);
    
        emp3.setDept("Cash");    
        emp3.setName("Vikas Kumar Sahu");
        emp3.setPhone("34666773");
        emp3.setSal(94448);
    
        empService.save(emp);
        empService.save(emp1);
        empService.save(emp3);
}

    @GetMapping(value = "/demo")
    public ResponseEntity<List<Employee>> show() {
    
        List<Employee> eList= new ArrayList<>(empService.findAll());        
         EmployeeService eService= ()-> System.out.println("Hello Lambda \n");
        
        // creating Comparator object and Adding Chain comparator comapring
        Comparator<Employee> employeeNameComparator = Comparator.comparing(Employee::getName).reversed()
        .thenComparing(Employee::getSal);

    //    Comparator<Employee> eComparator=Comparator.comparing(Employee::getName,(o1,o2)-> o1.compareTo(o2)); // {code ok}
       // java.util.Collections.sort(eList,(o1,o2)-> o1.getPhone().compareToIgnoreCase(o2.getPhone()) ); //{code ok}
    //    java.util.Collections.sort(eList, ((o1, o2) -> o1.getName().compareTo(o2.getName()) )); // {code ok}
               
        java.util.Collections.sort(eList, employeeNameComparator);
        eService.getSortEmp();
        log.info("Printing first element {} and 2nd element is {} ",eList.get(0), eList.get(1));
        return new ResponseEntity<List<Employee>>(eList, HttpStatus.OK);
    }
    /**
     * this method decides whether to show tax or not.
     * @param accepts "yes" or "no"
     * @return list of employee matching
     */
    @GetMapping(value = "/tax/{val}")
    @ResponseBody
    public List<Employee> showTax(@PathVariable String val) {
        List<Employee> tList=empService.findAll().stream().filter((t)->t.getSal()>100000)
        .collect(Collectors.toList());
        Long taxAmnt = calculateTax(tList.get(0).getSal());
        log.info("Tax amount for {} calculated in {} is  {}", tList.get(0).getName(),TAX_CNTRY, taxAmnt);
        log.info("Value is {} is at very best" ,tList );
        return tList;
    }

    @GetMapping(value="/emp/{id}")
    @ResponseBody
    public Employee geteEmployee(@PathVariable long id) {
        return empService
        .findEmployee(id);
    }

    @GetMapping(value="/emp")
    @ResponseBody
    public List<Employee> findEmployees() {
        return empService.findAll();
    }

    private Long calculateTax(long sal) {
        return (TAX_AMNT * sal)/100;
    }

}
