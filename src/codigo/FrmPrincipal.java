/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import com.sun.awt.SecurityWarning;
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
import javax.swing.JOptionPane;
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
        boton_intermedio.setEnabled(false);
        boton_simbolos.setEnabled(false);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_intermedio = new javax.swing.JTextArea();
        btnCase = new javax.swing.JButton();
        btnFunctions = new javax.swing.JButton();
        btnFor = new javax.swing.JButton();
        btnIf = new javax.swing.JButton();
        btnIf1 = new javax.swing.JButton();
        btnWhile = new javax.swing.JButton();
        boton_intermedio = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        btnArbol = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        ta_simbolos = new javax.swing.JTextArea();
        boton_simbolos = new javax.swing.JButton();
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

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        txtResultado.setText("main begin\n\t/^ INGRESE\n\tSU\n\tCODIGO^/\nend main\n\n");
        jScrollPane1.setViewportView(txtResultado);

        ta_intermedio.setEditable(false);
        ta_intermedio.setColumns(20);
        ta_intermedio.setRows(5);
        jScrollPane2.setViewportView(ta_intermedio);

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

        btnWhile.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        btnWhile.setText("Error Case");
        btnWhile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWhileActionPerformed(evt);
            }
        });

        boton_intermedio.setText("Codigo intermedio");
        boton_intermedio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_intermedioMouseClicked(evt);
            }
        });
        boton_intermedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_intermedioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnWhile)
                    .addComponent(btnFor)
                    .addComponent(btnIf)
                    .addComponent(btnIf1)
                    .addComponent(btnCase)
                    .addComponent(btnFunctions))
                .addGap(83, 83, 83)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_intermedio))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_intermedio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnCase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIf1)
                .addGap(18, 18, 18)
                .addComponent(btnFunctions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(btnWhile)
                .addGap(18, 18, 18)
                .addComponent(btnFor)
                .addGap(18, 18, 18)
                .addComponent(btnIf)
                .addGap(54, 54, 54))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Errores...", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnArbol)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(btnArbol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        ta_simbolos.setColumns(20);
        ta_simbolos.setRows(5);
        jScrollPane6.setViewportView(ta_simbolos);

        boton_simbolos.setText("Mostrar tabla de simbolos");
        boton_simbolos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_simbolosActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton_simbolos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boton_simbolos)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
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
                + "end for\n" + "end if\n" + "while a<10 repeat \n" + "\t a=>10; \n" + "end while \n" + "case(a) of \n"
                + "\t 1:Println(\"hola\"); \n" + "\t 2:Println(\"adios\");\n" + "\t default:Println(\"nunca\"); \n"
                + "end case\n" + "end main";
        txtResultado.setText(codigo);
    }//GEN-LAST:event_btnCaseActionPerformed

    private void btnFunctionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFunctionsActionPerformed
        // TODO add your handling code here:
        String codigo = "main begin \n" + "Int a=>3+2*7;\n" + "if a=3 then \n" + "\tfor Int i=>0 in range (i<a)\n" + "\t\t Print(\"hola\");\n"
                + "\tend for\n" + "end if\n" + "while true repeat \n" + "\t a=>10; \n" + "end while \n" + "case(a) of \n"
                + "\t 1:Println(\"hola\"); \n" + "\t 2:Println(\"adios\");\n" + "\t default:Println(\"nunca\"); \n"
                + "end case\n" + "end main\n\n" + "Int begin metodoRecursivo(Int numero)\n" +"Int resultado=>0;\n"+"Int n=>0;\n" +"numero=>resultado;\n"
                + "if n=1 then\n" + "\t return 1;\n" + "end if\n" + "else then\n" + "\t resultado => metodoRecursivo(numero-1);\n"
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
        ta_intermedio.setText(null);
        txtAnalizarSin.setText(null);
        ta_simbolos.setText(null);
        txtAnalizarSin.setText(null);
        txtResultado.setText(null);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        boton_intermedio.setEnabled(false);
        boton_simbolos.setEnabled(false);
        ta_intermedio.setText("");
        ta_simbolos.setText("");
        lista_tabla_simbolos = new ArrayList<Entry>();
        lista_cuadruplos = new ArrayList<Cuadruplo>();
        ids = null;
        ids2 = null;
        lista_tipos_matrix = null;
        lista_errores_type = new ArrayList<String>();
        ambito_cont = 1;
        ambito_control = -1;
        offset = 0;
        ambito = "";
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
        if (!Sintax.Errores.isEmpty() || !Lexer.ErroresLexicos.isEmpty()) {
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
        } else if(Sintax.Errores.isEmpty() && Lexer.ErroresLexicos.isEmpty()){

            try {
                root = s.raiz;
                try {
                    analizar();
                    padre = root;
                    /* funcion_cuadruplos(root);
                    System.out.println("" + lista_cuadruplos.size());
                    for (int i = 0; i < lista_cuadruplos.size(); i++) {
                        System.out.println(lista_cuadruplos.get(i));
                    }*/
                    if (!lista_errores_type.isEmpty()) {
                        boton_intermedio.setEnabled(false);
                        boton_simbolos.setEnabled(false);
                        String temp = "";
                        for (int i = 0; i < lista_errores_type.size(); i++) {
                            temp += "" + lista_errores_type.get(i) + "\n";
                        }
                        txtAnalizarSin.setText(temp);
                        txtAnalizarSin.setForeground(Color.red);

                    } else {
                        boton_intermedio.setEnabled(true);
                        boton_simbolos.setEnabled(true);
                        txtAnalizarSin.setText("Analisis realizado correctamente");
                        txtAnalizarSin.setForeground(new Color(25, 111, 61));
                    }
                } catch (IOException ex) {
                    System.out.println("error");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (!lista_errores_type.isEmpty()) {
            for (int i = 0; i < lista_errores_type.size(); i++) {
                System.out.println(lista_errores_type.get(i));
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
        //hola push
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
                + "\treturn 1;\n" + "end if\nelse then\n" + "\t numero=>numero-1;\n" + "\t resultado => metodoRecursivo(numero); \n \tresultado=>resultado*numero; \n  "
                + "\treturn resultado;\n" + "end else\nend call\n";
        txtResultado.setText(codigo);

    }//GEN-LAST:event_btnIf1ActionPerformed

    private void boton_intermedioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_intermedioMouseClicked
        ta_intermedio.setText("");
        try {
            funcion_cuadruplos(root);
            String mensaje = "";
            mensaje+="---------------------\n";
            for (int i = 0; i < lista_cuadruplos.size(); i++) {
                mensaje += lista_cuadruplos.get(i) + "\n";

            }
            mensaje+="---------------------\n";
            ta_intermedio.setText(mensaje);
        } catch (Exception e) {
        }


    }//GEN-LAST:event_boton_intermedioMouseClicked

    private void boton_intermedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_intermedioActionPerformed
       /* String temp = "";
        for (int i = 0; i < lista_cuadruplos.size(); i++) {
            temp = temp + lista_cuadruplos.get(i) + "/n";
        }
        ta_intermedio.setText(temp);*/
    }//GEN-LAST:event_boton_intermedioActionPerformed

    private void boton_simbolosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_simbolosActionPerformed
        ta_simbolos.setText("");
        try {
            String mensaje = "";
            for (int i = 0; i < lista_tabla_simbolos.size(); i++) {
                mensaje += "ID: " + lista_tabla_simbolos.get(i).id
                        + " TIPO: " + lista_tabla_simbolos.get(i).tipo
                        + " AMBITO: " + lista_tabla_simbolos.get(i).ambito
                        + " OFFSET: " + lista_tabla_simbolos.get(i).offset + "\n";
            }
            ta_simbolos.setText(mensaje);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_boton_simbolosActionPerformed
    public static void llenar(Node root, DefaultMutableTreeNode current) {
        for (int i = 0; i < root.hijos.size(); i++) {
            current.add(new DefaultMutableTreeNode(root.hijos.get(i)));
            if (!root.hijos.get(i).hijos.isEmpty()) {
                try {
                    llenar(root.hijos.get(i), (DefaultMutableTreeNode) current.getChildAt(i));
                } catch (Exception e) {
                    lista_errores_type.add("Error en llenar tabla");
                }
            }
        }
    }

    public static void llenar_tabla_simbolos(Node actual) {
//////////////////////////Comprobacion de tipos de for
        if (actual.nombre.equals("FOR")
                || actual.nombre.equals("If")
                || actual.nombre.equals("caseE")
                || actual.nombre.equals("caseC")
                || actual.nombre.equals("While")) {
            ambito += "," + ambito_cont;
            ambito_cont++;
            ambito_control++;

        }
        //bloque for
        if (actual.nombre.equals("FOR")) {
            if (actual.hijos.get(0).valor.equals("Int") && actual.hijos.get(3).nombre.equals("Int")) {
                agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ambito, offset, activo));
            } else {
                lista_errores_type.add("Error en el For, en la declaracion se necesita valores Int");
            }

            if (actual.hijos.get(4).hijos.size() > 1) {
                if (actual.hijos.get(4).hijos.get(0).nombre.equals("IDENTIFICADOR")
                        || actual.hijos.get(4).hijos.get(2).nombre.equals("IDENTIFICADOR")) {

                } else {
                    lista_errores_type.add("Condicion no valida para el for");
                }
            } else {
                lista_errores_type.add("Condicion no valida para el for");
            }
        }

        //bloque switch
        ///////////////////////////Validar switch//////////////////////////////////////
        if (actual.nombre.equals("switch")) {
            if (existe(actual.hijos.get(0).valor) == 1) {
                if (get_tipo(actual.hijos.get(0).valor).equals("Int")
                        && actual.hijos.get(1).hijos.get(0).nombre.equals("caseE")) {

                } else if (get_tipo(actual.hijos.get(0).valor).equals("Int")
                        && !actual.hijos.get(1).hijos.get(0).nombre.equals("caseE")) {
                    lista_errores_type.add("Las opciones en el case para la variable " + actual.hijos.get(0).valor + " son incorrectas");
                }
                if (get_tipo(actual.hijos.get(0).valor).equals("String")
                        && actual.hijos.get(1).hijos.get(0).nombre.equals("caseC")) {

                } else if (get_tipo(actual.hijos.get(0).valor).equals("String")
                        && !actual.hijos.get(1).hijos.get(0).nombre.equals("caseC")) {
                    lista_errores_type.add("Las opciones en el case para la variable " + actual.hijos.get(0).valor + " son incorrectas");
                }
            } else {
                lista_errores_type.add("La variable " + actual.hijos.get(0).valor + " no existe");
            }
        }

        if (actual.nombre.equals("void")) {
            agregar(new Entry(actual.hijos.get(0).valor, "void", ambito, offset, activo));
            if (actual.hijos.get(1).nombre.equals("parametro")) {
                adParametro(actual.hijos.get(1));
            }
        }

        //METODO PARAMETRO
        if (actual.nombre.equals("metodo parametro")) {
            agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).hijos.get(0).nombre, ambito, offset, activo));
            if (actual.hijos.get(2).nombre.equals("parametro")) {
                adParametro(actual.hijos.get(2));
            }
        }

