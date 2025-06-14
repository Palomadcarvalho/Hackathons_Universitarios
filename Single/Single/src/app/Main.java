package app;

import modelos.*;
import colecao.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Criando instituições
        Universidade pucLourdes = new Universidade("PUC Minas - Lourdes");
        Universidade pucCoracao = new Universidade("PUC Minas - Coração Eucarístico");
        Empresa google = new Empresa("Google");

        // Criando estudantes para duas equipes
        Estudante e1 = new Estudante("Paloma", pucLourdes);
        Estudante e2 = new Estudante("Karen", pucLourdes);
        Estudante e3 = new Estudante("Arthur", pucLourdes);
        Estudante e4 = new Estudante("Dolabela", pucLourdes);
        Estudante e5 = new Estudante("Ana", pucLourdes);

        Estudante e6 = new Estudante("Barbara", pucCoracao);
        Estudante e7 = new Estudante("Carlos", pucCoracao);
        Estudante e8 = new Estudante("Daniel", pucCoracao);
        Estudante e9 = new Estudante("Eduardo", pucCoracao);
        Estudante e10 = new Estudante("Fernanda", pucCoracao);

        // Criando Equipes
        Equipe equipe1 = new Equipe();
        Equipe equipe2 = new Equipe();

        List<Estudante> equipe1Membros = Arrays.asList(e1, e2, e3, e4, e5);
        List<Estudante> equipe2Membros = Arrays.asList(e6, e7, e8, e9, e10);

        equipe1Membros.forEach(equipe1::adicionarMembro);
        equipe2Membros.forEach(equipe2::adicionarMembro);

        // Salvando equipes na coleção Singleton
        Equipes.getInstancia().adicionarEquipe(equipe1);
        Equipes.getInstancia().adicionarEquipe(equipe2);

        // Criando orientadores
        Profissional orientador1 = new Profissional("Prof. Michelle", pucLourdes);
        Profissional orientador2 = new Profissional("Prof. Willian", pucCoracao);

        // Criando Projetos
        Projeto projeto1 = new Projeto(orientador1, equipe1);
        Projeto projeto2 = new Projeto(orientador2, equipe2);

        // Criando jurados
        Jurado j1 = new Jurado("Henrique", google);
        Jurado j2 = new Jurado("Joana", google);
        Jurado j3 = new Jurado("Soraia", google);
        Jurado j4 = new Jurado("Eveline", google);

        Jurado j5 = new Jurado("Diego", google);
        Jurado j6 = new Jurado("Lukas", google);
        Jurado j7 = new Jurado("João", google);
        Jurado j8 = new Jurado("Cleiton", google);

        // Criando Bancas
        Banca banca1 = new Banca(projeto1);
        banca1.adicionarNota(j1, 8);
        banca1.adicionarNota(j2, 7);
        banca1.adicionarNota(j3, 9);
        banca1.adicionarNota(j4, 7);

        Banca banca2 = new Banca(projeto2);
        banca2.adicionarNota(j5, 6);
        banca2.adicionarNota(j6, 7);
        banca2.adicionarNota(j7, 5);
        banca2.adicionarNota(j8, 6);

        // Criando Salas
        Sala sala1 = new Sala("Auditório 1");
        Sala sala2 = new Sala("Auditório 2");

        // Criando Apresentações
        Apresentacao apresentacao1 = new Apresentacao(projeto1, banca1, sala1, LocalDateTime.now());
        Apresentacao apresentacao2 = new Apresentacao(projeto2, banca2, sala2, LocalDateTime.now());

        // Salvando apresentações na coleção Singleton
        Apresentacoes.getInstancia().adicionarApresentacao(apresentacao1);
        Apresentacoes.getInstancia().adicionarApresentacao(apresentacao2);

        // Avaliando os projetos
        apresentacao1.avaliar();
        apresentacao2.avaliar();

        // Exibindo os projetos com nota final >= 7 (usando stream)
        System.out.println("\nProjetos com nota final >= 7:");
        List<Projeto> projetosAprovados = Arrays.asList(projeto1, projeto2).stream()
                .filter(p -> p.getNotaFinal() >= 7)
                .collect(Collectors.toList());

        for (Projeto p : projetosAprovados) {
            p.exibirInformacoes();
            System.out.println("-----------------------");
        }
    }
}