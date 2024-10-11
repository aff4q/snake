import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PilTasting {
    SnakeGUI guiRefferanse;
    PilTasting(SnakeGUI GUIObjekt) {
        guiRefferanse = GUIObjekt;
        guiRefferanse.mainFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        if (guiRefferanse.retning == null)
                            guiRefferanse.setRetning("UP");
                        else if (guiRefferanse.retning.equals("LEFT") || guiRefferanse.retning.equals("RIGHT")) {
                            guiRefferanse.setRetning("UP");
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (guiRefferanse.retning == null)
                            guiRefferanse.setRetning("DOWN");
                        else if (guiRefferanse.retning.equals("LEFT") || guiRefferanse.retning.equals("RIGHT")) {
                            guiRefferanse.setRetning("DOWN");
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (guiRefferanse.retning == null)
                            guiRefferanse.setRetning("RIGHT");
                        else if (guiRefferanse.retning.equals("UP") || guiRefferanse.retning.equals("DOWN")) {
                            guiRefferanse.setRetning("RIGHT");
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (guiRefferanse.retning == null)
                            guiRefferanse.setRetning(null);
                        else if (guiRefferanse.retning.equals("UP") || guiRefferanse.retning.equals("DOWN")) {
                            guiRefferanse.setRetning("LEFT");
                        }
                        break;
                }
            }
        });
    }
}
