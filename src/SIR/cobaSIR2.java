package SIR;

import java.util.Scanner;
import java.time.LocalDate;

public class cobaSIR2 {
    static Scanner sc = new Scanner(System.in);
    static String namaBahan[][] = {
            { "Daging Sapi", "Daging Ayam", "Telor", "Kentang", "Roti", "Keju", "Selada", "Tomat", "Tepung",
                    "Ketimun", "Bawang Bombay", "Saos", "Mayones", "Minyak", "Air Mineral", "Coca Cola",
                    "Teh Botol" },
            { "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "liter", "box",
                    "box", "box" }
    };
    static double stokBahan[] = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
    static double laporanPerTanggal[][] = new double[3][namaBahan[0].length];
    static double stokPerTanggal[][] = new double[3][namaBahan[0].length];
    static double bahanMasuk = 0.0, bahanKeluar = 0.0, bahanRusak = 0.0;
    static int hapusIndex = -1;
    static LocalDate tanggal2 = null;

    public static String SearchName() {
        System.out.print("Masukkan Nama Bahan : ");
        String a = sc.nextLine();
        return a;
    }

    public static int Pilih() {
        System.out.print("Masukkan Pilihan : ");
        int p = sc.nextInt();
        return p;
    }

    public static void main(String[] args) {
        String[][] akun = {
                { "Reza", "Rifda", "Vemas" },
                { "1234", "5678", "9101" },
        };
        String[][] inputan = new String[1][2];
        Boolean inventori = true, login = true, mainMenu = true;
        int pilih = 0,n = 0, z = 0, o = 0;
        LocalDate[] laporanTgl = new LocalDate[0];
        LocalDate tanggal1 = null;
        String a = "";

        while (inventori) {
            login = true;
            mainMenu = true;

            while (login) {
                System.out.println("==============================\n" + "|            LOGIN           |\n"
                        + "==============================");

                for (int i = 0; i < inputan.length; i++) {
                    System.out.print("Masukkan Username : ");
                    inputan[i][i] = sc.next();
                }

                for (int i = 0, j = 1; i < inputan.length && j <= inputan.length; i++, j++) {
                    System.out.print("Masukkan Password : ");
                    inputan[i][j] = sc.next();

                }
                if (inputan[0][0].equalsIgnoreCase(akun[0][0])) {
                    if (inputan[0][1].equalsIgnoreCase(akun[1][0])) {
                        System.out.println("=============================\n" + "|       Login Berhasil      |\n"
                                + "=============================");
                        login = false;
                        break;

                    } else {
                        System.out.println("=============================");
                        System.out.println("|    Password Anda Salah    |");
                        System.out.println("|         Login Gagal       |");
                        System.out.println("=============================");
                    }
                } else if (inputan[0][0].equalsIgnoreCase(akun[0][1])) {
                    if (inputan[0][1].equalsIgnoreCase(akun[1][1])) {
                        System.out.println("=============================");
                        System.out.println("|       Login Berhasil      |");
                        System.out.println("=============================");
                        login = false;
                        break;

                    } else {
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
            tanggal2 = tanggal1;
            System.out.print("Masukkan Tanggal (format YYYY-MM-DD): ");
            String tanggalString = sc.next();
            tanggal1 = LocalDate.parse(tanggalString);

            if (tanggal2 == null || !tanggal1.isEqual(tanggal2)) {
                double laporanPerTanggal2[][] = new double[laporanPerTanggal.length][laporanPerTanggal[0].length];
                laporanPerTanggal2 = laporanPerTanggal;
                double stokPerTanggalHapus[][] = new double[stokPerTanggal.length][stokPerTanggal[0].length];
                stokPerTanggal = stokPerTanggalHapus;
                n+=1;
                laporanTgl = new LocalDate[n];
                if (tanggal2 == null){
                    laporanTgl[o] = tanggal1;
                } else if (!tanggal1.isEqual(tanggal2)){
                    o += 1;
                    laporanPerTanggal = new double[3+3][namaBahan[0].length];
                    laporanPerTanggal = laporanPerTanggal2;
                    laporanTgl[o-1] = tanggal2;
                    laporanTgl[o] = tanggal1;
                }
            }
            while (mainMenu) {

                System.out.println("tanggal : " + tanggal1 + "\n==============================\n"
                        + "|          MAIN MENU         |\n" + "==============================");
                System.out.println("1. Data Master");
                System.out.println("2. Data Bahan Masuk, Keluar, dan Rusak");
                ;
                System.out.println("3. Laporan Bahan");
                System.out.println("4. Laporan Bahan Keluar Terbanyak");
                System.out.println("7. Keluar\n" + "==============================");
                pilih = Pilih();
                switch (pilih) {
                    case 1:
                    dataMaster(tanggal1, z);
                    break;

                    case 2:
                    dataMasukKeluarRusak(tanggal1);
                    break;

                    case 3:
                    laporanBahan(laporanTgl, stokBahan);
                    break;

                    case 7:
                        mainMenu = false;
                        break;
                }
            }
        }

    }

    public static void dataMaster( LocalDate tanggal1, int z) {
        boolean fiturMaster = true;
        while (fiturMaster) {

            System.out.println("====================================");
            System.out.println("|            DATA MASTER           |");
            System.out.println("====================================");
            System.out.println("| 1. Masukkan nama bahan           |");
            System.out.println("| 2. Masukkan data bahan           |");
            System.out.println("| 3. Hapus data bahan              |");
            System.out.println("| 4. Lihat data bahan              |");
            System.out.println("| 5. Keluar                        |");
            System.out.println("====================================");
            int pilih2 = Pilih();
            switch (pilih2) {
                case 1:
                    boolean bahanBaruDitambahkan = false;
                    System.out.println("====================================");
                    System.out.println("|       MASUKKAN NAMA BAHAN        |");
                    System.out.println("====================================");
                    System.out.print(" Masukkan jumlah bahan baru: ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    String namaBahanBaru[][] = new String[namaBahan.length][namaBahan[0].length + n];
                    double stokBahanBaru[] = new double[namaBahan[0].length + n];

                    for (int i = 0; i < namaBahan.length; i++) {
                        for (int j = 0; j < namaBahan[i].length; j++) {
                            namaBahanBaru[i][j] = namaBahan[i][j];
                            stokBahanBaru[j] = stokBahan[j];
                        }
                    }
                    
                    int k = namaBahan[0].length;
                    for (; k < namaBahan[0].length + n; k++) {
                        System.out.print(" Masukkan nama bahan baru : ");
                        namaBahanBaru[0][k] = sc.nextLine();

                        boolean terdaftar = false;
                        for (int j = 0; j < namaBahan[0].length; j++) {
                            if (namaBahanBaru[0][k].equalsIgnoreCase(namaBahan[0][j])) {
                                terdaftar = true;
                                break;
                            }
                        }
                        if (terdaftar) {
                            System.out.println("=======================================\n"
                                    + "        Bahan Sudah Terdaftar\n" + "=======================================");
                            k--;
                            continue;
                        }

                        System.out.print(" Masukkan satuan bahan baru : ");
                        namaBahanBaru[1][k] = sc.nextLine();
                        bahanBaruDitambahkan = true;
                    }

                    if (bahanBaruDitambahkan) {
                        namaBahan = namaBahanBaru;
                        stokBahan = stokBahanBaru;
                        stokPerTanggal = new double[3][namaBahan[0].length];
                        laporanPerTanggal = new double[3][namaBahan[0].length];
                    }
                    System.out.println(namaBahan[0].length);
                    break;
                case 2:
                    System.out.println("====================================");
                    System.out.println("|       MASUKKAN DATA BAHAN        |");
                    System.out.println("====================================");
                    System.out.println("| 1. Perbarui Data Master          |");
                    System.out.println("| 2. Keluar                        |");
                    System.out.println("====================================");
                    int pilih3 = Pilih();
                    if (pilih3 == 1) {
                        String nama = "";
                        System.out.println("=====================================");
                        System.out.println("|        PERBARUI DATA MASTER       |");
                        System.out.println("=====================================");
                        sc.nextLine();
                        for (int i = 0; i < namaBahan.length; i++) {
                            boolean bahanDitemukan = false;
                            System.out.print("Masukkan nama bahan yang ingin diperbarui : ");
                            nama = sc.nextLine();
                            for (int j = 0; j < namaBahan[0].length; j++) {
                                if (nama.equalsIgnoreCase(namaBahan[0][j])) {
                                    System.out.print("Masukkan data bahan : ");
                                    stokBahan[j] = sc.nextDouble();
                                    sc.nextLine();
                                    bahanDitemukan = true;
                                    break;
                                }
                            }
                            if (!bahanDitemukan) {
                                System.out.println("=================================================\n"
                                        + "Nama bahan yang ingin diperbarui tidak ditemukan\n"
                                        + "=================================================");
                                i--;
                                continue;
                            }

                            System.out.print("Kembali ke Menu Data Master (y/n)? : ");
                            String pilihan = sc.nextLine();
                            if (pilihan.equalsIgnoreCase("y")) {
                                i++;
                            } else if (pilihan.equalsIgnoreCase("n")) {
                                i--;
                            }
                        }

                    } else if (pilih3 != 1) {
                        break;
                    }
                    break;

                case 3:
                    boolean bahanHapusDiTemukan = false;
                    System.out.println("==========================================");
                    System.out.println("|            HAPUS DATA BAHAN            |");
                    System.out.println("==========================================");
                    sc.nextLine();
                    for (int i = 0; i < namaBahan.length; i++) {

                        System.out.print(" Masukkan nama bahan yang ingin dihapus : ");
                        String a = sc.nextLine();

                        for (int j = 0; j < namaBahan[0].length; j++) {
                            if (namaBahan[0][j].equalsIgnoreCase(a)) {
                                hapusIndex = j;
                                System.out.println("============ " + namaBahan[0][j]
                                        + " sudah dihapus dari daftar bahan di sistem ============");
                                bahanHapusDiTemukan = true;
                                i++;
                                break;
                            }
                        }
                        if (!bahanHapusDiTemukan) {
                            System.out.println("=================================================\n"
                                    + "Nama bahan yang ingin dihapus tidak ditemukan\n"
                                    + "=================================================");
                            i--;
                            continue;
                        }
                    }
                    String namaBahanHapus[][] = new String[namaBahan.length][namaBahan[0].length - 1];
                    double stokBahanHapus[] = new double[namaBahan[0].length - 1];
                    double stokMKR[][] = new double[3][namaBahan[0].length - 1];
                    double laporanHapus[][] = new double[laporanPerTanggal.length][namaBahan[0].length-1];
                    int g = 0;
                    if (hapusIndex != -1) {
                        
                        for (int j = 0; j < namaBahan[0].length; j++) {
                            if (j != hapusIndex) {
                                if (g < namaBahanHapus[0].length) {
                                    namaBahanHapus[0][g] = namaBahan[0][j];
                                    namaBahanHapus[1][g] = namaBahan[1][j];
                                    stokBahanHapus[g] = stokBahan[j];
                                    stokMKR[0][g] = stokPerTanggal[0][j];
                                    stokMKR[1][g] = stokPerTanggal[1][j];
                                    stokMKR[2][g] = stokPerTanggal[2][j];
                                    g++;
                                }
                            }
                            int h = 0;
                            for (int a = 0; a < laporanPerTanggal.length; a++){
                                for (int b  = 0; b < laporanPerTanggal[a].length; b++){
                                    if (b != hapusIndex){
                                        if (h < laporanHapus[0].length){
                                        laporanHapus[a][h] = laporanPerTanggal[a][b];
                                        h++;
                                    }
                                    }
                                }
                            }
                        }
                    }
                    laporanPerTanggal = laporanHapus;
                    namaBahan = namaBahanHapus;
                    stokBahan = stokBahanHapus;
                    stokPerTanggal = stokMKR;
                    break;

                case 4:
                    System.out.println("=============LIHAT DATA=============");
                    for (int i = 0; i < namaBahan.length - 1; i++) {
                        for (int j = 0; j < namaBahan[i].length; j++) {
                            System.out.printf("Stok terkini %s: %.1f %s\n", namaBahan[i][j], stokBahan[j],
                                    namaBahan[1][j]);
                        }
                    }
                    break;

                case 5:
                    fiturMaster = false;
                    break;

            }
        }
    }

    public static int dataMasukKeluarRusak( LocalDate tanggal1) {
        boolean dataMKR = true;
        int z = 0;
        while (dataMKR) {

            System.out.println("==============================================");
            System.out.println("|           DATA MASUK DAN KELUAR            |");
            System.out.println("==============================================");
            System.out.println(" 1. Masukkan Data Masuk              ");
            System.out.println(" 2. Masukkan Data Keluar             ");
            System.err.println(" 3. Masukkan Data Rusak");
            System.out.println(" 4. Lihat Data Bahan Masuk, Keluar, dan Rusak");
            System.out.println(" 5. Keluar                           ");
            System.out.println("==============================================");
            int pilih4 = Pilih();
            switch (pilih4) {
                case 1:
                    System.out.println("====================================");
                    System.out.println("|             DATA MASUK           |");
                    System.out.println("====================================");
                    sc.nextLine();
                    for (int i = 0; i < namaBahan.length; i++) {
                        boolean bahanMasukSama = false;
                        String a = SearchName();
                        for (int j = 0; j < namaBahan[0].length; j++) {
                            if (a.equalsIgnoreCase(namaBahan[0][j])) {
                                if (stokPerTanggal[0][j] == 0.0) {
                                    System.out.print("Masukkan jumlah " + namaBahan[0][j] + " yang masuk : ");
                                    stokPerTanggal[0][j] = sc.nextDouble();
                                    if (stokPerTanggal[0][j] >= 0) {
                                        bahanMasuk = stokPerTanggal[0][j];
                                        stokBahan[j] += stokPerTanggal[0][j];
                                        bahanMasukSama = true;
                                        if (tanggal2 == null || !tanggal1.isEqual(tanggal2)) {
                                                if (tanggal2 == null){
                                                    laporanPerTanggal[0][j] = stokPerTanggal[0][j];
                                                } else if (!tanggal2.equals(tanggal1)){
                                                    z += 3;
                                                    laporanPerTanggal[0+z][j] = stokPerTanggal[0][j];
                                                    z = 0;
                                                }
                                            }
                                        sc.nextLine();
                                        System.out.print("Kembali ke Menu Data Masuk Dan Keluar (y/n)? : ");
                                        String pilihan = sc.nextLine();
                                        if (pilihan.equalsIgnoreCase("y")) {
                                            i++;
                                            break;
                                        } else if (pilihan.equalsIgnoreCase("n")) {
                                            i--;
                                            continue;
                                        }

                                    } else if (stokPerTanggal[0][j] < 0) {

                                        System.out.println("=================================================\n"
                                                + "Jumlah bahan masuk tidak valid\n"
                                                + "=================================================");
                                        j--;
                                        continue;
                                    }
                                    
                                    
                                } else {
                                    stokBahan[j] -= bahanMasuk;
                                    System.out.print("Masukkan jumlah " + namaBahan[0][j] + " yang masuk : ");
                                    stokPerTanggal[0][j] = sc.nextDouble();
                                    if (stokPerTanggal[0][j] >= 0) {
                                        stokBahan[j] += stokPerTanggal[0][j];
                                        bahanMasuk = stokPerTanggal[0][j];
                                        bahanMasukSama = true;
                                        if (tanggal2 == null || !tanggal1.isEqual(tanggal2)) {
                                                if (tanggal2 == null){
                                                    laporanPerTanggal[0][j] = stokPerTanggal[0][j];
                                                } else if (!tanggal2.equals(tanggal1)){
                                                    z += 3;
                                                    laporanPerTanggal[0+z][j] = stokPerTanggal[0][j];
                                                    z = 0;
                                                }
                                            }
                                        sc.nextLine();
                                        System.out.print("Kembali ke Menu Data Masuk Dan Keluar (y/n)? : ");
                                        String pilihan = sc.nextLine();
                                        if (pilihan.equalsIgnoreCase("y")) {
                                            i++;
                                            break;
                                        } else if (pilihan.equalsIgnoreCase("n")) {
                                            i--;
                                            continue;
                                        }

                                    } else if (stokPerTanggal[0][j] > stokBahan[j]) {

                                        System.out.println("=================================================\n"
                                                + "Jumlah bahan masuk tidak valid\n"
                                                + "=================================================");
                                        j--;
                                        continue;
                                    }
                                }
                            }
                        }
                        if (!bahanMasukSama) {
                            System.out.println("=================================================\n"
                                    + "Nama bahan tidak terdaftar\n"
                                    + "=================================================");
                            i--;
                            continue;
                        }
                    }
                    break;

                case 2:
                    System.out.println("====================================");
                    System.out.println("|            DATA KELUAR           |");
                    System.out.println("====================================");
                    sc.nextLine();
                    for (int i = 0; i < namaBahan.length; i++) {
                        boolean bahanKeluarSama = false;
                        String a = SearchName();
                        for (int j = 0; j < namaBahan[0].length; j++) {
                            if (a.equalsIgnoreCase(namaBahan[0][j])) {
                                if (stokPerTanggal[1][j] == 0.0) {
                                    System.out.print("Masukkan jumlah " + namaBahan[0][j] + " yang keluar : ");
                                    stokPerTanggal[1][j] = sc.nextDouble();
                                    if (stokPerTanggal[1][j] <= stokBahan[j] && stokPerTanggal[1][j] >= 0.0) {
                                        bahanKeluar = stokPerTanggal[1][j];
                                        stokBahan[j] -= stokPerTanggal[1][j];
                                        bahanKeluarSama = true;
                                        if (tanggal2 == null || !tanggal1.isEqual(tanggal2)) {
                                                if (tanggal2 == null){
                                                    laporanPerTanggal[1][0] = stokPerTanggal[1][j];
                                                } else if (!tanggal2.equals(tanggal1)){
                                                    z += 3;
                                                    laporanPerTanggal[1+z][j] = stokPerTanggal[1][j];
                                                    z = 0;
                                                }
                                            }
                                        sc.nextLine();
                                        System.out.print("Kembali ke Menu Data Masuk Dan Keluar (y/n)? : ");
                                        String pilihan = sc.nextLine();
                                        if (pilihan.equalsIgnoreCase("y")) {
                                            i++;
                                            break;
                                        } else if (pilihan.equalsIgnoreCase("n")) {
                                            i--;
                                            continue;
                                        }

                                    } else if (stokPerTanggal[1][j] > stokBahan[j]) {

                                        System.out.println(
                                                "=================================================================\n"
                                                        + "jumlah keluar melebihi stock bahan " + namaBahan[0][j]
                                                        + " yang tersedia\n"
                                                        + "=================================================================");
                                        j--;
                                        continue;
                                    } else {
                                        System.out.println("=================================================\n"
                                                + "Jumlah bahan keluar tidak valid\n"
                                                + "=================================================");
                                        j--;
                                        continue;
                                    }
                                } else {
                                    stokBahan[j] += bahanKeluar;
                                    System.out.print("Masukkan jumlah " + namaBahan[0][j] + " yang keluar : ");
                                    stokPerTanggal[1][j] = sc.nextDouble();
                                    if (stokPerTanggal[1][j] <= stokBahan[j] && stokPerTanggal[1][j] >= 0.0) {
                                        stokBahan[j] -= stokPerTanggal[1][j];
                                        bahanKeluar = stokPerTanggal[1][j];
                                        bahanKeluarSama = true;
                                        if (tanggal2 == null || !tanggal1.isEqual(tanggal2)) {
                                                if (tanggal2 == null){
                                                    laporanPerTanggal[1][0] = stokPerTanggal[1][j];
                                                } else if (!tanggal2.equals(tanggal1)){
                                                    z += 3;
                                                    laporanPerTanggal[1+z][0+z] = stokPerTanggal[1][j];
                                                    z = 0;
                                                }
                                            }
                                        sc.nextLine();
                                        System.out.print("Kembali ke Menu Data Masuk Dan Keluar (y/n)? : ");
                                        String pilihan = sc.nextLine();
                                        if (pilihan.equalsIgnoreCase("y")) {
                                            i++;
                                            break;
                                        } else if (pilihan.equalsIgnoreCase("n")) {
                                            i--;
                                            continue;
                                        }

                                    } else if (stokPerTanggal[1][j] > stokBahan[j]) {

                                        System.out.println(
                                                "=================================================================\n"
                                                        + "jumlah keluar melebihi stock bahan " + namaBahan[0][j]
                                                        + " yang tersedia\n"
                                                        + "=================================================================");
                                        j--;
                                        continue;
                                    } else {
                                        System.out.println("=================================================\n"
                                                + "Jumlah bahan keluar tidak valid\n"
                                                + "=================================================");
                                        j--;
                                        continue;
                                    }
                                }
                            }
                        }
                        if (!bahanKeluarSama) {
                            System.out.println("=================================================\n"
                                    + "Nama bahan tidak terdaftar\n"
                                    + "=================================================");
                            i--;
                            continue;
                        }
                    }
                    break;

                case 3:
                    System.out.println("===============================");
                    System.out.println("|       BAHAN YANG RUSAK      |");
                    System.out.println("===============================");
                    sc.nextLine();
                    for (int i = 0; i < namaBahan.length; i++) {
                        boolean bahanKeluarSama = false;
                        String a = SearchName();
                        for (int j = 0; j < namaBahan[0].length; j++) {
                            if (a.equalsIgnoreCase(namaBahan[0][j])) {
                                if (stokPerTanggal[2][j] == 0.0) {
                                    System.out.print("Masukkan jumlah " + namaBahan[0][j] + " yang rusak : ");
                                    stokPerTanggal[2][j] = sc.nextDouble();
                                    if (stokPerTanggal[2][j] <= stokBahan[j] && stokPerTanggal[2][j] >= 0.0) {
                                        bahanRusak = stokPerTanggal[2][j];
                                        stokBahan[j] -= stokPerTanggal[2][j];
                                        bahanKeluarSama = true;
                                        if (tanggal2 == null || !tanggal1.isEqual(tanggal2)) {
                                                if (tanggal2 == null){
                                                    laporanPerTanggal[2][0] = stokPerTanggal[2][j];
                                                } else if (!tanggal2.equals(tanggal1)){
                                                    z += 3;
                                                    laporanPerTanggal[2+z][0+z] = stokPerTanggal[2][j];
                                                    z = 0;
                                                }
                                            }
                                        sc.nextLine();
                                        System.out.print("Kembali ke Menu Data Masuk, Keluar, dan rusak (y/n)? : ");
                                        String pilihan = sc.nextLine();
                                        if (pilihan.equalsIgnoreCase("y")) {
                                            i++;
                                            break;
                                        } else if (pilihan.equalsIgnoreCase("n")) {
                                            i--;
                                            continue;
                                        }

                                    } else if (stokPerTanggal[2][j] > stokBahan[j]) {

                                        System.out.println(
                                                "=================================================================\n"
                                                        + "jumlah rusak melebihi stock bahan " + namaBahan[0][j]
                                                        + " yang tersedia\n"
                                                        + "=================================================================");
                                        j--;
                                        continue;
                                    } else {
                                        System.out.println("=================================================\n"
                                                + "Jumlah bahan rusak tidak valid\n"
                                                + "=================================================");
                                        j--;
                                        continue;
                                    }
                                } else {
                                    stokBahan[j] += bahanRusak;
                                    System.out.print("Masukkan jumlah " + namaBahan[0][j] + " yang rusak : ");
                                    stokPerTanggal[2][j] = sc.nextDouble();
                                    if (stokPerTanggal[2][j] <= stokBahan[j] && stokPerTanggal[2][j] >= 0.0) {
                                        stokBahan[j] -= stokPerTanggal[2][j];
                                        bahanRusak = stokPerTanggal[2][j];
                                        bahanKeluarSama = true;
                                        if (tanggal2 == null || !tanggal1.isEqual(tanggal2)) {
                                                if (tanggal2 == null){
                                                    laporanPerTanggal[2][0] = stokPerTanggal[2][j];
                                                } else if (!tanggal2.equals(tanggal1)){
                                                    z += 3;
                                                    laporanPerTanggal[2+z][0+z] = stokPerTanggal[2][j];
                                                    z = 0;
                                                }
                                            }
                                        sc.nextLine();
                                        System.out.print("Kembali ke Menu Data Masuk, Keluar, dan Rusak (y/n)? : ");
                                        String pilihan = sc.nextLine();
                                        if (pilihan.equalsIgnoreCase("y")) {
                                            i++;
                                            break;
                                        } else if (pilihan.equalsIgnoreCase("n")) {
                                            i--;
                                            continue;
                                        }

                                    } else if (stokPerTanggal[2][j] > stokBahan[j]) {

                                        System.out.println(
                                                "=================================================================\n"
                                                        + "jumlah rusak melebihi stock bahan " + namaBahan[0][j]
                                                        + " yang tersedia\n"
                                                        + "=================================================================");
                                        j--;
                                        continue;
                                    } else {
                                        System.out.println("=================================================\n"
                                                + "Jumlah bahan rusak tidak valid\n"
                                                + "=================================================");
                                        j--;
                                        continue;
                                    }
                                }
                            }
                        }
                        if (!bahanKeluarSama) {
                            System.out.println("=================================================\n"
                                    + "Nama bahan tidak terdaftar\n"
                                    + "=================================================");
                            i--;
                            continue;
                        }
                    }
                    break;

                case 4:
                    System.out.println("====================================");
                    System.out.println("|            DATA MASUK            |");
                    System.out.println("====================================");
                    for (int i = 0; i < namaBahan.length - 1; i++) {
                        for (int j = 0; j < namaBahan[i].length; j++) {
                            System.out.println(namaBahan[i][j] + " " + stokPerTanggal[i][j] + " " + namaBahan[1][j]);
                        }
                    }
                    System.out.println("====================================");
                    System.out.println("|            DATA KELUAR           |");
                    System.out.println("====================================");
                    for (int i = 1; i < namaBahan.length; i++) {
                        for (int j = 0; j < namaBahan[i].length; j++) {
                            System.out.println(namaBahan[0][j] + " " + stokPerTanggal[i][j] + " " + namaBahan[1][j]);
                        }
                    }
                    System.out.println("======================");
                    System.out.println("|  DATA BAHAN RUSAK  |");
                    System.out.println("======================");
                    for (int i = 2; i < stokPerTanggal.length; i++) {
                        for (int j = 0; j < namaBahan[1].length; j++) {
                            System.out.println(namaBahan[0][j] + " : " + stokPerTanggal[2][j] + " " + namaBahan[1][j]);
                        }
                    }
                    System.out.println("====================================");
                    System.out.println("|          Kembali Ke Menu         |");
                    System.out.println("====================================");
                    System.out.println(" 1. Iya                             ");
                    System.out.println(" 2. Tidak                           ");
                    System.out.println("====================================");
                    int pilih5 = Pilih();
                    if (pilih5 == 1) {
                        break;
                    } else {
                        dataMKR = false;
                    }
                    break;

                case 5:
                    dataMKR = false;
                    break;
            }
        }
        return z;
    }
    public static void laporanBahan(LocalDate[] laporanTgl, double[] stokBahan){
        boolean laporan = true;
        while(laporan){
            System.out.println("--------------------------\n" + "|   MENU LAPORAN BAHAN   |\n" + "--------------------------");
            System.out.print("Masukkan tanggal laporan : ");
            String tanggalLaporan = sc.next();
            LocalDate tanggal3 = LocalDate.parse(tanggalLaporan);
            if (tanggal3 != null){
                if (tanggal3.equals(laporanTgl[0])){
                    for (int i = 0; i < 3; i++){
                        for (int j=0; j < namaBahan[0].length; j++){
                            if (laporanPerTanggal[i][j] != 0.0){
                                System.out.println(namaBahan[0][j] + " yang masuk pada " + laporanTgl[0] + " sebanyak : " + laporanPerTanggal[i][j] + " " + namaBahan[1][j]);
                            }
                        }
                    }
                }
            }
            
        }
    }
}
