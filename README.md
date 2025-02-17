# BugBank - Testes Automatizados com Selenium e Java

Este repositório contém a automação de testes para o sistema **BugBank**, realizado utilizando **Selenium WebDriver** e **Java**. O objetivo do projeto é garantir a qualidade e estabilidade do sistema por meio de testes automatizados de funcionalidades principais, tanto com dados válidos quanto inválidos.

## Tecnologias Utilizadas

- **Selenium WebDriver**: Framework para automação de testes em navegadores.
- **Java**: Linguagem de programação para implementar os testes.
- **JUnit**: Framework de testes para criar, executar e reportar os resultados dos testes.
- **Maven**: Ferramenta de automação para construção de projetos Java.

## Funcionalidades Testadas

Os testes automatizados foram criados para verificar as principais funcionalidades do BugBank, incluindo:

- **Login de usuário**:
  - Verificação de login correto com dados válidos.
  - Verificação de login incorreto com dados inválidos.
  
- **Registro de usuário**:
  - Verificação de registro correto com dados válidos.
  - Verificação de erro ao registrar com dados inválidos (como email inválido ou senhas que não coincidem).
  
- **Transferência entre contas**:
  - Verificação de transferência de valores entre contas com dados válidos.
  - Verificação de erro em transferências com dados inválidos, como número de conta incorreto, dígito errado ou valor inválido (ex: negativo).

## Testes Positivos e Negativos

Os testes automatizados contemplam tanto cenários positivos quanto negativos:

- **Cenários Positivos**: Testes realizados com dados válidos para garantir que as funcionalidades funcionem corretamente.
  - **Login**: Teste de login com email e senha corretos.
  - **Cadastro**: Teste de cadastro com um email válido e senha que atenda aos critérios exigidos.
  - **Transferência**: Teste de transferência com número de conta, dígito e valor válidos.

- **Cenários Negativos**: Testes realizados com dados inválidos para garantir que o sistema seja capaz de lidar com entradas incorretas de maneira adequada.
  - **Login Inválido**: Teste de login com email ou senha incorretos, verificando a exibição de mensagens de erro.
  - **Cadastro Inválido**: Teste de cadastro com email inválido ou senhas que não coincidam, verificando a exibição de erros.
  
## Como Executar os Testes

### Requisitos:

- **Java 11** ou superior.
- **Maven** instalado no seu sistema.
- **Selenium WebDriver** e o driver adequado para o navegador que você está utilizando (ex: Chrome, Firefox, Edge).

### Passos para execução:

1. Clone este repositório:
   ```bash
   git clone https://github.com/GabrielSbruzzi/BugBankTestes.git


## Estrutura do Projeto
```bash
BugBank/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org.example/
│   │           ├── Main.java
│   │               
│   └── test/
│       └── java/
│           ├──  BugBankNTestes.java (Testes com Dados Inválidos)   
│           └──  BugBankTestes.java (Testes com Dados Válidos)   
├── pom.xml                      
└── README.md                 
