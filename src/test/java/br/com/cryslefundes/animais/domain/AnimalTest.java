package br.com.cryslefundes.animais.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    @DisplayName("Passado parametros válidos, deve ser capaz de criar uma nova instancia de animal")
    void deveCriarUmAnimalAPartirDeParametrosValidos() {
        String nomeProvisorioEsperado = "Thor";
        Integer idadeEstimadaEsperada = 4;
        String racaEsperada = "chihuahua";
        String nomeRecebedorEsperado = "Crystian";
        String condicoesDeChegadaEsperada = "Assustado, machucados leves e bem magro";
        String porteEsperado = "pequeno";

        var animal = Animal.novoAnimal(nomeProvisorioEsperado, idadeEstimadaEsperada, racaEsperada, nomeRecebedorEsperado, condicoesDeChegadaEsperada, porteEsperado);

        assertNotNull(animal);
        assertNotNull(animal.getId());
        assertEquals(nomeProvisorioEsperado, animal.getNomeProvisorio());
        assertEquals(idadeEstimadaEsperada, animal.getIdadeEstimada());
        assertEquals(racaEsperada, animal.getRaca());
        assertEquals(nomeRecebedorEsperado, animal.getNomeRecebedor());
        assertEquals(condicoesDeChegadaEsperada, animal.getCondicoesDeChegada());
        assertEquals(porteEsperado, animal.getPorte());
        assertNotNull(animal.getDataDeChegada());
        assertNull(animal.getDataDeObito());
        assertNull(animal.getDataDeAdocao());
    }
}
