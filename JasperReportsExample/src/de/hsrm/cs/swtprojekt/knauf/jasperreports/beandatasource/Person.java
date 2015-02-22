package de.hsrm.cs.swtprojekt.knauf.jasperreports.beandatasource;

import java.io.Serializable;

/**Dummy-Datenklasse für den Report: eine einzelne Person.
 * 
 * @author Wolfgang Knauf
 *
 */
public class Person implements Serializable
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**Nachname der Prson
   */
  private String sNachname;
  
  /**Vorname der Person
   */
  private String sVorname;

  /**Konstruktor, dem alle Daten übergeben werden.
   * 
   * @param nachname Nachname
   * @param vorname  Vorname
   */
  public Person(String nachname, String vorname)
  {
    this.sNachname = nachname;
    this.sVorname = vorname;
  }
  
  /**Nachnamen abrufen
   * @return Aktueller Nachname
   */
  public String getNachname()
  {
    return this.sNachname;
  }

  /**Neuen Nachnamen setzen.
   * @param nachname Neuer Nachname, keine Einschränkungen.
   */
  public void setNachname(String nachname)
  {
    this.sNachname = nachname;
  }

  /**Vornamen abrufen
   * @return Aktueller Vorname
   */
  public String getVorname()
  {
    return this.sVorname;
  }

  /**Setzen des neuen Vornamens
   * @param vorname Neuer Vorname, keine Einschränkungen.
   */
  public void setVorname(String vorname)
  {
    this.sVorname = vorname;
  }
}
