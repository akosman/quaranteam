//Proba komment GM
//Proba komment Dani
package hu.unideb.inf.model;

import java.io.Serializable;
import java.util.Objects;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Dani
 */
@Entity
@Table(name = "fighters")
@Access(AccessType.PROPERTY)
public class Fighter implements Serializable {

    private int id; 
    private int attack;
    private int defend;
    private IntegerProperty level = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();

    public Fighter() {

    }

    public Fighter(String name, int attack, int defend, int level) {
        this.name.setValue(name);
        this.attack = attack;
        this.defend = defend;
        this.level.setValue(level);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "attack")
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Column(name = "defend")
    public int getDefend() {
        return defend;
    }
    public void setDefend(int defend) {
        this.defend = defend;
    }

    @Column(name = "level")
    public Integer getLevel() {
        return level.getValue();
    }
    public void setLevel(Integer level) {
        this.level.setValue(level);
    }
    public IntegerProperty levelProperty() {
        return level;
    }

    @Column(name = "name")
    public String getName() {
        return name.getValue();
    }
    public void setName(String name) {
        this.name.setValue(name);
    }
    public StringProperty nameProperty() {
        return name;
    }

    /*@Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }*/

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fighter other = (Fighter) obj;

        if (!Objects.equals(this.name.toString(), other.name.toString())) {
            return false;
        }

        return true;
    }
}
