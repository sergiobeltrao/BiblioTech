USE BIBLIOTECH;

-- TABELA DE CONSULTA COM AS CATEGORIAS E SUB CATEGORIAS DISPONÍVEIS.
-- SERÃO USADAS SOMENTE PARA ALIMENTAR A TABELA LIVRO.

CREATE TABLE CATEGORIA(
CAT_ID INT PRIMARY KEY AUTO_INCREMENT,
CAT_NOME VARCHAR(50)
);

CREATE TABLE SUBCATEGORIA(
SCA_ID INT PRIMARY KEY AUTO_INCREMENT,
SCA_NOME VARCHAR(50),
SCA_CATEGORIA INT,
FOREIGN KEY (SCA_CATEGORIA) REFERENCES CATEGORIA (CAT_ID)
);

-- INSERTS DOS DADOS QUE ESTARÃO DISPONÍVEIS NO BIBLIOTECH (INSERT OBRIGATORIO)

INSERT INTO CATEGORIA(CAT_NOME) VALUES('Ficção'), ('Não Ficção'), ('Poesia'), ('Literatura Infantil e Juvenil'), ('História');
INSERT INTO CATEGORIA(CAT_NOME) VALUES('Ciências'), ('Religião e Espiritualidade'), ('Autoajuda e Desenvolvimento Pessoal'), ('Livros Técnicos'), ('Artes');
INSERT INTO CATEGORIA(CAT_NOME) VALUES('Saúde e Bem-Estar'), ('Culinária e Gastronomia'), ('Viagens'), ('Esportes e Lazer'), ('Hobbies e Passatempos');

INSERT INTO SUBCATEGORIA(SCA_NOME, SCA_CATEGORIA) VALUES('Romance', '1'), ('Mistério', '1'), ('Ficção Científica', '1'), ('Fantasia', '1'), ('Literatura Clássica', '1'), ('Contos', '1');
INSERT INTO SUBCATEGORIA(SCA_NOME, SCA_CATEGORIA) VALUES ('Biografia', '2'), ('Memórias', '2'), ('História', '2'), ('Autoajuda', '2'), ('Política', '2'), ('Ensaios', '2');
INSERT INTO SUBCATEGORIA(SCA_NOME, SCA_CATEGORIA) VALUES ('Poesia Clássica', '3'), ('Poesia Contemporânea', '3'), ('Haicai', '3');
INSERT INTO SUBCATEGORIA(SCA_NOME, SCA_CATEGORIA) VALUES ('Livros Infantis', '4'), ('Livros para Adolescentes', '4'), ('Contos de Fadas', '4');
INSERT INTO SUBCATEGORIA(SCA_NOME, SCA_CATEGORIA) VALUES ('História Mundial', '5'), ('História Regional', '5'), ('História da Arte', '5'), ('História Militar', '5');
INSERT INTO SUBCATEGORIA(SCA_NOME, SCA_CATEGORIA) VALUES ('Biologia', '6'), ('Química', '6'), ('Física', '6'), ('Astronomia', '6'), ('Geologia', '6'), ('Matemática', '6');
INSERT INTO SUBCATEGORIA(SCA_NOME, SCA_CATEGORIA) VALUES ('Cristianismo', '7'), ('Islamismo', '7'), ('Judaísmo', '7'), ('Budismo', '7'), ('Hinduísmo', '7'), ('Filosofia', '7');
INSERT INTO SUBCATEGORIA(SCA_NOME, SCA_CATEGORIA) VALUES ('Motivação', '8'), ('Autoaperfeiçoamento', '8'), ('Gestão do Tempo', '8'), ('Psicologia Positiva', '8');
INSERT INTO SUBCATEGORIA(SCA_NOME, SCA_CATEGORIA) VALUES ('Tecnologia', '9'), ('Programação', '9'), ('Engenharia', '9'), ('Medicina', '9'), ('Direito', '9'), ('Economia', '9');
INSERT INTO SUBCATEGORIA(SCA_NOME, SCA_CATEGORIA) VALUES ('Arte Visual', '10'), ('Música', '10'), ('Teatro', '10'), ('Dança', '10'), ('Arquitetura', '10');
INSERT INTO SUBCATEGORIA(SCA_NOME, SCA_CATEGORIA) VALUES ('Nutrição', '11'), ('Fitness', '11'), ('Saúde Mental', '11'), ('Medicina Alternativa', '11');
INSERT INTO SUBCATEGORIA(SCA_NOME, SCA_CATEGORIA) VALUES ('Receitas', '12'), ('Gastronomia Internacional', '12'), ('Culinária Saudável', '12');
INSERT INTO SUBCATEGORIA(SCA_NOME, SCA_CATEGORIA) VALUES ('Guias de Viagem', '13'), ('Memórias de Viagem', '13'), ('Aventuras de Viagem', '13');
INSERT INTO SUBCATEGORIA(SCA_NOME, SCA_CATEGORIA) VALUES ('Futebol', '14'), ('Basquete', '14'), ('Esportes de Aventura', '14'), ('Jogos de Mesa', '14');
INSERT INTO SUBCATEGORIA(SCA_NOME, SCA_CATEGORIA) VALUES ('Artesanato', '15'), ('Fotografia', '15'), ('Quebra-cabeças', '15'), ('Colecionismo', '15');

-- SELECT DAS TABELAS RELEVANTES
SELECT * FROM CATEGORIA;
SELECT * FROM SUBCATEGORIA;
SELECT * FROM LIVRO;