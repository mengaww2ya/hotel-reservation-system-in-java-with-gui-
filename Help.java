import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Help extends JFrame {
    Help (){
        JLabel lab1=new JLabel("This is information that guid");
        lab1.setBounds(10,10,300,10);
        lab1.setBackground(Color.BLACK);
        lab1.setForeground(Color.BLUE);
        Font font1=new Font("serif",Font.BOLD,30);
        lab1.setFont(font1);
        JTextArea txta1=new JTextArea();
        txta1.setText("HELP\n Welcome to the UNITY Hotel Reservation System!\n" +
                "If you want to access our hotel reservation system, you must log in by filling our hotel id and  password\n " +
                "\n\thotel id is 'u01'and \n\tthe password is 'unity123'\n.\n" +
                "To create a new account, click the \"Sign Up\" button and fill the required information. " +
                "If you already have an account, click the \"Sign In\" button " +
                "and fill the required information.\n" +
                "If you need any assistance or have questions regarding the system, please refer to the information provided below:\n" +
                "\n" +
                "Making a Reservation:\n" +
                "To make a reservation, click the \"Check In\" button on the main screen.\n" +
                "Fill in the required details such as your name, number of guests, and room preferences.\n" +
                "Once all the information is entered, click the \"Check In\" button to confirm your reservation." +
                "\nRemember after you reserve a room don't forget generate recite by clicking 'see check in status'  \n" +
                " to checkout click the \\\"Check out\\\" button  and fill the required information on the main screen." +
                "to update your account information  click 'update' button. " +
                " " +


                "Searching for Availability:\n" +
                "If you want to check the availability of rooms for specific dates, click the \"see rooms \" button.\n and " +
                "if the status row is '1' or empty it is available and  if the status of room is '0' it is reserved" +
                "Enter the desired check-in and check-out dates, along with any other preferences, and click the \"Search\" button.\n" +
                "The system will display the available rooms based on your criteria.\n" +
                "\n" +
                "Contacting Customer Support:\n" +
                "If you require further assistance or have any inquiries, our customer support team is available for 24hours, 7days in week and for 30 days for month.\n" +
                "You can reach out to them by calling our toll-free number at [01163760376] or by sending an email to [unity_international_hotel@gmail.com].\n" +
                "thank you for using our hotel");
        txta1.setSize(400,600);
        txta1.setEditable(false);
        txta1.setLineWrap(true);
        txta1.setWrapStyleWord(true);
        txta1.getScrollableTracksViewportWidth();
        txta1.setDragEnabled(true);
        txta1.setBackground(Color.cyan);
        txta1.setFont(new Font("serif",Font.ROMAN_BASELINE,18));
        JButton btn2=new JButton("exit");
        btn2.setBounds(10,10,5,5);
        btn2.setBackground(Color.lightGray);
        btn2.setForeground(Color.BLACK);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JButton btn3=new JButton("back");
        btn3.setBounds(5,5,30,30);
        btn3.setBackground(Color.ORANGE);
        btn3.setForeground(Color.black);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Log_in log_in=new Log_in();

            }
        });
        JScrollPane scrollPane = new JScrollPane(txta1);
        JPanel pan1=new JPanel();
        JPanel pan2=new JPanel();
        pan1.add(lab1);
        pan1.add(btn2);
        pan1.add(btn3);
        pan2.add(scrollPane);
        add(pan2);
        add(pan1);
        pan2.setLayout(new GridLayout(1,1));
        pan1.setLayout(new GridLayout(6,1));
        setLayout(new GridLayout(2,1));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\menga\\OneDrive\\Pictures\\hotel reservations\\download (1).jpg"));
            setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Help help=new Help();
    }
}
