/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entities;

import domain.entities.item.Item;
import domain.entities.item.Pokeball;
import domain.exceptions.OperacaoInvalidaExeception;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author marcus
 */
public class Player {

    private int             PlayerId;
    private String          Name;
    private String          Description;

    private Bag<Item>       Bag;

    private int             Level;

    private List<Pokemon>   PokemonBag;
    private PokemonHub      PokemonHub;

    private double Money;

    public Player(int PlayerId, String Name, String Description, Bag<Item> Bag, List<Pokemon> Pokemonbag, double Money) {
        this.PlayerId = PlayerId;
        this.Name = Name;
        this.Description = Description;
        this.Bag = Bag;
        this.PokemonBag = Pokemonbag;
        this.Money = Money;
    }

    public int getPlayerId() {
        return PlayerId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
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

    public double getMoney() {
        return Money;
    }

    public Bag<Item> getBag() {
        return Bag;
    }

    public List<Pokemon> getPokemonbag() {
        return Collections.unmodifiableList(PokemonBag);
    }

    public boolean AddPokemonBag(Pokemon data) throws OperacaoInvalidaExeception {
        if (this.PokemonBag.toArray().length >= 6) {
            return this.PokemonHub.Add(data);
        }

        return this.PokemonBag.add(data);
    }

    public boolean RemovePokemonBag(Pokemon data) throws OperacaoInvalidaExeception {
        if (this.PokemonBag.toArray().length <= 0) {
            throw new OperacaoInvalidaExeception("Você não tem nenhum Pokemon");
        }

        return this.PokemonBag.remove(data);
    }

    public boolean TryCathPokemon(Pokeball pokeball, Pokemon pokemon) {
        double chance = (int) (Math.random() * 100);
        
        pokeball.setQuantidade(pokeball.getQuantidade() - 1);
        
        chance -= pokemon.getLevel() / 2;
        chance -= pokemon.getDefenseToCath();
        chance -= pokemon.getSpeed() / 10;
        chance += this.Level / 2;
        chance += pokeball.getPower();
        return chance > 50;
    }
}
