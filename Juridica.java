package AEP20190518;

import java.util.UUID;

public class Juridica extends Pessoa{
	private String cnpj;
	private double capitalSocial;
	private CotaSociedade cotasSociedade;
	
	public String getCnpj() {
		return cnpj;
	}
	
	public boolean validaCnpj(String cnpj) {
		if (cnpj.length() > 0) {
			return true;
		}
		return false;
	}
	
	
	public double getCapitalSocial() {
		return capitalSocial;
	}
	
	public Juridica(String nome, String cnpj, double capitalSocial) {
		super(nome);
		if(validaCnpj(cnpj) == true) {
			this.cnpj = cnpj;
		}
		else {
			throw new RuntimeException("Erro! cnpj invalido.");
		}
		this.capitalSocial = capitalSocial;
	}
	
	public Juridica(UUID id, String nome, String cnpj, double capitalSocial) {
		super(id, nome);
		if(validaCnpj(cnpj) == true) {
			this.cnpj = cnpj;
		}
		else {
			throw new RuntimeException("Erro! cnpj invalido.");
		}
		this.capitalSocial = capitalSocial;
	}
	public void adicionarSocio(Pessoa socio, double percentualDeParticipacao) {
		
	}
	
	public void removerSocio(Pessoa socio) {
		
	}
	
	private class CotaSociedade{
		private double percentualDeParticipacao;
		
		private CotaSociedade(double percentualDeParticipacao) {
			this.percentualDeParticipacao = percentualDeParticipacao;
		}
	}
}
