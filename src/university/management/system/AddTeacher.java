package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class AddTeacher extends JFrame implements ActionListener {

    JTextField tfName, tfFatherName, tfAddress, tfPhone, tfEmail, tfX, tfXII, tfAadhar;
    JLabel labelEmpId;
    JDateChooser dcdob;
    JComboBox cbCourse, cbBranch;

    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddTeacher(){

        setSize(900, 700);
        setLocation(350, 50);

        setLayout(null);

        //Heading
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310, 30, 500,50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        //Name
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(50, 150, 100, 30);
        lblName.setFont(new Font("serif", Font.BOLD, 20));
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(200, 150, 150, 30);
        add(tfName);

        //Father's Name
        JLabel lblfatherName = new JLabel("Father's Name");
        lblfatherName.setBounds(400, 150, 200, 30);
        lblfatherName.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfatherName);

        tfFatherName = new JTextField();
        tfFatherName.setBounds(600, 150, 150, 30);
        add(tfFatherName);

        //Roll No
        JLabel lblempid = new JLabel("Employee Id");
        lblempid.setBounds(50, 200, 200, 30);
        lblempid.setFont(new Font("serif", Font.BOLD, 20));
        add(lblempid);

        labelEmpId = new JLabel("101" + first4);
        labelEmpId.setBounds(200, 200, 200, 30);
        labelEmpId.setFont(new Font("serif", Font.BOLD, 20));
        add(labelEmpId);

        //Date of birth
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);

        //Address
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(50, 250, 200, 30);
        lblAddress.setFont(new Font("serif", Font.BOLD, 20));
        add(lblAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(200, 250, 150, 30);
        add(tfAddress);

        //Phone no.
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(400, 250, 200, 30);
        lblPhone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(600, 250, 150, 30);
        add(tfPhone);

        //Email
        JLabel lblEmail = new JLabel("Email id");
        lblEmail.setBounds(50, 300, 200, 30);
        lblEmail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(200, 300, 150, 30);
        add(tfEmail);

        //10th Percentage
        JLabel lblX = new JLabel("Class X in (%)");
        lblX.setBounds(400, 300, 200, 30);
        lblX.setFont(new Font("serif", Font.BOLD, 20));
        add(lblX);

        tfX = new JTextField();
        tfX.setBounds(600, 300, 150, 30);
        add(tfX);

        //12th Percentage
        JLabel lblXII = new JLabel("Class XII (%)");
        lblXII.setBounds(50, 350, 200, 30);
        lblXII.setFont(new Font("serif", Font.BOLD, 20));
        add(lblXII);

        tfXII = new JTextField();
        tfXII.setBounds(200, 350, 150, 30);
        add(tfXII);

        //Aadhar Number
        JLabel lblAadhar = new JLabel("Aadhar Number");
        lblAadhar.setBounds(400, 350, 200, 30);
        lblAadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblAadhar);

        tfAadhar = new JTextField();
        tfAadhar.setBounds(600, 350, 150, 30);
        add(tfAadhar);

        //Course
        JLabel lblCourse = new JLabel("Qualification");
        lblCourse.setBounds(50, 400, 200, 30);
        lblCourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblCourse);

        String course[] = {"B.Tech", "M.Tech", "BBA", "BCA", "MCA", "Bsc", "Msc", "BCom","MCom", "BA", "MA"};
        cbCourse = new JComboBox(course);
        cbCourse.setBounds(200, 400, 150, 30);
        add(cbCourse);

        //Branch
        JLabel lblBranch = new JLabel("Department");
        lblBranch.setBounds(400, 400, 200, 30);
        lblBranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblBranch);

        String branch[] = {"Computer Science", "AIML", "IT", "Electronics", "Mechanical", "Civil"};
        cbBranch = new JComboBox(branch);
        cbBranch.setBounds(600, 400, 150, 30);
        add(cbBranch);

        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
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
            String name = tfName.getText();
            String fName = tfFatherName.getText();
            String empId = labelEmpId.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String x = tfX.getText();
            String xii = tfXII.getText();
            String aadhar = tfAadhar.getText();
            String course = (String)cbCourse.getSelectedItem();
            String branch = (String)cbBranch.getSelectedItem();

            try{
                String query = "insert into teacher values('"+name+"', '"+fName+"', '"+empId+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+aadhar+"', '"+course+"', '"+branch+"')";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new AddTeacher();
    }

}

