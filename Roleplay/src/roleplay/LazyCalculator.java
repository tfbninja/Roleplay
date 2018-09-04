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
public class LazyCalculator extends CalculatingDevice{
    
    private Calculator calc = new Calculator();
    
    @Override
    public int add(int num1, int num2) {
        return calc.add(num1, num2);
    }
    
    @Override
    public int subtract(int num1, int num2) {
        return calc.subtract(num1, num2);
    }
    
    public int add(int num1, int num2, int num3, int num4) {
        int temp1 = calc.add(num1, num2);
        int temp2 = calc.add(num3, num4);
        return calc.add(temp1,temp2);
    }
}