package modelos;

public class Projeto {
    private Profissional orientador;
    private Equipe equipe;
    private int notaFinal;

    public Projeto(Profissional orientador, Equipe equipe) {
        this.orientador = orientador;
        this.equipe = equipe;
        this.notaFinal = 0; // Inicialmente, o projeto ainda não tem nota
    }

    public Profissional getOrientador() {
        return orientador;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
    }

    public void exibirInformacoes() {
        System.out.println("Projeto da equipe:");
        equipe.listarMembros();
        System.out.println("Orientador: " + orientador.getNome() + " (" + orientador.getInstituicao().getNome() + ")");
        System.out.println("Nota final: " + notaFinal);
    }
}