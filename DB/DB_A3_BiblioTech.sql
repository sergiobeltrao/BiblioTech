CREATE DATABASE DB_BiblioTech;

USE DB_BiblioTech;

CREATE TABLE Livros ( 
	ID_livros int PRIMARY KEY AUTO_INCREMENT,
	Nome_livro varchar (100) NOT NULL,
	ISBN Varchar (100)NOT NULL,
	Ano_publicacao DATE, 
	Paginas INT (4)NOT NULL,
	Quantidade INT,
	Categoria varchar (50)NOT NULL,
	Preco FLOAT (5.2)
);

INSERT INTO Livros VALUES(
	NULL, 'O Segredo das Estrelas', '978-1234567890', '1980-10-12', 320, 10,  'Ficção Científica', '180.20');
SELECT * FROM Livros;

CREATE TABLE Autores(
	ID_autor INT PRIMARY KEY AUTO_INCREMENT,
	Nome_autor varchar (100)NOT NULL,
	Data_Nascimento DATE,
	Nacionalidade VARCHAR (50) NOT NULL,
	Biografia TEXT,
	Genero ENUM ('MAS', 'FEM', 'OUTROS'),
	ID_FK_Livros INT,
	FOREIGN KEY (ID_FK_Livros) REFERENCES Livros(ID_livros)
	);
	
INSERT INTO Autores (ID_autor, Nome_autor, Data_Nascimento, Nacionalidade, Genero, ID_FK_Livros) VALUES (
		NULL, 'Laura Bens', '1997-01-27', 'Brazil', 'FEM', 1 );
SELECT * FROM Autores;

CREATE TABLE Editoras (
	ID_Editora INT PRIMARY KEY AUTO_INCREMENT,
	Nome_Editora VARCHAR (50) NOT NULL,
	Telefone VARCHAR (12) NOT NULL,
	Endereço varchar (100)NOT NULL, /*Este talvez vire uma tabela*/
	ID_FK_Livros INT,
	FOREIGN KEY (ID_FK_Livros) REFERENCES Livros(ID_livros)
	);
	
SELECT * FROM Editoras;
INSERT INTO Editoras (Nome_Editora, Telefone, Endereço) VALUES ( 'Galáxia Editora', '12345678', 'SP, Centro, AV. Paulista');
SELECT Nome_autor, Nome_livro FROM Autores INNER JOIN Livros;










