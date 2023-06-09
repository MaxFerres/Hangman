import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Variablen

        Scanner s = new Scanner(System.in);
        boolean spielen = true;
        boolean starten = true;
        boolean option1 = false;
        boolean option2 = false;
        boolean containsLetter = false;
        boolean gameFinished = false;
        boolean correctInput = false;
        boolean richtigeLoesung = false;
        boolean eingabeKorrekt = false;
        int counter = 10;
        int leben = 10;
        int historyCount = 0;
        char [] wort = new char [0];
        char [] suchwort = new char [0];
        char [] historie = new char [counter];

        // Hauptschleife des Spiels

        while(spielen && !gameFinished && starten)
        {

            // Intro

            System.out.println(" _                                            ");
            System.out.println("| |                                            ");
            System.out.println("| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  ");
            System.out.println("|  _ \\ / _  | '_ \\ / _  | '_ ` _ \\ / _` | '_ \\ ");
            System.out.println("| | | | (_| | | | | (_| | | | | | | (_| | | | |");
            System.out.println("|_| |_|\\__,_|_| |_|\\__| |_| |_| |_|\\__|_|_| |_|");
            System.out.println("                    __/ |                      ");
            System.out.println("                   |____/" + "\n");


            // Option zum Spielstart

            while (starten)
            {
                System.out.println("Möchtest du das Spiel starten? [Y]es/[N]o");
                char start = s.next().charAt(0);

                if (start == 'y' || start == 'Y')
                {
                    starten = false;
                    counter = 10;
                    leben = 10;
                    eingabeKorrekt = false;
                    historyCount = 0;
                    historie = new char [counter];
                }
                else if (start == 'n' || start == 'N')
                {
                    spielen = false;
                    starten = false;
                    gameFinished = true;
                }
                else
                {
                    System.out.println("Falsche Nutzereingabe, bitte versuchen sie es erneut");
                }
            }



            // Nutzereingabe des Wortes

            while (!eingabeKorrekt && !gameFinished)
            {
                System.out.println("\n" + "Bitte gib als erstes ein Wort zum Raten ein");
                wort = s.next().toCharArray();

                for (int i = 0; i < wort.length; i++)
                {
                    if (wort[i] >= 'A' && wort[i] <= 'Z' || wort[i] >= 'a' && wort[i] <= 'z')
                    {
                        eingabeKorrekt = true;
                    }
                    else
                    {
                        eingabeKorrekt = false;
                        System.out.println("Falsche Eingabe! Bitte wiederhole deine Eingabe");
                        break;
                    }
                }

                if (eingabeKorrekt)
                {
                    for (int i = 0; i <= 20; i++)
                    {
                        System.out.print("\n");
                    }

                    suchwort = new char [wort.length];

                    // Eingegebenes Wort mit Unterstrichen darstellen
                    for (int i = 0; i < wort.length; i++)
                    {
                        suchwort [i] = '_';
                    }

                    System.out.println(suchwort);
                }
            }

            // Rundenschleife

            while(counter > 0 && !gameFinished)
            {
                while (!correctInput)
                {
                        System.out.println("\n" + "Bitte wähle aus folgenden Optionen: [1] [2]");
                        System.out.println("[1] Ich möchte einen Buchstaben eingeben");
                        System.out.println("[2] Ich möchte das Wort lösen");

                        char options = s.next().charAt(0);

                        if (options == '1')
                        {
                            correctInput = true;
                            option1 = true;
                        }
                        else if (options == '2')
                        {
                            correctInput = true;
                            option2 = true;
                        }
                        else
                        {
                            System.out.println("Bitte wiederhole die Eingabe");
                        }
                }

                // Eingabe Buchstabe

                if(option1)
                {
                    System.out.println("Bitte gib einen Buchstaben ein:");
                    char buchstabe = s.next().charAt(0);

                    for (int i = 0; i < wort.length; i++)
                    {
                        if (buchstabe == wort[i])
                        {
                            suchwort[i] = buchstabe;
                        }
                    }


                    for (int i = 0; i < wort.length; i++)
                    {
                        if (suchwort[i] == buchstabe)
                        {
                            System.out.println("\n" + "Herzlichen Glückwunsch, der eingegebene Buchstabe befindet sich an " + (i + 1) + "er Stelle");
                            System.out.println(suchwort);
                            containsLetter = true;
                        }
                    }

                    if (!containsLetter)
                    {
                        System.out.println("Leider konnte der eingegebene Buchstabe nicht im Wort gefunden werden");
                        System.out.println("-1 Versuch");
                        System.out.println("Noch " + (counter - 1) + " Versuche übrig");

                        historie [historyCount] = buchstabe;
                        historyCount++;

                        System.out.println("\n" + "Bisherige Falscheingaben");
                        System.out.println(historie);

                        drawHangman.TheHangman(leben);
                        counter--;
                        leben--;
                    }
                }

                // Eingabe Lösungswort

                if(option2)
                {
                    System.out.println("Bitte gib das Lösungswort an:");
                    char [] loesungEingabe = s.next().toCharArray();
                    System.out.println(wort);

                    for (int i = 0; i < wort.length; i++)
                    {
                        if (loesungEingabe [i] == wort [i])
                        {
                            richtigeLoesung = true;
                        }
                        else
                        {
                            richtigeLoesung = false;
                            break;
                        }
                    }

                    if (richtigeLoesung)
                    {
                        System.out.println("Herzlichen Glückwunsch, du hast die richtige Lösung gefunden!");
                        System.out.println("Das Spiel ist fertig, du wirst wieder zum Start des Programms geführt");
                        counter = 0;
                        starten = true;
                        spielen = true;
                    }
                    else
                    {
                        System.out.println("Leider stimmt das eingegebene Wort nicht mit der Lösung überein");
                        drawHangman.TheHangman(leben);
                        counter--;
                        leben--;
                    }
                }
                option1 = false;
                option2 = false;
                containsLetter = false;
                correctInput = false;
            }
        }
    }
}

