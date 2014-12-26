package br.com.infnet.tela;

import java.awt.EventQueue;
import br.com.infnet.calculanotas.*;
import br.com.infnet.calculanotas.validacao.NumberField;
import br.com.infnet.calculanotas.validacao.Validacao;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class TelaPrincipal extends JFrame {
	// Serial default(não sei usar ainda)
	private static final long serialVersionUID = 1L;
	private static JTextField edAv1;
	private static JTextField edAv2;
	private static JTextField edAv3;
	private static JLabel txResultadoNota;
	private static JLabel txResultadoStatus;
	public  static Dados dados = Dados.getDadosP();

	public static void calculaNota(){
		// Limpa nota
		txResultadoNota.setText("");

		// Limpa resultado
		txResultadoStatus.setText("");

		// Cria e verifica variáveis
		int av1 = Validacao.verificaSeFez(edAv1);
		int av2 = Validacao.verificaSeFez(edAv2);
		int av3 = Validacao.verificaSeFez(edAv3);

		// Verifica se ultrapassa 100(nota máxima)
		Validacao.verificaLimiteNota(av1, edAv1);
		Validacao.verificaLimiteNota(av2, edAv2);
		Validacao.verificaLimiteNota(av3, edAv3);

		// Calcula caso um estiver preechido
		if(Validacao.verificaTodosVazios(av1, av2, av3) == false){
			int nota;
			// Verifica arredondamento
			if(dados.getArredondamento() == true){
				// Calcula a nota (Método Math.round para arredondar valores)
				nota = Math.round(Funcoes.calculaNota(av1, dados.getPesoAv1(), av2, dados.getPesoAv2(), av3));
			}else{
				// Calcula a nota em int sem arredondar
				nota = (int) Funcoes.calculaNota(av1, dados.getPesoAv1(), av2, dados.getPesoAv2(), av3);
			}
			// Exibe
			txResultadoNota.setText("" + nota);
			// Calcula status
			Funcoes.calculaStatus(nota, av3, dados.getAprovacaoSemAv3(), dados.getAprovacaoComAv3(), txResultadoStatus);
		}
	}

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/br/com/infnet/tela/imagens/ico_calculator.png")));
		setResizable(false);
		setTitle("Calculadora de Notas");
		setBounds(100, 100, 255, 363);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuTopo = new JMenuBar();
		menuTopo.setToolTipText("");
		setJMenuBar(menuTopo);

		JMenu mnConfigurar = new JMenu("Configurar");
		mnConfigurar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Configuracoes configura = new Configuracoes();
				// Centraliza na tela
				configura.setLocationRelativeTo(null);
				// Exibe
				configura.setVisible(true);
			}
		});
		menuTopo.add(mnConfigurar);

		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Sobre
				JOptionPane.showMessageDialog(null,"Versão: " + Sobre.getVersao() + "\n" + "Criado por: " + Sobre.getCriadores());
			}
		});

		JMenu mnInformaes = new JMenu("Informa\u00E7\u00F5es");
		mnInformaes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Informacoes info = new Informacoes();
				// Centraliza na tela
				info.setLocationRelativeTo(null);
				// Exibe
				info.setVisible(true);
			}
		});
		menuTopo.add(mnInformaes);
		menuTopo.add(mnSobre);
		getContentPane().setLayout(null);

		JLabel txTitulo = new JLabel("Calculadora de Notas");
		txTitulo.setBounds(0, 14, 249, 25);
		txTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		txTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(txTitulo);

		JPanel panelNotasMateria = new JPanel();
		panelNotasMateria.setBorder(new TitledBorder(null, "Nota por mat\u00E9ria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNotasMateria.setBounds(20, 55, 208, 247);
		getContentPane().add(panelNotasMateria);
		panelNotasMateria.setLayout(null);

		JLabel txAv1 = new JLabel("AV1: ");
		txAv1.setBounds(62, 41, 36, 14);
		panelNotasMateria.add(txAv1);

		edAv1 = new NumberField();
		edAv1.setColumns(5);
		edAv1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				// Verifica
				calculaNota();
			}
		});
		edAv1.setHorizontalAlignment(SwingConstants.CENTER);
		edAv1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		edAv1.setBounds(99, 34, 46, 29);
		panelNotasMateria.add(edAv1);

		JLabel txAv2 = new JLabel("AV2: ");
		txAv2.setBounds(62, 75, 36, 14);
		panelNotasMateria.add(txAv2);

		edAv2 = new NumberField();
		edAv2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				// Verifica
				calculaNota();
			}
		});
		edAv2.setHorizontalAlignment(SwingConstants.CENTER);
		edAv2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		edAv2.setToolTipText("");
		edAv2.setBounds(99, 68, 46, 29);
		panelNotasMateria.add(edAv2);
		edAv2.setColumns(5);

		JLabel txAv3 = new JLabel("AV3: ");
		txAv3.setBounds(62, 109, 36, 14);
		panelNotasMateria.add(txAv3);

		edAv3 = new NumberField();
		edAv3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				// Verifica
				calculaNota();
			}
		});
		edAv3.setHorizontalAlignment(SwingConstants.CENTER);
		edAv3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		edAv3.setToolTipText("");
		edAv3.setColumns(5);
		edAv3.setBounds(99, 102, 46, 29);
		panelNotasMateria.add(edAv3);

		JLabel txStatus = new JLabel("Resultado:");
		txStatus.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txStatus.setBounds(20, 169, 80, 21);
		panelNotasMateria.add(txStatus);

		JLabel txNota = new JLabel("Nota:");
		txNota.setHorizontalAlignment(SwingConstants.RIGHT);
		txNota.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txNota.setBounds(20, 145, 80, 21);
		panelNotasMateria.add(txNota);

		txResultadoNota = new JLabel("");
		txResultadoNota.setHorizontalAlignment(SwingConstants.LEFT);
		txResultadoNota.setFont(new Font("Tahoma", Font.BOLD, 14));
		txResultadoNota.setBounds(105, 145, 80, 21);
		panelNotasMateria.add(txResultadoNota);

		txResultadoStatus = new JLabel("");
		txResultadoStatus.setHorizontalAlignment(SwingConstants.LEFT);
		txResultadoStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		txResultadoStatus.setBounds(105, 169, 80, 21);
		panelNotasMateria.add(txResultadoStatus);

		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Limpa tudo
				edAv1.setText("");
				edAv2.setText("");
				edAv3.setText("");
				txResultadoNota.setText("");
				txResultadoStatus.setText("");
				// Foca o primeiro campo
				edAv1.requestFocus();
			}
		});
		btLimpar.setBounds(22, 203, 165, 30);
		panelNotasMateria.add(btLimpar);

	}
}
