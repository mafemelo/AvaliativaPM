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

public class Empresa {
    private List<Organizador> organizadores;
    private List<Salao> saloes;
    private List<Reserva> reservas;

    public Empresa() {
        organizadores = new ArrayList<>();
        saloes = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void adicionarOrganizador(Organizador organizador) {
        organizadores.add(organizador);
    }

    public void adicionarSalao(Salao salao) {
        saloes.add(salao);
    }

    public void cadastrarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public Organizador buscarOrganizadorPorCpf(String cpf) {
        for (Organizador organizador : organizadores) {
            if (organizador.getCpf().equals(cpf)) {
                return organizador;
            }
        }
        return null;
    }

    public Salao buscarSalao(int numero) {
        for (Salao salao : saloes) {
            if (salao.getNumero() == numero) {
                return salao;
            }
        }
        return null;
    }

    public Reserva buscarReserva(int codigo) {
        for (Reserva reserva : reservas) {
            if (ordem.getCodigo() == codigo) {
                return reserva;
            }
        }
        return null;
    }

    public boolean associarOrganizador(Organizador organizador, Salao salao) {
        if (organizador == null || salao == null) {
            return false;
        }

        if (organizador.possuiSalao()) {
            return false;
        }

        if (salao.getOrganizadorResponsavel() != null) {
            return false;
        }

        organizador.definirSalaoResponsavel(salao);
        salao.definirOrganizador(organizador);
        return true;
    }

    public boolean atribuirReservaSalao(Reserva reserva, Salao salao) {
        if (reserva == null || salao == null) {
            return false;
        }

        if (!reserva.getStatus().equalsIgnoreCase("aberta") &&
                !reserva.getStatus().equalsIgnoreCase("acontecendo")) {
            return false;
        }

        return salao.adicionarReserva(reserva);
    }

    public List<Reserva> buscarPorStatus(String status) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getStatus().equalsIgnoreCase(status)) {
                resultado.add(reservas);
            }
        }
        return resultado;
    }

    public List<Organizador> getOrganizadores() { return organizadores; }
    public List<Salao> getSaloes() { return saloes; }
    public List<Reserva> getReservas() { return reservas; }
}

