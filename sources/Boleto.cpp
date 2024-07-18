#include "../headers/Boleto.h"

Boleto::Boleto(int sala, Pelicula pelicula, QString fila, int columna)
    : sala(sala), pelicula(pelicula), fila(fila), columna(columna) {}

QString Boleto::getAsiento() const {
    return fila + QString::number(columna);
}
