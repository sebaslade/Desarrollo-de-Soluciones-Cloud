-- eliminamos la base de datos si existe
drop database if exists bdrapidosyfuriosos2025;

-- creamos la base de datos
create database bdrapidosyfuriosos2025;

-- seleccionamos la base de datos
use bdrapidosyfuriosos2025;

-- creamos las tablas
-- simples
-- distrito
create table distrito(
coddis int primary key auto_increment,
nomdis varchar(50) not null,
estdis bit not null
)engine=InnoDB character set=utf8;

-- sexo
create table sexo(
codsex int primary key auto_increment,
nomsex varchar(20) not null,
estsex bit not null
)engine=InnoDB character set=utf8;

-- tipodocumento
create table tipodocumento(
codtipd int primary key auto_increment,
nomtipd varchar(30) not null,
esttipd bit not null
)engine=InnoDB character set=utf8;

-- cruzadas
create table cliente(
codcli int primary key auto_increment,
nomcli varchar(40) not null,
apepcli varchar(40) not null,
apemcli varchar(40) not null,
doccli varchar(15) not null,
feccli date not null,
dircli varchar(100) not null,
telcli varchar(7) null,
celcli varchar(9) not null,
corcli varchar(40) null,
estcli bit not null,
coddis int not null,
codsex int not null,
codtipd int not null,
foreign key (coddis) references distrito(coddis),
foreign key (codsex) references sexo(codsex),
foreign key (codtipd) references tipodocumento(codtipd)
);

-- insertar datos
-- simples
-- distrito
insert into distrito(nomdis,estdis) values('Ancón',1);
insert into distrito(nomdis,estdis) values('Ate',1);
insert into distrito(nomdis,estdis) values('Barranco',1);
insert into distrito(nomdis,estdis) values('Breña',1);
insert into distrito(nomdis,estdis) values('Carabayllo',1);
insert into distrito(nomdis,estdis) values('Chaclacayo',1);
insert into distrito(nomdis,estdis) values('Chorrillos',1);
insert into distrito(nomdis,estdis) values('Cieneguilla',1);
insert into distrito(nomdis,estdis) values('Comas',1);
insert into distrito(nomdis,estdis) values('El Agustino',1);
insert into distrito(nomdis,estdis) values('Independencia',1);
insert into distrito(nomdis,estdis) values('Jesús María',1);
insert into distrito(nomdis,estdis) values('La Molina',1);
insert into distrito(nomdis,estdis) values('La Victoria',1);
insert into distrito(nomdis,estdis) values('Lima',1);
insert into distrito(nomdis,estdis) values('Lince',1);
insert into distrito(nomdis,estdis) values('Los Olivos',1);
insert into distrito(nomdis,estdis) values('Lurigancho',1);
insert into distrito(nomdis,estdis) values('Lurín',1);
insert into distrito(nomdis,estdis) values('Magdalena del Mar',1);
insert into distrito(nomdis,estdis) values('Miraflores',1);
insert into distrito(nomdis,estdis) values('Pachacámac',1);
insert into distrito(nomdis,estdis) values('Pucusana',1);
insert into distrito(nomdis,estdis) values('Pueblo Libre',1);
insert into distrito(nomdis,estdis) values('Puente Piedra',1);
insert into distrito(nomdis,estdis) values('Punta Hermosa',1);
insert into distrito(nomdis,estdis) values('Punta Negra',1);
insert into distrito(nomdis,estdis) values('Rímac',1);
insert into distrito(nomdis,estdis) values('San Bartolo',1);
insert into distrito(nomdis,estdis) values('San Borja',1);
insert into distrito(nomdis,estdis) values('San Isidro',1);
insert into distrito(nomdis,estdis) values('San Juan de Lurigancho',1);
insert into distrito(nomdis,estdis) values('San Juan de Miraflores',1);
insert into distrito(nomdis,estdis) values('San Luis',1);
insert into distrito(nomdis,estdis) values('San Martín de Porres',1);
insert into distrito(nomdis,estdis) values('San Miguel',1);
insert into distrito(nomdis,estdis) values('Santa Anita',1);
insert into distrito(nomdis,estdis) values('Santa María del Mar',1);
insert into distrito(nomdis,estdis) values('Santa Rosa',1);
insert into distrito(nomdis,estdis) values('Santiago de Surco',1);
insert into distrito(nomdis,estdis) values('Surquillo',1);
insert into distrito(nomdis,estdis) values('Villa El Salvador',1);
insert into distrito(nomdis,estdis) values('Villa María del Triunfo',1);
insert into distrito(nomdis,estdis) values('Callao',1);
insert into distrito(nomdis,estdis) values('Bellavista',1);
insert into distrito(nomdis,estdis) values('Carmen de La Legua-Reynoso',1);
insert into distrito(nomdis,estdis) values('La Perla',1);
insert into distrito(nomdis,estdis) values('La Punta',1);
insert into distrito(nomdis,estdis) values('Ventanilla',1);
insert into distrito(nomdis,estdis) values('Mi Perú',1);

-- sexo
insert into sexo(nomsex,estsex) values('Masculino',1);
insert into sexo(nomsex,estsex) values('Femenino',1);
insert into sexo(nomsex,estsex) values('Otros',1);
insert into sexo(nomsex,estsex) values('Sin especificar',1);

-- tipo de documento
insert into tipodocumento(nomtipd,esttipd) values('DNI',1);
insert into tipodocumento(nomtipd,esttipd) values('RUC',1);
insert into tipodocumento(nomtipd,esttipd) values('Pasaporte',1);
insert into tipodocumento(nomtipd,esttipd) values('Carnet de Extranjeria',1);

