#ifndef SALA_H
#define SALA_H

#include <vector>
#include <QString>
using namespace std;

class Sala {
private:
    vector<vector<char>> asientos;
    QString filas = "ABCDE";

public:
    Sala();
    void mostrarAsientos() const;
    bool reservarAsiento(QString fila, int columna);
    QString getAsientos() const;
};

#endif // SALA_H
