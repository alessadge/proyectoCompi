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
import java.util.ArrayList;
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

    public int corregirLinea(int x) {
        int count = 0;
        String temp = "" + x;
        for (int i = 0; i < temp.length(); i++) {
            count++;
        }
        switch (count) {
            case 1:
                return x;
            case 2:
                return Integer.parseInt(temp.substring(0, 1));
            case 3:
                return Integer.parseInt(temp.substring(0, 2));
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
        btnIf1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        btnArbol = new javax.swing.JButton();
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
        btnWhile.setText("Error Case");
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
        btnFunctions.setText("Lista");
        btnFunctions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFunctionsActionPerformed(evt);
            }
        });

        btnFor.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        btnFor.setText("Error Matriz");
        btnFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForActionPerformed(evt);
            }
        });

        btnIf.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        btnIf.setText("Error Lista");
        btnIf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIfActionPerformed(evt);
            }
        });

        btnIf1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        btnIf1.setText("Matriz");
        btnIf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIf1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnWhile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIf))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCase)
                        .addGap(27, 27, 27)
                        .addComponent(btnIf1)
                        .addGap(26, 26, 26)
                        .addComponent(btnFunctions))
                    .addComponent(jScrollPane2))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFunctions)
                    .addComponent(btnIf1)
                    .addComponent(btnCase)
                    .addComponent(btnIf)
                    .addComponent(btnFor)
                    .addComponent(btnWhile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Errores...", 2, 0, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        txtAnalizarSin.setEditable(false);
        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setRows(5);
        txtAnalizarSin.setText("/^ERRORES^/");
        jScrollPane3.setViewportView(txtAnalizarSin);

        btnArbol.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        btnArbol.setText("Ver arbol");
        btnArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArbolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(btnArbol)
                .addContainerGap(286, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(btnArbol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        String codigo = "main begin \n" + "Int a=>3;\n" + "if a=3 then \n" + "for Int i=> in range (i<a)\n" + "\tPrint(\"hola\");ª\n"
                + "end for\n" + "end if\n" + "while true  º\n" + "\t a=>10; ç \n" + "end while \n" + "case(a) of \n"
                + "\t 1:Println(\"hola\"); \n" + "\t 2:Println(\"adios\");\n" + "\t default:Println(\"nunca\"); \n"
                + "end case\n" + "end main";
        txtResultado.setText(codigo);

    }//GEN-LAST:event_btnWhileActionPerformed

    private void btnCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaseActionPerformed
        // TODO add your handling code here:
        String codigo = "main begin \n" + "Int suma=>3*2+6/4;\n" + "Int a=>3;\n" + "Matriz m(2)(2)=>{1,2}{3,4};\n" + "List lista(3)=>{1,2,3};\n" + "if a=3 then \n" + "for Int i=>0 in range (i<10)\n" + "\t Print(\"hola\");\n"
                + "end for\n" + "end if\n" + "while true repeat \n" + "\t a=>10; \n" + "end while \n" + "case(a) of \n"
                + "\t 1:Println(\"hola\"); \n" + "\t 2:Println(\"adios\");\n" + "\t default:Println(\"nunca\"); \n"
                + "end case\n" + "end main";
        txtResultado.setText(codigo);
    }//GEN-LAST:event_btnCaseActionPerformed

    private void btnFunctionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFunctionsActionPerformed
        // TODO add your handling code here:
        String codigo = "main begin \n" + "Int a=>3+2*7;\n" + "if a=3 then \n" + "\tfor Int i=>0 in range (i<a)\n" + "\t\t Print(\"hola\");\n"
                + "\tend for\n" + "end if\n" + "while true repeat \n" + "\t a=>10; \n" + "end while \n" + "case(a) of \n"
                + "\t 1:Println(\"hola\"); \n" + "\t 2:Println(\"adios\");\n" + "\t default:Println(\"nunca\"); \n"
                + "end case\n" + "end main\n\n" + "Int begin metodoRecursivo(Int numero)\n" + "numero=>resultado;\n"
                + "if n=1 then\n" + "\t return 1;\n" + "end if\n" + "else then\n" + "\t resultado => metodoRecursivo(numero-1)*numero;\n"
                + "\t\t return resultado;\n" + "end else\n" + "end call\n\n" + "call begin imprimirHola()\n"
                + "List lista(3)=>{1,2,3};\n\t for Int i=>0 in range(i<3) \n\t\t Print(i[i]); \n\tend for\nend call";
        txtResultado.setText(codigo);
    }//GEN-LAST:event_btnFunctionsActionPerformed

    private void btnForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForActionPerformed
        String codigo = " begin \n" + "String miNombre=>\"Franklin \";\n" + "Put miNombre;\n" + "Int a=>1-4*7*6;\n" + "case(a) of\n"
                + "\t1: Matriz m(2)(2)=>{1,2}{3,4};~\n" + "\tfor Int i=>0  range(i<2)\n" + "\t\tfor Int j=>0 in range(j<2) |\n"
                + "\t\t\tPrint(m[i][j]);°\n" + "\t\tend for\n\tend for\n" + "\t2: Println(\"Fin 2\");\n\t default: Println(\"Fin default\");\n"
                + "end case\nend main \n\n" + "Int begin (Int numero)\n" + "numero=>resultado;\nif n=1 then\n"
                + "\treturn 1;\n" + "end if\nelse then\n" + "\tresultado => metodoRecursivo(numero-1)*numero;\n"
                + "\treturn resultado;\n" + "end else\nend call\n";
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
        tabla_simbolos = new ArrayList<Entry>();
        ids = null;
        ids2 = null;
        tipos_matrix = null;
        Errores_tipos = new ArrayList<String>();
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
                try {
                    analizar();
                } catch (IOException ex) {
                    Errores_tipos.add("Error comprobando tipos");
                }

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
        if (!Errores_tipos.isEmpty()) {
            for (int i = 0; i < Errores_tipos.size(); i++) {
                System.out.println(Errores_tipos.get(i));
            }
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btnIfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIfActionPerformed
        // TODO add your handling code here:
        String codigo = "main begin \n" + "Int a=>3+2*7;\n" + "if a=3 then \n" + "\tfor Int i=>0 in  (i<a)\n" + "\t\t Print(\"hola\");\n"
                + "\tend for\n" + "end if\n" + "while true repeat \n" + "\t a=>10; \n" + "end while \n" + "case(a) of \n"
                + "\t 1:Println(\"hola\"); \n" + "\t 2:Println(\"adios\");|\n" + "\t default:Println(\"nunca\");° \n"
                + "end case\n" + "end main\n\n" + "Int begin metodoRecursivo(Int numero)\n" + "numero=>resultado; ~\n"
                + "if n=1 then\n" + "\t return 1;\n" + "end if\n" + "else then\n" + "\t resultado => metodoRecursivo(numero-1)*numero;\n"
                + "\t\t return resultado;\n" + "end else\n" + "end call\n\n" + "call  imprimirHola()\n"
                + "List lista(3)=>{1,2,3};\n\t for Int i=>0 in range(i<3) \n\t\t Print(i[i]); \n\tend for\nend call";
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
            DefaultTreeModel modelo = (DefaultTreeModel) jtree.getModel();
            llenar(root, arbol);
            modelo.setRoot(arbol);
            jtree.setModel(modelo);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnIf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIf1ActionPerformed
        String codigo = "main begin \n" + "String miNombre=>\"Franklin \";\n" + "Put miNombre;\n" + "Int a=>1-4*7*6;\n" + "case(a) of\n"
                + "\t1: Matriz m(2)(2)=>{1,2}{3,4};\n" + "\tfor Int i=>0 in range(i<2)\n" + "\t\tfor Int j=>0 in range(j<2) \n"
                + "\t\t\tPrint(m[i][j]);\n" + "\t\tend for\n\tend for\n" + "\t2: Println(\"Fin 2\");\n\t default: Println(\"Fin default\");\n"
                + "end case\nend main \n\n" + "Int begin metodoRecursivo(Int numero)\n Int resultado=>1+2*8;\n Int n=>1+2;\n" + "numero=>resultado;\nif n=1 then\n"
                + "\treturn 1;\n" + "end if\nelse then\n" +"\t numero=>numero-1;\n" +"\t resultado => metodoRecursivo(numero); \n \tresultado=>resultado*numero; \n  "
                + "\treturn resultado;\n" + "end else\nend call\n";
        txtResultado.setText(codigo);

    }//GEN-LAST:event_btnIf1ActionPerformed
    public static void llenar(Node root, DefaultMutableTreeNode current) {
        for (int i = 0; i < root.hijos.size(); i++) {
            current.add(new DefaultMutableTreeNode(root.hijos.get(i)));
            if (!root.hijos.get(i).hijos.isEmpty()) {
                try {
                    llenar(root.hijos.get(i), (DefaultMutableTreeNode) current.getChildAt(i));
                } catch (Exception e) {
                    Errores_tipos.add("Error en llenar tabla");
                }
            }
        }
    }

    public static void llenar_tabla(Node actual) {
//////////////////////////Comprobacion de tipos de for

        if (actual.nombre.equals("void")) {
            agregar(new Entry(actual.hijos.get(0).valor, "void", ""));
            if (actual.hijos.get(1).nombre.equals("parametro")) {
                adParametro(actual.hijos.get(1));
            }
        }
        if (actual.nombre.equals("metodo parametro")) {
            agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).hijos.get(0).nombre, ""));
            if (actual.hijos.get(2).nombre.equals("parametro")) {
                adParametro(actual.hijos.get(2));
            }
        }
        if (actual.nombre.equals("FOR")) {
            if (actual.hijos.get(0).valor.equals("Int") && actual.hijos.get(3).nombre.equals("Int")) {
                agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ""));
            } else {
                Errores_tipos.add("Error en el For, en la declaracion se necesita valores Int");
            }

            if (actual.hijos.get(4).hijos.size() > 1) {
                if (actual.hijos.get(4).hijos.get(0).nombre.equals("IDENTIFICADOR")
                        || actual.hijos.get(4).hijos.get(2).nombre.equals("IDENTIFICADOR")) {

                } else {
                    Errores_tipos.add("Condicion no valida para el for");
                }
            } else {
                Errores_tipos.add("Condicion no valida para el for");
            }
        }
