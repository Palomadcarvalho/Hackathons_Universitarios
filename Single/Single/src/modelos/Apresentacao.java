package modelos;

import java.time.LocalDateTime;

public class Apresentacao {
    private Projeto projeto;
    private Avaliavel banca;
    private Sala sala;
    private LocalDateTime dataHora;

    public Apresentacao(Projeto projeto, Avaliavel banca, Sala sala, LocalDateTime dataHora) {
        this.projeto = projeto;
        this.banca = banca;
        this.sala = sala;
        this.dataHora = dataHora;
    }

    public void avaliar() {
        banca.calcularNotaFinal();
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public Sala getSala() {
        return sala;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
