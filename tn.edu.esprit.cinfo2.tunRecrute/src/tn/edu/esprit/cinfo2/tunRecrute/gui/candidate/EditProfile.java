package tn.edu.esprit.cinfo2.tunRecrute.gui.candidate;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import tn.edu.esprit.cinfo2.tunRecrute.domain.Candidate;
import tn.edu.esprit.cinfo2.tunRecrute.gui.SignIn;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.CandidateImpl;

public class EditProfile extends JFrame {
	/**
* 
*/
	private static final long serialVersionUID = 1L;

	private Candidate candidate;

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	JPanel panelHaut, panelBas, panelGauche, panelDroite, panelCentre,
			panelConnexion;

	// static JTextField user, mdp;

	public EditProfile(final Candidate candidate) {

		super();
		this.setCandidate(candidate);

		/* Initialisation du JFrame */
		this.setSize(new Dimension(300, 200));
		// On ne pourra pas agrandir la fenetre intitul�e.
		this.setResizable(true);
		this.setLocationRelativeTo(null);
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
		panelCentre.setBorder(new TitledBorder("Edit Profile"));
		panelCentre.add(panelConnexion);

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Home");
		menu.setMnemonic(KeyEvent.VK_H);

		menuBar.add(menu);
		JMenuItem menuItemHome = new JMenuItem("home", KeyEvent.VK_H);

		menu.add(menuItemHome);
		ActionListener homeActionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomeCandidate homeCandidate= new HomeCandidate(candidate);
				homeCandidate.setVisible(true);
			}
		};
		
		menuItemHome.addActionListener(homeActionListener);

		// Build second menu in the menu bar.
		menu = new JMenu("Profile");
		menu.setMnemonic(KeyEvent.VK_P);


		JMenuItem menuItem = new JMenuItem("Show Profile", KeyEvent.VK_S);

		menu.add(menuItem);
		
		ActionListener showProfile = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ShowProfile  showProfile = new ShowProfile(candidate);
				showProfile.setVisible(true);
			}
		};
		
		menuItem.addActionListener(showProfile);
		
		JMenuItem menuItem11 = new JMenuItem("Edit Profile", KeyEvent.VK_E);

		menu.add(menuItem11);
		
		ActionListener editProfileAction = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				EditProfile editProfile = new EditProfile(candidate);
				editProfile.setVisible(true);
			}
		};
		menuItem11.addActionListener(editProfileAction);

		JMenuItem menuItem111 = new JMenuItem("Unsubscribe", KeyEvent.VK_U);
		
		menu.add(menuItem111);

		menuBar.add(menu);

		menu = new JMenu("Job Offers");
		menu.setMnemonic(KeyEvent.VK_O);
	
		JMenuItem menuItem1111 = new JMenuItem("List", KeyEvent.VK_U);

		menu.add(menuItem1111);
		
		ActionListener listJobOfferAction= new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ListJobOffers listJobOffers= new ListJobOffers(candidate);
				listJobOffers.setVisible(true);
			}
		};
		
		menuItem1111.addActionListener(listJobOfferAction);
		JMenuItem menuItem11111 = new JMenuItem("Search", KeyEvent.VK_U);

		
		menu.add(menuItem11111);
		menuBar.add(menu);

		menu = new JMenu("Job Applications");
		menu.setMnemonic(KeyEvent.VK_A);
JMenuItem menuItemJobApp = new JMenuItem("List", KeyEvent.VK_U);

		
		menu.add(menuItemJobApp);
		
		ActionListener jobApplicationAction= new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ListCandidateOffers listCandidateOffers = new ListCandidateOffers(candidate);
				listCandidateOffers.setVisible(true);
			}
		};
		menuItemJobApp.addActionListener(jobApplicationAction);
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
				+ this.getCandidate().getLogin()));
		panelConnexion.add(logOut);
		
		JLabel login = new JLabel("Login : ");
		final JTextField  loginField = new JTextField(candidate.getLogin());
		JLabel password = new JLabel("Password : ");
		final JPasswordField passwordField = new JPasswordField(candidate.getPassword());
		JLabel firstName = new JLabel("First Name : ");
		final JTextField firstNameField = new JTextField(candidate.getFirstName());
		JLabel lastName = new JLabel("Last Name : ");
		final JTextField lastNameField = new JTextField(candidate.getLastName());
		JLabel email = new JLabel("Email : ");
		final JTextField emailField = new JTextField(candidate.getEmail());
		JLabel dateOfBirth = new JLabel("Date Of Birth : ");
		final JTextField dateOfBirthField = new JTextField(candidate.getDateOfBirth().toString());
		JLabel resume = new JLabel("Resume : ");
		final JTextArea resumeArea = new JTextArea(candidate.getResume());
		JLabel cv = new JLabel("CV : ");
		final JTextField cvField = new JTextField(candidate.getCvPath());
		
	
		panelCentre.add(login);
		panelCentre.add(loginField);
		panelCentre.add(password);
		panelCentre.add(passwordField);
		panelCentre.add(firstName);
		panelCentre.add(firstNameField);
		panelCentre.add(lastName);
		panelCentre.add(lastNameField);
		panelCentre.add(email);
		panelCentre.add(emailField);
		panelCentre.add(dateOfBirth);
		panelCentre.add(dateOfBirthField);
		panelCentre.add(resume);
		panelCentre.add(resumeArea);
		panelCentre.add(cv);
		panelCentre.add(cvField);
		
		JButton update = new JButton("Update Profile");
		ActionListener updateAction = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date date = formatter.parse(dateOfBirthField.getText());
					CandidateImpl candidateImpl= new CandidateImpl();
					Candidate newCandidate = new Candidate(candidate.getId(), loginField.getText(), passwordField.getText(), firstNameField.getText(), lastNameField.getText(), emailField.getText(), date, candidate.getIdCandidate(), resumeArea.getText(), cvField.getText());
					candidateImpl.update(candidate.getIdCandidate(), newCandidate);
					dispose();
					ShowProfile showProfile = new ShowProfile(newCandidate);
					showProfile.setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
			}
		};
		
		update.addActionListener(updateAction);
		panelCentre.add(update);
	}
}
