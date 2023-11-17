CREATE DATABASE BIBLIOTECH;

USE BIBLIOTECH;

CREATE TABLE USUARIO (
  USE_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  USE_NICK VARCHAR(30) NOT NULL UNIQUE,  /* USAR NO LOGIN */
  USE_SENHA VARCHAR(100) NOT NULL,   /* USAR NO LOGIN */
  USE_TYPE ENUM('ADMIN', 'CLIENTE') NOT NULL,   /* USAR NO LOGIN */
  USE_NOME VARCHAR(50) NOT NULL,
  USE_SOBRENOME VARCHAR(50),
  USE_DATANASC DATE,
  USE_EMAIL VARCHAR(100) NOT NULL,
  USE_CRIA DATETIME,
  USE_SEXO ENUM ('MASC', 'FEM', 'OUTRO'),
  USE_CPF VARCHAR (15) NOT NULL UNIQUE
);

INSERT INTO USUARIO VALUES
  ( NULL, 'admin', '8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918', 'ADMIN', 'Bruno', 'Fernades', '1990-02-28', 'bruno@email.com',  NOW(), 'MASC', '11111111111'),
  ( NULL, 'sergio', '36033BABFB48EC64E197C97FB40D65E6C79F81E04C61AECCEF3009E01645AB8D', 'CLIENTE', 'Sérgio', 'Beltrão', '1990-02-28', 'sergio@email.com',  NOW(), 'MASC', '22222222222'),
  ( NULL, 'john', '96D9632F363564CC3032521409CF22A852F2032EEC099ED5967C0D000CEC607A', 'CLIENTE', 'Jonatas', 'Sousa', '1990-02-28', 'john@email.com',  NOW(), 'MASC','33333333333');
  
  CREATE TABLE TELEFONE (
	TEL_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	TEL_TIPO ENUM ('RESIDENCIAL', 'COMERCIAL', 'CELULAR')NOT NULL,
	TEL_TELEFONE VARCHAR (15) NOT NULL	
);
 
 INSERT INTO TELEFONE VALUES (NULL, 'CELULAR', '11 994545058'), 
 (NULL, 'CELULAR', '11 975630714'), (NULL, 'CELULAR', '11 91340-9833');
 

  CREATE TABLE ENDERECO (
  END_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  END_RUA VARCHAR(150),
  END_NUM INT,
  END_COMP VARCHAR(50),
  END_BAIRRO VARCHAR(100),
  END_CIDADE VARCHAR(100),
  END_UF VARCHAR (2),
  END_PAIS VARCHAR(50),
  END_CEP VARCHAR(10)
);

INSERT INTO ENDERECO VALUES (NULL, 'Dolores', 13, 'APTO', 'Mooca', 'Sao Paulo', 'SP', 'BRASIL', '987321654'),
(NULL, 'Avenida Atlântica', '1702', NULL, 'Copacabana', ' Rio de Janeiro', 'RJ', 'BRASIL', '22021001'),
(NULL, 'Rua22', '122', NULL, 'St. Oeste', 'Goiânia', 'GO', 'BRASIL', '74120140');
  
CREATE TABLE FUNCIONARIO (
  FUN_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  FUN_ENTRADA DATE NOT NULL,
  FUN_SAIDA DATE,
  FUN_SALARIO DECIMAL(10, 2) NOT NULL
);

INSERT INTO FUNCIONARIO  VALUES
  (NULL, '2022-01-15', NULL, 8000.00),
  (NULL, '2021-03-10', NULL, 6000.00);

CREATE TABLE LIVRO ( 
	ID_LIVRO INT PRIMARY KEY AUTO_INCREMENT,
	LIV_NOME_LIVRO VARCHAR (100) NOT NULL,
	LIV_ISBN VARCHAR (100)NOT NULL,
	LIV_ANO INT NOT NULL, 
	LIV_PAGINA INT NOT NULL,
	LIV_CATEGORIA VARCHAR (50)NOT NULL,
	LIV_SUBCATEGORIA VARCHAR (50) NOT NULL,
    LIV_IDIOMA VARCHAR (50) NOT NULL,
    LIV_EDITORA VARCHAR (50),
    LIV_SINOPSE TEXT
);

INSERT INTO LIVRO VALUES(
	NULL, 'O Segredo das Estrelas', '978-1234567890', 1980, 320, '1 - Ficção', '40 - Programação', 'Portugues - Brasil', 'Atlas',NULL),
    (NULL, 'O Alquimista', '978-8584390670', 1988, 208, '1 - Ficção', '4 - Fantasia', 'Português - Brasil', 'Osires', NULL);


