package colecao;

import modelos.Equipe;

import java.util.ArrayList;
import java.util.List;

public class Equipes {
    private static Equipes instancia;
    private List<Equipe> listaEquipes;

    private Equipes() {
        listaEquipes = new ArrayList<>();
    }

    public static Equipes getInstancia() {
        if (instancia == null) {
            instancia = new Equipes();
        }
        return instancia;
    }

    public void adicionarEquipe(Equipe equipe) {
        listaEquipes.add(equipe);
    }

    public List<Equipe> getListaEquipes() {
        return listaEquipes;
    }
}