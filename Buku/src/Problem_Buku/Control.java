package Problem_Buku;
   
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




public class Control {

    String[] header = {"KODE BUKU", "JUDUL BUKU", "JENIS BUKU","HARGA", "PENULIS", "PENERBIT", "TAHUN TERBIT"};

    private ArrayList<model> list = new ArrayList();

//  untuk menampilkan data pada tabel
    public void read(JTable bc) {
        DefaultTableModel dtm = new DefaultTableModel(null, header);

        for (int i = 0; i < list.size(); i++) {
            Object[] ob = new Object[7];
            ob[0] = list.get(i).getKODE_BUKU();
            ob[1] = list.get(i).getJUDUL_BUKU();
            ob[2] = list.get(i).getJENIS_BUKU();
            ob[3] = list.get(i).getHARGA();
            ob[4] = list.get(i).getPENULIS();
            ob[5] = list.get(i).getPENERBIT();
            ob[6] = list.get(i).getTAHUN_TERBIT();
            dtm.addRow(ob);

        }

        bc.setModel(dtm);
    }

//  untuk menambahkan data
    public void create(model br) {
        list.add(br);
        JOptionPane.showMessageDialog(null, "Succesfully saved!");
    }

//  untuk ubah data
    public void update(model br) {
        for (int i = 0; i < list.size(); i++) {
            if (br.getKODE_BUKU() == list.get(i).getKODE_BUKU()) {
                list.set(i, br);
            }
        }

        JOptionPane.showMessageDialog(null, "Succesfully changed!");
    }

    //  untuk hapus data
    public void delete(String JUDUL_BUKU) {
        for (int i = 0; i < list.size(); i++) {
            if (JUDUL_BUKU == list.get(i).getJUDUL_BUKU()) {
                list.remove(i);
            }
        }

        JOptionPane.showMessageDialog(null, "Succesfully deleted!");
    }

//    untuk melakukan pencarian berdasarkan JUDUL BUKU
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
