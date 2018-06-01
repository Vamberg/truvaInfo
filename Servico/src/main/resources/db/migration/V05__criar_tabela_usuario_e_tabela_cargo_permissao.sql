CREATE TABLE usuario (
    id INT UNSIGNED,
    funcao VARCHAR (20) ,
    PRIMARY KEY (id)
    

)Engine = INNOdb default charset = utf8;

CREATE TABLE permissao (
    id INT UNSIGNED,
    descricao VARCHAR (50) ,
    PRIMARY KEY (id)
    

)Engine = INNOdb default charset = utf8;

CREATE TABLE usuario_permissao(
    id_usuario INT UNSIGNED,
    id_permissao INT UNSIGNED,
    PRIMARY KEY(id_usuario,id_permissao)


)Engine = INNOdb default charset = utf8;


INSERT INTO usuario (funcao,id) values ('GERENTE','1');
INSERT INTO usuario (funcao,id) values ('TÉCNICO','2');
INSERT INTO usuario (funcao,id) values ('RECEPCIONISTA','3');
INSERT INTO usuario (funcao,id) values ('CLIENTE','4');
INSERT INTO usuario (funcao,id) values ('CAIXA','5');