////////////////////////////Comprobacion de tipos de Declaracion con asignacion        
        if (actual.nombre.equals("asig")) {
            if (actual.hijos.get(0).valor.equals("List") && actual.hijos.get(4).nombre.equals("LISTA")) {
                agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ""));
            } else if (actual.hijos.get(0).valor.equals("List") && !actual.hijos.get(4).nombre.equals("LISTA")) {
                Errores_tipos.add("El valor asignado a " + actual.hijos.get(1).valor + " no es correcta");
            }

            if (actual.hijos.get(0).valor.equals("Matriz") && actual.hijos.get(5).nombre.equals("LISTA") && actual.hijos.get(6).nombre.equals("LISTA")) {
                agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ""));
            } else if (actual.hijos.get(0).valor.equals("Matriz") && (!actual.hijos.get(5).nombre.equals("LISTA") || !actual.hijos.get(6).nombre.equals("LISTA"))) {
                Errores_tipos.add("El valor asignado a " + actual.hijos.get(1).valor + " no es correcta");
            }

            if (actual.hijos.get(0).valor.equals("Int") && Compr_valor(actual.hijos.get(3)).equals("Int")) {
                agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ""));
            } else if (actual.hijos.get(0).valor.equals("Int") && !Compr_valor(actual.hijos.get(3)).equals("Int")) {
                Errores_tipos.add("El valor asignado a " + actual.hijos.get(1).valor + " no es correcta");
            }
            if (actual.hijos.get(0).valor.equals("Float") && Compr_valor(actual.hijos.get(3)).equals("Float")) {
                agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ""));
            } else if (actual.hijos.get(0).valor.equals("Float") && !Compr_valor(actual.hijos.get(3)).equals("Float")) {
                Errores_tipos.add("El valor asignado a " + actual.hijos.get(1).valor + " no es correcta");
            }

            if (actual.hijos.get(0).valor.equals("String") && actual.hijos.get(3).nombre.equals("String")) {
                agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ""));
            } else if (actual.hijos.get(0).valor.equals("String") && actual.hijos.get(3).nombre.equals("IDENTIFICADOR")) {
                if (existe(actual.hijos.get(3).valor) == 1) {
                    if (actual.hijos.get(0).valor.equals("String") && get_tipo(actual.hijos.get(3).valor).equals("String")) {
                        agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ""));
                    } else if (actual.hijos.get(0).valor.equals("String") && !(get_tipo(actual.hijos.get(3).valor).equals("String"))) {
                        Errores_tipos.add("El valor asignado a " + actual.hijos.get(1).valor + " no es correcta");
                    }
                } else {
                    Errores_tipos.add("La raiable " + actual.hijos.get(3).valor + " no existe");
                }
            } else if (actual.hijos.get(0).valor.equals("String") && !actual.hijos.get(3).nombre.equals("String")) {
                Errores_tipos.add("El valor asignado a " + actual.hijos.get(1).valor + " no es correcta");
            }

            if (actual.hijos.get(0).valor.equals("Bool") && actual.hijos.get(3).nombre.equals("Bool")) {
                agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ""));
            } else if (actual.hijos.get(0).valor.equals("Bool") && actual.hijos.get(3).nombre.equals("IDENTIFICADOR")) {
                if (existe(actual.hijos.get(3).valor) == 1) {
                    if (actual.hijos.get(0).valor.equals("Bool") && get_tipo(actual.hijos.get(3).valor).equals("Bool")) {
                        agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ""));
                    } else if (actual.hijos.get(0).valor.equals("Bool") && !(get_tipo(actual.hijos.get(3).valor).equals("Bool"))) {
                        Errores_tipos.add("El valor asignado a " + actual.hijos.get(1).valor + " no es correcta");
                    }
                } else {
                    Errores_tipos.add("La raiable " + actual.hijos.get(3).valor + " no existe");
                }
            } else if (actual.hijos.get(0).valor.equals("Bool") && !(actual.hijos.get(3).nombre.equals("Bool"))) {
                Errores_tipos.add("El valor asignado a " + actual.hijos.get(1).valor + " no es correcta");
            }

        }
