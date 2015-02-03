/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumnModel;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.jdom.JDOMXPath;
import org.jdom.DataConversionException;
import org.jdom.Element;

/**
 *
 * @author javierms
 */
public final class ObjectGridWizard4 extends javax.swing.JFrame {

    /**
     * Creates new form ObjectGridWizard4
     */
    
    Element diagram;
    String association;
    Integer colCountTable;
    Integer rowCountTable;
    
    
    JTextField rowCount;
    JTextField colCount;
    
    JComboBox assoCombo;
    JLabel assLab;
    
    JLabel rowCountLab;
    JLabel colCountLab;
    
    JScrollPane paneContent;
    JTable table;
    
    JButton generateB;
    JButton okB;
    JButton CancelB;
    
    
    //Containers:
    Container pane, cp1, cp2, cp3;
    JPanel p,p1,p2, pBottom;
    
    TableCellEditor editors[][];
    JComboBox comboxes [][], combox;
    
    public ObjectGridWizard4() {
        initComponents();
    }
    
    public ObjectGridWizard4(Element one_diagram){
    
       ini(one_diagram);
        
 }
    
    public void ini(Element one_diagram){
    
        diagram = one_diagram;
        colCountTable = 0; 
        rowCountTable = 0;
        
        setTitle("Create Grid of Objects");
        
        rowCount = new JTextField(3);
        rowCount.setEnabled(false);
        rowCount.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                    colCount.setEnabled(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Only numbers are allowed!");
                    rowCount.setText(" ");
                    colCount.setEnabled(false);
                }
            }
        }); 
        
        colCount = new JTextField(3);
        colCount.setEnabled(false);                
        colCount.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                    generateB.setEnabled(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Only numbers are allowed!");
                    colCount.setText(" ");
                    generateB.setEnabled(false);
                }
            }
         });
        rowCountLab = new JLabel("Rows:");

        colCountLab = new JLabel("Columns:");
        

        generateB = new JButton("Generate");
        generateB.setPreferredSize(new Dimension(90, 30));
        generateB.setEnabled(false);
        generateB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
         
                //ArrayList<Object> objects = new ArrayList<Object>();
    
                rowCountTable = Integer.parseInt(rowCount.getText());
                colCountTable = Integer.parseInt(colCount.getText());
                
                editors = new TableCellEditor[rowCountTable][colCountTable];
                
                
                showTable();
                fillComboTable();
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setSize(495, 535);
                setVisible(true);
            }
        });
        
        assoCombo = new JComboBox(); 
        assoCombo.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                association = (String)e.getItem();
                if(!"...shoose an association...".equals(association)){
                    rowCount.setEnabled(true);
                    rowCount.requestFocus();
                    if(table != null){
                        fillComboTable();
                    generateB.setEnabled(true);
                    }
                }
                else
                    rowCount.setEnabled(false);
            }
        });
        
        ArrayList<Object> associations = getAssociations();
       
        assoCombo.removeAllItems();
        assoCombo.addItem("...shoose an association...");
        for(int i = 0; i < associations.size(); i++){
            assoCombo.addItem(associations.get(i).toString());
        }
      
        
        
        assLab = new JLabel("Associations:");
           
        okB = new JButton("Ok");
        okB.setPreferredSize(new Dimension(80, 30));
        okB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // get label of selected radiobutton
               setTitle("Ok");
            }
        });
               
    
        CancelB = new JButton("Close");
        CancelB.setPreferredSize(new Dimension(80, 30));
        CancelB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                dispose();
               // new ObjectGridWizard4(diagram).setVisible(true);
        
            }
        });
        
        pane = this.getContentPane(); //captura o painel do JFrame
        pane.setLayout(new FlowLayout(FlowLayout.LEFT)); //define o layout

        p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.LEFT));
        p.add(assLab);
        p.add(assoCombo);
       
        
        p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        p1.add(rowCountLab);
        p1.add(rowCount);
        p1.add(colCountLab);
        p1.add(colCount);
        p1.add(generateB);
       
        cp1 = new Container();
        cp1.setLayout(new GridLayout(2, 1));
        cp1.add(p);
        cp1.add(p1);
