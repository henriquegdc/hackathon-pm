package hackathon;

import hackathon.modelo.*;
import hackathon.repositorio.RepositorioEquipes;
import hackathon.repositorio.RepositorioProjetos;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        // Padrão Singleton para obter as coleções
        RepositorioEquipes repositorioEquipes = RepositorioEquipes.getInstance();
        RepositorioProjetos repositorioProjetos = RepositorioProjetos.getInstance();

        // Setup de dados iniciais
        Universidade puc = new Universidade("PUC Minas");
        Empresa google = new Empresa("Google");
        Empresa microsoft = new Empresa("Microsoft");
        Profissional orientador = new Profissional("Daniel Kansaon", puc, "Professor");

        // Cria 2 equipes com 5 alunos cada
        Equipe equipe1 = new Equipe("The-Office-PUC");
        for (int i = 1; i <= 5; i++) {
            equipe1.adicionarMembro(new Estudante("Aluno " + i, puc, "mat" + i));
        }
        repositorioEquipes.adicionar(equipe1);

        Equipe equipe2 = new Equipe("CodeMiners");
        for (int i = 6; i <= 10; i++) {
            equipe2.adicionarMembro(new Estudante("Aluno " + i, puc, "mat" + i));
        }
        repositorioEquipes.adicionar(equipe2);

        // Adiciona um projeto diferente para cada equipe
        Projeto projeto1 = new Projeto("Sistema de Gestão de Hackathons", equipe1, orientador);
        Projeto projeto2 = new Projeto("App de Caronas Universitárias", equipe2, orientador);
        repositorioProjetos.adicionar(projeto1);
        repositorioProjetos.adicionar(projeto2);

        // Criar uma banca avaliadora para cada projeto (cada banca deve conter 4 jurados)
        Banca banca1 = new Banca(projeto1);
        banca1.adicionarJuradoComNota(new Jurado("Jurado A", google, "Eng. de Software"), 8);
        banca1.adicionarJuradoComNota(new Jurado("Jurado B", microsoft, "Gerente de Produto"), 9);
        banca1.adicionarJuradoComNota(new Jurado("Jurado C", puc, "Coordenador"), 7);
        banca1.adicionarJuradoComNota(new Jurado("Jurado D", google, "UX Designer"), 8);

        Banca banca2 = new Banca(projeto2);
        banca2.adicionarJuradoComNota(new Jurado("Jurado E", microsoft, "Dev Advocate"), 6);
        banca2.adicionarJuradoComNota(new Jurado("Jurado F", google, "Analista de Dados"), 5);
        banca2.adicionarJuradoComNota(new Jurado("Jurado G", puc, "Pesquisador"), 7);
        banca2.adicionarJuradoComNota(new Jurado("Jurado H", microsoft, "Eng. de Software"), 6);

        // Apresentação e avaliação
        Apresentacao apresentacao1 = new Apresentacao(projeto1, banca1, new Sala("Auditório 1"), LocalDateTime.now());
        Apresentacao apresentacao2 = new Apresentacao(projeto2, banca2, new Sala("Sala 3B"), LocalDateTime.now().plusHours(1));

        // Calcula a nota final de cada projeto a partir da apresentação
        apresentacao1.avaliar();
        apresentacao2.avaliar();

        System.out.println("\n--- RESULTADO FINAL ---");

        // Lista os projetos com nota final >= 7 (usar stream)
        System.out.println("Projetos Aprovados (Nota Final >= 7.0):");
        repositorioProjetos.listar().stream()
                .filter(p -> p.getNotaFinal() >= 7)
                .forEach(System.out::println);
    }
}