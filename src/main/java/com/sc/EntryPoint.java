package com.sc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.sc.dto.Employee;
import com.sc.dto.WrapperEmployee;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class EntryPoint {

	public static void main(String[] args) throws JAXBException {
		List<Employee> employeeList = new ArrayList<>();

		Employee emp1 = new Employee();
		emp1.setName("John");
		emp1.setAge("35");
		emp1.setDesignation("Software Engineer");
		emp1.setSalary("$1000");

		Employee emp2 = new Employee();
		emp2.setName("Allen");
		emp2.setAge("32");
		emp2.setDesignation("Software Engineer");
		emp2.setSalary("$1000");

		employeeList.add(emp1);
		employeeList.add(emp2);

		WrapperEmployee wrapperEmployee = new WrapperEmployee();
		wrapperEmployee.setAddress("London");
		wrapperEmployee.setName("conversion of object");
		wrapperEmployee.setEmployeeList(employeeList);

//		convertObjectToXML(wrapperEmployee);
		convertXMLToObject();
	}

	private static void convertObjectToXML(WrapperEmployee wrapperEmployee) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(WrapperEmployee.class);
		Marshaller m = jaxbContext.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(wrapperEmployee, System.out);
		m.marshal(wrapperEmployee, new File("emp.xml"));

	}

	private static void convertXMLToObject() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(WrapperEmployee.class);
		Unmarshaller um = jaxbContext.createUnmarshaller();

		WrapperEmployee wrapperEmployee = (WrapperEmployee) um.unmarshal(new File("emp.xml"));

		for (Employee emp : wrapperEmployee.getEmployeeLists()) {
			System.out.println(emp);
		}

	}

}
