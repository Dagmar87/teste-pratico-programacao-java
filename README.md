# Teste Prático de Programação em Java

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-CI-C71A36?style=for-the-badge&logo=apachemaven)

Este projeto resolve um desafio prático de programação em Java, aplicando conceitos de orientação a objetos, manipulação de datas, valores monetários, coleções e streams.

## Objetivo

O programa simula a gestão de uma equipe de funcionários, com operações de cadastro, remoção, cálculo de salário, agrupamento por funções e geração de relatórios com base nos dados informados.

## Requisitos atendidos

| Requisito | Status |
|---|---|
| Cadastro de pessoas com nome e data de nascimento | ✅ |
| Herança com a classe `Funcionario` | ✅ |
| Inserção na ordem da tabela informada | ✅ |
| Remoção do funcionário João | ✅ |
| Formatação de data e salário no padrão brasileiro | ✅ |
| Aplicação de aumento salarial de 10% | ✅ |
| Agrupamento por função | ✅ |
| Identificação de aniversariantes dos meses 10 e 12 | ✅ |
| Cálculo do funcionário com maior idade | ✅ |
| Ordenação alfabética dos nomes | ✅ |
| Cálculo do total dos salários | ✅ |
| Cálculo de salários mínimos por funcionário | ✅ |

## Estrutura do projeto

```text
teste-pratico-programacao-java/
├── pom.xml
├── README.md
├── src/
│   └── main/
│       └── java/
│           └── br/
│               └── com/
│                   └── teste/
│                       ├── Pessoa.java
│                       ├── Funcionario.java
│                       └── Principal.java
└── target/
```

## Como executar

### 1. Clone o projeto

```bash
git clone https://github.com/seu-usuario/teste-pratico-programacao-java.git
cd teste-pratico-programacao-java
```

### 2. Compile e execute

```bash
mvn clean compile
java -cp target/classes br.com.teste.Principal
```

### 3. Executar pela IDE

Importe o projeto como projeto Maven e execute a classe:

`src/main/java/br/com/teste/Principal.java`

## Funcionalidades principais

- Gestão de funcionários com dados pessoais e salarials.
- Aplicação de aumento percentual com precisão monetária via `BigDecimal`.
- Agrupamento por função utilizando `Map` e `Collectors.groupingBy`.
- Consulta de aniversariantes por mês.
- Cálculo de idade com base na data atual.
- Formatação de valores em moeda brasileira.

## Tecnologias utilizadas

- Java 17
- Maven
- `LocalDate`
- `BigDecimal`
- `List`, `Map`, `Comparator`
- Streams e `Collectors`

## Observações

- O cálculo da idade considera a data atual da execução do programa.
- O uso de `BigDecimal` garante precisão em valores financeiros.
- A formatação monetária segue o padrão brasileiro, com separador decimal e milhar.

## Resultado esperado

Ao executar o programa, a aplicação exibe os funcionários cadastrados, o aumento de 10%, a listagem por função, aniversariantes, funcionário mais velho, ordenação alfabética, total salarial e quantidade de salários mínimos para cada colaborador.