////////////////////////////Comprobacion de tipos de Declaracion con asignacion        
        if (actual.nombre.equals("asig")) {
            if (actual.hijos.get(0).valor.equals("List") && actual.hijos.get(4).nombre.equals("LISTA")) {
                agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ambito, offset, activo));
            } else if (actual.hijos.get(0).valor.equals("List") && !actual.hijos.get(4).nombre.equals("LISTA")) {
                lista_errores_type.add("El valor asignado a " + actual.hijos.get(1).valor + " no es correcta");
            }

            if (actual.hijos.get(0).valor.equals("Matriz") && actual.hijos.get(5).nombre.equals("LISTA") && actual.hijos.get(6).nombre.equals("LISTA")) {
                agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ambito, offset, activo));
            } else if (actual.hijos.get(0).valor.equals("Matriz") && (!actual.hijos.get(5).nombre.equals("LISTA") || !actual.hijos.get(6).nombre.equals("LISTA"))) {
                lista_errores_type.add("El valor asignado a " + actual.hijos.get(1).valor + " no es correcta");
            }

            if (actual.hijos.get(0).valor.equals("Int") && Compr_valor(actual.hijos.get(3)).equals("Int")) {
                agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ambito, offset, activo));
            } else if (actual.hijos.get(0).valor.equals("Int") && !Compr_valor(actual.hijos.get(3)).equals("Int")) {
                lista_errores_type.add("El valor asignado a " + actual.hijos.get(1).valor + " no es correcta");
            }
            if (actual.hijos.get(0).valor.equals("Float") && Compr_valor(actual.hijos.get(3)).equals("Float")) {
                agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ambito, offset, activo));
            } else if (actual.hijos.get(0).valor.equals("Float") && !Compr_valor(actual.hijos.get(3)).equals("Float")) {
                lista_errores_type.add("El valor asignado a " + actual.hijos.get(1).valor + " no es correcta");
            }

            if (actual.hijos.get(0).valor.equals("String") && actual.hijos.get(3).nombre.equals("String")) {
                agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ambito, offset, activo));
            } else if (actual.hijos.get(0).valor.equals("String") && actual.hijos.get(3).nombre.equals("IDENTIFICADOR")) {
                if (existe(actual.hijos.get(3).valor) == 1) {
                    if (actual.hijos.get(0).valor.equals("String") && get_tipo(actual.hijos.get(3).valor).equals("String")) {
                        agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ambito, offset, activo));
                    } else if (actual.hijos.get(0).valor.equals("String") && !(get_tipo(actual.hijos.get(3).valor).equals("String"))) {
                        lista_errores_type.add("El valor asignado a " + actual.hijos.get(1).valor + " no es correcta");
                    }
                } else {
                    lista_errores_type.add("La raiable " + actual.hijos.get(3).valor + " no existe");
                }
            } else if (actual.hijos.get(0).valor.equals("String") && !actual.hijos.get(3).nombre.equals("String")) {
                lista_errores_type.add("El valor asignado a " + actual.hijos.get(1).valor + " no es correcta");
            }

            if (actual.hijos.get(0).valor.equals("Bool") && actual.hijos.get(3).nombre.equals("Bool")) {
                agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ambito, offset, activo));
            } else if (actual.hijos.get(0).valor.equals("Bool") && actual.hijos.get(3).nombre.equals("IDENTIFICADOR")) {
                if (existe(actual.hijos.get(3).valor) == 1) {
                    if (actual.hijos.get(0).valor.equals("Bool") && get_tipo(actual.hijos.get(3).valor).equals("Bool")) {
                        agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ambito, offset, activo));
                    } else if (actual.hijos.get(0).valor.equals("Bool") && !(get_tipo(actual.hijos.get(3).valor).equals("Bool"))) {
                        lista_errores_type.add("El valor asignado a " + actual.hijos.get(1).valor + " no es correcta");
                    }
                } else {
                    lista_errores_type.add("La raiable " + actual.hijos.get(3).valor + " no existe");
                }
            } else if (actual.hijos.get(0).valor.equals("Bool") && !(actual.hijos.get(3).nombre.equals("Bool"))) {
                lista_errores_type.add("El valor asignado a " + actual.hijos.get(1).valor + " no es correcta");
            }

        }

