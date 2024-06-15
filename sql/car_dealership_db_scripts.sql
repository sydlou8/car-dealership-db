-- drop Database
DROP DATABASE IF EXISTS car_dealership_db;

-- create Database
CREATE DATABASE car_dealership_db;
USE car_dealership_db;

-- create Tables
CREATE TABLE dealerships (
	dealership_id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	address VARCHAR(50) NOT NULL,
	phone VARCHAR(12) NOT NULL,
    PRIMARY KEY(dealership_id)
);

CREATE TABLE vehicles (
	vin INT NOT NULL,
    year INT NOT NULL,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    vehicle_type VARCHAR(50) NOT NULL,
    color VARCHAR(50) NOT NULL,
    odometer INT NOT NULL,
    price DOUBLE NOT NULL,
    PRIMARY KEY(vin)
);

CREATE TABLE inventory (
	dealership_id INT NOT NULL,
    vin INT NOT NULL,
    PRIMARY KEY (
		dealership_id,
        vin
	)
);

CREATE TABLE contracts (
	id INT NOT NULL AUTO_INCREMENT,
    contract_type VARCHAR(50) NOT NULL,
    date VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    vin INT NOT NULL,
    total_cost DOUBLE NOT NULL,
    finance BOOLEAN,
    PRIMARY KEY(id)
);

-- insert records
-- populate the dealership table
INSERT INTO dealerships (dealership_id, name, address, phone)
VALUES(555, 'D & B Used Cars', '111 Old Benbrook Rd, Dallas, TX 45137', '817-555-5555'),
	(556, 'New 2 U Cars', '214 Elm Street, Austin, TX 78704', '555-555-0100'),
    (557, 'Car-Rave', '805 Spruce Drive, Seattle, WA 98103', '212-867-5309'),
    (558, 'Vehicool', '1600 Oak Lane, Denver, CO 80202', '704-555-2345')
;
ALTER TABLE dealerships AUTO_INCREMENT 559;

-- populate the vehicles table
INSERT INTO vehicles (vin, year, make, model, vehicle_type, color, odometer, price)
VALUES (10112, 1993, 'Ford', 'Explorer', 'SUV', 'Red', 525123, 995.00),
	(37846, 2001, 'Ford', 'Ranger', 'Truck', 'Yellow', 172544, 1995.00),
    (44901, 2012, 'Honda', 'Civic', 'Sedan', 'Gray', 103221, 6995.00),
    (10101, 2024, 'Bentley', 'Flying Spur', 'Sedan', 'Black', 10000, 220000.00),
	(44444, 2020, 'Lexus', 'LS 500h', 'Sedan', 'Silver', 17590, 109095.00),
    (32213, 2020, 'Maybach', 'S580', 'Sedan', 'Black', 45892, 125000.00),
    (88822, 2008, 'BMW', '328xi', 'Sedan', 'Red', 122024, 11010.00),
	(19194, 2019, 'Toyota', 'Tacoma', 'Truck', 'Black', 170344, 15035.00),
    (25231, 2022, 'Honda', 'Accord', 'Sedan', 'Blue', 12221, 20995.00),
    (12345, 2023, 'Mazda', 'Miata', 'Coupe', 'Silver', 16634, 35999.00)
;

-- populate the inventory table
INSERT INTO inventory (dealership_id, vin)
VALUES (555, 10112),
	(555, 37846),
    (555, 44901),
    (556, 10101),
    (556, 44444),
    (556, 32213),
    (557, 88822),
    (557, 19194),
    (558, 25231),
    (558, 12345)
;

-- populate the lease_contracts table
INSERT INTO lease_contracts (contract_type, date, name, email, vin, total_cost, finance)
VALUES ('SALE', '2024-05-31', 'Syd', 'syd@email.com', 44444, 109095.00*1.15, true),
	('SALE', '2024-05-11', 'Chris', 'christ@email.com', 19194, 14035.00*1.15, true),
	('LEASE', '2024-04-12', 'Phillip', 'phillip@email.com', 12345, 20995.00*1.25, false),
    ('LEASE', '2024-04-02', 'Phillip', 'phillip@email.com', 25231, 20995.00*1.25, false),
    ('SALE', '2024-06-12', 'Anisa', 'anisa@email.com', 10101, 220000.00*1.25, false),
	('LEASE', '2024-06-02', 'Anisa', 'anisa@email.com', 88822, 11010.00*1.25, false)
;

-- create foreign keys
ALTER TABLE lease_contracts
ADD CONSTRAINT fk_lease_contracts
FOREIGN KEY (vin) REFERENCES vehicles (vin);