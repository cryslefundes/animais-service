package br.com.cryslefundes.animais.infra.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "Animal")
@Table(name = "animais")
public class AnimalJPA {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String nomeProvisorio;
    @Column(nullable = false)
    private Integer idadeEstimada;
    @Column(nullable = false)
    private String raca;
    @Column(nullable = false)
    private String nomeRecebedor;
    @Column(nullable = false)
    private String condicoesDeChegada;
    @Column(nullable = false)
    private String porte;
    @Column(nullable = false)
    private Instant dataDeChegada;
    private Instant dataDeAdocao;
    private Instant dataDeObito;

    public static AnimalJPA novoAnimal(
            final UUID id,
            final String nomeProvisorio,
            final Integer idadeEstimada,
            final String raca,
            final String nomeRecebedor,
            final String condicoesDeChegada,
            final String porte,
            final Instant dataDeChegada,
            final Instant dataDeAdocao,
            final Instant dataDeObito
    ) {
        return new AnimalJPA(id, nomeProvisorio, idadeEstimada, raca, nomeRecebedor, condicoesDeChegada, porte, dataDeChegada, dataDeAdocao, dataDeObito);
    }
}
