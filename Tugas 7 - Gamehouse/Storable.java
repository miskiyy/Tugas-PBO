
/**
 * Write a description of interface Storable here.
 *
 * @author Frensnya Windah Basudara
 * @version 12/10/2024
 */
import java.util.Map;

public interface Storable {
    void tambahItem(String item, int jumlah);
    void hapusItem(String item);
    void tampilkanItem();
}