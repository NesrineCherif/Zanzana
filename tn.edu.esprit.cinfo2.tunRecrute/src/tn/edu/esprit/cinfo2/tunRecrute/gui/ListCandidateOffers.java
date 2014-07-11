package tn.edu.esprit.cinfo2.tunRecrute.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import tn.edu.esprit.cinfo2.tunRecrute.domain.CandidateOffer;
import tn.edu.esprit.cinfo2.tunRecrute.domain.JobOffers;
import tn.edu.esprit.cinfo2.tunRecrute.service.business.Business;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.CandidateOfferImpl;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.JobOffersImpl;

public class ListCandidateOffers extends JFrame {
	/**
* 
*/
	private static final long serialVersionUID = 1L;

	JPanel panelHaut, panelBas, panelGauche, panelDroite, panelCentre,
			panelConnexion;



	// static JTextField user, mdp;

	public ListCandidateOffers() {

		super();

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

		// Create columns names
		String columnNames[] = { "Job Offer", "Candidate", "Status"};

		// Create some data
		String dataValues[][] = null;

		DefaultTableModel model = new DefaultTableModel();

		model.setDataVector(dataValues, columnNames);

		CandidateOfferImpl candidateOfferImpl = new CandidateOfferImpl();

		List<CandidateOffer> candidateOffers = candidateOfferImpl.findAll();
		if (candidateOffers == null) {
			System.out.println("There is no job application found");
		} else {
			Iterator<CandidateOffer> i = candidateOffers.iterator();
			while (i.hasNext()) {

				CandidateOffer candidateOffer = i.next();
				model.addRow(new String[] { candidateOffer.getJobOffer().getName(),
						candidateOffer.getCandidate().getLogin(),
						candidateOffer.getStatus() });

			}
		}

		JTable table = new JTable(model);
		table.setEnabled(false);

		panelCentre.add(table.getTableHeader());
		panelCentre.add(table);
		


		/* Ajout du texte de panelConnexion */
		panelConnexion.add(new JLabel("Job Application List"));

	}

}
