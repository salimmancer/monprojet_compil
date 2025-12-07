/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetcompil;

import java.util.List;
import java.util.ArrayList;
import java.io.*;
/**
 *
 * @author user
 */
public class mylexer {
  

    
    
    
    
   
      int i=0;
        String code;
        String mot;
        int esp;
        int compteur;
        public mylexer( String code){
            this.code=code;
            compteur=0;
            esp=0;
            mot="";
           
        }
        public void ignorerespaces() {
    while (i < code.length() && code.charAt(i) == ' ') 
    {
        i++;
    }
}      
        public boolean est_caractere(char c){
           
           if((c >='a')&&(c<='z')||(c>='A')&&(c<='Z')||c=='_') {
               return true;
           }else
               return false;
       
        }
        public String avancer_caractere(){
        String mot1="";
        while(i<code.length()&&est_caractere( code.charAt(i))){
        mot1=mot1+code.charAt(i);
        i++;  
        }
        return mot1;
        }
        
        
        public boolean chiffre(char n){
            if((n>='0')&&(n<='9')){
            return true;
        }else
                return false;
        }
        public String avancernember(){
            String mot1="";
            while( i<code.length()&&chiffre( code.charAt(i))){
             mot1=mot1+code.charAt(i);
                 i++;
            }
            return mot1;
        }
       
