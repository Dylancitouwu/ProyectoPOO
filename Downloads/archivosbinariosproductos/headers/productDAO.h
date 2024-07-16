#ifndef PRODUCTDAO_H
#define PRODUCTDAO_H
#include "../headers/producto.h"
#include<fstream>
#include <vector>
class productDAO{
private:
    Product p;
    fstream archivo;
    string path="C://ejerciciosFS//ejercicio02//producto.bin";
public:
    productDAO();
    ~productDAO();
    productDAO(const Product&);
    void writeProducts();
    vector<Product> readProducts();
};
#endif // PRODUCTDAO_H
