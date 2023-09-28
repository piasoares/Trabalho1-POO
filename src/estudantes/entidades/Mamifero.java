package estudantes.entidades;

/**
 * Classe que define os animais mamíferos. É uma subclasse de Animal.
 * @see Animal
 * 
 * @author Pietra Soares pietrasoares.aluno@unipampa.edu.br
 * @version 1.1
 */
public class Mamifero extends Animal {

    private boolean peludo;

    /**
     * Construtor do Mamífero.
     * Todos os atributos são passados por parâmetro (utilizando o super()).
     * @param id do Mamífero
     * @param nome do Mamífero
     * @param especie do Mamífero
     * @param andarDesejado que o Mamífero deseja ir
     * @param peso do Mamífero
     * @param temperaturaIdeal que o elevador deve ter
     * @param peludo se o mamifero é peludo ou não.
     */
    public Mamifero(int id, String nome, String especie, int andarDesejado, int peso, int temperaturaIdeal,
            boolean peludo) {
        super(id, nome, especie, andarDesejado, peso, temperaturaIdeal);
        this.peludo = peludo;
    }

    /**
     * Retorna se o Mamífero é peludo ou não.
     * @return se o mamífero é peludo ou não
     */
    public boolean isPeludo() {
        return peludo;
    }

    @Override
    public String toString() {
        return super.toString() + "\n[Peludo:" + peludo + "]";
    }
}
