package estudantes.entidades;

public class ReptilAquatico extends Reptil {
    /**
     *Limite da paciência que um reptil aquatico fica esperando na fila antes de ir embora.
     */
    public final int PACIENCIA_MAXIMA = 15;

    /**
     * Construtor de ReptilAquatico.
     * Todos os atributos são passados por parâmetro (utilizando o super()), exceto a paciência
     * máxima que, em reptil aquatico é sempre 15.
     * @param id
     * @param nome
     * @param especie
     * @param andarDesejado
     * @param peso
     * @param temperaturaIdeal
     */
    public ReptilAquatico(int id, String nome, String especie, int andarDesejado, int peso, int temperaturaIdeal) {
        super(id, nome, especie, andarDesejado, peso, temperaturaIdeal);
    }

    /**
     * Retorna que o reptil aquatico está nadando
     * @return String "Nadando"
     */
    public String nadar(){
        return "nadando";
    }

    @Override
    public String toString() {
        return super.toString() + "[Paciência Máxima:" + PACIENCIA_MAXIMA + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ReptilAquatico other = (ReptilAquatico) obj;
        if (PACIENCIA_MAXIMA != other.PACIENCIA_MAXIMA)
            return false;
        return true;
    }

}
