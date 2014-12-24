package br.com.infnet.calculanotas;

import java.awt.Color;

import javax.swing.JLabel;

public class Funcoes {

	/* Funções do programa */

	// Calcula nota
	public static float calculaNota(int av1, int pesoAv1, int av2, int pesoAv2, int av3){
		int naoFez	   = -1;
		int notaMinima = 0;

		/* Possibilidades */
		if(av3 == naoFez && av1 >= notaMinima && av2 >= notaMinima){
			// av1 + av2
			return aplicaPeso(av1, pesoAv1) + aplicaPeso(av2, pesoAv2);
		}else if(av1 == naoFez && av2 == naoFez){
			// Somente av3
			return av3;
		}else if(av1 == naoFez){
			// av2 + av3(recebe o peso da av1)
			// Caso av3 for vazio(-1), recebe zero
			if(av3 == -1){
				av3 = 0;
			}
			return aplicaPeso(av2, pesoAv2) + aplicaPeso(av3, pesoAv1);
		}else if(av2 == naoFez){
			// av1 + av3
			// Caso av3 for vazio(-1), recebe zero
			if(av3 == -1){
				av3 = 0;
			}
			return aplicaPeso(av1, pesoAv1) + aplicaPeso(av3, pesoAv2);
		}else{
			// av1 + av2 + av3
			return (((aplicaPeso(av1, pesoAv1) + aplicaPeso(av2, pesoAv2)) + av3) / 2);
		}
	}

	// Aplica peso
	private static float aplicaPeso(int valor, int peso){
		return (valor * ((float) peso / 100));
	}

	// Calcula status (Aprovado ou Reprovado)
	public static void calculaStatus(int nota, int av3, int aprovacaoSemAv3, int aprovacaoComAv3, JLabel txResultadoStatus){
		if(av3 == -1){
			// Não fez av3
			if(nota >= aprovacaoSemAv3){
				txResultadoStatus.setForeground(Color.GREEN);
				txResultadoStatus.setText("Aprovado");
			}else{
				txResultadoStatus.setForeground(Color.RED);
				txResultadoStatus.setText("Reprovado");
			}
		}else{
			// Fez av3
			if(nota >= aprovacaoComAv3){
				txResultadoStatus.setForeground(Color.GREEN);
				txResultadoStatus.setText("Aprovado");
			}else{
				txResultadoStatus.setForeground(Color.RED);
				txResultadoStatus.setText("Reprovado");
			}
		}
	}

}
