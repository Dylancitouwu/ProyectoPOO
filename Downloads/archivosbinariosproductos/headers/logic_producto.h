#ifndef LOGIC_PRODUCTO_H
#define LOGIC_PRODUCTO_H
#include "../headers/productDAO.h"
#include <vector>
#include <string>

class logic_product {
public:
    productDAO pdao;
    logic_product();
    ~logic_product();
    bool save(std::string,std::string, int, double);
    std::vector<std::string> loadInfoProduct(int); // Permite recorrer cada producto almacenado
    int loadTotalProducts(); // Nuevo método para obtener el total de productos
};
#endif // LOGIC_PRODUCTO_H
