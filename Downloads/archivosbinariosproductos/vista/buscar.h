#ifndef BUSCAR_H
#define BUSCAR_H
#include <QWidget>
#include "headers/logic_producto.h"
#include <QWidget>
#include <vector>
#include <string>

namespace Ui {
class buscar;
}

class buscar : public QWidget
{
    Q_OBJECT

public:
    explicit buscar(QWidget *parent = nullptr);
    ~buscar();

private:
    Ui::buscar *ui;
    logic_product lp;
    logic_product *ptrLp;

public slots:
    bool buscarcode();
};

#endif // BUSCAR_H
