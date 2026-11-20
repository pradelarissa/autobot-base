package com.cybertron.autobot;

import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia o grupo de Autobots da base: busca, repara e classifica, e concentra as
 * regras de negócio (classificação por Energon e reparo), deixando a classe Autobot
 * responsável apenas por guardar os dados.
 */
public class GerenciadorAutobots {

    private static final double EnergonElite = 500;
    private static final double  EnergonPadrao = 200;
    private static final double  EnergiaReparo = 100;

    private List<Autobot> lista = new ArrayList<>();

    public void adicionar(Autobot autobot) {
        lista.add(autobot);
    }

    /**
     * Soma o Energon de todos os Autobots cadastrados.
     * @return Energon total da base; 0 se não houver nenhum Autobot.
     */
    public double calcularEnergonTotal() {
        double total = 0;
        for (int i = 0; i < lista.size(); i++) {
            total += lista.get(i).getEnergon();
        }
        return total;
    }

    /**
     * Busca um Autobot pelo nome exato.
     *
     * <p>A comparação diferencia maiúsculas de minúsculas.</p>
     *
     * @param nome nome do Autobot procurado
     * @return o Autobot encontrado, ou {@code null} se nenhum tiver esse nome
     */
    public Autobot buscar(String nome) {
        for (Autobot autobot : lista) {
            if (autobot.getNome().equals(nome)) {
                return autobot;
            }
        }
        return null;
    }

    /**
     * Recupera Energon de um Autobot.
     * <p>Energon negativo indica dado inconsistente. Corrigir isso em silêncio
     * esconderia o problema, por isso o reparo é recusado com um erro.</p>
     * @param autobot Autobot a ser reparado
     * @throws IllegalArgumentException se o Energon do Autobot for negativo
     */
    public void reparar(Autobot autobot) {
        if (autobot.getEnergon() < 0) {
            throw new IllegalArgumentException("Energon negativo");
        }
        autobot.setEnergon(autobot.getEnergon() + EnergiaReparo);
    }

    /**
     * Classifica o Autobot pelo nível de Energon, para definir seu papel na base.
     *
     * <p>Energon acima do limite de elite resulta em ELITE; acima do limite
     * padrão, em PADRAO. Nos demais casos (inclusive Energon negativo),
     * resulta em RESERVA.</p>
     *
     * @param autobot Autobot a ser classificado
     * @return "ELITE", "PADRAO" ou "RESERVA"
     */
    public String classificar(Autobot autobot) {
        if (autobot.getEnergon() > EnergonElite) {
            return "ELITE";
        } else if (autobot.getEnergon() > EnergonPadrao) {
            return "PADRAO";
        } else {
            return "RESERVA";
        }
    }
}