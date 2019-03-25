package entities;

import entities.Car;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-11T16:31:27")
@StaticMetamodel(CarDetails.class)
public class CarDetails_ { 

    public static volatile SingularAttribute<CarDetails, Integer> doorsCar;
    public static volatile SingularAttribute<CarDetails, BigDecimal> priceCar;
    public static volatile SingularAttribute<CarDetails, String> licenseCar;
    public static volatile SingularAttribute<CarDetails, Integer> idCar;
    public static volatile SingularAttribute<CarDetails, Car> idCarModel;

}