/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entities;

import domain.entities.enuns.Status;
import domain.entities.enuns.Type;
import java.util.List;

/**
 *
 * @author marcus
 */
public class Hability {
    private int             HabilityID;
    private String          Name;
    private String          Description;
    
    private double          Damage;
    
    private Type            Type1;
    private Type            Type2;
    
    private List<Status>    ApllyStatus;  

    public Hability(int HabilityID, String Name, String Description, Type Type1, Type Type2, List<Status> ApllyStatus) {
        this.HabilityID = HabilityID;
        this.Name = Name;
        this.Description = Description;
        this.Type1 = Type1;
        this.Type2 = Type2;
        this.ApllyStatus = ApllyStatus;
    }
    
    public int getHabilityID() {
        return HabilityID;
    }

    public void setHabilityID(int HabilityID) {
        this.HabilityID = HabilityID;
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

    public List<Status> getApllyStatus() {
        return ApllyStatus;
    }

    public void setApllyStatus(List<Status> ApllyStatus) {
        this.ApllyStatus = ApllyStatus;
    }

    public double getDamage() {
        return Damage;
    }

    public void setDamage(double Damage) {
        this.Damage = Damage;
    }
}
