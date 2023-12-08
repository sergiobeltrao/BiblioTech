CREATE DATABASE BIBLIOTECH;

USE BIBLIOTECH;

CREATE TABLE USUARIO (
USE_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
USE_NICK VARCHAR(30) NOT NULL UNIQUE,
USE_SENHA VARCHAR(100) NOT NULL,
USE_TYPE ENUM('ADMIN', 'CLIENTE') NOT NULL,
USE_NOME VARCHAR(50) NOT NULL,
USE_SOBRENOME VARCHAR(50),
USE_DATANASC DATE,
USE_EMAIL VARCHAR(100) NOT NULL,
USE_CRIA DATETIME,
USE_SEXO ENUM ('MASC', 'FEM', 'OUTRO'),
USE_CPF VARCHAR (15) NOT NULL UNIQUE
);

/* Usuário: admin senha: admin*/
INSERT INTO USUARIO VALUES
( NULL, 'admin', '8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918', 'ADMIN', 'Bruno', 'Fernades', '1990-02-28', 'bruno@email.com',  NOW(), 'MASC', '11111111111');

CREATE TABLE TELEFONE (
TEL_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
TEL_TIPO ENUM ('RESIDENCIAL', 'COMERCIAL', 'CELULAR')NOT NULL,
TEL_TELEFONE VARCHAR (15) NOT NULL	
);

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

CREATE TABLE LIVRO ( 
ID_LIVRO INT PRIMARY KEY AUTO_INCREMENT,
LIV_NOME_LIVRO VARCHAR (100) NOT NULL,
LIV_ISBN VARCHAR (100)NOT NULL UNIQUE,
LIV_ANO INT NOT NULL, 
LIV_PAGINA INT NOT NULL,
LIV_CATEGORIA VARCHAR (50)NOT NULL,
LIV_SUBCATEGORIA VARCHAR (50) NOT NULL,
LIV_IDIOMA VARCHAR (50) NOT NULL,
LIV_EDITORA VARCHAR (50),
LIV_SINOPSE TEXT,
LIV_IMAGEM MEDIUMBLOB
);

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

CREATE TABLE AUTOR(
ID_AUTOR INT PRIMARY KEY AUTO_INCREMENT,
AUT_NOME_AUTOR VARCHAR (100)NOT NULL,
AUT_NACIONALIDADE VARCHAR (50) ,
AUT_SEXO ENUM ('MASC', 'FEM', 'OUTRO')
);

