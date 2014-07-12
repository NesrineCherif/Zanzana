package tn.edu.esprit.cinfo2.tunRecrute.gui.recruiter;

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
import tn.edu.esprit.cinfo2.tunRecrute.domain.Recruiter;
import tn.edu.esprit.cinfo2.tunRecrute.gui.SignIn;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.CandidateImpl;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.RecruiterImpl;

public class EditProfile extends JFrame {
	/**
* 
*/
	private static final long serialVersionUID = 1L;

	private Recruiter recruiter;

	

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	JPanel panelHaut, panelBas, panelGauche, panelDroite, panelCentre,
			panelConnexion;

	// static JTextField user, mdp;

	public EditProfile(final Recruiter recruiter) {

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
		panelCentre.setBorder(new TitledBorder("Edit Profile"));
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
				dispose();
				ShowProfile  showProfile = new ShowProfile(recruiter);
				showProfile.setVisible(true);
			}
		};
		
		JMenuItem menuItem11 = new JMenuItem("Edit Profile", KeyEvent.VK_E);

		menuItem11.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");
		menu.add(menuItem11);

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
		
		JLabel login = new JLabel("Login : ");
		final JTextField  loginField = new JTextField(recruiter.getLogin());
		JLabel password = new JLabel("Password : ");
		final JPasswordField passwordField = new JPasswordField(recruiter.getPassword());
		JLabel firstName = new JLabel("First Name : ");
		final JTextField firstNameField = new JTextField(recruiter.getFirstName());
		JLabel lastName = new JLabel("Last Name : ");
		final JTextField lastNameField = new JTextField(recruiter.getLastName());
		JLabel email = new JLabel("Email : ");
		final JTextField emailField = new JTextField(recruiter.getEmail());
		JLabel dateOfBirth = new JLabel("Date Of Birth : ");
		final JTextField dateOfBirthField = new JTextField(recruiter.getDateOfBirth().toString());
		JLabel organizationName = new JLabel("Oranization Name : ");
		final JTextField organizationNameField = new JTextField(recruiter.getOrganizationName());
		JLabel organizationDescription = new JLabel("Organization Description : ");
		final JTextArea organizationDescriptionArea = new JTextArea(recruiter.getOrganizationDescription());
		JLabel organizationAddress = new JLabel("Organization Address : ");
		final JTextArea organizationAddressArea = new JTextArea(recruiter.getOrganizationAddress());
		JLabel organizationDomain = new JLabel("Organization Domain : ");
		final JTextField organizationDomainField = new JTextField(recruiter.getOrganizationDomain());
		JLabel employeesNumber = new JLabel("Employees Number : ");
		final JTextField employeesNumberField = new JTextField(""+recruiter.getEmployeesNumber());
		JLabel organizationTurnover = new JLabel("Organization Turnovez : ");
		final JTextField organizationTurnoverField = new JTextField(""+recruiter.getOrganizationTurnover());
	
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
		panelCentre.add(organizationName);
		panelCentre.add(organizationNameField);
		panelCentre.add(organizationDescription);
		panelCentre.add(organizationDescriptionArea);
		panelCentre.add(organizationAddress);
		panelCentre.add(organizationAddressArea);
		panelCentre.add(organizationDomain);
		panelCentre.add(organizationDomainField);
		panelCentre.add(employeesNumber);
		panelCentre.add(employeesNumberField);
		panelCentre.add(organizationTurnover);
		panelCentre.add(organizationTurnoverField);
		
		JButton update = new JButton("Update Profile");
		ActionListener updateAction = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date date = formatter.parse(dateOfBirthField.getText());
					RecruiterImpl recruiterImpl = new RecruiterImpl();
					Recruiter newRecruiter = new Recruiter(recruiter.getId(), loginField.getText(), passwordField.getText(), firstNameField.getText(), lastNameField.getText(), emailField.getText(), date, recruiter.getIdRecruiter(), 
							organizationNameField.getText(), organizationDescriptionArea.getText(),
							organizationAddressArea.getText(), organizationDomainField.getText(),
							Integer.parseInt(employeesNumberField.getText()), Long.parseLong(organizationTurnoverField.getText()));
					recruiterImpl.update(recruiter.getIdRecruiter(), newRecruiter);
					dispose();
					ShowProfile showProfile = new ShowProfile(newRecruiter);
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