-- cruzadas
-- cliente
insert into cliente(nomcli,apepcli,apemcli,doccli,feccli,dircli,telcli,
celcli,corcli,estcli,coddis,codsex,codtipd) values('Jose Daniel','Osorio',
'Morales','77456231','1993-08-04','Av. Luis Braille 1450','2462119',
'999874521',null,1,15,1,1);
insert into cliente(nomcli,apepcli,apemcli,doccli,feccli,dircli,telcli,
celcli,corcli,estcli,coddis,codsex,codtipd) values('Stefani Daniela',
'Morales','Castillo','79853214','1997-04-02','Av. Las Flores 1980',null,
'951753258','smorales@gmail.com',1,22,2,1);

-- mostrando informacion
-- simples
select * from distrito;
select * from sexo;
select * from tipodocumento;

-- cruzadas
select c.codcli,c.nomcli,c.apepcli,c.apemcli,c.doccli,c.feccli,c.dircli,
c.telcli,c.celcli,c.corcli,c.estcli,d.nomdis,s.nomsex,td.nomtipd from 
cliente c inner join distrito d on c.coddis=d.coddis inner join sexo s 
on c.codsex=s.codsex inner join tipodocumento td on c.codtipd=td.codtipd;

CREATE TABLE Marca (
    codMarca INT AUTO_INCREMENT PRIMARY KEY,     
    nomMarca VARCHAR(50) NOT NULL,               
    estado BIT NOT NULL DEFAULT 1                
);

CREATE TABLE Color (
    codColor INT AUTO_INCREMENT PRIMARY KEY,     
    nomColor VARCHAR(30) NOT NULL,              
    estado BIT NOT NULL DEFAULT 1               
);

-- rol 
-- eliminamos la tabla si existe
drop table if exists rol;
create table rol(
codrol int primary key auto_increment,
nomrol varchar(40) binary character set utf8 collate utf8_bin not null,
estado bit not null
)engine=InnoDB character set utf8;

-- insertamos valores a la tabla categoria
insert into rol(nomrol,estado) values('administrador',1);
insert into rol(nomrol,estado) values('usuario',1);
insert into rol(nomrol,estado) values('invitado',1);

select * from rol;

create table empleado(
codemp int primary key auto_increment,
nomemp varchar(40) binary character set utf8 collate utf8_bin not null,
apepemp varchar(30) binary character set utf8 collate utf8_bin not null,
apememp varchar(30) binary character set utf8 collate utf8_bin not null,
dniemp varchar(8) not null,
fecemp date not null,
diremp varchar(50) binary character set utf8 collate utf8_bin not null,
telemp varchar(7) not null,
celemp varchar(9) not null,
coremp varchar(40) binary character set utf8 collate utf8_bin not null,
sexemp varchar(9) not null,
usuemp varchar(40) binary character set utf8 collate utf8_bin not null,
claemp varchar(40) binary character set utf8 collate utf8_bin not null,
estemp bit not null,
coddis int not null,
codrol int not null,
foreign key (coddis) references distrito(coddis),
foreign key (codrol) references rol(codrol)
)engine=InnoDB character set=utf8;

insert into empleado(nomemp,apepemp,apememp,dniemp,fecemp,diremp,telemp,celemp,coremp,sexemp,usuemp,claemp,estemp,coddis,codrol)
values ('Mario Antonio', 'Huapalla','Morales','41526332','1982-02-17','Av. Luis Braille 1450','4253524','963258741',
'mhuapalla@gmail.com','Masculino','mhuapalla','123456',1,15,1);

CREATE TABLE Vehiculo (
    codVehiculo INT AUTO_INCREMENT PRIMARY KEY,  
    placa VARCHAR(10) NOT NULL UNIQUE,           
    modelo VARCHAR(50) NOT NULL,                
    anioFabricacion INT NOT NULL,                
    codMarca INT NOT NULL,                       
    codColor INT NOT NULL,                      
    codcli INT NOT NULL,                    
    estado BIT NOT NULL DEFAULT 1,               
    FOREIGN KEY (codMarca) REFERENCES Marca(codMarca), 
    FOREIGN KEY (codColor) REFERENCES Color(codColor), 
    FOREIGN KEY (codcli) REFERENCES Cliente(codcli) 
);

CREATE TABLE HistorialVehiculo (
    codHistorial INT AUTO_INCREMENT PRIMARY KEY, 
    codVehiculo INT NOT NULL,                     
    fechaIngreso DATE NOT NULL,                   
    servicioSolicitado VARCHAR(100) NOT NULL,     
    observaciones TEXT,                           
    codemp INT NOT NULL,               
    estado BIT NOT NULL DEFAULT 1,               
    FOREIGN KEY (codVehiculo) REFERENCES Vehiculo(codVehiculo),
    FOREIGN KEY (codemp) REFERENCES empleado(codemp)
);

CREATE TABLE Servicio (
    codServicio INT AUTO_INCREMENT PRIMARY KEY,   
    nomServicio VARCHAR(100) NOT NULL,            
    descripcion TEXT,                            
    precio DECIMAL(10, 2) NOT NULL,               
    estado BIT NOT NULL DEFAULT 1                 
);

CREATE TABLE DetalleHistorial (
    codDetalleHistorial INT AUTO_INCREMENT PRIMARY KEY,  
    codHistorial INT NOT NULL,                          
    codServicio INT NOT NULL,                            
    estado BIT NOT NULL DEFAULT 1,                    
    FOREIGN KEY (codHistorial) REFERENCES HistorialVehiculo(codHistorial),
    FOREIGN KEY (codServicio) REFERENCES Servicio(codServicio)
);

