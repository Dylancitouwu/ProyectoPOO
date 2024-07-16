#include "../headers/producto.h"
Product::Product(){
    this->name="";
    this->price=0;
    this->stock=0;
}
Product::~Product(){

}
Product::Product(string n,string c,int s,double p){
    this->name=n;
    this->code=c;
    this->price=p;
    this->stock=s;
}
string Product::getName()const{
    return name;
}
string Product::getCode()const{
    return code;
}
int Product::getStock()const{
    return stock;
}
double Product::getPrice()const{
    return price;
}
void Product::setName(string n){
    this->name=n;
}
void Product::setStock(int s){
    this->stock=s;
}
void Product::setPrice(double p){
    this->price=p;
}
string Product::information()const{
    return name+";"+code+";"+to_string(stock)+";"+to_string(price)+"\n";
}
