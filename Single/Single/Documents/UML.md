@startuml

' ===========================
' Pacote modelos
' ===========================
package "modelos" {
    abstract class Instituicao {
        - nome : String
        + getNome() : String
    }

    class Universidade extends Instituicao
    class Empresa extends Instituicao

    abstract class Pessoa {
        - nome : String
        - instituicao : Instituicao
        + getNome() : String
        + getInstituicao() : Instituicao
    }

    class Estudante extends Pessoa
    class Profissional extends Pessoa
    class Jurado extends Profissional

    class Equipe {
        - membros : List<Estudante>
        + adicionarMembro(estudante: Estudante) : void
        + getMembros() : List<Estudante>
        + listarMembros() : void
    }

    class Projeto {
        - orientador : Profissional
        - equipe : Equipe
        - notaFinal : int
        + getOrientador() : Profissional
        + getEquipe() : Equipe
        + getNotaFinal() : int
        + setNotaFinal(notaFinal: int) : void
        + exibirInformacoes() : void
    }

    class Sala {
        - nome : String
        + getNome() : String
    }

    interface Avaliavel {
        + calcularNotaFinal() : void
    }

    class Banca implements Avaliavel {
        - projetoAvaliado : Projeto
        - notasDosJurados : Map<Jurado, Integer>
        + adicionarNota(jurado: Jurado, nota: int) : void
        + calcularNotaFinal() : void
        + getProjetoAvaliado() : Projeto
        + getNotasDosJurados() : Map<Jurado, Integer>
    }

    class Apresentacao {
        - projeto : Projeto
        - banca : Avaliavel
        - sala : Sala
        - dataHora : LocalDateTime
        + avaliar() : void
        + getProjeto() : Projeto
        + getSala() : Sala
        + getDataHora() : LocalDateTime
    }
}

' ===========================
' Pacote colecao
' ===========================
package "colecao" {
    class Equipes {
        - instancia : Equipes
        - listaEquipes : List<Equipe>
        - Equipes()
        + getInstancia() : Equipes
        + adicionarEquipe(equipe: Equipe) : void
        + getListaEquipes() : List<Equipe>
    }

    class Apresentacoes {
        - instancia : Apresentacoes
        - listaApresentacoes : List<Apresentacao>
        - Apresentacoes()
        + getInstancia() : Apresentacoes
        + adicionarApresentacao(apresentacao: Apresentacao) : void
        + getListaApresentacoes() : List<Apresentacao>
    }
}

' ===========================
' RELACIONAMENTOS ENTRE PACOTES
' ===========================

modelos.Pessoa o-- modelos.Instituicao

modelos.Projeto o-- modelos.Equipe
modelos.Projeto o-- modelos.Profissional

modelos.Banca o-- modelos.Projeto
modelos.Banca *-- modelos.Jurado

modelos.Apresentacao o-- modelos.Projeto
modelos.Apresentacao o-- modelos.Sala
modelos.Apresentacao o-- modelos.Avaliavel

colecao.Equipes *-- modelos.Equipe
colecao.Apresentacoes *-- modelos.Apresentacao

@enduml
