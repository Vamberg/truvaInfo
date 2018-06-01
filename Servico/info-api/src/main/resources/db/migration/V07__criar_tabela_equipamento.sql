CREATE TABLE equipamento (

    id INT UNSIGNED AUTO_INCREMENT,
    marca VARCHAR(30) NOT NULL,
    descricao VARCHAR(30) NOT NULL,
    modelo VARCHAR(30) NOT NULL,
    numero_serie VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)

)Engine=Innodb default charset = utf8;
