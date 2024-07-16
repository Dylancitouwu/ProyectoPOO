#include "../headers/productDAO.h"
#include <QDebug>
#include <string>
#include <sstream>
#include <fstream>
using namespace std;
vector<string> split(string str, char delimitador) {
    vector<string> tokens;
    stringstream ss(str);
    string item;
    while (getline(ss, item, delimitador)) {
        tokens.push_back(item);
    }
    return tokens;
}

productDAO::productDAO() {}

productDAO::~productDAO() {}

productDAO::productDAO(const Product& p_) : p(p_) {}

void productDAO::writeProducts() {
    archivo.open(path,std::ios::binary|std::ios::app);

    if (archivo.is_open()) {
        archivo << p.information() << endl;
        archivo.close();
    }
}

vector<Product> productDAO::readProducts() {
    vector<Product> products;
    vector<string> datafile; // recupera el contenido del archivo
    archivo.open(path, ios::in);
    if (archivo.is_open()) {
        string linea;
        while (getline(archivo, linea)) {
            datafile.push_back(linea);
        }
        archivo.close();
    }
    for (const auto &str : datafile) {
        vector<string> tokens = split(str, ';'); // separa por ;
        if (tokens.size() == 3) {
            Product p;
            p.setName(tokens[0]);
            p.setStock(stoi(tokens[1]));
            p.setPrice(stod(tokens[2]));
            products.push_back(p);
        }
    }
    return products;
}
