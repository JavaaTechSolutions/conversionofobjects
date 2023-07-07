package com.sc.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XmlRootElement(name = "employee")
@XmlType(propOrder = { "name", "designation", "age", "salary" })
public class Employee {
	private String name;

	private String salary;

	private String designation;

	private String age;
}
