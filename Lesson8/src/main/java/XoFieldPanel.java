import javax.swing.*;
import java.awt.*;

public class XoFieldPanel extends JPanel {

    public static final int GAME_MODE_HVAI = 0;
    public static final int GAME_MODE_HVH = 1;

    public XoFieldPanel() {
        setBackground(Color.LIGHT_GRAY);
    }

    public void startGame(int gameMode, int fieldSize, int winLength) {
        System.out.printf(" Game mode: %d%n Field size: %d%n Win length: %d%n", gameMode, fieldSize, winLength);
    }

}