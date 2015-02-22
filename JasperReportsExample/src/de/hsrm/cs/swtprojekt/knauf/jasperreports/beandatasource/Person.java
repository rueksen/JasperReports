package de.hsrm.cs.swtprojekt.knauf.jasperreports.beandatasource;

import java.io.Serializable;

/**Dummy-Datenklasse f�r den Report: eine einzelne Person.
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

  /**Konstruktor, dem alle Daten �bergeben werden.
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
   * @param nachname Neuer Nachname, keine Einschr�nkungen.
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
   * @param vorname Neuer Vorname, keine Einschr�nkungen.
   */
  public void setVorname(String vorname)
  {
    this.sVorname = vorname;
  }
}
