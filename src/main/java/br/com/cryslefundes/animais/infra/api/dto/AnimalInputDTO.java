package br.com.cryslefundes.animais.infra.api.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record AnimalInputDTO(
        UUID id,
        @NotBlank
        @NotEmpty
        @JsonAlias("nome_provisorio")
        String nomeProvisorio,
        @NotNull
        @JsonAlias("idade_estimada")
        Integer idadeEstimada,
        @NotBlank
        @NotEmpty
        String raca,
        @NotBlank
        @NotEmpty
        @JsonAlias("nome_recebedor")
        String nomeRecebedor,
        @NotBlank
        @NotEmpty
        @JsonAlias("condicoes_de_chegada")
        String condicoesDeChegada,
        @NotBlank
        @NotEmpty
        String porte
) {

}
