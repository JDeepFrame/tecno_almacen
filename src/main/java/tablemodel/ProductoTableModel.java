package tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import models.Producto;

public class ProductoTableModel extends AbstractTableModel {
    
    private final String[] cols = {"ID", "Nombre", "Precio", "Stock"};
    private List<Producto> data;

    public ProductoTableModel(List<Producto> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() { return data.size(); }

    @Override
    public int getColumnCount() { return cols.length; }

    @Override
    public String getColumnName(int c) { return cols[c]; }

    @Override
    public Object getValueAt(int r, int c) {
        Producto p = data.get(r);
        return switch (c) {
            case 0 -> p.getIdProducto();
            case 1 -> p.getNombre();
            case 2 -> p.getPrecioUnitario();
            case 3 -> p.getStockActual();
            default -> "";
        };
    }

    public Producto get(int row) { return data.get(row); }

    public void update(List<Producto> nuevaLista) {
        this.data = nuevaLista;
        fireTableDataChanged();
    }
    
    // dentro de clase ProductoTableModel
    public models.Producto getProductoAt(int row) {
        if (data == null || row < 0 || row >= data.size()) return null;
        return data.get(row);
    }
}
