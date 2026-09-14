package br.com.teste;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {

    private static final DateTimeFormatter DATA_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

    public static void main(String[] args) {

        // 3.1 - Inserir todos os funcionários na mesma ordem da tabela.
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria",
                LocalDate.parse("18/10/2000", DATA_FORMATTER),
                new BigDecimal("2009.44"), "Operador"));

        funcionarios.add(new Funcionario("João",
                LocalDate.parse("12/05/1990", DATA_FORMATTER),
                new BigDecimal("2284.38"), "Operador"));

        funcionarios.add(new Funcionario("Caio",
                LocalDate.parse("02/05/1961", DATA_FORMATTER),
                new BigDecimal("9836.14"), "Coordenador"));

        funcionarios.add(new Funcionario("Miguel",
                LocalDate.parse("14/10/1988", DATA_FORMATTER),
                new BigDecimal("19119.88"), "Diretor"));

        funcionarios.add(new Funcionario("Alice",
                LocalDate.parse("05/01/1995", DATA_FORMATTER),
                new BigDecimal("2234.68"), "Recepcionista"));

        funcionarios.add(new Funcionario("Heitor",
                LocalDate.parse("19/11/1999", DATA_FORMATTER),
                new BigDecimal("1582.72"), "Operador"));

        funcionarios.add(new Funcionario("Arthur",
                LocalDate.parse("31/03/1993", DATA_FORMATTER),
                new BigDecimal("4071.84"), "Contador"));

        funcionarios.add(new Funcionario("Laura",
                LocalDate.parse("08/07/1994", DATA_FORMATTER),
                new BigDecimal("3017.45"), "Gerente"));

        funcionarios.add(new Funcionario("Heloísa",
                LocalDate.parse("24/05/2003", DATA_FORMATTER),
                new BigDecimal("1606.85"), "Eletricista"));

        funcionarios.add(new Funcionario("Helena",
                LocalDate.parse("02/09/1996", DATA_FORMATTER),
                new BigDecimal("2799.93"), "Gerente"));

        // 3.2 - Remover João.
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase("João"));

        // 3.3 - Imprimir funcionários.
        System.out.println("=== 3.3 - FUNCIONÁRIOS ===");
        funcionarios.forEach(System.out::println);

        // 3.4 - Aplicar aumento de 10%.
        funcionarios.forEach(f -> f.aplicarAumento(new BigDecimal("10")));

        System.out.println("\n=== 3.4 - APÓS AUMENTO DE 10% ===");
        funcionarios.forEach(System.out::println);

        // 3.5 - Agrupar por função.
        Map<String, List<Funcionario>> funcionariosPorFuncao =
                funcionarios.stream()
                        .collect(Collectors.groupingBy(
                                Funcionario::getFuncao,
                                LinkedHashMap::new,
                                Collectors.toList()
                        ));

        // 3.6 - Imprimir agrupados por função.
        System.out.println("\n=== 3.6 - AGRUPADOS POR FUNÇÃO ===");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(f -> System.out.println("  " + f));
        });

        // 3.8 - Aniversariantes dos meses 10 e 12.
        System.out.println("\n=== 3.8 - ANIVERSARIANTES DOS MESES 10 E 12 ===");
        funcionarios.stream()
                .filter(f -> {
                    int mes = f.getDataNascimento().getMonthValue();
                    return mes == 10 || mes == 12;
                })
                .forEach(System.out::println);

        // 3.9 - Funcionário com maior idade.
        Funcionario maisVelho = funcionarios.stream()
                .max(Comparator.comparing(Funcionario::getDataNascimento))
                .orElseThrow();

        System.out.println("\n=== 3.9 - FUNCIONÁRIO COM MAIOR IDADE ===");
        System.out.println("Nome: " + maisVelho.getNome());
        System.out.println("Idade: " + maisVelho.getIdade());

        // 3.10 - Ordem alfabética.
        System.out.println("\n=== 3.10 - ORDEM ALFABÉTICA ===");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome,
                        String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);

        // 3.11 - Total dos salários após o aumento.
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("\n=== 3.11 - TOTAL DOS SALÁRIOS ===");
        System.out.println(formatarMoeda(totalSalarios));

        // 3.12 - Quantidade de salários mínimos de cada funcionário.
        System.out.println("\n=== 3.12 - SALÁRIOS MÍNIMOS POR FUNCIONÁRIO ===");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome,
                        String.CASE_INSENSITIVE_ORDER))
                .forEach(f -> {
                    BigDecimal quantidade = f.getSalario()
                            .divide(SALARIO_MINIMO, 2, RoundingMode.HALF_UP);
                    System.out.println(f.getNome() + ": "
                            + quantidade.toPlainString()
                            + " salários mínimos");
                });
    }

    public static String formatarMoeda(BigDecimal valor) {
        NumberFormat formato = NumberFormat.getNumberInstance(
                Locale.of("pt", "BR")
        );
        formato.setMinimumFractionDigits(2);
        formato.setMaximumFractionDigits(2);
        return formato.format(valor);
    }
}
