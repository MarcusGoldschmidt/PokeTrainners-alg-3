/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entities.item;

/**
 *
 * @author marcus
 */
public class Pokeball extends Item {
    
    private int Power;
    
    private int Quantidade;

    public int getPower() {
        return Power;
    }

    public void setPower(int Power) {
        this.Power = Power;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

      
}