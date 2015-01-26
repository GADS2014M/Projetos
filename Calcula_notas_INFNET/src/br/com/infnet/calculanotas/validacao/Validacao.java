package br.com.infnet.calculanotas.validacao;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validacao {
	private Validacao(){} // Construtor

	/* Validações de notas */

	// Verifica se ultrapassou o máximo da nota
	public static int verificaLimiteNota(int valor, JTextField edAv){
		if(valor > 100){
			JOptionPane.showMessageDialog(null, "Valor máximo ultrapassado");
			edAv.setText("");
			return -1;
		}else{
			return valor;
		}
	}

	// Verifica se fez a avaliação
	public static int verificaSeFez(JTextField numero){
		if(numero.getText().equals("") == true){
			// Não, retorna -1
			return -1;
		}else{
			// Sim, retorna o valor em int
			return Integer.valueOf(numero.getText());
		}
	}

	// Verifica se todos estão vazios
	public static boolean verificaTodosVazios(int av1, int av2, int av3){
		if((av1 == -1) && (av2 == -1) && (av3 == -1)){
			return true;
		}else{
			return false;
		}
	}

}
