import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class off_staff_view2 {
    off_staff_view2(int a){
        JFrame frame= new JFrame();
        Object[][] data= new Object[a][5];
        frame.setVisible(true);
        frame.setLocation(450,50);
        frame.setResizable(true);
        frame.setSize(800,850);
        frame.setLayout(null);
        JButton add= new JButton();
        add.setText("Add");
        JButton back= new JButton("Back");
        add.setBounds(200,690,100,30);
        back.setBounds(350,750,100,30);
        JButton remove= new JButton();
        remove.setText("Remove");
        remove.setBounds(350,690,100,30);
        JButton but= new JButton();
        but.setText("Edit");
        but.setBounds(500,690,100,30);
        int f=0;

        try{


            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
            String sr="select * from students_list";
            Statement st=conn.createStatement();
            ResultSet rs= st.executeQuery(sr);
            while (rs.next()){
                data[f][0]=rs.getString(1);
                data[f][1]=rs.getString(3);
                data[f][2]=rs.getString(4);
                data[f][3]=rs.getInt(5);
                data[f][4]=rs.getString(6);
               f++;

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        String[] head={"Username","Students Name"," Students Roll_No","Students Class","Fees to be Paid"};
        JTable table= new JTable(data,head);
        JScrollPane scrollPane=new JScrollPane(table);
        table.setRowHeight(40);
        scrollPane.createVerticalScrollBar();
        scrollPane.createVerticalScrollBar();
        scrollPane.setBounds(100,100,650,550);
        frame.add(scrollPane);
        frame.add(but);
        frame.add(add);
        frame.add(remove);
        frame.add(back);
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  frame.dispose();
                  JFrame frame1= new JFrame();
                  frame1.setVisible(true);
                  frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                  frame1.setResizable(true);
                  frame1.setSize(500,500);
                  frame1.setLocation(450,150);
                  frame1.setLayout(null);
                  JLabel label= new JLabel("Enter Username");
                  JTextField textFielde= new JTextField();
                  JButton but1 = new JButton("Enter");
                  label.setBounds(100,100,100,30);
                  textFielde.setBounds(250,100,100,30);
                  but1.setBounds(260,200,100,30);
                  frame1.add(but1);
                  frame1.add(label);
                  frame1.add(textFielde);
                  but1.addActionListener(new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent e) {
                          String a= textFielde.getText();
                          if (e.getSource() == but1) {
                              frame1.dispose();
                              off_staff_student_edit ew = new off_staff_student_edit(a);
                          }
                      }
                  });


            }
        });
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                add_student l= new add_student();

            }
        });
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                remove_student l= new remove_student();

            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                office_Staff_view m= new office_Staff_view();
            }
        });
    }
}
