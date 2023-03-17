Drop database if exists task_alberghi;
Create database task_alberghi;
Use task_alberghi;

Create Table Albergo(
	albergoID integer primary key auto_increment,
	nome varchar(100) not null,
    indirizzo varchar(100) not null,
    stelle integer not null check (stelle > 0)
    );
    
Create Table Stanza(
	stanzaID integer primary key auto_increment,
    nome varchar(100) not null,
    tipo varchar(100) not null,
    occupata boolean default false,
    albergoRIF integer not null,
    foreign key (albergoRIF) references Albergo(albergoID) on delete cascade
    );
    
Create Table Prenotazione(
	prenotazioneID integer primary key auto_increment,
    codice varchar(100) not null unique,
    nominativo varchar(100) default "N:D:",
    data_inizio date,
    data_fine date,
    data_prenotazione datetime default current_timestamp,
    stanzaRIF integer not null,
    foreign key (stanzaRIF) references Stanza(stanzaID) on delete cascade
    );
    
select * 
	from Albergo
    left join Stanza on Albergo.albergoID = Stanza.albergoRIF
    left join Prenotazione on Stanza.stanzaID = Prenotazione.stanzaRIF;