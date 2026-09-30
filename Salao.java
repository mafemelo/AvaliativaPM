/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avaliativapm;

/**
 *
 * @author 1635579
 */
import java.util.ArrayList;
import java.util.List;
public class Salao {
    private int numero;
    private int capacidadeMaximaPessoas;
    private String localizacao;
    private String tipoSalao;
    private Organizador organizadorResponsavel;
    private List<Reserva> reserva;

    public Salao(int numero, String tipoSalao, int capacidadeMaximaPessoas, String localizacao) {
        this.numero = numero;
        this.tipoSalao = tipoSalao;
        this.capacidadeMaximaPessoas = capacidadeMaximaPessoas;
        this.localizacao = localizacao;
        this.reserva = new ArrayList<>();
    }

    public int getNumero() { return numero; }
    public String getTipoSalao() { return tipoSalao; }
    public int getcapacidadeMaximaPessoas() { return capacidadeMaximaPessoas; }
    public String getLocalizacao() { return localizacao; }
    public Organizador getMecanicoResponsavel() { return organizadorResponsavel; }
    public List<Reserva> getReservas() { return reserva; }

    public boolean possuiCapacidade() {
        return reserva.size() < capacidadeMaximaPessoas;
    }

    public boolean podeConfirmar(Reserva reserva) {
        return possuiCapacidade()
                && reserva.getReservas().getCategoria().equalsIgnoreCase(tipoSalao);
    }

    public boolean adicionarOrdem(Reserva reserva) {
        if (!podeConfirmar(reserva)) {
            return false;
        }
        reserva.add(reserva);
        reserva.setSalao(this);
        return true;
    }

    public void definirOrganizador(Organizador organizador) {
        this.organizadorResponsavel = organizador;
    }

    public int reservasFinalizadas() {
        int total = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getStatus().equalsIgnoreCase("finalizada")) {
                total++;
            }
        }
        return total;
    }

    @Override
    public String toString() {
        String organizador = organizadorResponsavel == null ? "Nenhum" : organizadorResponsavel.getNome();
        return "Salao " + numero + "Tipo: " + tipoSalao
                + "Capacidade: " + capacidadeMaximaPessoas
                + "Localização: " + localizacao
                + "Organizador: " + organizador;
    }
}

