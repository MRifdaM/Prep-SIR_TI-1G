package SIR;
import java.util.Scanner;
import java.math.BigDecimal;
import java.time.LocalDate;


public class cobaSIR1 {
    static Scanner sc = new Scanner(System.in);
    static String namaBahan[][] = {
        { "Daging Sapi", "Daging Ayam", "Telor", "Kentang", "Roti", "Keju", "Selada", "Tomat", "Tepung",
                "Ketimun", "Bawang Bombay", "Saos", "Mayones", "Minyak", "Air Mineral", "Coca-Cola",
                "Teh Botol" },
        { "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "liter", "box",
                "box", "box" }
};
static BigDecimal stokBahan[] = {
            new BigDecimal("100.0"), new BigDecimal("100.0"), new BigDecimal("100.0"), 
            new BigDecimal("100.0"), new BigDecimal("100.0"), new BigDecimal("100.0"),
            new BigDecimal("100.0"), new BigDecimal("100.0"), new BigDecimal("100.0"),
            new BigDecimal("100.0"), new BigDecimal("100.0"), new BigDecimal("100.0"),
            new BigDecimal("100.0"), new BigDecimal("100.0"), new BigDecimal("100.0"), 
            new BigDecimal("100.0"), new BigDecimal("100.0"),
        };


    public static String SearchName(){
        System.out.print("Masukkan Nama Bahan : ");
        String a = sc.nextLine();
        return a;
    }
    public static void main(String[] args) {
        String[][] akun = {
            { "Reza", "Rifda", "Vemas" },
            { "1234", "5678", "9101" },
    };
    String[][] inputan = new String[1][2];
    Boolean inventori = true, login = true, mainMenu = true;
    int pilih = 0, n = 0, hapusIndex = -1;
    String a = "";


        while(inventori){
            login = true;
            mainMenu = true;
    
            while (login) {
                System.out.println("==============================\n" + "|            LOGIN           |\n" + "==============================");
    
                for (int i = 0; i <inputan.length; i++) {
                    System.out.print("Masukkan Username : ");
                    inputan[i][i]= sc.next();
                }
    
                for (int i =0, j = 1; i< inputan.length && j <= inputan.length;i++, j++) {
                    System.out.print("Masukkan Password : ");
                    inputan[i][j]= sc.next();
    
                }
                if (inputan[0][0].equalsIgnoreCase(akun[0][0])) {
                    if (inputan[0][1].equalsIgnoreCase(akun[1][0])) {
                    System.out.println("=============================\n" + "|       Login Berhasil      |\n" + "=============================");
                    login = false;
                    break;
    
                    } else {
                        System.out.println("=============================");
                        System.out.println("|    Password Anda Salah    |");
                        System.out.println("|         Login Gagal       |");
                        System.out.println("=============================");
                    }
                } else if (inputan[0][0].equalsIgnoreCase(akun[0][1])) {
                    if (inputan[0][1].equalsIgnoreCase(akun[1][1])){
                    System.out.println("=============================");
                    System.out.println("|       Login Berhasil      |");
                    System.out.println("=============================");
                    login = false;
                    break;
    
                    }else {
                        System.out.println("=============================");
                        System.out.println("|     Pasaword Anda Salah   |");
                        System.out.println("|         Login Gagal       |");
                        System.out.println("=============================");
                    }
                } else if (inputan[0][0].equalsIgnoreCase(akun[0][2])) {
                    if (inputan[0][1].equalsIgnoreCase(akun[1][2])) {
                    System.out.println("=============================");
                    System.out.println("|       Login Berhasil      |");
                    System.out.println("=============================");
                    login = false;
                    break;
    
                    } else {
                        System.out.println("=========================");
                        System.out.println("|   Password Anda Salah |");
                        System.out.println("|       Login Gagal     |");
                        System.out.println("=========================");
                    }
                } else {
                    System.out.println("=============================");
                    System.out.println("|    Username Anda Salah    |");
                    System.out.println("|         Login Gagal       |");
                    System.out.println("=============================");
                }
            }
            while (mainMenu) {
        boolean dataMaster = true,  dataMK = true, dataR = true, dataU = true, laporan = true;

        System.out.println("==============================\n" + "|          MAIN MENU         |\n" + "==============================");
        System.out.println("1. Data Master");
        System.out.println("2. Data Bahan Masuk dan Keluar");
        System.out.println("3. Data Bahan Rusak");
        System.out.println("4. Update Data");
        System.out.println("5. Laporan Bahan");
        System.out.println("6. Laporan Bahan Keluar Terbanyak");
        System.out.println("7. Keluar\n" + "==============================");
        System.out.print("Masukkan Pilihan : ");
        pilih = sc.nextInt();
        }
        }

}
}
