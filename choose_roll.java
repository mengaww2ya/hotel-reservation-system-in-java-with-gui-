import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class choose_roll extends JFrame {
    choose_roll(){
        JLabel lab1=new JLabel("what is your roll choose one");
        lab1.setBounds(10,10,300,20);
        lab1.setFont(new Font("serif",Font.BOLD,30));
        lab1.setForeground(Color.BLUE);
        lab1.setBackground(Color.pink);
        JLabel lab2=new JLabel("             who are you ?");
        lab2.setForeground(Color.BLUE);
        lab2.setBackground(Color.PINK);
        lab2.setFont(new Font("serif",Font.PLAIN,18));
        String roll[] ={"customer","manager"};
        JComboBox comboBox1=new JComboBox<>(roll);
        comboBox1.setBackground(Color.pink);
        comboBox1.setForeground(Color.BLUE);
        JButton btn1=new JButton("Go");
        btn1.setBackground(Color.pink);
        btn1.setForeground(Color.BLUE);
        btn1.setBounds(10,10,5,5);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String  roll= (String) comboBox1.getSelectedItem();
                if (roll.equals("customer")){
                    setVisible(false);
                    Welcome welcome=new Welcome();
                }
                else {
                    setVisible(false);
                    Log_in_asmangaer log_in_asmangaer=new Log_in_asmangaer();
                }

            }
        });
        JButton btn2=new JButton("exit");
        btn2.setBackground(Color.pink);
        btn2.setForeground(Color.BLUE);
        btn2.setBounds(10,10,5,5);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
//        JButton btn3=new JButton("help");
//        btn3.setBackground(Color.pink);
//        btn3.setForeground(Color.BLUE);
//        btn3.setBounds(10,10,5,5);
//                btn3.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        setVisible(false);
//                        Help help=new Help();
//                    }
//                });
        JButton btn4=new JButton("back");
        btn4.setBounds(20,40,30,30);
        btn4.setBackground(Color.pink);
        btn4.setForeground(Color.BLUE);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Log_in log_in =new Log_in();
            }
        });
        JPanel pan1=new JPanel();
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon("C:\\Users\\menga\\OneDrive\\Pictures\\Screenshots\\chooose roll.PNG "); // Replace with the path to your image file
        label.setIcon(icon);

        // Add the label to the panel
        pan1.add(label);
        JPanel pan2 =new JPanel();
        pan1.setLayout(new GridLayout(2,1));
        pan2.setLayout(new GridLayout(4,2));
        pan2.setBackground(Color.CYAN);
        pan1.setBackground(Color.cyan);
        pan1.add(lab1);
        pan2.add(lab2);
        pan2.add(comboBox1);
        pan2.add(btn1);
        pan2.add(btn2);
//        pan2.add(btn3);
        pan2.add(btn4);
        add(pan1);
        add(pan2);
        setLayout(new GridLayout(2,1));
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("SELECT YOUR ROLL");
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\menga\\OneDrive\\Pictures\\hotel reservations\\download (1).jpg"));
            setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {

        choose_roll chooseRoll=new choose_roll();
    }
}
