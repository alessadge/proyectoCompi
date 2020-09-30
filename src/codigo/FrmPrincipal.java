/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dialog.ModalityType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Charly Ponce
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        jpanel2.setVisible(false);
    }
    
    public int corregirLinea(int x){
        int count = 0;
        String temp = ""+x;
        for(int i = 0; i < temp.length();i++){
            count++;
        }
        switch (count) {
            case 1:
                return x;
            case 2:
                return Integer.parseInt(temp.substring(0,1));
            case 3:
                return Integer.parseInt(temp.substring(0,2));
            default:
                return x;
        }

    }
    private void analizarLexico() throws IOException {
        int cont = 1;

        String expr = (String) txtResultado.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                txtAnalizarLex.setText(resultado);
                return;
            }
            switch (token) {
                case Linea:
                    cont++;
                    resultado += "LINEA " + cont + "\n";
                    break;
                case Comillas:
                    resultado += "  <Comillas>\t\t" + lexer.lexeme + "\n";
                    break;
                case CADENA:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    break;
                case TypeInt:
                    resultado += "  <Tipo de dato Int>\t" + lexer.lexeme + "\n";
                    break;
                case TypeFloat:
                    resultado += "  <Tipo de dato Float>\t" + lexer.lexeme + "\n";
                    break;
                case TypeString:
                    resultado += "  <Tipo de dato Cadena>\t" + lexer.lexeme + "\n";
                    break;
                case TypeList:
                    resultado += "  <Tipo de dato Lista>\t" + lexer.lexeme + "\n";
                    break;
                case TypeMatriz:
                    resultado += "  <Tipo de dato Matriz>\t" + lexer.lexeme + "\n";
                    break;
                case TypeBool:
                    resultado += "  <Tipo de dato Bool>\t" + lexer.lexeme + "\n";
                    break;
                case If:
                    resultado += "  <Reservada if>\t" + lexer.lexeme + "\n";
                    break;
                case EndIf:
                    resultado += "  <Reservada end if>\t" + lexer.lexeme + "\n";
                    break;
                case ElseIf:
                    resultado += "  <Reservada else if>\t" + lexer.lexeme + "\n";
                    break;
                case EndElseIf:
                    resultado += "  <Reservada end else if>\t" + lexer.lexeme + "\n";
                    break;
                case Else:
                    resultado += "  <Reservada else>\t" + lexer.lexeme + "\n";
                    break;
                case Then:
                    resultado += "  <Reservada then>\t" + lexer.lexeme + "\n";
                    break;
                case In:
                    resultado += "  <Reservada in>\t" + lexer.lexeme + "\n";
                    break;
                case Range:
                    resultado += "  <Reservada range>\t" + lexer.lexeme + "\n";
                    break;
                case EndElse:
                    resultado += "  <Reservada end else>\t" + lexer.lexeme + "\n";
                    break;
                case Do:
                    resultado += "  <Reservada do>\t" + lexer.lexeme + "\n";
                    break;
                case EndFor:
                    resultado += "  <Reservada end for>\t" + lexer.lexeme + "\n";
                    break;
                case Repeat:
                    resultado += "  <Reservada repeat>\t" + lexer.lexeme + "\n";
                    break;
                case EndWhile:
                    resultado += "  <Reservada end while>\t" + lexer.lexeme + "\n";
                    break;
                case OP_BOOL:
                    resultado += "  <Operadores Booleanos>\t" + lexer.lexeme + "\n";
                    break;
                case OP_RELA:
                    resultado += "  <Operadores Relacionales>\t" + lexer.lexeme + "\n";
                    break;
                case While:
                    resultado += "  <Reservada while>\t" + lexer.lexeme + "\n";
                    break;
                case For:
                    resultado += "  <Reservada For>\t" + lexer.lexeme + "\n";
                    break;
                case OP_ASIG:
                    resultado += "  <Operador asignacion>\t" + lexer.lexeme + "\n";
                    break;
                case OP_SUMA:
                    resultado += "  <Operador suma>\t" + lexer.lexeme + "\n";
                    break;
                case OP_MULT:
                    resultado += "  <Operador multiplicacion>\t" + lexer.lexeme + "\n";
                    break;
                case OP_DIV:
                    resultado += "  <Operador division>\t" + lexer.lexeme + "\n";
                    break;
                case OP_LOGIC:
                    resultado += "  <Operador logico>\t" + lexer.lexeme + "\n";
                    break;
                case Op_incremento:
                    resultado += "  <Operador incremento>\t" + lexer.lexeme + "\n";
                    break;
                case Case:
                    resultado += "  <Case switch>\t" + lexer.lexeme + "\n";
                    break;
                case Of:
                    resultado += "  <Reservada Of>\t" + lexer.lexeme + "\n";
                    break;
                case Default:
                    resultado += "  <Reservada Default>\t" + lexer.lexeme + "\n";
                    break;
                case EndCase:
                    resultado += "  <Reservada end case>\t" + lexer.lexeme + "\n";
                    break;
                case Begin:
                    resultado += "  <Reservada begin>\t" + lexer.lexeme + "\n";
                    break;
                case ImpLn:
                    resultado += "  <Reservada Println>\t" + lexer.lexeme + "\n";
                    break;
                case Imp:
                    resultado += "  <Reservada Print>\t" + lexer.lexeme + "\n";
                    break;
                case Call:
                    resultado += "  <Reservada call>\t" + lexer.lexeme + "\n";
                    break;
                case EndCall:
                    resultado += "  <Reservada end call>\t" + lexer.lexeme + "\n";
                    break;
                case EndMain:
                    resultado += "  <Reservada end main>\t" + lexer.lexeme + "\n";
                    break;
                case Put:
                    resultado += "  <Reservada Put>\t" + lexer.lexeme + "\n";
                    break;
                case Get:
                    resultado += "  <Reservada Get>\t" + lexer.lexeme + "\n";
                    break;
                case DosPuntos:
                    resultado += "  <Dos puntos>\t" + lexer.lexeme + "\n";
                    break;
                case PuntoComa:
                    resultado += "  <Punto y >\t" + lexer.lexeme + "\n";
                    break;
                case Punto:
                    resultado += "  <Punto>\t" + lexer.lexeme + "\n";
                    break;
                case Coma:
                    resultado += "  <Coma>\t" + lexer.lexeme + "\n";
                    break;
                case GuionBajo:
                    resultado += "  <Guion Bajo>\t" + lexer.lexeme + "\n";
                    break;
                case Ampersand:
                    resultado += "  <Ampersand>\t" + lexer.lexeme + "\n";
                    break;
                case Apostrofe:
                    resultado += "  <Apostrofe>\t" + lexer.lexeme + "\n";
                    break;
                case Arroba:
                    resultado += "  <Arroba>\t" + lexer.lexeme + "\n";
                    break;
                case Numeral:
                    resultado += "  <Numeral>\t" + lexer.lexeme + "\n";
                    break;
                case ParIzq:
                    resultado += "  <Parentesis de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case ParDer:
                    resultado += "  <Parentesis de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case SquareBIzq:
                    resultado += "  <Corchete de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case SquareBDer:
                    resultado += "  <Corchete de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case CurlyIzq:
                    resultado += "  <Llaves de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case CurlyDer:
                    resultado += "  <Llaves de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case special_characters:
                    resultado += "  <Caracteres especiales>\t" + lexer.lexeme + "\n";
                    break;
                case Op_atribucion:
                    resultado += "  <Operador de atribucion>\t" + lexer.lexeme + "\n";
                    break;
                case ENTERO:
                    resultado += "  <Entero>\t" + lexer.lexeme + "\n";
                    break;
                case DECIMAL:
                    resultado += "  <Decimal>\t" + lexer.lexeme + "\n";
                    break;
                case Main:
                    resultado += "  <Reservada main>\t" + lexer.lexeme + "\n";
                    break;
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexer.lexeme + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    break;
                case ERROR:
                    resultado += "  <Simbolo no definido>\n";
                    break;
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jpanel2 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtree = new javax.swing.JTree();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnWhile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        btnCase = new javax.swing.JButton();
        btnFunctions = new javax.swing.JButton();
        btnFor = new javax.swing.JButton();
        btnIf = new javax.swing.JButton();
        btnArbol = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        jLabel1.setText("ARBOL");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jtree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane4.setViewportView(jtree);

        jButton4.setText("Ver mi arbol");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanel2Layout = new javax.swing.GroupLayout(jpanel2.getContentPane());
        jpanel2.getContentPane().setLayout(jpanel2Layout);
        jpanel2Layout.setHorizontalGroup(
            jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel2Layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(64, 64, 64))
            .addGroup(jpanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jpanel2Layout.setVerticalGroup(
            jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnWhile.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        btnWhile.setText("While");
        btnWhile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWhileActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        txtResultado.setText("main begin\n\t/^ INGRESE\n\tSU\n\tCODIGO^/\nend main\n\n");
        jScrollPane1.setViewportView(txtResultado);

        txtAnalizarLex.setEditable(false);
        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setRows(5);
        jScrollPane2.setViewportView(txtAnalizarLex);

        btnCase.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        btnCase.setText("Case");
        btnCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaseActionPerformed(evt);
            }
        });

        btnFunctions.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        btnFunctions.setText("Functions");
        btnFunctions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFunctionsActionPerformed(evt);
            }
        });

        btnFor.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        btnFor.setText("For");
        btnFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForActionPerformed(evt);
            }
        });

        btnIf.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        btnIf.setText("If");
        btnIf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIfActionPerformed(evt);
            }
        });

        btnArbol.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        btnArbol.setText("Ver arbol");
        btnArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArbolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnWhile, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFor)
                .addGap(18, 18, 18)
                .addComponent(btnIf)
                .addGap(18, 18, 18)
                .addComponent(btnCase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnFunctions)
                        .addGap(63, 63, 63)
                        .addComponent(btnArbol)))
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(386, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFunctions)
                    .addComponent(btnCase)
                    .addComponent(btnWhile)
                    .addComponent(btnFor)
                    .addComponent(btnIf)
                    .addComponent(btnArbol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 57, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Debugging...", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        txtAnalizarSin.setEditable(false);
        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setRows(5);
        txtAnalizarSin.setText("/^ERRORES^/");
        jScrollPane3.setViewportView(txtAnalizarSin);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Abrir Archivo...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Limpiar...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ejecutar");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Compilar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Arbol");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Mostrar...");
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnWhileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWhileActionPerformed
        // TODO add your handling code here:
        String codigo = "main begin \n"+ "while true repeat \n" + "\t n=>5;\n" + "end while\n"+"end main\n";
        txtResultado.setText(codigo);
        
    }//GEN-LAST:event_btnWhileActionPerformed

    private void btnCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaseActionPerformed
        // TODO add your handling code here:
        String codigo = "main begin \n"+ "Int a=>3;\n" + "if a=3 then \n" + "for Int i=>0 in range (i<a)\n" + "\t Print(\"hola\");\n"
                        +"end for\n" + "end if\n" + "while true repeat \n" + "\t a=>10; \n" + "end while \n" + "case(a) of \n"
                        + "\t 1:Println(\"hola\"); \n" + "\t 2:Println(\"adios\");\n" + "\t default:Println(\"nunca\"); \n"
                        + "end case\n" + "end main";
        txtResultado.setText(codigo);
    }//GEN-LAST:event_btnCaseActionPerformed

    private void btnFunctionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFunctionsActionPerformed
        // TODO add your handling code here:
        String codigo = "main begin \n"+ "Int a=>3;\n" + "if a=3 then \n" + "for Int i=>0 in range (i<a)\n" + "\t Print(\"hola\");\n"
                        +"end for\n" + "end if\n" + "while true repeat \n" + "\t a=>10; \n" + "end while \n" + "case(a) of \n"
                        + "\t 1:Println(\"hola\"); \n" + "\t 2:Println(\"adios\");\n" + "\t default:Println(\"nunca\"); \n"
                        + "end case\n" + "end main\n\n"+"Int begin metodoRecursivo(Int numero)\n"+ "numero=>resultado;\n"
                        +"if n=1 then\n"+"\t return1;\n"+"end if\n"+"else then\n"+"\t resultado => metodoRecursivo(numero-1)*numero;\n"
                        +"\t\t return resultado;\n"+"end else\n"+"end call\n\n"+"call begin imprimirHola()\n"  
                        + "\t Println(\"Hola\");\n end call";
        txtResultado.setText(codigo);
    }//GEN-LAST:event_btnFunctionsActionPerformed

    private void btnForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForActionPerformed
        String codigo = "main begin \n"+ "for Int i=>0 in range (i<a) \n" + "\t a=>5;\n" + "end for\n"+"end main\n";
        txtResultado.setText(codigo);
    }//GEN-LAST:event_btnForActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());

        try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtResultado.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        txtAnalizarLex.setText(null);
        txtAnalizarSin.setText(null);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       // TODO add your handling code here:
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(Sintax.Errores.size());
        String ST = txtResultado.getText();
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        String temporal = "------Errores Sintacticos------\n";
        try {
            s.parse();
        } catch (Exception ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (Sintax.Errores.isEmpty() && Lexer.ErroresLexicos.isEmpty()) {
            try {
                root = s.raiz;
                txtAnalizarSin.setText("Analisis realizado correctamente");
                txtAnalizarSin.setForeground(new Color(25, 111, 61));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                Symbol sym = s.getS();
                temporal = temporal + Sintax.Errores;
                temporal = temporal + "------Errores Lexicos------\n";
                //temporal = temporal + "Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"";
                temporal = temporal + Lexer.ErroresLexicos + "\n";
                txtAnalizarSin.setText(temporal);
                temporal = "";
                Sintax.Errores.clear();
                Lexer.ErroresLexicos.clear();
                txtAnalizarSin.setForeground(Color.red);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } 
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btnIfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIfActionPerformed
        // TODO add your handling code here:
        String codigo = "main begin \n"+ "if x = 2 then \n" + "\t n=>1;\n" + "end if\n"+"else if x=3 then \n"+"\t n=>2; \n"+"end else if\n"+"end main";
        txtResultado.setText(codigo);
    }//GEN-LAST:event_btnIfActionPerformed

    private void btnArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArbolActionPerformed
        try {
           jpanel2.setModal(true);
            jpanel2.pack();
            jpanel2.setLocationRelativeTo(this);
            jpanel2.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnArbolActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            arbol = new DefaultMutableTreeNode(root);
            DefaultTreeModel modelo = (DefaultTreeModel)jtree.getModel();
            llenar(root, arbol);
            modelo.setRoot(arbol);
            jtree.setModel(modelo);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton4ActionPerformed
        public static void llenar(Node root, DefaultMutableTreeNode current){
        for (int i = 0; i < root.hijos.size(); i++) {
            current.add(new DefaultMutableTreeNode(root.hijos.get(i)));
            if(!root.hijos.get(i).hijos.isEmpty()){
                llenar(root.hijos.get(i), (DefaultMutableTreeNode)current.getChildAt(i));
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArbol;
    private javax.swing.JButton btnCase;
    private javax.swing.JButton btnFor;
    private javax.swing.JButton btnFunctions;
    private javax.swing.JButton btnIf;
    private javax.swing.JButton btnWhile;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JDialog jpanel2;
    private javax.swing.JTree jtree;
    private javax.swing.JTextArea txtAnalizarLex;
    private javax.swing.JTextArea txtAnalizarSin;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
    public static Node root;
    DefaultMutableTreeNode arbol;
}
