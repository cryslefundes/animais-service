package br.com.cryslefundes.animais.infra.persistence;

import br.com.cryslefundes.animais.application.RepositorioAnimalGateway;
import br.com.cryslefundes.animais.domain.Animal;
import br.com.cryslefundes.animais.infra.utils.AnimalMapper;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class RepositorioAnimalJPA implements RepositorioAnimalGateway {

    private final RepositorioAnimal repositorio;

    public RepositorioAnimalJPA(RepositorioAnimal repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Animal cadastrar(Animal animal) {
        var animalJPA = AnimalMapper.converteAnimalParaAnimalJPA(animal);
        var animalSalvo = this.repositorio.save(animalJPA);
        return AnimalMapper.converteAnimalJPAParaAnimal(animalSalvo);
    }

    @Override
    public Animal buscar(UUID id) {
        var animalBuscado = this.repositorio.findById(id);

        if (animalBuscado.isEmpty()) throw new RepositorioException("Usuário não encontrado.");

        return AnimalMapper.converteAnimalJPAParaAnimal(animalBuscado.get());
    }

    @Override
    public List<Animal> buscarTodos() {
        return this.repositorio.findAll().stream()
                .map(AnimalMapper::converteAnimalJPAParaAnimal)
                .toList();
    }

    @Override
    public Animal atualizar(Animal animal) {
        var animalExiste = this.repositorio.existsById(animal.getId());

        if (!animalExiste) throw new RepositorioException("Usuário não encontrado.");

        var animalJPA = AnimalMapper.converteAnimalParaAnimalJPA(animal);
        this.repositorio.save(animalJPA);

        return AnimalMapper.converteAnimalJPAParaAnimal(animalJPA);
    }

    @Override
    public void deletar(UUID id) {
        this.repositorio.deleteById(id);
    }

    @Override
    public List<Animal> buscarAnimaisResgatadosPorFuncionarioEmUmIntervalo(String nomeRecebedor, Instant dataInicial, Instant dataFinal) {
        return this.repositorio.buscaAnimaisRegastadosPorFuncionarioEmUmIntervalo(nomeRecebedor, dataInicial, dataFinal).stream()
                .map(AnimalMapper::converteAnimalJPAParaAnimal)
                .toList();
    }
}
