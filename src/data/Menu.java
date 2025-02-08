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

    public void vis(){
        System.out.println(p[0].toString());
        System.out.println(p[1].toString());
        System.out.println("Que desea hacer?");
        System.out.println("1: Atacar");
        System.out.println("2: Objetos");
        System.out.println("3: Cambiar Pokemon");
    }
    
     /*pequeño metodo que "limpia" la pantalla de la consola*/
    private void CLS(){
        for (int i = 0; i < 50; i++) {
            System.out.println(" ");
            
        }
    }
    /*switch con las elecciones del usuario, uso thread.sleep para parar los mensajes
    y que se puedan leer bien*/
    public void gestionarMenu(int eleccion, boolean miTurno) throws InterruptedException{
        int dinero;
        
        switch(eleccion){
            case 1:
                //voy a tener que acabar cambiando lo del miTurno porque no es sostenible a largo plazo
                //Tambien voy a tener que cambiar lo de los pokemons para cuando quiera meter más de 2
                if (miTurno == true){
                    System.out.println(p[0].getNombre() + " ataca!");
                    Thread.sleep(1000);
                    c.cambiarVida(c.atacar(),1);
                }
                else{
                    System.out.println(p[1].getNombre() + " ataca!");
                    Thread.sleep(1000);
                    c.cambiarVida(c.atacar(),0);
                }
                break;
                
            case 2:
                break;

            case 3:
                break;

            default:
                System.out.println("La introduccion introducida no es valida");
                Thread.sleep(1000);
        }
        
        Thread.sleep(1000);
        CLS();
    }

    public boolean cambiarTurno(boolean miTurno){
        if (miTurno == true)
            return miTurno = false;
        else
            return miTurno = true;
                
    }




    
}
