# Tech-Challenge - FIAP

## Pré-requisitos

- Java 17
- Maven
- Docker
- Docker Compose

## Configuração

1. Clone o repositório:
    ```sh
    git clone https://github.com/ricardo-oamaro/tech-challenge-fiap.git
    cd TechChallenge
    ```

2. Construa o projeto com Maven:
    ```sh
    mvn clean install
    ```

3. Construa e inicie os containers Docker:
    ```sh
    docker-compose up --build 
    ```
   OU
   ```sh
    docker-compose up --d 
    ```

## Execução

1. Para executar a aplicação, use o comando:
    ```sh
    mvn spring-boot:run
    ```

2. A aplicação estará disponível na porta `9090`

## Portas

- **API local**: `9090`
- **Banco de Dados (MySQL)**: `3307`

## Acesso ao BD

1. Pode ser utilizado o DBeaver ou qualquer outra ferramenta de sua preferência.
2. Utilize as credenciais localizadas no arquivo application.properties

## Endpoints

- `GET http://localhost:9090/api/dono-restaurante/ids`: Lista todos os donos de restaurante ordenados pelo ID de forma crescente.
- `GET http://localhost:9090/api/dono-restaurante/nome/{nome}`: Busca o dono do restaurante pelo nome desejado.
- `GET http://localhost:9090/api/dono-restaurante/nomes`: Lista todos os donos de restaurante ordenados pelo nome de forma crescente.
- `GET http://localhost:9090/api/dono-restaurante/email/{email}`: Busca o dono do restaurante pelo e-mail desejado.
- `GET http://localhost:9090/api/dono-restaurante/emails`: Lista todos os donos de restaurante ordenados por e-mail de forma crescente.
- `GET http://localhost:9090/api/dono-restaurante/endereco/{endereco}`: Busca o dono do restaurante pelo endereço desejado.
- `GET http://localhost:9090/api/dono-restaurante/enderecos`: Lista todos os donos de restaurante ordenados pelo endereço de forma crescente.
- `GET http://localhost:9090/api/dono-restaurante/data-ultima-alteracao`: Lista todos os donos de restaurante ordenados pela data de alteração forma crescente.
- `POST http://localhost:9090/api/dono-restaurante`: Cria um novo dono de restaurante.
- `PUT http://localhost:9090/api/dono-restaurante/{id}`: Atualiza um dono de restaurante existente informando o ID. Mas, os campos atualizados serão somente os campos informados na requisição.
- `DELETE http://localhost:9090/api/dono-restaurante/{id}`: Exclui um dono de restaurante.

## Tecnologias utilizadas

- Java
- Spring Boot
- Maven
- Docker
- MySQL