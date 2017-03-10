package a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}
 
public class Human {
 
    public static void main(String[] args) 
        throws Exception {
    	
    	String str = "北京市(朝阳区)(西城区)(海淀区)";
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }
    	
    	
        try {
            try {
                throw new Sneeze();
            } 
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } 
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }

    }
}












