package data;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author alber
 */

// clase combate, que almacena pokemons
public class Combate {
    private Pokemon  [] p;

    public Combate(Pokemon[] p) {
        this.p = p;
    }
    /*metodo encargado de generar un numero aleatorio para el ataque de un pokemon,
    además de generar el daño, tambien tiene posibilidad de dar un golpe critico*/
    public int atacar() throws InterruptedException{
       Random r = new Random(System.currentTimeMillis());
       //random para calcular los puntos de ataque, y otro para la probabilidad de critico
       int puntosAtaque = r.nextInt(0,15);
       
       int posibilidadCritico = r.nextInt(0,10);
       //si acerto el critico y no fallo el ataque, el golpe critico suma daño
       if (posibilidadCritico > 7 && puntosAtaque>0){
            puntosAtaque += 6;
            System.out.println("GOLPE CRITICO!!!");
        }
       //si el daño es 0 fallo, si no, mensaje de cuanto daño hizo
       if (puntosAtaque == 0)
           System.out.println("El ataque fallo...");
       else
           System.out.println("El ataque ha quitado " + puntosAtaque + " de vida al enemigo.");
       
       Thread.sleep(1000);
       return puntosAtaque;
       
   }
    //metodo para cuando atacan, restarle el daño a la vida actual del pokemon
   public void cambiarVida(int puntosAtaque, int pokemonAtacado){
       p[pokemonAtacado].setHp(p[pokemonAtacado].getHp()-puntosAtaque);
   }
//funcion para elegir o cambiar pokemon
   public int elegirPokemon(int numJugador){
       Scanner sc = new Scanner(System.in);
       /*primero comprobamos de quien es el turno, una vez comprobado
       le damos a elegir entre los pokemons de su equipo, y lo adaptamos a los detalles*/
       if (numJugador == 1){
            System.out.println("J1: Introduce el pokemon que quieras sacar: " + 
            p[0].getNombre() +" (1) " + p[1].getNombre() + " (2) " + p[2].getNombre() + " (3) ");
            int pokemonElegido = sc.nextInt()-1;
            return pokemonElegido;
       }
       /*en el primer caso, cogemos el siguiente entero y lo restamos a 1 para que
       se ajuste a las posiciones del array donde estan esos pokemons*/
       else{
            System.out.println("J2: Introduce el pokemon que quieras sacar: " + 
            p[3].getNombre() +" (1) " + p[4].getNombre() + " (2) " + p[5].getNombre() + " (3) ");
            int pokemonElegido = sc.nextInt()+2;
            return pokemonElegido;   
       }
       //en este caso igual, pero le sumamos 2
   }
   
      //mini metodo que cambia el turno
    public boolean cambiarTurno(boolean miTurno){
        if (miTurno == true)
            return miTurno = false;
        else
            return miTurno = true;
                
    }
   /*para comprobar si los equipos de los jugadores tienen todos los pokemons
   muertos, puedo hacer una funcion que recorra todo el equipo, coja los hp actuales
   y si todos son 0, acaba la partida y le da la victoria al otro
   
   el problema viene cuando matas a un pokemon y automaticamente te pida cambiar de pokemon
   tengo que ver como hacer eso.*/
}

