-- Create  and use DB 
CREATE DATABASE smtDB;
USE smtDB;

CREATE TABLE employee(id int primary key auto_increment, username varchar(20), password varchar(20), team_id int, FOREIGN KEY (team_id) REFERENCES team(id), total_seats int); 

CREATE TABLE team(id int primary key auto_increment, team varchar(20), OECode varchar(20));

CREATE TABLE floor(id int primary key auto_increment, floor_number int);

CREATE TABLE zone(id int primary key primary key auto_increment, floor_id int, FOREIGN KEY (floor_id) REFERENCES floor(id), zone_name varchar(20));

CREATE TABLE seat(id int primary key, floor_id int, zone_id int, seats_from int, seats_to int);

CREATE TABLE EMPLOYEE_UNDER_TEAM(id int primary key, employee_id int, TEAM_ID int);

CREATE TABLE TEAM_FLOOR_ZONE(id int primary key, team_id int, floor_id int, Zone_id int, seat_from int, seat_to int);


INSERT INTO Team(team, OECode) values("team1", "OE1");
INSERT INTO Team(team, OECode) values("team2", "OE2");
INSERT INTO Team(team, OECode) values("team11", "OE11");
INSERT INTO Team(team, OECode) values("team12", "OE12");
INSERT INTO Team(team, OECode) values("team111", "OE111");
INSERT INTO Team(team, OECode) values("team112", "OE112");
INSERT INTO Team(team, OECode) values("team121", "OE121");
INSERT INTO Team(team, OECode) values("team21", "OE21");
INSERT INTO Team(team, OECode) values("team211", "OE211");
INSERT INTO Team(team, OECode) values("team212", "OE212");
INSERT INTO Team(team, OECode) values("team22", "OE22");
INSERT INTO Team(team, OECode) values("team221", "OE221");

INSERT INTO employee(username, password, team_, total_seats) values(1, "1", "OE1", 100);
INSERT INTO employee(username, password, OECode, total_seats) values("2", "2", "OE2", 50);
INSERT INTO employee(username, password, OECode, total_seats) values("3", "3", "OE11", 40);
INSERT INTO employee(username, password, OECode, total_seats) values("4", "4", "OE12", 10);
INSERT INTO employee(username, password, OECode, total_seats) values("5", "5", "OE111", 10);
INSERT INTO employee(username, password, OECode, total_seats) values("6", "6", "OE111", 1);
INSERT INTO employee(username, password, OECode, total_seats) values("7", "7", "OE111", 1);
INSERT INTO employee(username, password, OECode, total_seats) values("8", "8", "OE112", 1);
INSERT INTO employee(username, password, OECode, total_seats) values("9", "9", "OE112", 1);
INSERT INTO employee(username, password, OECode, total_seats) values("10", "10", "OE112", 1);
INSERT INTO employee(username, password, OECode, total_seats) values("11", "11", "OE112", 1);
INSERT INTO employee(username, password, OECode, total_seats) values("12", "12", "OE21", 90);
INSERT INTO employee(username, password, OECode, total_seats) values("13", "13", "OE211", 9);
INSERT INTO employee(username, password, OECode, total_seats) values("14", "14", "OE211", 9);
INSERT INTO employee(username, password, OECode, total_seats) values("15", "15", "OE211", 9);