        public String  caractere_nombre(){
          String mot1="" ;
          while(i < code.length()&&(est_caractere(code.charAt(i))||chiffre(code.charAt(i)))){
             mot1=mot1+code.charAt(i);  
            i++;
          }
                            return mot1;
        }
       
     
    public String avanceroperateur (){
        String op="";
        if(i<code.length()&&code.charAt(i)=='='){
           op="=";
           i++;
        }
        return op;
    }
  public int tab() {
    int cpt = 0;

    while (i < code.length() && (code.charAt(i) == ' ' || code.charAt(i) == '\t')) {

        if (code.charAt(i) == ' ') {
            
            int k = 0;
            while (k < 4 && i < code.length() && code.charAt(i) == ' ') {
                k++;
                i++;
            }
            if (k == 4) {
                cpt++;
            } else if (k < 4) {
               
            }

        } else if (i < code.length()&&code.charAt(i) == '\t') {
            cpt++;  // tab = 1 niveau (ou 4 colonnes si tu veux)
            i++;
        }
    }

    return cpt;
}
    public List<TOKEN> Analyser(){
       
       List<TOKEN> tokens = new ArrayList<>();
     

        while( !mot.equals("eof")){
             if (i >= code.length()) break;
           
              if (i < code.length()&&code.charAt(i) == '#') {
    while (i < code.length() && code.charAt(i) != '\n') {
        i++;
    }
     // revenir au début du while
         continue;
  }
               ignorerespaces();
            mot="";
         
            if( i < code.length() &&est_caractere(code.charAt(i))){
                mot=mot+code.charAt(i);
                i++;
         mot=mot+avancer_caractere();
       if (mot.equals("else")) {
    TOKEN else1 = new TOKEN(mot, TOKEN.TYPETOKEN.ELSE);
    tokens.add(else1);

} else if (mot.equals("if")) {
    TOKEN if1 = new TOKEN(mot, TOKEN.TYPETOKEN.IF);
    tokens.add(if1);

} else if (mot.equals("elif")) {
    TOKEN elif1 = new TOKEN(mot, TOKEN.TYPETOKEN.ELIF);
    tokens.add(elif1);

} else if (mot.equals("while")) {
    TOKEN tokenwhile = new TOKEN(mot, TOKEN.TYPETOKEN.WHILE);
    tokens.add(tokenwhile);

} else if (mot.equals("for")) {
    TOKEN tokenfor = new TOKEN(mot, TOKEN.TYPETOKEN.FOR);
    tokens.add(tokenfor);

} else if (mot.equals("try")) {
    TOKEN tokentry = new TOKEN(mot, TOKEN.TYPETOKEN.TRY);
    tokens.add(tokentry);

} else if (mot.equals("except")) {
    TOKEN tokenexcept = new TOKEN(mot, TOKEN.TYPETOKEN.EXCEPT);
    tokens.add(tokenexcept);

} else if (mot.equals("break")) {
    TOKEN tokenbreak = new TOKEN(mot, TOKEN.TYPETOKEN.BREAK);
    tokens.add(tokenbreak);

} else if (mot.equals("continue")) {
    TOKEN tokencontinue = new TOKEN(mot, TOKEN.TYPETOKEN.CONTINUE);
    tokens.add(tokencontinue);

} else if (mot.equals("or")) {
    TOKEN tokenor = new TOKEN(mot, TOKEN.TYPETOKEN.OR);
    tokens.add(tokenor);

} else if (mot.equals("and")) {
    TOKEN tokenand = new TOKEN(mot, TOKEN.TYPETOKEN.AND);
    tokens.add(tokenand);

} else if (mot.equals("not")) {
    TOKEN tokennot = new TOKEN(mot, TOKEN.TYPETOKEN.NOT);
    tokens.add(tokennot);

} else if (mot.equals("false")) {
    TOKEN tokenfalse = new TOKEN(mot, TOKEN.TYPETOKEN.FALSE);
    tokens.add(tokenfalse);

} else if (mot.equals("true")) {
    TOKEN tokentrue = new TOKEN(mot, TOKEN.TYPETOKEN.TRUE);
    tokens.add(tokentrue);

} else if (mot.equals("salim")) {
    TOKEN tokenprenom = new TOKEN(mot, TOKEN.TYPETOKEN.PRENOM);
    tokens.add(tokenprenom);

} else if (mot.equals("mancer")) {
    TOKEN tokennom = new TOKEN(mot, TOKEN.TYPETOKEN.NOM);
    tokens.add(tokennom);

} else if (mot.equals("def")) {
    TOKEN tokendef = new TOKEN(mot, TOKEN.TYPETOKEN.DEF);
    tokens.add(tokendef);

} else if (mot.equals("class")) {
    TOKEN tokenclass = new TOKEN(mot, TOKEN.TYPETOKEN.CLASSE);
    tokens.add(tokenclass);

} else if (mot.equals("print")) {
    TOKEN tokenprint = new TOKEN(mot, TOKEN.TYPETOKEN.PRINT);
    tokens.add(tokenprint);

} else if (mot.equals("eof")) {
    TOKEN tokeneof = new TOKEN("eof", TOKEN.TYPETOKEN.EOF);
    tokens.add(tokeneof);
}   else{  
     mot=mot+caractere_nombre();
      TOKEN id = new TOKEN(mot, TOKEN.TYPETOKEN.IDENTIFIER);
    tokens.add(id);}
  
          
            } else if (i < code.length() &&code.charAt(i)=='='){
                mot=mot+code.charAt(i);
                i++;
               mot=mot+avanceroperateur ();
               if (mot.equals("==")) {
                TOKEN tokeneqeq = new TOKEN(mot, TOKEN.TYPETOKEN.EQEQ);
                tokens.add(tokeneqeq);

        } else if (mot.equals("=")) {
        TOKEN tokeneq = new TOKEN(mot, TOKEN.TYPETOKEN.EQUALS);
        tokens.add(tokeneq);
}
               
            }else if( i < code.length() &&code.charAt(i)=='+'){
                mot= mot+code.charAt(i);
                i++;
                mot=mot+avanceroperateur();
                    if (i < code.length() &&mot.equals("+")) {
                    TOKEN tokenplus = new TOKEN(mot, TOKEN.TYPETOKEN.PLUS);
                    tokens.add(tokenplus);

                } else if (i < code.length() &&mot.equals("+=")) {
                TOKEN tokenpluseq = new TOKEN(mot, TOKEN.TYPETOKEN.PLUSEQ);
                tokens.add(tokenpluseq);
                                             }
                
               
                }else if (i < code.length() &&code.charAt(i)=='-'){
                mot=mot+code.charAt(i);
                i++;
                 mot=mot+avanceroperateur();
                 if (i < code.length() &&mot.equals("-")) {
                  TOKEN tokenminus = new TOKEN(mot, TOKEN.TYPETOKEN.MINUS);
                  tokens.add(tokenminus);

                 } else if (i < code.length() &&mot.equals("-=")) {
                 TOKEN tokenminuseq = new TOKEN(mot, TOKEN.TYPETOKEN.MINUSEQ);
                 tokens.add(tokenminuseq);
                }

               
            }else if(i < code.length() &&code.charAt(i)=='*'){
                mot=mot+code.charAt(i);
                i++;
                mot=mot+avanceroperateur();
                if (mot.equals("*")) {
                TOKEN tokenmult = new TOKEN(mot, TOKEN.TYPETOKEN.MULT);
                tokens.add(tokenmult);

                } else if (mot.equals("*=")) {
                TOKEN tokenmulteq = new TOKEN(mot, TOKEN.TYPETOKEN.MULTEQ);
                tokens.add(tokenmulteq);
                }
            }else if(i < code.length() &&code.charAt(i)=='/'){
                 mot=mot+code.charAt(i);
                i++;
                mot=mot+avanceroperateur();
                if (i < code.length() &&mot.equals("/")) {
                TOKEN tokendiv = new TOKEN(mot, TOKEN.TYPETOKEN.DIV);
                tokens.add(tokendiv);

                } else if (mot.equals("/=")) {
                TOKEN tokendiveq = new TOKEN(mot, TOKEN.TYPETOKEN.DIVEQ);
                tokens.add(tokendiveq);
                }
            }else if(i < code.length() &&code.charAt(i)=='%'){
                 mot=mot+code.charAt(i);
                i++;
                mot=mot+avanceroperateur();
                if (mot.equals("%")) {
                TOKEN tokendiv = new TOKEN(mot, TOKEN.TYPETOKEN.MOD);
                tokens.add(tokendiv);
            } else if (mot.equals("%=")) {
            TOKEN tokenmod = new TOKEN(mot, TOKEN.TYPETOKEN.MODEQ);
            tokens.add(tokenmod);
            }
            }else if (i < code.length() &&code.charAt(i)=='!'){
                mot=mot+code.charAt(i);
                i++;
                mot=mot+avanceroperateur();
                if( mot.equals("!=")){
                TOKEN tokennoteq=new TOKEN(mot,TOKEN.TYPETOKEN.NEQ);
                tokens.add(tokennoteq); ;
            }else {
                    System.out.println("! il n'existe pas seul en python"); i++;
                }  
               
            }else if(i < code.length() &&code.charAt(i)=='>'){
               mot=mot+code.charAt(i);
               i++;
               mot=mot+avanceroperateur();
               if (mot.equals(">")) {
               TOKEN tokengt = new TOKEN(mot, TOKEN.TYPETOKEN.GT);
               tokens.add(tokengt);
               } else if (mot.equals(">=")) {
               TOKEN tokengte = new TOKEN(mot, TOKEN.TYPETOKEN.GTE);
               tokens.add(tokengte);
                }
            }else if(i < code.length() &&code.charAt(i)=='<'){
                mot=mot+code.charAt(i);
                i++;
                   mot=mot+avanceroperateur();
                   if (mot.equals("<")) {
                    TOKEN tokenlt = new TOKEN(mot, TOKEN.TYPETOKEN.LT);
                    tokens.add(tokenlt);
                    } else if (mot.equals("<=")) {
                    TOKEN tokenlte = new TOKEN(mot, TOKEN.TYPETOKEN.LTE);
                    tokens.add(tokenlte);
                    }
            }else if(i < code.length() &&code.charAt(i)=='('){
                mot=mot+code.charAt(i);
                TOKEN tokenlp=new TOKEN(mot,TOKEN.TYPETOKEN.LPAREN);
                tokens.add(tokenlp);
                i++;
         
        }else if(i < code.length() &&code.charAt(i)==')'){
                            mot=mot+code.charAt(i);

            TOKEN tokenrp=new TOKEN(mot,TOKEN.TYPETOKEN.RPAREN);
            tokens.add(tokenrp);
            i++;
        }else if(i < code.length() &&code.charAt(i)==':'){
                            mot=mot+code.charAt(i);

              TOKEN tokencolon=new TOKEN(mot,TOKEN.TYPETOKEN.COLON);
            tokens.add(tokencolon); i++;
        }else if(i < code.length() &&code.charAt(i)==','){
                            mot=mot+code.charAt(i);

            TOKEN tokencomma=new TOKEN(mot,TOKEN.TYPETOKEN.COMMA);
            tokens.add(tokencomma);
            i++;
        }else if (i < code.length() &&(code.charAt(i) == '\r' || code.charAt(i) == '\n')) {
    // Gérer CRLF (\r\n) et LF (\n)
    if (code.charAt(i) == '\r' && i + 1 < code.length() && code.charAt(i + 1) == '\n') {
        i += 2; // consommer \r\n
    } else {
        i++; // consommer \n ou \r isolé
    }

    // Compter indentation à partir de la nouvelle position
    compteur = tab(); // tab() avance i sur espaces/tabs et renvoie le niveau

    // Ajouter UN seul NEWLINE
    TOKEN tokenNewline = new TOKEN("\\n", TOKEN.TYPETOKEN.NEWLINE);
    tokens.add(tokenNewline);

    // Gérer INDENT / DEDENT en fonction du niveau calculé
    if (compteur > esp) {
        TOKEN tokenIndent = new TOKEN("INDENT", TOKEN.TYPETOKEN.INDENT);
        tokens.add(tokenIndent);
        esp = compteur;
    } else if (compteur < esp) {
        // on peut avoir plusieurs niveaux de dedent : générer autant de DEDENT que nécessaire
        while (compteur < esp) {
            TOKEN tokenDedent = new TOKEN("DEDENT", TOKEN.TYPETOKEN.DEDENT);
            tokens.add(tokenDedent);
            esp--; // ou décrémenter jusqu'à atteindre compteur
        }
        esp = compteur;
    }
    // on continue la boucle (le while principal reprendra l'analyse à la nouvelle position i)
    continue;
}else if (i<code.length()&& (code.charAt(i) == '"' || code.charAt(i) == '\'')) {
    char quote = code.charAt(i);
    i++;
    StringBuilder str = new StringBuilder();
    while (i < code.length() && code.charAt(i) != quote) {
        str.append(code.charAt(i));
        i++;
    }
    if (i < code.length() && code.charAt(i) == quote) {
        i++; // fermer la chaîne
        TOKEN tokenstring = new TOKEN(str.toString(), TOKEN.TYPETOKEN.CHAINE);
        tokens.add(tokenstring);
    } else {
        System.err.println("Erreur : guillemet fermant manquant");
       
    }

        }else if(i<code.length()&&chiffre(code.charAt(i))){
            mot=mot+code.charAt(i);
            i++;
                mot=mot+avancernember();
               
                TOKEN tokennumbre=new TOKEN(mot,TOKEN.TYPETOKEN.NUMBER);
                tokens.add(tokennumbre);
        }
             
        }
    tokens.add(new TOKEN("eof", TOKEN.TYPETOKEN.EOF));

    return tokens;

}
               
    

    
    
    
  //   parser
    
    
    
