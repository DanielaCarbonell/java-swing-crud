import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class window extends JFrame {

    private ArrayList<user> usuarios = new ArrayList<>();

    public window() {
        super("Responsive Form");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(5, 5, 5, 5); 
        c.fill = GridBagConstraints.HORIZONTAL; 
        c.weightx = 1.0; 

        // Name
        c.gridx = 0; c.gridy = 0;
        panel.add(new JLabel("Name:"), c);

        c.gridx = 1; c.gridy = 0;
        JTextField nameField = new JTextField();
        panel.add(nameField, c);

        // Last name
        c.gridx = 0; c.gridy = 1;
        panel.add(new JLabel("Last Name:"), c);

        c.gridx = 1; c.gridy = 1;
        JTextField lastNameField = new JTextField();
        panel.add(lastNameField, c);

        // Botones
        c.gridx = 0; c.gridy = 2;
        c.gridwidth = 2;
        JButton addButton = new JButton("Add");
        JButton clearButton = new JButton("Clear");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
        panel.add(buttonPanel, c);

        // Eventos
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String lastName = lastNameField.getText().trim();

            if (!name.isEmpty() && !lastName.isEmpty()) {
                user u = new user (name, lastName);
                usuarios.add(u);
                System.out.println("Usuario agregado: " + u);
                JOptionPane.showMessageDialog(this, "Usuario agregado: " + u);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor llena todos los campos");
            }
        });

        clearButton.addActionListener(e -> {
            nameField.setText("");
            lastNameField.setText("");
        });

        this.add(panel);
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(window::new);
    }
}