import javax.swing.*;
import java.awt.*;
public class SnakeGUI {
    JFrame mainFrame;
    int hoyde;
    int lengde;
    GridManager gridd;
    String retning;
    boolean fortsettSpill;
    public SnakeGUI(int gitthoyde, int gittlengde) {

        hoyde = gitthoyde;
        lengde = gittlengde;
        fortsettSpill = true;
        gridd = new GridManager(hoyde, lengde);


        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mainFrame = new JFrame("snake game");                                 // Oppretter JFrame
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                  // Setter standard operasjon når vinduet lukkes
        mainFrame.setLayout(new GridLayout(hoyde, lengde));       // setter gridd layout

        // Oppretter snakePanelene
        for (int i = 0; i < hoyde; i++){
            for (int j = 0; j < lengde; j++){
                snakePanel panel = new snakePanel(i,j);
                gridd.add(panel);
                panel.setPreferredSize(new Dimension(30, 30));
                panel.setBackground(Color.BLACK);
                mainFrame.add(panel);
            }
        }
        mainFrame.pack();                          // Tilpasser størrelsen på vinduet slik at alle komponenter får plass
        mainFrame.setLocationRelativeTo(null);     // Plasserer vinduet i midten av skjermen
        mainFrame.setResizable(false);             // hindrer endringer på størrelsen til vinduet
        mainFrame.setVisible(true);                // Gjør vinduet synlig
    }
    void startSpill() {
        gridd.genererStartSpill();
    }
    void setRetning(String nyRetning){
        retning = nyRetning;
        etTrekk();
    }
    boolean etTrekk(){
        if (fortsettSpill){
            if (gridd.hentStoppSpill()){
                fortsettSpill = false;
                return false;
            }else {
                gridd.flyttHodet(retning);
                if (!gridd.harLikKordinat(gridd.eple, gridd.snakeHodet)) gridd.fjernHale();
                else gridd.genererEple();
            }
            return true;
        }else return false;
    }
}
