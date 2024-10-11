import java.util.ArrayList;
import java.util.Random;

public class GridManager {

    boolean stoppSpill = false;
    ArrayList<ArrayList<snakePanel>> gridd;
    ArrayList<snakePanel> snake;
    ArrayList<snakePanel> ikkeSnake;
    snakePanel snakeHodet;
    snakePanel snakeHale;
    snakePanel eple;


    GridManager(int hoyde, int lengde) {

        ikkeSnake = new ArrayList<snakePanel>();
        snake = new ArrayList<snakePanel>();
        gridd = new ArrayList<>();

        for (int i = 0; i < hoyde; i++) {
            ArrayList<snakePanel> row = new ArrayList<>();
            for (int j = 0; j < lengde; j++) {
                row.add(null);
            }
            gridd.add(row);
        }
    }

    void add(snakePanel panel) {
        gridd.get(panel.y_hoyde).set(panel.x_bredde, panel);
        ikkeSnake.add(panel);
    }

    void genererStartSpill() {
        snakeHodet = gridd.get((gridd.size()/2)-1).get((gridd.get((gridd.size()/2)-1).size()/2)-1);

        for (int i = 0; i < 5; i++) {
            if (snakeHodet.y_hoyde - i >= 0 && gridd.get(snakeHodet.y_hoyde).get(snakeHodet.x_bredde) != null) {
                snake.addFirst(gridd.get(snakeHodet.y_hoyde).get(snakeHodet.x_bredde - i));
                gridd.get(snakeHodet.y_hoyde).get(snakeHodet.x_bredde - i).setBla();
            }else{
                System.out.println("banen er for liten. kan ikke generere slangen og eple.");
                System.exit(2);
            }
        }
        for (int i = 0; i < snake.size(); i++){
            ikkeSnake.remove(snake.get(i));
        }
        snakeHale = gridd.get(snakeHodet.y_hoyde).get(snakeHodet.x_bredde-4);
        eple = gridd.get(snakeHodet.y_hoyde).get(snakeHodet.x_bredde + 4);
        gridd.get(snakeHodet.y_hoyde).get(snakeHodet.x_bredde + 4).setRod();
    }
    void genererEple() {
        int randomTall = (int) (Math.random() * ikkeSnake.size());
        eple = ikkeSnake.get(randomTall);
        eple.setRod();
    }
    boolean harKresjet(int y_hoyde, int x_bredde){
        return (
                y_hoyde >= gridd.size() ||
                x_bredde >= gridd.getFirst().size() ||
                y_hoyde < 0 ||
                x_bredde < 0 ||
                gridd.get(y_hoyde).get(x_bredde).farge.equals("BLUE") ||
                stoppSpill
        );

    }
    boolean harLikKordinat(snakePanel felt1, snakePanel felt2){
        return felt1.x_bredde == felt2.x_bredde && felt1.y_hoyde == felt2.y_hoyde;
    }
    void flyttHodet(String retning){
        if (retning.equals("UP")){
            if(!harKresjet(snakeHodet.y_hoyde-1, snakeHodet.x_bredde))
                snakeHodet = gridd.get(snakeHodet.y_hoyde-1).get(snakeHodet.x_bredde); else stoppSpill = true;
            snakeHodet.setBla();
            snake.addLast(snakeHodet);
            return;
        }
        if (retning.equals("DOWN")){
            if(!harKresjet(snakeHodet.y_hoyde+1, snakeHodet.x_bredde))
                snakeHodet = gridd.get(snakeHodet.y_hoyde+1).get(snakeHodet.x_bredde); else stoppSpill = true;
            snakeHodet.setBla();
            snake.addLast(snakeHodet);
            return;
        }
        if (retning.equals("RIGHT")){
            if(!harKresjet(snakeHodet.y_hoyde, snakeHodet.x_bredde+1))
                snakeHodet = gridd.get(snakeHodet.y_hoyde).get(snakeHodet.x_bredde+1); else stoppSpill = true;
            snakeHodet.setBla();
            snake.addLast(snakeHodet);
            return;
        }
        if (retning.equals("LEFT")){
            if(!harKresjet(snakeHodet.y_hoyde, snakeHodet.x_bredde-1))
                snakeHodet = gridd.get(snakeHodet.y_hoyde).get(snakeHodet.x_bredde-1); else stoppSpill = true;
            snakeHodet.setBla();
            snake.addLast(snakeHodet);
            return;
        }
        System.out.println("retnings indikasjon ble feil gitt. ");
        System.exit(2);
    }
    void fjernHale(){
        snakeHale.setSvart();
        snake.remove(snakeHale);
        snakeHale = snake.getFirst();
    }
    boolean hentStoppSpill(){
        return stoppSpill;
    }
}
