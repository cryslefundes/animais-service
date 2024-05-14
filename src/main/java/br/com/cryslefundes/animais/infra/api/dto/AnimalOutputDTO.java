package br.com.cryslefundes.animais.infra.api.dto;

import br.com.cryslefundes.animais.domain.Animal;

import java.time.Instant;
import java.util.UUID;

public record AnimalOutputDTO(
        UUID id,
        String nomeProvisorio,
        Integer idadeEstimada,
        String raca,
        String nomeRecebedor,
        String condicoesDeChegada,
        String porte,
        Instant dataDeChegada,
        Instant dataDeAdocao,
        Instant dataDeObito
) {
    public AnimalOutputDTO(Animal animal) {
        this(
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
}
