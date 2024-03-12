import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Welcome extends JFrame {
    Welcome(){
    JLabel lab1=new JLabel("                  Welcome to unity hotel");
    lab1.setForeground(Color.BLUE);
    lab1.setBounds(30,30,200,30);
    lab1.setFont(new Font("serif",Font.BOLD,18));
    JButton btn1=new JButton("sign in");
    btn1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            Sign_in login=new Sign_in();
        }
    });
    btn1.setForeground(Color.BLACK);
    btn1.setBackground(Color.cyan);
    btn1.setBounds(10,10,30,30);
    JButton btn2=new JButton("sign up");
        btn2.setBackground(Color.cyan);
        btn2.setForeground(Color.BLACK);
    btn2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            Sign_up signUp=new Sign_up();
        }
    });
    JButton btn3=new JButton("EXIT");
    btn3.setForeground(Color.BLACK);
    btn3.setBackground(Color.cyan);
        btn3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        JButton btn4=new JButton("back");
        btn4.setBounds(20,40,30,30);
        btn4.setBackground(Color.cyan);
        btn4.setForeground(Color.BLACK);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible( false);
                choose_roll choose_roll=new choose_roll();

            }
        });
        JPanel welcome_pane1=new JPanel();
    JPanel welcome_pane2=new JPanel();
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon("C:\\Users\\menga\\OneDrive\\Pictures\\Screenshots\\welcom.PNG");
        label.setIcon(icon);
        welcome_pane1.add(label);
        welcome_pane1.add(lab1);
        welcome_pane2.add(btn1);
        welcome_pane2.add(btn2);
        welcome_pane2.add(btn3);
        welcome_pane2.add(btn4);

        add(welcome_pane1);
        add(welcome_pane2);

        welcome_pane2.setLayout(new GridLayout(2,2));
        welcome_pane1.setLayout(new GridLayout(2,1));
        LayoutManager layoutManager3=new GridLayout(2,1,10,10);
            setLayout(layoutManager3);
        Font font1=new Font("new Roman",Font.BOLD,20);
      lab1.setFont(font1);
        setTitle("welcome to unity hotel!!");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setBounds(20,20,400,400);
    setLocationRelativeTo(null);
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\menga\\OneDrive\\Pictures\\hotel reservations\\download (1).jpg"));
            setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
}

    public static void main(String[] args) {
        Welcome welcome=new Welcome();
    }
}
