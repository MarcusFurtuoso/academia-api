--liquibase formatted sql

--changeset liquibase:1

    CREATE TABLE tb_avaliacoes (
        id BIGINT NOT NULL AUTO_INCREMENT,
        altura_atual FLOAT NOT NULL,
        data_da_avaliacao DATETIME NOT NULL,
        peso_atual FLOAT NOT NULL,
        aluno_id BIGINT NOT NULL,

        PRIMARY KEY (id)
    );
    
    ALTER TABLE tb_avaliacoes ADD CONSTRAINT fk_avaliacoes_alunos
    FOREIGN KEY (aluno_id) REFERENCES tb_alunos (id)