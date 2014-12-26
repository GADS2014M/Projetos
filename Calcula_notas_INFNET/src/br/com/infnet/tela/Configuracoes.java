package br.com.infnet.tela;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.com.infnet.calculanotas.Dados;
import br.com.infnet.calculanotas.validacao.NumberField;
import br.com.infnet.calculanotas.validacao.Validacao;
import javax.swing.JRadioButton;

public class Configuracoes extends JDialog {
	// Serial default(não sei usar ainda)
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private NumberField edPesoAv1;
	private NumberField edPesoAv2;
	private NumberField edAprovacaoSemAv3;
	private NumberField edAprovacaoComAv3;
	private JRadioButton btSim;
	private JRadioButton btNao;

	// Variáveis locais que será enviada
	private int pesoAv1;
	private int pesoAv2;
	private int aprovacaoSemAv3;
	private int aprovacaoComAv3;
	private boolean arredondamento;

	// Instancia TelaPrincipal
	private Dados dados = TelaPrincipal.dados;

	// Pega dados e exibe na tela
	private void pegaDados(){
		// Exibe na tela
		edPesoAv1.setText("" + dados.getPesoAv1());
		edPesoAv2.setText("" + dados.getPesoAv2());
		edAprovacaoSemAv3.setText("" + dados.getAprovacaoSemAv3());
		edAprovacaoComAv3.setText("" + dados.getAprovacaoComAv3());
		if(dados.getArredondamento() == true){
			btSim.setSelected(true);
			btNao.setSelected(false);
		}else{
			btSim.setSelected(false);
			btNao.setSelected(true);
		}
		// Atualiza variáveis locais
		pesoAv1 = dados.getPesoAv1();
		pesoAv2 = dados.getPesoAv2();
		aprovacaoSemAv3 = dados.getAprovacaoSemAv3();
		aprovacaoComAv3 = dados.getAprovacaoComAv3();
		if(dados.getArredondamento() == true){
			arredondamento = true;
		}else{
			arredondamento = false;
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Configuracoes dialog = new Configuracoes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			// Centraliza na tela
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Configuracoes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Configuracoes.class.getResource("/br/com/infnet/tela/imagens/ico_calculator.png")));
		setTitle("Configura\u00E7\u00F5es");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(-13, -52, 275, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Configura\u00E7\u00F5es da calculadora de notas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 249, 260);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Verifica se todos são maiores ou igual a 0
				if((pesoAv1 >= 0) && (pesoAv2 >= 0) && (aprovacaoSemAv3 >= 0) && (aprovacaoComAv3 >= 0)){
					// Salva todos na classe
					TelaPrincipal.dados.setDados(pesoAv1, pesoAv2, aprovacaoSemAv3, aprovacaoComAv3, arredondamento);
					// Exibe mensagem
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
					// Atualiza dados na TelaPrincipal
					TelaPrincipal.calculaNota();
					// Fecha janela
					Configuracoes.this.dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Erro: preecha todos os campos!");
				}
			}
		});
		btSalvar.setBounds(30, 224, 89, 23);
		panel.add(btSalvar);

		JButton btRedefinir = new JButton("Redefinir");
		btRedefinir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Redefini valores padrão
				Dados dados = new Dados();
				edPesoAv1.setText("" + dados.getPesoAv1P());
				edPesoAv2.setText("" + dados.getPesoAv2P());
				edAprovacaoSemAv3.setText("" + dados.getAprovacaoSemAv3P());
				edAprovacaoComAv3.setText("" + dados.getAprovacaoComAv3P());
				if(dados.getArredondamentoP() == true){
					btSim.setSelected(true);
					btNao.setSelected(false);
				}else{
					btSim.setSelected(false);
					btNao.setSelected(true);
				}
				// Redefini variáveis locais
				pesoAv1 = dados.getPesoAv1P();
				pesoAv2 = dados.getPesoAv2P();
				aprovacaoSemAv3 = dados.getAprovacaoSemAv3P();
				aprovacaoComAv3 = dados.getAprovacaoComAv3P();
				arredondamento	= dados.getArredondamentoP();
			}
		});
		btRedefinir.setBounds(132, 224, 89, 23);
		panel.add(btRedefinir);

		JLabel lblPesoAv = new JLabel("Peso AV1: ");
		lblPesoAv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesoAv.setBounds(74, 30, 64, 30);
		panel.add(lblPesoAv);

		JLabel lblPesoAv_1 = new JLabel("Peso AV2: ");
		lblPesoAv_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesoAv_1.setBounds(74, 63, 64, 30);
		panel.add(lblPesoAv_1);

		JLabel lblAprovaoSemAv = new JLabel("Aprova\u00E7\u00E3o SEM AV3: ");
		lblAprovaoSemAv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAprovaoSemAv.setBounds(13, 98, 125, 30);
		panel.add(lblAprovaoSemAv);

		JLabel lblAprovaoComAv = new JLabel("Aprova\u00E7\u00E3o COM AV3: ");
		lblAprovaoComAv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAprovaoComAv.setBounds(13, 132, 125, 30);
		panel.add(lblAprovaoComAv);

		edPesoAv1 = new NumberField();
		edPesoAv1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				// Converte pra int e salva valor
				pesoAv1 = Validacao.verificaSeFez(edPesoAv1);
				// Caso não seja vazio
				if(pesoAv1 >= 0){
					// Verifica se ultrapassa 100(nota máxima)
					Validacao.verificaLimiteNota(pesoAv1, edPesoAv1);
				}
			}
		});
		edPesoAv1.setHorizontalAlignment(SwingConstants.CENTER);
		edPesoAv1.setBounds(148, 30, 50, 30);
		panel.add(edPesoAv1);
		edPesoAv1.setColumns(10);

		edPesoAv2 = new NumberField();
		edPesoAv2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				// Converte pra int e salva valor
				pesoAv2 = Validacao.verificaSeFez(edPesoAv2);
				// Caso não seja vazio
				if(pesoAv2 >= 0){
					// Verifica se ultrapassa 100(nota máxima)
					Validacao.verificaLimiteNota(pesoAv2, edPesoAv2);
				}
			}
		});
		edPesoAv2.setHorizontalAlignment(SwingConstants.CENTER);
		edPesoAv2.setColumns(10);
		edPesoAv2.setBounds(148, 63, 50, 30);
		panel.add(edPesoAv2);

		edAprovacaoSemAv3 = new NumberField();
		edAprovacaoSemAv3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				// Converte pra int e salva valor
				aprovacaoSemAv3 = Validacao.verificaSeFez(edAprovacaoSemAv3);
				// Caso não seja vazio
				if(aprovacaoSemAv3 >= 0){
					// Verifica se ultrapassa 100(nota máxima)
					Validacao.verificaLimiteNota(aprovacaoSemAv3, edAprovacaoSemAv3);
				}
			}
		});
		edAprovacaoSemAv3.setHorizontalAlignment(SwingConstants.CENTER);
		edAprovacaoSemAv3.setColumns(10);
		edAprovacaoSemAv3.setBounds(148, 98, 50, 30);
		panel.add(edAprovacaoSemAv3);

		edAprovacaoComAv3 = new NumberField();
		edAprovacaoComAv3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				// Converte pra int e salva valor
				aprovacaoComAv3 = Validacao.verificaSeFez(edAprovacaoComAv3);
				// Caso não seja vazio
				if(aprovacaoComAv3 >= 0){
					// Verifica se ultrapassa 100(nota máxima)
					Validacao.verificaLimiteNota(aprovacaoComAv3, edAprovacaoComAv3);
				}
			}
		});
		edAprovacaoComAv3.setHorizontalAlignment(SwingConstants.CENTER);
		edAprovacaoComAv3.setColumns(10);
		edAprovacaoComAv3.setBounds(148, 132, 50, 30);
		panel.add(edAprovacaoComAv3);

		JLabel porcentagem1 = new JLabel("%");
		porcentagem1.setHorizontalAlignment(SwingConstants.LEFT);
		porcentagem1.setBounds(200, 30, 29, 30);
		panel.add(porcentagem1);

		JLabel porcentagem2 = new JLabel("%");
		porcentagem2.setHorizontalAlignment(SwingConstants.LEFT);
		porcentagem2.setBounds(200, 63, 29, 30);
		panel.add(porcentagem2);

		JLabel lblMaiorOuIgual = new JLabel(">=");
		lblMaiorOuIgual.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaiorOuIgual.setBounds(200, 98, 29, 30);
		panel.add(lblMaiorOuIgual);

		JLabel label_2 = new JLabel(">=");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setBounds(200, 132, 29, 30);
		panel.add(label_2);

		JLabel lblArredondamento = new JLabel("Arredondamento nota:");
		lblArredondamento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArredondamento.setBounds(0, 166, 138, 30);
		panel.add(lblArredondamento);

		btSim = new JRadioButton("Sim");
		btSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arredondamento = true;
				btSim.setSelected(true);
				btNao.setSelected(false);
			}
		});
		btSim.setBounds(148, 169, 50, 23);
		panel.add(btSim);

		btNao = new JRadioButton("N\u00E3o");
		btNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arredondamento = false;
				btSim.setSelected(false);
				btNao.setSelected(true);
			}
		});
		btNao.setBounds(194, 169, 50, 23);
		panel.add(btNao);

		JLabel txSim = new JLabel("(Sim ex.: 0,5 arredonda pra 1)");
		txSim.setHorizontalAlignment(SwingConstants.CENTER);
		txSim.setBounds(0, 195, 244, 14);
		panel.add(txSim);

		// Atualiza dados ao iniciar
		pegaDados();
	}

}
