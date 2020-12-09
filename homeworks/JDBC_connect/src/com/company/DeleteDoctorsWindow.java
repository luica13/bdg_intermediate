package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDoctorsWindow extends JFrame implements ActionListener {
    private JTextField doctorIdInput = new JTextField(1);
    private JButton deleteDoctorButton = new JButton("Delete doctor");

    public DeleteDoctorsWindow(){
        setLayout(new FlowLayout());
        add(deleteDoctorButton);
        deleteDoctorButton.addActionListener(this);
        setSize(200,150);
        setVisible(true);
        add(doctorIdInput);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deleteDoctorButton){
            DoctorsList doctorsList = new DoctorsList();
            doctorsList.deleteDoctor(Integer.parseInt(doctorIdInput.getText()));
        }

    }
}

