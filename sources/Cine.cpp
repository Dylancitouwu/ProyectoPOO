#include "../headers/Cine.h"
#include <QDebug>
#include <iostream>
#include <stdexcept>

Cine::Cine() : precio_boleto(3.15), boletos(0) {
    // Constructor por defecto con inicialización
    peliculas.push_back(Pelicula(1, "Poor Things", 141, true, "16:00"));
    peliculas.push_back(Pelicula(2, "Mision Imposible:  Repercusion", 148, false, "12:20"));
    peliculas.push_back(Pelicula(3, "Dune: Parte dos", 166, true, "10:40"));
    peliculas.push_back(Pelicula(4, "Todo en todas partes al mismo tiempo", 139, false, "10:00"));
    peliculas.push_back(Pelicula(5, "Anatomia de una caida", 151, true, "17:15"));

    // Inicialización de las salas para cada película
    for (size_t i = 0; i < peliculas.size(); ++i) {
        salas.push_back(Sala()); // Cada película tiene su propia sala con asientos
    }
}

Cine::~Cine() {
    // Destructor
}

Cine::Cine(float boleto) : precio_boleto(boleto), boletos(0) {
    // Constructor con parámetro
}

void Cine::mostrarCartelera() const {
    qDebug() << "- - C A R T E L E R A - -";
    for (const Pelicula &pelicula : peliculas) {
        qDebug() << pelicula.toString();
    }
    qDebug() << "\n";
}

Pelicula Cine::obtenerPorId(int peliculaId) const {
    for (const Pelicula &pelicula : peliculas) {
        if (pelicula.getId() == peliculaId) {
            return pelicula;
        }
    }
    throw invalid_argument("Pelicula no encontrada");
}

void Cine::mostrarSala(int peliculaId) const {
    Pelicula pelicula = obtenerPorId(peliculaId);
    cout << pelicula.toString() << "\n";
    salas[peliculaId - 1].mostrarAsientos(); // Mostrar los asientos de la sala correspondiente
}

void Cine::comprarBoletos() {
    int peliculaId;
    cout << "Ingrese el ID de la pelicula: ";
    cin >> peliculaId;
    Pelicula pelicula = obtenerPorId(peliculaId);

    int numBoletos;
    cout << "Ingrese el numero de boletos: ";
    cin >> numBoletos;
    if (numBoletos <= 0 || numBoletos > 25) {
        cout << "Numero de boletos invalido.\n";
        return;
    }

    vector<Boleto> boletosComprados;
    Sala& sala = salas[peliculaId - 1]; // Obtener la sala correspondiente a la película seleccionada
    char opt;
    cout << "Desea ver la pelicula en 3D? (S/N): ";
    cin >> opt;
    bool es3D = (opt == 'S' || opt == 's');

    // Calcular el precio individual del boleto
    float precio3D = precio_boleto;
    if (es3D) {
        precio3D *= 1.4; // Aumentar el precio en un 50% para 3D
    }
    for (int i = 0; i < numBoletos; ++i) {
        while (true) {
            cout << sala.getAsientos().toStdString();
            string asiento;
            cout << "Boleto #" << i + 1 << " - Ingrese el asiento (Ej. A1): ";
            cin >> asiento;
            QString qasiento = QString::fromStdString(asiento);
            QString fila = qasiento[0];
            int columna = qasiento.mid(1).toInt();
            if (sala.reservarAsiento(fila, columna)) {
                boletosComprados.push_back(Boleto(1, pelicula, fila, columna));
                break;
            } else {
                cout << "Asiento no disponible.\n";
            }
        }
    }

    // Calcular el total de la compra
    float precioIndividual = precio3D;
    float totalCompra = numBoletos * precioIndividual;

    // Mostrar los boletos comprados
    cout << "\nResumen de la Compra:\n";
    cout << "====================\n";
    for (size_t i = 0; i < boletosComprados.size(); ++i) {
        qDebug() << " Boleto #" << i + 1;
        qDebug() << "==========================================";
        qDebug() << "= Sala:" << peliculaId;
        qDebug() << "= Hora:" << pelicula.getHora();
        qDebug() << "= Asiento:"<<boletosComprados[i].getAsiento();
        qDebug() << "= Pelicula:" << pelicula.getTitulo();
        qDebug() << "==========================================\n";
    }

    // Mostrar el resumen de la compra
    cout << "Cantidad de boletos: " << numBoletos << endl;
    cout << "Precio individual por boleto: $" << precioIndividual << endl;
    cout << "Total: $" << totalCompra << endl;
    cout<<"\n";
}
void Cine::reservarBoletos(string titulo, Boleto boleto) {
    colasReservas[titulo].push(boleto);
}

void Cine::venderBoletos(string titulo, Venta venta) {
    pilasVentas[titulo].push(venta);
}

void Cine::agregarUsuario(Usuario usuario) {
    usuarios.push_back(usuario);
}
