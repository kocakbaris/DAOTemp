package main.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JList;

import java.awt.Dimension;

import main.IEntity;
import main.dao.StudentsMysqlDAO;
import main.dao.AdministratorsMysqlDAO;
import main.model.City;
import main.model.Country;
import main.model.Student;
import main.model.Administrator;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import main.dao.*;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.AbstractListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.DebugGraphics;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JCheckBox;
public class MainFrame extends JFrame{

	boolean flagModifier=false;
	boolean flagAjouter=false;
	private JPanel contentPane;
	AdministratorsMysqlDAO respDAO=new AdministratorsMysqlDAO();
	StudentsMysqlDAO etudDao=new StudentsMysqlDAO();
	Country pays=new Country();
	City localite=new City();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField RespLogin;
	private JTextField RespMdp;
	private JTextField RespNom;
	private JTextField RespPrenom;
	private JTextField textField_8;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField RespEmail;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_19;
	private JList<Administrator> listResponsables;
	private JList listPays;
	private JComboBox<Country> comboBoxPaysAdr;
	private JComboBox<City> comboBoxLocalite;
	private JComboBox<Country> comboBoxNationalite;
	private JComboBox<Country> comboBoxPaysLieuN;
	private JComboBox<City> comboBoxLieuN;
	private JComboBox<Country> comboboxpays;
	private JButton btnModifier;
	private JButton btnSauvegarder;
	private JButton btnNouveau;
	private JButton btnAjouter;
	private JButton btnSupprimer;
	private JButton btnRecuperer;
	private JButton btnCancel;
	private JTextField LocaliteId;
	private JTextField LocaliteCP;
	private JTextField LocaliteLocalite;
	private JButton BtnRespSauver;
	private JButton BtnRespModifier;
	private JButton BtnRespNouveau;
	private JButton BtnRespAjouter;
	private JButton BtnRespSupprimer;
	private JButton BtnRespRecuperer;
	private JTextField PaysId;
	private JTextField PaysNom;
	private JButton buttonPaysSauver;
	private JButton buttonPaysModifier;
	private JButton buttonPaysNouveau;
	private JButton buttonPaysSupprimer;
	private JButton buttonPaysAjouter;
	private JButton buttonPaysRecuperer;
	private JButton buttonPaysCancel;
	private JButton buttonLocModifier;
	private JButton buttonLocSave;
	private JList<City> listLocalite;
	private JButton buttonLocAdd;
	private JButton buttonLocNew;
	private JTextField RespId;
	final DefaultListModel<Student> mymodeletudiants;
	final DefaultListModel<Administrator> mymodelresponsables;
	final DefaultListModel<Country> mymodelpays;
	final DefaultListModel<City> mymodelCity;
	final DefaultListModel<Student> mymodeletudiantsALL;
	final DefaultListModel<Administrator> mymodelresponsablesALL;
	final DefaultListModel<Country> mymodelpaysALL;
	final DefaultListModel<City> mymodelCityALL;
	private JList<Student> listEtudiants;
	/**
	 * Create the frame.
	 */
	public MainFrame() 
	{
		setTitle("Test ALPHA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1088, 706);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Montrer");
		menuBar.add(mnMenu);
		
		JCheckBox chckbxEtudiants = new JCheckBox("Etudiants Supprim\u00E9s");
		mnMenu.add(chckbxEtudiants);
		
		JCheckBox chckbxResponsables = new JCheckBox("Responsables Supprim\u00E9s");
		mnMenu.add(chckbxResponsables);
		
		JCheckBox chckbxPays = new JCheckBox("Pays Supprim\u00E9s");
		mnMenu.add(chckbxPays);
		
		JCheckBox chckbxLocalites = new JCheckBox("Localit\u00E9s Supprim\u00E9es");
		mnMenu.add(chckbxLocalites);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JSplitPane splitPaneEtudiants = new JSplitPane();
		tabbedPane.addTab("Etudiants", null, splitPaneEtudiants, null);
		
		mymodelresponsables = new DefaultListModel<Administrator>();
		mymodelresponsablesALL = new DefaultListModel<Administrator>();
		for (Administrator r : respDAO.getListOfEntity()) 
		{
			mymodelresponsablesALL.addElement(r);
			//JOptionPane.showMessageDialog(null, r.isDel());
			if(r.isDel()==false)
				mymodelresponsables.addElement(r);
		}
		mymodelpays = new DefaultListModel<Country>();
		mymodelpaysALL = new DefaultListModel<Country>();
		for (Country r : pays.getListOfEntity())
		{
			mymodelpaysALL.addElement(r);
			if(r.isDel()==false)
			{
				mymodelpays.addElement(r);
			}
		}
		mymodeletudiants = new DefaultListModel<Student>();
		mymodeletudiantsALL = new DefaultListModel<Student>();
		for (Student r : etudDao.getListOfEntity()) 
		{
			mymodeletudiantsALL.addElement(r);
			if(r.isDel()==false)
				mymodeletudiants.addElement(r);
		}
		mymodelCity = new DefaultListModel<City>();
		mymodelCityALL = new DefaultListModel<City>();
		JPanel leftPanelEtudiants = new JPanel();
		leftPanelEtudiants.setMinimumSize(new Dimension(400, 10));
		splitPaneEtudiants.setLeftComponent(leftPanelEtudiants);
		leftPanelEtudiants.setLayout(new BorderLayout(0, 0));
		
		listEtudiants = new JList<Student>(mymodeletudiants);
		listEtudiants.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if(listEtudiants.getSelectedIndex()>-1)
				{
					Student et=new Student();
					et=mymodeletudiants.getElementAt(listEtudiants.getSelectedIndex());
					textField.setText(et.getLogin());
					textField_1.setText(et.getPassWord());
					textField_2.setText(et.getLastName());
					textField_3.setText(et.getFirstName());
					textField_19.setText(et.getId()+"");
					textField_13.setText(et.getNationalNumber());
					textField_15.setText(et.getDateNaissance());
					textField_16.setText(et.getSexe()+"");
					textField_8.setText(et.getAdress());
					//textField_9.setText(et.getCity());
					textField_10.setText(et.getPhone());
					textField_11.setText(et.getEmail());
					textField_12.setText(et.getGSM());
					//textField_17.setText(et.getNationalite());
					//textField_18.setText(et.getLieudeNaissance());
					
					
					comboBoxLocalite.setEditable(true);
					comboBoxPaysAdr.setEditable(true);
					comboBoxNationalite.setEditable(true);
					comboBoxPaysLieuN.setEditable(true);
					comboBoxLieuN.setEditable(true);
					comboBoxPaysAdr.setSelectedItem(pays.getById(localite.getById(et.getCity()).getIdCountry()));
					//comboBoxLocalite.addItem(localite.getById(et.getCity()));
					
					
					
					//JOptionPane.showMessageDialog(null, localite.getById(et.getCity()));
					//JOptionPane.showMessageDialog(null,pays.getById(localite.getById(et.getCity()).getIdCountry()));
					
					comboBoxPaysLieuN.setSelectedItem(pays.getById(localite.getById(et.getLieudeNaissance()).getIdCountry()));
					comboBoxNationalite.setSelectedItem(pays.getById(et.getNationalite()));
					//comboBoxLieuN.addItem(localite.getById(et.getLieudeNaissance()));
					comboBoxLieuN.setSelectedItem(localite.getById(et.getLieudeNaissance()));
					comboBoxLocalite.setSelectedItem(localite.getById(et.getCity()));
	
					
					comboBoxPaysAdr.setEditable(false);
					comboBoxLocalite.setEditable(false);
					comboBoxNationalite.setEditable(false);
					comboBoxPaysLieuN.setEditable(false);
					comboBoxLieuN.setEditable(false);
				}
			}
		});
		
		leftPanelEtudiants.add(listEtudiants, BorderLayout.CENTER);
		
		JPanel rightPanelEtudiants = new JPanel();
		splitPaneEtudiants.setRightComponent(rightPanelEtudiants);
		rightPanelEtudiants.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(121, 48, 34, 22);
		rightPanelEtudiants.add(lblLogin);
		
		JLabel lblMdp = new JLabel("Mdp:");
		lblMdp.setBounds(129, 78, 29, 22);
		rightPanelEtudiants.add(lblMdp);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setBounds(107, 139, 39, 14);
		rightPanelEtudiants.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom:");
		lblPrenom.setBounds(102, 167, 55, 14);
		rightPanelEtudiants.add(lblPrenom);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(189, 51, 283, 20);
		rightPanelEtudiants.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false); 
		textField_1.setBounds(189, 82, 86, 20);
		rightPanelEtudiants.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(189, 136, 155, 20);
		rightPanelEtudiants.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(189, 164, 155, 20);
		rightPanelEtudiants.add(textField_3);
		textField_3.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(189, 284, 283, 20);
		rightPanelEtudiants.add(textField_8);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(189, 375, 155, 20);
		rightPanelEtudiants.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(189, 406, 283, 20);
		rightPanelEtudiants.add(textField_11);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setBounds(103, 284, 57, 14);
		rightPanelEtudiants.add(lblAdresse);
		
		JLabel lblNewLabel = new JLabel("Localité:");
		lblNewLabel.setBounds(107, 343, 57, 14);
		rightPanelEtudiants.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(102, 412, 55, 14);
		rightPanelEtudiants.add(lblEmail);
		
		JLabel lblTel = new JLabel("Tel:");
		lblTel.setBounds(112, 381, 34, 14);
		rightPanelEtudiants.add(lblTel);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(189, 437, 155, 20);
		rightPanelEtudiants.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(189, 192, 155, 20);
		rightPanelEtudiants.add(textField_13);
		
		JLabel label = new JLabel("Nationalité:");
		label.setBounds(85, 473, 77, 14);
		rightPanelEtudiants.add(label);
		
		JLabel label_1 = new JLabel("Numero National:");
		label_1.setBounds(60, 195, 119, 14);
		rightPanelEtudiants.add(label_1);
		
		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.setColumns(10);
		textField_15.setBounds(189, 222, 128, 20);
		rightPanelEtudiants.add(textField_15);
		
		JLabel lblDateDeNaissance = new JLabel("Date de Naissance:");
		lblDateDeNaissance.setBounds(60, 225, 119, 14);
		rightPanelEtudiants.add(lblDateDeNaissance);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBounds(189, 253, 57, 20);
		rightPanelEtudiants.add(textField_16);
		
		JLabel lblSexe = new JLabel("Sexe:");
		lblSexe.setBounds(112, 256, 39, 14);
		rightPanelEtudiants.add(lblSexe);
		
		JLabel lblGsm = new JLabel("GSM");
		lblGsm.setBounds(107, 443, 55, 14);
		rightPanelEtudiants.add(lblGsm);
		
		JLabel lblLieuDeNaissance = new JLabel("Lieu de Naissance:");
		lblLieuDeNaissance.setBounds(376, 504, 119, 14);
		rightPanelEtudiants.add(lblLieuDeNaissance);
		
		textField_19 = new JTextField();
		textField_19.setEditable(false);
		textField_19.setColumns(10);
		textField_19.setBounds(189, 19, 86, 20);
		rightPanelEtudiants.add(textField_19);
		
		JLabel lblIdEcole = new JLabel("Id Ecole:");
		lblIdEcole.setBounds(109, 18, 56, 22);
		rightPanelEtudiants.add(lblIdEcole);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 529, 543, 100);
		rightPanelEtudiants.add(panel);
		panel.setLayout(null);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(425, 59, 91, 23);
		panel.add(btnCancel);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int id=((Student)mymodeletudiants.getElementAt(listEtudiants.getSelectedIndex())).getId();
				//mymodelCityALL
				((Student)mymodeletudiantsALL.getElementAt(listEtudiants.getSelectedIndex())).setDel(true);
				mymodeletudiants.remove(listEtudiants.getSelectedIndex());
				listEtudiants.setSelectedIndex(0);
				etudDao.deleteById(id);
			}
		});
		//btnSupprimer.addActionListener(this);
		btnSupprimer.setBounds(296, 25, 104, 23);
		panel.add(btnSupprimer);
		btnNouveau = new JButton("Nouveau");
		btnNouveau.setBounds(178, 25, 91, 23);
		panel.add(btnNouveau);
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Student st=new Student();
				//st=mymodeletudiants.getElementAt(listEtudiants.getSelectedIndex());
				//st.setId(Integer.parseInt(textField_19.getText()));
				//st.setLogin(textField.getText());
				st.setPassWord(textField_1.getText());
				st.setLastName(textField_2.getText());
				st.setFirstName(textField_3.getText());
				st.setNationalNumber(textField_13.getText());
				st.setDateNaissance(textField_15.getText());
				st.setSexe(textField_16.getText().charAt(0));
				st.setAdress(textField_8.getText());
				//st.setZipCode(textField_20.getText());
				comboBoxLocalite.setEditable(true);
				st.setCity(((City)comboBoxLocalite.getSelectedItem()).getCode());
				comboBoxLocalite.setEditable(false);
				st.setPhone(textField_10.getText());
				st.setEmail(textField_11.getText());
				st.setGSM(textField_12.getText());
				comboBoxLieuN.setEditable(true);
				st.setLieudeNaissance(((City)comboBoxLieuN.getSelectedItem()).getCode());
				comboBoxLieuN.setEditable(false);
				comboBoxNationalite.setEditable(true);
				st.setNationalite(((Country)comboBoxNationalite.getSelectedItem()).getCode());
				comboBoxNationalite.setEditable(false);
				int id=etudDao.addStudent(st);
				System.out.println(id+"");
				st.setId(id);
				st.setLogin(st.getEmail());
				btnSauvegarder.setEnabled(false);
				btnModifier.setEnabled(true);
				btnNouveau.setEnabled(true);
				btnAjouter.setEnabled(false);
				btnSupprimer.setEnabled(true);
				CloseTextBoxesEtudiant();	
			
				mymodeletudiants.addElement(st);//a la place code dessus..
				/*mymodeletudiants.removeAllElements();//a verifier refresh
				for(Student stud:etudDao.getListOfEntity())
				{
					mymodeletudiants.addElement(stud);
				}*/ 
			}
		});
		btnAjouter.setBounds(178, 59, 91, 23);
		panel.add(btnAjouter);
		
		
		btnAjouter.setEnabled(false);
		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(25, 25, 119, 23);
		panel.add(btnModifier);
		btnSauvegarder = new JButton("Sauvegarder");
		btnSauvegarder.setBounds(25, 59, 119, 23);
		panel.add(btnSauvegarder);
		
		
		btnSauvegarder.setEnabled(false);
		
		btnRecuperer = new JButton("Recuperer");
		btnRecuperer.setEnabled(false);
		btnRecuperer.setBounds(296, 59, 104, 23);
		panel.add(btnRecuperer);
		
		JLabel lblPays = new JLabel("Pays:");
		lblPays.setBounds(109, 318, 46, 14);
		rightPanelEtudiants.add(lblPays);
		
		comboBoxLieuN = new JComboBox<City>();
		comboBoxPaysLieuN = new JComboBox<Country>();
		
		comboBoxPaysAdr = new JComboBox<Country>();
		comboBoxPaysAdr.setEnabled(false);
		comboBoxNationalite = new JComboBox<Country>();
		comboboxpays = new JComboBox<Country>();
		for (Country ctr : pays.getListOfEntity()) 
		{
			if(ctr.isDel()==false)
			{
				comboboxpays.addItem(ctr);
				comboBoxPaysAdr.addItem(ctr);
				comboBoxNationalite.addItem(ctr);
				comboBoxPaysLieuN.addItem(ctr);
			}
		}
		comboBoxPaysAdr.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent arg0)
			{
				//comboBoxLocalite.setEditable(true);
				comboBoxLocalite.removeAllItems();
				for(City ct : localite.getListOfEntity(((Country)comboBoxPaysAdr.getSelectedItem()).getCode())) 
				{
					comboBoxLocalite.addItem(ct);
				}	
				//comboBoxLocalite.setEditable(false);
			} 
		});
		comboBoxPaysLieuN.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent arg0) 
			{
				comboBoxLieuN.removeAllItems();
				
				for(City ct : localite.getListOfEntity(((Country)comboBoxPaysLieuN.getSelectedItem()).getCode())) 
				{
					comboBoxLieuN.addItem(ct);
				}	
			}
		});
		
		comboBoxPaysAdr.setBounds(189, 314, 155, 22);
		rightPanelEtudiants.add(comboBoxPaysAdr);
		
		comboBoxLocalite = new JComboBox<City>();
		comboBoxLocalite.setEnabled(false);
		comboBoxLocalite.setBounds(189, 343, 155, 22);
		rightPanelEtudiants.add(comboBoxLocalite);
		
		
		comboBoxNationalite.setEnabled(false);
		comboBoxNationalite.setBounds(189, 469, 155, 22);
		rightPanelEtudiants.add(comboBoxNationalite);
		
		JLabel label_3 = new JLabel("Pays:");
		label_3.setBounds(95, 504, 46, 14);
		rightPanelEtudiants.add(label_3);
		
		
		comboBoxPaysLieuN.setEnabled(false);
		comboBoxPaysLieuN.setBounds(189, 500, 154, 22);
		rightPanelEtudiants.add(comboBoxPaysLieuN);
		comboBoxLieuN.setEnabled(false);
		comboBoxLieuN.setBounds(499, 500, 149, 22);
		rightPanelEtudiants.add(comboBoxLieuN);
		btnSauvegarder.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{

				//System.out.println("Ok");
				Student st=new Student();
				st=mymodeletudiants.getElementAt(listEtudiants.getSelectedIndex());
				st.setId(Integer.parseInt(textField_19.getText()));
				st.setLogin(textField.getText());
				st.setPassWord(textField_1.getText());
				st.setLastName(textField_2.getText());
				st.setFirstName(textField_3.getText());
				st.setNationalNumber(textField_13.getText());
				st.setDateNaissance(textField_15.getText());
				st.setSexe(textField_16.getText().charAt(0));
				st.setAdress(textField_8.getText());
				//st.setZipCode(textField_20.getText());
				comboBoxLocalite.setEditable(true);
				st.setCity(((City)comboBoxLocalite.getSelectedItem()).getCode());
				comboBoxLocalite.setEditable(false);
				st.setPhone(textField_10.getText());
				st.setEmail(textField_11.getText());
				st.setGSM(textField_12.getText());
				comboBoxLieuN.setEditable(true);
				st.setLieudeNaissance(((City)comboBoxLieuN.getSelectedItem()).getCode());
				comboBoxLieuN.setEditable(false);
				comboBoxNationalite.setEditable(true);
				st.setNationalite(((Country)comboBoxNationalite.getSelectedItem()).getCode());
				comboBoxNationalite.setEditable(false);
				//mymodeletudiants.set(listEtudiants.getSelectedIndex(), st);
				etudDao.updateEntity(st);//Envoi d'un etudiant modifié a la classe StudentsMysqlDao
				//OpenTextBoxesEtudiant();
				
				btnSauvegarder.setEnabled(false);
				btnModifier.setEnabled(true);
				btnNouveau.setEnabled(true);
				btnSupprimer.setEnabled(true);
				CloseTextBoxesEtudiant();				
			}
		});
		
		
		btnModifier.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!textField_19.getText().isEmpty())
				{
					OpenTextBoxesEtudiant();
					
					btnNouveau.setEnabled(false);
					btnModifier.setEnabled(false);
					btnSauvegarder.setEnabled(true);
					btnSupprimer.setEnabled(false);
					btnRecuperer.setEnabled(false);
				}
			}
		});
		btnNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//textField.setEditable(true);//login
				textField_1.setEditable(true);//mdp
				OpenTextBoxesEtudiant();
				ClearTextBoxesEtudiant();
				btnAjouter.setEnabled(true);
				btnNouveau.setEnabled(false);
				btnModifier.setEnabled(false);
				
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnModifier.setEnabled(true);
				btnAjouter.setEnabled(false);
				btnSauvegarder.setEnabled(false);
				btnNouveau.setEnabled(true);
				ClearTextBoxesEtudiant();
				CloseTextBoxesEtudiant();
				textField.setEditable(false);
				textField_1.setEditable(false);
			}
		});
		
		JSplitPane splitPaneResponsables = new JSplitPane();
		tabbedPane.addTab("Responsables", null, splitPaneResponsables, null);
		
		JPanel leftPanelResponsables = new JPanel();
		leftPanelResponsables.setMinimumSize(new Dimension(400, 10));
		splitPaneResponsables.setLeftComponent(leftPanelResponsables);
		leftPanelResponsables.setLayout(new BorderLayout(0, 0));
		
		
		
		
		listResponsables = new JList<Administrator>(mymodelresponsables);
		listResponsables.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e)
			{
				if(listResponsables.getSelectedIndex()>-1)
				{
					Administrator et=new Administrator();
					et=mymodelresponsables.getElementAt(listResponsables.getSelectedIndex());
					RespId.setText(et.getId()+"");
					RespLogin.setText(et.getLogin());
					RespMdp.setText(et.getPassWord());
					RespNom.setText(et.getLastName());
					RespPrenom.setText(et.getFirstName());
					RespEmail.setText(et.getEmail()); 
					//System.out.println(mymodeletudiants.getElementAt(listEtudiants.getSelectedIndex()));
				}
			}
		});
		
		
		
		leftPanelResponsables.add(listResponsables, BorderLayout.CENTER);
		
		JPanel rightPanelResponsables = new JPanel();
		splitPaneResponsables.setRightComponent(rightPanelResponsables);
		rightPanelResponsables.setLayout(null);
		
		JLabel lblLogin_1 = new JLabel("Login:");
		lblLogin_1.setBounds(75, 90, 46, 14);
		rightPanelResponsables.add(lblLogin_1);
		
		JLabel lblMdp_1 = new JLabel("Mdp:");
		lblMdp_1.setBounds(75, 126, 46, 14);
		rightPanelResponsables.add(lblMdp_1);
		
		JLabel lblNom_1 = new JLabel("Nom:");
		lblNom_1.setBounds(75, 168, 46, 14);
		rightPanelResponsables.add(lblNom_1);
		
		JLabel lblPrenom_1 = new JLabel("Prenom:");
		lblPrenom_1.setBounds(75, 204, 46, 14);
		rightPanelResponsables.add(lblPrenom_1);
		
		RespLogin = new JTextField();
		RespLogin.setEditable(false);
		RespLogin.setBounds(131, 87, 146, 20);
		rightPanelResponsables.add(RespLogin);
		RespLogin.setColumns(10);
		
		RespMdp = new JTextField();
		RespMdp.setEditable(false);
		RespMdp.setBounds(131, 123, 146, 20);
		rightPanelResponsables.add(RespMdp);
		RespMdp.setColumns(10);
		
		RespNom = new JTextField();
		RespNom.setEditable(false);
		RespNom.setBounds(131, 165, 146, 20);
		rightPanelResponsables.add(RespNom);
		RespNom.setColumns(10);
		
		RespPrenom = new JTextField();
		RespPrenom.setEditable(false);
		RespPrenom.setBounds(131, 201, 146, 20);
		rightPanelResponsables.add(RespPrenom);
		RespPrenom.setColumns(10);
		
		RespEmail = new JTextField();
		RespEmail.setEditable(false);
		RespEmail.setColumns(10);
		RespEmail.setBounds(131, 232, 146, 20);
		rightPanelResponsables.add(RespEmail);
		
		JLabel label_2 = new JLabel("Email:");
		label_2.setBounds(75, 235, 46, 14);
		rightPanelResponsables.add(label_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(65, 321, 543, 100);
		rightPanelResponsables.add(panel_1);
		
		JButton BtnRespCancel = new JButton("CANCEL");
		BtnRespCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				CloseTextBoxesResponsable();
				ClearTextBoxesResponsable();
				BtnRespAjouter.setEnabled(false);
				BtnRespModifier.setEnabled(true);
				BtnRespNouveau.setEnabled(true);
				BtnRespSauver.setEnabled(false);
			}
		});
		BtnRespCancel.setBounds(425, 59, 91, 23);
		panel_1.add(BtnRespCancel);
		
		BtnRespSupprimer = new JButton("Supprimer");
		BtnRespSupprimer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{ 
				int id=((Administrator)mymodelresponsables.getElementAt(listResponsables.getSelectedIndex())).getId();
				((Administrator)mymodelresponsablesALL.getElementAt(listResponsables.getSelectedIndex())).setDel(true);
				mymodelresponsables.remove(listResponsables.getSelectedIndex());
				listResponsables.setSelectedIndex(0);
				respDAO.deleteById(id);
			}
		});
		//BtnRespSupprimer.addActionListener(this);
		BtnRespSupprimer.setBounds(296, 25, 104, 23);
		panel_1.add(BtnRespSupprimer);
		
		BtnRespNouveau = new JButton("Nouveau");
		BtnRespNouveau.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				OpenTextBoxesResponsable();
				ClearTextBoxesResponsable();
				BtnRespAjouter.setEnabled(true);
				BtnRespModifier.setEnabled(false);
				BtnRespNouveau.setEnabled(false);
				
			}
		});
		BtnRespNouveau.setBounds(178, 25, 91, 23);
		panel_1.add(BtnRespNouveau);
		
		BtnRespAjouter = new JButton("Ajouter");
		BtnRespAjouter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				int a=0;
				CloseTextBoxesResponsable();
				Administrator adm=new Administrator();
				adm.setEmail(RespEmail.getText());
				adm.setLastName(RespNom.getText());
				adm.setFirstName(RespPrenom.getText());
				adm.setLogin(RespLogin.getText());
				adm.setPassWord(RespMdp.getText());
				a=respDAO.addEntity(adm);
				adm.setId(a);
				BtnRespAjouter.setEnabled(false);
				BtnRespModifier.setEnabled(true);
				BtnRespNouveau.setEnabled(true);
				mymodelresponsables.addElement(adm);
				
			}
		});
		BtnRespAjouter.setEnabled(false);
		BtnRespAjouter.setBounds(178, 59, 91, 23);
		panel_1.add(BtnRespAjouter);
		
		BtnRespModifier = new JButton("Modifier");
		BtnRespModifier.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!RespLogin.getText().isEmpty())
				{
					OpenTextBoxesResponsable();
					//BtnRespAjouter.setEnabled(false);
					BtnRespModifier.setEnabled(false);
					BtnRespNouveau.setEnabled(false);
					BtnRespSauver.setEnabled(true);
					BtnRespSupprimer.setEnabled(false);
				}
				
			}
		});
		BtnRespModifier.setBounds(25, 25, 119, 23);
		panel_1.add(BtnRespModifier);
		
		BtnRespSauver = new JButton("Sauvegarder");
		BtnRespSauver.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				//BtnRespAjouter.setEnabled(true);
				BtnRespModifier.setEnabled(true);
				BtnRespNouveau.setEnabled(true);
				BtnRespSauver.setEnabled(false);
				BtnRespSupprimer.setEnabled(true);
				Administrator adm=new Administrator();
				adm=mymodelresponsables.getElementAt(listResponsables.getSelectedIndex());
				adm.setEmail(RespEmail.getText());
				adm.setLastName(RespNom.getText());
				adm.setFirstName(RespPrenom.getText());
				adm.setLogin(RespLogin.getText());
				adm.setPassWord(RespMdp.getText());
				respDAO.updateEntity(adm);
				CloseTextBoxesResponsable();
			}
		});
		BtnRespSauver.setEnabled(false);
		BtnRespSauver.setBounds(25, 59, 119, 23);
		panel_1.add(BtnRespSauver);
		
		BtnRespRecuperer = new JButton("Recuperer");
		BtnRespRecuperer.setEnabled(false);
		BtnRespRecuperer.setBounds(296, 59, 104, 23);
		panel_1.add(BtnRespRecuperer);
		
		RespId = new JTextField();
		RespId.setEnabled(false);
		RespId.setEditable(false);
		RespId.setColumns(10);
		RespId.setBounds(131, 45, 146, 20);
		rightPanelResponsables.add(RespId);
		
		JLabel lblIdresponsable = new JLabel("IdResponsable:");
		lblIdresponsable.setBounds(26, 48, 95, 14);
		rightPanelResponsables.add(lblIdresponsable);
		
		JSplitPane splitPanePays = new JSplitPane();
		tabbedPane.addTab("Pays", null, splitPanePays, null);
		
		JPanel leftPanelPays = new JPanel();
		leftPanelPays.setMinimumSize(new Dimension(400, 10));
		splitPanePays.setLeftComponent(leftPanelPays);
		leftPanelPays.setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSize(new Dimension(400, 10));
		list.setMinimumSize(new Dimension(400, 10));
		
		
		listPays = new JList<Country>(mymodelpays);
		listPays.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e)
			{
				if(listPays.getSelectedIndex()>-1)
				{
					Country ct=new Country();
					ct=mymodelpays.getElementAt(listPays.getSelectedIndex());
					PaysId.setText(ct.getCode()+"");
					PaysNom.setText(ct.getName());
				}
			}
		});
		listPays.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		leftPanelPays.add(listPays, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(listPays);
		//scrollPane.setViewportView(list_1);
		leftPanelPays.add(scrollPane, BorderLayout.CENTER);
		JPanel rightPanelPays = new JPanel();
		splitPanePays.setRightComponent(rightPanelPays);
		rightPanelPays.setLayout(null);
		
		JLabel lblIdpays = new JLabel("IdPays:");
		lblIdpays.setBounds(48, 95, 46, 14);
		rightPanelPays.add(lblIdpays);
		
		PaysId = new JTextField();
		PaysId.setEditable(false);
		PaysId.setColumns(10);
		PaysId.setBounds(110, 92, 103, 20);
		rightPanelPays.add(PaysId);
		
		PaysNom = new JTextField();
		PaysNom.setEditable(false);
		PaysNom.setColumns(10);
		PaysNom.setBounds(110, 128, 287, 20);
		rightPanelPays.add(PaysNom);
		
		JLabel lblNom_2 = new JLabel("Nom:");
		lblNom_2.setBounds(48, 131, 46, 14);
		rightPanelPays.add(lblNom_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(24, 243, 543, 100);
		rightPanelPays.add(panel_2);
		
		buttonPaysCancel = new JButton("CANCEL");
		buttonPaysCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				PaysId.setText("");
				PaysNom.setText("");
				PaysNom.setEditable(false);
				buttonPaysNouveau.setEnabled(true);
				buttonPaysModifier.setEnabled(true);
				buttonPaysAjouter.setEnabled(false);
				buttonPaysSauver.setEnabled(false);
			}
		});
		buttonPaysCancel.setBounds(425, 59, 91, 23);
		panel_2.add(buttonPaysCancel);
		
		buttonPaysSupprimer = new JButton("Supprimer");
		buttonPaysSupprimer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(listPays.getSelectedIndex()>-1)
				{
					int id=((Country)mymodelpays.getElementAt(listPays.getSelectedIndex())).getCode();
					comboBoxNationalite.removeItemAt(listPays.getSelectedIndex());
					comboBoxPaysAdr.removeItemAt(listPays.getSelectedIndex());
					comboBoxPaysLieuN.removeItemAt(listPays.getSelectedIndex());
					comboboxpays.removeItemAt(listPays.getSelectedIndex());
					//((Country)mymodelpays.getElementAt(listPays.getSelectedIndex())).setDel(true);
					((Country)mymodelpaysALL.getElementAt(listPays.getSelectedIndex())).setDel(true);
					mymodelpays.remove(listPays.getSelectedIndex());
					listPays.setSelectedIndex(0);
					pays.deleteById(id);
				}
				
			}
		});
		buttonPaysSupprimer.setBounds(296, 25, 104, 23);
		panel_2.add(buttonPaysSupprimer);
		
		buttonPaysNouveau = new JButton("Nouveau");
		buttonPaysNouveau.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				PaysNom.setEditable(true);
				PaysNom.setText("");
				buttonPaysNouveau.setEnabled(false);
				buttonPaysModifier.setEnabled(false);
				buttonPaysAjouter.setEnabled(true);
				buttonPaysSauver.setEnabled(false);
			}
		});
		buttonPaysNouveau.setBounds(178, 25, 91, 23);
		panel_2.add(buttonPaysNouveau);
		
		buttonPaysAjouter = new JButton("Ajouter");
		buttonPaysAjouter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int a=0;
				Country ctr=new Country();
				
				ctr.setName(PaysNom.getText());
				a=pays.addCountry(ctr);
				ctr.setCode(a);
				
				System.out.println(a+"");
				PaysNom.setEditable(false);
				buttonPaysNouveau.setEnabled(true);
				buttonPaysModifier.setEnabled(true);
				buttonPaysAjouter.setEnabled(false);
				buttonPaysSauver.setEnabled(false);
				mymodelpays.addElement(ctr);
			}
		});
		buttonPaysAjouter.setEnabled(false);
		buttonPaysAjouter.setBounds(178, 59, 91, 23);
		panel_2.add(buttonPaysAjouter);
		
		buttonPaysModifier = new JButton("Modifier");
		buttonPaysModifier.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!PaysId.getText().isEmpty())
				{
					PaysNom.setEditable(true);
					buttonPaysNouveau.setEnabled(false);
					buttonPaysModifier.setEnabled(false);
					buttonPaysAjouter.setEnabled(false);
					buttonPaysSauver.setEnabled(true);
				}
				
			}
		});
		buttonPaysModifier.setBounds(25, 25, 119, 23);
		panel_2.add(buttonPaysModifier);
		
		buttonPaysSauver = new JButton("Sauvegarder");
		buttonPaysSauver.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Country ctr=new Country();
				ctr=mymodelpays.getElementAt(listPays.getSelectedIndex());
				ctr.setName(PaysNom.getText());
				pays.updateCountry(ctr);
				PaysNom.setEditable(false);
				buttonPaysNouveau.setEnabled(true);
				buttonPaysModifier.setEnabled(true);
				buttonPaysAjouter.setEnabled(false);
				buttonPaysSauver.setEnabled(false);
				
			}
		});
		buttonPaysSauver.setEnabled(false);
		buttonPaysSauver.setBounds(25, 59, 119, 23);
		panel_2.add(buttonPaysSauver);
		
		buttonPaysRecuperer = new JButton("Recuperer");
		buttonPaysRecuperer.setEnabled(false);
		buttonPaysRecuperer.setBounds(296, 59, 104, 23);
		panel_2.add(buttonPaysRecuperer);
		
		JSplitPane splitPaneLocalite = new JSplitPane();
		tabbedPane.addTab("Localite", null, splitPaneLocalite, null);
		
		JPanel leftPanelLocalite = new JPanel();
		leftPanelLocalite.setMinimumSize(new Dimension(400, 10));
		splitPaneLocalite.setLeftComponent(leftPanelLocalite);
		
		/*for(Country c:pays.getListOfEntity())
		{
			comboboxpays.addItem(c);
		}*/
		JLabel lblNewLabel_1 = new JLabel("Pays:");
	
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_leftPanelLocalite = new GroupLayout(leftPanelLocalite);
		gl_leftPanelLocalite.setHorizontalGroup(
			gl_leftPanelLocalite.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftPanelLocalite.createSequentialGroup()
					.addGap(42)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(comboboxpays, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(165, Short.MAX_VALUE))
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
		);
		gl_leftPanelLocalite.setVerticalGroup(
			gl_leftPanelLocalite.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftPanelLocalite.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_leftPanelLocalite.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboboxpays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
		);
		
		
	
		listLocalite = new JList<City>(mymodelCity);
		
		listLocalite.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				//System.out.println(listLocalite.getSelectedValue().toString());
				try
				{
					if(listLocalite.getSelectedIndex()>-1)
					{
						System.out.println(listLocalite.getSelectedIndex()+"");
						City ct=new City();
						ct=mymodelCity.getElementAt(listLocalite.getSelectedIndex());
						LocaliteId.setText(ct.getCode()+"");
						LocaliteCP.setText(ct.getZipCode());
						LocaliteLocalite.setText(ct.getName());
					}
					
				}
				catch(Exception ex)
				{
					System.out.print(ex.toString());
				}
			}
		});
		scrollPane_1.setViewportView(listLocalite);
		leftPanelLocalite.setLayout(gl_leftPanelLocalite);
		
		JPanel rightPanelLocalite = new JPanel();
		splitPaneLocalite.setRightComponent(rightPanelLocalite);
		rightPanelLocalite.setLayout(null);
		
		JLabel lblCode = new JLabel("Id_Localite:");
		lblCode.setBounds(55, 53, 92, 14);
		rightPanelLocalite.add(lblCode);
		
		LocaliteId = new JTextField();
		LocaliteId.setEditable(false);
		LocaliteId.setColumns(10);
		LocaliteId.setBounds(172, 50, 146, 20);
		rightPanelLocalite.add(LocaliteId);
		
		LocaliteCP = new JTextField();
		LocaliteCP.setEditable(false);
		LocaliteCP.setColumns(10);
		LocaliteCP.setBounds(172, 86, 146, 20);
		rightPanelLocalite.add(LocaliteCP);
		
		JLabel lblCodepostal = new JLabel("CodePostal:");
		lblCodepostal.setBounds(55, 89, 98, 14);
		rightPanelLocalite.add(lblCodepostal);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(37, 282, 543, 100);
		rightPanelLocalite.add(panel_3);
		
		JButton buttonLocCancel = new JButton("CANCEL");
		buttonLocCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				LocaliteCP.setEditable(false);
				LocaliteLocalite.setEditable(false);
				buttonLocNew.setEnabled(true);
				buttonLocAdd.setEnabled(false);
				buttonLocModifier.setEnabled(true);
				buttonLocSave.setEnabled(false);
			}
		});
		buttonLocCancel.setBounds(425, 59, 91, 23);
		panel_3.add(buttonLocCancel);
		
		JButton buttonLocDel = new JButton("Supprimer");
		buttonLocDel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				int id=((City)mymodelCity.getElementAt(listLocalite.getSelectedIndex())).getCode();
				//((City)mymodelCity.getElementAt(listLocalite.getSelectedIndex())).setDel(true);
				((City)mymodelCityALL.getElementAt(listLocalite.getSelectedIndex())).setDel(true);
				mymodelCity.remove(listLocalite.getSelectedIndex());
				listLocalite.setSelectedIndex(0);
				localite.deleteById(id);
			}
		});
		buttonLocDel.setBounds(296, 25, 104, 23);
		panel_3.add(buttonLocDel);
		
		buttonLocNew = new JButton("Nouveau");
		buttonLocNew.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				ClearTextBoxesLocalite();
				LocaliteCP.setEditable(true);
				LocaliteLocalite.setEditable(true);
				buttonLocNew.setEnabled(false);
				buttonLocAdd.setEnabled(true);
				buttonLocModifier.setEnabled(false);
				buttonLocSave.setEnabled(false);
			}
		});
		buttonLocNew.setBounds(178, 25, 91, 23);
		panel_3.add(buttonLocNew);
		
		buttonLocAdd = new JButton("Ajouter");
		buttonLocAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int a=0;
				//System.out.println(((Country)comboboxpays.getSelectedItem()).getCode());
				City ct=new City();
				ct.setIdCountry(((Country)comboboxpays.getSelectedItem()).getCode());
				ct.setZipCode(LocaliteCP.getText());
				ct.setName(LocaliteLocalite.getText());
				a=localite.addCity(ct);
				ct.setCode(a);
				mymodelCity.addElement(ct);
				LocaliteCP.setEditable(false);
				LocaliteLocalite.setEditable(false);
				buttonLocNew.setEnabled(true);
				buttonLocAdd.setEnabled(false);
				buttonLocModifier.setEnabled(true);
				buttonLocSave.setEnabled(false);
			}
		});
		buttonLocAdd.setEnabled(false);
		buttonLocAdd.setBounds(178, 59, 91, 23);
		panel_3.add(buttonLocAdd);
		
		buttonLocModifier = new JButton("Modifier");
		buttonLocModifier.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!LocaliteId.getText().isEmpty())
				{
					LocaliteCP.setEditable(true);
					LocaliteLocalite.setEditable(true);
					buttonLocAdd.setEnabled(false);
					buttonLocSave.setEnabled(true);
					buttonLocNew.setEnabled(false);
					buttonLocModifier.setEnabled(false);
				}
			}
		});
		buttonLocModifier.setBounds(25, 25, 119, 23);
		panel_3.add(buttonLocModifier);
		
		buttonLocSave = new JButton("Sauvegarder");
		buttonLocSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				City cite=new City();
				//Country ctr=new Country();
				cite=mymodelCity.getElementAt(listLocalite.getSelectedIndex());
				cite.setZipCode(LocaliteCP.getText());
				cite.setName(LocaliteLocalite.getText());
				cite.setIdCountry(((Country)comboboxpays.getSelectedItem()).getCode());
				localite.updateCity(cite);
				LocaliteCP.setEditable(false);
				LocaliteLocalite.setEditable(false);
				buttonLocAdd.setEnabled(false);
				buttonLocSave.setEnabled(false);
				buttonLocNew.setEnabled(true);
				buttonLocModifier.setEnabled(true);
				
			}
		});
		buttonLocSave.setEnabled(false);
		buttonLocSave.setBounds(25, 59, 119, 23);
		panel_3.add(buttonLocSave);
		
		JButton buttonLocRest = new JButton("Recuperer");
		buttonLocRest.setEnabled(false);
		buttonLocRest.setBounds(296, 59, 104, 23);
		panel_3.add(buttonLocRest);
		
		LocaliteLocalite = new JTextField();
		LocaliteLocalite.setEditable(false);
		LocaliteLocalite.setColumns(10);
		LocaliteLocalite.setBounds(172, 123, 146, 20);
		rightPanelLocalite.add(LocaliteLocalite);
		
		JLabel lblNom_3 = new JLabel("Localite:");
		lblNom_3.setBounds(55, 126, 98, 14);
		rightPanelLocalite.add(lblNom_3);
		
		
		comboboxpays.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent arg0) 
			{
				
				//listLocalite_1.setSelectedIndex(0);
				mymodelCityALL.removeAllElements();
				mymodelCity.removeAllElements();
				
				for (City r : localite.getListOfEntity(((Country)comboboxpays.getSelectedItem()).getCode()))
				{
					mymodelCityALL.addElement(r);
					if(r.isDel()==false)
						mymodelCity.addElement(r);
				}
				listLocalite.setSelectedIndex(-1);
				listLocalite.setModel(mymodelCity);
				
			}
		});
		/*.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0) 
			{
				int id=((Student)mymodeletudiants.getElementAt(listEtudiants.getSelectedIndex())).getId();
				etudDao.deleteById(id);
			}
		});*/
		
	}
	public void OpenTextBoxesEtudiant()
	{
		textField_2.setEditable(true);
		textField_3.setEditable(true);
		textField_13.setEditable(true);
		textField_15.setEditable(true);
		textField_16.setEditable(true); 
		textField_8.setEditable(true);
		//textField.setEditable(true);
		comboBoxLocalite.setEnabled(true);
		comboBoxLieuN.setEnabled(true);
		comboBoxNationalite.setEnabled(true);
		comboBoxPaysAdr.setEnabled(true);
		comboBoxPaysLieuN.setEnabled(true);
		//comboBoxLocalite.setEditable(false);
		//comboBoxLieuN.setEditable(false);
		comboBoxNationalite.setEditable(false);
		comboBoxPaysAdr.setEditable(false);
		comboBoxPaysLieuN.setEditable(false);
		textField_1.setEditable(true);
		textField_10.setEditable(true);
		textField_11.setEditable(true);
		textField_12.setEditable(true);
		
	}
	public void ClearTextBoxesEtudiant()
	{
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_19.setText("");
		textField_13.setText("");
		textField_15.setText("");
		textField_16.setText("");
		textField_8.setText("");
		
		textField_10.setText("");
		textField_11.setText("");
		textField_12.setText("");
		
	}
	public void CloseTextBoxesEtudiant()
	{
		textField_2.setEditable(false);
		textField_3.setEditable(false);
		textField_13.setEditable(false);
		textField_15.setEditable(false);
		textField_16.setEditable(false);
		textField_8.setEditable(false);
		//textField_9.setEditable(false);
		textField_10.setEditable(false);
		textField_11.setEditable(false);
		textField_12.setEditable(false);
		textField.setEditable(false);
		textField_1.setEditable(false);
		comboBoxLocalite.setEnabled(false);
		comboBoxLieuN.setEnabled(false);
		comboBoxNationalite.setEnabled(false);
		comboBoxPaysAdr.setEnabled(false);
		comboBoxPaysLieuN.setEnabled(false);
		//textField_17.setEditable(false);
		//textField_18.setEditable(false);
		//textField_20.setEditable(false);
	}
	public void OpenTextBoxesResponsable()
	{
		RespLogin.setEditable(true);
		RespNom.setEditable(true);
		RespPrenom.setEditable(true);
		RespEmail.setEditable(true);
		RespMdp.setEditable(true);
	}
	public void CloseTextBoxesResponsable()
	{
		RespLogin.setEditable(false);
		RespNom.setEditable(false);
		RespPrenom.setEditable(false);
		RespEmail.setEditable(false);
		RespMdp.setEditable(false);
	}
	public void ClearTextBoxesResponsable()
	{ 
		RespLogin.setText("");
		RespNom.setText("");
		RespPrenom.setText("");
		RespEmail.setText("");
		RespMdp.setText("");
	}

	public void ClearTextBoxesLocalite()
	{
		LocaliteId.setText("");
		LocaliteCP.setText("");
		LocaliteLocalite.setText("");
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
