# 🚀 Java Swing CRUD System

<img width="399" height="361" alt="image" src="https://github.com/user-attachments/assets/86682996-6a10-42c0-b6b3-92f724bc662e" />
<img width="556" height="468" alt="image" src="https://github.com/user-attachments/assets/55bba181-c7be-4265-bc22-1bde7f43d2e0" />

Este é um sistema de gerenciamento de usuários (CRUD) desenvolvido em Java utilizando a biblioteca gráfica **Swing**. O projeto conta com um sistema de autenticação seguro, interface intuitiva e persistência de dados em banco de dados MySQL.

## 📋 Funcionalidades

- **Sistema de Login Seguro**: Acesso restrito com criptografia de senhas.
- **Criação de Contas**: Possibilidade de registrar novos operadores diretamente pela tela de login.
- **CRUD Completo de Usuários**: 
  - **C**reate: Cadastro de novos usuários (Nome, Sobrenome, E-mail, Cidade e CPF).
  - **R**ead: Visualização automática da lista de usuários ao abrir o sistema.
  - **U**pdate: Atualização de dados de usuários existentes.
  - **D**elete: Exclusão de registros com confirmação de segurança.
- **Experiência do Usuário (UX)**: 
  - Suporte total ao botão **Enter** para agilizar o login e cadastros.
  - Carregamento automático de dados na inicialização.

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java 
- **Interface Gráfica**: Java Swing (JFrame)
- **Banco de Dados**: MySQL
- **Persistência**: DAO (Data Access Object)
- **Criptografia**: SHA-256 (Criptografia de via única para senhas)
- **IDE**: NetBeans

## ⚙️ Como Configurar o Projeto

### 1. Requisitos
- JDK 21 ou superior (Ajuste a versão nas propriedades do projeto se necessário).
- MySQL Server.
- Driver JDBC do MySQL (`mysql-connector-j`).

### 2. Banco de Dados
Execute os comandos SQL abaixo para criar a estrutura necessária:

```sql
CREATE DATABASE sistema_crud;
USE sistema_crud;

-- Tabela de Usuários (Clientes)
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    sobrenome VARCHAR(100),
    email VARCHAR(100),
    cidade VARCHAR(100),
    cpf VARCHAR(20)
);

-- Tabela de Autenticação (Operadores)
CREATE TABLE logins (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);
```sql


3. Conexão
Certifique-se de configurar as credenciais do seu banco de dados na classe DBConnection.java.

🚀 Como Executar
Clone o repositório.

Abra o projeto no NetBeans.

Caso encontre o erro UnsupportedClassVersionError, clique com o botão direito no projeto -> Propriedades -> Sources e mude o Binary Format para o JDK da sua máquina.

Execute Limpar e Construir (ícone da vassoura).

Inicie pela classe Login.java.

📂 Estrutura de Pastas
src/model: Classes de entidade (Usuario.java).

src/dao: Classes de acesso a dados (UsuarioDAO.java, LoginDAO.java).

src/view: Telas da interface gráfica (Login.java, Cadastro.java).

src/controller: Lógica de conexão e utilitários de criptografia.

Desenvolvido por Luís Guilherme 👨‍💻


---

### Dicas para tornar o README ainda melhor:
1. **Screenshots**: Tire prints da sua tela de Login e da tela de Cadastro e coloque-os na pasta do projeto. No Markdown, você pode exibi-los usando `![Nome](caminho/da/imagem.png)`.
2. **Badges**: Você pode adicionar badges no topo (como versão do Java ou status do build) usando o site [Shields.io](https://shields.io/).
3. **Licença**: Se for subir para o GitHub, lembre-se de escolher uma licença (como a MIT) para que outros saibam como podem usar seu código.

O que achou desta estrutura? Se quiser mudar algum tópico ou adicionar mais detalhes técn
