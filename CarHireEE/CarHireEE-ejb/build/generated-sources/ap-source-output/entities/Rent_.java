package entities;

import entities.CashPayment;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-11T16:31:27")
@StaticMetamodel(Rent.class)
public class Rent_ { 

    public static volatile SingularAttribute<Rent, Integer> idRent;
    public static volatile SingularAttribute<Rent, String> comercial;
    public static volatile SingularAttribute<Rent, String> addressClient;
    public static volatile SingularAttribute<Rent, String> bornClient;
    public static volatile CollectionAttribute<Rent, CashPayment> cashPaymentCollection;
    public static volatile SingularAttribute<Rent, String> licenseClient;
    public static volatile SingularAttribute<Rent, String> dniClient;
    public static volatile SingularAttribute<Rent, String> carClient;
    public static volatile SingularAttribute<Rent, String> wayToPay;
    public static volatile SingularAttribute<Rent, String> days;
    public static volatile SingularAttribute<Rent, String> nameClient;

}