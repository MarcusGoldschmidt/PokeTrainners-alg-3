/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entities;

import domain.entities.enuns.Status;
import domain.entities.enuns.Type;
import domain.exceptions.OperacaoInvalidaExeception;
import java.util.List;

/**
 *
 * @author marcus
 */
public class Pokemon {
    private int             PokemonId;
    
    private Player          PlayerOwner;
    
    private String          Name;
    private String          Description;
    
    private int             Level;
    private int             CurrentXp;
    private int             XpToNextLevel;
    
    private int             HP;
    private int             Attack;
    private int             SpAtk;
    private int             SpDef;
    private int             Speed;
    
    private int             DefenseToCath;
    
    private Type            Type1;
    private Type            Type2;
    
    private List<Status>    Status;
    
    private List<Hability> Habilitys;

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

    public int getXpToNextLevel() {
        return XpToNextLevel;
    }

    public void setXpToNextLevel(int XpToNextLevel) {
        this.XpToNextLevel = XpToNextLevel;
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

    public int getDefenseToCath() {
        return DefenseToCath;
    }

    public void setDefenseToCath(int DefenseToCath) {
        this.DefenseToCath = DefenseToCath;
    }

    public List<Status> getStatus() {
        return Status;
    }

    public void setStatus(List<Status> Status) {
        this.Status = Status;
    }

    public List<Hability> getHabilitys() {
        return Habilitys;
    }

    public void setHabilitys(List<Hability> Habilitys) {
        this.Habilitys = Habilitys;
    }
    
    public boolean RemoveAbility(Hability data){
        return Habilitys.remove(data);
    }

    public Type getType1() {
        return Type1;
    }

    public void setType1(Type Type1) {
        this.Type1 = Type1;
    }

    public Type getType2() {
        return Type2;
    }

    public void setType2(Type Type2) {
        this.Type2 = Type2;
    }

    public Player getPlayerOwner() {
        return PlayerOwner;
    }

    public void setPlayerOwner(Player PlayerOwner) {
        this.PlayerOwner = PlayerOwner;
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