 private static  List<TOKEN> tokens;
private int p = 0;
private boolean error = false;  
    
    public void PROGRAMME(List<TOKEN> tokens) {
    this.tokens = tokens;
    this.p = 0;
    this.error= false;
    while (p < tokens.size() && tokens.get(p).token == TOKEN.TYPETOKEN.NEWLINE) {
        p++;
    }

    STATEMENT_LIST(); // Appel de la grammaire

    if (!error &&  tokens.get(p).token == TOKEN.TYPETOKEN.EOF) {
        System.out.println("Programme accepte\n");
    } else {
        System.err.println("Programme NON accepte\n");
    }
}
    
    public void STATEMENT_LIST(){
    
    STATEMENT();
    STATEMENT_LIST1();
    }
    
    
    public void STATEMENT_LIST1(){
    while (p < tokens.size() && tokens.get(p).token == TOKEN.TYPETOKEN.NEWLINE) {
        p++;
    }
    if(p < tokens.size() &&
       (tokens.get(p).token == TOKEN.TYPETOKEN.IDENTIFIER
        || tokens.get(p).token == TOKEN.TYPETOKEN.PRINT
        || tokens.get(p).token == TOKEN.TYPETOKEN.IF)) {
        STATEMENT();
        STATEMENT_LIST1();
    }
}
    
    
    