CREATE TABLE AUTOR(
	ID_AUTOR INT PRIMARY KEY AUTO_INCREMENT,
	AUT_NOME_AUTOR VARCHAR (100)NOT NULL,
	AUT_DATA_NASC DATE,
	AUT_NACIONALIDADE VARCHAR (50) ,
	AUT_BIBLIOGRAFIA TEXT,
	AUT_SEXO ENUM ('MASC', 'FEM', 'OUTRO')
);
    
INSERT INTO AUTOR ( AUT_NOME_AUTOR, AUT_DATA_NASC, AUT_NACIONALIDADE, AUT_SEXO) 
 VALUES ('Laura Bens', '1997-01-27', 'Brazil', 'FEM' );


CREATE TABLE AVALIACAO (
    ID_AVALIACAO INT PRIMARY KEY AUTO_INCREMENT,
    AVA_FK_LIVRO INT NOT NULL, FOREIGN KEY (AVA_FK_LIVRO) REFERENCES LIVRO (ID_LIVRO),
    AVA_USUARIO INT,
    AVA_TOTAL DECIMAL(6, 2), /* criar codigo para somar as notas dos usuarios */
    AVA_COMENTARIO TEXT,
    AVA_DATA_AVALIACAO TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    AVA_FK_USUARIO INT, FOREIGN KEY (AVA_FK_USUARIO) REFERENCES USUARIO (USE_ID)
);

INSERT INTO AVALIACAO (AVA_COMENTARIO, AVA_FK_LIVRO) VALUES ('Este comentario é para testar a tela de avaliação de livros', 1);

CREATE TABLE FAVORITO ( 
	ID INT PRIMARY KEY AUTO_INCREMENT,
    FAV_CATEGORIA1 VARCHAR (50),
    FAV_SUB1 VARCHAR (50),
    FAV_CATEGORIA2 VARCHAR (50),
    FAV_SUB2 VARCHAR (50),
    FAV_USUARIO INT NOT NULL, FOREIGN KEY (FAV_USUARIO) REFERENCES USUARIO(USE_ID)
);
SELECT * FROM usuario;
/* APARTIR DESTA LINHA ESTAO AS TABELAS COM AS CHAVES ESTRANGEIRAS*/

/*TABELA DE CHAVES ESTRANGEIRAS DE LIVRO */
CREATE TABLE LIVRO_USUARIO (
	LIVRO_CHAVE INT NOT NULL, FOREIGN KEY (LIVRO_CHAVE) REFERENCES LIVRO (ID_LIVRO),
	LIVRO_USER INT NOT NULL, FOREIGN KEY (LIVRO_USER) REFERENCES USUARIO (USE_ID),
	PRIMARY KEY (LIVRO_CHAVE, LIVRO_USER)
);

CREATE TABLE LIVRO_AUTOR ( 
    LIVRO_CHAVE INT NOT NULL, FOREIGN KEY (LIVRO_CHAVE) REFERENCES LIVRO (ID_LIVRO),
    LIVRO_AUTOR INT NOT NULL, FOREIGN KEY (LIVRO_AUTOR) REFERENCES AUTOR (ID_AUTOR),
    PRIMARY KEY (LIVRO_CHAVE, LIVRO_AUTOR)
);

/*TABELA DE CHAVES ESTRANGEIRAS TELEFONE */
CREATE TABLE TELEFONE_USUARIO (
    TELEFONE_USER INT NOT NULL,FOREIGN KEY (TELEFONE_USER) REFERENCES USUARIO(USE_ID) ON DELETE CASCADE,
    TELEFONE_FONE INT NOT NULL,FOREIGN KEY (TELEFONE_FONE) REFERENCES TELEFONE(TEL_ID),
    PRIMARY KEY (TELEFONE_USER, TELEFONE_FONE)
);
    
CREATE TABLE TELEFONE_AUTOR ( 
    TELEFONE_FONE INT NOT NULL, FOREIGN KEY (TELEFONE_FONE) REFERENCES TELEFONE(TEL_ID),
    TELEFONE_AUTOR INT NOT NULL, FOREIGN KEY (TELEFONE_AUTOR) REFERENCES AUTOR (ID_AUTOR),
    PRIMARY KEY (TELEFONE_FONE, TELEFONE_AUTOR)
);


