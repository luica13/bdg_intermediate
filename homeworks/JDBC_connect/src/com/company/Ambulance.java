package com.company;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.KeyEvent;
        import java.awt.event.KeyListener;

public class Ambulance extends JFrame implements ActionListener, KeyListener {
    private JButton openDoctorList = new JButton("Open DoctorList");
    private JLabel logoImgeLabel = new JLabel();
    private JLabel nameTextLabel = new JLabel();
    private Icon icon = new ImageIcon("nuaca.png");
    private JLabel generalText = new JLabel();
    private JButton deleteButton = new JButton("Delete");

    public Ambulance(){
        setLayout(new FlowLayout());
        Font myFont = new Font("Arial", Font.BOLD, 20);
        nameTextLabel.setFont(myFont);
        nameTextLabel.setText(("Company Name"));
        add(nameTextLabel);

        logoImgeLabel.setIcon(icon);
        add(logoImgeLabel);
        add(openDoctorList);
        add(deleteButton);
        openDoctorList.addActionListener(this);
        deleteButton.addActionListener(this);
        setSize(500, 800);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == openDoctorList){
            DoctorWindow doctorWindow = new DoctorWindow();
        }
        if(e.getSource() == deleteButton){
            DeleteDoctorWindow deleteDoctorWindow = new DeleteDoctorWindow();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
