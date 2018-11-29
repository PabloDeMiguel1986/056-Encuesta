package unico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Encuesta {

	private JFrame frmPrincipal;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNumero;
	private JOptionPane ptnInfo;
	private JRadioButton rdbWindows;
	private JRadioButton rdbLinux;
	private JRadioButton rdbMac;
	private JCheckBox chcProgramacion;
	private JCheckBox chcDiseno;
	JCheckBox chcAdministracion;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Encuesta window = new Encuesta();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Encuesta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("Mini encuesta");
		frmPrincipal.setBounds(100, 100, 338, 482);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);
		
		JLabel lblPregunta1 = new JLabel("Elige un sistema operativo");
		lblPregunta1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPregunta1.setBounds(72, 28, 168, 14);
		frmPrincipal.getContentPane().add(lblPregunta1);
		
		JRadioButton rdbWindows = new JRadioButton("Windows");
		buttonGroup.add(rdbWindows);
		rdbWindows.setBounds(102, 53, 109, 23);
		frmPrincipal.getContentPane().add(rdbWindows);
		
		JRadioButton rdbLinux = new JRadioButton("Linux");
		buttonGroup.add(rdbLinux);
		rdbLinux.setBounds(102, 83, 109, 23);
		frmPrincipal.getContentPane().add(rdbLinux);
		
		JRadioButton rdbMac = new JRadioButton("Mac");
		rdbMac.setSelected(true);
		buttonGroup.add(rdbMac);
		rdbMac.setBounds(102, 109, 109, 23);
		frmPrincipal.getContentPane().add(rdbMac);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 148, 254, 2);
		frmPrincipal.getContentPane().add(separator);
		
		JLabel lblEspecialidad = new JLabel("Elige tu especialidad");
		lblEspecialidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspecialidad.setBounds(72, 161, 168, 14);
		frmPrincipal.getContentPane().add(lblEspecialidad);
		
		JCheckBox chcProgramacion = new JCheckBox("Programaci\u00F3n");
		chcProgramacion.setBounds(102, 186, 97, 23);
		frmPrincipal.getContentPane().add(chcProgramacion);
		
		JCheckBox chcDiseno = new JCheckBox("Dise\u00F1o gr\u00E1fico");
		chcDiseno.setSelected(true);
		chcDiseno.setBounds(102, 212, 97, 23);
		frmPrincipal.getContentPane().add(chcDiseno);
		
		JCheckBox chcAdministracion = new JCheckBox("Administraci\u00F3n");
		chcAdministracion.setBounds(102, 240, 97, 23);
		frmPrincipal.getContentPane().add(chcAdministracion);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(33, 275, 254, 2);
		frmPrincipal.getContentPane().add(separator_1);
		
		JSlider sldHoras = new JSlider();
		sldHoras.setMinimum(0);
		sldHoras.setMaximum(24);
		sldHoras.setBounds(87, 313, 200, 26);
		sldHoras.setPaintTicks(true);
		sldHoras.setPaintLabels(true);
		frmPrincipal.getContentPane().add(sldHoras);
		
		JLabel lblNumero = new JLabel("");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setBounds(53, 313, 24, 26);
		frmPrincipal.getContentPane().add(lblNumero);
		
		JOptionPane ptnInfo = new JOptionPane();
		
		JLabel lblHoras = new JLabel("Horas que dedicas en el ordenador");
		lblHoras.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoras.setBounds(72, 288, 168, 14);
		frmPrincipal.getContentPane().add(lblHoras);
		
		sldHoras.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblNumero.setText(String.valueOf(sldHoras.getValue()));
				
			}
		});
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sistema = "";
				String preferencia = "";
				if (rdbWindows.isSelected()) {
					sistema = rdbWindows.getText();
				}if (rdbLinux.isSelected()){
					sistema = rdbLinux.getText();
				}if (rdbMac.isSelected()) {
					sistema = rdbMac.getText();
				}if (chcProgramacion.isSelected()) {
					preferencia = "Programación";
				}if (chcDiseno.isSelected()) {
					if(chcProgramacion.isSelected()) {
						preferencia += ", Diseño gráfico";
					}else {
						preferencia = "Diseño gráfico";
				
				}if (chcAdministracion.isSelected()) {
					if(chcDiseno.isSelected()||chcProgramacion.isSelected()) {
						preferencia = preferencia +  " y administración";
					}else
						preferencia = "administración";
				}
				
				}
				ptnInfo.showMessageDialog(frmPrincipal, ("Su sistema operativo preferido es " + sistema + 
						"\nSu especialidad es :" + preferencia + "\nLas horas que dedica al día son: " + lblNumero.getText()),"Información", JOptionPane.INFORMATION_MESSAGE);
				}
		});
		btnGenerar.setBounds(102, 373, 89, 23);
		frmPrincipal.getContentPane().add(btnGenerar);
		
		
	}
}

