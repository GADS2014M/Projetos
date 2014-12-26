package br.com.infnet.calculanotas.validacao;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validacao {

	/* Valida��es de notas */

	// Verifica se ultrapassou o m�ximo da nota
	public static void verificaLimiteNota(int valor, JTextField edAv){
		if(valor > 100){
			JOptionPane.showMessageDialog(null, "Valor m�ximo ultrapassado");
			edAv.setText("");
		}
	}

	// Verifica se fez a avalia��o
	public static int verificaSeFez(JTextField numero){
		if(numero.getText().equals("") == true){
			// N�o, retorna -1
			return -1;
		}else{
			// Sim, retorna o valor em int
			return Integer.valueOf(numero.getText());
		}
	}

	// Verifica se todos est�o vazios
	public static boolean verificaTodosVazios(int av1, int av2, int av3){
		if((av1 == -1) && (av2 == -1) && (av3 == -1)){
			return true;
		}else{
			return false;
		}
	}

}
