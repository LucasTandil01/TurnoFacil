package Swing;
import Clases.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.Cursor;

public class LoggerPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtBienvenidoPaciente;
	private JFormattedTextField ingresoDni;

	/**
	 * Create the frame.
	 */
	public LoggerPaciente(TurnoFacil sistema) {
		setResizable(false);
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 268, 155);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextField textDni = new JTextField("DNI: ");
		textDni.setBorder(null);
		textDni.setCaretColor(UIManager.getColor("Button.background"));
		textDni.setFocusTraversalKeysEnabled(false);
		textDni.setFocusable(false);
		textDni.setEditable(false);
		textDni.setAutoscrolls(false);
		textDni.setOpaque(false);
		
		textDni.setPreferredSize(new Dimension(2, 14));
		
		txtBienvenidoPaciente = new JTextField("Bienvenido Paciente");
		txtBienvenidoPaciente.setRequestFocusEnabled(false);
		txtBienvenidoPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		txtBienvenidoPaciente.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtBienvenidoPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBienvenidoPaciente.setPreferredSize(new Dimension(2, 14));
		txtBienvenidoPaciente.setOpaque(false);
		txtBienvenidoPaciente.setFocusable(false);
		txtBienvenidoPaciente.setFocusTraversalKeysEnabled(false);
		txtBienvenidoPaciente.setEditable(false);
		txtBienvenidoPaciente.setCaretColor(SystemColor.menu);
		txtBienvenidoPaciente.setBorder(null);
		txtBienvenidoPaciente.setAutoscrolls(false);
						
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		longFormat.setGroupingUsed(false);
		NumberFormatter numberFormatter = new NumberFormatter(longFormat) {
			@Override
		    public Object stringToValue(String text) throws ParseException {
		        if (text.length() == 0)
		            return null;
		        return super.stringToValue(text);
		    }
		};
		numberFormatter.setValueClass(Long.class);
		numberFormatter.setAllowsInvalid(false); 
		numberFormatter.setMinimum(0l);
		ingresoDni = new JFormattedTextField(numberFormatter);
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long dni = Long.valueOf(ingresoDni.getText());
	            irPortalUsuario(dni, sistema);
			}
		});
		ingresoDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){					
		            long dni = Long.valueOf(ingresoDni.getText());
		            irPortalUsuario(dni, sistema);			   					
				}				
			}
		});
		ingresoDni.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addComponent(txtBienvenidoPaciente, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addComponent(textDni, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(btnNewButton))
								.addComponent(ingresoDni, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))))
					.addGap(56))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(txtBienvenidoPaciente, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ingresoDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void irPortalUsuario(long dni, TurnoFacil sistema) {
		sistema.login(dni);
		dispose();
	}
}
