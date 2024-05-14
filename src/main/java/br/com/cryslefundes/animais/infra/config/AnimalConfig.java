package br.com.cryslefundes.animais.infra.config;

import br.com.cryslefundes.animais.application.AnimalUseCase;
import br.com.cryslefundes.animais.application.RepositorioAnimalGateway;
import br.com.cryslefundes.animais.infra.persistence.RepositorioAnimal;
import br.com.cryslefundes.animais.infra.persistence.RepositorioAnimalJPA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfig {
    @Bean
    AnimalUseCase retornaUseCase(RepositorioAnimalGateway repositorio) {
        return new AnimalUseCase(repositorio);
    }

    @Bean
    RepositorioAnimalGateway retornaRepositorio(RepositorioAnimal repositorioJPA) {
        return new RepositorioAnimalJPA(repositorioJPA);
    }
}