    public void STATEMENT(){
    if (tokens.get(p).token == TOKEN.TYPETOKEN.IDENTIFIER
        || tokens.get(p).token == TOKEN.TYPETOKEN.PRINT) {
        SIMPLE_STMT();
        // Ici on ne vérifie plus le NEWLINE, il est géré par STATEMENT_LIST()
    } else if (tokens.get(p).token == TOKEN.TYPETOKEN.IF) {
        COMPOUND_STMT();
        // Le bloc IF consomme déjà ses NEWLINE et INDENT/DEDENT
    } else {
        System.err.println("Instruction inattendue à la position " + p);
        error = true;
    }
}
    
    
    public void SIMPLE_STMT(){
        while (p < tokens.size() && tokens.get(p).token == TOKEN.TYPETOKEN.NEWLINE) {
        p++;
    }
         if( tokens.get(p).token == TOKEN.TYPETOKEN.IDENTIFIER){
             
         ASSIGN();
     
                }else if( tokens.get(p).token == TOKEN.TYPETOKEN.PRINT){
     
                    PRINT_CALL();
     
     }else { System.err.println(" instruction simple invalide. Une instruction doit commencer par un identificateur ou par 'print'\n"); 
             error=true;   }
  }
    public void ASSIGN(){
    if(tokens.get(p).token == TOKEN.TYPETOKEN.IDENTIFIER){
        p++;  // <<< MANQUAIT !!!!!
        ASSIGN_OP();
        EXPR();
    } else {
        System.err.println("ce n'est pas un identifiant");
        error = true;
    }
}

    
    