/*
        cp2 = new Container();
        cp2.setLayout(new FlowLayout(FlowLayout.LEFT));
        cp2.add(paneContent, BorderLayout.CENTER);
               
        pBottom = new JPanel();
        pBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pBottom.add(okB);
        pBottom.add(CancelB);
        
        cp3 = new Container();
        cp3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        cp3.add(pBottom, BorderLayout.CENTER);
 */
        pane.add(cp1);
        //pane.add(cp2);
       // pane.add(cp3, BorderLayout.CENTER);
        

       
        

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(495, 120);
        this.setVisible(true);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height);
        
       

        
    
    }
    
    private void clearAllElements(){
        assoCombo.removeAllItems();
        colCount.setText("");
        rowCount.setText("");
    
    }
    private void fillComboTable(){
        
        ArrayList<Object> objects = new ArrayList<Object>();
        objects = getObjects_of_Association(assoCombo.getSelectedItem().toString());
        combox.removeAllItems();
                
                //Deleting repeat elements
       HashSet<Object> listToSet = new HashSet<Object>(objects);
       ArrayList<Object> listWithoutDuplicates = new ArrayList<Object>(listToSet);
                
       for(int i = 0; i < listWithoutDuplicates.size(); i++){
           ArrayList<Object> objects_class = new ArrayList<Object>();
           objects_class = getObjectsClass(listWithoutDuplicates.get(i).toString());
           if(!objects_class.isEmpty()){
               combox.addItem("Class: " + getNameClass(listWithoutDuplicates.get(i).toString()));
               for(int j = 0; j < objects_class.size(); j++){
                   combox.addItem("      " + objects_class.get(j));                             
                }
            }
        }
        DefaultCellEditor e1 = new DefaultCellEditor(combox);
        table.setDefaultEditor(Object.class, e1);
    
    
    }
    private void showTable(){
        
        JTable temp = fillTable();
        
        if(table == null){
            table = new JTable(temp.getModel());
           /* TableColumnModel tcm = table.getColumnModel();
                      
                //paneContent.setViewportView(table);
                
            for(int i = 0; i < tcm.getColumnCount(); i++){
                tcm.getColumn(i).setPreferredWidth(150);
            }
        
       table.setRowHeight(30);
             */    
      
                
       paneContent = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       
       table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
       
       paneContent.setPreferredSize(new Dimension(470, 350));
       cp2 = new Container();
       cp2.setLayout(new FlowLayout(FlowLayout.LEFT));
       cp2.add(paneContent, BorderLayout.CENTER);
               
       pBottom = new JPanel();
       pBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
       pBottom.add(okB);
       pBottom.add(CancelB);
        
       cp3 = new Container();
       cp3.setLayout(new FlowLayout(FlowLayout.RIGHT));
       cp3.add(pBottom, BorderLayout.CENTER);
        
       pane.add(cp2);
       pane.add(cp3, BorderLayout.CENTER);
        }
        
        else{
            table.setModel(temp.getModel());
            
        }
           
       TableColumnModel tcm = table.getColumnModel();
                      
       for(int i = 0; i < tcm.getColumnCount(); i++){
          tcm.getColumn(i).setPreferredWidth(140);
      }
      table.setRowHeight(30);
            
      generateB.setEnabled(false);
    }
    
    private JTable fillTable1(){
    
        int row_Count = 5, col_Count = 5;
         final TableCellEditor editors[][] = new TableCellEditor[row_Count][col_Count];
        
        String colNames[] = new String[col_Count];
        colNames[0] = "Objects:";
        
        for(int i = 1; i < col_Count; i ++){
            colNames[i] = "Objects";
        }
        
        Object [][] data = new Object[row_Count][col_Count];
        DefaultTableModel model = new DefaultTableModel(data, colNames);
  
        JTable table = new JTable(model);
        return table;
    }    
    private JTable fillTable(){
              
        Map<Object, ArrayList> mp = new HashMap<Object, ArrayList>();
        ArrayList <String> values = new ArrayList<String>();
        String colNames[] = new String[colCountTable];
       
            
        mp = getObjects();
        
        comboxes = new JComboBox[rowCountTable][colCountTable];
        combox = new JComboBox();
        
        Object idAss = getIdClass(association.toString());
        
       
        //Inicialite of columns header name:
        for(int i = 0; i < colCountTable; i ++){
            colNames[i] = "Object:";
        }
    
        Object [][] data = new Object[rowCountTable][colCountTable];
       
        DefaultTableModel model = new DefaultTableModel(data, colNames);
  
        JTable table = new JTable(model);       
        
         /*       
        TableColumnModel tcm = table.getColumnModel();
        
        tcm.getColumn(0).setPreferredWidth(100);
        
        for(int i = 1; i < model.getColumnCount(); i++){
            tcm.getColumn(i).setPreferredWidth(200);
        }
        
        table.setRowHeight(30);
        
        table.setPreferredScrollableViewportSize(new Dimension(500, 500));
        */
        return table;
        
   };
    
     public ArrayList<Object> getNameAssociations(String classe){
     
        ArrayList<Object> name_associations = new ArrayList<Object>();
        List<?> result = null;
        List<?> list_asso_end = null;

        try {
            XPath path = new JDOMXPath("project/elements/classAssociations/classAssociation");
            result = path.selectNodes(diagram.getDocument());
	} catch (JaxenException e2) {			
        }
        
        for(int i = 0; i < result.size(); i++){ 
            Element association = (Element)result.get(i);     
            Element ass_ends = association.getChild("associationEnds");
            String name = association.getChildText("name");
            list_asso_end = ass_ends.getChildren("associationEnd");   
            String second_ass = ((Element)list_asso_end.get(1)).getAttributeValue("element-id");             
            //First store a association name
            if(second_ass.equals(classe)){
                name_associations.add(name);                
            }
            }
        return name_associations;
        }
     
      public ArrayList<Object> getObjects_of_Association(String name_association){
      
        ArrayList<Object> objects = new ArrayList<Object>();
        List<?> result = null;
        List<?> list_asso_end = null;

        try {
            XPath path = new JDOMXPath("project/elements/classAssociations/classAssociation");
            result = path.selectNodes(diagram.getDocument());
	} catch (JaxenException e2) {			
        }
        
        for(int i = 0; i < result.size(); i++){ 
            Element associat = (Element)result.get(i);  
            String name = associat.getChild("name").getText();
            if(name.equals(name_association)){
                Element ass_ends = associat.getChild("associationEnds");
                list_asso_end = ass_ends.getChildren("associationEnd");
                String firs_obj = ((Element)list_asso_end.get(0)).getAttributeValue("element-id");
                String second_obj = ((Element)list_asso_end.get(1)).getAttributeValue("element-id");
            
                objects.add(firs_obj);
                if(!second_obj.equals(firs_obj))
                    objects.add(second_obj);
                
            }
            
            /*Element ass_ends = associat.getChild("associationEnds");
            String name = associat.getChildText("name");
            list_asso_end = ass_ends.getChildren("associationEnd");   
            String second_ass = ((Element)list_asso_end.get(1)).getAttributeValue("element-id");             
            //First store a association name
            if(second_ass.equals(classe)){
                name_associations.add(name);                
            }*/
            }
        return objects;
        };
          
          
      
     
      public ArrayList<Object> getObjectsClass(String id_classe){
        List<?> result, result1, result2, result3= null;
        String classe = null;
        Object[] objects = null;
        ArrayList<Object> objs = new ArrayList<Object>();
        
	try {
          
            Integer id = null;
            Element domain = diagram.getParentElement().getParentElement();
            try {
                id = domain.getAttribute("id").getIntValue();
            } catch (DataConversionException ex) {
                Logger.getLogger(ObjectGridWizard.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            XPath path = new JDOMXPath("project/diagrams/planningDomains/domain[@id="+id+"]");
            result1 = path.selectNodes(diagram.getDocument());
            
            Element object1  = (Element)(result1.get(0));
            
            result = object1.getChildren("elements");
            
            Element object2 = (Element)result.get(0);
            
            result2 = object2.getChildren("objects");
            
            Element object3 = (Element)result2.get(0);
            
            result3 = object3.getChildren("object");
                   //
        } 
        catch (JaxenException e2) {			
            }
                
       	for (int i = 0; i < result3.size(); i++){
            Element object = (Element)result3.get(i);
            classe = (object.getChildText("class"));
            if(classe.equals(id_classe))
                objs.add(object.getChildText("name"));
        }
        return objs;   
    }
    
 private Map<Object, ArrayList>  getObjects(){
    
        ArrayList<String> objects = null;
        List<?> result, result1, result2, result3= null;
 
        //To save an object and its class associations
        Map<Object, ArrayList> mp=new HashMap<Object, ArrayList>();
                              
        if(diagram!= null){
            try{
                Integer id = null;
                Element domain = diagram.getParentElement().getParentElement();
                try {
                    id = domain.getAttribute("id").getIntValue();
                    } 
                catch (DataConversionException ex) {
                    Logger.getLogger(ObjectGridWizard.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
                XPath path = new JDOMXPath("project/diagrams/planningDomains/domain[@id="+id+"]");
                result1 = path.selectNodes(diagram.getDocument());
            
                Element object1  = (Element)result1.get(0);
            
                result = object1.getChildren("elements");
            
                Element object2 = (Element)result.get(0);
            
                result2 = object2.getChildren("objects");
            
                Element object3 = (Element)result2.get(0);
            
                result3 = object3.getChildren("object");
                   //
            } 
            catch (JaxenException e2) {			
                e2.printStackTrace();
            }
            for (int i = 0; i < result3.size(); i++){
                Element object  = (Element)result3.get(i);
                ArrayList <Object> associations = getAssociations(object.getChildText("class").toString());
                
                if(associations.size() != 0)
                    mp.put(object.getChildText("name"), associations);//object.getChildText("class"));
               }
       }
      return mp;
    }

 public ArrayList<Object> getAssociations(String classe){

        ArrayList<Object> associations = new ArrayList<Object>();
        List<?> result = null;
        List<?> list_asso_end = null;

        try {
            XPath path = new JDOMXPath("project/elements/classAssociations/classAssociation");
            result = path.selectNodes(diagram.getDocument());
	} catch (JaxenException e2) {			
	e2.printStackTrace();
        }
        
        for(int i = 0; i < result.size(); i++){ 
            Element association = (Element)result.get(i);     
            Element ass_ends = association.getChild("associationEnds");             
            list_asso_end = ass_ends.getChildren("associationEnd");   
            String first_ass = ((Element)list_asso_end.get(0)).getAttributeValue("element-id");             
            //First store a association name
            if(first_ass.equals(classe)){
                for(int k = 1; k< list_asso_end.size(); k++){
                    Element b = (Element)list_asso_end.get(k);
                    String c = b.getAttributeValue("element-id");
                    associations.add(c);
                }
             }
        }        
        return associations;
    }
    public ArrayList<Object> getAssociations(){
    
        ArrayList<Object> name_associations = new ArrayList<Object>();
        
        List<?> result = null;
        List<?> list_asso_end = null;

        try {
            XPath path = new JDOMXPath("project/elements/classAssociations/classAssociation");
            result = path.selectNodes(diagram.getDocument());
	} catch (JaxenException e2) {			
	e2.printStackTrace();
        }
        for(int i = 0; i < result.size(); i++){ 
            Element association = (Element)result.get(i);     
            Element name = association.getChild("name");
            name_associations.add(name.getValue());
        }    
        return name_associations;
       
    }
    
    public Object getIdClass(String classe){
    
        ArrayList<Object> associations = new ArrayList<Object>();
        List<?> result = null;
        List<?> list_asso_end = null;

        try {
            XPath path = new JDOMXPath("project/elements/classAssociations/classAssociation");
            result = path.selectNodes(diagram.getDocument());
	} catch (JaxenException e2) {			
	e2.printStackTrace();
        }
        for(int i = 0; i < result.size(); i++){ 
            Element association = (Element)result.get(i);            
            if(association.getChild("name").getValue().toString().equals(classe)){
                return association.getAttribute("id").getValue();
            }
        }
        return null;
    }
    
    public Object getNameClass(String id){
    
        ArrayList<Object> associations = new ArrayList<Object>();
        List<?> result = null;
        List<?> list_asso_end = null;

        try {
            XPath path = new JDOMXPath("project/elements/classes/class");
            result = path.selectNodes(diagram.getDocument());
	} catch (JaxenException e2) {			
	e2.printStackTrace();
        }
        for(int i = 0; i < result.size(); i++){ 
            Element association = (Element)result.get(i); 
            String temp = association.getAttribute("id").getValue().toString();
            if(temp.equals(id)){
                return association.getChild("name").getValue().toString();
            }
        }
        return null;
    }
    
    public int row_count( Map<Object, ArrayList> mp){
        int k = 0;
        ArrayList <String> values;
             
        Set s = mp.entrySet();
        Iterator it=s.iterator();
        
        while(it.hasNext()){
            Map.Entry m =(Map.Entry)it.next();
            values = (ArrayList <String>) m.getValue();
            if(!values.isEmpty())
                k++;
        }
 
        return k;
    }
    
    public int col_count(Map<Object, ArrayList> mp){
    
        int major = 0;
      
        Set s = mp.entrySet();
        Iterator it = s.iterator();

        while(it.hasNext()){
            Map.Entry m = (Map.Entry)it.next();
            ArrayList associations = (ArrayList)m.getValue();
            if(associations.size() > major)
                major = associations.size();           
        }
        return major;
    }

    public void setObjectDiagram(Element one_objectDiagram){
    
        diagram = one_objectDiagram;
        ini(diagram);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ObjectGridWizard4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ObjectGridWizard4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ObjectGridWizard4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ObjectGridWizard4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ObjectGridWizard4().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
