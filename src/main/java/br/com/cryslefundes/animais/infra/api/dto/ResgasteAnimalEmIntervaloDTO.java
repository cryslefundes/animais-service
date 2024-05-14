package br.com.cryslefundes.animais.infra.api.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;

import java.time.Instant;

public record ResgasteAnimalEmIntervaloDTO(
        @NotBlank
        @NotEmpty
        @JsonAlias("nome_recebedor")
        String nomeRecebedor,
        @Past
        @JsonAlias("data_inicial")
        Instant dataInicial,
        @PastOrPresent
        @JsonAlias("data_final")
        Instant dataFinal
) {
}
