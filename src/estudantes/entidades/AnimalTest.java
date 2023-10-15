package estudantes.entidades;

import professor.entidades.Andar; // Importe a classe Andar

import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void testAumentaEspera() {
        // Crie um andar (substitua com a lógica real de criação do Andar)
        Andar andar = new Andar(0); // Certifique-se de criar o Andar apropriadamente

        // Crie um animal
        Animal animal = new Animal(1, "Cachorro", "Canis lupus familiaris", 0, 10, 25);

        // Adicione o animal à fila do elevador no andar (substitua com a lógica real)
        andar.colocarNaFila(animal);

        // Inicialmente, o tempo de espera é 0
        assertEquals(0, animal.getTempoDeEspera());

        // Simule o aumento de espera por 25 ciclos (tempo total igual à paciência máxima)
        for (int i = 0; i < 25; i++) {
            animal.aumentaEspera(andar); // Passe o Andar como argumento
        }

        // O tempo de espera agora deve ser igual à paciência máxima
        assertEquals(25, animal.getTempoDeEspera());

        // Simule um ciclo adicional, ultrapassando a paciência máxima
        try {
            animal.aumentaEspera(andar); // Passe o Andar como argumento
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            // Certifique-se de que uma exceção seja lançada
            assertEquals("O animal está esperando mais tempo do que sua paciência permite", e.getMessage());
        }

        // Verifique se o animal foi removido da fila do elevador
        assertEquals(0, andar.consultarTamanhoDaFila());

        // Verifique se o animal foi adicionado à lista de animais que saíram da fila
        assertTrue(Animal.getAnimaisQueSairamDaFila().contains(animal));
    }
}