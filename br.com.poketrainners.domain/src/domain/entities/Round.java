/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entities;

/**
 *
 * @author marcus
 */
public class Round {
    private int     RoundId;
    
    private int     BattleId;
    private Battle  Battle;
    
    private String  Message;
    
    private String  AtributeComparable;
    
    private String  ValueOne;
    private String  ValueTwo;
    
    private int     PlayerWinnerId;
    private Player  PlayerWinner;

    public int getRoundId() {
        return RoundId;
    }

    public void setRoundId(int RoundId) {
        this.RoundId = RoundId;
    }

    public int getBattleId() {
        return BattleId;
    }

    public void setBattleId(int BattleId) {
        this.BattleId = BattleId;
    }

    public Battle getBattle() {
        return Battle;
    }

    public void setBattle(Battle Battle) {
        this.Battle = Battle;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public String getAtributeComparable() {
        return AtributeComparable;
    }

    public void setAtributeComparable(String AtributeComparable) {
        this.AtributeComparable = AtributeComparable;
    }

    public String getValueOne() {
        return ValueOne;
    }

    public void setValueOne(String ValueOne) {
        this.ValueOne = ValueOne;
    }

    public String getValueTwo() {
        return ValueTwo;
    }

    public void setValueTwo(String ValueTwo) {
        this.ValueTwo = ValueTwo;
    }

    public int getPlayerWinnerId() {
        return PlayerWinnerId;
    }

    public void setPlayerWinnerId(int PlayerWinnerId) {
        this.PlayerWinnerId = PlayerWinnerId;
    }

    public Player getPlayerWinner() {
        return PlayerWinner;
    }

    public void setPlayerWinner(Player PlayerWinner) {
        this.PlayerWinner = PlayerWinner;
    }
    
    
}
