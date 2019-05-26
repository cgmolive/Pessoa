package AEP20190518;

import java.util.UUID;
import java.util.HashSet;
import java.util.Set;

public class Juridica extends Pessoa{
	private String cnpj;
	private double capitalSocial;
	private Set<CotaSociedade> cotasSociedade = new HashSet<>();
	
	
	
	
	public String getCnpj() {
		return cnpj;
	}
	

	public double getCapitalSocial() {
		return capitalSocial;
	}
	
	
	
	public void removerSocio(Pessoa socioParaRemover) {
		Set<CotaSociedade> aux = new HashSet<>();
		for (CotaSociedade cota : cotasSociedade) {
			if (!cota.socio.equals(socioParaRemover)) {
				aux.add(cota);
			}
		}
		this.cotasSociedade = aux;
}
	

	
	
	private double somarPercentualAtual() {
		double percentualAtual = 0.00d;
		for (CotaSociedade cotaSociedade : cotasSociedade) {
			percentualAtual += cotaSociedade.percentualDeParticipacao;
		}
		return percentualAtual;
}
	
	
	public void adicionarSocio(Pessoa socio, double percentualDeParticipacao) {
		CotaSociedade novaCota = new CotaSociedade();
		novaCota.socio = socio;
		novaCota.percentualDeParticipacao = percentualDeParticipacao;
		
		double percentualAtual = somarPercentualAtual();
		if (percentualAtual + percentualDeParticipacao> 100.00) {
			throw new RuntimeException("A participação total não pode exceder 100%! Percentual atual: " + percentualAtual + ". Você tentou adicionar mais " + percentualDeParticipacao);
		}
		
		this.cotasSociedade.add(novaCota);
}
	
	public Juridica(String nome, String cnpj, double capitalSocial) {
		super(nome);
		if (CNPJ.isCNPJ(cnpj) == true) {
			this.cnpj = cnpj;
		}
		else {
			throw new RuntimeException("Erro! cnpj invalido.");
		}
		this.capitalSocial = capitalSocial;
	}
	
	public Juridica(UUID id, String nome, String cnpj, double capitalSocial) {
		super(id, nome);
		if (CNPJ.isCNPJ(cnpj) == true) {
			this.cnpj = cnpj;
		}
		else {
			throw new RuntimeException("Erro! cnpj invalido.");
		}
		this.capitalSocial = capitalSocial;
	}
	
	private class CotaSociedade {
		private double percentualDeParticipacao;
		private Pessoa socio;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((socio == null) ? 0 : socio.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CotaSociedade other = (CotaSociedade) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (socio == null) {
				if (other.socio != null)
					return false;
			} else if (!socio.equals(other.socio))
				return false;
			return true;
		}
		private Juridica getOuterType() {
			return Juridica.this;
		}
		
		
		

	}
}
