import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
public class Rooms extends JFrame {
    Rooms(){
                JLabel lab1=new JLabel("welcome to rooms");
                lab1.setBounds(10,10,200,20);
                JButton btn1=new JButton("all free rooms");
                btn1.setBounds(20,40,30,30);
                btn1.setBackground(Color.ORANGE);
                btn1.setForeground(Color.black);
                btn1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame1=new JFrame("available rooms are");
                        JPanel pan1=new JPanel();
                        JLabel lab1=new JLabel("the available rooms are ") ;
                        lab1.setBounds(20,20,300,20);
                        lab1.setForeground(Color.green);
                Font font1=new Font("new Roman",Font.BOLD,20);
                lab1.setFont(font1);
                JTextArea txta1=new JTextArea();
                txta1.setSize(600,600);
                txta1.setBackground(Color.CYAN);
                JPanel pan2=new JPanel();
                JPanel pan3=new JPanel();
                frame1.add(lab1);
                pan1.setLayout(new GridLayout(2,1));
                pan1.add(lab1);
                pan1.add(txta1);
                pan2.setLayout(new GridLayout(1,1));
                pan2.add(pan1);
                frame1.add(pan2);
                frame1.setVisible(true);
                frame1.setBounds(10,10,600,600);
                frame1.setLocationRelativeTo(null);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        try {
                            BufferedImage image = ImageIO.read(new File("C:\\Users\\menga\\OneDrive\\Pictures\\hotel reservations\\download (1).jpg"));
                            frame1. setIconImage(image);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String jdbcUrl = "jdbc:mysql://localhost:3306/hotel";
                    String username = "root";
                    String password = "262088";
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel",
                            "root","262088");
                    Statement statement1=connection.createStatement();
                    ResultSet resultSet1=statement1.executeQuery("select * from rooms");
                    String[] columnNames = {"room_number", "number_of_person_it_holds", "price_of_room_per_day","status"};
                    Object[][] data = new Object[100][4];
//                    txta1.append("room no"+"\t"+"No ofperson "+"\t"+"price \n");
                    
                    int i = 0;
                    while (resultSet1.next()) {

                        data[i][0] = resultSet1.getString("room_number");
                        data[i][1] = resultSet1.getDouble("number_of_person_it_holds");
                        data[i][2] = resultSet1.getInt("price_of_room_per_day");
                        data[i][3] =resultSet1.getString("status");

                        i++;
                        
                    }

                    JTable table = new JTable(data, columnNames);
                    table.setSize(400, 400);
                    table.setVisible(true);
                    frame1.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
                    frame1.setVisible(true);
                    frame1.setLocationRelativeTo(null);

                    while (resultSet1.next()){
                     txta1.append(resultSet1.getString(1)+"\t"+resultSet1.getString(2)+
                             "\t"+resultSet1.getString(3)+"\n");

                    }
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }




            }

        });
        JButton btn2=new JButton("exit");
        btn2.setBounds(20,40,30,30);
        btn2.setBackground(Color.ORANGE);
        btn2.setForeground(Color.black);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JButton btn3=new JButton("back");
        btn3.setBounds(20,40,30,30);
        btn3.setBackground(Color.ORANGE);
        btn3.setForeground(Color.black);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                  Start_interface start_interface=new Start_interface();
                              }
        });

        JPanel roompan1=new JPanel();
        roompan1.setBackground(Color.PINK);
        JPanel roompan2=new JPanel();

        roompan2.setLayout(new GridLayout(1,3,1,1));
        roompan1.setLayout(new GridLayout(1,1));
        Font font1=new Font("serif",Font.BOLD,20);
        lab1.setFont(font1);
        roompan1.add(lab1);
        roompan2.add(btn1);
        roompan2.add(btn2);
        roompan2.add(btn3);
        add(roompan1);
        add(roompan2);


                   setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
            setBounds(10,10,500,500);
            setTitle("ROOMS");
        setLocationRelativeTo(null);


    }

    public static void main(String[] args) {
        Rooms rooms=new Rooms();

    }

}
