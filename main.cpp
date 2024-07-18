#include <QCoreApplication>
#include "headers/ControladorCine.h"

int main(int argc, char *argv[]) {
    QCoreApplication a(argc, argv);
    ControladorCine controlador;
    controlador.iniciar();

    return a.exec();
}