///////////////////////////////////////////////Comprobacion de tipos asignar
        if (actual.nombre.equals("asignar")) {
            if (existe(actual.hijos.get(0).valor) == 1) {
                if (get_tipo(actual.hijos.get(0).valor).equals("List") && actual.hijos.get(2).hijos.get(0).nombre.equals("LISTA")) {
                } else if ((get_tipo(actual.hijos.get(0).valor).equals("List") && !actual.hijos.get(2).hijos.get(0).nombre.equals("LISTA"))) {
                    lista_errores_type.add("El valor asignado a " + actual.hijos.get(0).valor + " no es correcto");
                }
                if (get_tipo(actual.hijos.get(0).valor).equals("Matriz") && (actual.hijos.get(2).hijos.get(0).nombre.equals("LISTA") && actual.hijos.get(2).hijos.get(1).nombre.equals("LISTA"))) {
                } else if (get_tipo(actual.hijos.get(0).valor).equals("Matriz") && (!actual.hijos.get(2).hijos.get(0).nombre.equals("LISTA") || !actual.hijos.get(2).hijos.get(1).nombre.equals("LISTA"))) {
                    lista_errores_type.add("El valor asignado a " + actual.hijos.get(0).valor + " no es correcto");
                }
                if (get_tipo(actual.hijos.get(0).valor).equals("Int") && Compr_valor(actual.hijos.get(2)).equals("Int")) {
                } else if (get_tipo(actual.hijos.get(0).valor).equals("Int") && !Compr_valor(actual.hijos.get(2)).equals("Int")) {
                    lista_errores_type.add("El valor asignado a " + actual.hijos.get(0).valor + " no es correcto");
                }
                if (get_tipo(actual.hijos.get(0).valor).equals("Float") && Compr_valor(actual.hijos.get(2)).equals("Float")) {
                } else if (get_tipo(actual.hijos.get(0).valor).equals("Float") && !Compr_valor(actual.hijos.get(2)).equals("Float")) {
                    lista_errores_type.add("El valor asignado a " + actual.hijos.get(0).valor + " no es correcta");
                }

                if (get_tipo(actual.hijos.get(0).valor).equals("String") && Compr_valor(actual.hijos.get(2)).equals("String")) {
                } else if (get_tipo(actual.hijos.get(0).valor).equals("String") && !Compr_valor(actual.hijos.get(2)).equals("String")) {
                    System.out.println("tipo" + get_tipo(actual.hijos.get(0).valor));
                    System.out.println("tipo" + Compr_valor(actual.hijos.get(2)));
                    lista_errores_type.add("El valor asignado a " + actual.hijos.get(0).valor + " no es correcta");
                }
                if (get_tipo(actual.hijos.get(0).valor).equals("Bool") && Compr_valor(actual.hijos.get(2)).equals("Bool")) {
                } else if (get_tipo(actual.hijos.get(0).valor).equals("Bool") && !Compr_valor(actual.hijos.get(2)).equals("Bool")) {
                    lista_errores_type.add("El valor asignado a " + actual.hijos.get(0).valor + " no es correcta");
                }

            } else {
                lista_errores_type.add("La variable " + actual.hijos.get(0).valor + " no existe");
            }
        }
///////////////////////////////////////Comprobacion de tipos condicion1
        if (actual.nombre.equals("PROPOSICION1") && actual.hijos.size() > 1) {
            if (comprobar_condicion(actual, 1) == 1) {
            } else {
                lista_errores_type.add("error en la condicion");
            }
        }
        if (actual.nombre.equals("PROPOSICION1-2") && actual.hijos.size() > 1) {
            if (comprobar_condicion(actual, 2) == 1) {
            } else {
                lista_errores_type.add("error en la condicion");
            }
        }

