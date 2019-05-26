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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
}
}
