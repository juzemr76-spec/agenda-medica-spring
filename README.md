# Agenda Médica - Spring Boot

Protótipo baseado nas telas enviadas: login, gerenciamento de consultas,
cancelamento e remarcação usando horários disponíveis.

## Tecnologias

- Java 17
- Spring Boot
- Spring MVC
- Thymeleaf
- Spring Data JPA
- H2 Database
- HTML, CSS e JavaScript

## Como abrir no VS Code

1. Instale o Java JDK 17.
2. Instale o VS Code.
3. No VS Code, instale:
   - Extension Pack for Java
   - Spring Boot Extension Pack
4. Abra a pasta `agenda-medica-spring`.
5. Abra `AgendaMedicaApplication.java`.
6. Clique em **Run**.

Também pode executar pelo terminal:

```bash
mvn spring-boot:run
```

Depois abra no navegador:

http://localhost:8080

## Login de teste

- Usuário: `juzem`
- Senha: `1234`

## Banco H2

Os dados ficam salvos em `./data/agendamedica`.

Console:
http://localhost:8080/h2-console

Configuração:
- JDBC URL: `jdbc:h2:file:./data/agendamedica`
- User: `sa`
- Password: deixe em branco

## O que já funciona

- Login
- Lista de consultas
- Visualização dos detalhes da consulta
- Cancelamento
- Tela de horários disponíveis
- Remarcação de consulta
- Persistência em banco de dados H2

## Próximas melhorias recomendadas

- Cadastro real de usuário
- Recuperação de senha
- Criptografia de senha com Spring Security
- Cadastro de médicos
- Cadastro de novos horários
- Agendamento de nova consulta
- Perfil do usuário
- Validação de conflito de horários
- Painel administrativo
- Banco MySQL/PostgreSQL para produção
