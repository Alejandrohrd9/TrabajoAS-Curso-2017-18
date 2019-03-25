package entities;

import entities.CarDetails;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-11T16:31:27")
@StaticMetamodel(Car.class)
public class Car_ { 

    public static volatile SingularAttribute<Car, String> modelC;
    public static volatile SingularAttribute<Car, String> typeC;
    public static volatile CollectionAttribute<Car, CarDetails> carDetailsCollection;
    public static volatile SingularAttribute<Car, Integer> idC;
    public static volatile SingularAttribute<Car, String> marcaC;

}