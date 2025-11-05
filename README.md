# Imperium API

O **Imperium API** é o backend do sistema **Imperium**, desenvolvido em **Java** com o **Spring Boot**.  
Seu objetivo é fornecer uma **API RESTful estável e segura** para o gerenciamento de **chamados de suporte de TI**, **controle de usuários**, **administração de estoque** e **envio de sugestões de melhoria**.

---

## 🚀 Tecnologias utilizadas
- Java 17+
- Spring Boot
- Maven
- MySQL
- Spring Data JPA
- Spring Web

---

## 🔧 Funcionalidades principais
- Criação e gerenciamento de **chamados de suporte de TI**.  
- Cadastro, autenticação e gerenciamento de **usuários**.  
- Controle de **estoque e recursos de TI**.  
- Envio e administração de **sugestões de melhoria**.  
- Integração com o **frontend** via **API REST**.

---

## ⚙️ Como executar o projeto localmente

### 1. Clonar o repositório
````
git clone https://github.com/lucas-andre-dev/imperium-backend.git
````
### 2. Abrir o projeto

Abra o projeto em uma IDE compatível, como IntelliJ IDEA ou VS Code, de preferência o Intelij.

### 3. Criar o banco de dados MySQL
````
CREATE DATABASE imperium_db;
````
### 4. Configurar o arquivo application.properties
O projeto já está configurado com as dependências do MySQL no Maven.
Caso deseje utilizar outro banco de dados, será necessário substituir a dependência correspondente.

Para isso, procure a dependência oficial do banco desejado no repositório
````
https://mvnrepository.com/


spring.datasource.url=jdbc:mysql://localhost:3306/imperium_db
spring.datasource.username=root      <------------------------------Coloca o usuario do seu banco de dados
spring.datasource.password=sua_senha <----------------------------- Coloca a senha do seu banco de dados
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
````
### 5. Executar o projeto
Se você estiver usando Spring Boot dentro do IntelliJ ou Eclipse, pode rodar direto sem terminal:

Eclipse: botão direito na classe ImperiumApplication → Run As → Spring Boot App

IntelliJ: clique no ícone ▶️ Run ao lado da classe ImperiumApplication.
Alternativamente, você pode executar o projeto pelo terminal da IDE utilizando o comando:
````
mvn spring-boot:run
````
### 6. Adicionar dois usuarios ao banco
````
use imperium_db;

insert into tb_user(id,email,nome,senha,roles)
values(1,"user@user.com","user","123","USER");

insert into tb_user(id,email,nome,senha,roles)
values(2,"admin@admin.com","admin","123","ADMIN");
````
### 7. Acessar a API
````
http://localhost:8080
````
### 8. Baixar o Frontend
Para que o projeto funcione de forma completa será necessário baixar o Frontend dessa aplicação.
para isso baixe no link abaixo:
````
https://github.com/lucas-andre-dev/imperium_front_end
````
### 📜 Licença

Este projeto é de uso interno e educativo.
Distribuição ou reprodução não autorizada sem o devido crédito é proibida.
