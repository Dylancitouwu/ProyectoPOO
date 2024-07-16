#include "../headers/logic_producto.h"

logic_product::logic_product() {}

logic_product::~logic_product() {}

bool logic_product::save(std::string nameProduct,std::string code, int stock, double price) {
    Product p(nameProduct,code, stock, price);
    productDAO pdao(p);
    pdao.writeProducts();
    return true;
}

std::vector<std::string> logic_product::loadInfoProduct(int index) {
    std::vector<std::string> infoP;
    std::vector<Product> products = pdao.readProducts();
    int size = products.size();
    if (index >= 0 && index < size) {
        infoP.push_back(products[index].getName());
        infoP.push_back(products[index].getCode());
        infoP.push_back(std::to_string(products[index].getStock()));
        infoP.push_back(std::to_string(products[index].getPrice()));
    }
    return infoP;
}

int logic_product::loadTotalProducts() {
    std::vector<Product> products = pdao.readProducts();
    return products.size();
}
