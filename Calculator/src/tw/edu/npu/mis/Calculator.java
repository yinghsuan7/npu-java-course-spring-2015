/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 * The model class of the calculator application.
 */
public class Calculator extends java.util.Observable{
    String k = "",o;
    int number,number2;
    
    /**
     * The available operators of the calculator.
     */
    public enum Operator {
        CLEAR,       // C
        CLEAR_ENTRY, // CE
        BACKSPACE,   // ⌫
        EQUAL,       // =
        PLUS,        // +
        MINUS,       // -
        TIMES,       // ×
        OVER,        // ⁄
        PLUS_MINUS,  // ±
        RECIPROCAL,  // 1/x
        PERCENT,     // %
        SQRT,        // √
        MEM_CLEAR,   // MC
        MEM_SET,     // MS
        MEM_PLUS,    // M+
        MEM_MINUS,   // M-
        MEM_RECALL   // MR
    }
    
    public void appendDigit(int digit) {
        k+= String.valueOf(digit);
        getDisplay();
    }
    
    public void appendDot(String dot) {
        k+= dot;
        getDisplay();
    }
    
    public void performOperation(Operator operator) {
        if(operator == Operator.PLUS)
        {
            number=Integer.parseInt(k);
            k="";
            getDisplay();
            o="+";
            
        }
         if(operator == Operator.MINUS)
        {
            number=Integer.parseInt(k);
            k="";
            getDisplay();
            o="-";
            
        }
          if(operator == Operator.TIMES)
        {
            number=Integer.parseInt(k);
            k="";
            getDisplay();
            o="*";
            
        }
           if(operator == Operator.OVER)
        {
            number=Integer.parseInt(k);
            k="";
            getDisplay();
            o="/";
            
        }
            if(operator == Operator.EQUAL)
        {
            if(o == "+")
            {
                number2 = Integer.parseInt(k);
                k = String.valueOf(number+number2);
                getDisplay();
                k="";    
            }
             if(o == "-")
                {
                number2 = Integer.parseInt(k);
                k = String.valueOf(number-number2);
                getDisplay();
                k="";    
            }  
              if(o == "*")
                {
                number2 = Integer.parseInt(k);
                k = String.valueOf(number*number2);
                getDisplay();
                k="";    
            }
              if(o == "/")
                 {
                number2 = Integer.parseInt(k);
                k = String.valueOf(number/number2);
                getDisplay();
                k="";    
            } 
        }
        
    }
    
    public String getDisplay() {
       setChanged();
       notifyObservers(k);
        return null;
    }

    /**
     * @param args the command line arguments
     */
   public void setOperation(String text){
       if(text=="+")performOperation(Operator.PLUS);
       if(text=="-")performOperation(Operator.MINUS);
       if(text=="*")performOperation(Operator.TIMES);
       if(text=="/")performOperation(Operator.OVER);
       if(text=="=")performOperation(Operator.EQUAL);
       
       
   }
       
   }