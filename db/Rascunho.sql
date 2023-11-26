USE BIBLIOTECH;

/* Usuário: sergio Senha: sergio. Usuário: john Senha john */
INSERT INTO USUARIO VALUES
( NULL, 'sergio', '36033BABFB48EC64E197C97FB40D65E6C79F81E04C61AECCEF3009E01645AB8D', 'CLIENTE', 'Sérgio', 'Beltrão', '1990-02-28', 'sergio@email.com',  NOW(), 'MASC', '22222222222'),
( NULL, 'john', '96D9632F363564CC3032521409CF22A852F2032EEC099ED5967C0D000CEC607A', 'CLIENTE', 'Jonatas', 'Sousa', '1990-02-28', 'john@email.com',  NOW(), 'MASC','33333333333');

INSERT INTO TELEFONE VALUES (NULL, 'CELULAR', '11 994545058'), 
(NULL, 'CELULAR', '11 975630714'), (NULL, 'CELULAR', '11 91340-9833');

INSERT INTO ENDERECO VALUES (NULL, 'Dolores', 13, 'APTO', 'Mooca', 'Sao Paulo', 'SP', 'BRASIL', '987321654'),
(NULL, 'Avenida Atlântica', '1702', NULL, 'Copacabana', ' Rio de Janeiro', 'RJ', 'BRASIL', '22021001'),
(NULL, 'Rua22', '122', NULL, 'St. Oeste', 'Goiânia', 'GO', 'BRASIL', '74120140');

INSERT INTO LIVRO VALUES
(NULL, 'O Segredo das Estrelas', '978-12-345-6789-0', 1980, 320, '1 - Ficção', '40 - Programação', 'Portugues - Brasil', 'Atlas', NULL),
(NULL, 'O Alquimista', '978-85-843-9067-0', 1988, 208, '1 - Ficção', '4 - Fantasia', 'Português - Brasil', 'Osires', NULL);

INSERT INTO AUTOR ( AUT_NOME_AUTOR, AUT_NACIONALIDADE, AUT_SEXO) VALUES
('Laura Bens', 'Brasil - Brasileira', 'FEM' ), ('Gabriel Torres', 'Brasil - Brasileira', 'MASC' ),
('Paulo Coelho', 'Brasil - Brasileira', 'MASC' ), ('George R. R. Martin', 'Estados Unidos - Americana', 'MASC' ),
('Agatha Christie', 'Reino Unido - Britânica', 'FEM');

-- livros
INSERT INTO LIVRO (LIV_NOME_LIVRO, LIV_ISBN, LIV_ANO, LIV_PAGINA, LIV_CATEGORIA, LIV_SUBCATEGORIA, LIV_IDIOMA, LIV_EDITORA, LIV_SINOPSE)
VALUES ('Dom Casmurro', '9788532820480', 1899, 256, 'Ficção', 'Romance', 'Português', 'Editora Nova Fronteira', 'A obra retrata a vida de Bento Santiago, um homem enigmático e melancólico.'),
('Cosmos', '9780345539434', 1980, 384, 'Não Ficção', 'Ciências', 'Inglês', 'Ballantine Books', 'Uma jornada pelo universo, explorando ciência, filosofia e a história da vida na Terra.'),
('O Pequeno Príncipe', '9788576573195', 1943, 96, 'Literatura Infantil e Juvenil', 'Contos de Fadas', 'Francês', 'Gallimard', 'Uma história encantadora sobre amizade e valores essenciais da vida.'),
('A Origem das Espécies', '9788533616655', 1859, 480, 'Não Ficção', 'Ciências', 'Português', 'L&PM Editores', 'Charles Darwin explora a teoria da evolução e a seleção natural.'),
('O Poder do Hábito', '9788539004115', 2012, 408, 'Não Ficção', 'Autoajuda', 'Português', 'Objetiva', 'Investiga como os hábitos funcionam e como podem ser transformados.'),
('Cem Anos de Solidão', '9788535908064', 1967, 448, 'Ficção', 'Romance', 'Espanhol', 'Editora Record', 'A história da família Buendía ao longo de várias gerações em Macondo.'),
('A Revolução dos Bichos', '9788535907708', 1945, 128, 'Ficção', 'Sátira', 'Português', 'Companhia das Letras', 'Uma alegoria sobre os eventos que levaram à Revolução Russa.'),
('O Código Da Vinci', '9788575428769', 2003, 448, 'Ficção', 'Mistério', 'Português', 'Editora Arqueiro', 'Uma trama envolvente de conspirações e mistérios ligados à Igreja Católica.'),
('A Arte da Guerra', '9788533618819', 0001, 112, 'Não Ficção', 'Filosofia', 'Português', 'L&PM Pocket', 'Um tratado militar atribuído a Sun Tzu sobre estratégias de guerra.'),
('O Senhor dos Anéis: A Sociedade do Anel', '9788578271223', 1954, 576, 'Ficção', 'Fantasia', 'Inglês', 'Martins Fontes', 'A primeira parte da trilogia épica de J.R.R. Tolkien.');

