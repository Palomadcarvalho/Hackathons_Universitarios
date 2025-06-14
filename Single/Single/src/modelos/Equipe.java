package modelos;

import java.util.ArrayList;
import java.util.List;

public class Equipe {

    private List<Estudante> membros;

    public Equipe() {
        this.membros = new ArrayList<>();
    }

    public void adicionarMembro(Estudante estudante) {
        membros.add(estudante);
    }

    public List<Estudante> getMembros() {
        return membros;
    }

    public void listarMembros() {
        System.out.println("Membros da equipe:");
        for (Estudante e : membros) {
            System.out.println("- " + e.getNome() + " (Instituição: " + e.getInstituicao().getNome() + ")");
        }
    }
}