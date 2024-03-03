module sn.dev.userpersist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    //requires MaterialFX;

    opens sn.dev.userpersist to javafx.fxml;
    exports sn.dev.userpersist;

    opens sn.dev.userpersist.entities;
    exports sn.dev.userpersist.entities;

    opens sn.dev.userpersist.controller to javafx.fxml;
    exports sn.dev.userpersist.controller;
}