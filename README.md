# Gestão Acadêmica - API Spring Boot

API simples para gerenciamento de **alunos, professores, disciplinas e faltas**, feita com **Spring Boot + MySQL**.

## ✔️ Funcionalidades
- Cadastro de Professores  
- Cadastro de Alunos  
- Cadastro de Disciplinas  
- Registro de Faltas  
- Justificativa de Faltas  
- Testes unitários básicos  

---

## 🚀 Tecnologias
- Java 17  
- Spring Boot 3  
- Spring Web  
- Spring Data JPA  
- MySQL  
- Docker  
- JUnit 5  

---

## 🗄️ Banco de Dados (MySQL)

Configuração utilizada no projeto (`application.properties`):
spring.datasource.url=jdbc:mysql://localhost:3306/gestao?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update

---

🐳 Subindo o MySQL com Docker
Para iniciar o banco:
docker-compose up -d

---

▶️ Como rodar a API
mvn spring-boot:run

---

🌐 Endpoints Principais

Professores
POST /professores
GET  /professores

Alunos
POST /alunos
GET  /alunos

Disciplinas
POST /disciplinas
GET  /disciplinas

Faltas
POST /faltas
POST /faltas/justificar

🧪 Testes
Para rodar os testes:
mvn test

 -Projeto desenvolvido por Laura Matos para fins acadêmicos.