///////////////////////////////////////////////Comprobacion de tipos asignar
        if (actual.nombre.equals("asignar")) {
            if (existe(actual.hijos.get(0).valor) == 1) {
                if (get_tipo(actual.hijos.get(0).valor).equals("List") && actual.hijos.get(2).hijos.get(0).nombre.equals("LISTA")) {
                } else if ((get_tipo(actual.hijos.get(0).valor).equals("List") && !actual.hijos.get(2).hijos.get(0).nombre.equals("LISTA"))) {
                    Errores_tipos.add("El valor asignado a " + actual.hijos.get(0).valor + " no es correcto");
                }
                if (get_tipo(actual.hijos.get(0).valor).equals("Matriz") && (actual.hijos.get(2).hijos.get(0).nombre.equals("LISTA") && actual.hijos.get(2).hijos.get(1).nombre.equals("LISTA"))) {
                } else if (get_tipo(actual.hijos.get(0).valor).equals("Matriz") && (!actual.hijos.get(2).hijos.get(0).nombre.equals("LISTA") || !actual.hijos.get(2).hijos.get(1).nombre.equals("LISTA"))) {
                    Errores_tipos.add("El valor asignado a " + actual.hijos.get(0).valor + " no es correcto");
                }
                if (get_tipo(actual.hijos.get(0).valor).equals("Int") && Compr_valor(actual.hijos.get(2)).equals("Int")) {
                } else if (get_tipo(actual.hijos.get(0).valor).equals("Int") && !Compr_valor(actual.hijos.get(2)).equals("Int")) {
                    Errores_tipos.add("El valor asignado a " + actual.hijos.get(0).valor + " no es correcto");
                }
                if (get_tipo(actual.hijos.get(0).valor).equals("Float") && Compr_valor(actual.hijos.get(2)).equals("Float")) {
                } else if (get_tipo(actual.hijos.get(0).valor).equals("Float") && !Compr_valor(actual.hijos.get(2)).equals("Float")) {
                    Errores_tipos.add("El valor asignado a " + actual.hijos.get(0).valor + " no es correcta");
                }

                if (get_tipo(actual.hijos.get(0).valor).equals("String") && Compr_valor(actual.hijos.get(2)).equals("String")) {
                } else if (get_tipo(actual.hijos.get(0).valor).equals("String") && !Compr_valor(actual.hijos.get(2)).equals("String")) {
                    System.out.println("tipo" + get_tipo(actual.hijos.get(0).valor));
                    System.out.println("tipo" + Compr_valor(actual.hijos.get(2)));
                    Errores_tipos.add("El valor asignado a " + actual.hijos.get(0).valor + " no es correcta");
                }
                if (get_tipo(actual.hijos.get(0).valor).equals("Bool") && Compr_valor(actual.hijos.get(2)).equals("Bool")) {
                } else if (get_tipo(actual.hijos.get(0).valor).equals("Bool") && !Compr_valor(actual.hijos.get(2)).equals("Bool")) {
                    Errores_tipos.add("El valor asignado a " + actual.hijos.get(0).valor + " no es correcta");
                }

            } else {
                Errores_tipos.add("La variable " + actual.hijos.get(0).valor + " no existe");
            }
        }
