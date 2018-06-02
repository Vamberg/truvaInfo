CREATE TABLE papel (
    id INT UNSIGNED,
    funcao VARCHAR (20) ,
    PRIMARY KEY (id)
    

)Engine = INNOdb default charset = utf8;

CREATE TABLE permissao (
    id INT UNSIGNED,
    descricao VARCHAR (50) ,
    PRIMARY KEY (id)
    

)Engine = INNOdb default charset = utf8;

CREATE TABLE papel_permissao(
    id_papel INT UNSIGNED,
    id_permissao INT UNSIGNED,
    PRIMARY KEY(id_papel,id_permissao)


)Engine = INNOdb default charset = utf8;


INSERT INTO papel (funcao,id) values ('ADMIN','1');
INSERT INTO papel (funcao,id) values ('GERENTE','2');
INSERT INTO papel (funcao,id) values ('FUNCIONARIO','3');
INSERT INTO papel (funcao,id) values ('CLIENTE','4');


-- inserindo permissoes
INSERT INTO permissao (id, descricao) values (1, 'ROLE_CADASTRAR_PESSOA');
INSERT INTO permissao (id, descricao) values (2, 'ROLE_BUSCAR_PESSOA');
INSERT INTO permissao (id, descricao) values (3, 'ROLE_ATUALIZAR_PESSOA');
INSERT INTO permissao (id, descricao) values (4, 'ROLE_DELETAR_PESSOA');
INSERT INTO permissao (id, descricao) values (5, 'ROLE_CADASTRAR_CLIENTE');
INSERT INTO permissao (id, descricao) values (6, 'ROLE_BUSCAR_CLIENTE');
INSERT INTO permissao (id, descricao) values (7, 'ROLE_ATUALIZAR_CLIENTE');
INSERT INTO permissao (id, descricao) values (8, 'ROLE_DELETAR_CLIENTE');
INSERT INTO permissao (id, descricao) values (9, 'ROLE_CADASTRAR_FUNCIONARIO');
INSERT INTO permissao (id, descricao) values (10, 'ROLE_BUSCAR_FUNCIONARIO');
INSERT INTO permissao (id, descricao) values (11, 'ROLE_ATUALIZAR_FUNCIONARIO');
INSERT INTO permissao (id, descricao) values (12, 'ROLE_DELETAR_FUNCIONARIO');
INSERT INTO permissao (id, descricao) values (13, 'ROLE_CADASTRAR_ORDEM_SERVICO');
INSERT INTO permissao (id, descricao) values (14, 'ROLE_BUSCAR_ORDEM_SERVICO');
INSERT INTO permissao (id, descricao) values (15, 'ROLE_ATUALIZAR_ORDEM_SERVICO');
INSERT INTO permissao (id, descricao) values (16, 'ROLE_DELETAR_ORDEM_SERVICO');



-- adicionando permissoes ao adm
INSERT INTO papel_permissao (id_papel, id_permissao) values (1, 1);
INSERT INTO papel_permissao (id_papel, id_permissao) values (1, 2);
INSERT INTO papel_permissao (id_papel, id_permissao) values (1, 3);
INSERT INTO papel_permissao (id_papel, id_permissao) values (1, 4);
INSERT INTO papel_permissao (id_papel, id_permissao) values (1, 5);
INSERT INTO papel_permissao (id_papel, id_permissao) values (1, 6);
INSERT INTO papel_permissao (id_papel, id_permissao) values (1, 7);
INSERT INTO papel_permissao (id_papel, id_permissao) values (1, 8);
INSERT INTO papel_permissao (id_papel, id_permissao) values (1, 9);
INSERT INTO papel_permissao (id_papel, id_permissao) values (1, 10);
INSERT INTO papel_permissao (id_papel, id_permissao) values (1, 11);
INSERT INTO papel_permissao (id_papel, id_permissao) values (1, 12);
INSERT INTO papel_permissao (id_papel, id_permissao) values (1, 13);
INSERT INTO papel_permissao (id_papel, id_permissao) values (1, 14);
INSERT INTO papel_permissao (id_papel, id_permissao) values (1, 15);
INSERT INTO papel_permissao (id_papel, id_permissao) values (1, 16);


-- adicionando permissoes ao gererente
INSERT INTO papel_permissao (id_papel, id_permissao) values (2, 1);
INSERT INTO papel_permissao (id_papel, id_permissao) values (2, 2);
INSERT INTO papel_permissao (id_papel, id_permissao) values (2, 3);
INSERT INTO papel_permissao (id_papel, id_permissao) values (2, 5);
INSERT INTO papel_permissao (id_papel, id_permissao) values (2, 6);
INSERT INTO papel_permissao (id_papel, id_permissao) values (2, 7);
INSERT INTO papel_permissao (id_papel, id_permissao) values (2, 9);
INSERT INTO papel_permissao (id_papel, id_permissao) values (2, 10);
INSERT INTO papel_permissao (id_papel, id_permissao) values (2, 11);
INSERT INTO papel_permissao (id_papel, id_permissao) values (2, 13);
INSERT INTO papel_permissao (id_papel, id_permissao) values (2, 14);
INSERT INTO papel_permissao (id_papel, id_permissao) values (2, 15);


-- adicionando permissoes ao funcionario
INSERT INTO papel_permissao (id_papel, id_permissao) values (3, 1);
INSERT INTO papel_permissao (id_papel, id_permissao) values (3, 2);
INSERT INTO papel_permissao (id_papel, id_permissao) values (3, 3);
INSERT INTO papel_permissao (id_papel, id_permissao) values (3, 5);
INSERT INTO papel_permissao (id_papel, id_permissao) values (3, 6);
INSERT INTO papel_permissao (id_papel, id_permissao) values (3, 7);
INSERT INTO papel_permissao (id_papel, id_permissao) values (3, 13);
INSERT INTO papel_permissao (id_papel, id_permissao) values (3, 14);
INSERT INTO papel_permissao (id_papel, id_permissao) values (3, 15);


-- adicionando permissoes ao cliente


INSERT INTO papel_permissao (id_papel, id_permissao) values (4, 14);











