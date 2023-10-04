package estudantes.entidades;
/**
 * Classe que define os animais Répteis. É uma subclasse de Animal.
 * @see Animal
 * @author Patricia Rodrigues patriciarodrigues.aluno@unipampa.edu.br
 * @version 1.0
 */
public class Reptil extends Animal {
    /**
     *  Construtor de Reptil.
     * Todos os atributos são passados por parâmetro (utilizando o super()), exceto a paciência
     * máxima que, em reptil é sempre 10.
     * @param id
     * @param nome
     * @param especie
     * @param andarDesejado
     * @param peso
     * @param temperaturaIdeal
     */
    public Reptil(int id, String nome, String especie, int andarDesejado, int peso, int temperaturaIdeal) {
        super(id, nome, especie, andarDesejado, peso, temperaturaIdeal);
    }

    /**
     *Limite da paciência que um reptil fica esperando na fila antes de ir embora.
     */
    public int PACIENCIA_MAXIMA = 10;

    /**
     * Retorna que o reptil está andando
     * @return String "Andando"
     */
    public String andar(){
        return "Andando";
    }

    @Override
    public String toString() {
        return "Reptil [PACIENCIA_MAXIMA=" + PACIENCIA_MAXIMA + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reptil other = (Reptil) obj;
        if (PACIENCIA_MAXIMA != other.PACIENCIA_MAXIMA)
            return false;
        return true;
    }
}
