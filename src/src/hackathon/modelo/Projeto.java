package hackathon.modelo;

public class Projeto {
    private String nome;
    private Equipe equipe;
    private Profissional orientador;
    private double notaFinal;

    public Projeto(String nome, Equipe equipe, Profissional orientador) {
        this.nome = nome;
        this.equipe = equipe;
        this.orientador = orientador;
        this.notaFinal = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return "Projeto '" + nome + "' da Equipe '" + equipe.getNome() + "' - Nota Final: " + String.format("%.2f", notaFinal);
    }
}