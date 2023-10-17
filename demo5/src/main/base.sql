create database solar;
\c solar;

drop table client cascade;
drop table donnees cascade;
drop table clientbatterie cascade;
drop table typebatterie cascade;
drop table module cascade;
drop table clientmodule cascade;

create table typebatterie(
    id serial not null,
    valeur real not null,
    primary key(id)
);

insert into typebatterie(valeur) values (12);
insert into typebatterie(valeur) values (24);
insert into typebatterie(valeur) values (48);

create table module(
    id serial not null,
    qrcode varchar(500) not null,
    idbatterie int not null,
    primary key(id),
    foreign key(idbatterie) references typebatterie(id)
);

insert into module(qrcode,idbatterie) values ('itonyqr',1);

create table client(
    id serial not null,
    email varchar(500) not null,
    pass varchar(500) not null,
    lienimage varchar(500) not null,
    adresse varchar(500) not null,
    codepostal varchar(500) not null,
    haveQr boolean default true,
    primary key(id)
);

create table clientmodule(
    id serial not null,
    idclient int not null,
    idmodule int not null,
    primary key(id),
    foreign key(idclient) references client(id),
    foreign key(idmodule) references module(id)
);

create table donnees(
    id serial not null,
    idmodule int not null,
    voltagepanneau real not null,
    voltageoutput real not null,
    voltagebatterie real not null,
    production real not null,
    consommation real not null,
    valeurbatterie real not null,
    temps timestamp not null,
    primary key(id),
    foreign key(idmodule) references module(id)
);