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
 * @author Pietra
 * @author Patricia
 * @version 1.3
 */
public class Ascensorista {

    /**
     * Construtor padrão de Ascensorista.
     * Esse construtor sem parâmetros que será usado pela Arca. Embora a
     * assinatura do construtor não deva ser mudada, o código interno pode
     * ser alterado conforme a necessidade.
     */
    public Ascensorista() {
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
        System.out.println("Inicio do metodo agir");
        int pesoTotal = 0;
        int andarDesejado = 0;
        int andarAtual = elevador.getAndar();
        int temperaturaDoArCondicionado = 0;

        if(elevador.checarAnimaisNoElevador().length > 0){
            andarDesejado = elevador.checarAnimaisNoElevador()[0].getAndarDesejado();
            if (andarDesejado > andarAtual) {
                elevador.subir();
                elevador.movimentar();
                andarAtual = elevador.getAndar(); // Atualize o andarAtual
                System.out.println("Elevador subindo para o andar " + andarAtual);
    
            } else if (andarDesejado < andarAtual) {
                elevador.descer();
                elevador.movimentar();
                andarAtual = elevador.getAndar(); // Atualize o andarAtual
                System.out.println("Elevador descendo...");
    
            } else if (andarDesejado == andarAtual) {
                System.out.println("Elevador continua no mesmo andar.");
                andar.desembarcar(andar.chamarProximoDaFila()); // Pra garantir
                System.out.println("animaisQueDesceram "+andar.animaisQueDesceram.size());
                elevador.desembarcar(elevador.checarAnimaisNoElevador()[0], andar);
                pesoTotal = 0;
                movimentaFila(elevador, andar, pesoTotal);
                System.out.println("Peso total após desembarque: " + pesoTotal);
                System.out.println("Animal desembarcado no andar desejado. Andar:" + andarDesejado);
    
            }
        }else{
            movimentaFila(elevador, andar, pesoTotal);
            
            if(elevador.checarAnimaisNoElevador().length > 0){
                andarDesejado = elevador.checarAnimaisNoElevador()[0].getAndarDesejado();
                if (andarDesejado == andarAtual) {
                    System.out.println("Elevador continua no mesmo andar.");
                    andar.desembarcar(andar.chamarProximoDaFila()); // Pra garantir
                    System.out.println("animaisQueDesceram "+andar.animaisQueDesceram.size());
                    elevador.desembarcar(elevador.checarAnimaisNoElevador()[0], andar);
                    pesoTotal = 0;
                    movimentaFila(elevador, andar, pesoTotal);
                    System.out.println("Peso total após desembarque: " + pesoTotal);
                    System.out.println("Animal desembarcado no andar desejado. Andar:" + andarDesejado);
        
                }
            }
            
        }
       
    /*
     * // Verificar se o elevador está no térreo (andar 0)
     * if (elevador.getAndar() == 0) {
     * elevador.subir();
     * } else if (andar.consultarTamanhoDaFila() == 0) {
     * irParaTerreo(elevador);
     * }
     */

    System.out.println("Fim do método agir");
    }

