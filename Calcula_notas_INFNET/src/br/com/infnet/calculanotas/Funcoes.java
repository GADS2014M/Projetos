package br.com.infnet.calculanotas;

public class Funcoes {

	/* Funções do programa */

	// Calcula nota
	public static int calculaNota(int av1, int pesoAv1, int av2, int pesoAv2, int av3){
		// Aplica peso na av1
		av1 = (int) (av1 * ((float) pesoAv1 / 100));
		// Aplica peso na av2
		av2 = (int) (av2 * ((float) pesoAv2 / 100));
		// Calcula resultado
		if(av3 == 0){
			// Não fez av3
			return av1 + av2;
		}else{
			// Fez av3
			return ((av1 + av2) + av3) / 2;
		}
	}

	// Calcula status
	public static String calculaStatus(int av3, int nota, int aprovacaoCP, int aprovacaoPF){
		// Nota de aprovação muda caso esteja em av3
		if(av3 == 0){
			if(nota >= aprovacaoCP){
				return "Aprovado";
			}else{
				return "Reprovado";
			}
		}else{
			if(nota >= aprovacaoPF){
				return "Aprovado";
			}else{
				return "Reprovado";
			}
		}
	}

}
