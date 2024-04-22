import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

// promenne
        JFrame okno = new JFrame();

        JLabel popis = new JLabel("Zde prosím zadejte kvadratickou rovnici ve formátu ax²+bx+c=0. Nezapomeňte zadat znaménka! ");
        popis.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel();

        JTextField prvni= new JTextField();
        JTextField druhe= new JTextField();
        JTextField treti = new JTextField();

//size na input okinka
        prvni.setPreferredSize(new Dimension(40,20));
        druhe.setPreferredSize(new Dimension(45,20));
        treti.setPreferredSize(new Dimension(45,20));

//xka a =0 pro rovnici
        JLabel nula = new JLabel("= 0");
        JLabel b = new JLabel("x");
        JLabel xnadruhou = new JLabel("x²");

//nastaveni borderu
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        prvni.setBorder(border);
        druhe.setBorder(border);

//nastavit vlastnosti panelu, pridat text fieldy a komponenty rovnice
        panel.setLayout(new FlowLayout());
        panel.add(prvni);
        panel.add(xnadruhou);
        panel.add(druhe);
        panel.add(b);
        panel.add(treti);
        panel.add(nula);

//panel a label na vysledek 1
        JPanel v1 = new JPanel();
        JLabel v1vysledek= new JLabel();
        v1.add(v1vysledek);
//panel a label na vysledek 2
        JPanel v2 = new JPanel();
        JLabel v2vysledek = new JLabel();
        v2.add(v2vysledek);

//button na pocitani
        JButton vypocitej = new JButton("Vypočítej");

//action listener na tlacitko
        vypocitej.addActionListener(new ActionListener() {
            @Override
            //parsovat hodnoty z textfieldu
            public void actionPerformed(ActionEvent e) {
                double a = Double.parseDouble(prvni.getText());
                double b = Double.parseDouble(druhe.getText());
                double c = Double.parseDouble(treti.getText());

                //logika pocitani
                double diskriminant = b * b - 4 * a * c;

                //check jestli diskriminant je vetsi jak 0
                if (diskriminant < 0) {

                    v1vysledek.setText("Rovnice není v realných číslech!" );
                    v2vysledek.setText("Rovnice není v realných číslec!");


                }

                //dopocitani kvadraticke rovnice
                else {
                    double v3 = (-b + Math.sqrt(diskriminant) )/ (2 * a);

                    double v4 = (-b - Math.sqrt(diskriminant) )/ (2 * a);
                //nastaveni hodnot do labelu
                    v1vysledek.setText("Výsledek je " + v3);
                    v2vysledek.setText("Výsledek je " + v4);
                }
            }
        });

//pridani komponent do framu
        okno.setLayout(new GridLayout(5,1));
        okno.add(popis);
        okno.add(panel);
        okno.add(vypocitej);
        okno.add(v1);
        okno.add(v2);

//nastaveni zbylejch rozmeru okna a setvisible
        okno.setTitle("Kalkulacka");
        okno.setSize(620,250);
        okno.setVisible(true);
        okno.setResizable(true);  
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
