package estudantes.entidades;
/**
 * Classe que define os animais mamíferos voadores. É uma subclasse de Mamifero.
 * @see Mamifero
 * @author Patricia Rodrigues patriciarodrigues.aluno@unipampa.edu.br
 * @version 1.0
 */
public class MamiferoVoador extends Mamifero{
    /**
     *Limite da paciência de um mamífero voador fica esperando na fila antes de ir embora.
     */
    public int PACIENCIA_MAXIMA = 15; //em segundos (ciclos de espera)

    /**
     * Construtor de Mamifero Voador.
     * Todos os atributos são passados por parâmetro (utilizando o super()), exceto a paciência
     * máxima que, em mamifero voador é sempre 15.
     * @param id
     * @param nome
     * @param especie
     * @param andarDesejado
     * @param peso
     * @param temperaturaIdeal
     * @param peludo
     */
    public MamiferoVoador(int id, String nome, String especie, int andarDesejado, int peso, int temperaturaIdeal,
            boolean peludo) {
        super(id, nome, especie, andarDesejado, peso, temperaturaIdeal, peludo);
        PACIENCIA_MAXIMA = 15;
    }
    /**
     * Retorna que o mamifero esta voando
     * @return String "Voando"
     */
    public String voar(){
        return "voando";
    }
    @Override
    public String toString() {
        return super.toString() + "[Paciência Máxima:" + PACIENCIA_MAXIMA + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + PACIENCIA_MAXIMA;
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
        MamiferoVoador other = (MamiferoVoador) obj;
        if (PACIENCIA_MAXIMA != other.PACIENCIA_MAXIMA)
            return false;
        return true;
    }
}