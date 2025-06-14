package colecao;

import modelos.Apresentacao;

import java.util.ArrayList;
import java.util.List;

public class Apresentacoes {
    private static Apresentacoes instancia;
    private List<Apresentacao> listaApresentacoes;

    private Apresentacoes() {
        listaApresentacoes = new ArrayList<>();
    }

    public static Apresentacoes getInstancia() {
        if (instancia == null) {
            instancia = new Apresentacoes();
        }
        return instancia;
    }

    public void adicionarApresentacao(Apresentacao apresentacao) {
        listaApresentacoes.add(apresentacao);
    }

    public List<Apresentacao> getListaApresentacoes() {
        return listaApresentacoes;
    }
}
