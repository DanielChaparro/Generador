
package generador;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class generador {

    //int x,y,alto;    
    int mayorAlto;
    int alto;

    String variablesDeControl="";
    String creacionDeControles="";
    String parametrosParcial = "";
    String parametrosGlobal = "";

    String codigoParaLeer = "";
    
    String variablesDeArchivo="";
    String codigoParaSetear = "";
    
    

    public void generarClase(String cadena) {
        
        String aux[] = cadena.split("\nc");
//        
//        for (int t = 0; t< aux.length; t++) {
//            String acumulado=aux[t].substring(0, 1);
//        
//            if("l".equals(acumulado)){
////                System.out.println("HOLAAAAAAAAAA"+aux[t]);
//        
//                
//     }
//        }
        int x, y;

        x = 10;
        y = 10;

        mayorAlto = 0;

        String salida;
        salida = "";
        //int ancho=0,alto=30;


        mayorAlto = 0;
        parametrosGlobal = "            String xml=" + (char) 34 + "<parametros>" + (char)92+(char)114+(char)92+(char)110+(char) 34 + ";\r\n";
        parametrosGlobal = parametrosGlobal + "            xml=xml+" + (char) 34 + "   <parametro" + (char) 34 + "+";
        
        
       
        for (int i = 0; i < aux.length; i++) {
              String acumulado=aux[i].substring(0, 1);
//        
            if("l".equals(acumulado)){
            System.out.println(aux[i]);
            alto = 0;

            salida = salida + getCodigo(aux[i], x, y);
            }
           
            if("c".equals(acumulado)){
              salida=salida+getCombo(aux[i], x, y);
            }
            
            if("t".equals(acumulado)){
                salida=salida+getTextArea(aux[i], x, y);
            }
            
            if("a".equals(acumulado)){
                salida=salida+getTree(aux[i], x, y);
            }
            
            
            if (i < aux.length - 1) {
                parametrosGlobal = parametrosGlobal + parametrosParcial +"+";
            } else {
                //parametrosGlobal=parametrosGlobal+parametrosParcial+";";    
                parametrosGlobal = parametrosGlobal + parametrosParcial;
            }
            parametrosParcial = "";

            if (alto > mayorAlto) {
                mayorAlto = alto;
            }
            x = x + 190;
            
        
        } 
        //System.out.println("controles son:\n"+creacionDeControles);
        //System.out.println("Codigo para leer es\n" + codigoParaLeer);
        //System.out.println("Parametros parcial es\n" + parametrosParcial);
        System.out.println("Variables de archivo son\n"+variablesDeArchivo);
        System.out.println("Codigo para setear es\n"+codigoParaSetear);
        
        

        parametrosGlobal = parametrosGlobal + "+"+(char)34+"></parametro>"+(char)34+";";

        //parametrosGlobal=parametrosGlobal+"xml=xml+"+(char)34+"</parametros>\r\n"+(char)34+";\r\n";
        parametrosGlobal = parametrosGlobal;
        parametrosGlobal = parametrosGlobal +  "\n            xml=xml+"+(char) 34 + (char)92+(char)114+(char)92+(char)110+ "</parametros>" + (char)92+(char)114+(char)92+(char)110+(char)34 +";\r\n";
        
        //System.out.println("Parametros global es\n" + parametrosGlobal);
        //System.out.println("Codigo para leer es:\n" + codigoParaLeer);
        
        int ancho = 200 * aux.length;
        
        //generación de variable salida con el código necesario
        salida = salida + "package generador;\r\n";
        salida = salida + "" + "\r\n";

        salida=salida+"import java.awt.Color;\r\n";
        salida=salida+"import java.awt.GradientPaint;\r\n";
        salida=salida+"import java.awt.Graphics;\r\n";
        salida=salida+"import java.awt.Graphics2D;\r\n";
        salida=salida+"import java.awt.Rectangle;\r\n";
        
        salida = salida + "import java.awt.event.ActionEvent;\r\n";
        salida = salida + "import java.awt.event.ActionListener;\r\n";
        salida = salida + "import javax.swing.JButton;\r\n";
        salida = salida + "import java.awt.event.WindowAdapter;\r\n";
        salida = salida + "import java.awt.event.WindowEvent;\r\n";
        salida=salida+"import java.io.BufferedWriter;\r\n";
        salida=salida+"import java.io.FileWriter;\r\n";
        salida=salida+"import javax.xml.parsers.DocumentBuilder;\r\n";
        salida=salida+"import javax.xml.parsers.DocumentBuilderFactory;\r\n";
        salida=salida+"import javax.xml.parsers.ParserConfigurationException;\r\n";  
        salida=salida+"import javax.swing.BorderFactory;\r\n";  
        
        
        salida=salida+"import org.w3c.dom.Document;\r\n";
        salida=salida+"import org.w3c.dom.Element;\r\n";
        salida=salida+"import org.w3c.dom.Node;\r\n";
        salida=salida+"import org.w3c.dom.NodeList;\r\n";        

        salida = salida + "import javax.swing.JFrame;" + "\r\n";
        salida = salida + "import javax.swing.JLabel;" + "\r\n";
        salida = salida + "import javax.swing.JTextField;" + "\r\n\r\n";
        salida = salida + "import javax.swing.JComboBox;" + "\r\n\r\n";
        salida = salida + "import javax.swing.JTextArea;"+"\r\n\r\n";
        salida = salida + "import javax.swing.JTree;"+"\r\n\r\n";
        salida = salida + "import javax.swing.JPanel;" + "\r\n\r\n";
        
        

        salida=salida+"class JLabel1 extends JLabel{\r\n";
        salida=salida+"  public JLabel1(String nombre){\r\n";
        salida=salida+"     super.setText(nombre);\r\n";
        salida=salida+"     super.setForeground(Color.white);        \r\n";
        salida=salida+"  }  \r\n";
        salida=salida+"}\r\n";
        salida=salida+"\r\n";
        
        salida=salida+"class NuevoJPanel extends javax.swing.JPanel\r\n";
        salida=salida+"{\r\n";
        salida=salida+"    private Color color1 = new Color(0,0,0);\r\n";
        salida=salida+"    private Color color2 = new Color(255,255,255);\r\n";
        salida=salida+"    protected void paintComponent(Graphics g)\r\n";
        salida=salida+"    {\r\n";
        salida=salida+"        Graphics2D g2 = (Graphics2D) g.create();\r\n";
        salida=salida+"        Rectangle clip = g2.getClipBounds();\r\n";
        salida=salida+"        float x=getWidth();\r\n";
        salida=salida+"        float y=getHeight();\r\n";
        salida=salida+"        g2.setPaint(new GradientPaint(0.0f, 0.0f, color1.darker(),\r\n";
        salida=salida+"                0.0f, getHeight(), color2.darker()));\r\n";
        salida=salida+"        g2.fillRect(clip.x, clip.y, clip.width, clip.height);\r\n";
        salida=salida+"    }\r\n";
        salida=salida+"   //M�todos set y get que nos permiten modificar los colores\r\n";
        salida=salida+"    public Color getColor1() {return color1;}\r\n";
        salida=salida+"    public void setColor1(Color color1) {this.color1 = color1;}\r\n";
        salida=salida+"    public Color getColor2() {return color2;}\r\n";
        salida=salida+"    public void setColor2(Color color2){this.color2 = color2;}\r\n";
        salida=salida+"}\r\n";


        salida = salida + "class interfaz extends JFrame{" + "\r\n";
        
        salida=salida+"      NuevoJPanel panelInterior;\r\n";
        salida=salida+"      JPanel panelExterior;      \r\n";
        
        
        variablesDeControl=variablesDeControl+"\r\n";
        salida=salida+variablesDeControl;
        salida = salida + "   public interfaz(){" + "\r\n";

        salida=salida+"      panelInterior = new NuevoJPanel();\r\n";
        salida=salida+"      panelInterior.setLayout(null);\r\n";
        salida=salida+"      \r\n";
        salida=salida+"      panelExterior = new JPanel();      \r\n";
        salida=salida+"      panelExterior.setLayout(null);\r\n";
        
        salida = salida + "      " + "\r\n";
        salida = salida + "      this.setLayout(null);" + "\r\n";
        

        salida=salida+creacionDeControles;
        
        //salida = salida + "      " + "\r\n";
        salida=salida+"      panelInterior.setBounds(10,20,"+(ancho-40)+","+(alto+60)+");\r\n";
        salida=salida+"      panelInterior.setBackground(new Color(20, 100, 128));\r\n";
        salida=salida+"      panelInterior.setForeground(Color.white);\r\n";
        salida=salida+"      panelInterior.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.yellow));\r\n";
        salida=salida+"      \r\n";
        salida=salida+"      panelExterior.setBorder(BorderFactory.createMatteBorder(2,2,5,5,Color.black));\r\n";
        salida=salida+"      panelExterior.setBackground(new Color(20, 100, 128));\r\n";
        salida=salida+"\r\n";
        salida=salida+"      setContentPane(panelExterior);            \r\n";
        salida=salida+"      add(panelInterior);\r\n";

        salida = salida + "      this.setVisible(true);" + "\r\n";

        int xb;//posición x del botón. utilizada para centrarlo en la pantalla

        xb = (ancho - 100) / 2;
        System.out.println("Xb es " + xb);

        salida = salida + "      JButton btnprocesar=new JButton(" + (char) 34 + "Guardar" + (char) 34 + ");\r\n";
        //salida=salida+  "      btnprocesar.setBounds(40,"+(alto+20)+",100,20);\r\n";
        salida = salida + "      btnprocesar.setBounds(" + xb + "," + (mayorAlto + 40) + ",100,20);\r\n";
        salida = salida + "      panelInterior.add(btnprocesar);\r\n";

        mayorAlto = mayorAlto + 110;

        salida = salida + "      this.setSize(" + ancho + "," + (mayorAlto+30) + ");" + "\r\n";
        salida = salida + "      this.setResizable(false);\r\n";
        salida = salida + "      this.setTitle(" + (char) 34 + "Parámetros" + (char) 34 + ");\r\n\r\n";
        salida=salida+"      leerXML();\r\n\r\n";
        
        salida = salida + "\r\n";
        salida = salida + "      this.addWindowListener(new WindowAdapter() {\r\n";
        salida = salida + "        public void windowClosing(WindowEvent we) {\r\n";
        salida = salida + "           System.exit(0);\r\n";
        salida = salida + "        }\r\n";
        salida = salida + "      });\r\n";

        salida = salida + generarMetodoDeLectura();

        salida = salida + "   }" + "\r\n\r\n";
        
        salida=salida+getMetodoCrearArchivo()+"\r\n\r\n";
        
        salida=salida+getMetodoLeerXML()+"\r\n\r\n";

        salida = salida + "    public static void main(String[] args) {        " + "\r\n";
        salida = salida + "        interfaz v=new interfaz();" + "\r\n";
        salida = salida + "    }" + "\r\n";
        salida = salida + "}" + "\r\n";

        //System.out.println("Salida es\n"+salida);
        crearArchivo("src/generador/interfaz.java", salida);
//        }
              
    }

    public String ch(String cadena) {
        return ((char) 34 + cadena + (char) 34);
    }

    public String getTree(String cadena,int x,int y){
        String salida="";
        String tree;
        String label;
        String aux[];
        String tipoControl;
        String valorControl;
        
        String linea[]=cadena.split(",");
        for (int i = 0; i < linea.length; i++) {
            label="lbl"+linea[i];
            tree="ar"+linea[i];
            if(linea[i].indexOf(":")>0){
            aux=linea[i].split(":");
            tipoControl=aux[0];
            valorControl=aux[1];
            label=aux[0].replace("ar:", " ");
            
             variablesDeControl=variablesDeControl+"   JLabel1 " + label+";\r\n";
             creacionDeControles = creacionDeControles + "      " + label + "=new JLabel1(" + (char) 34 + valorControl + (char) 34 + ");" + "\r\n";
             creacionDeControles = creacionDeControles + "      " + label + ".setBounds(" + x + "," + y + ",200,20);" + "\r\n";
             creacionDeControles = creacionDeControles + "      panelInterior.add(" + label+ ");" + "\r\n\r\n";
        }else{
            variablesDeControl=variablesDeControl+"    JTree  "+ tree+";\r\n";
            creacionDeControles=  creacionDeControles+"           "+tree+"= new JTree();" + "\r\n";
            creacionDeControles = creacionDeControles + "      " + tree + ".setBounds(" + (x) + "," + (y+30) + ",150,100);" + "\r\n";
          
            creacionDeControles = creacionDeControles + "      panelInterior.add(" +tree + ");" + "\r\n\r\n";  
            
             codigoParaLeer = codigoParaLeer + "            String " + linea[i] + "=" +(char)34+""+(char)34+ ";\r\n";
            
            if (i < (linea.length - 1)) {
                    //parametrosParcial=parametrosParcial+ch(linea[i]+"=")+"+ch("+linea[i]+")+"+" "; 
                    parametrosParcial = parametrosParcial + (char) 34 + " "+linea[i] + "=" + (char) 34 + "+(char)34+" + linea[i] + "+(char)34+"+ " " ;
                } else {
                    //parametrosParcial=parametrosParcial+ch(linea[i]+"=")+"+ch("+linea[i]+")";
                    parametrosParcial = parametrosParcial + (char) 34 + " "+linea[i] + "=" + (char) 34 + "+(char)34+" + linea[i] + "+(char)34";
                }

            parametrosParcial=parametrosParcial.trim();
            //salida = salida + "\r\n";

            y = y + 21;
            alto = alto + 21;
            }
            
        
        }
        
        return (salida);
    }
    
    public String getTextArea(String cadena,int x,int y){
        
        String salida="";
        String Area;
        String label;
        String aux[];
        String tipoControl;
        String valorControl;
        
        String linea[]=cadena.split(",");
        for (int i = 0; i < linea.length; i++) {
            label="lbl"+linea[i];
            Area="ta"+linea[i];
            if(linea[i].indexOf(":")>0){
            aux=linea[i].split(":");
            tipoControl=aux[0];
            valorControl=aux[1];
            label=aux[0].replace("ta:", " ");
            
             variablesDeControl=variablesDeControl+"   JLabel1 " + label+";\r\n";
             creacionDeControles = creacionDeControles + "      " + label + "=new JLabel1(" + (char) 34 + valorControl + (char) 34 + ");" + "\r\n";
             creacionDeControles = creacionDeControles + "      " + label + ".setBounds(" + x + "," + y + ",200,20);" + "\r\n";
             creacionDeControles = creacionDeControles + "      panelInterior.add(" + label + ");" + "\r\n\r\n";
        }else{
            variablesDeControl=variablesDeControl+"    JTextArea  "+  Area+";\r\n";
            creacionDeControles=  creacionDeControles+"           "+Area+"= new JTextArea();" + "\r\n";
            creacionDeControles = creacionDeControles + "      " + Area + ".setBounds(" + (x) + "," + (y+30) + ",150,100);" + "\r\n";
            creacionDeControles=creacionDeControles +"       "+Area+".append("+(char)34+"Escribe un texto aqui"+(char)34+");"+"\r\n";
            creacionDeControles = creacionDeControles + "      panelInterior.add(" +Area + ");" + "\r\n\r\n";  
            
             codigoParaLeer = codigoParaLeer + "            String " + linea[i] + "=" +(char)34+""+(char)34+ ";\r\n";
            
            if (i < (linea.length - 1)) {
                    //parametrosParcial=parametrosParcial+ch(linea[i]+"=")+"+ch("+linea[i]+")+"+" "; 
                    parametrosParcial = parametrosParcial + (char) 34 + " "+linea[i] + "=" + (char) 34 + "+(char)34+" + linea[i] + "+(char)34+"+ " " ;
                } else {
                    //parametrosParcial=parametrosParcial+ch(linea[i]+"=")+"+ch("+linea[i]+")";
                    parametrosParcial = parametrosParcial + (char) 34 + " "+linea[i] + "=" + (char) 34 + "+(char)34+" + linea[i] + "+(char)34";
                }

            parametrosParcial=parametrosParcial.trim();
            //salida = salida + "\r\n";

            y = y + 21;
            alto = alto + 21;
            }
            
        }
        
        return (salida);
    }
    
    public String getCombo(String cadena,int x,int y){
        
        String salida="";
        String combo;
        String label;
        String aux[];   
        String tipoControl;
        String valorControl;
        
        String linea[]=cadena.split(",");
        for (int i = 0; i < linea.length; i++) {
            
            label = "lbl" + linea[i];//lblhost, etc...
           
            combo = "cb" +linea[i] ;
                System.out.println(combo);
                    String repa=combo.replace("(","");
                 System.out.println(repa);
             if (linea[i].indexOf(":") > 0 || linea[i].indexOf("-")>0) {// si lo encuentra
               aux = linea[i].split(":");
                
               tipoControl = aux[0];
               valorControl = aux[1];
               label = aux[0].replace("cb:", "");
//               label=aux[].replace("-", " ");
//               label=aux[0].replace("( ", " ");
                   


                variablesDeControl=variablesDeControl+"   JLabel1 " + label+";\r\n";
                creacionDeControles = creacionDeControles + "      " + label + "=new JLabel1(" + (char) 34 + valorControl + (char) 34 + ");" + "\r\n";
                creacionDeControles = creacionDeControles + "      " + label + ".setBounds(" + x + "," + y + ",200,20);" + "\r\n";
                
                creacionDeControles = creacionDeControles + "      panelInterior.add(" + label + ");" + "\r\n\r\n";
                
               }else{
                    
            variablesDeControl=variablesDeControl+"    JComboBox  "+  repa+";\r\n";
            creacionDeControles=  creacionDeControles+"           "+repa+"= new JComboBox();" + "\r\n";
            creacionDeControles = creacionDeControles + "      " + repa + ".setBounds(" + (x) + "," + (y+30) + ",100,20);" + "\r\n";
            String guardar=linea[i];
//            String acumulado[]=guardar.split("(");
                 
//                 System.out.println(linea[i]);
//                
//                 for (int j = 0; j < acumulado.length; j++) {
//                     System.out.println(acumulado[j]);
//                 }   
//                
//                 for (int j = 0; j < acumulado.length; j++) {
//            
            creacionDeControles=   creacionDeControles+ "      "+repa+".addItem ("+(char)34+linea[i]+(char)34+");\r\n";
//                 }
            creacionDeControles = creacionDeControles + "      panelInterior.add(" +repa + ");" + "\r\n\r\n";  
            
            codigoParaLeer = codigoParaLeer + "            String " + linea[i] + "=" +(char)34+""+(char)34+ ";\r\n";
//                
//                codigoParaSetear = codigoParaSetear + "          txt" + linea[i] + ".setText(" + linea[i] + ");\r\n";
//                
//                variablesDeArchivo=variablesDeArchivo+"          String "+linea[i]+" = ele.getAttribute("+(char)34+linea[i]+(char)34+");\r\n";
//                                
                if (i < (linea.length - 1)) {
                    //parametrosParcial=parametrosParcial+ch(linea[i]+"=")+"+ch("+linea[i]+")+"+" "; 
                    parametrosParcial = parametrosParcial + (char) 34 + " "+linea[i] + "=" + (char) 34 + "+(char)34+" + linea[i] + "+(char)34+"+ " " ;
                } else {
                    //parametrosParcial=parametrosParcial+ch(linea[i]+"=")+"+ch("+linea[i]+")";
                    parametrosParcial = parametrosParcial + (char) 34 + " "+linea[i] + "=" + (char) 34 + "+(char)34+" + linea[i] + "+(char)34";
                }

            parametrosParcial=parametrosParcial.trim();
            //salida = salida + "\r\n";

            y = y + 21;
            alto = alto + 21;
               }
        }
        return(salida);
    }
    public String getCodigo(String cadena, int x, int y) {
        String salida = "";

        String linea[] = cadena.split(",");
        String label;
        String texto;
        String combo;
        String tipoControl;
        String valorControl;
        String aux[];

        //String codigoParaLeer="";
        //dividir la cadena por "nc"     
        
        for (int i = 0; i < linea.length; i++) {

            label = "lbl" + linea[i];//lblhost, etc...
            texto = "txt" + linea[i];
//            combo = "cb"   ;
      
                
            
//            String acumulado=linea[i].substring(0, 1);
            
////            if("c".equals(acumulado)){
//            if(linea[i].contains("cb")){
//            variablesDeControl=variablesDeControl+"    JComboBox  "+  combo+";\r\n";
//            creacionDeControles=  creacionDeControles+"           "+combo+"= new JComboBox();" + "\r\n";
//            creacionDeControles = creacionDeControles + "      " + combo + ".setBounds(" + (x +55 ) + "," + (y+65) + ",100,20);" + "\r\n";
//            creacionDeControles = creacionDeControles + "      panelInterior.add(" +combo + ");" + "\r\n\r\n";     
//            
        
//            }else{
                
                        
            if (linea[i].indexOf(":") > 0) {
                aux = linea[i].split(":");
                tipoControl = aux[0];
                valorControl = aux[1];

                label = aux[0].replace("lbl:", "");
//                label=aux[1].replace("(", "");
//                label=aux[1].replace("cb: ", " ");
                variablesDeControl=variablesDeControl+"   JLabel1 " + label+";\r\n";

                creacionDeControles = creacionDeControles + "      " + label + "=new JLabel1(" + (char) 34 + valorControl + (char) 34 + ");" + "\r\n";
                creacionDeControles = creacionDeControles + "      " + label + ".setBounds(" + x + "," + y + ",200,20);" + "\r\n";
                creacionDeControles = creacionDeControles + "      panelInterior.add(" + label + ");" + "\r\n\r\n";
            } else {
                
                variablesDeControl=variablesDeControl+"   JLabel1 " + label+";\r\n";
                variablesDeControl=variablesDeControl+"   JTextField " + texto+";\r\n";
//                variablesDeControl=variablesDeControl+"    JComboBox  "+  combo+";\r\n";
                
                creacionDeControles = creacionDeControles + "      " + label + "=new JLabel1(" + (char) 34 + linea[i] + (char) 34 + ");" + "\r\n";
                creacionDeControles = creacionDeControles+ "       " + texto + "=new JTextField(" + (char) 34 + "" + (char) 34 + ");" + "\r\n";
//                creacionDeControles=  creacionDeControles+"           "+combo+"= new JComboBox();" + "\r\n";
                
                creacionDeControles = creacionDeControles + "      " + label + ".setBounds(" + x + "," + y + ",60,20);" + "\r\n";
                creacionDeControles = creacionDeControles + "      " + texto + ".setBounds(" + (x + 55) + "," + y + ",100,20);" + "\r\n";
//                creacionDeControles = creacionDeControles + "      " + combo + ".setBounds(" + (x +55 ) + "," + (y+25) + ",100,20);" + "\r\n";
                
                creacionDeControles = creacionDeControles + "      panelInterior.add(" + label + ");" + "\r\n";
                creacionDeControles = creacionDeControles + "      panelInterior.add(" + texto + ");" + "\r\n\r\n";
//                creacionDeControles = creacionDeControles + "      panelInterior.add(" +combo + ");" + "\r\n\r\n";
                
                
            
        
                    
                codigoParaLeer = codigoParaLeer + "            String " + linea[i] + "=txt" + linea[i] + ".getText();\r\n";
                
                codigoParaSetear = codigoParaSetear + "          txt" + linea[i] + ".setText(" + linea[i] + ");\r\n";
                
                variablesDeArchivo=variablesDeArchivo+"          String "+linea[i]+" = ele.getAttribute("+(char)34+linea[i]+(char)34+");\r\n";
                                
                if (i < (linea.length - 1)) {
                    //parametrosParcial=parametrosParcial+ch(linea[i]+"=")+"+ch("+linea[i]+")+"+" "; 
                    parametrosParcial = parametrosParcial + (char) 34 + " "+linea[i] + "=" + (char) 34 + "+(char)34+" + linea[i] + "+(char)34+"+ " " ;
                } else {
                    //parametrosParcial=parametrosParcial+ch(linea[i]+"=")+"+ch("+linea[i]+")";
                    parametrosParcial = parametrosParcial + (char) 34 + " "+linea[i] + "=" + (char) 34 + "+(char)34+" + linea[i] + "+(char)34";
                }

            }
            
            parametrosParcial=parametrosParcial.trim();
            //salida = salida + "\r\n";

            y = y + 21;
            alto = alto + 21;
            }
//        }
       
return (salida);
    }

    public String generarMetodoDeLectura() {
        String salida = "\r\n";

        salida = salida + "      btnprocesar.addActionListener(new ActionListener() {\r\n";
        salida = salida + "         @Override\r\n";
        salida = salida + "         public void actionPerformed(ActionEvent e) {\r\n";
        salida = salida + codigoParaLeer;
        //salida=salida+"                String txthost_value=txthost.getText();                \r\n";
        //salida=salida+"                JOptionPane.showMessageDialog(null, "+(char)34+"Datos son:"+(char)34+"+txthost_value);\r\n";
        salida = salida + "\r\n" + parametrosGlobal + "\r\n";
        
        salida=salida+"            crearArchivo("+(char)34+"parametros.xml"+(char)34+",xml);\r\n";

        salida = salida + "         }\r\n";
        salida = salida + "\r\n";

        salida = salida + "      });\r\n";

        //System.out.println(salida);

        return (salida);
    }

   public String getMetodoCrearArchivo(){
     String salida="";
     salida=salida+"    public static void crearArchivo(String nombre,String cadena){\r\n";
     salida=salida+"       try{\r\n";
     salida=salida+"          BufferedWriter bw = new BufferedWriter(new FileWriter(nombre));\r\n";
     salida=salida+"          \r\n";
     salida=salida+"          bw.write(cadena);\r\n";
     salida=salida+"          bw.close();\r\n";
     //salida=salida+"          //bw.write("+(char)34+"\r\n"+(char)34+");              \r\n";
     salida=salida+"       }catch(Exception e){\r\n";
     salida=salida+"          System.out.println("+(char)34+"Ha ocurrido un error al intentar escribir el archivo "+(char)34+"+nombre);\r\n";
     salida=salida+"       }   \r\n";
     salida=salida+"    }\r\n";
     return(salida);
     //System.out.println(salida);   
   }
   
   public String getMetodoLeerXML(){
      String salida="";
      salida=salida+"    public void leerXML(){    \r\n";
      salida=salida+"       Document dom;       \r\n";
      salida=salida+"       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();\r\n";
      salida=salida+"       try {\r\n";
      salida=salida+"          //Using factory get an instance of document builder\r\n";
      salida=salida+"          DocumentBuilder db = dbf.newDocumentBuilder();          \r\n";
      salida=salida+"          dom = db.parse("+(char)34+"parametros.xml"+(char)34+");\r\n";
      salida=salida+"                    \r\n";
      salida=salida+"          Element docEle = dom.getDocumentElement();                   \r\n";
      salida=salida+"           \r\n";
      salida=salida+"          NodeList nl1 = docEle.getElementsByTagName("+(char)34+"parametro"+(char)34+");\r\n";
      salida=salida+"          Node node = nl1.item(0);\r\n";
      salida=salida+"          Element ele = (Element)node;\r\n";
      salida=salida+"\r\n";
      
      //salida=salida+"          String database = ele.getAttribute("+(char)34+"database"+(char)34+");\r\n";
      salida=salida+variablesDeArchivo+"\r\n";
      salida=salida+codigoParaSetear;
      salida=salida+"          \r\n";
      salida=salida+"       }catch(Exception e ){\r\n";
      salida=salida+"           System.out.println("+(char)34+"Error al parsear"+(char)34+");\r\n";
      salida=salida+"       }       \r\n";
      salida=salida+"    }\r\n";

       return(salida);
   }
   
   
    public void crearArchivo(String nombre, String cadena) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombre));

            bw.write(cadena);
            bw.close();
            //bw.write("\r\n");              
        } catch (IOException e) {
            System.out.println("Error al generar archivo");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        generador g = new generador();
        /*g.generarClase("lblPara:Parámetros de Bases de Datos,Host,Database,Port,carpeta,url\nc"
                + "lblPara1:Parámetros de servidor,primero,segundo,tercero,cuarto,quinto\nc"
                + "lblPara2:Parámetros extras,prim,sego,tero,cuar,quint");*/

        g.generarClase("lblPara:Parámetros de Bases de Datos,Host,Database,Puerto\nc"
                + "lblPara1:Parámetros de servidor,Host1,Port2,Database1\nc"  
        +"cbPara2:Opciones de guardado,nuevo\nc" 
        +"taPara3:Datos,nuevo2\nc"
        +"arPara6:Archivos nuevos,hola");


        //System.out.println(System.getProperty("user.dir"));
        //System.out.println(Paths.get("").toAbsolutePath().toString());

        try {
            //TimeUnit.MINUTES.sleep(1);

            //JOptionPane.showMessageDialog(null,"Proceso finalizado!");
            interfaz f = new interfaz();
            //g.mostrarVentanao();

        } catch (Exception e) {
            System.out.println("Error al generar pausa");
        }
        //interfaz i=new interfaz();

    }
}