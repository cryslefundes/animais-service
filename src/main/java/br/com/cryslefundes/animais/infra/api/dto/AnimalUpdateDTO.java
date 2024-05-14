package br.com.cryslefundes.animais.infra.api.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.Instant;
import java.util.UUID;

public record AnimalUpdateDTO (
    @NotNull
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
    String porte,
    @NotNull
    @PastOrPresent
    @JsonAlias("data_de_chegada")
    Instant dataDeChegada,
    @PastOrPresent
    @JsonAlias("data_de_adocao")
    Instant dataDeAdocao,
    @PastOrPresent
    @JsonAlias("data_de_obito")
    Instant dataDeObito
){

}
