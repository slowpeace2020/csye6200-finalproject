package edu.neu.csye6200.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Test {

  public static void simpleJTableExample(){
    String[] colTitles = new String[]{"A","B","C","E"};
    DefaultTableModel myTM = new DefaultTableModel();
    myTM.setColumnCount(colTitles.length);
    myTM.setColumnIdentifiers(colTitles);
    for(int i=0;i<8;i++){
      int j= 0+10*i;
      int k=3+10*i;
      char c3 = (char) (0x41+i);
      double d4 = 1.0+10*i;
      myTM.addRow(new Object[]{j,k,c3,d4});
    }

    JTable table = new JTable();
    table.setModel(myTM);
    table.setAutoCreateRowSorter(true);
    JFrame frame = new JFrame("Pop-up Table Example");
    frame.add(new JScrollPane(table));
    frame.setSize(300,100);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    List<String> lines = new ArrayList<>();
    lines.add("1,abc,234,ABC,3.14,end");
    lines.forEach(System.out::println);
    for(String line:lines){
      Scanner in = new Scanner(line);
      in.useDelimiter(",");
      int a = in.nextInt();
      String b = in.next();
      int c = in.nextInt();
      String d = in.next();
      double e = in.nextDouble();
      in.close();
    }
  }
}
