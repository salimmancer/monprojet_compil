/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetcompil;

/**
 *
 * @author NIS
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author user
 */
public class TOKEN {
   
    public String lexeme;
    public TYPETOKEN token;

    public TOKEN(String lexeme, TYPETOKEN token) {
        this.lexeme = lexeme;
        this.token = token;
    }
    
   

  public enum TYPETOKEN{
      //mots cle
     IF,    
     ELSE,
     ELIF,
     WHILE,
     FOR,
     IN, 
     PASS,   
     TRY,
     EXCEPT,
     BREAK,
     CONTINUE,
     CLASSE,
     DEF,
     
     //identificateur
     IDENTIFIER,
     
     // TYPES
     CHAINE,
     NOM,
     PRENOM,
     
     // affectation
     PLUS,
     MINUS,
     MULT,
     DIV,
     MOD,
     AND,
     OR,
     NOT,
     TRUE,
     FALSE,
     EQUALS,
   
     MULTEQ,// *=
     DIVEQ,   // /=
     MODEQ, // %=
     
     
       // incrementation et decrementation
     PLUSEQ, //+=
     MINUSEQ,   //-=
     
     // Opérateurs de comparaison
      EQEQ, 
      NEQ, 
      LT, 
      GT, 
      LTE, 
      GTE , 
      
      PRINT,
     
      NUMBER,
     
     
      LPAREN,
       COMMA,
      EOF, 
      RPAREN, 
   
      INDENT,
      DEDENT,
       COLON, 
      NEWLINE,
  }  
}

Creat Main.java
  
