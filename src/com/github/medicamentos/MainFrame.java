package com.github.medicamentos;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.AbstractListModel;
import javax.swing.border.LineBorder;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class MainFrame extends javax.swing.JFrame {

    private final Connection con;
    private final List<String> medicamentos;

    public MainFrame(Connection con) {
        this.con = con;
        medicamentos = getMedicamentos();
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jList1.setBorder(new LineBorder(Color.LIGHT_GRAY));
        painelChart = new javax.swing.JPanel();
        barChart1 = new com.github.medicamentos.components.BarChart();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(750, 600));

        jPanel5.setBackground(java.awt.Color.darkGray);

        jPanel1.setBackground(java.awt.Color.darkGray);
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 200));

        jPanel3.setBackground(java.awt.Color.darkGray);
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setBackground(java.awt.Color.darkGray);
        jPanel2.setPreferredSize(new java.awt.Dimension(522, 25));
        jPanel2.setLayout(new java.awt.CardLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pesquisar Produto");
        jLabel1.setAlignmentY(0.0F);
        jPanel2.add(jLabel1, "card2");

        jPanel3.add(jPanel2);

        txtProduto.setBackground(java.awt.Color.darkGray);
        txtProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtProduto.setForeground(new java.awt.Color(0, 255, 204));
        txtProduto.setBorder(null);
        txtProduto.setCaretColor(new java.awt.Color(255, 255, 255));
        txtProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtProduto.setMargin(new java.awt.Insets(2, 15, 2, 2));
        txtProduto.setPreferredSize(new java.awt.Dimension(2, 30));
        txtProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoActionPerformed(evt);
            }
        });
        txtProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProdutoKeyReleased(evt);
            }
        });
        jPanel3.add(txtProduto);

        jScrollPane1.setBackground(java.awt.Color.darkGray);
        jScrollPane1.setBorder(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(7, 250));

        jList1.setBackground(java.awt.Color.darkGray);
        jList1.setForeground(new java.awt.Color(0, 255, 204));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {" "};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jList1.setPreferredSize(new java.awt.Dimension(5, 250));
        jList1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jList1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel3.add(jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addContainerGap())
        );

        painelChart.setBackground(new java.awt.Color(255, 255, 255));
        painelChart.setLayout(new java.awt.CardLayout());

        barChart1.setChartColor(java.awt.Color.darkGray);
        barChart1.setChartLabelsColor(java.awt.Color.white);
        barChart1.setChartLabelsVisible(true);
        barChart1.setChartMarksColor(java.awt.Color.white);
        barChart1.setChartMarksVisible(true);
        barChart1.setChartSeriesColor(new java.awt.Color(0, 255, 204));
        barChart1.setChartTitle("");
        barChart1.setChartTitleColor(java.awt.Color.white);
        barChart1.setOpaque(false);
        painelChart.add(barChart1, "card2");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                        .addComponent(painelChart, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(painelChart, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void txtProdutoKeyReleased(java.awt.event.KeyEvent evt) {
        procurarProduto(txtProduto.getText());
    }

    private void txtProdutoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {
        generateChart(jList1.getSelectedValuesList());
    }

    // Variables declaration - do not modify                     
    private com.github.medicamentos.components.BarChart barChart1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelChart;
    private javax.swing.JTextField txtProduto;
    // End of variables declaration                   

    private void generateChart(List<String> list) {
        String query;
        if (list.size() == 1) {
            query = "SELECT "
                    + "extract(year from f.dtlancamento) as ANO,"
                    + "sum(abs(f.quantidade)) as TOTAL "
                    + " FROM ECUSCASTROLANDAFINANCEIRO f "
                    + "WHERE f.nmproduto = '" + list.get(0) + "' "
                    + "group by ANO ";
        } else {
            query = "SELECT "
                    + "extract(year from f.dtlancamento) as ANO,"
                    + "sum(abs(f.quantidade)) as TOTAL "
                    + " FROM ECUSCASTROLANDAFINANCEIRO f "
                    + "WHERE f.nmproduto = '' ";
            for (String m : list) {
                query = query.concat("or f.nmproduto = '" + m + "' ");
            }

            query = query.concat("group by ANO");

        }
        try {
            JDBCCategoryDataset dataSet = new JDBCCategoryDataset(con, query);
            barChart1.setData(dataSet);
            barChart1.setChartTitle(Arrays.toString(list.toArray()));

        } catch (Exception e) {
        }
    }

    private void procurarProduto(String text) {
        Stream<String> filter = medicamentos.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String t) {
                return t.toUpperCase().contains(text.toUpperCase());
            }
        });

        List<String> list = filter.collect(Collectors.toList());
        setModelList(list);

    }

    private void setModelList(List<String> list) {
        AbstractListModel<String> model = new AbstractListModel<String>() {
            @Override
            public int getSize() {
                return list.size();
            }

            @Override
            public String getElementAt(int i) {
                return list.get(i);
            }
        };
        jList1.setModel(model);
    }

    private List<String> getMedicamentos() {
        String sql = "select distinct f.nmproduto as PRODUTO from ecuscastrolandafinanceiro f ";

        try {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(sql);
            rs.first();
            List<String> produtos = new ArrayList<>();
            while (!rs.isAfterLast()) {
                String prod = rs.getString("PRODUTO");
                produtos.add(prod);
                rs.next();
            }
            return produtos;
        } catch (Exception e) {
            return null;
        }
    }

}
