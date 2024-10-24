
/**
 * Write a description of class Inventory here.
 *
 * @author Frensnya Windah Basudara
 * @version 12/10/2024
 */
import java.util.HashMap;
import java.util.Map;

public class Inventory implements Storable {
    private Map<String, Integer> itemMap;
    private int totalItem;

    public Inventory() {
        itemMap = new HashMap<>();
        totalItem = 0;
    }

    @Override
    public void tambahItem(String item, int jumlah) {
        if (itemMap.containsKey(item)) {
            itemMap.put(item, itemMap.get(item) + jumlah);
        } else {
            itemMap.put(item, jumlah);
        }
        totalItem += jumlah;
        System.out.println(jumlah + " " + item + " berhasil ditambahkan.");
    }

    @Override
    public void hapusItem(String item) {
        if (itemMap.containsKey(item)) {
            totalItem -= itemMap.get(item);
            itemMap.remove(item);
            System.out.println(item + " berhasil dihapus.");
        } else {
            System.out.println(item + " tidak ditemukan.");
        }
    }

    @Override
    public void tampilkanItem() {
        System.out.println("Daftar item Keputih Game Corners :");
        if (itemMap.isEmpty()) {
            System.out.println("Tidak ada item dalam inventaris.");
        } else {
            for (Map.Entry<String, Integer> entry : itemMap.entrySet()) {
                System.out.println("Item: " + entry.getKey() + " - Jumlah: " + entry.getValue());
            }
            System.out.println("Total item di inventaris: " + totalItem);
        }
    }
}
