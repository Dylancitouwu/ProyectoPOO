/********************************************************************************
** Form generated from reading UI file 'widget.ui'
**
** Created by: Qt User Interface Compiler version 6.7.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_WIDGET_H
#define UI_WIDGET_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_Widget
{
public:
    QWidget *gridLayoutWidget;
    QGridLayout *gridLayout;
    QLabel *label_3;
    QLabel *label_2;
    QLabel *label;
    QPushButton *btn_search;
    QPushButton *btn_agregar;
    QLineEdit *txt_precio;
    QHBoxLayout *horizontalLayout;
    QPushButton *btn_previous;
    QPushButton *btn_next;
    QLineEdit *txt_unidades;
    QPushButton *btn_new;
    QLineEdit *txt_producto;
    QLabel *label_4;
    QLineEdit *txt_code;

    void setupUi(QWidget *Widget)
    {
        if (Widget->objectName().isEmpty())
            Widget->setObjectName("Widget");
        Widget->resize(352, 316);
        gridLayoutWidget = new QWidget(Widget);
        gridLayoutWidget->setObjectName("gridLayoutWidget");
        gridLayoutWidget->setGeometry(QRect(30, 20, 311, 285));
        gridLayout = new QGridLayout(gridLayoutWidget);
        gridLayout->setObjectName("gridLayout");
        gridLayout->setContentsMargins(0, 0, 0, 0);
        label_3 = new QLabel(gridLayoutWidget);
        label_3->setObjectName("label_3");
        QFont font;
        font.setFamilies({QString::fromUtf8("Segoe UI Variable Display Semib")});
        font.setPointSize(12);
        font.setBold(true);
        label_3->setFont(font);

        gridLayout->addWidget(label_3, 4, 0, 1, 1);

        label_2 = new QLabel(gridLayoutWidget);
        label_2->setObjectName("label_2");
        label_2->setFont(font);

        gridLayout->addWidget(label_2, 3, 0, 1, 1);

        label = new QLabel(gridLayoutWidget);
        label->setObjectName("label");
        label->setFont(font);

        gridLayout->addWidget(label, 1, 0, 1, 1);

        btn_search = new QPushButton(gridLayoutWidget);
        btn_search->setObjectName("btn_search");
        btn_search->setFont(font);
        btn_search->setCursor(QCursor(Qt::PointingHandCursor));

        gridLayout->addWidget(btn_search, 7, 0, 1, 1);

        btn_agregar = new QPushButton(gridLayoutWidget);
        btn_agregar->setObjectName("btn_agregar");
        btn_agregar->setFont(font);
        btn_agregar->setCursor(QCursor(Qt::PointingHandCursor));

        gridLayout->addWidget(btn_agregar, 6, 1, 1, 1);

        txt_precio = new QLineEdit(gridLayoutWidget);
        txt_precio->setObjectName("txt_precio");
        QFont font1;
        font1.setPointSize(12);
        txt_precio->setFont(font1);

        gridLayout->addWidget(txt_precio, 4, 1, 1, 1);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setObjectName("horizontalLayout");
        btn_previous = new QPushButton(gridLayoutWidget);
        btn_previous->setObjectName("btn_previous");
        btn_previous->setFont(font);
        btn_previous->setCursor(QCursor(Qt::PointingHandCursor));

        horizontalLayout->addWidget(btn_previous);

        btn_next = new QPushButton(gridLayoutWidget);
        btn_next->setObjectName("btn_next");
        btn_next->setFont(font);
        btn_next->setCursor(QCursor(Qt::PointingHandCursor));

        horizontalLayout->addWidget(btn_next);


        gridLayout->addLayout(horizontalLayout, 5, 1, 1, 1);

        txt_unidades = new QLineEdit(gridLayoutWidget);
        txt_unidades->setObjectName("txt_unidades");
        txt_unidades->setFont(font1);

        gridLayout->addWidget(txt_unidades, 3, 1, 1, 1);

        btn_new = new QPushButton(gridLayoutWidget);
        btn_new->setObjectName("btn_new");
        btn_new->setFont(font);
        btn_new->setCursor(QCursor(Qt::PointingHandCursor));

        gridLayout->addWidget(btn_new, 7, 1, 1, 1);

        txt_producto = new QLineEdit(gridLayoutWidget);
        txt_producto->setObjectName("txt_producto");
        txt_producto->setFont(font1);

        gridLayout->addWidget(txt_producto, 1, 1, 1, 1);

        label_4 = new QLabel(gridLayoutWidget);
        label_4->setObjectName("label_4");
        label_4->setFont(font);

        gridLayout->addWidget(label_4, 2, 0, 1, 1);

        txt_code = new QLineEdit(gridLayoutWidget);
        txt_code->setObjectName("txt_code");
        txt_code->setFont(font1);

        gridLayout->addWidget(txt_code, 2, 1, 1, 1);


        retranslateUi(Widget);

        QMetaObject::connectSlotsByName(Widget);
    } // setupUi

    void retranslateUi(QWidget *Widget)
    {
        Widget->setWindowTitle(QCoreApplication::translate("Widget", "Widget", nullptr));
        label_3->setText(QCoreApplication::translate("Widget", "Precio:", nullptr));
        label_2->setText(QCoreApplication::translate("Widget", "Unidades:", nullptr));
        label->setText(QCoreApplication::translate("Widget", "Producto:", nullptr));
        btn_search->setText(QCoreApplication::translate("Widget", "BUSCAR", nullptr));
        btn_agregar->setText(QCoreApplication::translate("Widget", "AGREGAR", nullptr));
        btn_previous->setText(QCoreApplication::translate("Widget", "<<", nullptr));
        btn_next->setText(QCoreApplication::translate("Widget", ">>", nullptr));
        btn_new->setText(QCoreApplication::translate("Widget", "NUEVO", nullptr));
        label_4->setText(QCoreApplication::translate("Widget", "C\303\263digo:", nullptr));
    } // retranslateUi

};

namespace Ui {
    class Widget: public Ui_Widget {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_WIDGET_H
