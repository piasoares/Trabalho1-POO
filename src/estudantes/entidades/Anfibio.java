package estudantes.entidades;

/**
 * Classe que define os animais anfíbios. É uma subclasse de Animal.
 * @see Animal
 * 
 * @author Pietra Soares pietrasoares.aluno@unipampa.edu.br
 * @version 1.1
 */
public class Anfibio extends Animal {
    
    /**
     * Limite da paciência de um anfíbio esperando na fila antes de ir embora.
     */
    public int PACIENCIA_MAXIMA = 45; //em segundos (ciclos de espera)

    /**
     * Construtor do Anfibio.
     * Todos os atributos são passados por parâmetro (utilizando o super()), exceto a paciência 
     * máxima que, em anfibio é sempre 45.
     * @param id do Anfíbio
     * @param nome do Anfíbio
     * @param especie do Anfíbio
     * @param andarDesejado que o Anfíbio deseja ir
     * @param peso do Anfíbio
     * @param temperaturaIdeal que o elevador deve ter
     */
    public Anfibio(int id, String nome, String especie, int andarDesejado, int peso, int temperaturaIdeal) {
        super(id, nome, especie, andarDesejado, peso, temperaturaIdeal);
        PACIENCIA_MAXIMA = 45;
    }

    /**
     * Retorna a paciência máxima do anfibio.
     * @return a paciência máxima do anfibio que deve ser 45 seg.
     */
    public int getPACIENCIA_MAXIMA() {
        return PACIENCIA_MAXIMA;
    }

    /**
     * Retorna que o anfibio está andando.
     * @return a String "Andando".
     */
    public String andar(){
        return "Andando";
    }

    /**
     * Retorna que o anfibio está nadando.
     * @return a String "Nadando".
     */
    public String nadar(){
        return "Nadando";
    }

    @Override
    public String toString() {
        return super.toString() + "\n[PACIENCIA_MAXIMA:" + PACIENCIA_MAXIMA + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Anfibio other = (Anfibio) obj;
        if (PACIENCIA_MAXIMA != other.PACIENCIA_MAXIMA)
            return false;
        return true;
    }
}
