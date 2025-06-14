package modelos;

public abstract class Instituicao {
    private String nome;

    public Instituicao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}