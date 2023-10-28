CREATE DATABASE DB_BiblioTech;  -- Vocês estão usando bancos separados. É bom unificar.

USE DB_BiblioTech;

CREATE TABLE livros ( 
	li_ID_livros int NOT NULL PRIMARY KEY AUTO_INCREMENT, -- Como o "li" inicial é uma abreviatura de "livros", colocar "livros" no final fica meio redundante.
	li_nome_livro varchar (100), -- Aqui também, "livro" no final
	li_nome_autor varchar (100),
	li_ISBN Varchar (100), -- Um varchar(17) já cabe um ISBN13 com digitos e hifens
	li_paginas int (4), -- O MySQL 8.0 depreciou o uso de limitadores no int e avisa "warning(s): 1681 Integer display width is deprecated and will be removed in a future release."
	li_quantidade varchar (100), -- Não deveria ser um int?
	li_categoria varchar (50),
	li_editora varchar (50),
	li_versao varchar (40),
	li_integridade char (2), -- Como os únicos valores serão 'Novo' ou 'Usado' um varchar(5) já resolve
	li_avalicacao varchar (4), -- Como vai ser avaliado de 0 a 10 acho que deveria ser um int
	li_sinopse text
);


-- Essa parte aqui pode deletar já que foi um teste interno e também tá acusando erro

insert into livros (li_quantidade)  values ( auto_increment)  where li_ID_livros = 1;
INSERT INTO livros (li_quantidade) VALUES (NULL)  where li_ID_livros = 1;

--

-- Como tá usando 'AUTO_INCREMENT' no ID acho que não precisa informar ele manualmente

-- Vale a pena organizar um pouco essa parte aqui e remover os dados duplicados e IDs
insert into livros (li_ID_livros, li_nome_livro, li_nome_autor, li_ISBN, li_paginas, li_quantidade, 
li_categoria, li_editora, li_versao, li_integridade, li_avalicacao, li_sinopse) values ( 
);
insert into livros (li_ID_livros, li_nome_livro, li_nome_autor, li_ISBN, li_paginas, li_categoria, li_editora ) values
(1, 'O Segredo das Estrelas', 'Laura Smith', '978-1234567890', 320, 'Ficção Científica', 'Galáxia Editora');


insert into livros (li_ID_livros, li_nome_livro, li_nome_autor, li_ISBN, li_paginas, li_categoria, li_editora, li_versao ) values
(2, 'Caminho das Sombras', 'John Doe', '978-0987654321', 480, 'Fantasia Épica', 'Mundo Mágico Publicações', 3);

insert into livros (li_quantidade) values
(2, 'Caminho das Sombras', 'John Doe', '978-0987654321', 480, 'Fantasia Épica', 'Mundo Mágico Publicações', 3),
(3, 'A Cidade dos Suspiros', 'Maria Silva', '978-5432109876', 256, 'Romance', 'Amor & Drama Editora', 'Atlas'),
(4, 'Aventuras no Espaço-Tempo', 'Carlos Rodrigues', '978-1122334455', 400, 'Ficção Científica', 'Via Láctea Livros', 'Edição Limitada'),
(5, 'Noites de Mistério', 'Isabel Pereira', '978-5555555555', 384, 'Suspense', 'Editora Enigma', 'Edição de Bolso'),
(6, 'O Legado Perdido', 'Roberto Santos', '978-9876543210', 320, 'Fantasia', 'Terra dos Sonhos Publicações', 'Edição Revisada'),
(7, 'Trilhas de Aventura', 'Lucas Ribeiro', '978-1357924680', 416, 'Ação e Aventura', 'Editora Desbravadores', 'Edição Definitiva'),
(8, 'Segredos Obscuros', 'Mariana Lima', '978-1111222233', 272, 'Thriller', 'Editora Mistério Sombrio', 'Edição de Colecionador'),
(9, 'Além da Imaginação', 'Pedro Carvalho', '978-9876543211', 352, 'Ficção Científica', 'Universo Paralelo Editora', 'Edição Especial'),
(10, 'O Enigma do Passado', 'Ana Santos', '978-4444333222', 304, 'Mistério', 'Editora Enigmas e Revelações', 'Edição Limitada');


select * from livros;



-- Isso aqui pode deletar já que essas mudanças tinham sido aplicadas no script

ALTER TABLE livros MODIFY li_versao VARCHAR(40);
UPDATE livros set li_versao =  'Editora Luxo' where li_ID_livros = 1;
UPDATE livros set li_quantidade =  10 where li_ID_livros = 1;
 
 --