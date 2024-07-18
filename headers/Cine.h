#ifndef CINE_H
#define CINE_H

#include "headers/Pelicula.h"
#include "headers/Sala.h"
#include "headers/Boleto.h"
#include <vector>
#include <iostream>
using namespace std;

class Cine {
private:
    vector<Pelicula> peliculas;
    vector<Sala> salas;
    const float precio_boleto;
    int boletos;
    Pelicula obtenerPorId(int peliculaId)const;
    float calcularTotalCompra(int cantidadBoletos, float precioIndividual) const;


public:
    Cine(); // Constructor por defecto
    ~Cine(); // Destructor
    Cine(float boleto); // Constructor con parámetro
    void mostrarCartelera()const;
    void mostrarSala(int peliculaId)const;
    void comprarBoletos(); // Método para comprar boletos con parámetro
};

#endif // CINE_H
