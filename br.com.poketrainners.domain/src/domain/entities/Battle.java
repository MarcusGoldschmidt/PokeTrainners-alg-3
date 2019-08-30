/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entities;

import java.util.List;

/**
 *
 * @author marcus
 */
public class Battle {
    private int             BattleId;
    
    private int             PlayerOneId;
    private Player          PlayerOne;
    
    private int             PlayerTwoId;
    private Player          PlayerTwo;
    
    private BattleStatus    Status;
    
    private int             PlayerWinnerId;
    private Player          PlayerWinner;
    
    private List<Round>     Rounds;

    public int getBattleId() {
        return BattleId;
    }

    public void setBattleId(int BattleId) {
        this.BattleId = BattleId;
    }

    public int getPlayerOneId() {
        return PlayerOneId;
    }

    public void setPlayerOneId(int PlayerOneId) {
        this.PlayerOneId = PlayerOneId;
    }

    public Player getPlayerOne() {
        return PlayerOne;
    }

    public void setPlayerOne(Player PlayerOne) {
        this.PlayerOne = PlayerOne;
    }

    public int getPlayerTwoId() {
        return PlayerTwoId;
    }

    public void setPlayerTwoId(int PlayerTwoId) {
        this.PlayerTwoId = PlayerTwoId;
    }

    public Player getPlayerTwo() {
        return PlayerTwo;
    }

    public void setPlayerTwo(Player PlayerTwo) {
        this.PlayerTwo = PlayerTwo;
    }

    public BattleStatus getStatus() {
        return Status;
    }

    public void setStatus(BattleStatus Status) {
        this.Status = Status;
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

    public List<Round> getRounds() {
        return Rounds;
    }

    public void setRounds(List<Round> Rounds) {
        this.Rounds = Rounds;
    }

    public enum BattleStatus{
        FINALIZADA,
        ANDAMENTO
    }
}
