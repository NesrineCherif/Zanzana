package tn.edu.esprit.cinfo2.tunRecrute.gui.candidate;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import tn.edu.esprit.cinfo2.tunRecrute.domain.Candidate;
import tn.edu.esprit.cinfo2.tunRecrute.gui.SignIn;

public class HomeCandidate extends JFrame {
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

	public HomeCandidate(final Candidate candidate) {

		super();
		this.setCandidate(candidate);

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
		panelCentre.setBorder(new TitledBorder("Home"));
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

	}

}
