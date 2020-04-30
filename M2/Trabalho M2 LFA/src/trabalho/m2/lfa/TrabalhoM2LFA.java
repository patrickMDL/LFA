/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.m2.lfa;
import java.io.IOException;

/**
 *
 * @author patri
 */
public class TrabalhoM2LFA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        try
        {
            Lexico lexico = new Lexico("A= 10; B = 11; B = 111 + A / B; show(B);");
            Sintatico sintatico = new Sintatico();
            Semantico semantico = new Semantico();
            sintatico.parse(lexico, semantico);
        } 
        catch( LexicalError | SyntaticError | SemanticError e){
            System.out.println("comando não identificados");
        }
    }
    
}
