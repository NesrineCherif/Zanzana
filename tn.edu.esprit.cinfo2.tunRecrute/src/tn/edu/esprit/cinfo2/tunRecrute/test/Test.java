package tn.edu.esprit.cinfo2.tunRecrute.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import tn.edu.esprit.cinfo2.tunRecrute.domain.Candidate;
import tn.edu.esprit.cinfo2.tunRecrute.domain.CandidateOffer;
import tn.edu.esprit.cinfo2.tunRecrute.domain.JobOffers;
import tn.edu.esprit.cinfo2.tunRecrute.domain.Member;
import tn.edu.esprit.cinfo2.tunRecrute.domain.Recruiter;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.CandidateImpl;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.CandidateOfferImpl;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.JobOffersImpl;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.MemberImpl;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.RecruiterImpl;

public class Test {
	public static void main(String[] args) {

		Date date = new Date();

		 Recruiter recruiter = new Recruiter(0, "jihed1", "00e001", "jiehed",
		 "ben taher", "jihed@gmail.com", date,
		 0, "tritux", "boite dev", "eetunis - montplaisir", "dev", 50, 50000);

		 RecruiterImpl recruiterImpl = new RecruiterImpl();

//		 recruiterImpl.addRecruiter(recruiter);
		// recruiterImpl.deleteRecruiter(26);
		// recruiterImpl.updateRecruiter(13, recruiter);

		// Recruiter result = recruiterImpl.findRecruiterById(13);
		//
		// if (result == null) {
		// System.out.println("Recruiter not found");
		// } else {
		// System.out.println("ID MEMBER : "+result.getId());
		// System.out.println("ID RECRUITER : "+result.getIdRecruiter());
		// }

		// List<Recruiter> recruiters = recruiterImpl.findAll();
		// if (recruiters == null) {
		// System.out.println("There is no recruiters found");
		// } else {
		// Iterator<Recruiter> i = recruiters.iterator();
		// while(i.hasNext()){
		//
		// Recruiter recruiter = i.next();
		// System.out.println(recruiter.getId());
		//
		// }
		// }

		Member member = new Member(0, "administrator", "administrator", "jihed", "bentaher",
				"jihed.bentaher@gmail.com", date);

		MemberImpl memberImpl = new MemberImpl();

		//System.out.println(memberImpl.addMember(member));

		// memberImpl.deleteMember(30);

//		Member result = memberImpl.findMemberById(31);
//
//		if (result == null) {
//			System.out.println("Member not found");
//		} else {
//			System.out.println("ID MEMBER : " + result.getId());
//			
//		}
		//memberImpl.updateMember(35, member);
		
//		List<Member> members = memberImpl.findAll();
//		if (members == null) {
//			System.out.println("There is no recruiters found");
//		} else {
//			Iterator<Member> i = members.iterator();
//			while (i.hasNext()) {
//
//				Member member2 = i.next();
//				System.out.println(member2.getId());
//
//			}
//		}
//		Candidate candidate = new Candidate(0, "azz", "azzz", "zzzb", "vzzz", "emailzzz", date, 0, "resumezzz", "cvPathzzzz");
//		
//		CandidateImpl candidateImpl=new CandidateImpl();
//		
//		candidateImpl.addCandidate(candidate);
//		candidateImpl.deleteCandidate(40);
//		
//		Candidate result = candidateImpl.findCandidateById(4);
//		
//				if (result == null) {
//					System.out.println("Candidate not found");
//				} else {
//					System.out.println("ID MEMBER : " + result.getId());
//					
//				}
//				
//				List<Candidate> candidates = candidateImpl.findAll();
//				if (candidates == null) {
//					System.out.println("There is no candidates found");
//				} else {
//					Iterator<Candidate> i = candidates.iterator();
//					while (i.hasNext()) {
//		
//						Candidate candidate2 = i.next();
//						System.out.println(candidate2.getId());
//		
//					}
//				}
//				candidateImpl.updateCandidate(4, candidate);
//				JobOffers offer =  new JobOffers(0, "dev java/jee", "description dev java/jee", "www.google.com", 15);
//				
//				JobOffersImpl jobOffersImpl = new JobOffersImpl();
//				
//				jobOffersImpl.addJobOffer(offer);
//				
//				jobOffersImpl.deleteJobOffer(1);
//				
//				jobOffersImpl.updateJobOffer(2, offer);
//				
//				JobOffers result = jobOffersImpl.findJobOffersById(4);
////				
//						if (result == null) {
//							System.out.println("Job Offer not found");
//						} else {
//							System.out.println("ID RECRUITER : " + result.getIdRecruiter());
//							
//						}
//						System.out.println("find all");
//						
//						List<JobOffers> jobOffers = jobOffersImpl.findAll();
//						if (jobOffers == null) {
//							System.out.println("There is no job offers found");
//						} else {
//							Iterator<JobOffers> i = jobOffers.iterator();
//							while (i.hasNext()) {
//				
//								JobOffers jobOffers2 = i.next();
//								System.out.println(jobOffers2.getId());
//				
//							}
//						}
		
		CandidateOffer candidateOffer = new CandidateOffer(0, 5, 5);
		
		CandidateOfferImpl candidateOfferImpl = new CandidateOfferImpl();
		
		
		candidateOfferImpl.addCandidateOffer(candidateOffer);
		
		candidateOfferImpl.deleteCandidateOffer(4);
		
		
		CandidateOffer result = candidateOfferImpl.findCandidateOfferById(5);
//	
			if (result == null) {
				System.out.println("Candidate_Job_Offer not found");
			} else {
				System.out.println("ID Candidate : " + result.getIdCandidate());
				
			}
			
			
			System.out.println("find all");
//			
			List<CandidateOffer> candidateOffers = candidateOfferImpl.findAll();
			if (candidateOffers == null) {
				System.out.println("There is no candidate_offers found");
			} else {
				Iterator<CandidateOffer> i = candidateOffers.iterator();
				while (i.hasNext()) {
	
					CandidateOffer candidateOffer2 = i.next();
					System.out.println(candidateOffer2.getId());
	
				}
			}
			candidateOfferImpl.updateCandidateOffer(1, candidateOffer);	
	}	
}
