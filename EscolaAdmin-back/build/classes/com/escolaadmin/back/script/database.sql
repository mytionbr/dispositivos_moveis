CREATE TABLE IF NOT EXISTS aluno(
	aluno_id serial PRIMARY KEY,
        nome VARCHAR (255) NOT NULL,
	email VARCHAR (255) NOT NULL,
	idade INT NOT NULL
);

CREATE TABLE IF NOT EXISTS professor(
	professor_id serial PRIMARY KEY,
	nome VARCHAR (255) NOT NULL,
        email VARCHAR (255) NOT NULL,
	idade INT NOT NULL,
	senha VARCHAR (255) NOT NULL
);

CREATE TABLE IF NOT EXISTS curso(
	curso_id serial PRIMARY KEY,
	nome VARCHAR (255) NOT NULL,
	descricao TEXT NOT NULL,
	professor_id INT,
	FOREIGN KEY (professor_id)
		REFERENCES professor
);

CREATE TABLE IF NOT EXISTS aula(
	aula_id serial PRIMARY KEY,
	nome VARCHAR (255) NOT NULL,
	descricao VARCHAR (255) NOT NULL,
	curso_id INT NOT NULL,
	FOREIGN KEY (curso_id)
		REFERENCES curso
);



CREATE TABLE IF NOT EXISTS curso_aluno(
	curso_id INT NOT NULL,
	aluno_id INT NOT NULL,
	FOREIGN KEY (curso_id)
		REFERENCES curso,
	FOREIGN KEY (aluno_id)
		REFERENCES aluno
);

CREATE TABLE IF NOT EXISTS nota(
	nota_id serial PRIMARY KEY,
	valor INT NOT NULL,
	aprovado BOOLEAN NOT NULL,
	curso_id INT NOT NULL,
	aluno_id INT NOT NULL,
	FOREIGN KEY (curso_id)
		REFERENCES curso,
	FOREIGN KEY (aluno_id)
		REFERENCES aluno
);

INSERT INTO aluno (aluno_id,nome,email,idade) 
	VALUES 	(1,'Gustavo ferreira','gustavo@gmail.com', 18),
			(2,'Fernando ferreira','fernando@gmail.com', 18),
			(3,'Bruno','bruno@gmail.com', 20);

INSERT INTO professor (professor_id,nome,email,idade,senha) 
	VALUES 	(1,'Gustavo ferreira','gustavo@gmail.com', 69,'12345'),
			(2,'Nogeira','nogeira@gmail.com', 65,'12345'),
			(3,'Bruna','bruna@gmail.com', 30,'123456');

INSERT INTO curso (curso_id,nome,descricao,professor_id) 
	VALUES 	(1,'Python', 'Aprenda a linguagem python',1),
			(2,'Java', 'Aprenda a linguagem java',2),
			(3,'PHP', 'Aprenda a linguagem php',3);

INSERT INTO aula (aula_id,nome,descricao,curso_id) 
	VALUES 	(1,'Introdução aos algoritmos', 'Apresentação do curso',1),
			(2,'Introdução as estruturas de dados', 'Introdução do curso',2),
			(3,'Desenvolvimento de CRUD', 'Função de adção',3);

INSERT INTO curso_aluno (curso_id,aluno_id) 
	VALUES 	(1,1),
			(2,2),
			(3,3);
			
INSERT INTO nota (nota_id,valor,aprovado,curso_id,aluno_id) 
	VALUES 	(1,8, 'true',1,1),
			(2,5, 'false',2,2),
			(3,9, 'true',3,3);


Select nextval(pg_get_serial_sequence('aluno', 'aluno_id')) as aluno_id;
Select nextval(pg_get_serial_sequence('aula', 'aula_id')) as aluno_id;
Select nextval(pg_get_serial_sequence('curso', 'curso_id')) as aluno_id;
Select nextval(pg_get_serial_sequence('nota', 'nota_id')) as aluno_id;
Select nextval(pg_get_serial_sequence('professor', 'professor_id')) as aluno_id;
			