///////////////////////////////////////Comprobacion de tipos condicion1
        if (actual.nombre.equals("PROPOSICION1") && actual.hijos.size() > 1) {
            if (comprobar_condicion(actual, 1) == 1) {
            } else {
                Errores_tipos.add("error en la condicion");
            }
        }
        if (actual.nombre.equals("PROPOSICION1-2") && actual.hijos.size() > 1) {
            if (comprobar_condicion(actual, 2) == 1) {
            } else {
                Errores_tipos.add("error en la condicion");
            }
        }

///////////////////////////Validar switch//////////////////////////////////////
        if (actual.nombre.equals("switch")) {
            if (existe(actual.hijos.get(0).valor) == 1) {
                if (get_tipo(actual.hijos.get(0).valor).equals("Int")
                        && actual.hijos.get(1).hijos.get(0).nombre.equals("caseE")) {
                } else if (get_tipo(actual.hijos.get(0).valor).equals("Int")
                        && !actual.hijos.get(1).hijos.get(0).nombre.equals("caseE")) {
                    Errores_tipos.add("Las opciones en el case para la variable " + actual.hijos.get(0).valor + " son incorrectas");
                }
                if (get_tipo(actual.hijos.get(0).valor).equals("String")
                        && actual.hijos.get(1).hijos.get(0).nombre.equals("caseC")) {
                } else if (get_tipo(actual.hijos.get(0).valor).equals("String")
                        && !actual.hijos.get(1).hijos.get(0).nombre.equals("caseC")) {
                    Errores_tipos.add("Las opciones en el case para la variable " + actual.hijos.get(0).valor + " son incorrectas");
                }
            } else {
                Errores_tipos.add("La variable " + actual.hijos.get(0).valor + " no existe");
            }
        }
