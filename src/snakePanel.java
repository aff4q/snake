import javax.swing.*;
import java.awt.*;

public class snakePanel extends JPanel {
    int x_bredde;
    int y_hoyde;
    String farge = "BLACK";
    snakePanel(int gitty, int gittx){
        super();
        y_hoyde = gitty;
        x_bredde = gittx;
    }
    void setBla(){
        this.setBackground(Color.BLUE);
        farge = "BLUE";
    }
    void setRod(){
        this.setBackground(Color.RED);
        farge = "RED";
    }
    void setSvart(){
        this.setBackground(Color.BLACK);
        farge = "BLACK";
    }
    @Override
    public String toString() {
        return "x bredde: " + x_bredde + " y hoyde: " + y_hoyde + " farge: " + farge;
    }
}
