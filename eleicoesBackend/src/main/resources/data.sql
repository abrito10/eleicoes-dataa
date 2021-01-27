INSERT INTO tb_eleicao(nome_eleicao, data_inicio, data_termino) VALUES('Eleicao Geral', TIMESTAMP WITH TIME ZONE '2021-01-01T16:00:00Z', TIMESTAMP WITH TIME ZONE '2021-01-10T16:00:00Z' );
INSERT INTO tb_eleicao(nome_eleicao, data_inicio, data_termino) VALUES('Eleicao Teste', TIMESTAMP WITH TIME ZONE '2021-01-01T16:00:00Z', TIMESTAMP WITH TIME ZONE '2021-02-10T16:00:00Z' );

INSERT INTO tb_cargo(nome_cargo) VALUES('PRESIDENTE');
INSERT INTO tb_cargo(nome_cargo) VALUES('GOVERNADOR');

INSERT INTO tb_candidato(cargo, imagem_Candidato, nome_candidato) VALUES ('Governador', 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_bacon.jpg', 'Adilson');
INSERT INTO tb_candidato(cargo, imagem_Candidato, nome_candidato) VALUES ('Presidente', 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_bacon.jpg', 'Adilson');

INSERT INTO tb_usuario(nome_usuario, cpf, senha) VALUES('Usuario 1', '12345678909','1234');
INSERT INTO tb_usuario(nome_usuario, cpf, senha) VALUES('Usuario 2', '12345678909','1239');

INSERT INTO perfis(usuario_id,perfis) VALUES(1, 1);
INSERT INTO perfis(usuario_id,perfis) VALUES(1, 2);

INSERT INTO perfis(usuario_id,perfis) VALUES(2, 1);

INSERT INTO tb_voto(cpf,protocolo,voto) VALUES('12345678909', '1234-1234-1234-1', 1 );
INSERT INTO tb_voto(cpf,protocolo,voto) VALUES('02345678909', '1234-1234-1234-1', 1 );
INSERT INTO tb_voto(cpf,protocolo,voto) VALUES('32345678909', '1234-1234-1234-1', 1 );


