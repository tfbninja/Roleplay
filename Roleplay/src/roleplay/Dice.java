/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roleplay;

/**
 *
 * @author barber.timothy20
 */
public class Dice {
    private int count;
    
    public int roll() {
        int answer = (int) (Math.random() * 6) + 1;
        count++;
        return answer;
    }
    public int numRolls() {
        return count;
    }
    public void clear() {
        count = 0;
    }
}