CREATE TABLE AVALIACAO (
AVA_ID_USUARIO INT NOT NULL, FOREIGN KEY (AVA_ID_USUARIO) REFERENCES USUARIO (USE_ID),
AVA_FK_LIVRO INT NOT NULL, FOREIGN KEY (AVA_FK_LIVRO) REFERENCES LIVRO (ID_LIVRO),
AVA_USUARIO NUMERIC(6,2) NOT NULL,
AVA_COMENTARIO TEXT NOT NULL,
AVA_DATA_AVALIACAO TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
 
CREATE TABLE FAVORITO ( 
FAV_ID_USUARIO INT NOT NULL, FOREIGN KEY (FAV_ID_USUARIO) REFERENCES USUARIO(USE_ID),
FAV_CATEGORIA1 VARCHAR (50),
FAV_SUB1 VARCHAR (50),
FAV_CATEGORIA2 VARCHAR (50),
FAV_SUB2 VARCHAR (50)
);

/* APARTIR DESTA LINHA ESTAO AS TABELAS COM AS CHAVES ESTRANGEIRAS */
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

CREATE TABLE TELEFONE_USUARIO (
TELEFONE_USER INT NOT NULL,FOREIGN KEY (TELEFONE_USER) REFERENCES USUARIO(USE_ID) ON DELETE CASCADE,
TELEFONE_FONE INT NOT NULL,FOREIGN KEY (TELEFONE_FONE) REFERENCES TELEFONE(TEL_ID),
PRIMARY KEY (TELEFONE_USER, TELEFONE_FONE)
);

CREATE TABLE ENDERECO_USUARIO ( 
ENDERECO_USER INT NOT NULL, FOREIGN KEY (ENDERECO_USER) REFERENCES USUARIO (USE_ID),
ENDERECO_CHAVE INT NOT NULL, FOREIGN KEY (ENDERECO_CHAVE) REFERENCES ENDERECO (END_ID),
PRIMARY KEY (ENDERECO_USER, ENDERECO_CHAVE)
);

/* INSERT DOS DADOS PADRÃO PARA CATEGORIA E SUBCATEGORIA */
INSERT INTO CATEGORIA(CAT_NOME) VALUES('Ficção'), ('Não Ficção'), ('Poesia'), ('Literatura Infantil e Juvenil'), ('História'),
('Ciências'), ('Religião e Espiritualidade'), ('Autoajuda e Desenvolvimento Pessoal'), ('Livros Técnicos'), ('Artes'),
('Saúde e Bem-Estar'), ('Culinária e Gastronomia'), ('Viagens'), ('Esportes e Lazer'), ('Hobbies e Passatempos');

INSERT INTO SUBCATEGORIA(SCA_NOME, SCA_CATEGORIA) VALUES('Romance', '1'), ('Mistério', '1'), ('Ficção Científica', '1'), ('Fantasia', '1'), ('Literatura Clássica', '1'), 
('Contos', '1'), ('Biografia', '2'), ('Memórias', '2'), ('História', '2'), ('Autoajuda', '2'), ('Política', '2'), ('Ensaios', '2'), ('Poesia Clássica', '3'), 
('Poesia Contemporânea', '3'), ('Haicai', '3'), ('Livros Infantis', '4'), ('Livros para Adolescentes', '4'), ('Contos de Fadas', '4'), ('História Mundial', '5'), 
('História Regional', '5'), ('História da Arte', '5'), ('História Militar', '5'), ('Biologia', '6'), ('Química', '6'), ('Física', '6'), ('Astronomia', '6'), 
('Geologia', '6'), ('Matemática', '6'), ('Cristianismo', '7'), ('Islamismo', '7'), ('Judaísmo', '7'), ('Budismo', '7'), ('Hinduísmo', '7'), ('Filosofia', '7'), 
('Motivação', '8'), ('Autoaperfeiçoamento', '8'), ('Gestão do Tempo', '8'), ('Psicologia Positiva', '8'), ('Tecnologia', '9'), ('Programação', '9'), ('Engenharia', '9'), 
('Medicina', '9'), ('Direito', '9'), ('Economia', '9'), ('Arte Visual', '10'), ('Música', '10'), ('Teatro', '10'), ('Dança', '10'), ('Arquitetura', '10'), 
('Nutrição', '11'), ('Fitness', '11'), ('Saúde Mental', '11'), ('Medicina Alternativa', '11'), ('Receitas', '12'), ('Gastronomia Internacional', '12'), 
('Culinária Saudável', '12'), ('Guias de Viagem', '13'), ('Memórias de Viagem', '13'), ('Aventuras de Viagem', '13'), ('Futebol', '14'), ('Basquete', '14'), 
('Esportes de Aventura', '14'), ('Jogos de Mesa', '14'), ('Artesanato', '15'), ('Fotografia', '15'), ('Quebra-cabeças', '15'), ('Colecionismo', '15');

INSERT INTO NACIONALIDADE(NAC_NOME) VALUES ('Afeganistão - Afegã'), ('Albânia - Albanesa'), ('Alemanha - Alemã'), ('Andorra - Andorrana'), ('Angola - Angolana'), ('Antígua e Barbuda - Antiguana'), ('Argentina - Argentina'), ('Armênia - Armênia'),
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

INSERT INTO IDIOMA(IDI_NOME) VALUES ('Akan - Gana'), ('Alemão - Alemanha'), ('Alemão - Áustria'), ('Alemão - Bélgica'), ('Alemão - Suíça'), ('Amharic - Etiópia'), ('Árabe - Arábia Saudita'), ('Árabe - Egito'), ('Árabe - Líbano'), ('Árabe - Síria'),
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


