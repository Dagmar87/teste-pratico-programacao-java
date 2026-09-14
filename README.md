# Teste Prático de Programação - Java

Implementação dos requisitos solicitados utilizando Java 17, `LocalDate`,
`BigDecimal`, coleções, streams e `Map`.

## Como executar

### Maven
```bash
mvn clean compile
java -cp target/classes br.com.teste.Principal
```

### IDE
Importe o projeto como projeto Maven e execute:
`src/main/java/br/com/teste/Principal.java`

## Requisitos implementados

- Pessoa com nome e data de nascimento.
- Funcionário herdando de Pessoa.
- Cadastro na ordem da tabela.
- Remoção de João.
- Formatação de data e salário no padrão brasileiro.
- Aumento de 10%.
- Agrupamento por função.
- Aniversariantes dos meses 10 e 12.
- Funcionário de maior idade.
- Ordem alfabética.
- Total dos salários.
- Quantidade de salários mínimos (R$ 1.212,00).

O cálculo de idade considera a data atual da execução.
