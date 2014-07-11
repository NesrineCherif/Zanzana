package tn.edu.esprit.cinfo2.tunRecrute.gui.candidate;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import tn.edu.esprit.cinfo2.tunRecrute.domain.Candidate;
import tn.edu.esprit.cinfo2.tunRecrute.gui.SignIn;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.CandidateImpl;

public class SubscribeCandidate extends JFrame {
	/**
* 
*/
	private static final long serialVersionUID = 1L;

	JPanel panelHaut, panelBas, panelGauche, panelDroite, panelCentre,
			panelConnexion;

	JLabel login = new JLabel("Login");
	JLabel password = new JLabel("Mot de passe");
	JLabel firstName = new JLabel("firstName");
	JLabel lastName = new JLabel("lastName");
	JLabel email = new JLabel("email");

	JLabel dateOfBirth = new JLabel("dateOfBirth");
	JLabel resume = new JLabel("Resume");
	JLabel cv = new JLabel("CV");
	JButton subscribe = new JButton("Subscribe");
	JButton cancel = new JButton("Cancel");

	// static JTextField user, mdp;

	public SubscribeCandidate() {

		super();

		/* Initialisation du JFrame */
		this.setSize(new Dimension(300, 200));
		// On ne pourra pas agrandir la fenetre intitul�e.
		this.setResizable(true);

		/* R�cup�ration du ContentPane */
		Container contenu = this.getContentPane();

		/* Cr�ation des JPanel avec leur Layout Manager */
		panelHaut = new JPanel(new GridLayout(2, 2));
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
		panelCentre.setBorder(new TitledBorder("Inscription"));
		panelCentre.add(panelConnexion);
		panelCentre.add(login);
		final JTextField loginField = new JTextField();
		panelCentre.add(loginField);
		panelCentre.add(password);
		final JPasswordField passwordField = new JPasswordField();
		panelCentre.add(passwordField);
		panelCentre.add(firstName);
		final JTextField firstNameField = new JTextField();
		panelCentre.add(firstNameField);
		panelCentre.add(lastName);
		final JTextField lastNameField = new JTextField();
		panelCentre.add(lastNameField);
		panelCentre.add(email);
		final JTextField emailField = new JTextField();
		panelCentre.add(emailField);
		panelCentre.add(dateOfBirth);
		final JFormattedTextField dateOfBirthField = new JFormattedTextField(
				new SimpleDateFormat("yyyy-MM-dd"));
		dateOfBirthField.setValue(new Date());
		panelCentre.add(dateOfBirthField);
		panelCentre.add(resume);
		final JTextArea resumeArea = new JTextArea();
		panelCentre.add(resumeArea);
		panelCentre.add(cv);
		final JTextField cvField = new JTextField();
		panelCentre.add(cvField);
		panelBas.add(subscribe);

		panelBas.add(cancel);

		ActionListener subscribeAction = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Candidate candidate = new Candidate(0, loginField.getText(),
						passwordField.getText(), firstNameField.getText(),
						lastNameField.getText(), emailField.getText(),
						(Date) dateOfBirthField.getValue(), 0,
						resumeArea.getText(), cvField.getText());
				CandidateImpl candidateImpl = new CandidateImpl();
				boolean response = candidateImpl.add(candidate);
				if (response == true) {
					SignIn signIn = new SignIn();
					signIn.setVisible(true);
					dispose();
				} else {
					JOptionPane
							.showConfirmDialog(null, "Account already exist");
				}
			}
		};

		ActionListener cancelAction = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SignIn signIn = new SignIn();
				signIn.setVisible(true);
				dispose();
			}
		};

		subscribe.addActionListener(subscribeAction);
		cancel.addActionListener(cancelAction);
		/* Ajout du texte de panelConnexion */
		panelConnexion.add(new JLabel("INSCRIPTION"));
	}

}
