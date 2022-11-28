package br.edu.infnet.pedido.model.entidade;

public class Especialidade {

    private Long codigo;
    private String nome;

    public Especialidade(Long codigo) {
        this.codigo = codigo;
    }

    public Especialidade(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Especialidade{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                '}';
    }
}
