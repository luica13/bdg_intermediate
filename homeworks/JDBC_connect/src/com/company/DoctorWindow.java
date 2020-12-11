package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class DoctorWindow extends JFrame implements ActionListener {
    private JButton select = new JButton("Select");
    private JButton save = new JButton("Save");
    private JButton saveupdate = new JButton("Save Update");
    private JTextArea doctortext = new JTextArea(15, 30);
    private JTextField authorid = new JTextField(10);
    private JTextField doctorname = new JTextField(10);
    private JTextField doctorlname = new JTextField(10);
    private JTextField doctormog = new JTextField(10);
    private JTextField doctorgroupId = new JTextField(10);
    private JLabel textdoctorid = new JLabel();
    private JLabel textdoctorname = new JLabel();
    private JLabel textdoctorlname = new JLabel();
    private JLabel textdoctormog = new JLabel();
    private JLabel textdoctorgroupId = new JLabel();

    public DoctorWindow() {
        setLayout(new FlowLayout());
        setSize(400, 400);
        setVisible(true);
        add(select);
        add(doctortext);

        Font myFont = new Font("Arial", Font.BOLD, 13);
        textdoctorid.setFont(myFont);

        textdoctorname.setFont(myFont);
        textdoctorname.setText(("name"));
        add(textdoctorname);
        add(doctorname);

        textdoctorlname.setFont(myFont);
        textdoctorlname.setText(("lname"));
        add(textdoctorlname);
        add(doctorlname);

        textdoctormog.setFont(myFont);
        textdoctormog.setText(("MOG"));
        add(textdoctormog);
        add(doctormog);

        textdoctorgroupId.setFont(myFont);
        textdoctorgroupId.setText(("doctor group"));
        add(textdoctorgroupId);
        add(doctorgroupId);
        add(saveupdate);
        select.addActionListener(this);
        save.addActionListener(this);
        saveupdate.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == select) {
            DoctorsList doctorList = new DoctorsList();
            doctorList.doctorFill();
            doctorList.doctorFill();

            doctortext.setText(doctorList.textDoctor());
        }
        if (e.getSource() == saveupdate) {
            DoctorsList doctorList = new DoctorsList();
            doctorList.insertDoctor(doctorname.getText(), doctorlname.getText(),
                    Double.parseDouble(textdoctormog.getText()), Integer.parseInt(doctorgroupId.getText()));


            doctortext.setText(doctorList.textDoctor());
        }
    }
}
