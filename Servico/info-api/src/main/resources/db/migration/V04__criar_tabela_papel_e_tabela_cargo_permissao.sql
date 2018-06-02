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


INSERT INTO papel (funcao,id) values ('GERENTE','1');
INSERT INTO papel (funcao,id) values ('TÉCNICO','2');
INSERT INTO papel (funcao,id) values ('RECEPCIONISTA','3');
INSERT INTO papel (funcao,id) values ('CLIENTE','4');
INSERT INTO papel (funcao,id) values ('CAIXA','5');


