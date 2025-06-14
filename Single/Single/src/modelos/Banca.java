package modelos;

import java.util.HashMap;
import java.util.Map;

public class Banca implements Avaliavel {
    private Projeto projetoAvaliado;
    private Map<Jurado, Integer> notasDosJurados;

    public Banca(Projeto projetoAvaliado) {
        this.projetoAvaliado = projetoAvaliado;
        this.notasDosJurados = new HashMap<>();
    }

    public void adicionarNota(Jurado jurado, int nota) {
        notasDosJurados.put(jurado, nota);
    }

    @Override
    public void calcularNotaFinal() {
        int soma = 0;
        for (int nota : notasDosJurados.values()) {
            soma += nota;
        }
        int media = (notasDosJurados.size() > 0) ? (soma / notasDosJurados.size()) : 0;
        projetoAvaliado.setNotaFinal(media);
    }

    public Projeto getProjetoAvaliado() {
        return projetoAvaliado;
    }

    public Map<Jurado, Integer> getNotasDosJurados() {
        return notasDosJurados;
    }
}