    public void ASSIGN_OP(){
    if (p < tokens.size() && 
        (tokens.get(p).token == TOKEN.TYPETOKEN.EQUALS ||
         tokens.get(p).token == TOKEN.TYPETOKEN.PLUSEQ ||
         tokens.get(p).token == TOKEN.TYPETOKEN.MINUSEQ ||
         tokens.get(p).token == TOKEN.TYPETOKEN.MULTEQ ||
         tokens.get(p).token == TOKEN.TYPETOKEN.DIVEQ ||
         tokens.get(p).token == TOKEN.TYPETOKEN.MODEQ)) {
        p++;
    } else {
        System.err.println("\"Erreur : opérateur d'affectation manquant. Vous devez mettre '=' ou un opérateur comme '+='\"");
        error = true;
    }
}
    
    
    
     public void PRINT_CALL(){
    if(tokens.get(p).token == TOKEN.TYPETOKEN.PRINT){
        p++;
        if(tokens.get(p).token == TOKEN.TYPETOKEN.LPAREN){
            p++;
            ARG_LIST();
            if(tokens.get(p).token == TOKEN.TYPETOKEN.RPAREN){
                p++;
            } else{
                System.err.println("Erreur : parenthese droite manquante");
                error=true; 
            }
        } else {
            System.err.println("Erreur : parenthese gauche manquante");
            error=true;
        }
    } else {
        System.err.println("Instruction print invalide");
        error=true;
    }
}
     
     
     
     
     public void ARG_LIST(){
      EXPR ();
      ARG_LIST1();
     
     
     }
     
     
    public void ARG_LIST1(){
        if(tokens.get(p).token == TOKEN.TYPETOKEN. COMMA){
          p++;
          EXPR();
          ARG_LIST1();
        } else{} 
     
     
     }
    
    
    
