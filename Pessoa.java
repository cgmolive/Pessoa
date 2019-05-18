package AEP20190518;
import java.util.UUID;

public abstract class Pessoa {
	private UUID id;
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public UUID getId() {
		return id;
	}
	public Pessoa (String nome) {
		this.nome = nome;
	}
	public Pessoa (UUID id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	

}
