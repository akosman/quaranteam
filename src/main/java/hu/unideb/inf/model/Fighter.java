//Proba komment GM
//Proba komment Dani

package hu.unideb.inf.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
    private int level;
    private IntegerProperty level2 = new SimpleIntegerProperty();
    

    public Fighter(String name,int attack,int defend, int level) {
        this.name.setValue(name);
        this.attack=attack;
        this.defend=defend;
        this.level=level;
        this.level2.setValue(level);
    }

    public int getAttack() {
        return attack;
    }

    public int getDefend() {
        return defend;
    }
    
    public int getLevel() {
        return level;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefend(int defend) {
        this.defend = defend;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
       public IntegerProperty levelProperty() {
        return level2;
    }

        public Integer getLevel2() {
        return level2.getValue();
    }

    public void setLevel2(Integer level) {
        this.level2.setValue(level);
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
        s.writeInt(level);
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        this.name = new SimpleStringProperty(s.readUTF());
        this.attack = s.readInt();
        this.defend = s.readInt();
        this.level = s.readInt();
    }
}