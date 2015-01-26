package br.com.infnet.calculanotas;

public class Dados {

	/* Dados em memória do programa */

	// Valores padrão (quando iniciado o programa)
	private final int pesoAv1P	      = 30;
	private final int pesoAv2P	      = 70;
	private final int aprovacaoSemAv3P    = 60;
	private final int aprovacaoComAv3P    = 50;
	private final boolean arredondamentoP = true;

	// Valores que podem ser alterados(configurações)
	private int pesoAv1	       = pesoAv1P;
	private int pesoAv2	       = pesoAv2P;
	private int aprovacaoSemAv3    = aprovacaoSemAv3P;
	private int aprovacaoComAv3    = aprovacaoComAv3P;
	private boolean arredondamento = arredondamentoP;

	// Pega dados padrão
	public static Dados getDadosP(){
		Dados dados = new Dados();
		dados.getPesoAv1P();
		dados.getPesoAv2P();
		dados.getAprovacaoSemAv3P();
		dados.getAprovacaoComAv3P();
		dados.getArredondamentoP();
		return dados;
	}

	// Salva novos dados
	public void setDados(int pesoAv1, int pesoAv2, int aprovacaoSemAv3, int aprovacaoComAv3, boolean arredondamento){
		this.setPesoAv1(pesoAv1);
		this.setPesoAv2(pesoAv2);
		this.setAprovacaoSemAv3(aprovacaoSemAv3);
		this.setAprovacaoComAv3(aprovacaoComAv3);
		this.setArredondamento(arredondamento);
	}

	public int getPesoAv1() {
		return pesoAv1;
	}

	public void setPesoAv1(int pesoAv1) {
		this.pesoAv1 = pesoAv1;
	}

	public int getPesoAv2() {
		return pesoAv2;
	}

	public void setPesoAv2(int pesoAv2) {
		this.pesoAv2 = pesoAv2;
	}

	public int getAprovacaoSemAv3() {
		return aprovacaoSemAv3;
	}

	public void setAprovacaoSemAv3(int aprovacaoSemAv3) {
		this.aprovacaoSemAv3 = aprovacaoSemAv3;
	}

	public int getAprovacaoComAv3() {
		return aprovacaoComAv3;
	}

	public void setAprovacaoComAv3(int aprovacaoComAv3) {
		this.aprovacaoComAv3 = aprovacaoComAv3;
	}

	public int getPesoAv1P() {
		return pesoAv1P;
	}

	public int getPesoAv2P() {
		return pesoAv2P;
	}

	public int getAprovacaoSemAv3P() {
		return aprovacaoSemAv3P;
	}

	public int getAprovacaoComAv3P() {
		return aprovacaoComAv3P;
	}

	public boolean getArredondamento() {
		return arredondamento;
	}

	public void setArredondamento(boolean arredondamento) {
		this.arredondamento = arredondamento;
	}

	public boolean getArredondamentoP() {
		return arredondamentoP;
	}

}
