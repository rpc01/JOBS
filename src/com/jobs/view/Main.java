package com.jobs.view;

import com.jobs.application.JobsController;
import com.jobs.application.MemberDTO;

import java.util.List;

public class Main {



	private static JobsController controller=new JobsController();

	public static void main(String[] args) throws Exception {

		controller.createBossEmployee("Pepe Boss", "Dirección molona", "666666666", 100.0);
		controller.createEmployee("Pedro Employee", "Dirección molona 2", "665266666", 40.0);
		controller.createEmployee("Laura Employee", "Dirección molona 3", "625266666", 45.0);
		controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666", "ITAcademy developer");
		controller.createManagerEmployee("Pedro Manager", "Dirección molona 2", "665226666", 80.0);


		controller.payAllEmployees();

		String allEmployees = new String("");
		List<MemberDTO> members = controller.getAllEmployees();
		for (MemberDTO m:members){
			allEmployees+= m.getName() + ": " + m.getTotalPaid() + "\n";
		}


		System.out.println("EMPLOYEES: " + allEmployees + " \n");

	}

}
