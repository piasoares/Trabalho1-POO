package estudantes.entidades;

/**
 * Classe que define as aves. É uma subclasse de Animal.
 * @see Animal
 * 
 * @author Pietra Soares pietrasoares.aluno@unipampa.edu.br
 * @version 1.1
 */
public class Ave extends Animal {
    
    /**
     * Limite da paciência de uma Ave esperando na fila antes de ir embora.
     */
    public final int PACIENCIA_MAXIMA = 30; //em segundos (ciclos de espera)
    private String corDasPenas;


    /**
     * Construtor da Ave.
     * Todos os atributos são passados por parâmetro (utilizando o super()), exceto a paciência 
     * máxima que, em aves é sempre 30.
     * @param id da Ave
     * @param nome da Ave
     * @param especie da Ave
     * @param andarDesejado que a ave deseja ir
     * @param peso da Ave
     * @param temperaturaIdeal que o elevador deve ter
     * @param corDasPenas da Ave
     */
    public Ave(int id, String nome, String especie, int andarDesejado, int peso, int temperaturaIdeal, String corDasPenas) {
        super(id, nome, especie, andarDesejado, peso, temperaturaIdeal);
        this.corDasPenas = corDasPenas;
    }


    /**
     * Retorna a paciência máxima da ave.
     * @return a paciência máxima da ave que deve ser 30 seg.
     */
    public int getPACIENCIA_MAXIMA() {
        return PACIENCIA_MAXIMA;
    }


    /**
     * Retorna a cor das penas da ave.
     * @return a cor das penas da ave.
     */
    public String getCorDasPenas() {
        return corDasPenas;
    }

    /**
     * Retorna que a ave está andando.
     * @return a String "Andando".
     */
    public String andar(){
        return "Andando";
    }


    @Override
    public String toString() {
        return super.toString() + "[PACIENCIA_MAXIMA=" + PACIENCIA_MAXIMA + "]" + "\n[Cor das penas:" + corDasPenas + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + PACIENCIA_MAXIMA;
        result = prime * result + ((corDasPenas == null) ? 0 : corDasPenas.hashCode());
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
        Ave other = (Ave) obj;
        if (PACIENCIA_MAXIMA != other.PACIENCIA_MAXIMA)
            return false;
        if (corDasPenas == null) {
            if (other.corDasPenas != null)
                return false;
        } else if (!corDasPenas.equals(other.corDasPenas))
            return false;
        return true;
    }
}
