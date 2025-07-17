package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeave extends JFrame implements ActionListener {

    Choice crollno, cTime;
    JDateChooser dcDate;
    JButton submit, cancel;

    StudentLeave(){
        setSize(500, 550);
        setLocation(550, 100);
        setLayout(null);

        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblRollNo = new JLabel("Search by Roll Number");
        lblRollNo.setBounds(60,100,200, 20);
        lblRollNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblRollNo);

        crollno = new Choice();
        crollno.setBounds(60, 130, 200,20);
        add(crollno);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(60,180,200, 20);
        lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblDate);

        dcDate = new JDateChooser();
        dcDate.setBounds(60, 210, 200, 25);
        add(dcDate);

        JLabel lblTime = new JLabel("Time Duration");
        lblTime.setBounds(60,260,200, 20);
        lblTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblTime);

        cTime = new Choice();
        cTime.setBounds(60, 290, 200,20);
        cTime.add("Full Day");
        cTime.add("Half Day");
        add(cTime);

        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String rollno = crollno.getSelectedItem();
            String date = ((JTextField) dcDate.getDateEditor().getUiComponent()).getText();
            String duration = cTime.getSelectedItem();
            String query = "insert into studentleave values('"+rollno+"', '"+date+"', '"+duration+"')";

            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeave();
    }
}
