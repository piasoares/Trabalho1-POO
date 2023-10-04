package estudantes.entidades;

/**
 * Classe que define um animal da arca.
 * <br>
 * <br>
 * Essa classe pode ser estendida. Adicionalmente, ela deve:
 * <br>
 * <br>
 * 1) ter um construtor completo,<br>
 * 2) implementar métodos de acesso (getters), sendo que métodos de modificação
 * (setters) NÃO devem ser implementados,<br>
 * 3) sobre-escrever os métodos toString, equals e hashCode,<br>
 * 4) deve implementar o método <i>aumentaEspera</i> conforme indicado na
 * documentação.
 * <br>
 * <br>
 * <strong>Não devem ser criados métodos adicionais nessa classe.</strong>
 * 
 * @author Jean Cheiran
 * @version 1.0
 */
public class Animal {

    /**
     * Limite da paciência de um animal esperando na fila antes de ir embora.
     */
    public final int PACIENCIA_MAXIMA = 25; // em segundos (ciclos de espera)

    private int id;
    private String nome;
    private String especie;
    private int peso; // em quilos
    private int andarDesejado; // 0 é o térreo
    private int tempoDeEspera;
    private int temperaturaIdeal; // em graus Celsius

    /**
     * Construtor do animal.
     * Todos os atributos são passados por parâmetro, exceto o tempo de espera
     * que sempre começa em 0.
     * 
     * @param id               do Animal
     * @param nome             do Animal
     * @param especie          do Animal
     * @param andarDesejado    que o animal deseja ir
     * @param peso             do Animal
     * @param temperaturaIdeal que o elevador deve ter
     */
    public Animal(int id, String nome, String especie, int andarDesejado,
            int peso, int temperaturaIdeal) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.andarDesejado = andarDesejado;
        this.peso = peso;
        this.temperaturaIdeal = temperaturaIdeal;
        tempoDeEspera = 0;
    }

    /**
     * Retorna o número de identificaçao do animal.
     * O valor é gerado aleatoriamente e está entre 0 e 999999.
     * 
     * @return número da identificação do animal
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o peso do animal.
     * O peso é gerado aleatoriamente e está entre 1 e 1.000 quilos.
     * 
     * @return peso do animal em quilos
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Retorna a paciência máxima do animal.
     * Gerado a partir do tipo do animal
     * 
     * @return a paciência máxima do animal em segundos
     */
    public int getPACIENCIA_MAXIMA() {
        return PACIENCIA_MAXIMA;
    }

    /**
     * Retorna o nome do animal.
     * 
     * @return uma string com o nome do animal.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a espécie do animal.
     * 
     * @return uma string com a espécie do animal.
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * Retorna o andar desejado do animal, para desembarcar.
     * 
     * @return o andar desejado pelo animal.
     */
    public int getAndarDesejado() {
        return andarDesejado;
    }

    /**
     * Retorna o tempo de espera do Animal.
     * 
     * @return o tempo esperado pelo animal.
     */
    public int getTempoDeEspera() {
        return tempoDeEspera;
    }

    /**
     * Retorna a temperatura ideal para o Animal.
     * 
     * @return a temperatura ideal para o animal.
     */
    public int getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    /**
     * Aumenta o tempo de espera um animal na fila quando passa um ciclo.
     * Esse é o tempo de espera na fila de um andar para embarcar no elevador.
     * Um ciclo ocorre sempre que o método de simular vida na arca é invocado.
     * Esse método não deve ser chamado fora da classe Arca.
     * <br>
     * <br>
     * A implementação desse método deve comparar a paciência do animal com
     * o tempo de espera depois de incrementado. Se ela for menor, uma exceção
     * deve ser lançada.
     * <br>
     * <br>
     * 
     * @throws RuntimeException se o animal está esperando a mais tempo que a
     *                          paciência
     * @see professor.entidades.Arca#simularVida
     */
    public void aumentaEspera() {

    }

    @Override // devo colocar paciencia maxima aqui?
    public String toString() {
        return "Animal: [Id:" + id + "]" + "\n[Nome:" + nome + "]" +
                "\n[Especie:" + especie + "]" + "\n[Peso:" + peso + "]" + "\n[Andar Desejado:" + andarDesejado + "]" +
                "\n[Tempo de Espera:" + tempoDeEspera + "]" + "\n[Temperatura Ideal:" + temperaturaIdeal + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + PACIENCIA_MAXIMA;
        result = prime * result + id;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((especie == null) ? 0 : especie.hashCode());
        result = prime * result + peso;
        result = prime * result + andarDesejado;
        result = prime * result + tempoDeEspera;
        result = prime * result + temperaturaIdeal;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        if (PACIENCIA_MAXIMA != other.PACIENCIA_MAXIMA)
            return false;
        if (id != other.id)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (especie == null) {
            if (other.especie != null)
                return false;
        } else if (!especie.equals(other.especie))
            return false;
        if (peso != other.peso)
            return false;
        if (andarDesejado != other.andarDesejado)
            return false;
        if (tempoDeEspera != other.tempoDeEspera)
            return false;
        if (temperaturaIdeal != other.temperaturaIdeal)
            return false;
        return true;
    }
}
