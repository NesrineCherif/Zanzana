package tn.edu.esprit.cinfo2.tunRecrute.gui.recruiter;

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
import tn.edu.esprit.cinfo2.tunRecrute.domain.Recruiter;
import tn.edu.esprit.cinfo2.tunRecrute.gui.SignIn;

public class CheckJobApplication extends JFrame {
	/**
* 
*/
	private static final long serialVersionUID = 1L;

	private Recruiter recruiter;
	private Candidate candidate;
	private int score;
	

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	JPanel panelHaut, panelBas, panelGauche, panelDroite, panelCentre,
			panelConnexion;

	// static JTextField user, mdp;

	public CheckJobApplication(final Recruiter recruiter,Candidate candidate,int score) {

		super();
		this.setRecruiter(recruiter);
		this.setCandidate(candidate);
		this.setScore(score);
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
		panelCentre.setBorder(new TitledBorder("Show Job Application"));
		panelCentre.add(panelConnexion);

		
		
	

		JLabel firstName = new JLabel("First Name : "+candidate.getFirstName());
		JLabel lastName = new JLabel("Last Name : "+candidate.getLastName());
		JLabel email = new JLabel("Email : "+candidate.getEmail());
		JLabel dateOfBirth = new JLabel("Date Of Birth : "+candidate.getDateOfBirth());
		JLabel resume = new JLabel("Resume : "+candidate.getResume());
		JLabel cv = new JLabel("CV : "+candidate.getCvPath());
		JLabel scoreCandidate = new JLabel("Score : "+score+"%");
		

		panelCentre.add(firstName);
		panelCentre.add(lastName);
		panelCentre.add(email);
		panelCentre.add(dateOfBirth);
		panelCentre.add(resume);
		panelCentre.add(cv);
		panelCentre.add(scoreCandidate);
		
		JButton close= new JButton("Close");
		ActionListener closeAction = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};
		close.addActionListener(closeAction);
		panelCentre.add(close);
	}

}
