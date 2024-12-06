package Controller;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Model.acount;
import Model.acountDAO;
import view.view_caja;


class OperacionDeposito implements Runnable {
    private view_caja vc;
    private long accountNumber;
    private double depositAmount;
    private acountDAO adao;
    public OperacionDeposito(view_caja vc, long accountNumber, double depositAmount) {
        this.vc = vc;
        this.accountNumber = accountNumber;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        // Realizamos la operación de depósito
        try {
            // Aquí debes implementar la lógica para realizar el depósito en el modelo (acountDAO)
            acount ac = adao.findAcountFile(accountNumber); // Buscar cuenta
            if (ac != null) {
                ac.setMount(ac.getMount() + depositAmount); // Actualizar el saldo
                adao.updateAcount(ac); // Guardar cambios en el archivo
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // Mostrar mensaje de éxito
                        JOptionPane.showMessageDialog(vc, "Depósito realizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        // Actualizamos el saldo en la interfaz
                        vc.txt_mount.setText(String.format("%.2f", ac.getMount()));
                    }
                });
            } else {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // Mostrar mensaje si la cuenta no existe
                        JOptionPane.showMessageDialog(vc, "Cuenta no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
            }
        } catch (IOException ex) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    // Error al leer o escribir en el archivo
                    JOptionPane.showMessageDialog(vc, "Error en la operación, intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }
    }
}
