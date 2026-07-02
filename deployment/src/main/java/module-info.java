module ec.edu.uce.mibanco.deployment {
    requires javafx.controls;
    requires javafx.fxml;


    opens ec.edu.uce.mibanco.deployment to javafx.fxml;
    exports ec.edu.uce.mibanco.deployment;
}