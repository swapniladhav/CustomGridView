package org.nisum.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nisum.constants.EmpRestURIConstants;
import org.nisum.model.Employee;
import org.nisum.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* Handles requests for the Employee service.
*/
@Controller
public class EmployeeController {
    
   private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    
   //Map to store employees, ideally we should use database
   Map<Integer, Employee> empData = new HashMap<Integer, Employee>();
	@Autowired
	private EmployeeService employeeService;
   @RequestMapping(value = EmpRestURIConstants.DUMMY_EMP, method = RequestMethod.GET)
   public @ResponseBody Employee getDummyEmployee() {
       logger.info("Start getDummyEmployee");
       Employee emp = new Employee();
       //emp.setId(9999);
       emp.setName("Dummy");
     //  emp.setCreatedDate(new Date());
       empData.put(9999, emp);
       return emp;
   }
    
   @RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
   public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
       logger.info("Start getEmployee. ID="+empId);
        
       return empData.get(empId);
   }
    
   @RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
   public @ResponseBody List<Employee>  getAllEmployees() {
       logger.info("Start getAllEmployees.");
       List<Employee> emps = new ArrayList<Employee>();
       List<Employee> empList = employeeService.getAllUser();
        
         return empList;
   }
    
   @RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
   public @ResponseBody ResponseEntity<String>  createEmployee(@RequestBody List<Employee> emp) {
       logger.info("Start createEmployee.");
       //  emp.setId((int)(Math.random()*20));
       // emp.setCreatedDate(new Date());
       //List<Employee> empList = new ArrayList<Employee>();
       //empList.add(emp);
       //empData.put(emp.getId(), emp);
       employeeService.connectRepo(emp);
       return new ResponseEntity<String>("Succesfully Registered", HttpStatus.OK);
   }
    
   @RequestMapping(value = EmpRestURIConstants.DELETE_EMP, method = RequestMethod.PUT)
   public @ResponseBody ResponseEntity<String> deleteEmployee(@PathVariable("name") String name) {
       logger.info("Start deleteEmployee.");
       employeeService.deleteUserByName(name);
       return new ResponseEntity<String>("Deleter Successfully",HttpStatus.OK);
   }
    
}
