create database IF NOT EXISTS portfolio_db;
use portfolio_db;
CREATE TABLE IF NOT EXISTS candidate_details(
id int NOT NULL AUTO_INCREMENT,
name varchar(255) NOT NULL,
email_Id varchar(255) NOT NULL UNIQUE,
contact_number varchar(20) UNIQUE,
description varchar(500),
fb_link varchar(255) UNIQUE,
linked_in_link varchar(255) UNIQUE,
leet_code_link varchar(255) UNIQUE,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Address_details(
address_id int NOT NULL AUTO_INCREMENT,
id int,
house_name varchar(255),
street_name varchar(255),
state varchar(255),
country varchar(255),
pin_code varchar(255),
constraint address_pk PRIMARY KEY(address_id),
constraint address_fk foreign key (id) references candidate_details(id)
);

CREATE TABLE IF NOT EXISTS hobbies_list (
	  id int NOT NULL AUTO_INCREMENT,
	  hobbies varchar(255) DEFAULT NULL,
	  FOREIGN KEY (id) REFERENCES candidate_details (id)
	);
	
CREATE TABLE IF NOT EXISTS stilltag_list (
id int NOT NULL AUTO_INCREMENT,
skill_tags varchar(255) DEFAULT NULL,
FOREIGN KEY (id) REFERENCES candidate_details (id)
);