package estudantes.entidades;

/**
 * Classe que define os animais mamíferos terrestres. É uma subclasse de Mamifero.
 * @see Mamifero
 * @author Patricia Rodrigues patriciarodrigues.aluno@unipampa.edu.br
 * @version 1.0
 */
public class MamiferoTerrestre extends Mamifero{
    /**
     *Limite da paciência de um mamífero terrestre fica esperando na fila antes de ir embora.
     */
    public final int PACIENCIA_MAXIMA = 35;

    /**
     * Construtor de Mamifero Terrestre.
     * Todos os atributos são passados por parâmetro (utilizando o super()), exceto a paciência
     * máxima que, em mamiferos terrestres é sempre 35.
     * @param id
     * @param nome
     * @param especie
     * @param andarDesejado
     * @param peso
     * @param temperaturaIdeal
     * @param peludo
     */
    public MamiferoTerrestre(int id, String nome, String especie, int andarDesejado, int peso, int temperaturaIdeal,
            boolean peludo) {
        super(id, nome, especie, andarDesejado, peso, temperaturaIdeal, peludo);
    }
    /**
     * Retorna que o mamifero terrestre está andando
     * @return String "Andando"
     */
    public String andar(){
        return "Andando";
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
        MamiferoTerrestre other = (MamiferoTerrestre) obj;
        if (PACIENCIA_MAXIMA != other.PACIENCIA_MAXIMA)
            return false;
        return true;
    }
}
