package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import modelo.Centro;
import modelo.Departamento;
import net.miginfocom.swing.MigLayout;

public class DialogoAnadirDepartamento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodDep;
	private JTextField txtNombre;
	private Controlador controlador;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnPropiedad;
	private JRadioButton rdbtnEnFunciones;
	private JSpinner spn_Presupuesto;
	private JTextField txt_CodCentro;


	/**
	 * Create the dialog.
	 */
	public DialogoAnadirDepartamento() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Detalles del departamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			((TitledBorder)  panel.getBorder()).setTitleFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPanel.add(panel, "cell 0 0,grow");
			panel.setLayout(new MigLayout("", "[55.00][][grow]", "[][][][][]"));
			{
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setIcon(new ImageIcon(DialogoAnadirDepartamento.class.getResource("/images/editar32.png")));
				panel.add(lblNewLabel_3, "cell 0 0 1 4");
			}
			{
				JLabel lblNewLabel = new JLabel("C\u00F3digo:");
				panel.add(lblNewLabel, "cell 1 0,alignx trailing");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				txtCodDep = new JTextField();
				panel.add(txtCodDep, "cell 2 0,growx");
				txtCodDep.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtCodDep.setColumns(10);
			}
			{
				JLabel lblCentro = new JLabel("Centro:");
				lblCentro.setFont(new Font("Dialog", Font.PLAIN, 14));
				panel.add(lblCentro, "cell 1 1,alignx trailing");
			}
			{
				txt_CodCentro = new JTextField();
				panel.add(txt_CodCentro, "cell 2 1,growx");
				txt_CodCentro.setColumns(10);
			}
			{
				JLabel lblTipoDireccin = new JLabel("Tipo Dirección:");
				lblTipoDireccin.setFont(new Font("Dialog", Font.PLAIN, 14));
				panel.add(lblTipoDireccin, "cell 1 2");
			}
			{
				rdbtnPropiedad = new JRadioButton("Propiedad");
				buttonGroup.add(rdbtnPropiedad);
				rdbtnPropiedad.setFont(new Font("Dialog", Font.PLAIN, 14));
				panel.add(rdbtnPropiedad, "flowx,cell 2 2,growx");
			}
			{
				JLabel lblPresupuesto = new JLabel("Presupuesto:");
				lblPresupuesto.setFont(new Font("Dialog", Font.PLAIN, 14));
				panel.add(lblPresupuesto, "cell 1 3,alignx trailing");
			}
			{
				spn_Presupuesto = new JSpinner();
				spn_Presupuesto.setModel(new SpinnerNumberModel(5, 1, 100, 1));
				spn_Presupuesto.setFont(new Font("Dialog", Font.PLAIN, 14));
				panel.add(spn_Presupuesto, "flowx,cell 2 3,alignx left");
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				panel.add(lblNewLabel_1, "cell 1 4,alignx trailing");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				txtNombre = new JTextField();
				panel.add(txtNombre, "cell 2 4,growx");
				txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtNombre.setColumns(10);
			}
			{
				rdbtnEnFunciones = new JRadioButton("En funciones");
				buttonGroup.add(rdbtnEnFunciones);
				rdbtnEnFunciones.setFont(new Font("Dialog", Font.PLAIN, 14));
				panel.add(rdbtnEnFunciones, "cell 2 2,growx");
			}
			{
				JLabel lblNewLabel_2 = new JLabel("(en miles de €)");
				lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 14));
				panel.add(lblNewLabel_2, "cell 2 3,alignx right");
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						recogerDatos();
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected void recogerDatos() {
		
		int codDep = Integer.parseInt(txtCodDep.getText());
		int codCentro = Integer.parseInt(txt_CodCentro.getText());
		String tipo_dir = "";
		if(rdbtnEnFunciones.isSelected()) {
			tipo_dir = "F";
		}else{
			tipo_dir = "P";
		}
		int presupuesto = Integer.parseInt(spn_Presupuesto.getValue().toString());
		String nombre = txtNombre.getText();
		Departamento dep = new Departamento(codDep, codCentro, tipo_dir,presupuesto,nombre);
		controlador.insertaDepartamento(dep);
		
	}


	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
	}

}
