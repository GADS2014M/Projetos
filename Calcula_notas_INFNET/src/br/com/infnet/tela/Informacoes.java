package br.com.infnet.tela;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;

public class Informacoes extends JDialog {
	// Serial default(não sei usar ainda)
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Informacoes dialog = new Informacoes();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					// Centraliza na tela
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Informacoes() {
		setType(Type.UTILITY);
		setTitle("Informa\u00E7\u00F5es");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Informacoes.class.getResource("/br/com/infnet/tela/imagens/ico_calculator.png")));
		setBounds(100, 100, 401, 431);
		getContentPane().setLayout(null);

		JButton btFechar = new JButton("Fechar");
		btFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Fecha janela
				Informacoes.this.dispose();
			}
		});
		btFechar.setBounds(153, 375, 89, 23);
		getContentPane().add(btFechar);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Explica\u00E7\u00F5es sobre notas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 375, 358);
		getContentPane().add(panel);
		panel.setLayout(null);

		JTextArea tx1 = new JTextArea();
		tx1.setFont(new Font("Monospaced", Font.PLAIN, 14));
		tx1.setBackground(SystemColor.control);
		tx1.setEditable(false);
		tx1.setLineWrap(true);
		tx1.setText("- Preenchendo somente AV1 e AV3, AV3 recebe o peso de AV2.");
		tx1.setBounds(10, 21, 355, 40);
		panel.add(tx1);

		JTextArea tx2 = new JTextArea();
		tx2.setFont(new Font("Monospaced", Font.PLAIN, 14));
		tx2.setText("- Preenchendo somente AV2 e AV3, AV3 recebe o peso de AV1.");
		tx2.setLineWrap(true);
		tx2.setEditable(false);
		tx2.setBackground(SystemColor.menu);
		tx2.setBounds(10, 76, 355, 40);
		panel.add(tx2);

		JTextArea tx3 = new JTextArea();
		tx3.setFont(new Font("Monospaced", Font.PLAIN, 14));
		tx3.setText("- Preenchendo somente AV3, AV3 vale 100%.");
		tx3.setLineWrap(true);
		tx3.setEditable(false);
		tx3.setBackground(SystemColor.menu);
		tx3.setBounds(10, 131, 355, 24);
		panel.add(tx3);

		JTextArea tx4 = new JTextArea();
		tx4.setFont(new Font("Monospaced", Font.PLAIN, 14));
		tx4.setText("- Preenchendo todos(AV1, AV2 e AV3), AV1 e AV2 recebem seus pesos + AV3 dividido por 2.");
		tx4.setLineWrap(true);
		tx4.setEditable(false);
		tx4.setBackground(SystemColor.menu);
		tx4.setBounds(10, 170, 355, 47);
		panel.add(tx4);

		JTextArea tx5 = new JTextArea();
		tx5.setFont(new Font("Monospaced", Font.PLAIN, 14));
		tx5.setText("- Com op\u00E7\u00E3o de arredondamento de nota ativado, valores abaixo ou igual a 0,4 recebem 0 e valores maiores ou igual a 0,5 recebem 1.");
		tx5.setLineWrap(true);
		tx5.setEditable(false);
		tx5.setBackground(SystemColor.menu);
		tx5.setBounds(10, 232, 355, 76);
		panel.add(tx5);

		JTextArea tx6 = new JTextArea();
		tx6.setEditable(false);
		tx6.setFont(new Font("Tahoma", Font.BOLD, 13));
		tx6.setText("OBS: Nota vazio \u00E9 igual a n\u00E3o fez, nota 0 igual a fez.");
		tx6.setLineWrap(true);
		tx6.setBackground(SystemColor.menu);
		tx6.setBounds(10, 323, 355, 20);
		panel.add(tx6);

	}
}
