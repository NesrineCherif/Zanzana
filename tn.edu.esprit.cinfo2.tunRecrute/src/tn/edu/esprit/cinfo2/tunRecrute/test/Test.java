package tn.edu.esprit.cinfo2.tunRecrute.test;

import java.util.Date;

import tn.edu.esprit.cinfo2.tunRecrute.domain.Recruiter;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.RecruiterImpl;

public class Test {
	public static void main(String[] args) {

		Date date = new Date();

		Recruiter recruiter = new Recruiter(0, "jihed1", "00e001", "jiehed", "ben taher", "jihed@gmail.com", date,
				0, "tritux", "boite dev", "eetunis - montplaisir", "dev", 50, 50000);

		RecruiterImpl recruiterImpl = new RecruiterImpl();

		// recruiterImpl.addRecruiter(recruiter);
		// recruiterImpl.deleteRecruiter(26);
		// recruiterImpl.updateRecruiter(13, recruiter)

		Recruiter result = recruiterImpl.findRecruiterById(13);

		if (result == null) {
			System.out.println("Recruiter not found");
		} else {
			System.out.println("ID MEMBER : "+result.getId());
			System.out.println("ID RECRUITER : "+result.getIdRecruiter());
		}
		
	
	}
}