    public  void movimentaFila(Elevador elevador, Andar andar, int pesoTotal){
        
        // Verificar se o elevador está subindo ou descendo
        // Verificar se há animais na fila do andar
        if (andar.consultarTamanhoDaFila() > 0) {
            System.out.println("Tamanho da fila " + andar.consultarTamanhoDaFila());
            // Obter o primeiro animal da fila
            Animal animal = andar.chamarProximoDaFila();

            // Verificar as características do primeiro animal da fila
            String tipoAnimal = animal.getClass().getSimpleName();

            // Preparar o elevador para o animal
            boolean encherDeAgua = (tipoAnimal.equals("Anfibio") || tipoAnimal.equals("MamiferoAquatico") ||
                    tipoAnimal.equals("Peixe") || tipoAnimal.equals("ReptilAquatico"));

            if (encherDeAgua == elevador.cheioDeAgua) {// ???
                if (encherDeAgua && !elevador.isCheioDeAgua()) {
                    elevador.encher(); // Encher o elevador de água se necessário
                    System.out.println("O elevador está alagado");
                    elevador.setTemperaturaDoArCondicionado(animal.getTemperaturaIdeal()); // Definir a temperatura do
                    // elevador
                } else if (!encherDeAgua && elevador.isCheioDeAgua()) {
                    elevador.drenar(); // Drenar a água do elevador se necessário
                    System.out.println("O elevador foi drenado e está sem água");
                    elevador.setTemperaturaDoArCondicionado(animal.getTemperaturaIdeal()); // Definir a temperatura do
                    // elevador
                } else {
                    elevador.setTemperaturaDoArCondicionado(animal.getTemperaturaIdeal()); // Definir a temperatura do
                    // elevador
                }
            }

            // Embarcar o animal no elevador
            if (temperaturaIdeal(animal.getTemperaturaIdeal(), elevador.getTemperaturaDoArCondicionado())) {
                elevador.embarcar(animal);
                pesoTotal += animal.getPeso(); // Atualiza o peso total
                andar.tirarDaFila(animal);
                elevador.remover(animal);
                System.out.println("Animal embarcado no elevador ");
                System.out.println("O peso atual no elevador é de :" + pesoTotal);
            } else {
                System.out.println("Animal náo pode embarcar por causa da temperatura ideal.");
            }
        
        // Verificar se há outros animais na fila para embarcar
        while (andar.consultarTamanhoDaFila() > 0) {
            Animal proximoAnimal = andar.chamarProximoDaFila();
            if (podemEmbarcarJuntos(animal, proximoAnimal, elevador)) {
                // Verificar o peso limite antes de embarcar o próximo animal
                if (temperaturaIdeal(animal.getTemperaturaIdeal(), elevador.getTemperaturaDoArCondicionado())) {
                    int novoPesoTotal = pesoTotal + proximoAnimal.getPeso(); // Calcula o novo peso total
                    if (novoPesoTotal <= elevador.LIMITE_DE_PESO) {
                        // Embarcar o próximo animal
                        elevador.embarcar(proximoAnimal);
                        andar.tirarDaFila(proximoAnimal);
                        elevador.remover(proximoAnimal);
                        pesoTotal = novoPesoTotal; // Atualiza o peso total com o novo valor
                        System.out.println("Animal embarcado no elevador");
                        System.out.println("Peso atual no elevador:" + pesoTotal);
                    }
                } else {
                    andar.devolverAnimalParaFila(proximoAnimal);
                    System.out.println("Peso limite do elevador excedido. Não é possível embarcar o próximo animal.");
                }
            } else {
                andar.devolverAnimalParaFila(proximoAnimal);
                System.out.println("Animais não podem embarcar juntos. Eles têm características diferentes.");
                break; // Você pode optar por interromper o loop quando os animais não podem embarcar
                       // juntos
            }
        }

    
        // Desembarcar o animal no andar desejado
        // andar.desembarcar(animal);
        // elevador.desembarcar(animal, andar);
        // Reiniciar a contagem do peso total
        // pesoTotal = 0;
        // System.out.println("animais totais: " +
        // elevador.checarAnimaisNoElevador().length);
        // System.out.println("Peso total após desembarque: " + pesoTotal);
        // System.out.println("AAndar atual:" + andarAtual);
        // System.out.println("Animal desembarcado no andar desejado. Andar:" +
        // andarDesejado);

        // Verificar se há outros animais na fila para embarcar
        // while (andar.consultarTamanhoDaFila() > 0) {
        // Animal proximoAnimal = andar.chamarProximoDaFila();
        // if (podemEmbarcarJuntos(animal, proximoAnimal, elevador)) {
        // // Verificar o peso limite antes de embarcar o próximo animal
        // int novoPesoTotal = pesoTotal + proximoAnimal.getPeso();
        // if (novoPesoTotal <= elevador.LIMITE_DE_PESO) {
        // // Embarcar o próximo animal
        // elevador.embarcar(proximoAnimal);
        // pesoTotal = novoPesoTotal;
        // System.out.println("Animal embarcado no elevador");
        // System.out.println("Peso total após embarque: " + pesoTotal);
        // } else {
        // System.out.println("Peso limite do elevador excedido. Não é possível embarcar
        // o próximo animal.");
        // }
        // } else {
        // System.out.println("Animais não podem embarcar juntos. Eles têm
        // características diferentes.");
        // }
        // }
    }else{
        andarEntrePrimeiroEQuartoAndar(elevador);
        System.out.println("Nenhum animal na fila do andar.");
        // subir se andar for menor que 4 se for 4 descer
    }
    }

    // Método para animais que podem embarcar juntos
    public boolean podemEmbarcarJuntos(Animal animal1, Animal animal2, Elevador elevador) {
        // Verificar se os tipos dos animais são iguais
        if (!animal1.getClass().getSimpleName().equals(animal2.getClass().getSimpleName())) {
            return false;
        }

        // Verificar a diferença de temperatura ideal entre os animais
        int diferencaTemperatura = Math.abs(animal1.getTemperaturaIdeal() - animal2.getTemperaturaIdeal());
        if (diferencaTemperatura > 15) {
            return false;
        }

        return true;
    }

    /**
     * Move o elevador para o térreo (andar 0).
     */
    public void irParaTerreo(Elevador elevador) {
        while (elevador.getAndar() > 0) {
            System.out.println("ta aqui");
            elevador.descer();
            elevador.movimentar();
        }
    }

    public void andarEntrePrimeiroEQuartoAndar(Elevador elevador) {
        int andarAtual = elevador.getAndar();

        
                if (andarAtual < 4) {
                    elevador.subir();
                } else {
                    elevador.descer();
                }
            
                if (andarAtual > 0) {
                    elevador.descer();
                } else {
                    elevador.subir();
                }
        
            elevador.movimentar();
            andarAtual = elevador.getAndar();
        
    }

   public boolean temperaturaIdeal(int temperaturaAnimal, int temperaturaElevador) {
    if (temperaturaAnimal == temperaturaElevador) {
        return true;
    }
    return false;
}
}