package estudantes.entidades;

import professor.entidades.Andar;
import professor.entidades.Elevador;

public class AscensoristaTeste {

    /**
     * @param elevador
     * @param andar
     */

    public void agir(Elevador elevador, Andar andar) {
    System.out.println("Inicio do metodo agir");

    // Verificar se há animais na fila do andar
    if (andar.consultarTamanhoDaFila() > 0) {
        // Obter o primeiro animal da fila
        Animal animal = andar.chamarProximoDaFila();

        // Verificar as características do primeiro animal da fila
        String tipoAnimal = animal.getClass().getSimpleName();

        // Preparar o elevador para o animal
        boolean encherDeAgua = (tipoAnimal.equals("Anfibio") || tipoAnimal.equals("MamiferoAquatico") ||
                tipoAnimal.equals("Peixe") || tipoAnimal.equals("ReptilAquatico"));

        if (encherDeAgua && !elevador.isCheioDeAgua()) {
            elevador.encher(); // Encher o elevador de água se necessário
            elevador.setTemperaturaDoArCondicionado(animal.getTemperaturaIdeal()); // Definir a temperatura do elevador
        } else if (!encherDeAgua && elevador.isCheioDeAgua()) {
            elevador.drenar(); // Drenar a água do elevador se necessário
            elevador.setTemperaturaDoArCondicionado(animal.getTemperaturaIdeal()); // Definir a temperatura do elevador
        } else {
            elevador.setTemperaturaDoArCondicionado(animal.getTemperaturaIdeal()); // Definir a temperatura do elevador
        }

        // Embarcar o animal no elevador
        elevador.embarcar(animal);

        System.out.println("Animal embarcado no elevador ");
        // Verificar se há outros animais na fila para embarcar
        while (andar.consultarTamanhoDaFila() > 0) {
            Animal proximoAnimal = andar.chamarProximoDaFila();
            if (podemEmbarcarJuntos(animal, proximoAnimal, elevador)) {
                // Verificar o peso limite antes de embarcar o próximo animal
                int pesoTotal = animal.getPeso() + proximoAnimal.getPeso();
                if (pesoTotal <= elevador.LIMITE_DE_PESO) {
                    // Embarcar o próximo animal
                    elevador.embarcar(proximoAnimal);
                    System.out.println("Animal embarcado no elevador");
                } else {
                    System.out.println("Peso limite do elevador excedido. Não é possível embarcar o próximo animal.");
                }
            } else {
                System.out.println("Animais não podem embarcar juntos. Eles têm características diferentes.");
                break; // Você pode optar por interromper o loop quando os animais não podem embarcar juntos
            }
        }

        int andarDesejado = animal.getAndarDesejado();
        int andarAtual = elevador.getAndar();

        // Verificar se o elevador está subindo ou descendo
        if (andarDesejado > andarAtual) {
            while (elevador.getAndar() < andarDesejado) {
                elevador.subir();
                System.out.println("Elevador subindo");
            }
        } else if (andarDesejado < andarAtual) {
            while (elevador.getAndar() > andarDesejado) {
                elevador.descer();
                System.out.println("Elevador descendo");
            }
        }

        // Desembarcar o animal no andar desejado
        andar.desembarcar(animal);

        System.out.println("Animal desembarcado no andar desejado. Andar:" + andarDesejado);

        // Verificar se há outros animais na fila para embarcar
        while (andar.consultarTamanhoDaFila() > 0) {
            Animal proximoAnimal = andar.chamarProximoDaFila();
            if (podemEmbarcarJuntos(animal, proximoAnimal, elevador)) {
                // Verificar o peso limite antes de embarcar o próximo animal
                int pesoTotal = animal.getPeso() + proximoAnimal.getPeso();
                if (pesoTotal <= elevador.LIMITE_DE_PESO) {
                    // Embarcar o próximo animal
                    elevador.embarcar(proximoAnimal);
                    System.out.println("Animal embarcado no elevador");
                } else {
                    System.out.println("Peso limite do elevador excedido. Não é possível embarcar o próximo animal.");
                }
            } else {
                System.out.println("Animais não podem embarcar juntos. Eles têm características diferentes.");
            }
        }
    } else {
        System.out.println("Nenhum animal na fila do andar.");
    }

    System.out.println("Fim do método agir");
}

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

}
