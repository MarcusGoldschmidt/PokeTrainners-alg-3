/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.exceptions;

/**
 *
 * @author marcus
 */
public class OperacaoInvalidaExeception extends Exception{

    public OperacaoInvalidaExeception(String message) {
        super(message);
    }
}
