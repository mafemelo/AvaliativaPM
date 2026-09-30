/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avaliativapm;

/**
 *
 * @author 1635579
 */
public class Organizador {
    private String nome;
    private String cpf;
    private String areadeatuacao;
    private String telefone;
    private Salao salaoResponsavel;

    public Organizador(String nome, String cpf, String areadeatuacao, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.areadeatuacao = areadeatuacao;
        this.telefone = telefone;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getAreadeatuacao() { return areadeatuacao; }
    public String getTelefone() { return telefone; }
    public Salao getSalaoResponsavel() { return salaoResponsavel; }

    public boolean possuiSalao() { return salaoResponsavel != null; }

    public void definirSalaoResponsavel(Salao salao) {
        this.salaoResponsavel = salao;
    }

    @Override
    public String toString() {
        return "Organizador: " + nome + " | CPF: " + cpf + " | Área de atuação: " + areadeatuacao + " | Telefone: " + telefone;
    }
}

