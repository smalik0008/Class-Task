import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class randomnum extends JFrame implements ActionListener {
    JButton generate;
    JLabel genlabel;

    randomnum() {
        generate = new JButton("Generate!");
        genlabel = new JLabel("  Generated Number");
        genlabel.setBorder(new LineBorder(Color.BLACK, 2));
        setTitle("Generator");
        generate.setBounds(300, 300, 100, 30);
        genlabel.setBounds(150, 120, 200, 30);
        setSize(500, 400);
        add(generate);
        add(genlabel);
        setLayout(null);
        generate.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generate) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    generateRandomNumber();
                }
            });
            t1.start();
        }
    }

    void generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(500);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            genlabel.setText("Error...");
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                genlabel.setText("  Generated Number: " + randomNumber);
            }
        });
    }
}

class Main {
    public static void main(String[] args) {
        randomnum r = new randomnum();
        r.setVisible(true);
    }
}
