package estudantes.entidades;

public class AveVoadora extends Ave{
    
    /**
     * Limite da paciência de uma Ave esperando na fila antes de ir embora.
     */
    public final int PACIENCIA_MAXIMA = 20; //em segundos (ciclos de espera)


    /**
     * Construtor da Ave.
     * Todos os atributos são passados por parâmetro (utilizando o super()), exceto a paciência 
     * máxima que, em aves voadoras é sempre 20.
     * @param id da Ave
     * @param nome da Ave
     * @param especie da Ave
     * @param andarDesejado que a ave deseja ir
     * @param peso da Ave
     * @param temperaturaIdeal que o elevador deve ter
     * @param corDasPenas da Ave
     */
    public AveVoadora(int id, String nome, String especie, int andarDesejado, int peso, int temperaturaIdeal,
            String corDasPenas) {
        super(id, nome, especie, andarDesejado, peso, temperaturaIdeal, corDasPenas);
    }


    /**
     * Retorna que a ave está voando.
     * @return a String "Voando".
     */
    public String voar(){
        return "voando";
    }

    @Override
    public String toString() {
        return super.toString() + "[PACIENCIA_MAXIMA=" + PACIENCIA_MAXIMA + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        AveVoadora other = (AveVoadora) obj;
        if (PACIENCIA_MAXIMA != other.PACIENCIA_MAXIMA)
            return false;
        return true;
    }
}
