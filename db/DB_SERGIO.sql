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

-- PAÍSES E NACIONALIDADES
CREATE TABLE NACIONALIDADE(
NAC_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
NAC_NOME VARCHAR(100)
);

-- INSERT DAS NACIONALIDADES
INSERT INTO NACIONALIDADE(NAC_NOME) VALUES ('Outra'), ('Afeganistão - Afegã'), ('Albânia - Albanesa'), ('Alemanha - Alemã'), ('Andorra - Andorrana'), ('Angola - Angolana'), ('Antígua e Barbuda - Antiguana'), ('Argentina - Argentina'), ('Armênia - Armênia'), ('Austrália - Australiana'), ('Áustria - Austríaca'), ('Azerbaijão - Azerbaijana'), ('Bahamas - Bahamense'), ('Barein - Bareinita'), ('Bangladesh - Bangladeshi'), ('Barbados - Barbadiana'), ('Belarus (Bielorrússia) - Bielo-russa'), ('Bélgica - Belga'), ('Belize - Belizenha'), ('Benin - Beninense'), ('Bolívia - Boliviana'), ('Bósnia e Herzegovina - Bósnia'), ('Botsuana - Botsuanesa'), ('Brasil - Brasileira'), ('Brunei - Bruneana'), ('Bulgária - Búlgara'), ('Burundi - Burundinesa'), ('Butão - Butanesa'), ('Cabo Verde - Cabo-verdiana'), ('Camarões - Camaronesa'), ('Camboja - Cambojana'), ('Canadá - Canadense'), ('Catar - Catari'), ('Cazaquistão - Cazaque'), ('Chade - Chadiana'), ('Chile - Chilena'), ('China - Chinesa'), ('Chipre - Cipriota'), ('Colômbia - Colombiana'), ('Comores - Comorense'), ('Congo - Congolesa'), ('Coreia do Norte - Norte-coreana'), ('Coreia do Sul - Sul-coreana'), ('Costa do Marfim - Marfinense'), ('Costa Rica - Costarriquenha'), ('Croácia - Croata'), ('Cuba - Cubana'), ('Dinamarca - Dinamarquesa'), ('Egito - Egípcia'), ('El Salvador - Salvadorenha'), ('Emirados Árabes Unidos - Emiratense'), ('Equador - Equatoriana'), ('Eritreia - Eritreia'), ('Eslováquia - Eslovaca'), ('Eslovênia - Eslovena'), ('Espanha - Espanhola'), ('Estados Unidos - Americana'), ('Estônia - Estoniana'), ('Etiópia - Etíope'), ('Fiji - Fijiana'), ('Filipinas - Filipina'), ('Finlândia - Finlandesa'), ('França - Francesa'), ('Gabão - Gabonesa'), ('Gâmbia - Gambiana'), ('Gana - Ganesa'), ('Geórgia - Georgiana'), ('Grécia - Grega'), ('Grenada - Granadina'), ('Guatemala - Guatemalteca'), ('Guiana - Guianesa'), ('Guiné - Guineense'), ('Guiné-Bissau - Guineense'), ('Haiti - Haitiana'), ('Holanda - Holandesa'), ('Honduras - Hondurenha'), ('Hungria - Húngara'), ('Iêmen - Iemenita'), ('Ilhas Marshall - Marshalesa'), ('Ilhas Salomão - Salomônica'), ('Índia - Indiana'), ('Indonésia - Indonésia'), ('Irã - Iraniana'), ('Iraque - Iraquiana'), ('Irlanda - Irlandesa'), ('Islândia - Islandesa'), ('Israel - Israelense'), ('Itália - Italiana'), ('Jamaica - Jamaicana'), ('Japão - Japonesa'), ('Jordânia - Jordana'), ('Kosovo - Kosovar'), ('Kuwait - Kuwaitiana'), ('Laos - Laosiana'), ('Lesoto - Lesota'), ('Letônia - Letã'), ('Líbano - Libanesa'), ('Libéria - Liberiana'), ('Líbia - Libyan'), ('Liechtenstein - Liechtensteina'), ('Lituânia - Lituana'), ('Luxemburgo - Luxemburguesa'), ('Macedônia - Macedônia'), ('Madagascar - Malgaxe'), ('Malásia - Malaia'), ('Malaui - Malauiana'), ('Maldivas - Maldiviana'), ('Mali - Malinesa'), ('Malta - Maltesa'), ('Marrocos - Marroquina'), ('Maurícia - Mauriciana'), ('Mauritânia - Mauritana'), ('México - Mexicana'), ('Micronésia - Micronésia'), ('Moldávia - Moldava'), ('Mônaco - Monegasca'), ('Mongólia - Mongol'), ('Montenegro - Montenegrina'), ('Moçambique - Moçambicana'), ('Namíbia - Namibiana'), ('Nauru - Nauruana'), ('Nepal - Nepalina'), ('Nicarágua - Nicaraguense'), ('Niger - Nigér'), ('Nigéria - Nigeriana'), ('Noruega - Norueguesa'), ('Nova Zelândia - Neozelandesa'), ('Omã - Omanense'), ('Países Baixos - Holandesa'), ('Palau - Palauana'), ('Palestina - Palestina'), ('Panamá - Panamenha'), ('Papua-Nova Guiné - Papua-Nova-Guineense'), ('Paquistão - Paquistanesa'), ('Paraguai - Paraguaia'), ('Peru - Peruana'), ('Polônia - Polonesa'), ('Portugal - Portuguesa'), ('Quênia - Queniana'), ('Quirguistão - Quirguiz'), ('Reino Unido - Britânica'), ('República Centro-Africana - Centro-africana'), ('República Checa - Tcheca'), ('República Dominicana - Dominicana'), ('Romênia - Romena'), ('Ruanda - Ruandesa'), ('Rússia - Russa'), ('Samoa - Samoana'), ('San Marino - Sanmarinense'), ('Santa Lúcia - Santa-lucense'), ('São Cristóvão e Nevis - São-cristovense'), ('São Tomé e Príncipe - Santomense'), ('São Vicente e Granadinas - São-vicentino'), ('Senegal - Senegalesa'), ('Sérvia - Serva'), ('Seychelles - Seychelense'), ('Serra Leoa - Serra-leonesa'), ('Singapura - Singapurense'), ('Síria - Síria'), ('Somália - Somali'), ('Sri Lanka - Sri-lankesa'), ('Suazilândia - Suazi'), ('Sudão - Sudanesa'), ('Sudão do Sul - Sul-sudanesa'), ('Suécia - Sueca'), ('Suíça - Suíça'), ('Suriname - Surinamesa'), ('Tailândia - Tailandesa'), ('Taiwan - Taiwanesa'), ('Tajiquistão - Tajique'), ('Tanzânia - Tanzaniana'), ('Togo - Togolesa'), ('Tonga - Tonganesa'), ('Trinidad e Tobago - Trinidadiana'), ('Tunísia - Tunisiana'), ('Turcomenistão - Turcomena'), ('Turquia - Turca'), ('Tuvalu - Tuvaluana'), ('Ucrânia - Ucraniana'), ('Uganda - Ugandense'), ('Uruguai - Uruguaia'), ('Uzbequistão - Uzbeque'), ('Vanuatu - Vanuatuense'), ('Vaticano - Vaticana'), ('Venezuela - Venezuelana'), ('Vietnã - Vietnamita'), ('Zâmbia - Zambiana'), ('Zimbábue - Zimbabuana');

SELECT NAC_NOME FROM NACIONALIDADE;
SELECT * FROM AUTOR;
