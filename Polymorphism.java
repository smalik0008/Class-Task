/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorphism;

/**
 *
 * @author Smart Computers
 */

 class shape{
        int lengh;
        void color(){
            System.out.println("Shape color...");
        }
    }
    class circle extends shape{
        int height;
        void color(){
            System.out.println("Circle color...");
        }
    }
public class Polymorphism {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        shape c1=new circle();
        c1.color();
        c1=new shape();
        c1.color();
    }
}
