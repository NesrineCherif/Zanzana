package tn.edu.esprit.cinfo2.tunRecrute.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import tn.edu.esprit.cinfo2.tunRecrute.domain.Candidate;
import tn.edu.esprit.cinfo2.tunRecrute.domain.Recruiter;
import tn.edu.esprit.cinfo2.tunRecrute.gui.candidate.HomeCandidate;
import tn.edu.esprit.cinfo2.tunRecrute.gui.candidate.SubscribeCandidate;
import tn.edu.esprit.cinfo2.tunRecrute.gui.recruiter.HomeRecruiter;
import tn.edu.esprit.cinfo2.tunRecrute.gui.recruiter.SubscribeRecruiter;
import tn.edu.esprit.cinfo2.tunRecrute.service.business.Business;

public class SignIn extends JFrame {
	/**
* 
*/
	private static final long serialVersionUID = 1L;

	JPanel panelHaut, panelBas, panelGauche, panelDroite, panelCentre,
			panelConnexion;

	JLabel login = new JLabel("Login");
	final JTextField loginField = new JTextField();
	JLabel password = new JLabel("Mot de passe");
	final JPasswordField passwordField = new JPasswordField();
	JButton signIn = new JButton("Sign In");
	JButton cancel = new JButton("Cancel");

	// static JTextField user, mdp;

	public SignIn() {

		super();

		/* Initialisation du JFrame */
		this.setSize(new Dimension(300, 200));
		// On ne pourra pas agrandir la fenetre intitul�e.
		this.setResizable(false);

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
		panelCentre.setBorder(new TitledBorder("Connexion"));
		panelCentre.add(panelConnexion);
		panelCentre.add(login);
		panelCentre.add(loginField);
		panelCentre.add(password);
		panelCentre.add(passwordField);
		panelBas.add(signIn);
		ActionListener signInAction = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Business business = new Business();
				Map<String, Object> result = business.authentification(
						loginField.getText(), passwordField.getText());
				if (result.isEmpty()) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null,
							"Invalid Account\nSubscribe now ?", "Warning",
							dialogButton);
					if (dialogResult == JOptionPane.YES_OPTION) {
						//
						Object response = JOptionPane.showInputDialog(null,
								"Choose One?", "Subscribe as",
								JOptionPane.QUESTION_MESSAGE, null,
								new String[] { "Recruiter", "Candidate" },
								"Candidate");
						if (response.equals("Candidate")) {
							SubscribeCandidate subscribeCandidate = new SubscribeCandidate();
							subscribeCandidate.setVisible(true);
						} else if (response.equals("Recruiter")) {
							SubscribeRecruiter subscribeRecruiter = new SubscribeRecruiter();
							subscribeRecruiter.setVisible(true);
						}
						dispose();
					}
				} else {
					dispose();

					if (result.get("UserType").equals("Candidate")) {
						HomeCandidate homeCandidate = new HomeCandidate(
								(Candidate) result.get("Value"));
						homeCandidate.setVisible(true);
					} else if (result.get("UserType").equals("Recruiter")) {
						 HomeRecruiter homeRecruiter =new HomeRecruiter((Recruiter) result.get("Value"));
						 homeRecruiter.setVisible(true);
					}
				}
			}

		};

		ActionListener cancelAction = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};

		signIn.addActionListener(signInAction);
		cancel.addActionListener(cancelAction);
		panelBas.add(cancel);

		/* Ajout du texte de panelConnexion */
		panelConnexion.add(new JLabel("CONNEXION"));

	}

}