CREATE TABLE ENDERECO_USUARIO ( 
    ENDERECO_USER INT NOT NULL, FOREIGN KEY (ENDERECO_USER) REFERENCES USUARIO (USE_ID),
    ENDERECO_CHAVE INT NOT NULL, FOREIGN KEY (ENDERECO_CHAVE) REFERENCES ENDERECO (END_ID),
	PRIMARY KEY (ENDERECO_USER, ENDERECO_CHAVE)
);

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

SELECT * FROM FAVORITO;

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

CREATE TABLE NACIONALIDADE(
NAC_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
NAC_NOME VARCHAR(100)
);

CREATE TABLE IDIOMA(
IDI_ID INT PRIMARY KEY AUTO_INCREMENT,
IDI_NOME VARCHAR(100)
);

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

INSERT INTO NACIONALIDADE(NAC_NOME) VALUES ('Outra'), ('Afeganistão - Afegã'), ('Albânia - Albanesa'), ('Alemanha - Alemã'), ('Andorra - Andorrana'), ('Angola - Angolana'), ('Antígua e Barbuda - Antiguana'), ('Argentina - Argentina'), ('Armênia - Armênia'),
('Austrália - Australiana'), ('Áustria - Austríaca'), ('Azerbaijão - Azerbaijana'), ('Bahamas - Bahamense'), ('Barein - Bareinita'), ('Bangladesh - Bangladeshi'), ('Barbados - Barbadiana'), ('Belarus (Bielorrússia) - Bielo-russa'), ('Bélgica - Belga'),
('Belize - Belizenha'), ('Benin - Beninense'), ('Bolívia - Boliviana'), ('Bósnia e Herzegovina - Bósnia'), ('Botsuana - Botsuanesa'), ('Brasil - Brasileira'), ('Brunei - Bruneana'), ('Bulgária - Búlgara'), ('Burundi - Burundinesa'), ('Butão - Butanesa'),
('Cabo Verde - Cabo-verdiana'), ('Camarões - Camaronesa'), ('Camboja - Cambojana'), ('Canadá - Canadense'), ('Catar - Catari'), ('Cazaquistão - Cazaque'), ('Chade - Chadiana'), ('Chile - Chilena'), ('China - Chinesa'), ('Chipre - Cipriota'),
('Colômbia - Colombiana'), ('Comores - Comorense'), ('Congo - Congolesa'), ('Coreia do Norte - Norte-coreana'), ('Coreia do Sul - Sul-coreana'), ('Costa do Marfim - Marfinense'), ('Costa Rica - Costarriquenha'), ('Croácia - Croata'), ('Cuba - Cubana'),
('Dinamarca - Dinamarquesa'), ('Egito - Egípcia'), ('El Salvador - Salvadorenha'), ('Emirados Árabes Unidos - Emiratense'), ('Equador - Equatoriana'), ('Eritreia - Eritreia'), ('Eslováquia - Eslovaca'), ('Eslovênia - Eslovena'), ('Espanha - Espanhola'),
('Estados Unidos - Americana'), ('Estônia - Estoniana'), ('Etiópia - Etíope'), ('Fiji - Fijiana'), ('Filipinas - Filipina'), ('Finlândia - Finlandesa'), ('França - Francesa'), ('Gabão - Gabonesa'), ('Gâmbia - Gambiana'), ('Gana - Ganesa'),
('Geórgia - Georgiana'), ('Grécia - Grega'), ('Grenada - Granadina'), ('Guatemala - Guatemalteca'), ('Guiana - Guianesa'), ('Guiné - Guineense'), ('Guiné-Bissau - Guineense'), ('Haiti - Haitiana'), ('Holanda - Holandesa'), ('Honduras - Hondurenha'),
('Hungria - Húngara'), ('Iêmen - Iemenita'), ('Ilhas Marshall - Marshalesa'), ('Ilhas Salomão - Salomônica'), ('Índia - Indiana'), ('Indonésia - Indonésia'), ('Irã - Iraniana'), ('Iraque - Iraquiana'), ('Irlanda - Irlandesa'), ('Islândia - Islandesa'),
('Israel - Israelense'), ('Itália - Italiana'), ('Jamaica - Jamaicana'), ('Japão - Japonesa'), ('Jordânia - Jordana'), ('Kosovo - Kosovar'), ('Kuwait - Kuwaitiana'), ('Laos - Laosiana'), ('Lesoto - Lesota'), ('Letônia - Letã'), ('Líbano - Libanesa'),
('Libéria - Liberiana'), ('Líbia - Libyan'), ('Liechtenstein - Liechtensteina'), ('Lituânia - Lituana'), ('Luxemburgo - Luxemburguesa'), ('Macedônia - Macedônia'), ('Madagascar - Malgaxe'), ('Malásia - Malaia'), ('Malaui - Malauiana'),
('Maldivas - Maldiviana'), ('Mali - Malinesa'), ('Malta - Maltesa'), ('Marrocos - Marroquina'), ('Maurícia - Mauriciana'), ('Mauritânia - Mauritana'), ('México - Mexicana'), ('Micronésia - Micronésia'), ('Moldávia - Moldava'), ('Mônaco - Monegasca'),
('Mongólia - Mongol'), ('Montenegro - Montenegrina'), ('Moçambique - Moçambicana'), ('Namíbia - Namibiana'), ('Nauru - Nauruana'), ('Nepal - Nepalina'), ('Nicarágua - Nicaraguense'), ('Niger - Nigér'), ('Nigéria - Nigeriana'), ('Noruega - Norueguesa'),
('Nova Zelândia - Neozelandesa'), ('Omã - Omanense'), ('Países Baixos - Holandesa'), ('Palau - Palauana'), ('Palestina - Palestina'), ('Panamá - Panamenha'), ('Papua-Nova Guiné - Papua-Nova-Guineense'), ('Paquistão - Paquistanesa'),
('Paraguai - Paraguaia'), ('Peru - Peruana'), ('Polônia - Polonesa'), ('Portugal - Portuguesa'), ('Quênia - Queniana'), ('Quirguistão - Quirguiz'), ('Reino Unido - Britânica'), ('República Centro-Africana - Centro-africana'), ('República Checa - Tcheca'),
('República Dominicana - Dominicana'), ('Romênia - Romena'), ('Ruanda - Ruandesa'), ('Rússia - Russa'), ('Samoa - Samoana'), ('San Marino - Sanmarinense'), ('Santa Lúcia - Santa-lucense'), ('São Cristóvão e Nevis - São-cristovense'),
('São Tomé e Príncipe - Santomense'), ('São Vicente e Granadinas - São-vicentino'), ('Senegal - Senegalesa'), ('Sérvia - Serva'), ('Seychelles - Seychelense'), ('Serra Leoa - Serra-leonesa'), ('Singapura - Singapurense'), ('Síria - Síria'),
('Somália - Somali'), ('Sri Lanka - Sri-lankesa'), ('Suazilândia - Suazi'), ('Sudão - Sudanesa'), ('Sudão do Sul - Sul-sudanesa'), ('Suécia - Sueca'), ('Suíça - Suíça'), ('Suriname - Surinamesa'), ('Tailândia - Tailandesa'), ('Taiwan - Taiwanesa'),
('Tajiquistão - Tajique'), ('Tanzânia - Tanzaniana'), ('Togo - Togolesa'), ('Tonga - Tonganesa'), ('Trinidad e Tobago - Trinidadiana'), ('Tunísia - Tunisiana'), ('Turcomenistão - Turcomena'), ('Turquia - Turca'), ('Tuvalu - Tuvaluana'), ('Ucrânia - Ucraniana'),
('Uganda - Ugandense'), ('Uruguai - Uruguaia'), ('Uzbequistão - Uzbeque'), ('Vanuatu - Vanuatuense'), ('Vaticano - Vaticana'), ('Venezuela - Venezuelana'), ('Vietnã - Vietnamita'), ('Zâmbia - Zambiana'), ('Zimbábue - Zimbabuana');

