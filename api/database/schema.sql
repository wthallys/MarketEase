CREATE DATABASE marketease;

USE marketease;

CREATE TABLE category (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE product (
  id INT NOT NULL AUTO_INCREMENT,
  categoryId INT NOT NULL,
  name VARCHAR(255),
  brand VARCHAR(255) NOT NULL,
  price DOUBLE NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (categoryId) REFERENCES category(id)
);

CREATE TABLE employee (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  cpf VARCHAR(14) NOT NULL,
  role ENUM('GERENTE', 'FUNCIONARIO') NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE customer (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE sale (
  id INT NOT NULL AUTO_INCREMENT,
  employeeId INT NOT NULL,
  customerId INT NOT NULL,
  date TIMESTAMP(3) NOT NULL,
  price DOUBLE NOT NULL,
  type ENUM('FIADO', 'IMEDIATO') NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (employeeId) REFERENCES employee(id),
  FOREIGN KEY (customerId) REFERENCES customer(id)
);

CREATE TABLE purchaseStatement (
  id INT NOT NULL AUTO_INCREMENT,
  saleId INT NOT NULL,
  customerId INT NOT NULL,
  debt DOUBLE NOT NULL,
  amountPaid DOUBLE NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (saleId) REFERENCES sale(id),
  FOREIGN KEY (customerId) REFERENCES customer(id)
);

CREATE TABLE soldProducts (
  id INT NOT NULL AUTO_INCREMENT,
  productId INT NOT NULL,
  saleId INT NOT NULL,
  quantity INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (productId) REFERENCES product(id),
  FOREIGN KEY (saleId) REFERENCES sale(id)
);