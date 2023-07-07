package com.sc.dto;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Setter;

@Setter
@XmlRootElement(namespace = "com.sc.xmlwriting")
public class WrapperEmployee {
	@XmlElementWrapper(name = "employeeList")
	@XmlElement(name = "employee")
	private List<Employee> employeeList;

	private String name;

	private String address;

	public List<Employee> getEmployeeLists() {
		return employeeList;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

}
