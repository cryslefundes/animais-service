package br.com.cryslefundes.animais.infra.api.controller;

import br.com.cryslefundes.animais.infra.api.dto.AnimalInputDTO;
import br.com.cryslefundes.animais.infra.api.dto.AnimalOutputDTO;
import br.com.cryslefundes.animais.infra.api.dto.AnimalUpdateDTO;
import br.com.cryslefundes.animais.infra.api.dto.ResgasteAnimalEmIntervaloDTO;
import br.com.cryslefundes.animais.infra.api.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animais")
public class AnimalController {
    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AnimalOutputDTO> cadastrarAnimal(@Valid @RequestBody AnimalInputDTO inputDTO) {
        var animalCadastrado = this.service.cadastrarAnimal(inputDTO);
        return ResponseEntity.created(URI.create("/animais/" + animalCadastrado.id())).build();
    }

    @GetMapping
    public ResponseEntity<List<AnimalOutputDTO>> buscarTodosOsAnimais() {
        return ResponseEntity.ok(this.service.buscarTodosOsAnimais());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalOutputDTO> buscarAnimalPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(this.service.buscarAnimalPorId(id));
    }

    @GetMapping("/intervalo-resgate")
    public ResponseEntity<List<AnimalOutputDTO>> buscarAnimalResgatadoPorFuncionarioEmUmIntervalo(@Valid @RequestBody ResgasteAnimalEmIntervaloDTO dto) {
        var animais = this.service.buscarAnimaisResgatadosPorFuncionarioEmUmIntervalo(dto);
        return ResponseEntity.ok(animais);
    }

    @PutMapping
    public ResponseEntity<AnimalOutputDTO> atualizarAnimal(@Valid @RequestBody AnimalUpdateDTO updateDTO) {
        return ResponseEntity.ok(this.service.atualizarAnimal(updateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirAnimal(@PathVariable UUID id) {
        this.service.excluirAnimal(id);
        return ResponseEntity.noContent().build();
    }

}