    public void COMPOUND_STMT(){
     IF_STMT();
    
    }
    
    
    
    
    public void IF_STMT(){
    if(tokens.get(p).token == TOKEN.TYPETOKEN.IF){
        p++;
        EXPR();
        if(tokens.get(p).token == TOKEN.TYPETOKEN.COLON){
            p++;
            BLOCK();
            IF_TAIL();  // <<< Ajouté pour gérer else / elif
        } else {
            System.err.println("\"\\\"Erreur : expression invalide ou ':' manquant après 'if'\\\"\"");
            error=true;
        }
    } else{
        System.err.println("symbole inattendu ");
        error=true;
    }
}
    
    
    
    public void IF_TAIL(){
       
    if(tokens.get(p).token == TOKEN.TYPETOKEN.ELIF){
        p++;
        EXPR();
        if(tokens.get(p).token == TOKEN.TYPETOKEN.COLON ){
            p++;
            BLOCK();
            IF_TAIL(); // récursif pour plusieurs elif
        } else { 
            System.err.println("\"Erreur : expression invalide ou ':' manquant après 'elif'\"");
            error=true;
        }
    } else if(p < tokens.size() && tokens.get(p).token == TOKEN.TYPETOKEN.ELSE){
        p++;
        if(tokens.get(p).token == TOKEN.TYPETOKEN.COLON){
            p++;
            BLOCK();
        } else {
            System.err.println("\"\\\"Erreur : expression invalide ou ':' manquant après 'else'\\\"\"");
            error=true;
        }
    } else{}
}
    
    
    
   public void  BLOCK(){
      
    
    if(p < tokens.size() && tokens.get(p).token == TOKEN.TYPETOKEN.NEWLINE){
        p++;
        if(p < tokens.size() && tokens.get(p).token == TOKEN.TYPETOKEN.INDENT){
            p++;
            STATEMENT_LIST();
            if(p < tokens.size() && tokens.get(p).token == TOKEN.TYPETOKEN.DEDENT){
                p++;
            } else if(p >= tokens.size()){
                
            } else {
                System.err.println("Erreur : 'DEDENT' manquant. La fin du bloc n'est pas correctement indentée.");
                error=true;
            }
        } else {
            System.err.println("Erreur : 'INDENT' manquant. Les instructions du bloc doivent être indentées.");
            error=true;
        }
    } else {
        System.err.println("Erreur : retour à la ligne attendu après ':' pour débuter un bloc.");
        error=true;
    }
}
   
   
   
   public void EXPR(){
     OR_EXPR();
    }
   
    public void OR_EXPR(){
     AND_EXPR();
     OR_EXPR1();
    
    }
   
    
      public void OR_EXPR1(){
       if(tokens.get(p).token == TOKEN.TYPETOKEN.OR ){
         p++;
         AND_EXPR();
         OR_EXPR1();
       }else{}
      }
      
      
      public void AND_EXPR(){
      NOT_EXPR();
      AND_EXPR1();
      
      }
      
      public void AND_EXPR1(){
      if(tokens.get(p).token == TOKEN.TYPETOKEN.AND ){
         p++;
        NOT_EXPR();
        AND_EXPR1();
        }else{}
      
      }
      
      
      
      
      public void NOT_EXPR(){
      
          if(tokens.get(p).token == TOKEN.TYPETOKEN.NOT ){
              p++;
              NOT_EXPR();
          } else  {COMP_EXPR();}
      
      }
      
      
      
