package de.hsrm.cs.swtprojekt.knauf.jasperreports.beandatasource;

import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;

/**
 * Data source provider implementation that provides a bean collection 
 * data source containing instances of Person class.
 * 
 */
public class PersonDataSourceProvider extends JRAbstractBeanDataSourceProvider
{
  /**
   * Konstruktor, in dem nichts passiert. Der Parentklasse wird gesagt, dass 
   * wir hier eine @see Person als Bean verwenden.
   * 
   */
  public PersonDataSourceProvider()
  {
    super(Person.class);
  }

  /**Erzeugen der DataSource für einen Report.
   * @return Hier kommt eine Liste mit genau zwei Personen zurück.
   * @param report Dieser Parameter ist hier egal.
   * @exception JRException Wird hier nie ausgelöst.
   */
  @Override
  public JRDataSource create(JasperReport report) throws JRException
  {
    List<Person> collection = new ArrayList<Person>();
    collection.add(new Person("Teodor", "Danciu"));
    collection.add(new Person("Peter", "Severin"));
    return new JRBeanCollectionDataSource(collection);
  }

  /**Dispose ist überladen und macht hier nix.
   * @param dataSource egaler Parameter
   * @exception JRException Wird hier nie ausgelöst.
   */
  @Override
  public void dispose(JRDataSource dataSource) throws JRException
  {
    // nothing to dispose
   
  } 

}
