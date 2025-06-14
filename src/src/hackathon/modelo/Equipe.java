package hackathon.modelo;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nome;
    private List<Estudante> membros;

    public Equipe(String nome) {
        this.nome = nome;
        this.membros = new ArrayList<>();
    }

    public void adicionarMembro(Estudante estudante) {
        // A lógica do main cria equipes com 5 alunos
        if (this.membros.size() < 5) {
            this.membros.add(estudante);
        } else {
            System.out.println("A equipe " + this.nome + " já está cheia.");
        }
    }

    public String getNome() {
        return nome;
    }

    public List<Estudante> getMembros() {
        return membros;
    }
}