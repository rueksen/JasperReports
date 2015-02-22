package de.hsrm.cs.swtprojekt.knauf.jasperreports.beandatasource;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

 
public class JasperReportsBeanDataSourceTestApp extends JFrame
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
    JasperReportsBeanDataSourceTestApp frameJasperReports = new JasperReportsBeanDataSourceTestApp();
    
    frameJasperReports.setVisible(true);

  }
  
  /**
   * This is the default constructor
   */
  public JasperReportsBeanDataSourceTestApp()
  {
    super();
    initialize();
    
    
    //WICHTIG: "JDK" muss gewählt sein, da "javac" ausgeführt wird!!!
    try
    {
      PersonDataSourceProvider dataSourceProvider = new PersonDataSourceProvider();
      //Die JRDataSource will zwar im "create" nen Report-Parameter, aber der ist hier egal.
      JRDataSource jrDataSource = dataSourceProvider.create(null);
      
      
      //Variante 1: selbst compilieren!
      //JasperReport js = JasperCompileManager.compileReport("beandatasourcereport.jrxml");
      //JasperPrint jp = JasperFillManager.fillReport(js, new HashMap(), jrDataSource);
     
      
      //=================
      
      //Variante 2: vorcompiliertes Dingsda nehmen!
      JasperPrint jp = JasperFillManager.fillReport("beandatasourcereport.jasper",
          new HashMap<String, Object>(), jrDataSource);
      
      //Variante 2 mit vompilieren der "jasper"-Datei:
      //JasperCompileManager.compileReportToFile("beandatasourcereport.jrxml","beandatasourcereport.jasper"); 
      
      
      JRViewer viewer = new JRViewer(jp);
      
      
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
