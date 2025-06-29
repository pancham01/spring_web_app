package spring.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.model.Employee;

@Controller
public class EmployeeController {

	// Map to store employees
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();

	@GetMapping(value = EmpRestURIConstants.TEST)
	public @ResponseBody Employee getDummyEmployee() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Piyush");
		
		emp.setCreatedDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
		empData.put(1, emp);
		return emp;
	}

	@RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {

		return empData.get(empId);
	}

	@RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
	public @ResponseBody Map getAllEmployees() {
		System.out.println("EmployeeController.getAllEmployees()");
		return empData;
	}
	@RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody Employee createAnEmployee(@RequestBody Employee emp) {
		emp.setCreatedDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		empData.put(emp.getId(), emp);
		return emp;
	}
	@RequestMapping(value = EmpRestURIConstants.CREATE_EMPS, method = RequestMethod.POST)
	public @ResponseBody String createEmployee() {
		System.out.println("DONEEEEEEEEEEE");
		for (int i = 1; i <= 10; i++) {
			Employee emp = new Employee();
			emp.setId(i);
			emp.setName("Piyush "+i);
			
			emp.setCreatedDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
			empData.put(i, emp);
			
		}
		return "10 employees records inserted!!!!!!";
	}

//	@RequestMapping(value = EmpRestURIConstants.DELETE_EMP, method = RequestMethod.DELETE)
	@DeleteMapping(value = EmpRestURIConstants.DELETE_EMP)
	public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
		Employee emp = empData.get(empId);
		empData.remove(empId);
		return emp;
	}

}