-- Autores
INSERT INTO AUTOR (AUT_NOME_AUTOR, AUT_NACIONALIDADE, AUT_SEXO)
VALUES ('Machado de Assis', 'Brasileira', 'MASC'), ('Carl Sagan', 'Estadunidense', 'MASC'),
('Antoine de Saint-Exupéry', 'Francês', 'MASC'), ('Charles Darwin', 'Britânica', 'MASC'),
('Charles Duhigg', 'Estadunidense', 'MASC'), ('Gabriel García Márquez', 'Colombiana', 'MASC'),
('George Orwell', 'Britânica', 'MASC'), ('Dan Brown', 'Estadunidense', 'MASC'),
('Sun Tzu', 'Chinesa', 'MASC'), ('J.R.R. Tolkien', 'Britânica', 'MASC');

-- chave estrangeira Livros e Autores
INSERT INTO LIVRO_AUTOR (LIVRO_CHAVE, LIVRO_AUTOR)
VALUES (1, 1), (2, 2), (3, 3), (4, 4), (5, 5), (6, 6), (7, 7), (8, 8), (9, 9), (10, 10);  

-- Avaliações dos Livros
-- O INT usado no AVA_ID_USUARIO é i ID do usuario da tabela usuario, o mesmo se aplica ao AVA_FK_LIVRO
INSERT INTO AVALIACAO (AVA_ID_USUARIO, AVA_FK_LIVRO, AVA_USUARIO, AVA_COMENTARIO)
VALUES (1, 1, 9.0,  'Um clássico da literatura brasileira.'), (2, 2, 7.8, 'Fascinante jornada pelo cosmos.'), (3, 3, 8, 'Uma história encantadora para todas as idades.'),
(2, 1, 7.0, 'Um clássico da literatura brasileira.'), (2, 2, 2.8, 'Fascinante jornada pelo cosmos.'), (2, 3, 6.3, 'Uma história encantadora para todas as idades.'),
(3, 1, 8.0, 'Um clássico da literatura brasileira.'), (3, 2, 1.8, 'Fascinante jornada pelo cosmos.'),(3, 3, 7.7, 'Uma história encantadora para todas as idades.');



/* 
estes so vão funcionar quando tiverem no miniumo 10 usuarios inseridos no banco
INSERT INTO AVALIACAO (AVA_ID_USUARIO, AVA_FK_LIVRO, AVA_USUARIO, AVA_COMENTARIO) VALUES 
(4, 4, 9.5, 'Exploração profunda da teoria da evolução.'), (4, 5, 7.2, 'Investigação fascinante sobre hábitos.'), (4, 6, 8.5, 'Realismo mágico em uma narrativa única.'),
(5, 1, 6.0, 'Alegoria política envolvente.'), (5, 2, 8.8, 'Mistérios e conspirações intrigantes.'), (5, 3, 9.2, 'Aventuras na Terra-média.'),
(6, 4, 9.0, 'Exploração profunda da teoria da evolução.'), (6, 5, 7.5, 'Investigação fascinante sobre hábitos.'), (6, 6, 8.0, 'Realismo mágico em uma narrativa única.'),
(7, 1, 7.5, 'Alegoria política envolvente.'), (7, 2, 6.8, 'Mistérios e conspirações intrigantes.'), (7, 3, 7.0, 'Aventuras na Terra-média.'),
(8, 4, 8.2, 'Exploração profunda da teoria da evolução.'), (8, 5, 6.5, 'Investigação fascinante sobre hábitos.'), (8, 6, 7.8, 'Realismo mágico em uma narrativa única.'),
(9, 7, 8.7, 'Alegoria política envolvente.'), (9, 8, 6.3, 'Mistérios e conspirações intrigantes.'), (9, 9, 7.5, 'Aventuras na Terra-média.'),
(10, 10, 9.0, 'História intrigante e cheia de reviravoltas.'), (10, 1, 7.8, 'Um clássico da literatura brasileira.'), (10, 2, 8.5, 'Fascinante jornada pelo cosmos.');
 */

-- Comando para listar o rank de livros
SELECT LIVRO.ID_LIVRO, LIVRO.LIV_NOME_LIVRO, ROUND(AVG(AVALIACAO.AVA_TOTAL), 1)AS MEDIA_NOTA
FROM LIVRO
JOIN AVALIACAO ON LIVRO.ID_LIVRO = AVALIACAO.AVA_FK_LIVRO
GROUP BY LIVRO.ID_LIVRO, LIVRO.LIV_NOME_LIVRO
ORDER BY MEDIA_NOTA DESC
LIMIT 5; 
-- comando pra imprimir os ultimos livros cadastrado
SELECT ID_LIVRO, LIV_NOME_LIVRO FROM LIVRO
ORDER BY ID_LIVRO DESC LIMIT 10;

