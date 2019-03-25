package entities;

import entities.Rent;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-11T16:31:27")
@StaticMetamodel(CashPayment.class)
public class CashPayment_ { 

    public static volatile SingularAttribute<CashPayment, Rent> idRentCar;
    public static volatile SingularAttribute<CashPayment, String> paidOut;
    public static volatile SingularAttribute<CashPayment, Integer> idCashPayment;
    public static volatile SingularAttribute<CashPayment, String> returned;
    public static volatile SingularAttribute<CashPayment, String> totalCost;

}