package br.com.cryslefundes.animais.application;

import br.com.cryslefundes.animais.domain.Animal;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class AnimalUseCase {

    private final RepositorioAnimalGateway repositorio;

    public AnimalUseCase(RepositorioAnimalGateway repositorio) {
        this.repositorio = repositorio;
    }

    public Animal cadastrarAnimal(Animal animal) {
        return this.repositorio.cadastrar(animal);
    }

    public Animal buscarUmAnimalPorId(UUID id) {
        return this.repositorio.buscar(id);
    }

    public List<Animal> buscarTodosOsAnimais() {
        return this.repositorio.buscarTodos();
    }

    public Animal atualizarAnimal(Animal animal) {
        return this.repositorio.atualizar(animal);
    }

    public void deletarAnimal(UUID id) {
        this.repositorio.deletar(id);
    }

    public List<Animal> buscarAnimaisResgatadosPorFuncionarioEmUmIntervalo(String nomeRecebedor, Instant dataInicial, Instant dataFinal) {
        return this.repositorio.buscarAnimaisResgatadosPorFuncionarioEmUmIntervalo(nomeRecebedor, dataInicial, dataFinal);
    }
}

