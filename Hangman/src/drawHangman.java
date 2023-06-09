public class drawHangman {
    public static void TheHangman(int leben) {

        if(leben == 10) {
            System.out.println("|");
        }
        else if(leben == 9) {
            System.out.println("|");
            System.out.println("|");
        }
        else if(leben == 8) {

            System.out.println("| ");
            System.out.println("|");
            System.out.println("|");
        }
        else if(leben == 7) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(leben == 6) {
            System.out.println("|----------");
            System.out.println("|         |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(leben == 5) {
            System.out.println("|----------");
            System.out.println("|         |");
            System.out.println("|         O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(leben == 4) {
            System.out.println("|----------");
            System.out.println("|         |");
            System.out.println("|         O");
            System.out.println("|         |");
            System.out.println("|");
            System.out.println("|");
        }
        else if(leben == 3) {
            System.out.println("|----------");
            System.out.println("|         |");
            System.out.println("|         O");
            System.out.println("|        -|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(leben == 2) {
            System.out.println("|----------");
            System.out.println("|         |");
            System.out.println("|         O");
            System.out.println("|        -|-");
            System.out.println("|");
            System.out.println("|");
        }
        else if(leben == 1) {
            System.out.println("|----------");
            System.out.println("|         |");
            System.out.println("|          O");
            System.out.println("|         -|-");
            System.out.println("|         /");
            System.out.println("|");
        }
        else {
            System.out.println("|----------");
            System.out.println("|         |");
            System.out.println("|         O");
            System.out.println("|        -|-");
            System.out.println("|        /|\\ ");
            System.out.println("|");
            System.out.println("YOU DIED !!!");
        }

    }

}
