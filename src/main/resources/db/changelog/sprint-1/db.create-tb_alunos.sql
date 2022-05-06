--liquibase formatted sql

--changeset liquibase:1

    CREATE TABLE tb_alunos (
        id BIGINT NOT NULL AUTO_INCREMENT,
        nome VARCHAR(255) NOT NULL,
        bairro VARCHAR(255),
        cpf VARCHAR(255) NOT NULL,
        data_de_nascimento DATE NOT NULL,

        PRIMARY KEY (id)
    );