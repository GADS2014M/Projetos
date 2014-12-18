package br.com.infnet.calculanotas;

public class Validacao {
	
	/* Validações do programa */
	
	// Valida uma nota
	public static boolean valida0a100(int n){
		int nMinimo = 0;
		int nMaximo = 100;
		if(n >= nMinimo && n <= nMaximo){
			return true;
		}else{
			return false;
		}
	}

}
