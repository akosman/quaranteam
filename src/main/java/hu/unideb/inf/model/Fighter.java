//Proba komment GM
//Proba komment Dani

package hu.unideb.inf.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Dani
 */
public class Fighter implements Serializable {

    private StringProperty name = new SimpleStringProperty();
    private int attack;
    private int defend;
    

    public Fighter(String name,int attack,int defend) {
        this.name.setValue(name);
        this.attack=attack;
        this.defend=defend;
    
    }

    public int getAttack() {
        return attack;
    }

    public int getDefend() {
        return defend;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefend(int defend) {
        this.defend = defend;
    }
    



    public StringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }




    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeUTF(name.getValue());
        s.writeInt(attack);
        s.writeInt(defend);
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        this.name = new SimpleStringProperty(s.readUTF());
        this.attack = s.readInt();
        this.defend = s.readInt();
    }
}