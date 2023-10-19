package estudantes.entidades;

/**
 * Classe que define os animais mamíferos aquáticos. É uma subclasse de Mamifero.
 * @see Mamifero
 * 
 * @author Pietra Soares pietrasoares.aluno@unipampa.edu.br
 * @version 1.1
 */
public class MamiferoAquatico  extends Mamifero{
    
    /**
     * Limite da paciência de um mamífero esperando na fila antes de ir embora.
     */
    public final int PACIENCIA_MAXIMA = 40; //em segundos (ciclos de espera)

    /**
     * Construtor do Anfibio.
     * Todos os atributos são passados por parâmetro (utilizando o super()), exceto a paciência 
     * máxima que, em mamífero aquático é sempre 40.
     * @param id do mamífero aquático
     * @param nome do mamífero aquático
     * @param especie do mamífero aquático
     * @param andarDesejado que o mamífero aquático deseja ir
     * @param peso do mamífero aquático
     * @param temperaturaIdeal que o elevador deve ter
     * @param peludo se o mamifero é peludo ou não.
     */
    public MamiferoAquatico(int id, String nome, String especie, int andarDesejado, int peso, int temperaturaIdeal,
            boolean peludo) {
        super(id, nome, especie, andarDesejado, peso, temperaturaIdeal, peludo);
    }

    /**
     * Retorna que o anfibio está nadando.
     * @return a String "Nadando".
     */
    public String nadar(){
        return "nadando";
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
        MamiferoAquatico other = (MamiferoAquatico) obj;
        if (PACIENCIA_MAXIMA != other.PACIENCIA_MAXIMA)
            return false;
        return true;
    }

    
}
