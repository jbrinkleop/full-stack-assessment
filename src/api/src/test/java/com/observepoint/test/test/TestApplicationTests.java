package com.observepoint.test.test;

import com.observepoint.test.test.controller.DepartmentDetailsController;
import com.observepoint.test.test.controller.EmployeeDetailsController;
import com.observepoint.test.test.dao.EmployeeDao;
import com.observepoint.test.test.model.Employees;
import com.observepoint.test.test.model.ServerResponse;
import com.observepoint.test.test.model.response.EmployeeDetailsResponse;
import com.observepoint.test.test.service.EmployeeDetailsService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class TestApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	EmployeeDetailsController employeeDetailsController;

	@Autowired
	DepartmentDetailsController departmentDetailsController;

	@InjectMocks
	private EmployeeDetailsService employeeDetailsService;

	@Mock
	private EmployeeDetailsService employeeDetailServiceMock;

	@Mock
	private EmployeeDao employeeDao;

	@Test
	void contextLoads() throws Exception {
		assertThat(employeeDetailsController).isNotNull();
		assertThat(departmentDetailsController).isNotNull();
	}

	@Test
	public void shouldReturnEmployeeDetails() throws Exception {
		List<Employees> employeeList = new ArrayList<Employees>();
		Employees employees = new Employees();
		employees.setId(1);
		employees.setFirstName("Test");
		employees.setLastName("User");
		employees.setGender("Female");
		employees.setJobTitle("Software Engineer");
		List<String> matchingEmails = new ArrayList<>();
		matchingEmails.add("test.user");
		String uniqueEmail = employeeDetailsService.generateUniqueEmailId(matchingEmails,"test.user");
		when(employeeDetailServiceMock.generateUniqueEmailId(matchingEmails, "test.user")).thenReturn(uniqueEmail);
		employees.setEmailId(uniqueEmail);
		employeeList.add(employees);
		EmployeeDetailsResponse response = new EmployeeDetailsResponse(true, "null");
		response.setEmployeeList(employeeList);
		when(employeeDetailServiceMock.getEmployeeDetails()).thenReturn(response);
		assertEquals(response.getMessage(), "null");
		assertEquals(response.isStatus(), true);
		assertSame(response.getEmployeeList(),employeeList );
	}
}




