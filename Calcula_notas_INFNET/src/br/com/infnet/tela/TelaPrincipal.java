package br.com.infnet.tela;

import java.awt.EventQueue;
import br.com.infnet.calculanotas.*;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class TelaPrincipal extends JFrame {
	private JTextField edAv1;
	private JTextField edAv2;
	private JTextField edAv3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					// Janela visivel
					frame.setVisible(true);
					// Centraliza na tela
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setTitle("Calculadora de Notas");
		setBounds(100, 100, 250, 335);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuTopo = new JMenuBar();
		menuTopo.setToolTipText("");
		setJMenuBar(menuTopo);

		JMenu mnConfigurar = new JMenu("Configurar");
		menuTopo.add(mnConfigurar);

		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Sobre
				JOptionPane.showMessageDialog(null,"Versão: " + Main.getVersao() + "\n" + "Criado por: " + Main.getCriadores());
			}
		});
		menuTopo.add(mnSobre);
		getContentPane().setLayout(null);

		JLabel txTitulo = new JLabel("Calculadora de Notas");
		txTitulo.setBounds(0, 14, 235, 25);
		txTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		txTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(txTitulo);

		JPanel panelNotasMateria = new JPanel();
		panelNotasMateria.setBorder(new TitledBorder(null, "Nota por mat\u00E9ria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNotasMateria.setBounds(16, 55, 203, 206);
		getContentPane().add(panelNotasMateria);
		panelNotasMateria.setLayout(null);

		JLabel txFezAv3 = new JLabel("Fez AV3:");
		txFezAv3.setBounds(43, 85, 61, 14);
		panelNotasMateria.add(txFezAv3);

		JLabel txAv1 = new JLabel("AV1: ");
		txAv1.setBounds(62, 29, 36, 14);
		panelNotasMateria.add(txAv1);

		edAv1 = new JTextField();
		edAv1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		edAv1.setBounds(103, 26, 46, 20);
		panelNotasMateria.add(edAv1);
		edAv1.setColumns(5);

		JLabel txAv2 = new JLabel("AV2: ");
		txAv2.setBounds(62, 57, 36, 14);
		panelNotasMateria.add(txAv2);

		edAv2 = new JTextField();
		edAv2.setToolTipText("");
		edAv2.setBounds(103, 54, 46, 20);
		panelNotasMateria.add(edAv2);
		edAv2.setColumns(5);

		JLabel txAv3 = new JLabel("AV3: ");
		txAv3.setBounds(62, 117, 36, 14);
		panelNotasMateria.add(txAv3);

		edAv3 = new JTextField();
		edAv3.setEnabled(false);
		edAv3.setToolTipText("");
		edAv3.setColumns(5);
		edAv3.setBounds(103, 114, 46, 20);
		panelNotasMateria.add(edAv3);

		JLabel txStatus = new JLabel("Resultado:");
		txStatus.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txStatus.setBounds(20, 173, 80, 21);
		panelNotasMateria.add(txStatus);

		JLabel txNota = new JLabel("Nota:");
		txNota.setHorizontalAlignment(SwingConstants.RIGHT);
		txNota.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txNota.setBounds(20, 149, 80, 21);
		panelNotasMateria.add(txNota);

		JLabel txResultadoNota = new JLabel("");
		txResultadoNota.setHorizontalAlignment(SwingConstants.LEFT);
		txResultadoNota.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txResultadoNota.setBounds(105, 149, 80, 21);
		panelNotasMateria.add(txResultadoNota);

		JLabel txResultadoStatus = new JLabel("");
		txResultadoStatus.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txResultadoStatus.setBounds(105, 173, 80, 21);
		panelNotasMateria.add(txResultadoStatus);

		JRadioButton rdAv3Sim = new JRadioButton("Sim");
		rdAv3Sim.setBounds(95, 81, 50, 23);
		panelNotasMateria.add(rdAv3Sim);

		final JRadioButton rdAv3Nao = new JRadioButton("N\u00E3o");
		rdAv3Nao.setSelected(true);
		rdAv3Nao.setBounds(146, 81, 50, 23);
		panelNotasMateria.add(rdAv3Nao);

	}
}
