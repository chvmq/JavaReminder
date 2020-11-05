import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Lary
 */
public class window extends JFrame {
    private int hour, min, sec;

    void nonEditable() {
        textArea1.setText("Время идёт...");
        textField1.setEditable(false);
        textField2.setEditable(false);
        textField3.setEditable(false);
        button1.setEnabled(false);
    }

    public static void main(String[] args) {
        window window = new window();
    }

    public window() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Reminder");
        setVisible(true);
        setResizable(false);

    }

    private void button1ActionPerformed(ActionEvent e) {

        nonEditable();

        hour = Integer.parseInt(textField1.getText());
        min = Integer.parseInt(textField2.getText());
        sec = Integer.parseInt(textField3.getText());

        Th th = new Th();

        th.setValHours(hour);
        th.setValMins(min);
        th.setValSec(sec);

        th.start();

        System.out.println("th is alive");

        try {
            th.join();
        } catch (Exception ex) {
            //System.out.println("hac catched")
        } finally {
            textArea1.setText("Время истекло");
            System.out.println("th is dead");
        }

    }

    private void button2ActionPerformed(ActionEvent e) {
        hour = 0;
        min = 0;
        sec = 0;
        textField1.setEditable(true);
        textField2.setEditable(true);
        textField3.setEditable(true);
        textField1.setText("0");
        textField2.setText("0");
        textField3.setText("0");
        button1.setEnabled(true);
        textArea1.setText("Введите значения");
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Lary
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- button2 ----
        button2.setText("RESET");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2, "cell 11 3");

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setText("Введите значения");
            textArea1.setEditable(false);
            textArea1.setFont(textArea1.getFont().deriveFont(textArea1.getFont().getSize() + 9f));
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1, "cell 9 4 8 4");

        //---- label1 ----
        label1.setText("hours");
        label1.setLabelFor(textField1);
        contentPane.add(label1, "cell 3 9");

        //---- label2 ----
        label2.setText("minutes");
        label2.setLabelFor(textField2);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label2, "cell 10 9");

        //---- label3 ----
        label3.setText("secunds");
        label3.setLabelFor(textField3);
        contentPane.add(label3, "cell 18 9");

        //---- textField1 ----
        textField1.setText("0");
        textField1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(textField1, "cell 1 11 7 1");

        //---- textField2 ----
        textField2.setText("0");
        textField2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(textField2, "cell 9 11 8 1");

        //---- textField3 ----
        textField3.setText("0");
        textField3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(textField3, "cell 18 11 6 1");

        //---- button1 ----
        button1.setText("CONFIRM");
        button1.setForeground(new Color(238, 238, 238));
        button1.setBackground(new Color(204, 0, 0));
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, "cell 10 17 7 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Lary
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

class Th extends Thread {

    int valHours, valMins, valSec;

    public void setValHours(int valHours) {
        this.valHours = valHours;
    }

    public void setValMins(int valMins) {
        this.valMins = valMins;
    }

    public void setValSec(int valSec) {
        this.valSec = valSec;
    }

    @Override
    public void run() {
            for (int j = valHours; j > 0; j--) {
                try {
                    sleep(1000 * 60 * 60);
                    System.out.println(j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int k = valMins; k > 0; k--) {
                try {
                    sleep(1000 * 60);
                    System.out.println(k);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = valSec; i >= 0; i--) {
                try {
                    sleep(1000);
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
