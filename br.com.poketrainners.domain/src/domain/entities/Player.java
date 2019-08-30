/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entities;

import domain.entities.item.Pokeball;
import domain.exceptions.OperacaoInvalidaExeception;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author marcus
 */
public class Player {

    private int                 PlayerId;
    private String              Name;
    
    private double              Pontuacao;

    private int                 Level;
    
    private int                 PokemonBagId;
    private Bag<Pokemon>        PokemonBag = new Bag<>(6);
    
    private List<PokemonCathed> pokemonCatheds;

    private double Money;

    public int getPlayerId() {
        return PlayerId;
    }

    public String getName() {
        return Name;
    }

    public int getLevel() {
        return Level;
    }

    public double getMoney() {
        return Money;
    }
    
    public double AddMoney(double valor) throws OperacaoInvalidaExeception {
        if (valor < 0)
            throw new OperacaoInvalidaExeception("Valor negativo não permitido");
        this.Money += valor;
        return this.Money;
    }
    
    public double RemoveMoney(double valor) throws OperacaoInvalidaExeception {
        if (valor < 0)
            throw new OperacaoInvalidaExeception("Valor negativo não permitido");
        this.Money -= valor;
        return this.Money;
    }

    public List<Pokemon> getPokemonBag() {
        return Collections.unmodifiableList(PokemonBag.Itens);
    }

    public boolean AddPokemonBag(Pokemon data) throws OperacaoInvalidaExeception {
        return this.PokemonBag.add(data);
    }

    public boolean RemovePokemonBag(Pokemon data) throws OperacaoInvalidaExeception {
        return this.PokemonBag.remove(data);
    }

    public boolean TryCathPokemon(Pokeball pokeball, Pokemon pokemon) {
        int chance = (int) (Math.random() * 100);
        
        pokeball.setQuantidade(pokeball.getQuantidade() - 1);
        
        chance -= pokemon.getLevel() / 2;
        chance -= pokemon.getDefenseToCath();
        chance -= pokemon.getSpeed() / 10;
        chance += this.Level / 2;
        chance += pokeball.getPower();
        return chance > 50;
    }
}
