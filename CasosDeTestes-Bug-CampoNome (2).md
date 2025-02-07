# Caso de Teste - Bug no Nome do Campo "É Campo Obrigatório"
**ID:** CT-001
**Título:** Bug ao Tentar Submeter o Formulário com Campos Obrigatórios Vazios

## Pré-condições:
- O usuário está na página de cadastro ou login
- O formulário possui campos obrigatórios (como email, nome, senha)

## Passos:

| Passo | Descrição                                                                                   | Resultado Esperado                                                   |
|-------|---------------------------------------------------------------------------------------------|----------------------------------------------------------------------|
| 1     | Acesse a página de cadastro ou login                                                        | A página é carregada corretamente                                    |
| 2     | Tente enviar o formulário sem preencher os campos obrigatórios (como email, nome, senha)    | A mensagem de erro "É campo obrigatório" aparece ao lado do campo vazio |
| 3     | Verifique se a mensagem de erro "É campo obrigatório" aparece corretamente para todos os campos obrigatórios | A mensagem "É campo obrigatório" aparece corretamente ao lado de cada campo vazio |

## Evidências: 
- https://prnt.sc/5CzU_lAlM5Ff

## Sistema:
- O bug foi encontrado no navegador Microsoft Edge

## Resultado Esperado:
- Quando o formulário for enviado sem preencher os campos obrigatórios, a mensagem de erro "É campo obrigatório" deve ser exibida de forma clara ao lado de cada campo obrigatório vazio.

## Resultado Atual (Bug):
- A mensagem de erro "É campo obrigatório" não aparece corretamente no campo Nome.
## Pós-condições:
- O usuário permanece na página de cadastro ou login, com os campos obrigatórios vazios e a mensagem de erro visível.
