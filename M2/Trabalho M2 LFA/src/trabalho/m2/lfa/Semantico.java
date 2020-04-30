package trabalho.m2.lfa;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Semantico implements Constants
{
    Stack<Integer> stack = new Stack();
    Map<String, Integer> vars = new HashMap<String, Integer>();
    String var;
    public void executeAction(int action, Token token)	throws SemanticError
    {
        Integer a,b;
        switch(action)
        {
            case 1: //Put numbers in the stack;
                stack.push(Integer.parseInt(token.getLexeme(),2));
                break;
            case 2: // add operation
                b = stack.pop();
                a = stack.pop();
                stack.push(new Integer(a.intValue() + b.intValue()));
                break;
            case 3: //multiply operation
                b = stack.pop();
                a = stack.pop();
                stack.push(new Integer(a.intValue() * b.intValue()));
                break;
            case 4://Put variable in the stack
                stack.push(vars.get(token.getLexeme()));
                break;
            case 5: //Sub operation
                b = stack.pop();
                a = stack.pop();
                stack.push(new Integer(a.intValue() - b.intValue()));
                break;
            case 6: //divide operation
                b = stack.pop();
                a = stack.pop();
                stack.push(new Integer(a.intValue() / b.intValue()));
                break;
            case 7: //Power operation
                b = stack.pop();
                a = stack.pop();
                Double A = Math.pow(a,b);
                stack.push(A.intValue());
                break;
            case 8: //Show command
                System.out.println("Resultado: " + Integer.toBinaryString(vars.get(var)) + "\n");
                break;
            case 9:
                vars.put(var, stack.pop());
                break;
            case 10:
                var = token.getLexeme();
                break;
                
        }
    }	
}
