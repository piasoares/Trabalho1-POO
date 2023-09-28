package estudantes.entidades;

public class MamiferoAquatico  extends Mamifero{
    
    /**
     * Limite da paciência de um animal esperando na fila antes de ir embora.
     */
    public int PACIENCIA_MAXIMA = 40; //em segundos (ciclos de espera)

    /**
     * Construtor do Anfibio.
     * Todos os atributos são passados por parâmetro (utilizando o super()), exceto a paciência 
     * máxima que, em mamífero aquático é sempre 40.
     * @param id do Animal
     * @param nome do Animal
     * @param especie do Animal
     * @param andarDesejado que o animal deseja ir
     * @param peso do Animal
     * @param temperaturaIdeal que o elevador deve ter
     * @param peludo se o mamifero é peludo ou não.
     */
    public MamiferoAquatico(int id, String nome, String especie, int andarDesejado, int peso, int temperaturaIdeal,
            boolean peludo) {
        super(id, nome, especie, andarDesejado, peso, temperaturaIdeal, peludo);
        PACIENCIA_MAXIMA = 40;
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
        MamiferoAquatico other = (MamiferoAquatico) obj;
        if (PACIENCIA_MAXIMA != other.PACIENCIA_MAXIMA)
            return false;
        return true;
    }

    
}
