/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entities.item;

import domain.entities.enuns.ItemType;
import domain.exceptions.OperacaoInvalidaExeception;

/**
 *
 * @author marcus
 */
public class ItemConsumable extends Item{

    public ItemConsumable(ItemType type) throws OperacaoInvalidaExeception {
        if (type != ItemType.PlayerConsumable && type != ItemType.PokemonConsumable) {
            throw new OperacaoInvalidaExeception("Tipo do item não foi definido corretametne");
        }
        this.Type = type;
    }
}
