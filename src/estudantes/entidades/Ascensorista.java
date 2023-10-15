package estudantes.entidades;

import professor.entidades.Andar;
import professor.entidades.Elevador;

/**
 * Classe que traz a lógica do algoritmo de uso do elevador.
 * <br>
 * <br>
 * Você pode incluir novos atributos e métodos nessa classe para criar
 * lógicas mais complexas para o gerenciamento do uso do elevador, mas esses
 * <strong>atributos e métodos devem ser todos privados</strong>. O único
 * método público deve ser "agir".
 * 
 * @author Jean Cheiran
 * @version 1.0
 */
public class Ascensorista {

    /**
     * Construtor padrão de Ascensorista.
     * Esse construtor sem parâmetros que será usado pela Arca. Embora a
     * assinatura do construtor não deva ser mudada, o código interno pode
     * ser alterado conforme a necessidade.
     */
    public Ascensorista() {
        /* TODO: codificar */
    }

    /**
     * Executa a lógica de controle do elevador e dos animais.
     * Esse método é o único método de controle invocado durante a simulação
     * de vida da arca.
     * <br>
     * <br>
     * Aqui podem ser feitas todas as verificações sobre os animais do elevador
     * e da fila de animais que estão esperando no andar. A partir desses
     * estados, você pode movimentar animais para dentro e para fora do
     * elevador usando os métodos "desembarcar" e "embarcar" por exemplo.
     * O estado do elevador também é importante para acionar os comandos do
     * elevador como "drenar", "encher", "subir" e "descer".
     * 
     * @param elevador o elevador controlado pelo ascensorista
     * @param andar    o andar no qual o elevador está parado
     */
    public void agir(Elevador elevador, Andar andar) {
        System.out.println("Início do método agir");
        while (andar.consultarTamanhoDaFila() > 0) { // Verifica se tem animais na fila do andar
            Animal animal = andar.chamarProximoDaFila(); // Pega o próximo animal na fila do andar
            String tipoAnimal = animal.getClass().getSimpleName(); // Verifica o tipo do animal

            boolean encherDeAgua = (tipoAnimal.equals("Anfibio") || tipoAnimal.equals("MamiferoAquatico") ||
                    tipoAnimal.equals("Peixe") || tipoAnimal.equals("ReptilAquatico"));

            boolean naoEncherDeAgua = (tipoAnimal.equals("Anfibio") || tipoAnimal.equals("Ave") ||
                    tipoAnimal.equals("AveVoadora") || tipoAnimal.equals("MamiferoTerrestre") ||
                    tipoAnimal.equals("MamiferoVoador") || tipoAnimal.equals("Reptil"));

            for (Animal outroAnimal : andar.checarFilaParaElevador()) {
                // Verifica se há outros animais na fila com características semelhantes
                if (outroAnimal != animal &&
                        outroAnimal.getAndarDesejado() == animal.getAndarDesejado() &&
                        outroAnimal.getTemperaturaIdeal() == animal.getTemperaturaIdeal() &&
                        elevador.isCheioDeAgua() == encherDeAgua) {
                    animal = outroAnimal; // Se sim, atualiza a referência do animal para um com características
                                          // semelhantes
                }
            }

            if (encherDeAgua && !elevador.isCheioDeAgua()) {
                elevador.encher(); // Enche o elevador de água se necessário
                elevador.setTemperaturaDoArCondicionado(animal.getTemperaturaIdeal()); // Define a temperatura do
                                                                                       // elevador
            } else if (naoEncherDeAgua && elevador.isCheioDeAgua()) {
                elevador.drenar(); // Drena a água do elevador se necessário
                elevador.setTemperaturaDoArCondicionado(animal.getTemperaturaIdeal()); // Define a temperatura do
                                                                                       // elevador
            } else {
                elevador.setTemperaturaDoArCondicionado(animal.getTemperaturaIdeal()); // Define a temperatura do
                                                                                       // elevador
            }

            int pesoTotal = 0;
            int animaisEmbarcados = 0;
            elevador.embarcar(animal); // Embarca o animal no elevador
            pesoTotal += animal.getPeso(); // Atualiza o peso total com o peso do animal
            animaisEmbarcados++;

            for (int i = 0; i < andar.checarFilaParaElevador().length; i++) {
                if (andar.checarFilaParaElevador()[i] != animal) {
                    int novoPeso = pesoTotal + andar.checarFilaParaElevador()[i].getPeso();
                    if (novoPeso <= elevador.LIMITE_DE_PESO) {
                        elevador.embarcar(andar.checarFilaParaElevador()[i]); // Embarca outros animais se não
                                                                              // ultrapassar o peso máximo
                        pesoTotal = novoPeso;
                        animaisEmbarcados++;
                    }
                }
                if (pesoTotal > elevador.LIMITE_DE_PESO) {
                    break;
                }
            }

            for (int i = 0; i < animaisEmbarcados; i++) {
                if (elevador.getAndar() > 0) {
                    elevador.descer(); // Move os animais para baixo para desembarcar.
                }                
            }

            // Adicione o aumento de espera para todos os animais na fila após o embarque.
            // Obtém a fila de animais no andar
            Animal[] fila = andar.checarFilaParaElevador();

            // Itera por todos os animais na fila e aplica o aumento de espera
            for (Animal animalNaFila : fila) {
                animalNaFila.aumentaEspera(andar);
            }

            andar.desembarcar(animal); // Remove o animal do andar

            for (int i = 0; i < andar.checarFilaParaElevador().length; i++) {
                andar.desembarcar(andar.checarFilaParaElevador()[i]); // Remove outros animais que embarcaram junto
            }
        }

        System.out.println("Fim do método agir");
    }
}
