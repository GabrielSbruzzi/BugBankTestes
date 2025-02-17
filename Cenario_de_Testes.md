# Cenário de Testes do BugBank

Este documento descreve os cenários de teste para o site "BugBank", utilizando o padrão BDD (Behavior-Driven Development). Os testes cobrem as funcionalidades essenciais do sistema.

## Cenários de Teste

### 1. Registro de Conta

#### Cenário: Registrar uma nova conta com sucesso
```gherkin
Funcionalidade: Registro de conta no BugBank

  Cenário: Registrar uma nova conta com sucesso
    Dado que eu esteja na página de registro
    Quando eu preencher os campos "E-mail", "Nome", "Senha" e "Confirmar Senha"
    E clicar no botão "Cadastrar"
    Então minha conta deve ser criada com sucesso
```

#### Cenário: Tentar registrar uma conta com senhas que não coincidem
```gherkin
Funcionalidade: Registro de conta no BugBank

  Cenário: Registrar uma conta com senhas que não coincidem
    Dado que eu esteja na página de registro
    Quando eu preencher o campo "Senha" com um valor
    E o campo "Confirmar Senha" com um valor diferente
    E clicar no botão "Cadastrar"
    Então uma mensagem de erro deve ser exibida informando que as senhas não coincidem
```

### 2. Login de Usuário

#### Cenário: Realizar login com dados válidos
```gherkin
Funcionalidade: Login de usuário no BugBank

  Cenário: Realizar login com dados válidos
    Dado que eu tenha uma conta registrada
    Quando eu preencher os campos "E-mail" e "Senha" com dados válidos
    E clicar no botão "Acessar"
    Então eu devo ser redirecionado para a página inicial do site
```

#### Cenário: Tentar fazer login com dados inválidos
```gherkin
Funcionalidade: Login de usuário no BugBank

  Cenário: Tentar fazer login com dados inválidos
    Dado que eu tenha uma conta registrada
    Quando eu preencher o campo "E-mail" com um e-mail inválido
    Ou preencher o campo "Senha" com uma senha incorreta
    E clicar no botão "Acessar"
    Então uma mensagem de erro deve ser exibida informando que as credenciais são inválidas
```

### 3. Transferência de Dinheiro

#### Cenário: Realizar uma transferência de dinheiro com sucesso
```gherkin
Funcionalidade: Transferir dinheiro entre contas no BugBank

  Cenário: Realizar uma transferência de dinheiro com sucesso
    Dado que eu tenha uma conta com saldo disponível
    E que eu tenha uma conta de destino para a transferência
    Quando eu preencher os campos "Valor" e "Conta de Destino" com informações válidas
    E clicar no botão "Transferir"
    Então a transferência deve ser realizada com sucesso
```

#### Cenário: Tentar realizar uma transferência com saldo insuficiente
```gherkin
Funcionalidade: Transferir dinheiro entre contas no BugBank

  Cenário: Tentar realizar uma transferência com saldo insuficiente
    Dado que eu tenha uma conta com saldo insuficiente
    Quando eu tentar transferir um valor maior que o saldo disponível
    Então uma mensagem de erro deve ser exibida informando que o saldo é insuficiente
```

### 4. Pagamento

#### Cenário: Realizar um pagamento com sucesso
```gherkin
Funcionalidade: Realizar pagamento no BugBank

  Cenário: Realizar um pagamento com sucesso
    Dado que eu tenha uma conta com saldo disponível
    E que eu tenha uma conta de destino para o pagamento
    Quando eu preencher os campos "Valor" e "Conta de Destino" com informações válidas para pagamento
    E clicar no botão "Pagar"
    Então o pagamento deve ser realizado com sucesso
```

#### Cenário: Tentar realizar um pagamento com saldo insuficiente
```gherkin
Funcionalidade: Realizar pagamento no BugBank

  Cenário: Tentar realizar um pagamento com saldo insuficiente
    Dado que eu tenha uma conta com saldo insuficiente
    Quando eu tentar realizar um pagamento com valor maior que o saldo disponível
    Então uma mensagem de erro deve ser exibida informando que o saldo é insuficiente
```

### 5. Verificação de Saldo

#### Cenário: Verificar o saldo da minha conta
```gherkin
Funcionalidade: Verificação de saldo no BugBank

  Cenário: Verificar o saldo da minha conta
    Dado que eu tenha uma conta com saldo disponível
    Quando eu acessar a página inicial
    Então o saldo da minha conta deve ser exibido corretamente na interface
```

### 6. Logout

#### Cenário: Realizar logout com sucesso
```gherkin
Funcionalidade: Logout no BugBank

  Cenário: Realizar logout com sucesso
    Dado que eu esteja logado no BugBank
    Quando eu clicar no botão "Logout"
    Então eu devo ser redirecionado para a página de login
```

### 7. Navegação entre Páginas

#### Cenário: Navegar de uma página para outra sem erros
```gherkin
Funcionalidade: Navegação entre páginas no BugBank

  Cenário: Navegar de uma página para outra sem erros
    Dado que eu esteja na página principal
    Quando eu clicar no link de navegação para "Registrar"
    Então eu devo ser redirecionado para a página de registro
```

### 8. Saque

#### Cenário: Clicar na opção "Saque" e exibir mensagem de desenvolvimento
```gherkin
Funcionalidade: Saque no BugBank

  Cenário: Clicar na opção "Saque" e exibir mensagem de desenvolvimento
    Dado que eu esteja logado no BugBank
    Quando eu clicar no menu "Saque"
    Então uma modal deve ser exibida com a mensagem "Funcionalidade em desenvolvimento."
```

### 9. Extrato de Conta

#### Cenário: Acessar o extrato de conta com sucesso
```gherkin
Funcionalidade: Extrato de conta no BugBank

  Cenário: Acessar o extrato de conta com sucesso
    Dado que eu esteja logado no BugBank
    E que eu tenha realizado transações na minha conta
    Quando eu acessar a página de extrato
    Então o extrato de conta deve ser exibido corretamente, mostrando todas as transações realizadas, com valores, datas e saldo atualizado
```

#### Cenário: Acessar o extrato de conta sem transações
```gherkin
Funcionalidade: Extrato de conta no BugBank

  Cenário: Acessar o extrato de conta sem transações
    Dado que eu esteja logado no BugBank
    E que não tenha realizado transações na minha conta
    Quando eu acessar a página de extrato
    Então o sistema deve exibir uma mensagem indicando que não há transações ou o extrato estará vazio
```

#### Cenário: Tentar acessar o extrato com erro no carregamento
```gherkin
Funcionalidade: Extrato de conta no BugBank

  Cenário: Tentar acessar o extrato com erro no carregamento
    Dado que eu esteja logado no BugBank
    Quando houver um erro ao carregar o extrato
    Então o sistema deve exibir uma mensagem de erro indicando que houve uma falha ao carregar o extrato, com a opção de tentar novamente
```
