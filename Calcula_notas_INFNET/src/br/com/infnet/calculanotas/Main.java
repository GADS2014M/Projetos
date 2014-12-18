package br.com.infnet.calculanotas;

import javax.swing.JOptionPane;

public class Main {

	/**
	 * @author Josinaldo Albuquerque Barbosa
	 * @turma  GADS2014M
	 * @colaboradores
	 */

	// Versão do programa
	public static float getVersao(){
		return (float) 1.0;
	}

	public static void main(String[] args) {

		/* TESTE MANUALMENTE */
		
		// Nota e peso av1
		int av1 	= 90;
		int pesoAv1	= 30;
		// Nota e peso av2
		int av2		= 60;
		int pesoAv2	= 70;
		// Nota av3 (OBS: tem que ser 0 caso sem nota)
		int av3		= 0;
		
		// Médias de aprovação
		int aprovacaoCP = 60; // CP = av1 e av2
		int aprovacaoPF = 50; // PF = av1, av2 e av3
		
		if((Validacao.valida0a100(av1)	   == true) &&
		   (Validacao.valida0a100(pesoAv1) == true) &&
		   (Validacao.valida0a100(av2)	   == true) &&
		   (Validacao.valida0a100(pesoAv2) == true) &&
		   (Validacao.valida0a100(av3)	   == true)){
			
			// Calcula a nota
			int resultado = Funcoes.calculaNota(av1, pesoAv1, av2, pesoAv2, av3);
			// Status da nota(Aprovado ou Reprovado)
			String status = Funcoes.calculaStatus(av3, resultado, aprovacaoCP, aprovacaoPF);
			// Exibe alerta com as informações
			JOptionPane.showMessageDialog(null, "Versão cod.: " + getVersao() + "\n" + "Resultado: " + resultado + "\n" + "Aluno: " + status);
		}else{
			// Algum dado não passo na validação
			JOptionPane.showMessageDialog(null, "Erro dados.");
		}
		
	}

}
