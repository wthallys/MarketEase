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
  value DOUBLE NOT NULL,
  quantity INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (categoryId) REFERENCES category(id)
);

CREATE TABLE employee (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  cpf VARCHAR(14) NOT NULL,
  age INT NOT NULL,
  role VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE client (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  age INT NOT NULL,
  address VARCHAR(255) NOT NULL,
  debt DOUBLE NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE role (
  id INT NOT NULL AUTO_INCREMENT,
  productId INT NOT NULL,
  employeeId INT NOT NULL,
  quantity INT NOT NULL,
  date TIMESTAMP(3) NOT NULL,
  type ENUM('FIADO', 'IMEDIATO') NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (productId) REFERENCES product(id),
  FOREIGN KEY (employeeId) REFERENCES employee(id)
);

CREATE TABLE purchaseStatement (
  id INT NOT NULL AUTO_INCREMENT,
  clientId INT NOT NULL,
  roleId INT NOT NULL,
  quantity INT NOT NULL,
  amountOwed DOUBLE NOT NULL,
  amountPaid DOUBLE NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (clientId) REFERENCES client(id),
  FOREIGN KEY (roleId) REFERENCES role(id)
);
