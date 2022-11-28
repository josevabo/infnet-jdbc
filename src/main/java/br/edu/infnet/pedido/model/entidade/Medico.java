package br.edu.infnet.pedido.model.entidade;

public class Medico {

	private Long codigo;

	private String nome;
	private String crm;

	private Especialidade especialidade;

	public Medico(String nome, String crm, Especialidade especialidade) {
		this.nome = nome;
		this.crm = crm;
		this.especialidade = especialidade;
	}

	public Medico(String nome) {
		super();
		this.nome = nome;
	}

	public Medico(String nome, Long codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}

	public Medico(Long codigo, String nome, String crm) {
		this.codigo = codigo;
		this.nome = nome;
		this.crm = crm;
	}

	public Medico(Long codigo, String nome, String crm, Especialidade especialidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.crm = crm;
		this.especialidade = especialidade;
	}


	public Long getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	@Override
	public String toString() {
		return "Médico [codigo=" + codigo + ", nome=" + nome + ", CRM=" + crm + ", Especialidade=" + especialidade + "]";
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}
}
