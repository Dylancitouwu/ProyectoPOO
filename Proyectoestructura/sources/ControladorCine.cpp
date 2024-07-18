#include "../headers/ControladorCine.h"
#include <QDebug>

ControladorCine::ControladorCine() {}

void ControladorCine::iniciar() {
    int opcion;
    do {
        qDebug() << "**** MENU PRINCIPAL ****\n";
        qDebug()  << "1. Mostrar Cartelera";
        qDebug()  << "2. Comprar Boletos";
        qDebug()  << "3. Mostrar Sala";
        qDebug()  << "4. Salir";
        qDebug()  << "Ingrese su opcion: ";
        cin >> opcion;
        qDebug()  << "\n";

        switch (opcion) {
        case 1:
            vista.mostrarCartelera(cine);
            break;
        case 2:
            vista.comprarBoletos(cine);
            break;
        case 3:
            int peliculaId;
            qDebug()  << "Ingrese el Id de la pelicula: ";
            cin >> peliculaId;
            vista.mostrarSala(cine, peliculaId);
            qDebug()  << "\n";
            break;
        case 4:
            return;
        default:
            qDebug()  << "Opcion no valida.\n";
        }
    } while (opcion != 4);
}
