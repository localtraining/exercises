drop table if exists cartao;
drop table if exists cliente;
drop table if exists pagamento;

create table cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(250) NOT NULL
);

create table cartao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    clienteid INT NOT NULL,
    numero VARCHAR(40) NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT 'false'
);

create table pagamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cartaoid INT NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    valor DOUBLE NOT NULL
);

insert into cliente (nome) values ('Primeiro');
insert into cliente (nome) values ('Segundo');

insert into cartao(clienteid, numero, ativo) values (1,'1234567890123456', 'true');

insert into pagamento(cartaoid, descricao, valor) values (1, 'Cooktop', 1290.99);
insert into pagamento(cartaoid, descricao, valor) values (1, 'Forno', 2240.95);
insert into pagamento(cartaoid, descricao, valor) values (2, 'Conjunto de Facas Tramontina', 240.90);