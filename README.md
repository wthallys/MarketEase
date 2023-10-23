# Rotas

## /employee
### Tipo: POST
### Parâmetros:
- name (string)
- cpf (string)

### Descrição
Irá cadastrar um novo funcionário.

## /login 
### Tipo: POST
### Parâmetros:
- cpf (string)

#### Descrição:
Irá retornar true ou false, pra verificar se o CPF existe.

## /category
### Tipo: POST
### Parâmetros
- name (string)

### Descrição:
Irá cadastrar uma nova categoria de produtos.

## /product
### Tipo: POST
### Parâmetros: 
- name (string)
- price (number)
- brand (string)
- categoryId (id externo)

### Descrição:
Irá cadastrar um novo produto

## /product
### Tipo: GET
### Parâmetros: 
- id (id)

### Descrição:
Irá retornar um produto específico

## /customer
### Tipo: POST
### Parâmetros:
- name (string)
- cpf (string)
- address (string)

### Descrição
Irá cadastrar um novo cliente.