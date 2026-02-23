# 🏥 Sistema de Gestão de Pacientes e Exames

Sistema web desenvolvido em **Java 8**, utilizando **Servlets e JDBC**, para gerenciamento de pacientes e seus exames médicos.

---

## 🚀 Tecnologias Utilizadas

- **Linguagem:** Java 8  
- **Servidor de Aplicação:** Apache Tomcat  
- Java Servlets  
- JSP  
- JDBC  
- HTML5 + CSS3 + Bootstrap  
- Banco de Dados Relacional  PostgreSQL

---

## 🏗 Arquitetura

O projeto segue uma organização em camadas:

controller/ → Servlets (camada de entrada)
service/ → Regras de negócio
dao/ → Acesso ao banco via JDBC
model/ → Entidades do sistema
webapp/ → JSP, HTML e arquivos estáticos


### 🔄 Fluxo da Requisição
Cliente → Servlet → Service → DAO → Banco de Dados

---

## 📋 Funcionalidades (em desenvolvimento)
- ✅ Listagem de pacientes

---

## 🗄 Modelagem do Banco de Dados

### 📌 Diagrama ER 

```mermaid
erDiagram
    PACIENTE ||--o{ EXAME : possui

    PACIENTE {
        int id
        string nome
        string cpf
        date data_nascimento
    }

    EXAME {
        int id
        string tipo
        string descricao
        date data_exame
        int paciente_id
    }
