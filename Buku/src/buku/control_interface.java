/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buku;

import javax.swing.JTable;


public interface control_interface {
    public void read (JTable bc);
    public void create (model br);
    public void update (model br);
    public void delete (String JUDUL_BUKU);


}
