package id.ac.uniska.pbo2.p05;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Form Anggota Perpustakaan (lanjutan Pertemuan 4) yang sudah memiliki event.
 */
public class FormAnggotaPerpustakaan extends javax.swing.JFrame {

    private static final int PANJANG_NPM = 10;

    /** Membuat form baru. */
    public FormAnggotaPerpustakaan() {
        initComponents();
        npmField.putClientProperty("JTextField.placeholderText", "10 digit NPM");
        perbaruiJumlahDigit();
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        isiPanel = new javax.swing.JPanel();
        npmLabel = new javax.swing.JLabel();
        npmField = new javax.swing.JTextField();
        jumlahDigitLabel = new javax.swing.JLabel();
        namaLabel = new javax.swing.JLabel();
        namaField = new javax.swing.JTextField();
        prodiLabel = new javax.swing.JLabel();
        prodiCombo = new javax.swing.JComboBox<>();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        setujuCheck = new javax.swing.JCheckBox();
        tombolPanel = new javax.swing.JPanel();
        batalButton = new javax.swing.JButton();
        daftarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Form Anggota Perpustakaan");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        isiPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 8, 16));
        isiPanel.setLayout(new java.awt.GridLayout(0, 1, 0, 6));

        npmLabel.setText("NPM");
        npmLabel.setLabelFor(npmField);
        isiPanel.add(npmLabel);

        npmField.setColumns(20);
        npmField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                npmFieldKeyReleased(evt);
            }
        });
        isiPanel.add(npmField);

        jumlahDigitLabel.setText("0 dari 10 digit");
        isiPanel.add(jumlahDigitLabel);

        namaLabel.setText("Nama lengkap");
        namaLabel.setLabelFor(namaField);
        isiPanel.add(namaLabel);
        isiPanel.add(namaField);

        prodiLabel.setText("Program studi");
        prodiLabel.setLabelFor(prodiCombo);
        isiPanel.add(prodiLabel);

        prodiCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teknik Informatika", "Sistem Informasi", "Teknik Elektro", "Teknik Sipil" }));
        isiPanel.add(prodiCombo);

        emailLabel.setText("Email");
        emailLabel.setLabelFor(emailField);
        isiPanel.add(emailLabel);
        isiPanel.add(emailField);

        setujuCheck.setText("Saya setuju dengan tata tertib perpustakaan");
        setujuCheck.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                setujuCheckItemStateChanged(evt);
            }
        });
        isiPanel.add(setujuCheck);

        getContentPane().add(isiPanel, java.awt.BorderLayout.CENTER);

        tombolPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 8, 8));

        batalButton.setText("Batal");
        batalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalButtonActionPerformed(evt);
            }
        });
        tombolPanel.add(batalButton);

        daftarButton.setText("Daftar");
        daftarButton.setEnabled(false);
        daftarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftarButtonActionPerformed(evt);
            }
        });
        tombolPanel.add(daftarButton);

        getContentPane().add(tombolPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setujuCheckItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_setujuCheckItemStateChanged
        daftarButton.setEnabled(setujuCheck.isSelected());
    }//GEN-LAST:event_setujuCheckItemStateChanged

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        kosongkan();
    }//GEN-LAST:event_batalButtonActionPerformed

    private void daftarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftarButtonActionPerformed
        String npm = npmField.getText().trim();
        String nama = namaField.getText().trim();
        if (npm.length() != PANJANG_NPM || !npm.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "NPM harus terdiri dari " + PANJANG_NPM + " digit angka.",
                    "Data belum benar", JOptionPane.WARNING_MESSAGE);
            npmField.requestFocusInWindow();
            return;
        }
        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama lengkap wajib diisi.",
                    "Data belum benar", JOptionPane.WARNING_MESSAGE);
            namaField.requestFocusInWindow();
            return;
        }
        String ringkasan = "NPM            : " + npm + "\n"
                + "Nama           : " + nama + "\n"
                + "Program studi  : " + prodiCombo.getSelectedItem() + "\n"
                + "Email          : " + emailField.getText().trim();
        JOptionPane.showMessageDialog(this, ringkasan, "Ringkasan Pendaftaran",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_daftarButtonActionPerformed

    private void npmFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_npmFieldKeyReleased
        perbaruiJumlahDigit();
    }//GEN-LAST:event_npmFieldKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int jawab = JOptionPane.showConfirmDialog(this,
                "Keluar dari aplikasi?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (jawab == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    /** Mengosongkan semua isian dan mengembalikan fokus ke NPM. */
    private void kosongkan() {
        npmField.setText("");
        namaField.setText("");
        emailField.setText("");
        prodiCombo.setSelectedIndex(0);
        perbaruiJumlahDigit();
        npmField.requestFocusInWindow();
    }

    /** Memperbarui label jumlah digit, merah jika melebihi panjang NPM. */
    private void perbaruiJumlahDigit() {
        int jumlah = npmField.getText().trim().length();
        jumlahDigitLabel.setText(jumlah + " dari " + PANJANG_NPM + " digit");
        jumlahDigitLabel.setForeground(jumlah > PANJANG_NPM
                ? Color.RED : UIManager.getColor("Label.foreground"));
    }

    public static void main(String args[]) {
        com.formdev.flatlaf.FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> new FormAnggotaPerpustakaan().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalButton;
    private javax.swing.JButton daftarButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel isiPanel;
    private javax.swing.JLabel jumlahDigitLabel;
    private javax.swing.JTextField namaField;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JTextField npmField;
    private javax.swing.JLabel npmLabel;
    private javax.swing.JComboBox<String> prodiCombo;
    private javax.swing.JLabel prodiLabel;
    private javax.swing.JCheckBox setujuCheck;
    private javax.swing.JPanel tombolPanel;
    // End of variables declaration//GEN-END:variables
}
