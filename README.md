# Projeto Capag

Este projeto é uma aplicação Spring Boot que expõe APIs para consultar dados de CAPAG (Capacidade de Pagamento) e população do IBGE.

## Mas por que isso existe?

No meu emprego eu preciso constantemente consultar esses dados, mas tanto a api do capag quando do IBGE não são legais de trabalhar, 
logo decidi cuidar do problema com as minhas próprias mãos, e criar uma API rest usando os dados públicos disponíveis.

### Mas por que Spring?

Honestamente, por aprendizado. Eu entendo que Spring é uma tecnologia incrível, ótima para fazer aplicações enterprise, resilientes, escaláveis e seguras,
mas esse não era meu objetivo, ainda assim, sai da minha zona de conforto e aprendi bastante sobre o ecossistema Spring.

## Tecnologias Utilizadas

*   Java 21
*   Spring Boot 3.5.0
*   Spring Data JPA
*   PostgreSQL
*   Lombok
*   Gradle

## Como Executar

1.  **Inicie o banco de dados PostgreSQL usando Docker:**
    ```bash
    docker-compose up -d
    ```

2.  **Importe os dados do IBGE e CAPAG:**
    Execute as seguintes tarefas Gradle para popular o banco de dados com os dados dos arquivos `ibge-pop.csv` e `capag.csv`.

    Para importar os dados do IBGE:
    ```bash
    ./gradlew importIbge
    ```

    Para importar os dados do CAPAG:
    ```bash
    ./gradlew importCapag
    ```

3.  **Inicie a aplicação Spring Boot:**
    ```bash
    ./gradlew bootRun
    ```

## Endpoints da API

A aplicação expõe os seguintes endpoints:

### CAPAG

*   `GET /capag`: Retorna uma lista de registros CAPAG. Você pode filtrar os resultados passando parâmetros de consulta que correspondem aos campos da entidade `Capag`.
    *   Exemplo: `GET /capag?uf=SP&nome_ente=São Paulo`

### População IBGE

*   `GET /population`: Retorna uma lista de registros de população. Você pode filtrar os resultados passando parâmetros de consulta que correspondem aos campos da entidade `Population`.
    *   Exemplo: `GET /population?uf=RJ`
*   `GET /population/recent/year`: Retorna o ano mais recente para o qual há dados de população disponíveis.

