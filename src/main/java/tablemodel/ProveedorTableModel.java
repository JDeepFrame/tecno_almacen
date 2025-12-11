package tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import models.Proveedor;

public class ProveedorTableModel extends AbstractTableModel {
    
    private final String[] cols = {"ID", "Nombre", "RUC", "Teléfono"};
    private List<Proveedor> data;

    public ProveedorTableModel(List<Proveedor> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() { return data == null ? 0 : data.size(); }

    @Override
    public int getColumnCount() { return cols.length; }

    @Override
    public String getColumnName(int c) { return cols[c]; }

    @Override
    public Object getValueAt(int r, int c) {
        Proveedor p = data.get(r);
        return switch (c) {
            case 0 -> p.getIdProveedor();
            case 1 -> p.getNombre();
            case 2 -> p.getRuc();
            case 3 -> p.getTelefono();
            default -> "";
        };
    }

    public void update(List<Proveedor> nuevaLista) {
        this.data = nuevaLista;
        fireTableDataChanged();
    }
    
    public models.Proveedor get(int row) {
    if (data == null || row < 0 || row >= data.size()) return null;
    return data.get(row);
    }
}
