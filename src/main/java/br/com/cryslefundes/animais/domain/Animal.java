package br.com.cryslefundes.animais.domain;

import java.time.Instant;
import java.util.UUID;

public class Animal {
    private UUID id;
    private String nomeProvisorio;
    private Integer idadeEstimada;
    private String raca;
    private String nomeRecebedor;
    private String condicoesDeChegada;
    private String porte;
    private Instant dataDeChegada;
    private Instant dataDeAdocao;
    private Instant dataDeObito;

    private Animal(
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
        this.id = id;
        this.nomeProvisorio = nomeProvisorio;
        this.idadeEstimada = idadeEstimada;
        this.raca = raca;
        this.nomeRecebedor = nomeRecebedor;
        this.condicoesDeChegada = condicoesDeChegada;
        this.porte = porte;
        this.dataDeChegada = dataDeChegada;
        this.dataDeAdocao = dataDeAdocao;
        this.dataDeObito = dataDeObito;
    }

    public static Animal novoAnimal(
            final String nomeProvisorio,
            final Integer idadeEstimada,
            final String raca,
            final String nomeRecebedor,
            final String condicoesDeChegada,
            final String porte
    ) {
        final var animalId = UUID.randomUUID();
        final var dataDeChegadaDoAnimal = Instant.now();
        return new Animal(animalId, nomeProvisorio, idadeEstimada, raca, nomeRecebedor, condicoesDeChegada, porte, dataDeChegadaDoAnimal, null, null);
    }
    public static Animal novoAnimal(
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
        return new Animal(id, nomeProvisorio, idadeEstimada, raca, nomeRecebedor, condicoesDeChegada, porte, dataDeChegada, dataDeAdocao, dataDeObito);
    }

    public void alterarNomeProvisorio(String nomeProvisorio) {
        this.nomeProvisorio = nomeProvisorio;
    }

    public void atribuirDataDeAdocao(Instant dataDeAdocao) {
        this.dataDeAdocao = dataDeAdocao;
    }

    public void atribuirDataDeObito(Instant dataDeObito) {
        this.dataDeObito = dataDeObito;
    }

    public UUID getId() {
        return id;
    }

    public String getNomeProvisorio() {
        return nomeProvisorio;
    }

    public Integer getIdadeEstimada() {
        return idadeEstimada;
    }

    public String getRaca() {
        return raca;
    }

    public String getNomeRecebedor() {
        return nomeRecebedor;
    }

    public String getCondicoesDeChegada() {
        return condicoesDeChegada;
    }

    public String getPorte() {
        return porte;
    }

    public Instant getDataDeChegada() {
        return dataDeChegada;
    }

    public Instant getDataDeAdocao() {
        return dataDeAdocao;
    }

    public Instant getDataDeObito() {
        return dataDeObito;
    }
}
