package FrontEnd;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class AgOffView extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AgOffView frame = new AgOffView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    String getQuoted(String input) {
        return "'" + input + "'";
    }

    /**
     * Create the frame.
     */
    public AgOffView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(51, 153, 255));

        JLabel lblNewLabel = new JLabel("Agent Office View");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JTextArea textArea = new JTextArea();
        textArea.setVisible(true);

        textField = new JTextField();
        textField.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AgentOffice AO = new AgentOffice();
                dispose();
                AO.setVisible(true);
            }
        });

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Sales Records");
        rdbtnNewRadioButton.setOpaque(false);
        buttonGroup.add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Rents Records");
        rdbtnNewRadioButton_1.setOpaque(false);
        buttonGroup.add(rdbtnNewRadioButton_1);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
                int agentid = Integer.parseInt(textField.getText());
                JDBCView view;
                String output = "Please enter a valid agent id...\n";
                if(rdbtnNewRadioButton.isSelected()){
                    String query = "select * from Property where sold = 1 and id in ";
                    query += "(select property from Agent_property where Agent_id = " + agentid + ")";
                    view = new JDBCView(query);
                    output = view.run();
                }
                else if(rdbtnNewRadioButton_1.isSelected()){
                    String query = "select * from Property where sold = 1 and sale_rent = 'rent' and id in ";
                    query += "(select property from Agent_property where Agent_id = " + agentid + ")";
                    view = new JDBCView(query);
                    output = view.run();
                }
                textArea.setText(output);
                textArea.setVisible(true);
                textArea.setEditable(false);
                textField.setText(null);
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
                .createSequentialGroup()
                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup().addGap(76)
                                .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE).addGap(270))
                        .addGroup(gl_contentPane.createSequentialGroup().addGap(59)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                .addGap(85).addComponent(rdbtnNewRadioButton).addGap(18)
                                .addComponent(rdbtnNewRadioButton_1).addGap(54))
                        .addGroup(gl_contentPane.createSequentialGroup().addGap(91)
                                .addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                .addGap(117)
                                .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                .addGap(279))
                        .addGroup(gl_contentPane.createSequentialGroup().addGap(20)
                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                                .addGap(11)))));
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup().addGap(24)
                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(68)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdbtnNewRadioButton).addComponent(rdbtnNewRadioButton_1))
                        .addGap(59).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE).addGap(18)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnSubmit)
                                .addComponent(btnBack))
                        .addGap(55))
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE).addGap(0)));

        JPanel panel_1 = new JPanel();
        scrollPane.setViewportView(panel_1);

        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addComponent(textArea,
                Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE));
        gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addComponent(textArea,
                GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE));
        panel_1.setLayout(gl_panel_1);

        JLabel lblNewLabel_1 = new JLabel("Agent ID");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_panel.createSequentialGroup().addContainerGap(102, Short.MAX_VALUE)
                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                        .addGap(35)));
        gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup().addGap(135)
                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(359, Short.MAX_VALUE)));
        panel.setLayout(gl_panel);
        contentPane.setLayout(gl_contentPane);
    }
}
