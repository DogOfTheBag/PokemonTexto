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
        //creamos objetos de pokemons, menu, combate, scanner...
        Pokemon [] p = {
            new Pokemon("Pikachu",23),
            new Pokemon("Fuecoco",51),
            new Pokemon("Magnemite",78),
            new Pokemon("Bulbasaur",25),
            new Pokemon("Cyndaquil",42),
            new Pokemon("Piplup",75),
         };
        
        Combate c = new Combate(p);
        Menu m = new Menu(c,p);
        Scanner sc = new Scanner(System.in);
        //el turno inicial será del J1
        boolean miTurno = true;
        //eligen pokemons iniciales los dos jugadores
        int pokemonElegidoJ1 = c.elegirPokemon(1);
        
        int pokemonElegidoJ2 = c.elegirPokemon(2);
        
        //comienza el combate, visualizamos menu y damos a elegir la opcion deseada al jugador        
        do{
            m.vis(pokemonElegidoJ1,pokemonElegidoJ2);
            int eleccion = sc.nextInt();
            int nuevoPokemonElegido = m.gestionarMenu(eleccion, miTurno,pokemonElegidoJ1,pokemonElegidoJ2);
            
            /*creamos la variable nuevo pokemon elegido por si el jugador quiere cambiar de pokemon,
            que se guarde ahí su input.
            si el sistema detecta esa variable con un -1, significa que no quiere cambiar de pokemon nadie
            (de ahi el retorno default en -1), y si no, cambia el pokemon elegido al pedido por el jugador*/
            if (nuevoPokemonElegido != -1){
                if(miTurno == true)
                    pokemonElegidoJ1 = nuevoPokemonElegido;
                else
                    pokemonElegidoJ2 = nuevoPokemonElegido; 
            }
            miTurno = c.cambiarTurno(miTurno);
        }while(p[pokemonElegidoJ1].getHp() > 0 && p[pokemonElegidoJ2].getHp() > 0);
        // el combate dura hasta que se derrote a un pokemon rival
        
        
        //dependiendo de que pokemon se quede sin vida se muestra 
        if (p[pokemonElegidoJ1].getHp()<1)
            System.out.println("GANADOR: JUGADOR 2 ");
        else
            System.out.println("GANADOR: JUGADOR 1 ");
        
        
    }
    
}
