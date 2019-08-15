/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entities;

import Helpers.Bag;
import com.sun.javafx.UnmodifiableArrayList;
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
    
    private List<Pokemon>   Pokemonbag;
    
    private double Money;

    public Player(int PlayerId, String Name, String Description, Bag<Item> Bag, List<Pokemon> Pokemonbag, double Money) {
        this.PlayerId = PlayerId;
        this.Name = Name;
        this.Description = Description;
        this.Bag = Bag;
        this.Pokemonbag = Pokemonbag;
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

    public double getMoney() {
        return Money;
    }
    
    public Bag<Item> getBag() {
        return Bag;
    }

    public List<Pokemon> getPokemonbag() {
        return Collections.unmodifiableList(Pokemonbag);
    }    

    public boolean AddPokemonBag(Pokemon data) throws OperacaoInvalidaExeception{
        if (this.Pokemonbag.toArray().length >= 6) {
            throw new OperacaoInvalidaExeception("Só pode ter 6 Pokemons em mão");
        }
        
        return this.Pokemonbag.add(data);
    }
    
    public boolean RemovePokemonBag(Pokemon data) throws OperacaoInvalidaExeception{
        if (this.Pokemonbag.toArray().length <= 0) {
            throw new OperacaoInvalidaExeception("Você não tem nenhum Pokemon");
        }
        
        return this.Pokemonbag.remove(data);
    }
}

