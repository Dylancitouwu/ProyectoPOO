#include "../headers/Sala.h"
#include <iostream>

Sala::Sala() {
    asientos = vector<vector<char>>(5, vector<char>(5, 'O'));
}

void Sala::mostrarAsientos() const {
    cout << "-=-=- ASIENTOS -=-=-\n";
    cout << "    1   2   3   4   5\n";
    for (int i = 0; i < 5; ++i) {
        cout << filas[i].toLatin1() << "   ";
        for (char asiento : asientos[i]) {
            cout << asiento << "   ";
        }
        cout << "\n";
    }
}

bool Sala::reservarAsiento(QString fila, int columna) {
    int filaIndice = filas.indexOf(fila);
    int columnaIndice = columna - 1;
    if (filaIndice >= 0 && filaIndice < 5 && columnaIndice >= 0 && columnaIndice < 5) {
        if (asientos[filaIndice][columnaIndice] == 'O') {
            asientos[filaIndice][columnaIndice] = 'X';
            return true;
        }
    }
    return false;
}

QString Sala::getAsientos() const {
    QString resultado;
    resultado += "-=-=- ASIENTOS -=-=-\n";
    resultado += "    1   2   3   4   5\n";
    for (int i = 0; i < 5; ++i) {
        resultado += filas[i];
        resultado += "   ";
        for (char asiento : asientos[i]) {
            resultado += asiento;
            resultado += "   ";
        }
        resultado += "\n";
    }
    cout << "\n";
    return resultado;
}
