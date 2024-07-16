#ifndef PRODUCTO_H
#define PRODUCTO_H
#include <iostream>
#include <string>
using namespace std;
class Product{
private:
    string name;
    string code;
    int stock;
    double price;
public:
    Product();
    ~Product();
    Product(string,string,int,double);
    string getName()const;
    string getCode()const;
    int getStock()const;
    double getPrice()const;
    void setName(string);
    void setCode(string);
    void setStock(int);
    void setPrice(double);
    string information()const;
};

#endif // PRODUCTO_H