INSERT INTO IDIOMA(IDI_NOME) VALUES ('Outro'), ('Akan - Gana'), ('Alemão - Alemanha'), ('Alemão - Áustria'), ('Alemão - Bélgica'), ('Alemão - Suíça'), ('Amharic - Etiópia'), ('Árabe - Arábia Saudita'), ('Árabe - Egito'), ('Árabe - Líbano'), ('Árabe - Síria'),
('Armenian - Armênia'), ('Armenian - Geórgia'), ('Assamese - Índia (Assam)'), ('Awadhi - Índia (Uttar Pradesh)'), ('Azerbaijani - Azerbaijão'), ('Azerbaijani - Irã'), ('Bengali - Bangladesh'), ('Bengali - Índia (Bengala Ocidental)'),
('Bhojpuri - Índia (Bihar, Uttar Pradesh)'), ('Burmês - Mianmar'), ('Cebuano - Filipinas'), ('Chhattisgarhi - Índia (Chhattisgarh)'), ('Chinês (Mandarim) - China'), ('Chinês (Mandarim) - Cingapura'), ('Chinês (Mandarim) - Malásia'), ('Chinês (Mandarim) - Taiwan'),
('Coreano - Coreia do Norte'), ('Coreano - Coreia do Sul'), ('Dutch - Bélgica'), ('Dutch - Holanda'), ('Espanhol - Argentina'), ('Espanhol - Colômbia'), ('Espanhol - Espanha'), ('Espanhol - México'), ('Francês - Bélgica'), ('Francês - Canadá'), ('Francês - França'),
('Francês - Suíça'), ('Greek - Albânia'), ('Greek - Chipre'), ('Greek - Grécia'), ('Gujarati - Índia (Gujarat)'), ('Hakka - China (várias províncias)'), ('Haryanvi - Índia (Haryana)'), ('Hindi - Fiji'), ('Hindi - Índia'), ('Hindi - Nepal'),
('Hindi - Trinidad e Tobago'), ('Hungarian - Hungria'), ('Igbo - Nigéria'), ('Inglês - Austrália'), ('Inglês - Canadá'), ('Inglês - Estados Unidos'), ('Inglês - Reino Unido'), ('Italiano - Itália'), ('Italiano - San Marino'), ('Italiano - Suíça'),
('Japonês - Japão'), ('Javanês - Indonésia (Java)'), ('Kannada - Índia (Karnataka)'), ('Kashmiri - Índia (Jammu e Caxemira)'), ('Kurdish - Irã'), ('Kurdish - Iraque'), ('Kurdish - Síria'), ('Kurdish - Turquia'), ('Laotian - Laos'), ('Magahi - Índia (Bihar)'),
('Maithili - Índia (Bihar)'), ('Malaio - Brunei'), ('Malaio - Indonésia'), ('Malaio - Malásia'), ('Malayalam - Índia (Kerala)'), ('Marathi - Índia (Maharashtra)'), ('Marwari - Índia (Rajastão)'), ('Min Nan (Hokkien) - China (Fujian)'), ('Min Nan (Hokkien) - Taiwan'),
('Nepali - Butão'), ('Nepali - Índia (Sikkim)'), ('Nepali - Nepal'), ('Odia - Índia (Odisha)'), ('Oromo - Etiópia'), ('Oromo - Quênia'), ('Pashto - Afeganistão'), ('Pashto - Paquistão'), ('Persa (Farsi) - Afeganistão'), ('Persa (Farsi) - Irã'),
('Persa (Farsi) - Tadjiquistão'), ('Polish - Bielorrússia'), ('Polish - Polônia'), ('Polish - Ucrânia'), ('Português - Angola'), ('Português - Brasil'), ('Português - Moçambique'), ('Português - Portugal'), ('Punjabi - Índia (Punjab)'),
('Punjabi - Paquistão (Punjab)'), ('Romanian - Moldávia'), ('Romanian - Romênia'), ('Russo - Bielorrússia'), ('Russo - Cazaquistão'), ('Russo - Rússia'), ('Russo - Ucrânia'), ('Saraiki - Paquistão (Punjab)'), ('Serbo-Croatian - Bósnia e Herzegovina'),
('Serbo-Croatian - Croácia'), ('Serbo-Croatian - Sérvia'), ('Sinhala - Sri Lanka'), ('Somali - Djibouti'), ('Somali - Etiópia'), ('Somali - Quênia'), ('Somali - Somália'), ('Sundanese - Indonésia (Java Ocidental)'), ('Tamil - Índia (Tâmil Nadu)'),
('Tamil - Sri Lanka'), ('Telugu - Índia (Andhra Pradesh)'), ('Turco - Chipre'), ('Turco - Kosovo'), ('Turco - Macedônia'), ('Turco - Turquia'), ('Ukrainian - Ucrânia'), ('Urdu - Índia (Jammu e Caxemira)'), ('Urdu - Paquistão'), ('Uzbek - Afeganistão'),
('Uzbek - Cazaquistão'), ('Uzbek - Tadjiquistão'), ('Uzbek - Uzbequistão'), ('Vietnamita - Vietnã'), ('Wu (Shanghainese) - China (Xangai)'), ('Yoruba - Nigéria');

SELECT L.LIV_NOME_LIVRO, L.LIV_PAGINA, L.LIV_ANO, L.LIV_EDITORA, A.AVA_COMENTARIO 
FROM LIVRO L LEFT JOIN AVALIACAO A ON L.ID_LIVRO = A.AVA_FK_LIVRO 
LEFT JOIN CATEGORIA C ON L.LIV_CATEGORIA = C.CAT_ID WHERE LIV_NOME_LIVRO = 'O Segredo das Estrelas' ;




