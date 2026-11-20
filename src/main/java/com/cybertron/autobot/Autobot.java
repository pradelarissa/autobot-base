package com.cybertron.autobot;

/**
 * Representa um Autobot da base, com seu nome, Energon (energia) e nível.
 *
 * Os campos são privados para que o Energon só seja alterado pelos
 * métodos da classe, evitando valores alterados sem controle.
 */
public class Autobot {

    private String nome;
    private double energon;
    private int niveldeenergia;

    /**
     * Cria um Autobot com os dados iniciais.
     *
     * @param nome nome do Autobot
     * @param energon quantidade inicial de Energon
     * @param niveldeenergia nível do Autobot
     */
    public Autobot(String nome, double energon, int niveldeenergia) {
        this.nome = nome;
        this.energon = energon;
        this.niveldeenergia = niveldeenergia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getEnergon() {
        return energon;
    }

    public void setEnergon(double energon) {
        this.energon = energon;
    }

    public int getNiveldeenergia() {
        return niveldeenergia;
    }

    public void setNiveldeenergia(int niveldeenergia) {
        this.niveldeenergia = niveldeenergia;
    }
}