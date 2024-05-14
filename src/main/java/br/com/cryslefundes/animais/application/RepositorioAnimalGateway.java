package br.com.cryslefundes.animais.application;

import br.com.cryslefundes.animais.domain.Animal;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface RepositorioAnimalGateway {
    Animal cadastrar(Animal animal);
    Animal buscar(UUID id);
    List<Animal> buscarTodos();
    Animal atualizar(Animal animal);
    void deletar(UUID id);
    List<Animal> buscarAnimaisResgatadosPorFuncionarioEmUmIntervalo(String nomeRecebedor, Instant dataInicial, Instant dataFinal);
}
