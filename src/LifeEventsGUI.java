import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class LifeEventsGUI extends JFrame implements ActionListener {
    private ArrayList<JPanel> panels = new ArrayList<>();

    StringBuilder masterLog;
    Random rand;
    int age = -1;
    int year = 2020;

    LifeEventsGUI(StringBuilder masterLog){
        this.masterLog = masterLog;
        rand = new Random();
    }

    public void showPrompts(){
        String ageStr = JOptionPane.showInputDialog("How old is your character (leave blank for random)");
        boolean randomAge = false;
        try {
            age = Integer.parseInt(ageStr);
            if (age < 16 || age > 27) {
                randomAge = true;
            }
        } catch (NumberFormatException n) {
            randomAge = true;
        }

        if(randomAge){
            age = 16 + rand.nextInt(11);
        }

        JOptionPane.showMessageDialog(this,"Age is set too " + age);
        masterLog.append("Character age is " + age + '\n');

        String yearStr = JOptionPane.showInputDialog("What year is it?");

        try {
            year = Integer.parseInt(yearStr);
            if (year < 2000 || year > 3000) {
                randomAge = true;
            }
        } catch (NumberFormatException n) {
            year = 2020;
        }

        JOptionPane.showMessageDialog(this,"Year set too " + year);
        masterLog.append("The year is " + year + '\n');
    }

    public void init(){

        showPrompts();

        Container pane = this.getContentPane();

        for(JPanel panel: panels){
            pane.add(panel);
        }

        setSize(1000,800);
        setTitle("RPG Life Path 0.1");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
