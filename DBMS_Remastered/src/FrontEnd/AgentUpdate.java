package FrontEnd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class AgentUpdate extends JFrame {

    private JPanel contentPane;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField agentID;
    private JTextField propertyID;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AgentUpdate frame = new AgentUpdate();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AgentUpdate() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(51, 153, 255));

        JLabel lblNewLabel = new JLabel("Agent Checkbook");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JRadioButton rdbtnSold = new JRadioButton("Sold");
        buttonGroup.add(rdbtnSold);
        buttonGroup.add(rdbtnSold);
        rdbtnSold.setOpaque(false);

        JRadioButton rdbtnForSale = new JRadioButton("Up for Sale");
        buttonGroup.add(rdbtnForSale);
        buttonGroup.add(rdbtnForSale);
        rdbtnForSale.setOpaque(false);

        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        agentID = new JTextField();
        agentID.setColumns(10);

        propertyID = new JTextField();
        propertyID.setColumns(10);

        passwordField = new JPasswordField();

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Agent agent = new Agent();
                dispose();
                agent.setVisible(true);
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane
                .setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
                                        .createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
                                                .createSequentialGroup().addGap(63).addGroup(
                                                        gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                .addComponent(propertyID, GroupLayout.DEFAULT_SIZE, 185,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(
                                                                        agentID, GroupLayout.DEFAULT_SIZE, 185,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(passwordField))
                                                .addGap(376))
                                        .addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
                                                .createParallelGroup(Alignment.TRAILING)
                                                .addGroup(Alignment.LEADING,
                                                        gl_contentPane.createSequentialGroup().addGap(154)
                                                                .addComponent(btnSave)
                                                                .addPreferredGap(ComponentPlacement.RELATED, 78,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 73,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED))
                                                .addGroup(gl_contentPane.createSequentialGroup().addGap(76)
                                                        .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 278,
                                                                Short.MAX_VALUE)))
                                                .addGap(258)))
                                        .addGroup(gl_contentPane.createSequentialGroup().addGap(89)
                                                .addComponent(rdbtnSold).addGap(65).addComponent(rdbtnForSale)
                                                .addGap(324)))));
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE).addGap(0))
                .addGroup(gl_contentPane.createSequentialGroup().addGap(24)
                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(54)
                        .addComponent(propertyID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(37)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(78)
                        .addComponent(agentID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(63)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnSold)
                                .addComponent(rdbtnForSale))
                        .addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE).addGroup(gl_contentPane
                                .createParallelGroup(Alignment.BASELINE).addComponent(btnSave).addComponent(btnBack))
                        .addGap(53)));

        JLabel lbPropertyID = new JLabel("Property ID");
        lbPropertyID.setHorizontalAlignment(SwingConstants.RIGHT);
        lbPropertyID.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lbPassword = new JLabel("Password");
        lbPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        lbPassword.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lbID = new JLabel("ID");
        lbID.setHorizontalAlignment(SwingConstants.RIGHT);
        lbID.setFont(new Font("Tahoma", Font.BOLD, 14));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_panel.createSequentialGroup().addContainerGap(88, Short.MAX_VALUE)
                        .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                .addComponent(lbPropertyID, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbID, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbPassword, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                        .addGap(27)));
        gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup().addGap(123)
                        .addComponent(lbID, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(lbPassword, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(54)
                        .addComponent(lbPropertyID, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(212, Short.MAX_VALUE)));
        panel.setLayout(gl_panel);
        contentPane.setLayout(gl_contentPane);
    }

}
