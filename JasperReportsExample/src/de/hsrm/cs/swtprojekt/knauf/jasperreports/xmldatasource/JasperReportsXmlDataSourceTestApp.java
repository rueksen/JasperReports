package de.hsrm.cs.swtprojekt.knauf.jasperreports.xmldatasource;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.w3c.dom.Document;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.query.JRXPathQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRXmlUtils;
import net.sf.jasperreports.swing.JRViewer;

/**Anwendung für das "Report aus XML-Datenquelle laden"-Beispiel
 * 
 * @author Wolfgang Knauf
 *
 */
public class JasperReportsXmlDataSourceTestApp extends JFrame
{
  /**Damit der Compiler keine Warnungen ausspuckt wird hier eine VersionID deklariert.
   */
  private static final long serialVersionUID = 1L;

  /**Auf diesem Pane landet der Report*/
  private JPanel jContentPane = null;
  
  /**Main-Methode baut das Anwendungsfenster auf und rendert den Report 
   * @param args Kommandozeile, hier ohne Funktion.
   */
  public static void main(String[] args)
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    JasperReportsXmlDataSourceTestApp frameJasperReports = new JasperReportsXmlDataSourceTestApp();
    
    frameJasperReports.setVisible(true);

  }
  
  /**
   * This is the default constructor
   */
  public JasperReportsXmlDataSourceTestApp()
  {
    super();
    initialize();
    
    
    try
    {
      Map<String, Object> params = new HashMap<String, Object>();
      Document document = JRXmlUtils.parse(JRLoader.getLocationInputStream("Romane.xml"));
      params.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT, document);
      
      //Vorcompilierten Report laden:
      JasperPrint print = JasperFillManager.fillReport("romanereport.jasper", params);
      
      JRViewer viewer = new JRViewer(print);
      
      //GridBagLayout: 100% füllen in alle Richtungen.
      GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
      gridBagConstraints3.fill = java.awt.GridBagConstraints.BOTH;
      gridBagConstraints3.gridy = 0;
      gridBagConstraints3.insets = new java.awt.Insets(5, 5, 5, 5);
      gridBagConstraints3.gridx = 0;
      gridBagConstraints3.weightx = 1.0;
      gridBagConstraints3.weighty = 1.0;
      
      jContentPane.add(viewer, gridBagConstraints3);

    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }


  /**
   * This method initializes this
   * 
   */
  private void initialize()
  {
    this.setSize(300, 200);
    this.setContentPane(getJContentPane());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("JFrame");
  }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane()
  {
    if (jContentPane == null)
    {
      jContentPane = new JPanel();
      
      jContentPane.setLayout(new GridBagLayout());
     
    }
    return jContentPane;
  }
}
