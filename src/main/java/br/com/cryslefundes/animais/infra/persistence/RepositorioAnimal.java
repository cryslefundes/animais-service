package br.com.cryslefundes.animais.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface RepositorioAnimal extends JpaRepository<AnimalJPA, UUID> {
    @Query("SELECT a FROM Animal a WHERE a.nomeRecebedor = ?1 AND a.dataDeChegada BETWEEN ?2 AND ?3")
    List<AnimalJPA> buscaAnimaisRegastadosPorFuncionarioEmUmIntervalo(String nomeRecebedor, Instant dataInicial, Instant dataFinal);
}
