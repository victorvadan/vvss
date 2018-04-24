package salariati.test;

import static org.junit.Assert.*;

import salariati.controller.UIController;
import salariati.model.Employee;

import org.junit.Before;
import org.junit.Test;

import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.repository.mock.EmployeeMock;
import salariati.validator.EmployeeValidator;
import salariati.controller.EmployeeController;
import salariati.enumeration.DidacticFunction;

import java.util.List;

public class AddEmployeeTest {

	private UIController uiController;

	@Before
	public void setUp() {
		EmployeeRepositoryInterface employeeRepository  = new EmployeeMock();
		EmployeeController controller 					= new EmployeeController(employeeRepository);
		EmployeeValidator employeeValidator 			= new EmployeeValidator();
		uiController   									= new UIController(controller, employeeValidator);
	}

	@Test
	public void testAddNewEmployee_BVA_nonvalid() {
		String result;
		//test salary
		result = uiController.addEmployee("Vasile", "1960405125786", DidacticFunction.ASISTENT, "9");
		assertEquals("Error to add: Vasile;1960405125786;ASISTENT;9", result);
        //test name length
        result = uiController.addEmployee("Va", "1960405125786", DidacticFunction.ASISTENT, "100");
        assertEquals("Error to add: Va;1960405125786;ASISTENT;100", result);
        //test cnp length
        result = uiController.addEmployee("Vasile","196040512578",DidacticFunction.ASISTENT,"100");
        assertEquals("Error to add: Vasile;196040512578;ASISTENT;100",result);
        //test cnp length
        result = uiController.addEmployee("Vasile","19604051257890",DidacticFunction.ASISTENT,"100");
        assertEquals("Error to add: Vasile;19604051257890;ASISTENT;100",result);

    }


	@Test
	public void testAddNewEmployee_BVA_valid(){
		String result;
		//test salary
		result = uiController.addEmployee("Vasile", "1960405125786", DidacticFunction.ASISTENT, "10");
		assertEquals("Added: Vasile;1960405125786;ASISTENT;10", result);
		//test cnp length
        result = uiController.addEmployee("Vasile", "1960405125786", DidacticFunction.ASISTENT, "1000");
        assertEquals("Added: Vasile;1960405125786;ASISTENT;1000", result);
        //test name lenth
        result = uiController.addEmployee("Vas", "1960405125786", DidacticFunction.ASISTENT, "1000");
        assertEquals("Added: Vas;1960405125786;ASISTENT;1000", result);
    }


	@Test
	public void testAddNewEmployee_ECP_nonvalid() {
		String result;
		//test salary
		result = uiController.addEmployee("Vasile", "1960405125786", DidacticFunction.ASISTENT, "-100");
		assertEquals("Error to add: Vasile;1960405125786;ASISTENT;-100", result);
		//test Name
        result = uiController.addEmployee("vasile", "1960405125786", DidacticFunction.ASISTENT, "100");
        assertEquals("Error to add: vasile;1960405125786;ASISTENT;100", result);
        //test Name
        result = uiController.addEmployee("Vasil3", "1960405125786", DidacticFunction.ASISTENT, "100");
        assertEquals("Error to add: Vasil3;1960405125786;ASISTENT;100", result);
    }

	@Test
	public void testAddNewEmployee_ECP_valid(){
		String result;
		//test salary
		result = uiController.addEmployee("Vasile", "1960405125786", DidacticFunction.ASISTENT, "100");
		assertEquals("Added: Vasile;1960405125786;ASISTENT;100", result);
		//test Name
        result = uiController.addEmployee("Vasile", "1960405125786", DidacticFunction.ASISTENT, "100");
        assertEquals("Added: Vasile;1960405125786;ASISTENT;100", result);
	}

    }
