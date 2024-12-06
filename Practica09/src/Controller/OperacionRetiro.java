package Controller;

import java.io.IOException;

import Model.acount;
import Model.acountDAO;

public class OperacionRetiro implements Runnable {
    private long numeroCuenta;
    private double monto;
    private acountDAO adao;

    public OperacionRetiro(long numeroCuenta, double monto, acountDAO adao) {
        this.numeroCuenta = numeroCuenta;
        this.monto = monto;
        this.adao = adao;
    }

    @Override
    public void run() {
        try {
            // Verificar si hay suficiente saldo antes de realizar el retiro
            acount cuenta = adao.findAcountFile(numeroCuenta);
            if (cuenta != null && cuenta.getMount() >= monto) {
                boolean exito = adao.depositToAcount(numeroCuenta, -monto); // Realizamos un depósito negativo para el retiro
                if (exito) {
                    System.out.println("Retiro exitoso: " + monto);
                } else {
                    System.out.println("Error al realizar el retiro.");
                }
            } else {
                System.out.println("Saldo insuficiente para el retiro.");
            }
        } catch (IOException e) {
            System.err.println("Error al realizar el retiro: " + e.getMessage());
        }
    }
}
