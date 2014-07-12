package tn.edu.esprit.cinfo2.tunRecrute.gui.recruiter;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import tn.edu.esprit.cinfo2.tunRecrute.domain.Candidate;
import tn.edu.esprit.cinfo2.tunRecrute.domain.CandidateOffer;
import tn.edu.esprit.cinfo2.tunRecrute.domain.JobOffers;
import tn.edu.esprit.cinfo2.tunRecrute.domain.Recruiter;
import tn.edu.esprit.cinfo2.tunRecrute.gui.SignIn;
import tn.edu.esprit.cinfo2.tunRecrute.service.business.Business;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.CandidateOfferImpl;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.JobOffersImpl;

public class ListCandidateOffers extends JFrame {
	/**
* 
*/
	private static final long serialVersionUID = 1L;
	private Recruiter recruiter;

	JPanel panelHaut, panelBas, panelGauche, panelDroite, panelCentre,
			panelConnexion;




	public Recruiter getRecruiter() {
		return recruiter;
	}




	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}




	public ListCandidateOffers(final Recruiter recruiter) {

		super();
		this.setRecruiter(recruiter);
		/* Initialisation du JFrame */
		this.setSize(new Dimension(300, 200));
		// On ne pourra pas agrandir la fenetre intitul�e.
		this.setResizable(true);

		/* R�cup�ration du ContentPane */
		Container contenu = this.getContentPane();

		/* Cr�ation des JPanel avec leur Layout Manager */
		panelHaut = new JPanel(new GridLayout(1, 1));
		panelBas = new JPanel(new GridLayout(1, 1));
		panelGauche = new JPanel(new GridLayout(1, 1));
		panelDroite = new JPanel(new GridLayout(1, 1));
		panelCentre = new JPanel(new GridLayout(0, 1));
		panelConnexion = new JPanel();

		/* Ajout des panneaux au ContentPane */
		contenu.add(panelHaut, BorderLayout.NORTH);
		contenu.add(panelBas, BorderLayout.SOUTH);
		contenu.add(panelGauche, BorderLayout.EAST);
		contenu.add(panelDroite, BorderLayout.WEST);
		contenu.add(panelCentre, BorderLayout.CENTER);

		/* Ajout du formulaire de connexion � panelCentre */
		panelCentre.setBorder(new TitledBorder("Job Application"));
		panelCentre.add(panelConnexion);

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Home");
		menu.setMnemonic(KeyEvent.VK_H);
		menu.getAccessibleContext().setAccessibleDescription("zzzzzzzzzzzz");
		menuBar.add(menu);

		// Build second menu in the menu bar.
		menu = new JMenu("Profile");
		menu.setMnemonic(KeyEvent.VK_P);
		menu.getAccessibleContext().setAccessibleDescription(
				"This menu does nothing");

		JMenuItem menuItem = new JMenuItem("Show Profile", KeyEvent.VK_S);

		menuItem.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");
		menu.add(menuItem);
		
		ActionListener showProfile = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		
		JMenuItem menuItem11 = new JMenuItem("Edit Profile", KeyEvent.VK_E);

		menu.add(menuItem11);
		
ActionListener editProfileAction = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
//				EditProfile editProfile = new EditProfile(candidate);
//				editProfile.setVisible(true);
			}
		};
		menuItem11.addActionListener(editProfileAction);

		JMenuItem menuItem111 = new JMenuItem("Unsubscribe", KeyEvent.VK_U);

		menuItem111.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");
		menu.add(menuItem111);

		menuBar.add(menu);

		menu = new JMenu("Job Offers");
		menu.setMnemonic(KeyEvent.VK_O);
		menu.getAccessibleContext().setAccessibleDescription(
				"This menu does nothing");
		JMenuItem menuItem1111 = new JMenuItem("List", KeyEvent.VK_U);

		menuItem1111.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");
		menu.add(menuItem1111);

		JMenuItem menuItem11111 = new JMenuItem("Search", KeyEvent.VK_U);

		menuItem11111.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");
		menu.add(menuItem11111);
		menuBar.add(menu);

		menu = new JMenu("Job Applications");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
				"This menu does nothing");
		menuBar.add(menu);

		panelCentre.add(menuBar);

		JButton logOut = new JButton("Logout");
		ActionListener logoutActionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SignIn signIn = new SignIn();
				signIn.setVisible(true);
				dispose();
			}
		};
		logOut.addActionListener(logoutActionListener);
		/* Ajout du texte de panelConnexion */
		panelConnexion.add(new JLabel("Welcome "
				+ this.getRecruiter().getLogin()));
		panelConnexion.add(logOut);
		
		
		// Create columns names
		String columnNames[] = { "Job Offer", "Candidate", "Score","Status"};

		// Create some data
		String dataValues[][] = null;

		DefaultTableModel model = new DefaultTableModel();

		model.setDataVector(dataValues, columnNames);

		CandidateOfferImpl candidateOfferImpl = new CandidateOfferImpl();

		List<CandidateOffer> candidateOffers = candidateOfferImpl.findAllByRecruiter(recruiter.getIdRecruiter());
		if (candidateOffers == null) {
			System.out.println("There is no job application found");
		} else {
			Iterator<CandidateOffer> i = candidateOffers.iterator();
			while (i.hasNext()) {
				JButton checkJobApplication = new JButton("Check Job Application");
				final CandidateOffer candidateOffer = i.next();
				model.addRow(new String[] { candidateOffer.getJobOffer().getName(),
						candidateOffer.getCandidate().getLogin(),
						candidateOffer.getScore()+"%",candidateOffer.getStatus() });
				ActionListener checkJobActionListener = new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						CheckJobApplication checkJobApplication = new CheckJobApplication(recruiter,candidateOffer.getCandidate(),candidateOffer.getScore());
						checkJobApplication.setVisible(true);
						Business business = new Business();
						business.checkJobApplication(candidateOffer.getId());
						dispose();
						ListCandidateOffers listCandidateOffers = new ListCandidateOffers(recruiter);
						listCandidateOffers.setVisible(true);
					}
				};
				checkJobApplication.addActionListener(checkJobActionListener);
				panelCentre.add(checkJobApplication);
				JButton callForInterview = new JButton("Call for interview");
				ActionListener callForInterviewAction= new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						ListCandidateOffers listCandidateOffers = new ListCandidateOffers(recruiter);
						listCandidateOffers.setVisible(true);
						Business  business = new Business();
						business.callForInterview(candidateOffer.getId());
					}
				};
				callForInterview.addActionListener(callForInterviewAction);
				panelCentre.add(callForInterview);
				JButton hire = new JButton("Hire");
				ActionListener hireAction= new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						ListCandidateOffers listCandidateOffers = new ListCandidateOffers(recruiter);
						listCandidateOffers.setVisible(true);
						Business  business = new Business();
						business.hire(candidateOffer.getId());
					}
				};
				hire.addActionListener(hireAction);
				panelCentre.add(hire);
			}
		}

		JTable table = new JTable(model);
		table.setEnabled(false);

		panelCentre.add(table.getTableHeader());
		panelCentre.add(table);
		

	}

}