//////////////////////////Recorrer arbol////////////////////////////////////////
        for (int i = 0; i < actual.hijos.size(); i++) {
            if (actual.nombre.equals("metodo parametro")) {
                ambito = actual.hijos.get(1).valor;
                offset = 0;
                ambito_cont = 1;
            } else if (actual.nombre.equals("void")) {
                ambito = actual.hijos.get(0).valor;
                offset = 0;
                ambito_cont = 1;
            } else if (actual.nombre.equals("Main")) {
                if (actual.hijos.get(i).nombre.equals("sentencias")) {
                    ambito = "main";
                    offset = 0;
                }
            }

            /* if(actual.nombre.equals("metodo parametro")){
                ambito=actual.hijos.get(1).valor+ " 0" ;
                offset=0;
                ambito_cont=1;
            }else if(actual.nombre.equals("void")){
                ambito=actual.hijos.get(0).valor+ " 0" ;
                offset=0;
                ambito_cont=1;
            }else if(actual.nombre.equals("Main")){
                if(actual.hijos.get(i).nombre.equals("sentencias")){
                    ambito="main 0 ";
                    offset=0;
                }
            }*/
            if (!actual.hijos.get(i).hijos.isEmpty()) {
                llenar_tabla_simbolos(actual.hijos.get(i));
            }
        }
        if (ambito_control >= 0
                && (actual.nombre.equals("FOR")
                || actual.nombre.equals("If")
                || actual.nombre.equals("caseE")
                || actual.nombre.equals("caseC")
                || actual.nombre.equals("While"))) {
            ambito = ambito.substring(0, ambito.lastIndexOf(","));
            ambito_control--;
            //System.out.println(ambito);
        }
    }

    public static void validarOperaciones(Node actual) {
/////////////////////////////////////ver salida de la funcion/////////////////////
        if (actual.nombre.equals("metodo parametro")) {
            if (actual.hijos.get(0).hijos.get(0).nombre.equals(Busca_retorno(actual))) {
            } else if (!actual.hijos.get(0).hijos.get(0).nombre.equals(Busca_retorno(actual))) {
                lista_errores_type.add("El valor de retorno " + " no es correcto para esta funcion " + actual.hijos.get(0).valor);
            }
        }

        if (actual.nombre.equals("llamar metodo")) {
            valores = new ArrayList();
            ids = new ArrayList();
            ver_args(actual);
            String temp = actual.hijos.get(0).valor;
            ver_params(root, temp);
            int cont = 0;
            if (valores.size() == ids.size()) {
                for (int i = 0; i < valores.size(); i++) {
                    if (valores.get(i).equals(ids.get(i))) {

                    } else {
                        cont++;
                    }
                }
            }
            if (cont == 0) {
            } else {
                lista_errores_type.add("La llamada de el metodo  " + temp + " no esta bien debido a que sus parametros y argumentos no son iguales");
            }

        }
//////////////////////////Recorrer arbol////////////////////////////////////////
        for (int i = 0; i < actual.hijos.size(); i++) {
            if (!actual.hijos.get(i).hijos.isEmpty()) {
                validarOperaciones(actual.hijos.get(i));

            }
        }
    }

    public static void ver_params(Node actual, String metodo) {
        if (actual.nombre.equals("metodo parametro") && actual.hijos.get(1).valor.equals(metodo)) {
            vP(actual);
        }
        for (int i = 0; i < actual.hijos.size(); i++) {
            if (!actual.hijos.get(i).hijos.isEmpty()) {
                ver_params(actual.hijos.get(i), metodo);
            }
        }
    }

    public static void vP(Node n) {
        if (n.nombre.equals("parametro")) {
            ids.add(n.hijos.get(0).hijos.get(0).valor);
        }

        for (int i = 0; i < n.hijos.size(); i++) {
            if (!n.hijos.get(i).hijos.isEmpty()) {
                vP(n.hijos.get(i));
            }
        }
    }

    public static void ver_args(Node n) {
        if (n.nombre.equals("Valoro")) {
            if (n.hijos.get(0).nombre.equals("IDENTIFICADOR")) {
                if (existe(n.hijos.get(0).valor) == 1) {
                    valores.add(get_tipo(n.hijos.get(0).valor));
                } else if (existe(n.hijos.get(0).valor) == 0) {
                    valores.add("error");
                    lista_errores_type.add("La variable " + n.hijos.get(0).valor + " no existe");
                }
            } else if (n.hijos.get(0).nombre.equals("Int")) {
                valores.add(n.hijos.get(0).nombre);
            } else if (n.hijos.get(0).nombre.equals("Float")) {
                valores.add(n.hijos.get(0).nombre);
            } else if (n.hijos.get(0).nombre.equals("String")) {
                valores.add(n.hijos.get(0).nombre);
            } else if (n.hijos.get(0).nombre.equals("Bool")) {
                valores.add(n.hijos.get(0).nombre);
            }

        }
        for (int i = 0; i < n.hijos.size(); i++) {
            if (!n.hijos.get(i).hijos.isEmpty()) {
                ver_args(n.hijos.get(i));
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
                lista_errores_type.add("La variable  " + actual.hijos.get(0).valor + "  o La variable " + actual.hijos.get(2).valor + " no existe");

            } else {
                if (get_tipo(actual.hijos.get(0).valor).equals(get_tipo(actual.hijos.get(2).valor))) {
                    return 1;
                } else {
                    lista_errores_type.add("Las variables " + actual.hijos.get(0).valor + " y " + actual.hijos.get(2).valor + " de la condicion no son iguales de tipos");
                }
            }

        } else if (actual.hijos.get(0).nombre.equals("IDENTIFICADOR") && actual.hijos.get(2).nombre.equals("Int")) {
            if (existe(actual.hijos.get(0).valor) == 0) {
                lista_errores_type.add("La variable " + actual.hijos.get(0).valor + " no existe");
            } else if (existe(actual.hijos.get(0).valor) == 1) {
                if (get_tipo(actual.hijos.get(0).valor).equals("Int")) {
                    return 1;
                } else {
                    lista_errores_type.add("La variable " + actual.hijos.get(0).valor + " y el valor " + actual.hijos.get(2).valor + " de la condicion no son iguales de tipos");
                }
            }

        } else if (actual.hijos.get(0).nombre.equals("Int") && actual.hijos.get(2).nombre.equals("IDENTIFICADOR")) {
            if (existe(actual.hijos.get(2).valor) == 0) {
                lista_errores_type.add("la variable " + actual.hijos.get(2).valor + " no existe");
            } else if (existe(actual.hijos.get(2).valor) == 1) {
                if (get_tipo(actual.hijos.get(2).valor).equals("Int")) {
                    return 1;
                } else {
                    lista_errores_type.add("El valor " + actual.hijos.get(0).valor + " y la variable " + actual.hijos.get(2).valor + " de la condicion no son iguales de tipos");
                }
            }

        } else if (actual.hijos.get(0).nombre.equals("IDENTIFICADOR") && actual.hijos.get(2).nombre.equals("Float")) {
            if (existe(actual.hijos.get(0).valor) == 0) {
                lista_errores_type.add("La variable " + actual.hijos.get(0).valor + " no existe");
            } else if (existe(actual.hijos.get(0).valor) == 1) {
                if (get_tipo(actual.hijos.get(0).valor).equals("Float")) {
                    return 1;
                } else {
                    lista_errores_type.add("La variable " + actual.hijos.get(0).valor + " y el valor" + actual.hijos.get(2).valor + " de la condicion no son iguales de tipos");
                }
            }

        } else if (actual.hijos.get(0).nombre.equals("Float") && actual.hijos.get(2).nombre.equals("IDENTIFICADOR")) {
            if (existe(actual.hijos.get(2).valor) == 0) {
                lista_errores_type.add("La variable " + actual.hijos.get(2).valor + "no existe");
            } else {
                if (get_tipo(actual.hijos.get(2).valor).equals("Float")) {
                    return 1;
                } else {
                    lista_errores_type.add("El valor " + actual.hijos.get(0).valor + " y la variable " + actual.hijos.get(2).valor + " de la condicion no son iguales de tipos");
                }
            }
        } else if (actual.hijos.get(0).nombre.equals("IDENTIFICADOR") && actual.hijos.get(2).nombre.equals("String")) {
            if (existe(actual.hijos.get(0).valor) == 0) {
                lista_errores_type.add("La variable " + actual.hijos.get(0).valor + " no existe");
            } else if (existe(actual.hijos.get(0).valor) == 1) {
                if (get_tipo(actual.hijos.get(0).valor).equals("String")) {
                    return 1;
                } else {
                    lista_errores_type.add("La variable " + actual.hijos.get(0).valor + " y el valor" + actual.hijos.get(2).valor + " de la condicion no son iguales de tipos");
                }
            }

        } else if (actual.hijos.get(0).nombre.equals("String") && actual.hijos.get(2).nombre.equals("IDENTIFICADOR")) {
            if (existe(actual.hijos.get(2).valor) == 0) {
                lista_errores_type.add("La variable " + actual.hijos.get(2).valor + "no existe");
            } else {
                if (get_tipo(actual.hijos.get(2).valor).equals("String")) {
                    return 1;
                } else {
                    lista_errores_type.add("El valor " + actual.hijos.get(0).valor + " y la variable " + actual.hijos.get(2).valor + " de la condicion no son iguales de tipos");
                }
            }
        } else {
            lista_errores_type.add("Los valores " + actual.hijos.get(0).valor + " y " + actual.hijos.get(2).valor + " de la condicion no son iguales de tipos");
        }
        return 0;
    }

    public static void agregar(Entry e) {
        boolean verifica = false;
        for (int i = 0; i < lista_tabla_simbolos.size(); i++) {
            if (e.id.equals(lista_tabla_simbolos.get(i).id)) {
                if (ambito.contains(lista_tabla_simbolos.get(i).ambito)) {
                    verifica = true;
                    break;
                }
            }

        }
        if (verifica == true) {
            //System.out.println("la variable " + e.id + " ya fue declarada");
            lista_errores_type.add("la variable " + e.id + " ya fue declarada");
        } else {
            lista_tabla_simbolos.add(e);
            //offset += getSize(e.tipo);
            offset += e.tipo.length();

        }

    }

    public static void adParametro(Node n) {
        if (n.nombre.equals("parametro")) {
            agregar(new Entry(n.hijos.get(1).valor, n.hijos.get(0).hijos.get(0).valor, "", offset, true));
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
                    lista_errores_type.add("La variable " + n.hijos.get(0).valor + " no existe");
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
                            lista_errores_type.add("La variable " + t3.valor + " no existe");
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
            if (t.nombre.equals("llamar metodo")) {
                if (existe(t.hijos.get(0).valor) == 1) {
                    return get_tipo(t.hijos.get(0).valor);
                } else {
                    lista_errores_type.add("El metodo " + t.hijos.get(0).valor + " no existe");
                }
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
                                lista_errores_type.add("La variable " + t3.valor + " no existe");
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
                    lista_errores_type.add("La variable " + n.hijos.get(0).valor + " no existe");
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
        for (int i = 0; i < lista_tabla_simbolos.size(); i++) {
            if (s.equals(lista_tabla_simbolos.get(i).id)) {
                return 1;
            }
        }
        return 0;
    }

    public static String get_tipo(String s) {
        for (int i = 0; i < lista_tabla_simbolos.size(); i++) {
            if (s.equals(lista_tabla_simbolos.get(i).id)) {
                return lista_tabla_simbolos.get(i).tipo;
            }
        }
        return "";
    }
    
    public static void analizar() throws IOException {
        llenar_tabla_simbolos(root);
        validarOperaciones(root);

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////------------ Codigo intermedio-----------------------------------------------------------

    public static void funcion_cuadruplos(Node root) {
        boolean skip = false;
        boolean main = false;
        boolean code_block = false;
        boolean falta = false;
        boolean func = false;
        if (root.nombre.equals("sentencias") && root.hijos.size() > 1) {
            if (root.hijos.get(1).nombre.equals("While")
                    || root.hijos.get(1).nombre.equals("If")
                    || root.hijos.get(1).nombre.equals("FOR")
                    || root.hijos.get(1).nombre.equals("switch")) {
                code_block = true;
                root.siguiente = etiqueta_nueva();
                root.hijos.get(1).siguiente = root.siguiente;
            }
        } else if (root.nombre.equals("sentencias") && root.hijos.size() == 1) {
            if (root.hijos.get(0).nombre.equals("While")
                    || root.hijos.get(0).nombre.equals("If")
                    || root.hijos.get(0).nombre.equals("FOR")
                    || root.hijos.get(0).nombre.equals("switch")) {
                code_block = true;
                root.siguiente = etiqueta_nueva();
                root.hijos.get(0).siguiente = root.siguiente;
            }
        }
        if (root.nombre.equals("While")) {
            skip = true;
            root.comienzo = etiqueta_nueva();
            lista_cuadruplos.add(new Cuadruplo("ETIQ", root.comienzo, "", ""));
            root.hijos.get(0).verdadera = etiqueta_nueva();
            root.hijos.get(0).falsa = root.siguiente;
            codigoBooleans(root.hijos.get(0));
            lista_cuadruplos.add(new Cuadruplo("ETIQ", root.hijos.get(0).verdadera, "", ""));
            root.hijos.get(1).siguiente = root.comienzo;
            funcion_cuadruplos(root.hijos.get(1));
            lista_cuadruplos.add(new Cuadruplo("GOTO", root.comienzo, "", ""));
        } else if (root.nombre.equals("IMPRIMIR")) {
            if (root.hijos.get(0).nombre.equals("String")) {
                lista_cuadruplos.add(new Cuadruplo("print", root.hijos.get(0).valor, "String", ""));
            } else if (root.hijos.get(0).nombre.equals("IDENTIFICADOR")) {
                codigoOpcionales(root.hijos.get(0));
                lista_cuadruplos.add(new Cuadruplo("print", root.hijos.get(0).valor, get_tipo2(root.hijos.get(0).nombre), ""));
                System.out.println("entroo 2");
            }
        } else if (root.nombre.equals("Main")) {
            main = true;
        } else if (root.nombre.equals("FOR")) {
            skip = true;
            lista_cuadruplos.add(new Cuadruplo("=", "0", "", root.hijos.get(1).valor));
            root.comienzo = etiqueta_nueva();
            lista_cuadruplos.add(new Cuadruplo("ETIQ", root.comienzo, "", ""));
            codigoOpcionales(root.hijos.get(4).hijos.get(2));
            String verdadera = etiqueta_nueva();
            String signo = root.hijos.get(4).hijos.get(1).valor;
            lista_cuadruplos.add(new Cuadruplo("if" + signo, root.hijos.get(4).hijos.get(0).valor, root.hijos.get(4).hijos.get(2).lugar, verdadera));
            lista_cuadruplos.add(new Cuadruplo("GOTO", root.siguiente, "", ""));
            root.asig = etiqueta_nueva();
            root.hijos.get(5).siguiente = root.asig;
            lista_cuadruplos.add(new Cuadruplo("ETIQ", verdadera, "", ""));
            funcion_cuadruplos(root.hijos.get(5));
            lista_cuadruplos.add(new Cuadruplo("ETIQ", root.asig, "", ""));
            String temp = tempporal_nuevo();
            lista_cuadruplos.add(new Cuadruplo("+", root.hijos.get(1).valor, "1", temp));
            lista_cuadruplos.add(new Cuadruplo("=", temp, "", root.hijos.get(1).valor));
            lista_cuadruplos.add(new Cuadruplo("GOTO", root.comienzo, "", ""));

        } else if (root.nombre.equals("switch")) {
            skip = true;
            opcionesID = root.hijos.get(0).valor;
            padre_opciones = root.hijos.get(1);
            padre_opciones.comienzo = etiqueta_nueva();
            root.hijos.get(1).hijos.get(0).siguiente = root.siguiente;
            opciones_switch(root.hijos.get(1).hijos.get(0));

        } else if (root.nombre.equals("Return")) {
            Node temp = root.hijos.get(0).hijos.get(0).hijos.get(0).hijos.get(0).hijos.get(0);
            codigoOpcionales(temp);
            lista_cuadruplos.add(new Cuadruplo("Return", temp.lugar, "", ""));
        } else if (root.nombre.equals("Entrada")) {
            lista_cuadruplos.add(new Cuadruplo("Read", "", "", root.hijos.get(0).valor));
        } else if (root.nombre.equals("asig")) {
            if (root.hijos.size() == 4 && root.hijos.get(3).nombre.equals("op")) {
                lista_cuadruplos.add(new Cuadruplo("=", root.hijos.get(3).hijos.get(0).hijos.get(0).hijos.get(0).valor, "", root.hijos.get(1).valor));
            }
            if (root.hijos.size() == 4
                    && (root.hijos.get(3).nombre.equals("String") || root.hijos.get(3).nombre.equals("Bool"))) {
                lista_cuadruplos.add(new Cuadruplo("=", root.hijos.get(3).valor, "", root.hijos.get(1).valor));
            }
        }/*else if (root.nombre.equals("asignar") && root.hijos.get(2).nombre.equals("TIPO") ) {
            if (root.hijos.get(2).hijos.get(0).equals("")) {
                 
            }else{
                lista_cuadruplos.add(new Cuadruplo("=",root.hijos.get(2).hijos.get(0).hijos.get(0).hijos.get(0).hijos.get(0).valor , "", root.hijos.get(0).valor));
            }*/ else if (root.nombre.equals("asignar") && root.hijos.get(2).nombre.equals("TIPO")) {
            if (root.hijos.get(2).hijos.get(0).nombre.equals("llamar metodo")) {
                agregar_parametros(root.hijos.get(2).hijos.get(0));
                lista_cuadruplos.add(new Cuadruplo("call", root.hijos.get(2).hijos.get(0).hijos.get(0).valor, "", ""));
                lista_cuadruplos.add(new Cuadruplo("=", "RET", root.hijos.get(0).valor, ""));
            } else if (root.hijos.get(2).hijos.get(0).nombre.equals("op")) {
                lista_cuadruplos.add(new Cuadruplo("=", root.hijos.get(2).hijos.get(0).hijos.get(0).hijos.get(0).hijos.get(0).valor, "", root.hijos.get(0).valor));
            }
        } else if (root.nombre.equals("If")) {
            skip = true;
            if (root.hijos.size() > 1) {
                if (root.hijos.size() == 2) {
                    root.hijos.get(0).verdadera = etiqueta_nueva();
                    root.hijos.get(0).falsa = root.siguiente;
                    codigoBooleans(root.hijos.get(0));
                    lista_cuadruplos.add(new Cuadruplo("ETIQ", root.hijos.get(0).verdadera, "", ""));
                    root.hijos.get(1).siguiente = root.siguiente;
                    funcion_cuadruplos(root.hijos.get(1));
                } else if (root.hijos.size() == 3 && root.hijos.get(1).nombre.equals("sentencias")) {
                    //solo if
                    root.hijos.get(0).verdadera = etiqueta_nueva();
                    root.hijos.get(0).falsa = root.siguiente;
                    codigoBooleans(root.hijos.get(0));
                    lista_cuadruplos.add(new Cuadruplo("ETIQ", root.hijos.get(0).verdadera, "", ""));
                    root.hijos.get(1).siguiente = root.siguiente;
                    funcion_cuadruplos(root.hijos.get(1));
                } else {
                    //if con else o else if
                    root.hijos.get(0).verdadera = etiqueta_nueva();
                    root.hijos.get(0).falsa = etiqueta_nueva();
                    codigoBooleans(root.hijos.get(0));
                    lista_cuadruplos.add(new Cuadruplo("ETIQ", root.hijos.get(0).verdadera, "", ""));
                    root.hijos.get(1).siguiente = root.siguiente;
                    padre.hijos.get(1).siguiente = padre.siguiente;
                    funcion_cuadruplos(root.hijos.get(1));
                    lista_cuadruplos.add(new Cuadruplo("GOTO", root.siguiente, "", ""));
                    lista_cuadruplos.add(new Cuadruplo("ETIQ", root.hijos.get(0).falsa, "", ""));
                }
            }
        }
        for (int i = 0; i < root.hijos.size(); i++) {
            if (code_block) {
                if (i == root.hijos.size() - 1 && !root.hijos.get(i).nombre.equals("sentencias")) {
                    falta = true;
                }
            }
            if (!skip) {
                funcion_cuadruplos(root.hijos.get(i));
            }
            if (main && root.hijos.get(i).nombre.equals("sentencias")) {
                lista_cuadruplos.add(new Cuadruplo("MAIN_ETIQ", "Main", "", ""));
            }
            if (main) {
                lista_cuadruplos.add(new Cuadruplo("P_ETIQ", "fin_main", "", ""));
            }
        }

        if (falta) {
            lista_cuadruplos.add(new Cuadruplo("ETIQ", root.siguiente, "", ""));
        }
    }

    public static void agregar_parametros(Node n) {
        if (n.nombre.equals("Valoro")) {
            lista_cuadruplos.add(new Cuadruplo("Param", n.hijos.get(0).valor, "", ""));
        }

        for (int i = 0; i < n.hijos.size(); i++) {
            if (!n.hijos.get(i).hijos.isEmpty()) {
                agregar_parametros(n.hijos.get(i));
            }
        }
    }

    public static void codigoBooleans(Node root) {
        if (root.nombre.equals("PROPOSICION") && root.hijos.get(0).nombre.equals("Bool")) {
            String salto = "";
            if (root.hijos.get(0).valor.contains("true")) {
                salto = root.verdadera;
            } else {
                salto = root.falsa;
            }
            lista_cuadruplos.add(new Cuadruplo("GOTO", salto, "", ""));
        } else if (root.nombre.equals("PROPOSICION") && root.hijos.get(0).nombre.equals("PROPOSICION1") && root.hijos.get(0).hijos.size() > 1) {
            codigoOpcionales(root.hijos.get(0).hijos.get(0));
            codigoOpcionales(root.hijos.get(0).hijos.get(2));
            String val = "if " + root.hijos.get(0).hijos.get(1).valor;
            lista_cuadruplos.add(new Cuadruplo(val, root.hijos.get(0).hijos.get(0).lugar, root.hijos.get(0).hijos.get(2).lugar, root.verdadera));
            lista_cuadruplos.add(new Cuadruplo("GOTO", root.falsa, "", ""));
        } else if (root.nombre.equals("PROPOSICION") && root.hijos.get(0).hijos.get(0).nombre.equals("PROPOSICION1-2")) {
            codigoOpcionales(root.hijos.get(0).hijos.get(0).hijos.get(0));
            codigoOpcionales(root.hijos.get(0).hijos.get(0).hijos.get(2));
            String val = "if " + root.hijos.get(0).hijos.get(0).hijos.get(1).valor;
            lista_cuadruplos.add(new Cuadruplo(val, root.hijos.get(0).hijos.get(0).hijos.get(0).lugar, root.hijos.get(0).hijos.get(0).hijos.get(2).lugar, root.verdadera));
            lista_cuadruplos.add(new Cuadruplo("GOTO", root.falsa, "", ""));
        } else if (root.nombre.equals("PROPOSICION") && root.hijos.get(0).nombre.equals("PROPOSICION2")) {
            if (root.hijos.get(0).hijos.get(1).valor.equals("And")) {
                root.hijos.get(0).hijos.get(0).verdadera = etiqueta_nueva();
                root.hijos.get(0).hijos.get(0).falsa = root.siguiente;
                codigoBooleans(root.hijos.get(0).hijos.get(0));
                lista_cuadruplos.add(new Cuadruplo("ETIQ", root.hijos.get(0).hijos.get(0).verdadera, "", ""));
                root.hijos.get(0).hijos.get(2).verdadera = root.verdadera;
                root.hijos.get(0).hijos.get(2).falsa = root.falsa;
                codigoBooleans(root.hijos.get(0).hijos.get(2));
            } else if (root.hijos.get(0).hijos.get(1).valor.equals("Or")) {
                root.hijos.get(0).hijos.get(0).verdadera = root.verdadera;
                root.hijos.get(0).hijos.get(0).falsa = etiqueta_nueva();
                codigoBooleans(root.hijos.get(0).hijos.get(0));
                lista_cuadruplos.add(new Cuadruplo("ETIQ", root.hijos.get(0).hijos.get(0).falsa, "", ""));
                root.hijos.get(0).hijos.get(2).verdadera = root.verdadera;
                root.hijos.get(0).hijos.get(2).falsa = root.falsa;
                codigoBooleans(root.hijos.get(0).hijos.get(2));
            }
        } else if (root.nombre.equals("PROPOSICION1")) {
            if (root.hijos.size() > 1) {
                codigoOpcionales(root.hijos.get(0));
                codigoOpcionales(root.hijos.get(2));
                String val = "if " + root.hijos.get(1).valor;
                lista_cuadruplos.add(new Cuadruplo(val, root.hijos.get(0).lugar, root.hijos.get(2).lugar, root.verdadera));
                lista_cuadruplos.add(new Cuadruplo("GOTO", root.falsa, "", ""));
            } else if (root.hijos.get(0).nombre.equals("PROPOSICION1-2")) {
                codigoOpcionales(root.hijos.get(0).hijos.get(0));
                codigoOpcionales(root.hijos.get(0).hijos.get(2));
                String val = "if " + root.hijos.get(0).hijos.get(1).valor;
                lista_cuadruplos.add(new Cuadruplo(val, root.hijos.get(0).hijos.get(0).lugar, root.hijos.get(0).hijos.get(2).lugar, root.verdadera));
                lista_cuadruplos.add(new Cuadruplo("GOTO", root.falsa, "", ""));
            }
        } else if (root.nombre.equals("PROPOSICION2")) {
            if (root.hijos.get(0).nombre.equals("PROPOSICION1") && root.hijos.get(0).hijos.size() > 1) {
                codigoOpcionales(root.hijos.get(0).hijos.get(0));
                codigoOpcionales(root.hijos.get(0).hijos.get(2));
                String val = "if " + root.hijos.get(0).hijos.get(1).valor;
                lista_cuadruplos.add(new Cuadruplo(val, root.hijos.get(0).hijos.get(0).lugar, root.hijos.get(0).hijos.get(2).lugar, root.verdadera));
                lista_cuadruplos.add(new Cuadruplo("GOTO", root.hijos.get(0).falsa, "", ""));
            } else if (root.hijos.get(0).nombre.equals("PROPOSICION1") && root.hijos.get(0).hijos.get(0).nombre.equals("PROPOSICION1-2")) {
                codigoOpcionales(root.hijos.get(0).hijos.get(0).hijos.get(0));
                codigoOpcionales(root.hijos.get(0).hijos.get(0).hijos.get(2));
                String val = "if " + root.hijos.get(0).hijos.get(0).hijos.get(1).valor;
                lista_cuadruplos.add(new Cuadruplo(val, root.hijos.get(0).hijos.get(0).hijos.get(0).lugar, root.hijos.get(0).hijos.get(0).hijos.get(2).lugar, root.verdadera));
                lista_cuadruplos.add(new Cuadruplo("GOTO", root.hijos.get(0).hijos.get(0).falsa, "", ""));
            }
        }
    }

    public static void codigoOpcionales(Node root) {
        for (int i = 0; i < root.hijos.size(); i++) {
            codigoOpcionales(root.hijos.get(i));
        }
        boolean funcion = false;
        if (root.nombre.equals("ID")) {
            String type = get_tipo2(root.valor);
            //verificar
            if (type.contains("->")) {
                funcion = true;
            }
        }
        //////////////////
        if (root.nombre.equals("Int") || root.nombre.equals("IDENTIFICADOR") && root.hijos.size() == 0
                && !funcion || root.nombre.equals("String") || root.nombre.equals("Bool")) {
            root.lugar = root.valor;
        } else if (root.valor.equals("*")) {
            root.lugar = tempporal_nuevo();
            lista_cuadruplos.add(new Cuadruplo("*", root.hijos.get(0).lugar, root.hijos.get(1).lugar, root.lugar));
        } else if (root.valor.equals("/")) {
            root.lugar = tempporal_nuevo();
            lista_cuadruplos.add(new Cuadruplo("/", root.hijos.get(0).lugar, root.hijos.get(1).lugar, root.lugar));
        } else if (root.valor.equals("+")) {
            root.lugar = tempporal_nuevo();
            lista_cuadruplos.add(new Cuadruplo("+", root.hijos.get(0).lugar, root.hijos.get(1).lugar, root.lugar));
        } else if (root.valor.equals("-")) {
            root.lugar = tempporal_nuevo();
            lista_cuadruplos.add(new Cuadruplo("-", root.hijos.get(0).lugar, root.hijos.get(1).lugar, root.lugar));
        } else if (root.nombre.equals("IDENTIFICADOR")) {
            String tipo = get_tipo2(root.valor);
            if (tipo.contains("array")) {
                String t = tempporal_nuevo();
                String tip = tipo.substring(tipo.indexOf("_") + 1, tipo.indexOf("{"));
                int tam = tip.length();
                String sz = "" + tam;
                lista_cuadruplos.add(new Cuadruplo("*", root.hijos.get(0).lugar, sz, t));
                root.lugar = tempporal_nuevo();
                lista_cuadruplos.add(new Cuadruplo("=[]", root.valor, t, root.lugar));
            } else if (tipo.contains("matrix")) {
                if (!root.hijos.get(0).nombre.equals("LISTA POSICIONES")) {
                    //NO FUE CUBIERTAA ASIGNAR UN ARRAY ENTERO DE UN SOLO A UNA MATRIZ
                } else {
                    String t = tempporal_nuevo();
                    String col = tipo.substring(tipo.indexOf("{") + 3, tipo.indexOf("}"));
                    lista_cuadruplos.add(new Cuadruplo("*", root.hijos.get(0).hijos.get(0).lugar, col, t));
                    String t1 = tempporal_nuevo();
                    lista_cuadruplos.add(new Cuadruplo("+", t, root.hijos.get(0).hijos.get(1).lugar, t1));
                    String t2 = tempporal_nuevo();
                    String tip = tipo.substring(tipo.indexOf("_") + 1, tipo.indexOf("{"));
                    int tam = tip.length();
                    String sz = "" + tam;
                    lista_cuadruplos.add(new Cuadruplo("*", t1, sz, t2));
                    root.lugar = tempporal_nuevo();
                    lista_cuadruplos.add(new Cuadruplo("=[]", root.valor, t2, root.lugar));
                }
            } else {
                //FUNCION
                /*if (root.hijos.size() == 0) {
                    lista_cuadruplos.add(new Cuadruplo("call", root.valor, "0", ""));
                    root.lugar = tempporal_nuevo();
                    lista_cuadruplos.add(new Cuadruplo("=", "RET", "", root.lugar));
                } else {
                    cantparam = 0;
                    params2(root, root.valor);
                    String cant = "" + cantparam;
                    lista_cuadruplos.add(new Cuadruplo("call", root.valor, cant, ""));
                    root.lugar = tempporal_nuevo();
                    lista_cuadruplos.add(new Cuadruplo("=", "RET", "", root.lugar));
                }*/
            }
        }
        /////////////////////////////
    }

    public static String tempporal_nuevo() {
        String r = "t" + temporales;
        temporales = temporales + 1;
        return r;
    }

    public static String etiqueta_nueva() {
        String r = "etiq" + etiquetas;
        etiquetas = etiquetas + 1;
        return r;
    }

    public static String get_tipo2(String s) {
        for (int i = 0; i < lista_tabla_simbolos.size(); i++) {
            if (s.equals(lista_tabla_simbolos.get(i).id)) {
                return lista_tabla_simbolos.get(i).tipo;
            }
        }
        return "";
    }

    public static void opciones_switch(Node root) {
        System.out.println("ok");
        if (root.nombre.equals("caseE")) {
            System.out.println("si entra casee");
            lista_cuadruplos.add(new Cuadruplo("ETIQ", padre_opciones.comienzo, "", ""));
            root.verdadera = etiqueta_nueva();
            codigoOpcionales(root.hijos.get(0));
            lista_cuadruplos.add(new Cuadruplo("if ==", opcionesID, root.hijos.get(0).valor, root.verdadera));
            root.comienzo = etiqueta_nueva();
            lista_cuadruplos.add(new Cuadruplo("GOTO", root.comienzo, "", ""));
            root.hijos.get(1).siguiente = root.siguiente;
            lista_cuadruplos.add(new Cuadruplo("ETIQ", root.verdadera, "", ""));
            funcion_cuadruplos(root.hijos.get(1));
            lista_cuadruplos.add(new Cuadruplo("GOTO", root.siguiente, "", ""));
            padre_opciones = root;
            if (root.hijos.size() == 3) {
                root.hijos.get(2).siguiente = root.siguiente;
                opciones_switch(root.hijos.get(2));
            } else if (root.hijos.size() == 2) {
                root.hijos.get(1).siguiente = root.siguiente;
            }

        } else if (root.nombre.equals("caseC")) {
            System.out.println("si entra casec");
            lista_cuadruplos.add(new Cuadruplo("ETIQ", padre_opciones.comienzo, "", ""));
            root.verdadera = etiqueta_nueva();
            codigoOpcionales(root.hijos.get(0));
            lista_cuadruplos.add(new Cuadruplo("if ==", opcionesID, root.hijos.get(0).lugar, root.verdadera));
            root.comienzo = etiqueta_nueva();
            lista_cuadruplos.add(new Cuadruplo("GOTO", root.comienzo, "", ""));
            root.hijos.get(1).siguiente = root.siguiente;
            lista_cuadruplos.add(new Cuadruplo("ETIQ", root.verdadera, "", ""));
            funcion_cuadruplos(root.hijos.get(1));
            lista_cuadruplos.add(new Cuadruplo("GOTO", root.siguiente, "", ""));
            padre_opciones = root;
        } else {
            lista_cuadruplos.add(new Cuadruplo("ETIQ", padre_opciones.comienzo, "", ""));
            root.hijos.get(0).siguiente = root.siguiente;
            funcion_cuadruplos(root.hijos.get(0));
            //bloque default options
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
    private javax.swing.JButton boton_intermedio;
    private javax.swing.JButton boton_simbolos;
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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JDialog jpanel2;
    private javax.swing.JTree jtree;
    private javax.swing.JTextArea ta_intermedio;
    private javax.swing.JTextArea ta_simbolos;
    private javax.swing.JTextArea txtAnalizarSin;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
    public static Node root;
    DefaultMutableTreeNode arbol;
    public static ArrayList<Entry> lista_tabla_simbolos = new ArrayList<Entry>();
    public static ArrayList<String> ids, ids2;
    public static ArrayList<String> lista_tipos_matrix, lista_errores_type = new ArrayList<String>();
    public static ArrayList<String> valores = new ArrayList();
    //ambito
    public static int ambito_cont = 0, ambito_control = -1, offset = 0;
    public static String ambito = "";
    public static boolean activo = true;
    public static int temporales = 0, cantparam = 0, etiquetas = 0;
    public static ArrayList<String> lista_mensajes = new ArrayList<String>();
    public static Node padre, padre_opciones;
    public static String opcionesID = "";
    public static ArrayList<Cuadruplo> lista_cuadruplos = new ArrayList<Cuadruplo>();

}
