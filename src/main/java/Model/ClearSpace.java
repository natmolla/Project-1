package Model;

import java.io.IOException;

public class ClearSpace {

    public ClearSpace() {
        //for(int i = 0; i<5; i++){
        //    System.out.println();
        }

        public static void clearSpace() {
            for (int i = 0; i < 5; i++) {
                System.out.println();
            }
        }

    public static void clearSpaceLots() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    public class CLS {
        public static void main(String... arg) throws IOException, InterruptedException {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
    }


}
