/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avaliativapm;

/**
 *
 * @author 1635579
 */
public class Reserva {
    private int codigo;
    private String nomeCliente;
    private String data;
    private String horario;
    private String qtconvidados;
    private String status;
    private double valorTotal;
    private Salao salao;

    public Reserva(int codigo, String nomeCliente,String data,String horario, String status,String qtconvidados, double valorTotal) {
        this.codigo = codigo;
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.horario = horario;
        this.qtconvidados = qtconvidados;
        this.status = status;
        this.valorTotal = valorTotal;
    }

    public int getCodigo() { return codigo; }
    public String getNomeCliente() { return nomeCliente; }
    public String getData() { return data; }
    public String getHorario() { return horario; }
    public String getqtConvidados() { return qtconvidados; }
    public String getStatus() { return status; }
    public double getvalorTotal() { return valorTotal; }
    public Salao getSalao() { return salao; }

    public void setStatus(String status) { this.status = status; }
    public void setSalao(Salao salao) { this.salao = salao; }

    @Override
    public String toString() {
        String salaoDetalhes = salao == null ? "Nenhum" : String.valueOf(salao.getNumero());
        return "Código: " + codigo
                + "Cliente: " + nomeCliente
                + "Data: " + data
                + "Horario: " + horario
                + "Status: " + status
                + "Valor total: R$ " + String.format("%.2f", valorTotal)
                + "Box: " + salaoDetalhes;
    }
}

