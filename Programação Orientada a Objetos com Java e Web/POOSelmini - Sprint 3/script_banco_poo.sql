
CREATE TABLE agencia (
    nro_agencia VARCHAR2(6) NOT NULL,
    cod_banco   VARCHAR2(4) NOT NULL,
    nome        VARCHAR2(80) NOT NULL,
    dig_agencia NUMBER(1)
);

ALTER TABLE agencia ADD CONSTRAINT agencia_pk PRIMARY KEY ( nro_agencia,
                                                            cod_banco );

CREATE TABLE banco (
    cod_banco          VARCHAR2(4) NOT NULL,
    nome               VARCHAR2(80) NOT NULL
);

ALTER TABLE banco ADD CONSTRAINT banco_pk PRIMARY KEY ( cod_banco );

CREATE TABLE conta_bancaria (
    id_conta    NUMBER(12) NOT NULL,
    saldo       NUMBER(15, 2) NOT NULL,
    nro_conta   VARCHAR2(10) NOT NULL,
    dig_conta   NUMBER(1) NOT NULL,
    nro_agencia VARCHAR2(6) NOT NULL,
    cod_banco   VARCHAR2(4) NOT NULL,
    tipo        VARCHAR2(2) NOT NULL
);

ALTER TABLE conta_bancaria ADD CONSTRAINT conta_bancaria_pk PRIMARY KEY ( id_conta );

ALTER TABLE conta_bancaria
    ADD CONSTRAINT conta_bancaria_un UNIQUE ( cod_banco,
                                              nro_agencia,
                                              nro_conta );
                                              
ALTER TABLE conta_bancaria ADD CONSTRAINT cb_tipo_ck CHECK ( tipo IN ('CC','CP') );

ALTER TABLE conta_bancaria
    ADD CONSTRAINT conta_bancaria_agencia_fk FOREIGN KEY ( nro_agencia,
                                                           cod_banco )
        REFERENCES agencia ( nro_agencia,
                             cod_banco );
                             
ALTER TABLE agencia
    ADD CONSTRAINT agencia_banco_fk FOREIGN KEY ( cod_banco )
        REFERENCES banco ( cod_banco );