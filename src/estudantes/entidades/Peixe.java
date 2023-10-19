package estudantes.entidades;
/**
 * Classe que define os animais peixes. É uma subclasse de Animal.
 * @see Animal
 * @author Patricia Rodrigues patriciarodrigues.aluno@unipampa.edu.br
 * @version 1.1
 */
public class Peixe extends Animal {
    /**
     *Limite da paciência que um peixe fica esperando na fila antes de ir embora.
     */
    public final int PACIENCIA_MAXIMA = 60;
    /**
     *Atributo cor das escamas
     */
    private String corDasEscamas;
    /**
     * Construtor de Peixe.
     * Todos os atributos são passados por parâmetro (utilizando o super()), exceto cor das escamas e paciência
     * máxima que, em peixe é sempre 60.
     * @param id
     * @param nome
     * @param especie
     * @param andarDesejado
     * @param peso
     * @param temperaturaIdeal
     */
    public Peixe(int id, String nome, String especie, int andarDesejado, int peso, int temperaturaIdeal, String corDasEscamas) {
        super(id, nome, especie, andarDesejado, peso, temperaturaIdeal);
        this.corDasEscamas = corDasEscamas;
    }
    /**
     * Retorna que o peixe está nadando.
     * @return a String "Nadando".
     */
    public String nadar(){
        return "nadando";
    }
    /**
     * retorna o tempo de paciencia maxima do peixe para esperar na fila, antes de desistir
     * @return PACIENCIA_MAXIMA
     */
    public int getPACIENCIA_MAXIMA() {
        return PACIENCIA_MAXIMA;
    }
    /**
     * retorna a cor das escamas do peixe
     * @return corDasEscamas
     */
    public String getCorDasEscamas() {
        return corDasEscamas;
    }
    @Override
    public String toString() {
        return super.toString() + "[Paciência Máxima:" + PACIENCIA_MAXIMA + "]" + "[" + "Cor Das Escamas=" + corDasEscamas + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + PACIENCIA_MAXIMA;
        result = prime * result + ((corDasEscamas == null) ? 0 : corDasEscamas.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Peixe other = (Peixe) obj;
        if (PACIENCIA_MAXIMA != other.PACIENCIA_MAXIMA)
            return false;
        if (corDasEscamas == null) {
            if (other.corDasEscamas != null)
                return false;
        } else if (!corDasEscamas.equals(other.corDasEscamas))
            return false;
        return true;
    }

}
