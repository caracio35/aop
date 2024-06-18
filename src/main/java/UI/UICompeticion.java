package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;

import model.Concursante;
import model.Concurso;
import model.RegistroConcursantes;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UICompeticion {

        private JPanel contentPane;
        private JLabel lblName;
        private JTextField txtName;
        private JLabel lblLastName;
        private JTextField txtLastName;
        private JLabel lblId;
        private JTextField txtId;
        private JLabel lblPhone;
        private JTextField txtPhone;
        private JLabel lblEmail;
        private JTextField txtEmail;
        private JComboBox<Concurso> comboBox;
        private JButton btnOk;
        private JLabel lblCompetition;
        private RegistroConcursantes registroConcursantes;
        private GroupLayout gl_contentPane;

        public UICompeticion(RegistroConcursantes registroConcursantes) throws IOException, SQLException {
                this.registroConcursantes = registroConcursantes;
                var frame = new JFrame("Inscription to Competition");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(100, 100, 451, 229);
                contentPane = new JPanel();
                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                frame.setContentPane(contentPane);
                formElements();
                layout();
                frame.setVisible(true);
        }

        private void formElements() throws IOException, SQLException {
                lblName = new JLabel("Nombre:");
                txtName = new JTextField();
                txtName.setColumns(10);
                lblLastName = new JLabel("Apellido:");
                txtLastName = new JTextField();
                txtLastName.setColumns(10);
                lblId = new JLabel("Dni:");
                txtId = new JTextField();
                txtId.setColumns(10);
                lblPhone = new JLabel("Telefono:");
                txtPhone = new JTextField();
                txtPhone.setColumns(10);
                lblEmail = new JLabel("Email:");
                txtEmail = new JTextField();
                txtEmail.setColumns(10);
                btnOk = new JButton("Ok");
                btnOk.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                btnOk.setEnabled(false);
                                saveInscription();
                                btnOk.setEnabled(true);
                        }
                });
                lblCompetition = new JLabel("Concurso:");
                comboBox = new JComboBox<Concurso>();
                todosLosConcursos(comboBox);
        }

        private void todosLosConcursos(JComboBox<Concurso> comboBox) throws IOException, SQLException {
                var concursos = registroConcursantes.cualesConcursosHay();
                for (Concurso concu : concursos) {
                        comboBox.addItem(concu);
                }
        }

        private void layout() {
                gl_contentPane = new GroupLayout(contentPane);
                gl_contentPane.setHorizontalGroup(gl_contentPane
                                .createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
                                                .addGroup(gl_contentPane
                                                                .createParallelGroup(Alignment.LEADING)
                                                                .addGroup(gl_contentPane
                                                                                .createSequentialGroup()
                                                                                .addGroup(gl_contentPane
                                                                                                .createParallelGroup(
                                                                                                                Alignment.LEADING)
                                                                                                .addComponent(lblLastName)
                                                                                                .addComponent(lblId)
                                                                                                .addComponent(lblPhone)
                                                                                                .addComponent(lblEmail)
                                                                                                .addComponent(lblName)
                                                                                                .addComponent(lblCompetition))
                                                                                .addPreferredGap(
                                                                                                ComponentPlacement.RELATED,
                                                                                                28, Short.MAX_VALUE)
                                                                                .addGroup(
                                                                                                gl_contentPane.createParallelGroup(
                                                                                                                Alignment.LEADING,
                                                                                                                false)
                                                                                                                .addComponent(comboBox,
                                                                                                                                0,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(txtEmail,
                                                                                                                                Alignment.TRAILING)
                                                                                                                .addComponent(txtPhone,
                                                                                                                                Alignment.TRAILING)
                                                                                                                .addComponent(txtId,
                                                                                                                                Alignment.TRAILING)
                                                                                                                .addComponent(txtLastName,
                                                                                                                                Alignment.TRAILING)
                                                                                                                .addComponent(txtName,
                                                                                                                                Alignment.TRAILING,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                298,
                                                                                                                                Short.MAX_VALUE)))
                                                                .addComponent(btnOk, Alignment.TRAILING,
                                                                                GroupLayout.PREFERRED_SIZE, 86,
                                                                                GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap()));
                gl_contentPane
                                .setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGroup(gl_contentPane
                                                                                .createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(txtName,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lblName))
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addGroup(gl_contentPane
                                                                                .createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(lblLastName)
                                                                                .addComponent(txtLastName,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addGroup(gl_contentPane
                                                                                .createParallelGroup(Alignment.TRAILING)
                                                                                .addComponent(lblId).addComponent(
                                                                                                txtId,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addGroup(gl_contentPane
                                                                                .createParallelGroup(Alignment.LEADING)
                                                                                .addGroup(
                                                                                                gl_contentPane.createSequentialGroup()
                                                                                                                .addComponent(lblPhone)
                                                                                                                .addPreferredGap(
                                                                                                                                ComponentPlacement.UNRELATED)
                                                                                                                .addComponent(lblEmail))
                                                                                .addGroup(gl_contentPane
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(txtPhone,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                ComponentPlacement.RELATED)
                                                                                                .addComponent(txtEmail,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                ComponentPlacement.RELATED)
                                                                                                .addGroup(
                                                                                                                gl_contentPane.createParallelGroup(
                                                                                                                                Alignment.BASELINE)
                                                                                                                                .addComponent(comboBox,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(lblCompetition))))
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(btnOk)
                                                                .addContainerGap(67, Short.MAX_VALUE)));
                contentPane.setLayout(gl_contentPane);
        }

        private boolean validation() {
                // if ("".equals(txtName.getText())) {
                // JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio",
                // "Error",
                // JOptionPane.ERROR_MESSAGE);
                // return false;
                // }
                // if ("".equals(txtLastName.getText())) {
                // JOptionPane.showMessageDialog(null, "El apellido no puede estar vacio",
                // "Error",
                // JOptionPane.ERROR_MESSAGE);
                // return false;
                // }
                // if ("".equals(txtId.getText())) {
                // JOptionPane.showMessageDialog(null, "El dni no puede estar vacio", "Error",
                // JOptionPane.ERROR_MESSAGE);
                // return false;
                // }
                // if (!chekEmail(txtEmail.getText())) {
                // JOptionPane.showMessageDialog(null, "El telefono no puede estar vacio",
                // "Error",
                // JOptionPane.ERROR_MESSAGE);
                // return false;
                // }
                // if (chekPhone(txtPhone.getText())) {
                // JOptionPane.showMessageDialog(null, "El telefono no puede estar vacio",
                // "Error",
                // JOptionPane.ERROR_MESSAGE);
                // return false;
                // }
                // if (comboBox.getSelectedIndex() == 0) {
                // JOptionPane.showMessageDialog(null, "El concurso no puede estar vacio",
                // "Error",
                // JOptionPane.ERROR_MESSAGE);
                // return false;
                // }
                return true;

        }

        private boolean chekPhone(String text) {
                String regex = "\\d{4}-\\d{6}";
                return text.matches(regex);
        }

        private boolean chekEmail(String text) {
                String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
                return text.matches(regex);
        }

        protected void saveInscription() {
                if (validation()) {
                        Concurso concu = (Concurso) comboBox.getSelectedItem();
                        var participant = new Concursante(txtName.getText(), txtLastName.getText(), txtId.getText(),
                                        txtPhone.getText(), txtEmail.getText());
                        try {
                                registroConcursantes.registrarConcursante(participant, concu);
                                JOptionPane.showMessageDialog(null, "Registrado con éxito", "Información",
                                                JOptionPane.INFORMATION_MESSAGE);

                        } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, "Error al registrar", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                                throw new RuntimeException(e);
                        }
                }
        }

}
