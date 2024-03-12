import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Information_of_hotel extends JFrame {
    Information_of_hotel (){
JLabel lab1=new JLabel("this is information about our hotel");
    lab1.setBounds(10,10,300,10);
    lab1.setBackground(Color.BLACK);
    Font font1=new Font("serif",Font.BOLD,20);
    lab1.setFont(font1);
    JTextArea txta1=new JTextArea();
    txta1.setBounds(10,10,400,400);
    txta1.setEditable(false);
    JButton btn1=new JButton("back");
    btn1.setBounds(10,10,5,5);
    btn1.setForeground(Color.WHITE);
    btn1.setForeground(Color.BLACK);
    btn1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            choose_roll chooseRoll=new choose_roll();
        }
    });
    JButton btn2=new JButton("exit");
        btn2.setBounds(10,10,5,5);
        btn2.setForeground(Color.WHITE);
        btn2.setForeground(Color.BLACK);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JPanel pan1=new JPanel();
        JPanel pan2=new JPanel();
        pan1.setLayout(new GridLayout(2,1));
        pan2.setLayout(new GridLayout(1,2));
        pan1.add(lab1);
        pan1.add(txta1);
        pan2.add(btn1);
        pan2.add(btn2);
        add(pan1);
        add(pan2);
        setLayout(new GridLayout(2,1));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10,10,600,600);
        setLocationRelativeTo(null);
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\menga\\OneDrive\\Pictures\\hotel reservations\\download (1).jpg"));
            setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Information_of_hotel informationOfHotel=new Information_of_hotel();
    }
}
