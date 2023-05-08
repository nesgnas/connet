import org.example.connect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inte {
    private JPanel panel1;
    private JTextField text;
    private JTable showTable;
    private JButton button1;
    private JPanel rootPanel;

    public JPanel getRootPanel(){
        return rootPanel;
    }

public inte() {
    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String query;
            if (!text.getText().equals("")){
                query = text.getText();
                connect c = new connect();
                Object[][] data=c.logicData(query);
                Object [] arr = c.logicColum(query);
                showTable.setModel(new DefaultTableModel(data,arr));
            }
        }
    });
}
}