//////////////////////////Recorrer arbol////////////////////////////////////////
        for (int i = 0; i < actual.hijos.size(); i++) {
            if (!actual.hijos.get(i).hijos.isEmpty()) {
                llenar_tabla(actual.hijos.get(i));
            }
        }
    }

    public static void validarOperaciones(Node actual) {
/////////////////////////////////////ver salida de la funcion/////////////////////
        if (actual.nombre.equals("metodo parametro")) {
            if (actual.hijos.get(0).hijos.get(0).nombre.equals(Busca_retorno(actual))) {
            } else if (!actual.hijos.get(0).hijos.get(0).nombre.equals(Busca_retorno(actual))) {
                Errores_tipos.add("El valor de retorno " + " no es correcto para esta funcion " + actual.hijos.get(0).valor);
            }
        }
//////////////////////////Recorrer arbol////////////////////////////////////////
        for (int i = 0; i < actual.hijos.size(); i++) {
            if (!actual.hijos.get(i).hijos.isEmpty()) {
                validarOperaciones(actual.hijos.get(i));
            }
        }
    }

    public static int comprobar_condicion(Node actual, int tc) {
        if (actual.hijos.get(0).nombre.equals("String") && actual.hijos.get(2).nombre.equals("String")) {
            return 1;
        }
        if (actual.hijos.get(0).nombre.equals("Int") && actual.hijos.get(2).nombre.equals("Int")) {
            return 1;
        } else if (actual.hijos.get(0).nombre.equals("Float") && actual.hijos.get(2).nombre.equals("Float")) {
            return 1;
        } else if (actual.hijos.get(0).nombre.equals("IDENTIFICADOR") && actual.hijos.get(2).nombre.equals("IDENTIFICADOR")) {
            if (existe(actual.hijos.get(0).valor) == 0 || existe(actual.hijos.get(2).valor) == 0) {
                Errores_tipos.add("La variable  " + actual.hijos.get(0).valor + "  o La variable " + actual.hijos.get(2).valor + " no existe");

            } else {
                if (get_tipo(actual.hijos.get(0).valor).equals(get_tipo(actual.hijos.get(2).valor))) {
                    return 1;
                } else {
                    Errores_tipos.add("Las variables " + actual.hijos.get(0).valor + " y " + actual.hijos.get(2).valor + " de la condicion no son iguales de tipos");
                }
            }

        } else if (actual.hijos.get(0).nombre.equals("IDENTIFICADOR") && actual.hijos.get(2).nombre.equals("Int")) {
            if (existe(actual.hijos.get(0).valor) == 0) {
                Errores_tipos.add("La variable " + actual.hijos.get(0).valor + " no existe");
            } else if (existe(actual.hijos.get(0).valor) == 1) {
                if (get_tipo(actual.hijos.get(0).valor).equals("Int")) {
                    return 1;
                } else {
                    Errores_tipos.add("La variable " + actual.hijos.get(0).valor + " y el valor " + actual.hijos.get(2).valor + " de la condicion no son iguales de tipos");
                }
            }

        } else if (actual.hijos.get(0).nombre.equals("Int") && actual.hijos.get(2).nombre.equals("IDENTIFICADOR")) {
            if (existe(actual.hijos.get(2).valor) == 0) {
                Errores_tipos.add("la variable " + actual.hijos.get(2).valor + " no existe");
            } else if (existe(actual.hijos.get(2).valor) == 1) {
                if (get_tipo(actual.hijos.get(2).valor).equals("Int")) {
                    return 1;
                } else {
                    Errores_tipos.add("El valor " + actual.hijos.get(0).valor + " y la variable " + actual.hijos.get(2).valor + " de la condicion no son iguales de tipos");
                }
            }

        } else if (actual.hijos.get(0).nombre.equals("IDENTIFICADOR") && actual.hijos.get(2).nombre.equals("Float")) {
            if (existe(actual.hijos.get(0).valor) == 0) {
                Errores_tipos.add("La variable " + actual.hijos.get(0).valor + " no existe");
            } else if (existe(actual.hijos.get(0).valor) == 1) {
                if (get_tipo(actual.hijos.get(0).valor).equals("Float")) {
                    return 1;
                } else {
                    Errores_tipos.add("La variable " + actual.hijos.get(0).valor + " y el valor" + actual.hijos.get(2).valor + " de la condicion no son iguales de tipos");
                }
            }

        } else if (actual.hijos.get(0).nombre.equals("Float") && actual.hijos.get(2).nombre.equals("IDENTIFICADOR")) {
            if (existe(actual.hijos.get(2).valor) == 0) {
                Errores_tipos.add("La variable " + actual.hijos.get(2).valor + "no existe");
            } else {
                if (get_tipo(actual.hijos.get(2).valor).equals("Float")) {
                    return 1;
                } else {
                    Errores_tipos.add("El valor " + actual.hijos.get(0).valor + " y la variable " + actual.hijos.get(2).valor + " de la condicion no son iguales de tipos");
                }
            }
        } else if (actual.hijos.get(0).nombre.equals("IDENTIFICADOR") && actual.hijos.get(2).nombre.equals("String")) {
            if (existe(actual.hijos.get(0).valor) == 0) {
                Errores_tipos.add("La variable " + actual.hijos.get(0).valor + " no existe");
            } else if (existe(actual.hijos.get(0).valor) == 1) {
                if (get_tipo(actual.hijos.get(0).valor).equals("String")) {
                    return 1;
                } else {
                    Errores_tipos.add("La variable " + actual.hijos.get(0).valor + " y el valor" + actual.hijos.get(2).valor + " de la condicion no son iguales de tipos");
                }
            }

        } else if (actual.hijos.get(0).nombre.equals("String") && actual.hijos.get(2).nombre.equals("IDENTIFICADOR")) {
            if (existe(actual.hijos.get(2).valor) == 0) {
                Errores_tipos.add("La variable " + actual.hijos.get(2).valor + "no existe");
            } else {
                if (get_tipo(actual.hijos.get(2).valor).equals("String")) {
                    return 1;
                } else {
                    Errores_tipos.add("El valor " + actual.hijos.get(0).valor + " y la variable " + actual.hijos.get(2).valor + " de la condicion no son iguales de tipos");
                }
            }
        } else {
            Errores_tipos.add("Los valores " + actual.hijos.get(0).valor + " y " + actual.hijos.get(2).valor + " de la condicion no son iguales de tipos");
        }
        return 0;
    }

    public static void agregar(Entry e) {
        tabla_simbolos.add(e);
        /*boolean esta = false;
        for (int i = 0; i < tabla_simbolos.size(); i++) {
            if (e.id.equals(tabla_simbolos.get(i).id)) {
                esta = true;
                break;
            }
        }
        if (esta) {
            Errores_tipos.add("La variable: " + e.id + " ya fue declarada");
        } else {
            tabla_simbolos.add(e);
        }*/
    }

    public static void adParametro(Node n) {
        if (n.nombre.equals("parametro")) {
            agregar(new Entry(n.hijos.get(1).valor, n.hijos.get(0).hijos.get(0).valor, ""));
        }

        for (int i = 0; i < n.hijos.size(); i++) {
            if (!n.hijos.get(i).hijos.isEmpty()) {
                adParametro(n.hijos.get(i));
            }
        }
    }

    public static String Busca_retorno(Node raiz) {
        valores = new ArrayList();
        BuscaR(raiz);
        int fallo = 0;
        String temp = valores.get(0), retorno = "";
        if (valores.size() == 1) {
            return valores.get(0);
        }
        if (temp.equals("Int")) {
            for (String t : valores) {
                if (t.equals("Int")) {
                    retorno = "Int";
                } else {
                    fallo++;
                }
            }
        }
        if (temp.equals("Float")) {
            for (String t : valores) {
                if (t.equals("Float")) {
                    retorno = "Float";
                } else {
                    fallo++;
                }
            }
        }
        if (temp.equals("String")) {
            for (String t : valores) {
                if (t.equals("String")) {
                    retorno = "String";
                } else {
                    fallo++;
                }
            }
        }
        if (temp.equals("Bool")) {
            for (String t : valores) {
                if (t.equals("Bool")) {
                    retorno = "Bool";
                } else {
                    fallo++;
                }
            }
        }
        if (temp.equals("List")) {
            for (String t : valores) {
                if (t.equals("List")) {
                    retorno = "List";
                } else {
                    fallo++;
                }
            }
        }
        if (temp.equals("Matriz")) {
            for (String t : valores) {
                if (t.equals("Matriz")) {
                    retorno = "Matriz";
                } else {
                    fallo++;
                }
            }
        }
        if (fallo == 0) {
            return retorno;
        }
        return "";
    }

    public static void BuscaR(Node nodo) {
        if (nodo.nombre.equals("Return")) {
            Node n = nodo.hijos.get(0).hijos.get(0).hijos.get(0).hijos.get(0);
            if (n.hijos.get(0).nombre.equals("IDENTIFICADOR")) {
                if (existe(n.hijos.get(0).valor) == 1) {
                    valores.add(get_tipo(n.hijos.get(0).valor));
                } else if (existe(n.hijos.get(0).valor) == 0) {
                    valores.add("error");
                    Errores_tipos.add("La variable " + n.hijos.get(0).valor + " no existe");
                }
            } else if (n.hijos.get(0).nombre.equals("Int")) {
                valores.add(n.hijos.get(0).nombre);
            } else if (n.hijos.get(0).nombre.equals("Float")) {
                valores.add(n.hijos.get(0).nombre);
            } else if (n.hijos.get(0).nombre.equals("String")) {
                valores.add(n.hijos.get(0).nombre);
            } else if (n.hijos.get(0).nombre.equals("Bool")) {
                valores.add(n.hijos.get(0).nombre);
            } else if (n.hijos.get(0).nombre.equals("Matriz")) {
                valores.add(n.hijos.get(0).nombre);
            } else if (n.hijos.get(0).nombre.equals("List")) {
                valores.add(n.hijos.get(0).nombre);
            } else {
                valores.add("error");
            }
        }

        for (int i = 0; i < nodo.hijos.size(); i++) {
            if (!nodo.hijos.get(i).hijos.isEmpty()) {
                BuscaR(nodo.hijos.get(i));
            }
        }
    }

    public static String Compr_valor(Node n) {
        if (n.nombre.equals("operacionA") || n.hijos.get(0).nombre.equals("operacionA-D") || n.hijos.get(0).nombre.equals("operacionA-M")) {
            return opA(n);
        }
        if (n.nombre.equals("op")) {
            Node t1 = n.hijos.get(0);
            if (t1.nombre.equals("Valor")) {
                Node t2 = t1.hijos.get(0);
                if (t2.nombre.equals("Valoro")) {
                    if (t2.hijos.get(0).nombre.equals("Int")) {
                        return "Int";
                    } else if (t2.hijos.get(0).nombre.equals("Float")) {
                        return "Float";
                    } else if (t2.hijos.get(0).nombre.equals("IDENTIFICADOR")) {
                        Node t3 = t2.hijos.get(0);
                        if (existe(t3.valor) == 1) {
                            if (get_tipo(t3.valor).equals("Int")) {
                                return "Int";
                            } else if (get_tipo(t3.valor).equals("Float")) {
                                return "Float";
                            } else if (get_tipo(t3.valor).equals("String")) {
                                return "String";
                            } else if (get_tipo(t3.valor).equals("Bool")) {
                                return "Bool";
                            }
                        } else {
                            Errores_tipos.add("La variable " + t3.valor + " no existe");
                        }
                    }
                }
            }
        }
        if (n.nombre.equals("TIPO")) {
            Node t = n.hijos.get(0);
            if (t.nombre.equals("operacionA") || t.hijos.get(0).nombre.equals("operacionA-D") || t.hijos.get(0).nombre.equals("operacionA-M")) {
                return opA(t);
            }
            if (t.nombre.equals("op")) {
                Node t1 = t.hijos.get(0);
                if (t1.nombre.equals("Valor")) {
                    Node t2 = t1.hijos.get(0);
                    if (t2.nombre.equals("Valoro")) {
                        if (t2.hijos.get(0).nombre.equals("Int")) {
                            return "Int";
                        } else if (t2.hijos.get(0).nombre.equals("Float")) {
                            return "Float";
                        } else if (t2.hijos.get(0).nombre.equals("String")) {
                            return "String";
                        } else if (t2.hijos.get(0).nombre.equals("Bool")) {
                            return "Bool";
                        } else if (t2.hijos.get(0).nombre.equals("IDENTIFICADOR")) {
                            Node t3 = t2.hijos.get(0);
                            if (existe(t3.valor) == 1) {
                                if (get_tipo(t3.valor).equals("Int")) {
                                    return "Int";
                                } else if (get_tipo(t3.valor).equals("Float")) {
                                    return "Float";
                                } else if (get_tipo(t3.valor).equals("String")) {
                                    return "String";
                                } else if (get_tipo(t3.valor).equals("Bool")) {
                                    return "Bool";
                                }
                            } else {
                                Errores_tipos.add("La variable " + t3.valor + " no existe");
                            }
                        }
                    }
                }
            }
        }
        return "";
    }

    public static String opA(Node raiz) {
        valores = new ArrayList();
        ver_operacion(raiz);
        int fallo = 0;
        String temp = valores.get(0), retorno = "";
        if (temp.equals("Int")) {
            for (String t : valores) {
                if (t.equals("Int")) {
                    retorno = "Int";
                } else {
                    fallo++;
                }
            }
        }
        if (temp.equals("Float")) {
            for (String t : valores) {
                if (t.equals("Float")) {
                    retorno = "Float";
                } else {
                    fallo++;
                }
            }
        }
        if (fallo == 0) {
            return retorno;
        }
        return "";
    }

    public static void ver_operacion(Node n) {
        if (n.nombre.equals("Valoro")) {
            if (n.hijos.get(0).nombre.equals("IDENTIFICADOR")) {
                if (existe(n.hijos.get(0).valor) == 1) {
                    valores.add(get_tipo(n.hijos.get(0).valor));
                } else if (existe(n.hijos.get(0).valor) == 0) {
                    valores.add("error");
                    Errores_tipos.add("La variable " + n.hijos.get(0).valor + " no existe");
                }
            } else if (n.hijos.get(0).nombre.equals("Int")) {
                valores.add(n.hijos.get(0).nombre);
            } else if (n.hijos.get(0).nombre.equals("Float")) {
                valores.add(n.hijos.get(0).nombre);
            } else {
                valores.add("error");
            }

        }
        for (int i = 0; i < n.hijos.size(); i++) {
            if (!n.hijos.get(i).hijos.isEmpty()) {
                ver_operacion(n.hijos.get(i));
            }
        }
    }

    public static int existe(String s) {
        for (int i = 0; i < tabla_simbolos.size(); i++) {
            if (s.equals(tabla_simbolos.get(i).id)) {
                return 1;
            }
        }
        return 0;
    }

    public static String get_tipo(String s) {
        for (int i = 0; i < tabla_simbolos.size(); i++) {
            if (s.equals(tabla_simbolos.get(i).id)) {
                return tabla_simbolos.get(i).tipo;
            }
        }
        return "";
    }

    public static void analizar() throws IOException {
        llenar_tabla(root);
        validarOperaciones(root);
        for (int i = 0; i < tabla_simbolos.size(); i++) {
            System.out.println("ID: " + tabla_simbolos.get(i).id + " TIPO: " + tabla_simbolos.get(i).tipo);
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
    private javax.swing.JButton btnIf1;
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
    public static ArrayList<Entry> tabla_simbolos = new ArrayList<Entry>();
    public static ArrayList<String> ids, ids2;
    public static ArrayList<String> tipos_matrix, Errores_tipos = new ArrayList<String>();
    public static ArrayList<String> valores = new ArrayList();
}
