/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entities;

import domain.entities.enuns.Status;
import domain.exceptions.OperacaoInvalidaExeception;
import java.util.List;

/**
 *
 * @author marcus
 */
public class Pokemon {
    private int     PokemonId;
    private String  Name;
    private String  Description;
    
    private int     Level;
    private int     CurrentXp;
    private int     XpToNextLevel;
    
    private int     HP;
    private int     Attack;
    private int     SpAtk;
    private int     SpDef;
    private int     Speed;
    
    private List<Status> Status;
    
    private List<Hability> Habilitys;

    public Pokemon(int PokemonId, String Name, String Description, int Level, int CurrentXp, int XpToNextLevel, int HP, int Attack, int SpAtk, int SpDef, int Speed, List<Status> Status, List<Hability> Habilitys) {
        this.PokemonId = PokemonId;
        this.Name = Name;
        this.Description = Description;
        this.Level = Level;
        this.CurrentXp = CurrentXp;
        this.XpToNextLevel = XpToNextLevel;
        this.HP = HP;
        this.Attack = Attack;
        this.SpAtk = SpAtk;
        this.SpDef = SpDef;
        this.Speed = Speed;
        this.Status = Status;
        this.Habilitys = Habilitys;
    }

    public int getPokemonId() {
        return PokemonId;
    }

    public void setPokemonId(int PokemonId) {
        this.PokemonId = PokemonId;
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

    public int getLevel() {
        return Level;
    }

    public void setLevel(int Level) {
        this.Level = Level;
    }

    public int getCurrentXp() {
        return CurrentXp;
    }

    public void setCurrentXp(int CurrentXp) {
        this.CurrentXp = CurrentXp;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int Attack) {
        this.Attack = Attack;
    }

    public int getSpAtk() {
        return SpAtk;
    }

    public void setSpAtk(int SpAtk) {
        this.SpAtk = SpAtk;
    }

    public int getSpDef() {
        return SpDef;
    }

    public void setSpDef(int SpDef) {
        this.SpDef = SpDef;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int Speed) {
        this.Speed = Speed;
    }

    public List<Status> getStatus() {
        return Status;
    }

    public void setStatus(List<Status> Status) {
        this.Status = Status;
    }
    
    public boolean RemoveAbility(Hability data){
        return Habilitys.remove(data);
    }
    
    public boolean AddAbility(Hability newData) throws OperacaoInvalidaExeception{
        if (Habilitys.toArray().length <= 4) {
            throw new OperacaoInvalidaExeception("Limite de 4 hábilidades");
        }
        return Habilitys.add(newData);
    }
    
    public boolean ChangeAbility(Hability oldData, Hability newData){
        if (Habilitys.remove(oldData)) {
            Habilitys.add(newData);
            return true;
        }
        return false;
    }
    
    public boolean TryLevelUp(){
        if (CurrentXp >= XpToNextLevel) {
            this.Level++;
            // 10 + 5 * RAIZ do Level
            this.XpToNextLevel = (int) (5 * (2 + Math.sqrt(Level)));
            return true;
        }
        return false;
    }
}
