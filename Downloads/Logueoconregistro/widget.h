#ifndef WIDGET_H
#define WIDGET_H

#include "Headers/logic_user.h"
#include "Vista/home.h"
#include <QWidget>

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
    Home *uiHome;
    Logic_user lu,
        *ptrLU=nullptr;
private slots:
    void registro();
    void validar();
    void radioRegistro(bool);
};
#endif // WIDGET_H
