# Caso de Teste - Cadastro com o Mesmo Email
**ID:** CT-002
**Título:** Bug ao Permitir Cadastro Múltiplo com o Mesmo Email

## Pré-condições:
- O usuário não está logado no sistema
- O formulário de cadastro está disponível
- O email utilizado para o cadastro não foi previamente bloqueado ou validado para ser único

## Passos:

| Passo | Descrição                                                                                   | Resultado Esperado                                                   |
|-------|---------------------------------------------------------------------------------------------|----------------------------------------------------------------------|
| 1     | Acesse a página de cadastro                                                                  | A página de cadastro é carregada corretamente                        |
| 2     | Insira um endereço de email válido e complete os outros campos obrigatórios (nome, senha, etc.) | O sistema permite o preenchimento do formulário                     |
| 3     | Clique em "Cadastrar"                                                                       | O cadastro é realizado com sucesso |
| 4     | Acesse novamente a página de cadastro                                                      | O formulário de cadastro é exibido novamente                         |
| 5     | Insira o mesmo endereço de email utilizado anteriormente e preencha os outros campos obrigatórios | O sistema permite o envio do formulário novamente sem gerar mensagem de erro sobre duplicidade de email |
| 6     | Clique em "Cadastrar"                                                                       | O cadastro é realizado novamente sem impedir a duplicação do email |

## Evidências
- https://prnt.sc/jd48geU4dnuv
- https://prnt.sc/hgpiHndhSoId
- https://prnt.sc/wbMLENArX1kw
- https://prnt.sc/5u0IS2hk3ddM

## Sistema:
- O Sistema Ambiente: O bug foi encontrado no navegador Google Chrome
  
## Resultado Esperado:
- O sistema não deve permitir que o mesmo endereço de email seja utilizado para o cadastro mais de uma vez. Uma mensagem de erro, como "Este email já está cadastrado", deve ser exibida, impedindo o segundo cadastro com o mesmo email.

## Resultado Atual (Bug):
- O sistema permite o cadastro múltiplo com o mesmo email, sem gerar uma mensagem de erro sobre duplicidade de email, o que pode gerar inconsistências no banco de dados e permitir que dois usuários compartilhem o mesmo email.

## Pós-condições:
- O email está cadastrado duas vezes no sistema, o que pode gerar conflitos ou dados inconsistentes, e o usuário permanece na tela de cadastro ou página inicial.
