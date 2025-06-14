package hackathon.repositorio;

import hackathon.modelo.Projeto;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe auxiliar para controlar a coleção de objetos do sistema.
 * padrão de projeto Singleton.
 */
public class RepositorioProjetos {
    private static RepositorioProjetos instance;
    private List<Projeto> projetos;

    private RepositorioProjetos() {
        this.projetos = new ArrayList<>();
    }

    public static synchronized RepositorioProjetos getInstance() {
        if (instance == null) {
            instance = new RepositorioProjetos();
        }
        return instance;
    }

    public void adicionar(Projeto projeto) {
        this.projetos.add(projeto);
    }

    public List<Projeto> listar() {
        return new ArrayList<>(this.projetos);
    }
}