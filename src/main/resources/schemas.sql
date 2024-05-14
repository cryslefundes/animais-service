CREATE TABLE animais (
    id UUID PRIMARY KEY,
    nome_provisorio VARCHAR(255) NOT NULL,
    idade_estimada VARCHAR(255) NOT NULL,
    raca VARCHAR(255) NOT NULL,
    nome_recebedor VARCHAR(255) NOT NULL,
    condicoes_de_chegada VARCHAR(255) NOT NULL,
    porte VARCHAR(255) NOT NULL,
    data_de_chegada DATE NOT NULL,
    data_de_adocao DATE,
    data_de_obito DATE
);