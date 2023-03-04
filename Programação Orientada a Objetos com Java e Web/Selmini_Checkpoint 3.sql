DROP TABLE JAVA_CATEGORIA CASCADE CONSTRAINTS;
DROP TABLE JAVA_PRODUTO CASCADE CONSTRAINTS;
DROP TABLE JAVA_PEDIDO CASCADE CONSTRAINTS;
DROP TABLE JAVA_PEDIDODETALHE CASCADE CONSTRAINTS;
DROP SEQUENCE categoria_sequence;
DROP SEQUENCE produto_sequence;
DROP SEQUENCE pedido_sequence;
DROP SEQUENCE detalhe_sequence;
COMMIT;

create sequence categoria_sequence
    MINVALUE 1
    MAXVALUE 9999999
    start with 1
    cache 20;
COMMIT;
create sequence produto_sequence
    MINVALUE 1
    MAXVALUE 9999999
    start with 1000
    cache 20;
COMMIT;
create sequence pedido_sequence
    MINVALUE 1
    MAXVALUE 9999999
    start with 1000
    cache 20;
COMMIT;
create sequence detalhe_sequence
    MINVALUE 1
    MAXVALUE 9999999
    start with 10
    cache 20;
    
COMMIT;

create table java_categoria(
    categoria_id number(10,0) primary key,
    categoria varchar2(50) not null unique
);
commit;

create table java_produto(
    produto_id number(10,0) primary key,
    categoria_id number(10,0),
    nome varchar2(50) not null,
    descricao varchar2(50) not null,
    preco number(10,2) not null,
    foreign key (categoria_id) references java_categoria(categoria_id)
);
commit;

create table java_pedido(
    pedido_id number(10,0) primary key,
    nome_contato varchar2(50) not null,
    endereco_contato varchar2(50) not null,
    data date not null
);
commit;

create table java_pedidodetalhe(
    id number(10,0),
    pedido_id number(10,0),
    produto_id number(10,0),
    quantidade number(10,0) not null,
    total number(10,2) not null,
    foreign key (pedido_id) references java_pedido(pedido_id),
    foreign key (produto_id) references java_produto(produto_id)
);
commit;

insert into java_categoria values (categoria_sequence.nextval, 'Higiene');
insert into java_categoria values (categoria_sequence.nextval, 'Destino');
insert into java_categoria values (categoria_sequence.nextval, 'Rotina');
insert into java_categoria values (categoria_sequence.nextval, 'Ocasionais');
insert into java_categoria values (categoria_sequence.nextval, 'Conveniência');
commit;

insert into java_produto values (produto_sequence.nextval, 1,'Shampoo','Cuidado Pessoal', 30.00);
insert into java_produto values (produto_sequence.nextval, 1,'Condicionador','Cuidado Pessoal', 26.00);
insert into java_produto values (produto_sequence.nextval, 1,'Sabonete','Cuidado Pessoal', 5.00);
insert into java_produto values (produto_sequence.nextval, 2,'Carne','Açougue', 75.00);
insert into java_produto values (produto_sequence.nextval, 2,'Vinho','Bebibas Alcoólicas', 50.00);
insert into java_produto values (produto_sequence.nextval, 2,'Pão','Padaria', 1.00);
insert into java_produto values (produto_sequence.nextval, 3,'Arroz','Dia a dia',35.00);
insert into java_produto values (produto_sequence.nextval, 3,'Feijão','Dia a dia', 8.00);
insert into java_produto values (produto_sequence.nextval, 3,'Macarrão','Dia a dia', 14.00);
insert into java_produto values (produto_sequence.nextval, 4,'Panettone','Sazonal', 25.00);
insert into java_produto values (produto_sequence.nextval, 4,'Ovo de Páscoa','Sazonal', 40.00);
insert into java_produto values (produto_sequence.nextval, 4,'Árvore de Natal','Sazonal', 150.00);
insert into java_produto values (produto_sequence.nextval, 5,'Doritos','Salgadinho', 7.50);
insert into java_produto values (produto_sequence.nextval, 5,'Bolacha','Guloseimas', 4.00);
insert into java_produto values (produto_sequence.nextval, 5,'Refrigerante','Bebidas Geral', 8.00);
commit;


insert into java_pedido values (pedido_sequence.nextval, 'Breno Silva', 'Rua Antonio Pires, 331', '26/10/2022');
insert into java_pedido values (pedido_sequence.nextval, 'Antonio Marcos Selmini', 'Avenida Lins de Vasconcelos,
1222', '26/10/2022');
insert into java_pedido values (pedido_sequence.nextval, 'Luciano Melo', 'Avenida Paulista, 1106', '26/10/2022');
commit;

insert into java_pedidodetalhe values (detalhe_sequence.nextval, 1000, 1000, 1, 30.00);
insert into java_pedidodetalhe values (detalhe_sequence.nextval, 1001, 1008, 1, 14.00);
insert into java_pedidodetalhe values (detalhe_sequence.nextval, 1002, 1012, 1, 7.50);
commit;


select * from java_pedido;

select * from java_pedidodetalhe;
