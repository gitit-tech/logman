package com.gitittech.errorman.models;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-15T14:41:44")
@StaticMetamodel(Log.class)
public class Log_ { 

    public static volatile SingularAttribute<Log, String> appController;
    public static volatile SingularAttribute<Log, Date> dateCreated;
    public static volatile SingularAttribute<Log, String> level;
    public static volatile SingularAttribute<Log, String> description;
    public static volatile SingularAttribute<Log, BigInteger> id;
    public static volatile SingularAttribute<Log, String> stackTrace;

}