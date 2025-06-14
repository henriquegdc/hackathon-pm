package hackathon.modelo;

public class Estudante extends Pessoa {
    private String matricula;

    public Estudante(String nome, Instituicao instituicao, String matricula) {
        super(nome, instituicao);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
}