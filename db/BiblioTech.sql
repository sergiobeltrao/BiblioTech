-- Banco de testes com informações básicas para
-- testar a conectividade entre o programa e o MySQL

-- Cria o banco
CREATE DATABASE BIBLIOTECH;

-- Seleciona o banco que será usado
USE BIBLIOTECH;

-- Cria a tabela e seus respectivos atributos
CREATE TABLE USUARIOS(
USR_ID INT PRIMARY KEY AUTO_INCREMENT,
USR_NOME VARCHAR(20) not null,
USR_SENHA VARCHAR(16) not null
);

-- Insert de usuário
INSERT INTO USUARIOS(USR_NOME, USR_SENHA)
VALUES('admin', 'admin');
INSERT INTO USUARIOS(USR_NOME, USR_SENHA)
VALUES('sergio', 'senha123');

-- Printando todos os dados.
SELECT * FROM USUARIOS;
