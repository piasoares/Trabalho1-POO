package professor.entidades;

import static org.junit.Assert.*;

import org.junit.Test;

import estudantes.entidades.Animal;

public class ElevadorTest {

    /**
     *@author Patricia Rodrigues
     * Testa as funções embarcar e desembarcar do elevador
     */
    @Test
    public void testEmbarcarEDesembarcar() {
        Elevador elevador = new Elevador();
        Andar[] andares;
        Animal animal1 = new Animal(1, "Leão", "Panthera leo", 2, 200, 25);
        Animal animal2 = new Animal(2, "Elefante", "Loxodonta africana", 2, 500, 20);

        elevador.embarcar(animal1);
        elevador.embarcar(animal2);

        Animal[] animaisNoElevador = elevador.checarAnimaisNoElevador();
        assertEquals(2, animaisNoElevador.length);
        andares = new Andar[5]; // Obtenha o andar atual do elevador
        elevador.desembarcar(animal1, andares[1]);
        animaisNoElevador = elevador.checarAnimaisNoElevador();
        assertEquals(1, animaisNoElevador.length);
        assertEquals(animal2, animaisNoElevador[0]);
    }

    /**
     * Testa as funções subir e descer do elevador
     */
    @Test
    public void testSubirEDescer() {
        Elevador elevador = new Elevador();
        int andarInicial = elevador.getAndar();

        // Teste de subida
        elevador.subir();
        assertEquals(andarInicial + 1, elevador.getAndar());

        // Teste de descida
        elevador.descer();
        assertEquals(andarInicial, elevador.getAndar());
    }

    /**
     * Testa a função da temperatura do ar condicionado do elevador
     */
    @Test
    public void testTemperaturaDoArCondicionado() {
        Elevador elevador = new Elevador();

        // Teste de alteração de temperatura válida
        assertTrue(elevador.setTemperaturaDoArCondicionado(30));
        assertEquals(30, elevador.getTemperaturaDoArCondicionado());

        // Teste de alteração de temperatura inválida
        assertFalse(elevador.setTemperaturaDoArCondicionado(-10));
        assertFalse(elevador.setTemperaturaDoArCondicionado(50));
        assertEquals(30, elevador.getTemperaturaDoArCondicionado());
    }


    @Test
    public void testLimiteDePeso() {
        Elevador elevador = new Elevador();
        Andar andar = new Andar(0); // Andar de origem

        int limiteDePeso = elevador.LIMITE_DE_PESO;
        int pesoTotal = 0;

        // Crie animais com pesos predefinidos para o teste
        Animal animal1 = new Animal(1, "Animal1", "Especie1", 0, 500, 25);
        Animal animal2 = new Animal(2, "Animal2", "Especie2", 0, 600, 25);
        Animal animal3 = new Animal(3, "Animal3", "Especie3", 0, 700, 25);

        // Embarque animais até atingir o limite de peso
        if (pesoTotal + animal1.getPeso() <= limiteDePeso) {
            elevador.embarcar(animal1);
            pesoTotal += animal1.getPeso();
        }

        if (pesoTotal + animal2.getPeso() <= limiteDePeso) {
            elevador.embarcar(animal2);
            pesoTotal += animal2.getPeso();
        }

        if (pesoTotal + animal3.getPeso() <= limiteDePeso) {
            elevador.embarcar(animal3);
            pesoTotal += animal3.getPeso();
        }

        // Verifique se o peso não excede o limite
        assertTrue(pesoTotal <= limiteDePeso);
    }
}
