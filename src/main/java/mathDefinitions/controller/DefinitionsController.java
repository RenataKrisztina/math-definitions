package mathDefinitions.controller;


import jakarta.xml.bind.JAXBException;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import jaxb.JAXBHelper;
import mathDefinitions.model.Def;
import mathDefinitions.model.Level;
import mathDefinitions.model.Topic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class DefinitionsController {

    @FXML
    public TextField keresesMezo;
    @FXML
    public CheckBox algebra;
    @FXML
    public CheckBox geometria;
    @FXML
    public CheckBox szamelmelet;
    @FXML
    public CheckBox analizis;
    @FXML
    public CheckBox alt_isk;
    @FXML
    public CheckBox egyetem;
    @FXML
    public CheckBox kozepisk;
    @FXML
    public CheckBox algebra1;
    @FXML
    public CheckBox geometria1;
    @FXML
    public CheckBox szamelmelet1;
    @FXML
    public CheckBox analizis1;
    @FXML
    public CheckBox alt_isk1;
    @FXML
    public CheckBox egyetem1;
    @FXML
    public CheckBox kozepisk1;
    @FXML
    public TableView<Def> tabla;
    @FXML
    public Button kereses;
    @FXML
    public Button letrehozas;
    @FXML
    public TextField nevMezo;
    public TextField defMezo;
    public TableColumn<Def, String> name;
    public TableColumn<Def, String> level;
    public TableColumn<Def, String> topic;
    public TableColumn<Def, String> definition;


    @FXML
    public void init(){
        tabla.setItems(Def.definitions);    //feltoltom a tablazatot
        //name.setCellValueFactory(data -> data.getValue().getName());
        name.setCellValueFactory(new PropertyValueFactory<Def, String>("name"));
        name.setCellValueFactory(new PropertyValueFactory<Def, String>("level"));
        name.setCellValueFactory(new PropertyValueFactory<Def, String>("topic"));
        name.setCellValueFactory(new PropertyValueFactory<Def, String>("definition"));
       // tabla.getColumns().addAll(name, level, topic, definition);  //a tabla oszlopaihoz hozzarendeli az ertekeket
    }

    public void hozzaadogomb(ActionEvent actionEvent) throws FileNotFoundException, JAXBException {
        /*
        Level level = null;
        if( alt_isk1.isSelected()){
            level = Level.ALTALANOS_ISKOLA;
        }
        if( kozepisk1.isSelected()){
            level = Level.KOZEP_ISKOLA;
        }
        if( egyetem1.isSelected()){
            level = Level.EGYETEM;
        }

        Topic topic = null;
        if( algebra1.isSelected()){
            topic = Topic.ALGEBRA;
        }
        if( szamelmelet1.isSelected()){
            topic = Topic.SZAMELMELET;
        }
        if( analizis1.isSelected()){
            topic = Topic.ANALIZIS;
        }
        if( geometria1.isSelected()){
            topic = Topic.GEOMETRIA;
        }

        Def definition = new Def(nevMezo.getText(), defMezo.getText(), topic, level);

        JAXBHelper.toXML(definition, new FileOutputStream("definitions.xml"));*/

        String level = null;
        if( alt_isk1.isSelected()){
            level = "ALTALANOS_ISKOLA";
        }
        if( kozepisk1.isSelected()){
            level = "KOZEP_ISKOLA";
        }
        if( egyetem1.isSelected()){
            level = "EGYETEM";
        }

        String topic = null;
        if( algebra1.isSelected()){
            topic = "ALGEBRA";
        }
        if( szamelmelet1.isSelected()){
            topic = "SZAMELMELET";
        }
        if( analizis1.isSelected()){
            topic = "ANALIZIS";
        }
        if( geometria1.isSelected()){
            topic = "GEOMETRIA";
        }

        Def.add(nevMezo.getText(), defMezo.getText(), topic, level);



        JAXBHelper.toXML(definition, new FileOutputStream("definitions.xml"));

        //lenullazom
        alt_isk1.setSelected(false);
        kozepisk1.setSelected(false);
        egyetem1.setSelected(false);
        algebra1.setSelected(false);
        szamelmelet1.setSelected(false);
        analizis1.setSelected(false);
        geometria1.setSelected(false);
        defMezo.clear();
        nevMezo.clear();

    }

    public void keresogomb(ActionEvent actionEvent) {
/*
        FilteredList<Def> filteredDefinitions = new FilteredList<>(
                Def.definitions, def -> (def.getName().contains(keresesMezo.getText()) &&
        if (algebra.isSelected()) { def.})
        );


*/

        ObservableList<Def> filteredDef = FXCollections.observableArrayList(new ArrayList<>());

        String level = null;
        if( alt_isk.isSelected()){
            level = "ALTALANOS_ISKOLA";
        }
        if( kozepisk.isSelected()){
            level = "KOZEP_ISKOLA";
        }
        if( egyetem.isSelected()){
            level = "EGYETEM";
        }

        String topic = null;
        if( algebra.isSelected()){
            topic = "ALGEBRA";
        }
        if( szamelmelet.isSelected()){
            topic = "SZAMELMELET";
        }
        if( analizis.isSelected()){
            topic = "ANALIZIS";
        }
        if( geometria.isSelected()){
            topic = "GEOMETRIA";
        }

        String nev = keresesMezo.getText();

        for( Def d: Def.definitions){
            if( d.getName().equals(nev) && d.getLevel().equals(level) && d.getTopic().equals(topic)){
                filteredDef.add(d);
            }
        }

        tabla.setItems(filteredDef);

    }
}
