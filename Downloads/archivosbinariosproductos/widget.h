#ifndef WIDGET_H
#define WIDGET_H

#include <QWidget>
#include "headers/logic_producto.h"
#include <QWidget>
#include <vector>
#include <string>
#include "vista/buscar.h"
#include <Qlabel>
#include <QLineEdit>
#include <QPushButton>


QT_BEGIN_NAMESPACE
namespace Ui {
class Widget;
}
QT_END_NAMESPACE

class Widget : public QWidget
{
    Q_OBJECT

public:
    Widget(QWidget *parent = nullptr);
    ~Widget();

private:
    Ui::Widget *ui;
    buscar *uiBuscar;
    logic_product lp;
    logic_product *ptrLp;
    void clearFields();
    void loadFields(int index); // cargar los campos del producto
    int index;
    int totalProducts;
    void productosbuscados();

private slots:
    void saveProduct();
    void prev();
    void next();
    void newProduct();
    void search();


};
#endif // WIDGET_H
