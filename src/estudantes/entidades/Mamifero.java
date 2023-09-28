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
     * Todos os atributos são passados por parâmetro (utilizando o super()), exceto o "peludo".
     * @param id do Animal
     * @param nome do Animal
     * @param especie do Animal
     * @param andarDesejado que o animal deseja ir
     * @param peso do Animal
     * @param temperaturaIdeal que o elevador deve ter
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

    //deve ser criado um set?
}
