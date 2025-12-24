# 📝 Task API – Gerenciador de Tarefas (API REST)

Uma **API RESTful** desenvolvida em **Java com Spring Boot** para gerenciamento de tarefas, seguindo boas práticas de arquitetura, uso de DTOs, tratamento de exceções e organização em camadas.

Projeto ideal para estudo e portfólio, focado na transição de **MVC tradicional para API REST profissional**.

---

##  Funcionalidades

* Criar tarefas
* Listar todas as tarefas
* Buscar tarefa por ID
* Atualizar tarefas
* Excluir tarefas
* Filtrar tarefas por status (ex: **CONCLUÍDA**)

---

## Conceitos aplicados

* Arquitetura em camadas (Controller, Service, Repository)
* API RESTful
* DTOs para entrada e saída de dados
* Mapeamento de entidades com JPA / Hibernate
* Validações com Bean Validation
* Tratamento global de exceções
* Boas práticas de versionamento e organização de código

---

## Tecnologias utilizadas

* **Java 17+**
* **Spring Boot**
* **Spring Data JPA**
* **MySQL**
* **Hibernate**
* **Maven** 
* **OpenApi docs Spring** (testes da API)
* **railway** (Para deploy da API)

---

## Estrutura do projeto

```
com.example.taskapi
│
├── controller
│   └── TaskController.java
│
├── service
│   ├── TaskService.java
│   └── impl
│       └── TaskServiceImpl.java
│
├── repository
│   └── TaskRepository.java
│
├── dto
│   ├── TaskCreateDTO.java
│   ├── TaskUpdateDTO.java
│   ├── TaskResponseDTO.java
│   └── TaskListDTO.java
│
├── model
│   └── Task.java
│
├── exception
│   └── GlobalExceptionHandler.java
│
└── TaskApiApplication.java
```

---

##  Modelo da entidade Task

* **id**
* **title**
* **description**
* **status** (PENDENTE, CONCLUIDA)
* **createdAt**
* **updatedAt**

---

##  Endpoints principais

| Método | Endpoint                  | Descrição                 |
| ------ | ------------------------- | ------------------------- |
| POST   | `/tasks`                  | Criar nova tarefa         |
| GET    | `/tasks`                  | Listar todas as tarefas   |
| GET    | `/tasks/{id}`             | Buscar tarefa por ID      |
| PUT    | `/tasks/{id}`             | Atualizar tarefa          |
| DELETE | `/tasks/{id}`             | Remover tarefa            |
| GET    | `/tasks/status/concluida` | Listar tarefas concluídas |

---

##  Exemplo de requisição (POST)

```json
{
  "title": "Estudar Spring Boot",
  "description": "Criar uma API REST completa",
  "status": "PENDENTE"
}
```

---

##  Exemplo de resposta (Response DTO)

```json
{
  "id": 1,
  "title": "Estudar Spring Boot",
  "description": "Criar uma API REST completa",
  "status": "PENDENTE",
  "createdAt": "2025-12-23T20:10:00"
}
```

---

##  Como executar o projeto

1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/task-api.git
```

2. Configure o banco de dados no `application.yml` ou `application.properties`

3. Execute o projeto

```bash
mvn spring-boot:run
```
ou
Entre nesse link para teste -> https://managementtask-production.up.railway.app/swagger-ui/index.html 
se tiver problema o railway deve ter fechado. 
4. Teste os endpoints via Postman ou Insomnia

---

##  Objetivo do projeto

Este projeto foi desenvolvido com foco em:

* Fixar conceitos de **API REST com Spring Boot**
* Entender a diferença entre **MVC e REST**
* Praticar **DTOs, Services e Repositories**
* Criar um projeto organizado e apresentável para **portfólio**

---

##  Próximas melhorias

*  Autenticação com JWT
*  Paginação e ordenação
*  Testes unitários
*  Documentação com Swagger
*  Integração com front-end (React)

---

##  Autor

**Samuel Duarte Alves**
Estudante de Engenharia de Software | Java | Spring Boot | API REST

---

 Se este projeto te ajudou, deixe uma estrela no repositório!
