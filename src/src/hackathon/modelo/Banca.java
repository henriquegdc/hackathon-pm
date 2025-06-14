package hackathon.modelo;

import java.util.HashMap;
import java.util.Map;

public class Banca implements Avaliavel {
    private Projeto projetoAvaliado;
    private Map<Jurado, Integer> notasDosJurados;

    public Banca(Projeto projetoAvaliado) {
        this.projetoAvaliado = projetoAvaliado;
        this.notasDosJurados = new HashMap<>();
    }

    public void adicionarJuradoComNota(Jurado jurado, Integer nota) {
        if (nota >= 0 && nota <= 10) {
            this.notasDosJurados.put(jurado, nota);
        } else {
            System.out.println("Nota inválida para o jurado " + jurado.getNome());
        }
    }

    @Override
    public double calcularNotaFinal() {
        if (notasDosJurados.isEmpty()) {
            return 0.0;
        }
        double soma = 0;
        for (Integer nota : notasDosJurados.values()) {
            soma += nota;
        }
        // A nota final é a média das notas dos jurados
        return soma / notasDosJurados.size();
    }
}