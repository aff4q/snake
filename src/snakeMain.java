public class snakeMain {
    static boolean fortsettSpill = true;

    public static void main(String[] args) {
        SnakeGUI test = new SnakeGUI(16,26);
        test.startSpill();
        PilTasting testTast = new PilTasting(test);
        while (fortsettSpill){
                try {Thread.sleep(400);} catch (InterruptedException e){}
                if(test.retning != null) fortsettSpill = test.etTrekk();
        }
        System.out.println("FERDIGGGGG");
    }
}
