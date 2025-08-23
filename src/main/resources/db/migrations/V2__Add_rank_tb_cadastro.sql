-- V2: Migrations para adicionar c oluna de RANK na tabela de cadastro

ALTER TABLE tb_cadastro
add COLUMN rank VARCHAR(255);