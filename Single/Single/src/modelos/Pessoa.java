package modelos;

public abstract class Pessoa {
    private String nome;
    private Instituicao instituicao;

    public Pessoa(String nome, Instituicao instituicao) {
        this.nome = nome;
        this.instituicao = instituicao;
    }

    public String getNome() {
        return nome;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }
}