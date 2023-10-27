CREATE DATABASE TesteUserAdministrador;

USE TesteUserAdministrador;


CREATE TABLE UserAdministrador (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NomeCompleto VARCHAR(100),
    NomeUsuario VARCHAR(50) UNIQUE,
    Senha VARCHAR(100),
    Email VARCHAR(100) UNIQUE,
    DataCriacao DATETIME,
    DataModificacao DATETIME,
    NivelAcesso ENUM('Administrador', 'Funcionario', 'Cliente'),
    Ativo BOOLEAN,
    Rua VARCHAR(100),
    Cidade VARCHAR(50),
    Estado VARCHAR(50),
    CEP VARCHAR(10),
    Telefone VARCHAR(15),
    DataNascimento DATE
    -- ConfigNotificacoes BOOLEAN DUVIDAS
);

-- Inserir alguns usuários fictícios
INSERT INTO UserAdministrador (NomeCompleto, NomeUsuario, Senha, Email, DataCriacao, DataModificacao, NivelAcesso, Ativo, Rua, Cidade, Estado, CEP, Telefone, DataNascimento, ConfigNotificacoes)
VALUES
('Eduardo Silva', 'eduardo', 'senha123', 'eduardo@email.com', NOW(), NOW(), 'Administrador', 1, '123 Main St', 'Cidade A', 'Estado A', '12345', '555-123-4567', '1990-01-15', 1),

('John Smith', 'john', 'senha456', 'john@email.com', NOW(), NOW(), 'Funcionario', 1, '456 Elm St', 'Cidade B', 'Estado B', '54321', '555-987-6543', '1985-05-20', 0),

('Sérgio Almeida', 'sergio', 'senha789', 'sergio@email.com', NOW(), NOW(), 'Funcionario', 1, '789 Oak St', 'Cidade C', 'Estado C', '98765', '555-111-2222', '1992-12-10', 1),

('Bruno Oliveira', 'bruno', 'senhaabc', 'bruno@email.com', NOW(), NOW(), 'Cliente', 1, '456 Pine St', 'Cidade A', 'Estado B', '54321', '555-222-3333', '1995-08-03', 0),

('Tiago Santos', 'tiago', 'senhabcd', 'tiago@email.com', NOW(), NOW(), 'Cliente', 1, '987 Cedar St', 'Cidade D', 'Estado A', '23456', '555-333-4444', '1998-03-27', 1),

('Alisson Lima', 'alisson', 'senhacef', 'alisson@email.com', NOW(), NOW(), 'Cliente', 1, '123 Oak St', 'Cidade E', 'Estado E', '12345', '555-444-5555', '1997-11-12', 0),

('Gustavo Ribeiro', 'gustavo', 'senhaghi', 'gustavo@email.com', NOW(), NOW(), 'Cliente', 1, '456 Elm St', 'Cidade F', 'Estado F', '54321', '555-555-6666', '1996-09-07', 1),

('Rodrigo Fernandes', 'rodrigo', 'senhaidj', 'rodrigo@email.com', NOW(), NOW(), 'Cliente', 1, '789 Pine St', 'Cidade G', 'Estado G', '98765', '555-666-7777', '1999-02-18', 0);

INSERT INTO UserAdministrador (NomeCompleto, NomeUsuario, Senha, Email, DataCriacao, DataModificacao, NivelAcesso, Ativo, Rua, Cidade, Estado, CEP, Telefone, DataNascimento)
VALUES
('Eduardo Silva', 'eduardo', 'senha123', 'eduardo@email.com', NOW(), NOW(), 'Administrador', 1, '123 Main St', 'Cidade A', 'Estado A', '12345', '555-123-4567', '1990-01-15'),

('John Smith', 'john', 'senha456', 'john@email.com', NOW(), NOW(), 'Funcionario', 1, '456 Elm St', 'Cidade B', 'Estado B', '54321', '555-987-6543', '1985-05-20'),

('Sérgio Almeida', 'sergio', 'senha789', 'sergio@email.com', NOW(), NOW(), 'Funcionario', 1, '789 Oak St', 'Cidade C', 'Estado C', '98765', '555-111-2222', '1992-12-10'),

('Bruno Oliveira', 'bruno', 'senhaabc', 'bruno@email.com', NOW(), NOW(), 'Cliente', 1, '456 Pine St', 'Cidade A', 'Estado B', '54321', '555-222-3333', '1995-08-03'),

('Tiago Santos', 'tiago', 'senhabcd', 'tiago@email.com', NOW(), NOW(), 'Cliente', 1, '987 Cedar St', 'Cidade D', 'Estado A', '23456', '555-333-4444', '1998-03-27'),

('Alisson Lima', 'alisson', 'senhacef', 'alisson@email.com', NOW(), NOW(), 'Cliente', 1, '123 Oak St', 'Cidade E', 'Estado E', '12345', '555-444-5555', '1997-11-12'),

('Gustavo Ribeiro', 'gustavo', 'senhaghi', 'gustavo@email.com', NOW(), NOW(), 'Cliente', 1, '456 Elm St', 'Cidade F', 'Estado F', '54321', '555-555-6666', '1996-09-07', 1),

('Rodrigo Fernandes', 'rodrigo', 'senhaidj', 'rodrigo@email.com', NOW(), NOW(), 'Cliente', 1, '789 Pine St', 'Cidade G', 'Estado G', '98765', '555-666-7777', '1999-02-18');
SHOW TABLES;

SELECT * FROM UserAdministrador;
SELECT NomeCompleto, NomeUsuario, DataNascimento from UserAdministrador;
DESC UserAdministrador;