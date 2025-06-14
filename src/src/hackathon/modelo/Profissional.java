package hackathon.modelo;

public class Profissional extends Pessoa {
    private String cargo;

    public Profissional(String nome, Instituicao instituicao, String cargo) {
        super(nome, instituicao);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }
}