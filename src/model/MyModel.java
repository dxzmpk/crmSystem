package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MyModel extends AbstractTableModel {



    private ArrayList<Contract> list = new ArrayList<Contract>();

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contract r = list.get(rowIndex);
        switch (columnIndex) {
            case 0: return r.contract_id;
            case 1: return r.contract_name;
            case 2: return r.customer_id_a;
            case 3: return r.customer_id_b;
            case 4: return r.contract_item_id;
            case 5: return r.product_amount;
            case 6: return r.activity_id;
        }
        return null;
    }

    public void addContract(Contract contract){
        list.add(contract);
        this.fireTableDataChanged();
    }


}
