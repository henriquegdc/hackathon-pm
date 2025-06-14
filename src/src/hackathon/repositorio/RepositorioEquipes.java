package hackathon.repositorio;

import hackathon.modelo.Equipe;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de coleção para manter objetos do tipo Equipe.
 * padrão de projeto Singleton.
 */
public class RepositorioEquipes {
    private static RepositorioEquipes instance;
    private List<Equipe> equipes;

    private RepositorioEquipes() {
        this.equipes = new ArrayList<>();
    }

    /**
     * Garante que apenas uma instância da coleção seja utilizada no sistema.
     * @return A instância única de RepositorioEquipes.
     */
    public static synchronized RepositorioEquipes getInstance() {
        if (instance == null) {
            instance = new RepositorioEquipes();
        }
        return instance;
    }


     // Metodo para incluir elementos na coleção.

    public void adicionar(Equipe equipe) {
        this.equipes.add(equipe);
    }


     // Metodo para pesquisar/listar elementos.

    public List<Equipe> listar() {
        return new ArrayList<>(this.equipes);
    }
}