package AEP20190518;
import java.util.UUID;

public class Fisica extends Pessoa {
	private String cpf;
	private String rg;
	
	
	public String getCpf() {
		return cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public boolean validaRg(String rg) {
		if (rg.length() > 0) {
			return true;
		}
		return false;
	}
	
	
	public Fisica(String nome, String rg, String cpf) {
		super(nome);
		this.rg = rg;
		if (CPF.isCPF(cpf) == true){
			this.cpf = cpf;
		}
		else {
			throw new RuntimeException("Erro! CPF invalido!");
		}
	}

	public Fisica (UUID id, String nome, String rg, String cpf) {
		super(id, nome);
		this.rg = rg;
		if (CPF.isCPF(cpf) == true){
			this.cpf = cpf;
		}
		else {
			throw new RuntimeException("Erro! CPF invalido!");
		}
	}
	
}
