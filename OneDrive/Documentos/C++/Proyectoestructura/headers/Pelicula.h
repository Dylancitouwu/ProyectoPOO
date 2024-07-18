#ifndef PELICULA_H
#define PELICULA_H

#include <string>
using namespace std;

class Pelicula {
private:
    int id;
    string titulo;
    int duracion;
    bool estreno;
    string hora;

public:
    Pelicula(int id, string titulo, int duracion, bool estreno, string hora);
    string toString() const;
    int getId() const;
    string getHora() const;
    string getTitulo() const;
};

#endif // PELICULA_H
