package salariati.test;

import org.junit.Before;
import org.junit.Test;
import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.validator.EmployeeValidator;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class EmployeeFieldsTest {

	private EmployeeValidator employeeValidator;
	private Employee employee;

	@Before
	public void setUp() {
		employeeValidator = new EmployeeValidator();
		employee = new Employee("Ardelean", "1234567891234", DidacticFunction.ASISTENT, "1234");
	}
	
	@Test
	public void testValidLastName() {
		employee.setLastName("ValidLastName");
		assertTrue(employeeValidator.isValid(employee));
	}
	
	@Test
	public void testInvalidLastName() {
		employee.setLastName("Invalid#LastName");
		assertFalse(employeeValidator.isValid(employee));
		employee.setLastName("Invalid!@1");
		assertFalse(employeeValidator.isValid(employee));
	}
	
	@Test
	public void testValidCNP() {
		assertTrue(employeeValidator.isValid(employee));
		employee.setCnp("1910509055057");
		assertTrue(employeeValidator.isValid(employee));
	}

	
	@Test
	public void testValidSalary() {
		assertTrue(employeeValidator.isValid(employee));
		employee.setSalary("1500");
		assertTrue(employeeValidator.isValid(employee));
	}
	
	@Test
	public void testInvalidSalary() {
		employee.setSalary("asdf");
		assertFalse(employeeValidator.isValid(employee));
		employee.setSalary("123v");
		assertFalse(employeeValidator.isValid(employee));
		employee.setSalary("");
		assertFalse(employeeValidator.isValid(employee));
		employee.setSalary("0");
		assertFalse(employeeValidator.isValid(employee));
	}

}
