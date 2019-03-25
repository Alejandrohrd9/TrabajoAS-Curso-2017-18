package entities;

import entities.Rent;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-11T16:31:27")
@StaticMetamodel(CreditPayment.class)
public class CreditPayment_ { 

    public static volatile SingularAttribute<CreditPayment, String> dateCredit;
    public static volatile SingularAttribute<CreditPayment, Integer> idCreditPayment;
    public static volatile SingularAttribute<CreditPayment, String> totalCredit;
    public static volatile SingularAttribute<CreditPayment, String> numberCredit;
    public static volatile SingularAttribute<CreditPayment, Rent> idCarRent;

}