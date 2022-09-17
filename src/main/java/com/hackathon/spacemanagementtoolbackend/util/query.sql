CREATE DATABASE smtDB;
USE smtDB;

CREATE TABLE team(id int primary key auto_increment, team varchar(20), OECode varchar(20));

INSERT INTO Team(team, oecode) values("team1", "OE1");
INSERT INTO Team(team, oecode) values("team2", "OE2");
INSERT INTO Team(team, oecode) values("team11", "OE11");
INSERT INTO Team(team, oecode) values("team12", "OE12");
INSERT INTO Team(team, oecode) values("team111", "OE111");
INSERT INTO Team(team, oecode) values("team112", "OE112");
INSERT INTO Team(team, oecode) values("team121", "OE121");
INSERT INTO Team(team, oecode) values("team21", "OE21");
INSERT INTO Team(team, oecode) values("team211", "OE211");
INSERT INTO Team(team, oecode) values("team212", "OE212");
INSERT INTO Team(team, oecode) values("team22", "OE22");
INSERT INTO Team(team, oecode) values("team221", "OE221");


CREATE TABLE employee(id int primary key auto_increment, username varchar(20), password varchar(20), team_id int, FOREIGN KEY (team_id) REFERENCES team(id), total_seats int);

INSERT INTO employee(username, password, team_id, total_seats) values("1", "1", "1", 100);
INSERT INTO employee(username, password, team_id, total_seats) values("2", "2", "2", 50);
INSERT INTO employee(username, password, team_id, total_seats) values("3", "3", "3", 40);
INSERT INTO employee(username, password, team_id, total_seats) values("4", "4", "4", 10);
INSERT INTO employee(username, password, team_id, total_seats) values("5", "5", "5", 10);
INSERT INTO employee(username, password, team_id, total_seats) values("6", "6", "5", 1);
INSERT INTO employee(username, password, team_id, total_seats) values("7", "7", "5", 1);
INSERT INTO employee(username, password, team_id, total_seats) values("8", "8", "6", 1);
INSERT INTO employee(username, password, team_id, total_seats) values("9", "9", "6", 1);
INSERT INTO employee(username, password, team_id, total_seats) values("10", "10", "6", 1);
INSERT INTO employee(username, password, team_id, total_seats) values("11", "11", "6", 1);
INSERT INTO employee(username, password, team_id, total_seats) values("12", "12", "8", 90);
INSERT INTO employee(username, password, team_id, total_seats) values("13", "13", "9", 9);
INSERT INTO employee(username, password, team_id, total_seats) values("14", "14", "9", 9);
INSERT INTO employee(username, password, team_id, total_seats) values("15", "15", "9", 9);
INSERT INTO employee(username, password, team_id, total_seats) values("16", "16", "7", 9);
INSERT INTO employee(username, password, team_id, total_seats) values("17", "17", "7", 9);
INSERT INTO employee(username, password, team_id, total_seats) values("18", "18", "10", 9);
INSERT INTO employee(username, password, team_id, total_seats) values("19", "19", "10", 9);
INSERT INTO employee(username, password, team_id, total_seats) values("20", "20", "10", 9);
INSERT INTO employee(username, password, team_id, total_seats) values("21", "21", "10", 9);
INSERT INTO employee(username, password, team_id, total_seats) values("23", "23", "11", 9);
INSERT INTO employee(username, password, team_id, total_seats) values("24", "24", "12", 9);
INSERT INTO employee(username, password, team_id, total_seats) values("26", "26", "12", 9);
INSERT INTO employee(username, password, team_id, total_seats) values("27", "27", "12", 9);
INSERT INTO employee(username, password, team_id, total_seats) values("28", "28", "12", 9);
INSERT INTO employee(username, password, team_id, total_seats) values("29", "29", "12", 9);
INSERT INTO employee(username, password, team_id, total_seats) values("30", "30", "12", 9);
INSERT INTO employee(username, password, team_id, total_seats) values("31", "31", "12", 9);

create table teamsunderemployee(id int primary key auto_increment, team_id int, foreign key (team_id) references team(id), employee_id int, foreign key (employee_id) references employee(id) );

INSERT INTO teamsunderemployee(team_id, employee_id) values(1,1);
INSERT INTO teamsunderemployee(team_id, employee_id) values(2,1);
INSERT INTO teamsunderemployee(team_id, employee_id) values(3,1);
INSERT INTO teamsunderemployee(team_id, employee_id) values(4,2);
INSERT INTO teamsunderemployee(team_id, employee_id) values(5,2);


CREATE TABLE floor(id int primary key auto_increment, floor_number int);

INSERT INTO FLOOR(floor_number) value(1);
INSERT INTO FLOOR(floor_number) value(2);
INSERT INTO FLOOR(floor_number) value(3);
INSERT INTO FLOOR(floor_number) value(4);

CREATE TABLE zone(id int primary key primary key auto_increment, floor_id int, FOREIGN KEY (floor_id) REFERENCES floor(id), zone_name varchar(20));

INSERT INTO ZONE(floor_id, zone_name) values(1, "A");
INSERT INTO ZONE(floor_id, zone_name) values(1, "B");
INSERT INTO ZONE(floor_id, zone_name) values(1, "C");
INSERT INTO ZONE(floor_id, zone_name) values(1, "D");
INSERT INTO ZONE(floor_id, zone_name) values(2, "A");
INSERT INTO ZONE(floor_id, zone_name) values(2, "B");
INSERT INTO ZONE(floor_id, zone_name) values(2, "C");
INSERT INTO ZONE(floor_id, zone_name) values(2, "D");
INSERT INTO ZONE(floor_id, zone_name) values(3, "A");
INSERT INTO ZONE(floor_id, zone_name) values(3, "B");
INSERT INTO ZONE(floor_id, zone_name) values(3, "C");
INSERT INTO ZONE(floor_id, zone_name) values(3, "D");
INSERT INTO ZONE(floor_id, zone_name) values(4, "A");
INSERT INTO ZONE(floor_id, zone_name) values(4, "B");
INSERT INTO ZONE(floor_id, zone_name) values(4, "C");
INSERT INTO ZONE(floor_id, zone_name) values(4, "D");

CREATE TABLE teamfloorzone(id int primary key auto_increment, team_id int, floor_id int, zone_id int, seat_from int, seat_to int);

INSERT INTO teamfloorzone(team_id, floor_id, zone_id, seat_from, seat_to) values (1, 1, 1, 1, 100);
INSERT INTO teamfloorzone(team_id, floor_id, zone_id, seat_from, seat_to) values (1, 1, 2, 1, 100);
INSERT INTO teamfloorzone(team_id, floor_id, zone_id, seat_from, seat_to) values (1, 2, 3, 1, 100);