package hackathon.modelo;

import java.time.LocalDateTime;

public class Apresentacao {
    private Projeto projeto;
    private Avaliavel banca;
    private Sala local;
    private LocalDateTime dataHora;

    public Apresentacao(Projeto projeto, Avaliavel banca, Sala local, LocalDateTime dataHora) {
        this.projeto = projeto;
        this.banca = banca;
        this.local = local;
        this.dataHora = dataHora;
    }

    public void avaliar() {
        double notaFinal = this.banca.calcularNotaFinal();
        this.projeto.setNotaFinal(notaFinal);
        System.out.println("Avaliação do projeto '" + projeto.getNome() + "' realizada. Nota final: " + String.format("%.2f", notaFinal));
    }
}