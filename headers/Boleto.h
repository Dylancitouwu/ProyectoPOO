#ifndef BOLETO_H
#define BOLETO_H

#include "Pelicula.h"
#include <QString>

class Boleto {
private:
    int sala;
    Pelicula pelicula;
    QString fila;
    int columna;

public:
    Boleto(int sala, Pelicula pelicula, QString fila, int columna);
    QString getAsiento() const;
};

#endif // BOLETO_H
