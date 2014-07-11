package tn.edu.esprit.cinfo2.tunRecrute.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class SubscribeRecruiter extends JFrame {
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

	JLabel organizationName = new JLabel("Organization Name");
	JButton valider = new JButton("Valider");
	JButton SignIn = new JButton("Sign In");
	JButton annuler = new JButton("Annuler");

	// static JTextField user, mdp;

	public SubscribeRecruiter() {

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
		JTextField loginField = new JTextField();
		panelCentre.add(loginField);
		panelCentre.add(password);
		JPasswordField passwordField = new JPasswordField();
		panelCentre.add(passwordField);
		panelCentre.add(firstName);
		JTextField firstNameField = new JTextField();
		panelCentre.add(firstNameField);
		panelCentre.add(lastName);
		JTextField lastNameField = new JTextField();
		panelCentre.add(lastNameField);
		panelCentre.add(email);
		JTextField emailField = new JTextField();
		panelCentre.add(emailField);
		panelCentre.add(dateOfBirth);
		JFormattedTextField dateOfBirthField = new JFormattedTextField(
				new SimpleDateFormat("yyyy-MM-dd"));
		dateOfBirthField.setValue(new Date());
		panelCentre.add(dateOfBirthField);
		panelCentre.add(organizationName);
		panelBas.add(valider);
		valider.addActionListener(null);
		panelBas.add(annuler);

		/* Ajout du texte de panelConnexion */
		panelConnexion.add(new JLabel("INSCRIPTION"));
	}

}
