CREATE DATABASE DB_BiblioTech;

USE DB_BiblioTech;

CREATE TABLE Livro ( 
	Li_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	Li_Titulo VARCHAR (100),
	Li_Autor VARCHAR (100),
	Li_ISBN VARCHAR (100),
	Li_Pagina INT,
	Li_Quantidade VARCHAR (100),
	Li_Categoria VARCHAR (50),
	Li_Editora VARCHAR (50),
	Li_Versao VARCHAR (40),
	Li_Integridade CHAR (2),
	Li_Avalicacao VARCHAR (4),
	Li_Sinopse TEXT 
    );

INSERT INTO Livro ( Li_Titulo, Li_Autor, Li_ISBN, Li_Pagina, Li_Categoria, Li_Editora ) VALUES
( 'O Segredo das Estrelas', 'Laura Smith', '978-1234567890', 320, 'Ficção Científica', 'Galáxia Editora');

INSERT INTO livro ( Li_Titulo, Li_Autor, Li_ISBN, Li_Pagina, Li_Categoria, Li_Editora, Li_Versao ) VALUES
( 'Caminho das Sombras', 'John Doe', '978-0987654321', 480, 'Fantasia Épica', 'Mundo Mágico Publicações', 'Altas'),
( 'A Cidade dos Suspiros', 'Maria Silva', '978-5432109876', 256, 'Romance', 'Amor & Drama Editora', 'Atlas'),
( 'Aventuras no Espaço-Tempo', 'Carlos Rodrigues', '978-1122334455', 400, 'Ficção Científica', 'Via Láctea Livros', 'Edição Limitada'),
( 'Noites de Mistério', 'Isabel Pereira', '978-5555555555', 384, 'Suspense', 'Editora Enigma', 'Edição de Bolso'),
( 'O Legado Perdido', 'Roberto Santos', '978-9876543210', 320, 'Fantasia', 'Terra dos Sonhos Publicações', 'Edição Revisada'),
( 'Trilhas de Aventura', 'Lucas Ribeiro', '978-1357924680', 416, 'Ação e Aventura', 'Editora Desbravadores', 'Edição Definitiva'),
( 'Segredos Obscuros', 'Mariana Lima', '978-1111222233', 272, 'Thriller', 'Editora Mistério Sombrio', 'Edição de Colecionador'),
( 'Além da Imaginação', 'Pedro Carvalho', '978-9876543211', 352, 'Ficção Científica', 'Universo Paralelo Editora', 'Edição Especial'),
( 'O Enigma do Passado', 'Ana Santos', '978-4444333222', 304, 'Mistério', 'Editora Enigmas e Revelações', 'Edição Limitada');

SELECT * FROM livro;