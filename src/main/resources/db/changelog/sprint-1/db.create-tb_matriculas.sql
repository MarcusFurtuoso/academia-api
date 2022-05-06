--liquibase formatted sql

--changeset liquibase:1

    CREATE TABLE tb_matriculas (
        id BIGINT NOT NULL AUTO_INCREMENT,
        data_da_matricula DATETIME NOT NULL,
        aluno_id BIGINT NOT NULL,

        PRIMARY KEY (id)
    );

    ALTER TABLE tb_matriculas ADD CONSTRAINT fk_matriculas_alunos
    FOREIGN KEY (aluno_id) REFERENCES tb_alunos (id)