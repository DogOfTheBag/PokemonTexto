package data;

/**
 *
 * @author alber
 */
public class Menu {
    private Combate c;
    private Pokemon[] p;

    public Menu(Combate c, Pokemon p[]) {
        this.c = c;
        this.p = p;
    }
//visualizar menu con opciones
    public void vis(int pokemonElegidoJ1, int pokemonElegidoJ2){
        System.out.println(p[pokemonElegidoJ1].toString());
        System.out.println(p[pokemonElegidoJ2].toString());
        System.out.println("Que desea hacer?");
        System.out.println("1: Atacar");
        System.out.println("2: Cambiar Pokemon");
    }
    
     /*pequeño metodo que "limpia" la pantalla de la consola*/
    private void CLS(){
        for (int i = 0; i < 50; i++) {
            System.out.println(" ");
            
        }
    }
    /*switch con las elecciones del usuario, uso thread.sleep para parar los mensajes
    y que se puedan leer bien*/
    public int gestionarMenu(int eleccion, boolean miTurno,int pokemonElegidoJ1, int pokemonElegidoJ2) throws InterruptedException{
       int nuevoPokemonElegido = -1;
        
        switch(eleccion){
            /*en caso de ataque, primero compruebo de quien es el turno, y hago el ataque*/
            case 1:
                //voy a tener que acabar cambiando lo del miTurno porque no es sostenible a largo plazo
                //Tambien voy a tener que cambiar lo de los pokemons para cuando quiera meter más de 2
                if (miTurno == true){
                    System.out.println(p[pokemonElegidoJ1].getNombre() + " ataca!");
                    Thread.sleep(1000);
                    c.cambiarVida(c.atacar(),pokemonElegidoJ2);
                }
                else{
                    System.out.println(p[pokemonElegidoJ2].getNombre() + " ataca!");
                    Thread.sleep(1000);
                    c.cambiarVida(c.atacar(),pokemonElegidoJ1);
                }
                break;
           /*en caso de cambiar pokemon, compruebo de quien es el turno, y 
            tomo el input del pokemon que quiere sacar, y después lo retorno*/
            case 2:
                if (miTurno == true){
                    nuevoPokemonElegido = c.elegirPokemon(1);
                    Thread.sleep(1000);
                    CLS();
                }
                else{
                   nuevoPokemonElegido = c.elegirPokemon(2);
                   Thread.sleep(1000);
                   CLS();
                }
                
            return nuevoPokemonElegido;

            default:
                System.out.println("La introduccion introducida no es valida");
                Thread.sleep(1000);
        }
        
        Thread.sleep(1000);
        CLS();
        //en caso predeterminado devuelvo -1, será importante en el main
        return -1;
    }
 




    
}
