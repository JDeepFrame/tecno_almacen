package tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import models.MovimientoInventario;

public class MovimientoTableModel extends AbstractTableModel {
    
    private final String[] cols = {"ID", "Producto", "Tipo", "Cantidad"};
    private List<MovimientoInventario> data;

    public MovimientoTableModel(List<MovimientoInventario> data) {
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
        MovimientoInventario m = data.get(r);
        switch (c) {
            case 0: return m.getIdMovimiento();
            case 1:
                // devuelve nombre del producto si está mapeado; si es null, muestra "-"
                return m.getIdProducto() != null ? m.getIdProducto().getNombre() : "-";
            case 2: return m.getTipoMovimiento();
            case 3: return m.getCantidad();
            default: return "";
        }
    }

    public void update(List<MovimientoInventario> nuevaLista) {
        this.data = nuevaLista;
        fireTableDataChanged();
    }
    
    public models.MovimientoInventario get(int row) {
    if (data == null || row < 0 || row >= data.size()) return null;
    return data.get(row);
    }
}
