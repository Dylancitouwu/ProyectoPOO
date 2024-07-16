#include "widget.h"
#include "ui_widget.h"
#include <QMessageBox>
#include <QString>
#include <fstream>>

Widget::Widget(QWidget *parent)
    : QWidget(parent)
    , ui(new Ui::Widget)
    , uiBuscar(new buscar)
    , index(0)
{
    ui->setupUi(this);

    ui->btn_agregar->setEnabled(false);
    ptrLp = &lp;

    connect(ui->btn_agregar, SIGNAL(clicked()), this, SLOT(saveProduct()));
    connect(ui->btn_next, SIGNAL(clicked()), this, SLOT(next()));
    connect(ui->btn_previous, SIGNAL(clicked()), this, SLOT(prev()));
    connect(ui->btn_new, SIGNAL(clicked()), this, SLOT(newProduct()));
    connect(ui->btn_search, SIGNAL(clicked()), this, SLOT(search()));


}

Widget::~Widget()
{
    delete ui;
}

void Widget::saveProduct() {
    std::string nameProduct = ui->txt_producto->text().toStdString();
    std::string code = ui->txt_code->text().toStdString();
    int stock = ui->txt_unidades->text().toInt();
    double price = ui->txt_precio->text().toDouble();
    if (ptrLp->save(nameProduct,code, stock, price)) {
        QMessageBox::information(this, "Registro de productos", "Registro exitoso");
        clearFields();
        totalProducts++;
        index = totalProducts - 1;
    }
}

void Widget::clearFields() {
    ui->txt_producto->clear();
    ui->txt_precio->clear();
    ui->txt_unidades->clear();
}

void Widget::loadFields(int index) {
    ui->btn_agregar->setEnabled(false);
    std::vector<std::string> p = ptrLp->loadInfoProduct(index);
    if (p.size() > 0) {
        ui->txt_producto->setText(QString::fromStdString(p[0]));
        ui->txt_unidades->setText(QString::fromStdString(p[1]));
        ui->txt_precio->setText(QString::fromStdString(p[2]));
    } else {
        QMessageBox::information(this, "Registro de Productos", "No existen más productos.");
    }
}

void Widget::prev() {
    if (index > 0) {
        index--;
        loadFields(index);
    } else {
        QMessageBox::information(this, "Registro de Productos", "Este es el primer producto.");
    }
}

void Widget::next() {
    if (index < totalProducts - 1) {
        index++;
        loadFields(index);
    } else {
        QMessageBox::information(this, "Registro de Productos", "Este es el último producto.");
    }
}

void Widget::newProduct() {
    clearFields();
    ui->btn_agregar->setEnabled(true);
}
void Widget::search(){
    uiBuscar->show();
}
void Widget::productosbuscados(){
    buscar bus;
    std::vector<Product> products = ptrLp->pdao.readProducts();
    bool existe=false;
    for(auto b:products){
        if(bus.buscarcode()){
            ui->txt_producto->setText(QString::fromStdString(b.getName()));
            ui->txt_code->setText(QString::fromStdString(b.getCode()));
            ui->txt_unidades->setText(QString::number(b.getStock()));
            ui->txt_precio->setText(QString::number(b.getPrice()));
        }else{
            QMessageBox::information(this, "Busqueda de Productos", "No existe el producto");
        }
    }
}


