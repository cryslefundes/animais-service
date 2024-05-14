package br.com.cryslefundes.animais.infra.utils;

import br.com.cryslefundes.animais.domain.Animal;
import br.com.cryslefundes.animais.infra.persistence.AnimalJPA;

public class AnimalMapper {
    public static AnimalJPA converteAnimalParaAnimalJPA(Animal animal) {
        return AnimalJPA.novoAnimal(
                animal.getId(),
                animal.getNomeProvisorio(),
                animal.getIdadeEstimada(),
                animal.getRaca(),
                animal.getNomeRecebedor(),
                animal.getCondicoesDeChegada(),
                animal.getPorte(),
                animal.getDataDeChegada(),
                animal.getDataDeAdocao(),
                animal.getDataDeObito()
        );
    }

    public static Animal converteAnimalJPAParaAnimal(AnimalJPA animalJPA) {
        return Animal.novoAnimal(
                animalJPA.getId(),
                animalJPA.getNomeProvisorio(),
                animalJPA.getIdadeEstimada(),
                animalJPA.getRaca(),
                animalJPA.getNomeRecebedor(),
                animalJPA.getCondicoesDeChegada(),
                animalJPA.getPorte(),
                animalJPA.getDataDeChegada(),
                animalJPA.getDataDeAdocao(),
                animalJPA.getDataDeObito()
        );
    }


}
