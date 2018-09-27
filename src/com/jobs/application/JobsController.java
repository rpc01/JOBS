package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Manager;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();

	public JobsController(){
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Manager manager = new Manager(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
	}

	public void createVolunteer(String name, String address, String phone, String description) throws Exception{
		Volunteer volunteer = new Volunteer(name, address, phone, description);
		repository.addMember(volunteer);
	}

	public void payAllEmployees() {
		List<AbsStaffMember> staff = repository.getAllMembers();
		for (AbsStaffMember member : staff) {
			member.pay();
		}
	}



	public List<MemberDTO> getAllEmployees() throws Exception{
		List<AbsStaffMember> staff = repository.getAllMembers();
		List<MemberDTO> result = new ArrayList<>();
		for (AbsStaffMember m: staff){
			result.add(new MemberDTO(m));
		}
		return result;
	}

}
