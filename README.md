# Hair Salon

#### An online Hair Salon Application
#### May 6, 2016

#### By Scott McIntire

## Description

A user can add a hair stylist and click on the stylist to add clients.

## Setup Instructions

* Clone this repository.
* Install postgresql and in PSQL:
  * CREATE DATABASE hair_salon;
  * CREATE TABLE stylists (id serial PRIMARY KEY, name varchar);
  * CREATE TABLE clients (id serial PRIMARY KEY, name varchar, stylist_id int);
* Install Gradle
* Run the following command in your terminal: `gradle run`

## Technologies Used

Java, SQL, Spark, Velocity, JUnit, FluentLenium, Bootstrap, CSS, JavaScript, HTML

## License

MIT License. See LICENSE.md for details.

## Copyright

Copyright (c) 2016 Scott McIntire
