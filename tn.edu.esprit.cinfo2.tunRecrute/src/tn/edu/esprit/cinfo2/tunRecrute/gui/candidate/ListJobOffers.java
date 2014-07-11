package tn.edu.esprit.cinfo2.tunRecrute.gui.candidate;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import tn.edu.esprit.cinfo2.tunRecrute.domain.Candidate;
import tn.edu.esprit.cinfo2.tunRecrute.domain.CandidateOffer;
import tn.edu.esprit.cinfo2.tunRecrute.domain.JobOffers;
import tn.edu.esprit.cinfo2.tunRecrute.gui.SignIn;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.CandidateOfferImpl;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.JobOffersImpl;

public class ListJobOffers extends JFrame {
	/**
* 
*/
	private static final long serialVersionUID = 1L;

	private Candidate candidate;
	JPanel panelHaut, panelBas, panelGauche, panelDroite, panelCentre,
			panelConnexion;

	// static JTextField user, mdp;

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public ListJobOffers(final Candidate candidate) {

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
		panelCentre.setBorder(new TitledBorder("Job Offers"));
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
				EditProfile editProfile = new EditProfile(candidate);
				editProfile.setVisible(true);
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
				+ this.getCandidate().getLogin()));
		panelConnexion.add(logOut);

		// Create columns names
		String columnNames[] = { "Name", "Description", "Test link",
				"Organization name", "Action" };

		// Create some data
		String dataValues[][] = null;

		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return column == 4;
			}
		};

		model.setDataVector(dataValues, columnNames);
		JTable table = new JTable(model);
		JobOffersImpl jobOffersImpl = new JobOffersImpl();

		List<JobOffers> jobOffers = jobOffersImpl.findAll();
		if (jobOffers == null) {
			System.out.println("There is no job offers found");
		} else {
			Iterator<JobOffers> i = jobOffers.iterator();

			while (i.hasNext()) {
				
				final JobOffers jobOffer = i.next();
				JButton apply= new JButton("Apply for :"+jobOffer.getName());
				model.addRow(new Object[] { jobOffer.getName(),
						jobOffer.getDescription(), jobOffer.getTestLink(),
						jobOffer.getRecruiter().getOrganizationName(), "apply" });
				ActionListener applyActionListener = new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						CandidateOffer candidateOffer= new CandidateOffer(0, candidate, jobOffer, "new");
						CandidateOfferImpl candidateOfferImpl = new CandidateOfferImpl();
						candidateOfferImpl.add(candidateOffer);
						dispose();
						ListCandidateOffers listCandidateOffers = new ListCandidateOffers(candidate);
						listCandidateOffers.setVisible(true);
						Desktop desktop= Desktop.getDesktop();
						
						try {
							desktop.browse(new URI(jobOffer.getTestLink()+"?id="+jobOffer.getId()));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				};
			
				apply.addActionListener(applyActionListener);
				
				panelCentre.add(apply);
			}
		}

		panelCentre.add(table.getTableHeader());
		panelCentre.add(table);

	}

}

