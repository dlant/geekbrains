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
        drawField(fieldSize);
        repaint();
    }


    public void drawField(int fieldSize){
        setBackground(Color.LIGHT_GRAY);
        repaint();
//            super("Кнопки");
            setSize(300, 400);
//            setResizable(false);
            JButton buttons[] = new JButton[9];//Создаю массив из 9 кнопок
            JPanel panel = new JPanel();//Создаю панель на которую буду размещать кнопки
            panel.setLayout(null);//Говорю что не буду использовать менеджер размещений и задам координа в ручную
            int x = 30, y = 30; // Начальные координаты первой кнопки
            int wide = 50, height = 50;//Размер кнопки
            for (int i = 0; i < 10; ) {//Пробегаем массив кнопок
                for (int j = 0; j < 3 && i < 9; j++) {//формируем "матрицу"
                    buttons[i] = new JButton("" );//Создание I-той кнопки
                    buttons[i].setSize(wide, height);//Задаем I-той кнопке размер
                    buttons[i].setLocation(x, y);//Задаем I-той кнопке координаты
                    panel.add(buttons[i]);//Добавляем I-тую кнопку на панель
                    y += 60; //Задаем смещение строки по У
                    i++;//переходим к следующей кнопке
                }
                x += 60;//Задаем смещение столбца по Х
                y = 30;//Возвращаем строку на начало
                if (i + 1 == 10) {
                    break;
                }
            }
            add(panel);//Устанавливаем панель в качестве контента окна
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setVisible(true);
        repaint();
        }
}