/*INSERT DOS VINCULOS DE ENDEREÇO E TELEFONE */
INSERT INTO TELEFONE_USUARIO VALUES (3, 2), (1, 1), (2, 3);

/*Comando usado para trazer todas as informaoes de um usuario. para ver de outro usuario é só trocar o numero no fim 
A letra em frente de cada atributo é para o comando saber de qual tabela esta vindo a coluna
SELECT U.USE_NICK, U.USE_SENHA, U.USE_TYPE, U.USE_NOME, U.USE_SOBRENOME, U.USE_DATANASC, 
U.USE_EMAIL, U.USE_CRIA, U.USE_SEXO, U.USE_CPF, E.END_RUA, E.END_NUM, E.END_BAIRRO, 
E.END_CIDADE, E.END_UF, E.END_PAIS, E.END_CEP, T.TEL_TIPO, T.TEL_TELEFONE
FROM USUARIO U
LEFT JOIN ENDERECO_USUARIO EU ON U.USE_ID = EU.ENDERECO_USER
LEFT JOIN ENDERECO E ON EU.ENDERECO_CHAVE = E.END_ID
LEFT JOIN TELEFONE_USUARIO TU ON U.USE_ID = TU.TELEFONE_USER
LEFT JOIN TELEFONE T ON TU.TELEFONE_FONE = T.TEL_ID
WHERE U.USE_ID = 1;

/*ESTE COMANDO DA UM PRINT DAS INFORMAÇÕES LISTAS DE TODOS OS USUARIO

SELECT U.USE_ID, U.USE_NICK, U.USE_SENHA, U.USE_TYPE, U.USE_NOME, U.USE_SOBRENOME, U.USE_DATANASC, 
U.USE_EMAIL, U.USE_CRIA, U.USE_SEXO, U.USE_CPF, E.END_RUA, E.END_NUM, E.END_COMP, E.END_BAIRRO, 
E.END_CIDADE, E.END_UF, E.END_PAIS, E.END_CEP, T.TEL_TIPO, T.TEL_TELEFONE
FROM USUARIO U
LEFT JOIN ENDERECO_USUARIO EU ON U.USE_ID = EU.ENDERECO_USER
LEFT JOIN ENDERECO E ON EU.ENDERECO_CHAVE = E.END_ID
LEFT JOIN TELEFONE_USUARIO TU ON U.USE_ID = TU.TELEFONE_USER
LEFT JOIN TELEFONE T ON TU.TELEFONE_FONE = T.TEL_ID;

ESTE COMANDO DA UM PRINT EM TODAS AS INFORMAÇÕES DO USUARIO ESCOLHIDO. SE TIRAR O WHERE NO FINAL VAI DAR UM PRINT DE TODOS OS USUARIOS
SELECT * FROM USUARIO U
LEFT JOIN ENDERECO_USUARIO EU ON U.USE_ID = EU.ENDERECO_USER
LEFT JOIN ENDERECO E ON EU.ENDERECO_CHAVE = E.END_ID
LEFT JOIN TELEFONE_USUARIO TU ON U.USE_ID = TU.TELEFONE_USER
LEFT JOIN TELEFONE T ON TU.TELEFONE_FONE = T.TEL_ID
WHERE U.USE_ID = 1;
*/

SELECT * FROM USUARIO U
LEFT JOIN ENDERECO_USUARIO EU ON U.USE_ID = EU.ENDERECO_USER
LEFT JOIN ENDERECO E ON EU.ENDERECO_CHAVE = E.END_ID
LEFT JOIN TELEFONE_USUARIO TU ON U.USE_ID = TU.TELEFONE_USER
LEFT JOIN TELEFONE T ON TU.TELEFONE_FONE = T.TEL_ID
LEFT JOIN FAVORITO F ON U.USE_ID = F.FAV_USUARIO;

select *from favorito where fav_usuario = '6';


SELECT L.LIV_NOME_LIVRO, L.LIV_PAGINA, L.LIV_ANO, L.LIV_EDITORA, A.AVA_COMENTARIO 
FROM LIVRO L LEFT JOIN AVALIACAO A ON L.ID_LIVRO = A.AVA_FK_LIVRO 
LEFT JOIN CATEGORIA C ON L.LIV_CATEGORIA = C.CAT_ID WHERE LIV_NOME_LIVRO = 'O Segredo das Estrelas' ;
