package generador;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.swing.BorderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JComboBox;

import javax.swing.JTextArea;

import javax.swing.JTree;

import javax.swing.JPanel;

class JLabel1 extends JLabel{
  public JLabel1(String nombre){
     super.setText(nombre);
     super.setForeground(Color.white);        
  }  
}

class NuevoJPanel extends javax.swing.JPanel
{
    private Color color1 = new Color(0,0,0);
    private Color color2 = new Color(255,255,255);
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();
        float x=getWidth();
        float y=getHeight();
        g2.setPaint(new GradientPaint(0.0f, 0.0f, color1.darker(),
                0.0f, getHeight(), color2.darker()));
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
    }
   //M�todos set y get que nos permiten modificar los colores
    public Color getColor1() {return color1;}
    public void setColor1(Color color1) {this.color1 = color1;}
    public Color getColor2() {return color2;}
    public void setColor2(Color color2){this.color2 = color2;}
}
class interfaz extends JFrame{
      NuevoJPanel panelInterior;
      JPanel panelExterior;      
   JLabel1 lblPara;
   JLabel1 lblHost;
   JTextField txtHost;
   JLabel1 lblDatabase;
   JTextField txtDatabase;
   JLabel1 lblPuerto;
   JTextField txtPuerto;
   JLabel1 lblPara1;
   JLabel1 lblHost1;
   JTextField txtHost1;
   JLabel1 lblPort2;
   JTextField txtPort2;
   JLabel1 lblDatabase1;
   JTextField txtDatabase1;
   JLabel1 cbPara2;
    JComboBox  cbnuevo;
   JLabel1 taPara3;
    JTextArea  tanuevo2;
   JLabel1 arPara6;
    JTree  arhola;

