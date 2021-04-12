# Buser APP

## Como rodar

Todos esses passos podem ser executados diretamente da IDE que esta sendo utilizada. A IDE utilizada para 
desenvolvimento foi IntelliJ da JetBrains.

### Requisitos

Esse projeto foi desenvolvido com o auxilio do framework springboot, e para inserção dos requisitos foi usado
meaven, então para roda-lo é necessário ter instalado meaven. Ele também foi desenvolvido em máquinas UBUNTU
20.04. A instalação do meaven no UBUNTU pode ser feita como segue:

```bash
sudo apt install meaven
```

E no windows: https://www.educba.com/install-maven/

### Testes

Roda todos os testes:
```bash
mvn test
```

Os testes também podem ser rodados diretamente da IDE.

### Development Derver

```bash
mvn spring-boot:run
```

Então o projeto estará rodando em localhost:8080

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
