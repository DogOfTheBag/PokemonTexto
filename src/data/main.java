package data;

import java.util.Scanner;

/**
 *
 * @author alber
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        
        Pokemon [] p = {
            new Pokemon("Pikachu",23),
            new Pokemon("Bulbasaur",25),
            new Pokemon("Fuecoco",51),
            new Pokemon("Cyndaquil",42),
            new Pokemon("Magnemite",78),
         };
        Combate c = new Combate(p);
        Menu m = new Menu(c,p);
        Scanner sc = new Scanner(System.in);
        boolean miTurno = true;
        
        do{
            m.vis();
            int eleccion = sc.nextInt();
            m.gestionarMenu(eleccion, miTurno);
            miTurno = m.cambiarTurno(miTurno);
        }while(p[0].getHp() > 0 && p[1].getHp() > 0);
        
        if (p[0].getHp()<1)
            System.out.println("GANADOR: " + p[1].getNombre());
        else
            System.out.println("GANADOR: " + p[0].getNombre());
        
        
    }
    
}
