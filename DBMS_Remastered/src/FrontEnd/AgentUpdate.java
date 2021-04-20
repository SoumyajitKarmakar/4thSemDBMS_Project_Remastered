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
    private JTextField textField;

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

        JRadioButton rdbtnSold = new JRadioButton("On Sale");
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
                int sold = 0;
                if (rdbtnSold.isSelected()) {
                    sold = 1;
                }
                String textCommand = "update Property set sold = " + sold + " where id=" + propertyID.getText();
                JDBCUpdate command = new JDBCUpdate(textCommand);
                command.run();
                System.out.println("Update complete");
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

        JRadioButton rdbtnSoldrented = new JRadioButton("Sold/Rented");
        buttonGroup.add(rdbtnSoldrented);
        rdbtnSoldrented.setOpaque(false);

        textField = new JTextField();
        textField.setColumns(10);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
                .createSequentialGroup()
                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
                        .createSequentialGroup()
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup().addGap(154).addComponent(btnSave)
                                        .addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                        .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 73,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED))
                                .addGroup(gl_contentPane.createSequentialGroup().addGap(76).addComponent(lblNewLabel,
                                        GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)))
                        .addGap(258))
                        .addGroup(gl_contentPane.createSequentialGroup().addGap(83).addGroup(gl_contentPane
                                .createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(propertyID, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                        .addComponent(agentID, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                        .addComponent(passwordField))
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
                                .addGap(175)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(rdbtnSoldrented, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rdbtnForSale, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(rdbtnSold, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addGap(82)))));
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE).addGap(0))
                .addGroup(gl_contentPane.createSequentialGroup().addGap(24)
                        .addGroup(gl_contentPane
                                .createParallelGroup(
                                        Alignment.LEADING)
                                .addGroup(Alignment.TRAILING,
                                        gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(54)
                                                .addComponent(propertyID, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(37)
                                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(78).addComponent(agentID, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(Alignment.TRAILING,
                                        gl_contentPane.createSequentialGroup().addComponent(rdbtnSold).addGap(11)))
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup().addGap(34).addComponent(textField,
                                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_contentPane.createSequentialGroup().addGap(18).addComponent(rdbtnForSale)))
                        .addGap(18).addComponent(rdbtnSoldrented)
                        .addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE).addGroup(gl_contentPane
                                .createParallelGroup(Alignment.BASELINE).addComponent(btnSave).addComponent(btnBack))
                        .addGap(53)));

        JLabel lbPropertyID = new JLabel("Property ID");
        lbPropertyID.setHorizontalAlignment(SwingConstants.RIGHT);
        lbPropertyID.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lbPassword = new JLabel("Password");
        lbPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        lbPassword.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lbID = new JLabel("Agent ID");
        lbID.setHorizontalAlignment(SwingConstants.RIGHT);
        lbID.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lblSellingDate = new JLabel("Selling Date");
        lblSellingDate.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSellingDate.setFont(new Font("Tahoma", Font.BOLD, 14));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
                .createSequentialGroup().addContainerGap(88, Short.MAX_VALUE)
                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblSellingDate, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
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
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(lblSellingDate, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(156, Short.MAX_VALUE)));
        panel.setLayout(gl_panel);
        contentPane.setLayout(gl_contentPane);
    }
}
