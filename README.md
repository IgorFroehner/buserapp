# Buser APP

## Regras de Negócio\Funcionalidades Criticas
* Usuários devem poder se cadastrar no aplicativo.
* Empresas devem poder se cadastrar no aplicativo.
* Empresas devem poder se cadastrar, alterar, excluir e consultar suas linhas.
* Empresas devem poder cadastrar, alterar, excluir e consultar seus ônibus.
* Empresas com reviews ruins podem ser banidas do aplicativo.
* Usuários devem poder consultar as linhas disponíveis.
* Usuários devem poder visualizar detalhes da linha, como empresa, veículo e motorista.
* Usuários devem poder cadastrar o cartão de crédito/débito no aplicativo.
* Usuários devem poder classificar as empresas com notas de 1 a 5 e deixar comentários.

## Entidades

Pensei em cliente pra poder mudar o nome de usuario, já que a diferenca entre eles é só cpf ou cnpj.

* Cliente:
    * id
    * nome
    * cpf
    * email
    * senha

Da pra pensar da empresa extender usuario mesmo, desse jeito só é estranho pq usuario
é uma entidade

* Empresa:
    * id
    * nome
    * cnpj
    * email
    * senha

* Veiculo:
    * id
    * numeroChassi
    * empresa
    * dataUltimaRevisao

* Linha:
    * id
    * titulo
    * numeroParadas
    * enderecosParadas
    * horarioInicio
    * horarioFim
    * empresa
    * preco
    * veiculos

* Review:
    * usuario
    * empresa
    * feedback
    * nota

Mapa n sei oq faz

## Anotações para implementação

### data.sql na pasta resources é um sql que é rodado toda a vez que roda
