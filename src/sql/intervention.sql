drop database if exists intervention;
create database intervention;

use intervention;

create table client (
	idclient int (3) not null auto_increment,
    nom varchar(20),
    prenom varchar (20),
	adresse varchar(20),
    primary key (idclient)
);

create table technicien (
	idtech int (3) not null auto_increment,
    nom varchar(20),
    prenom varchar (20),
    competence varchar(100),
    primary key (idtech)
);

create table intervention (
	idinter int (3) not null auto_increment,
    description varchar (100),
    dateinter date,
    montant float,
    idclient int(3) not null,
    idtech int(3) not null,
    primary key (idinter),
    foreign key (idclient) references client(idclient),
    foreign key (idtech) references technicient(idtech)
);

create table user (
	login varchar(20) not null,
    mdp varchar (100) not null,
    droits enum ('admin', 'user', 'autre'),
    primary key (login)
);