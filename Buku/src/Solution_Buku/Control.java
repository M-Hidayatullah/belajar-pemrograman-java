package Solution_Buku;
   
import Problem_Buku.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




public class Control implements control_interface{

    String[] header = {"KODE BUKU", "JUDUL BUKU", "JENIS BUKU","HARGA", "PENULIS", "PENERBIT", "TAHUN TERBIT"};

    private ArrayList<model> list = new ArrayList();

    @Override
    public void read(JTable bc) {
           DefaultTableModel dtm = new DefaultTableModel(null, header);

        for (int i = 0; i < list.size(); i++) {
            Object[] oj = new Object[7];
            oj[0] = list.get(i).getKODE_BUKU();
            oj[1] = list.get(i).getJUDUL_BUKU();
            oj[2] = list.get(i).getJENIS_BUKU();
            oj[3] = list.get(i).getHARGA();
            oj[4] = list.get(i).getPENULIS();
            oj[5] = list.get(i).getPENERBIT();
            oj[6] = list.get(i).getTAHUN_TERBIT();
            dtm.addRow(oj);

        }

        bc.setModel(dtm);
    }

    @Override
    public void create(Solution_Buku.model br) {
     list.add(br);
        JOptionPane.showMessageDialog(null, "Succesfully saved!");
    }

    @Override
    public void update(Solution_Buku.model br) {
        for (int i = 0; i < list.size(); i++) {
            if (br.getKODE_BUKU() == list.get(i).getKODE_BUKU()) {
                list.set(i, br);
            }
        }

        JOptionPane.showMessageDialog(null, "Succesfully changed!");
    }
    

    @Override
    public void delete(String JUDUL_BUKU) {
         for (int i = 0; i < list.size(); i++) {
            if (JUDUL_BUKU == list.get(i).getJUDUL_BUKU()) {
                list.remove(i);
            }
        }

        JOptionPane.showMessageDialog(null, "Succesfully deleted!");
    }
    

    public boolean search(JTable bc, String JUDUL_BUKU) {
        DefaultTableModel dtm = new DefaultTableModel(null, header);

        boolean Counter = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getJUDUL_BUKU().equalsIgnoreCase(JUDUL_BUKU.trim())) {
                Object[] oj = new Object[7];
           oj[0] = list.get(i).getKODE_BUKU();
            oj[1] = list.get(i).getJUDUL_BUKU();
            oj[2] = list.get(i).getJENIS_BUKU();
            oj[3] = list.get(i).getHARGA();
            oj[4] = list.get(i).getPENULIS();
            oj[5] = list.get(i).getPENERBIT();
            oj[6] = list.get(i).getTAHUN_TERBIT();
                dtm.addRow(oj);

                bc.setModel(dtm);

                Counter = true;

                break;
            }

        }

        if (Counter) {
            return true;
        }

        return false;

    }

    
    
}

    
    
    
    
