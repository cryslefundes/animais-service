package br.com.cryslefundes.animais.infra.api.service;

import br.com.cryslefundes.animais.application.AnimalUseCase;
import br.com.cryslefundes.animais.domain.Animal;
import br.com.cryslefundes.animais.infra.api.dto.AnimalInputDTO;
import br.com.cryslefundes.animais.infra.api.dto.AnimalOutputDTO;
import br.com.cryslefundes.animais.infra.api.dto.AnimalUpdateDTO;
import br.com.cryslefundes.animais.infra.api.dto.ResgasteAnimalEmIntervaloDTO;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class AnimalService {
    private final AnimalUseCase useCase;

    public AnimalService(AnimalUseCase useCase) {
        this.useCase = useCase;
    }

    public AnimalOutputDTO cadastrarAnimal(AnimalInputDTO inputDTO) {
        var novoAnimal = Animal.novoAnimal(
                inputDTO.nomeProvisorio(),
                inputDTO.idadeEstimada(),
                inputDTO.raca(),
                inputDTO.nomeRecebedor(),
                inputDTO.condicoesDeChegada(),
                inputDTO.porte()
        );
        var animalSalvo = this.useCase.cadastrarAnimal(novoAnimal);
        return new AnimalOutputDTO(animalSalvo);
    }

    public AnimalOutputDTO buscarAnimalPorId(UUID id) {
        var animal = this.useCase.buscarUmAnimalPorId(id);
        return new AnimalOutputDTO(animal);
    }

    public List<AnimalOutputDTO> buscarTodosOsAnimais() {
        return this.useCase.buscarTodosOsAnimais().stream()
                .map(AnimalOutputDTO::new)
                .toList();
    }

    public AnimalOutputDTO atualizarAnimal(AnimalUpdateDTO updateDTO) {
        var animal = Animal.novoAnimal(
                updateDTO.id(),
                updateDTO.nomeProvisorio(),
                updateDTO.idadeEstimada(),
                updateDTO.raca(),
                updateDTO.nomeRecebedor(),
                updateDTO.condicoesDeChegada(),
                updateDTO.porte(),
                updateDTO.dataDeChegada(),
                updateDTO.dataDeAdocao(),
                updateDTO.dataDeObito()
        );
        var animalAtualizado = this.useCase.atualizarAnimal(animal);
        return new AnimalOutputDTO(animalAtualizado);
    }

    public void excluirAnimal(UUID id) {
        this.useCase.deletarAnimal(id);
    }

    public List<AnimalOutputDTO> buscarAnimaisResgatadosPorFuncionarioEmUmIntervalo(ResgasteAnimalEmIntervaloDTO dto) {
        return this.useCase.buscarAnimaisResgatadosPorFuncionarioEmUmIntervalo(
                        dto.nomeRecebedor(),
                        dto.dataInicial(),
                        dto.dataFinal()).stream()
                .map(AnimalOutputDTO::new)
                .toList();
    }

}

