QT       += core gui

greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

CONFIG += c++17

# You can make your code fail to compile if it uses deprecated APIs.
# In order to do so, uncomment the following line.
#DEFINES += QT_DISABLE_DEPRECATED_BEFORE=0x060000    # disables all the APIs deprecated before Qt 6.0.0

SOURCES += \
    Sources/logic_user.cpp \
    Sources/user.cpp \
    Sources/userDAO.cpp \
    Vista/home.cpp \
    main.cpp \
    widget.cpp

HEADERS += \
    Headers/logic_user.h \
    Headers/user.h \
    Headers/userDAO.h \
    Vista/home.h \
    widget.h

FORMS += \
    Vista/home.ui \
    widget.ui

# Default rules for deployment.
qnx: target.path = /tmp/$${TARGET}/bin
else: unix:!android: target.path = /opt/$${TARGET}/bin
!isEmpty(target.path): INSTALLS += target
