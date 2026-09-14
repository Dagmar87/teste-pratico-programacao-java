package br.com.teste;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento,
                       BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void aplicarAumento(BigDecimal percentual) {
        BigDecimal fator = BigDecimal.ONE.add(
                percentual.divide(
                        BigDecimal.valueOf(100),
                        10,
                        RoundingMode.HALF_UP
                )
        );

        salario = salario
                .multiply(fator)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public int getIdade() {
        return Period.between(
                getDataNascimento(),
                LocalDate.now()
        ).getYears();
    }

    @Override
    public String toString() {
        return "Nome: " + getNome()
                + " | Nascimento: " + getDataNascimentoFormatada()
                + " | Salário: " + Principal.formatarMoeda(salario)
                + " | Função: " + funcao;
    }
}