      public void COMP_EXPR(){
    FACTOR();
    while (p < tokens.size() && (tokens.get(p).token == TOKEN.TYPETOKEN.EQEQ ||
                                tokens.get(p).token == TOKEN.TYPETOKEN.NEQ ||
                                tokens.get(p).token == TOKEN.TYPETOKEN.LT ||
                                tokens.get(p).token == TOKEN.TYPETOKEN.LTE ||
                                tokens.get(p).token == TOKEN.TYPETOKEN.GT ||
                                tokens.get(p).token == TOKEN.TYPETOKEN.GTE)) {
        COMP_OP();
        FACTOR();
    }
}
      
      
      
      
      public void  COMP_EXPR1(){
    if (p < tokens.size() && 
        (tokens.get(p).token == TOKEN.TYPETOKEN.EQEQ ||
         tokens.get(p).token == TOKEN.TYPETOKEN.NEQ ||
         tokens.get(p).token == TOKEN.TYPETOKEN.LT ||
         tokens.get(p).token == TOKEN.TYPETOKEN.LTE ||
         tokens.get(p).token == TOKEN.TYPETOKEN.GT ||
         tokens.get(p).token == TOKEN.TYPETOKEN.GTE)) {
        COMP_OP();
        ADD_EXPR();
        COMP_EXPR1();
    } // sinon ε
}
      
      
      
      public void  COMP_OP (){
    if (tokens.get(p).token == TOKEN.TYPETOKEN.EQEQ) {
        p++;
    } else if (tokens.get(p).token == TOKEN.TYPETOKEN.NEQ) {
        p++;
    } else if (tokens.get(p).token == TOKEN.TYPETOKEN.LT) {
        p++;
    } else if (tokens.get(p).token == TOKEN.TYPETOKEN.LTE) {
        p++;
    } else if (tokens.get(p).token == TOKEN.TYPETOKEN.GT) {
        p++;
    } else if (tokens.get(p).token == TOKEN.TYPETOKEN.GTE) {
        p++;
    } 
}

      
      
      
      
       public void ADD_EXPR(){
    TERM();
    ADD_EXPR1();
}
      
       
       
       public void ADD_EXPR1(){
    if (p < tokens.size() && (tokens.get(p).token == TOKEN.TYPETOKEN.PLUS ||
                              tokens.get(p).token == TOKEN.TYPETOKEN.MINUS)) {
        p++;
        TERM();
        ADD_EXPR1();
    } else{}
}
        
       
       
       
       
       public void TERM() {
    FACTOR();  // le facteur de base
    TERM1();   // puis les opérations * / %
}
       
      public void TERM1(){
      if (p < tokens.size() && (tokens.get(p).token == TOKEN.TYPETOKEN.MULT ||
                              tokens.get(p).token == TOKEN.TYPETOKEN.DIV ||
                              tokens.get(p).token == TOKEN.TYPETOKEN.MOD)) {
        p++;
        FACTOR();
        TERM1();
    } else {}
}
      
     public void FACTOR(){
      if(tokens.get(p).token == TOKEN.TYPETOKEN.NUMBER  ){
         p++;
        } else  if(tokens.get(p).token == TOKEN.TYPETOKEN.TRUE  ){
         p++;
        } else  if(tokens.get(p).token == TOKEN.TYPETOKEN.FALSE  ){
         p++;
        }else  if(tokens.get(p).token == TOKEN.TYPETOKEN. IDENTIFIER  ){
         p++;
        }else if(tokens.get(p).token == TOKEN.TYPETOKEN.CHAINE) {
         p++;

        }else   if(tokens.get(p).token == TOKEN.TYPETOKEN. LPAREN  ){
         p++;
          EXPR();
          if(tokens.get(p).token == TOKEN.TYPETOKEN. RPAREN  ){
         p++;
          } else { System.err.println("manque parenthese fermante");
                 error=true;
                 }
        } else { System.err.println("symbole inatendu dans FACTOR()");
                 error=true;
                 }
     
     } 
      
      
      
      
    // main 
    
    public static void main(String[] args) {
        // 1️⃣ Lire le fichier
        String Fichier = "C:\\Users\\NIS\\Desktop\\mon code.txt";
        StringBuilder code = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(Fichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                code.append(ligne).append("\n"); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
     

       
        mylexer lexer = new mylexer(code.toString());
       
       List<TOKEN> tokens=  lexer.Analyser();
               System.out.println("nous token\n ");
    for (TOKEN tok : tokens) {
        System.out.println( tok.lexeme + "      Type : "+ tok.token);
       
    }
 lexer.PROGRAMME(tokens);
    
    
         
    
    
}}

    

Create Main.java