   public interfaz(){
      panelInterior = new NuevoJPanel();
      panelInterior.setLayout(null);
      
      panelExterior = new JPanel();      
      panelExterior.setLayout(null);
      
      this.setLayout(null);
      lblPara=new JLabel1("Parámetros de Bases de Datos");
      lblPara.setBounds(10,10,200,20);
      panelInterior.add(lblPara);

      lblHost=new JLabel1("Host");
       txtHost=new JTextField("");
      lblHost.setBounds(10,31,60,20);
      txtHost.setBounds(65,31,100,20);
      panelInterior.add(lblHost);
      panelInterior.add(txtHost);

      lblDatabase=new JLabel1("Database");
       txtDatabase=new JTextField("");
      lblDatabase.setBounds(10,52,60,20);
      txtDatabase.setBounds(65,52,100,20);
      panelInterior.add(lblDatabase);
      panelInterior.add(txtDatabase);

      lblPuerto=new JLabel1("Puerto");
       txtPuerto=new JTextField("");
      lblPuerto.setBounds(10,73,60,20);
      txtPuerto.setBounds(65,73,100,20);
      panelInterior.add(lblPuerto);
      panelInterior.add(txtPuerto);

      lblPara1=new JLabel1("Parámetros de servidor");
      lblPara1.setBounds(200,10,200,20);
      panelInterior.add(lblPara1);

      lblHost1=new JLabel1("Host1");
       txtHost1=new JTextField("");
      lblHost1.setBounds(200,31,60,20);
      txtHost1.setBounds(255,31,100,20);
      panelInterior.add(lblHost1);
      panelInterior.add(txtHost1);

      lblPort2=new JLabel1("Port2");
       txtPort2=new JTextField("");
      lblPort2.setBounds(200,52,60,20);
      txtPort2.setBounds(255,52,100,20);
      panelInterior.add(lblPort2);
      panelInterior.add(txtPort2);

      lblDatabase1=new JLabel1("Database1");
       txtDatabase1=new JTextField("");
      lblDatabase1.setBounds(200,73,60,20);
      txtDatabase1.setBounds(255,73,100,20);
      panelInterior.add(lblDatabase1);
      panelInterior.add(txtDatabase1);

      cbPara2=new JLabel1("Opciones de guardado");
      cbPara2.setBounds(390,10,200,20);
      panelInterior.add(cbPara2);

           cbnuevo= new JComboBox();
      cbnuevo.setBounds(390,40,100,20);
      cbnuevo.addItem ("nuevo");
      panelInterior.add(cbnuevo);

      taPara3=new JLabel1("Datos");
      taPara3.setBounds(580,10,200,20);
      panelInterior.add(taPara3);

           tanuevo2= new JTextArea();
      tanuevo2.setBounds(580,40,150,100);
       tanuevo2.append("Escribe un texto aqui");
      panelInterior.add(tanuevo2);

      arPara6=new JLabel1("Archivos nuevos");
      arPara6.setBounds(770,10,200,20);
      panelInterior.add(arPara6);

           arhola= new JTree();
      arhola.setBounds(770,40,150,100);
      panelInterior.add(arhola);

      panelInterior.setBounds(10,20,960,207);
      panelInterior.setBackground(new Color(20, 100, 128));
      panelInterior.setForeground(Color.white);
      panelInterior.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.yellow));
      
      panelExterior.setBorder(BorderFactory.createMatteBorder(2,2,5,5,Color.black));
      panelExterior.setBackground(new Color(20, 100, 128));

      setContentPane(panelExterior);            
      add(panelInterior);
      this.setVisible(true);
      JButton btnprocesar=new JButton("Guardar");
      btnprocesar.setBounds(450,187,100,20);
      panelInterior.add(btnprocesar);
      this.setSize(1000,287);
      this.setResizable(false);
      this.setTitle("Parámetros");

      leerXML();


      this.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
           System.exit(0);
        }
      });

      btnprocesar.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String Host=txtHost.getText();
            String Database=txtDatabase.getText();
            String Puerto=txtPuerto.getText();
            String Host1=txtHost1.getText();
            String Port2=txtPort2.getText();
            String Database1=txtDatabase1.getText();
            String nuevo="";
            String nuevo2="";
            String hola="";

            String xml="<parametros>\r\n";
            xml=xml+"   <parametro"+" Host="+(char)34+Host+(char)34+" Database="+(char)34+Database+(char)34+" Puerto="+(char)34+Puerto+(char)34+" Host1="+(char)34+Host1+(char)34+" Port2="+(char)34+Port2+(char)34+" Database1="+(char)34+Database1+(char)34+" nuevo="+(char)34+nuevo+(char)34+" nuevo2="+(char)34+nuevo2+(char)34+" hola="+(char)34+hola+(char)34+"></parametro>";
            xml=xml+"\r\n</parametros>\r\n";

            crearArchivo("parametros.xml",xml);
         }

      });
   }

    public static void crearArchivo(String nombre,String cadena){
       try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(nombre));
          
          bw.write(cadena);
          bw.close();
       }catch(Exception e){
          System.out.println("Ha ocurrido un error al intentar escribir el archivo "+nombre);
       }   
    }


    public void leerXML(){    
       Document dom;       
       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
       try {
          //Using factory get an instance of document builder
          DocumentBuilder db = dbf.newDocumentBuilder();          
          dom = db.parse("parametros.xml");
                    
          Element docEle = dom.getDocumentElement();                   
           
          NodeList nl1 = docEle.getElementsByTagName("parametro");
          Node node = nl1.item(0);
          Element ele = (Element)node;

          String Host = ele.getAttribute("Host");
          String Database = ele.getAttribute("Database");
          String Puerto = ele.getAttribute("Puerto");
          String Host1 = ele.getAttribute("Host1");
          String Port2 = ele.getAttribute("Port2");
          String Database1 = ele.getAttribute("Database1");

          txtHost.setText(Host);
          txtDatabase.setText(Database);
          txtPuerto.setText(Puerto);
          txtHost1.setText(Host1);
          txtPort2.setText(Port2);
          txtDatabase1.setText(Database1);
          
       }catch(Exception e ){
           System.out.println("Error al parsear");
       }       
    }


    public static void main(String[] args) {        
        interfaz v=new interfaz();
    }
}
