/*VIDEOGAME A TURNI
DESCRIZIONE: Simulare un sistema di personaggi per un gioco a turni.
CASSI: 1-Personaggio(classe astratta)
2- guerriero,mago e archiere (Sotto classi di Personaggio)
FUNZIONALITA: Attacare e difendere con la gestione dell danno.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int scelta;
        int Agro;

        Mostrino goblin = new Mostrino(50, 100, "GOBLIN GUERRIERO", false);
        Guerriero Guerriero = new Guerriero(23, 50, 7, 3, false);
        Mago Stregone = new Mago(16, 80, 9, 5, false);
        Archiere Archiere = new Archiere(19, 65, 10, 4, false);

        int i;
        int vita;


        for (i = 0; !goblin.dead; i++) {


            if (i == 0 && !Guerriero.dead) {
                System.out.println("---è IL TURNO DEL GUERRIERO---\n"
                        + "-------------------------");
                System.out.println("GUERRIERO : Vita:" + Guerriero.vita + "   energia:" + Guerriero.energia + "\n"
                        + "-------------------------");
                System.out.println(goblin.nome + ": Vita:" + goblin.vita + "\n"
                        + "-------------------------");

                System.out.println("Che vuoi fare? \n"
                        + "Inserire 1) ATTACCA  =="+Guerriero.ad+"danno && "+" -10 di energia==\n"
                        + "Inserire 2) PROTEGGI =="+"+2 vita && +10 energia==\n"
                        + "Inserire 3) PASSA TURNO\n");

                scelta = myScanner.nextInt();

                switch (scelta) {

                    case 1:
                        System.out.println("==============================="
                                +"Il goblin riceve: " + Guerriero.ad + " di danno"
                                +"===============================");
                        goblin.vita = goblin.vita - Guerriero.ad;
                        Guerriero.energia = Guerriero.energia - 10;

                        if(goblin.vita<1){

                            System.out.println("GOBLIN UCCISSO!");
                            goblin.dead=true;
                        }

                        break;

                    case 2:
                        System.out.println("==============================="
                                +"Il guerriero indetreggia e si cura! |+2vita, +20 energia| "
                                +"===============================");
                        Guerriero.vita = Guerriero.vita + 2;
                        Guerriero.energia = Guerriero.energia + 20;

                        break;
                    case 3:
                        break;
                }
            } else {
                if (i == 1 && !Stregone.dead) {
                    System.out.println("---é IL TURNO DELLO STREGONE---\n"
                            + "-------------------------");
                    System.out.println("STREGONE: Vita:" + Stregone.vita + "   energia:" + Stregone.energia + "\n"
                            + "-------------------------");
                    System.out.println(goblin.nome + ": Vita:" + goblin.vita + "\n"
                            + "-------------------------");

                    System.out.println(" Che vuoi fare?\n"
                            +"Inserire 1) ATTACCA:   ==="+Stregone.ap+"danno && + -13 di energia==\n"
                            + "Inserire 2) PROTEGGI:    ===+2 vita && +25 energia==\n"
                            +"Inserire 3) PASSA TURNO");

                    scelta = myScanner.nextInt();

                    switch (scelta) {

                        case 1:
                            System.out.println("==============================="
                                    +"Il goblin riceve: " + Stregone.ap + " di danno"
                                    +"===============================");
                            goblin.vita = goblin.vita - Stregone.ap;
                            Stregone.energia = Stregone.energia - 13;

                            if(goblin.vita<1){
                                System.out.println("GOBLIN UCCISSO!");
                                goblin.dead=true;
                            }
                            break;

                        case 2:
                            System.out.println("==============================="
                                    +"Lo Stregone indetreggia e si cura! |+2vita, +25 energia| "
                                    +"===============================");
                            Stregone.vita = Stregone.vita + 2;
                            Stregone.energia = Archiere.energia + 25;

                            break;
                        case 3:
                            break;
                    }


                } else {
                    if (i == 2 && !Archiere.dead) {
                        System.out.println("---è IL TURNO DELL'ARCIERE---\n"
                                + "-------------------------");
                        System.out.println("ARCIERE : Vita:" + Archiere.vita + "   energia:" + Archiere.energia + "\n"
                                + "-------------------------");
                        System.out.println(goblin.nome + ": Vita:" + goblin.vita + "\n"
                                + "-------------------------");

                        System.out.println( "Che vuoi fare?\n"
                                +"Inserire 1) ATTACCA:     =="+ Archiere.ad +"danno && + -10 di energia==\\n\"\n"
                                +"Inserire 2) PROTEGGI:    ==+2 vita && +20 energia==\n"
                                +"Inserire 3) PASSA TURNO\n");

                        scelta = myScanner.nextInt();

                        switch (scelta) {

                            case 1:
                                System.out.println("==============================="
                                        +"Il goblin riceve: " + Archiere.ad + " di danno"
                                        +"===============================");
                                goblin.vita = goblin.vita - Archiere.ad;
                                Archiere.energia = Archiere.energia - 10;

                                if(goblin.vita<1){
                                    goblin.dead=true;
                                    System.out.println("GOBLIN UCCISSO!");
                                }
                                break;

                            case 2:
                                System.out.println("==============================="
                                        +"L'arciere indetreggia e si cura! |+2vita, +20 energia| "
                                        +"===============================");
                                Archiere.vita = Archiere.vita + 2;
                                Archiere.energia = Archiere.energia + 20;

                                break;
                            case 3:
                                break;
                        }
                    } else {
                        if (i == 3 && !goblin.dead) {//ATTACCO GOBLIN
                            Agro = 1+(int)(Math.random() * 2);
                            switch (Agro){

                                case 1:

                                    vita= goblin.Goblin_to_Hero(goblin.attacco,Guerriero.vita, Agro);
                                    if(vita<1){
                                        System.out.println("==Guerriero morto==");
                                        Guerriero.dead=true;
                                    }
                                    Guerriero.vita=vita;

                                    break;

                                case 2:

                                    vita= goblin.Goblin_to_Hero(goblin.attacco,Stregone.vita,Agro);


                                    if(vita<1){
                                        System.out.println("==Stregone morto==");
                                        Stregone.dead=true;
                                    }
                                    Stregone.vita=vita;

                                    break;

                                case 3:

                                    vita= goblin.Goblin_to_Hero(goblin.attacco, Archiere.vita,Agro);

                                    if(vita<1){
                                        System.out.println("==Arciere morto==");
                                        Archiere.dead=true;
                                    }

                                    Archiere.vita=vita;

                                    break;
                            }
                        }//FINE TURNO GOBLIN
                    }//FINE ELSE ARCIERE
                }//FINE ELSE STREGONE
            } //FINE ELSE GUERRIERO
        }//FINE FOR

        System.out.println("""
                |================================================================================================|
                |================================================================================================|
                |==========                                                                            ==========|
                |==========     =====                 =====    =============    =====        =====     ==========|
                |==========     =====                 =====    =============    ======       =====     ==========|
                |==========     =====                 =====        =====        =======      =====     ==========|
                |==========     =====                 =====        =====        ========     =====     ==========|
                |==========     =====                 =====        =====        =========    =====     ==========|
                |==========     =====                 =====        =====        ===== ====   =====     ==========|
                |==========     =====      =====      =====        =====        =====  ====  =====     ==========|
                |==========     =====    =========    =====        =====        =====   ==== =====     ==========|
                |==========     ===========     ===========    =============    =====    =========     ==========|
                |==========     =========         =========    =============    =====     ========     ==========|
                |==========                                                                            ==========|
                |================================================================================================|
                |================================================================================================|
                """);
    }//MAIN
}
