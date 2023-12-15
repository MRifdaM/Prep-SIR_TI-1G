package SIR;

import java.util.Scanner;
import java.time.LocalDate;

public class cadangan {
    static Scanner sc = new Scanner(System.in);
    static String namaBahan[][] = {
            { "Daging Sapi", "Daging Ayam", "Telor", "Kentang", "Roti", "Keju", "Selada", "Tomat", "Tepung",
                    "Ketimun", "Bawang Bombay", "Saos", "Mayones", "Minyak", "Air Mineral", "Coca Cola",
                    "Teh Botol" },
            { "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "liter", "box",
                    "box", "box" }
    };
    static String penyebab[][] = new String[1][namaBahan[0].length];
    static double stokBahan[] = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
    static double laporanPerTanggal[][] = new double[3][namaBahan[0].length];
    static int hapusIndex = -1;
    static LocalDate tanggal2 = null;
    static LocalDate[] laporanTgl = new LocalDate[1];

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

    private static boolean cekTanggal(LocalDate[] array, LocalDate date) {
        for (LocalDate d : array) {
            if (date.isEqual(d)) {
                return true;
            }
        }
        return false;
    }
    

    public static void main(String[] args) {
        String[][] akun = {
                { "Reza", "Rifda", "Vemas" },
                { "1234", "5678", "9101" },
        };
        String[][] inputan = new String[1][2];
        Boolean inventori = true, login = true, mainMenu = true, tanggals = true;
        int pilih = 0, n = 1, z = 0, o = 0, p = 3;
        LocalDate tanggal1 = null, tanggal = LocalDate.of(2023, 1, 1);

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
            tanggals = true;
            System.out.println("===================================================\n"
                    + "| Stok bahan awal dimulai pada tanggal 2023-01-01 |\n"
                    + "===================================================");
            
            while(tanggals){
                System.out.print("Masukkan Tanggal (format YYYY-MM-DD): ");
                String tanggalString = sc.next();
                tanggal1 = LocalDate.parse(tanggalString);
                if (tanggal1.isAfter(tanggal)){
                    tanggals = false;
                    break;
                } else {
                    System.out.println("Masukkan tanggal setelah tanggal 2023-01-01\n");
                }
                }
            
            if (tanggal2 == null || !cekTanggal(laporanTgl, tanggal1)) {
                double laporanPerTanggal2[][] = new double[laporanPerTanggal.length][laporanPerTanggal[0].length];
                for (int i = 0; i < laporanPerTanggal.length; i++) {
                    for (int j = 0; j < laporanPerTanggal[i].length; j++) {
                        laporanPerTanggal2[i][j] = laporanPerTanggal[i][j];
                    }
                }

                if (tanggal2 == null) {
                    laporanTgl[o] = tanggal1;
                } else if (!cekTanggal(laporanTgl, tanggal1)) {
                    p += 3;
                    n++;
                    LocalDate laporanTgl2[] = new LocalDate[laporanTgl.length + 1];
                    for (int i = 0; i < laporanTgl.length; i++) {
                        laporanTgl2[i] = laporanTgl[i];
                    }
                    laporanTgl2[laporanTgl.length] = tanggal1;
                    laporanTgl = new LocalDate[n];
                    for (int i = 0; i < laporanTgl.length; i++) {
                        laporanTgl[i] = laporanTgl2[i];
                    }
                    for (LocalDate date : laporanTgl) {
                        System.out.println(date);
                    }
                    laporanPerTanggal = new double[p][namaBahan[0].length];

                    for (int i = 0; i < laporanPerTanggal2.length; i++) {
                        for (int j = 0; j < laporanPerTanggal2[i].length; j++) {
                            laporanPerTanggal[i][j] = laporanPerTanggal2[i][j];
                        }
                    }
                    String penyebab2[][] = new String[penyebab.length + 1][namaBahan[0].length];
                    for (int i = 0; i < penyebab.length; i++) {
                    for (int j = 0; j < penyebab[i].length; j++) {
                        penyebab2[i][j] = penyebab[i][j];
                    }
                }
                    penyebab = new String[laporanTgl.length][namaBahan[0].length];
                    for (int i = 0; i < penyebab2.length; i++) {
                        for (int j = 0; j < penyebab2[i].length; j++) {
                            penyebab[i][j] = penyebab2[i][j];
                        }
                    }

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
                        dataMaster(tanggal1, p);
                        break;

                    case 2:
                        dataMasukKeluarRusak(tanggal1, laporanTgl);
                        break;

                    case 3:
                        laporanBahan(laporanTgl, stokBahan, tanggal1);
                        break;

                    case 7:
                        mainMenu = false;
                        break;
                }
            }
        }

    }

    public static void dataMaster(LocalDate tanggal1, int z) {
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
                    double laporanPerTanggalBaru[][] = new double[z][namaBahan[0].length + n];
                    String penyebabBaru[][] = new String[penyebab.length][penyebab.length + n];

                    for (int i = 0; i < penyebab.length; i++) {
                        for (int j = 0; j < penyebab[i].length; j++) {
                            penyebabBaru[i][j] = penyebab[i][j];
                        }
                    }

                    for (int i = 0; i < laporanPerTanggal.length; i++) {
                        for (int j = 0; j < laporanPerTanggal[i].length; j++) {
                            laporanPerTanggalBaru[i][j] = laporanPerTanggal[i][j];
                        }
                    }

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
                        laporanPerTanggal = laporanPerTanggalBaru;
                        penyebab = penyebabBaru;
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
                    double laporanHapus[][] = new double[laporanPerTanggal.length][namaBahan[0].length - 1];
                    String penyebabHapus[][] = new String[penyebab.length][namaBahan[0].length - 1];
                    int g = 0;
                    if (hapusIndex != -1) {

                        for (int j = 0; j < namaBahan[0].length; j++) {
                            if (j != hapusIndex) {
                                if (g < namaBahanHapus[0].length) {
                                    namaBahanHapus[0][g] = namaBahan[0][j];
                                    namaBahanHapus[1][g] = namaBahan[1][j];
                                    stokBahanHapus[g] = stokBahan[j];
                                    g++;
                                }
                            }
                            int h = 0;
                            for (int a = 0; a < laporanPerTanggal.length; a++) {
                                for (int b = 0; b < laporanPerTanggal[a].length; b++) {
                                    if (b != hapusIndex) {
                                        if (h < laporanHapus[0].length) {
                                            laporanHapus[a][h] = laporanPerTanggal[a][b];
                                            h++;
                                        }
                                    }
                                }
                            }
                            int d = 0;
                            for (int a = 0; a < penyebab.length; a++) {
                                for (int b = 0; b < penyebab[a].length; b++) {
                                    if (b != hapusIndex) {
                                        if (d < penyebabHapus[0].length) {
                                            penyebabHapus[a][d] = penyebab[a][b];
                                            d++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    laporanPerTanggal = laporanHapus;
                    namaBahan = namaBahanHapus;
                    stokBahan = stokBahanHapus;
                    penyebab = penyebabHapus;
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

    public static void dataMasukKeluarRusak(LocalDate tanggal1, LocalDate laporanTgl[]) {
        boolean dataMKR = true;
        while (dataMKR) {

            System.out.println("==============================================");
            System.out.println("|           DATA MASUK DAN KELUAR            |");
            System.out.println("==============================================");
            System.out.println(" 1. Masukkan Data Masuk              ");
            System.out.println(" 2. Masukkan Data Keluar             ");
            System.err.println(" 3. Masukkan Data Rusak");
            System.out.println(" 4. Hapus Data ");
            System.out.println(" 5. Lihat Data Bahan Masuk, Keluar, dan Rusak");
            System.out.println(" 6. Keluar                           ");
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
                        for (int t = 0; t < laporanTgl.length; t++) {
                            if (tanggal1.isEqual(laporanTgl[t])) {
                                int l = t * 3;
                                for (int j = 0; j < namaBahan[0].length; j++) {
                                    if (a.equalsIgnoreCase(namaBahan[0][j])) {
                                        if (laporanPerTanggal[l][j] == 0.0) {
                                            System.out.print("Masukkan jumlah " + namaBahan[0][j] + " yang masuk : ");
                                            laporanPerTanggal[l][j] = sc.nextDouble();
                                            if (laporanPerTanggal[l][j] >= 0) {
                                                stokBahan[j] += laporanPerTanggal[l][j];
                                                bahanMasukSama = true;

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

                                            } else if (laporanPerTanggal[l][j] < 0.0) {

                                                System.out.println("=================================================\n"
                                                        + "Jumlah bahan masuk tidak valid\n"
                                                        + "=================================================");
                                                j--;
                                                continue;
                                            }

                                        } else {
                                            stokBahan[j] -= laporanPerTanggal[l][j];
                                            System.out.print("Masukkan jumlah " + namaBahan[0][j] + " yang masuk : ");
                                            laporanPerTanggal[l][j] = sc.nextDouble();
                                            if (laporanPerTanggal[l][j] >= 0) {
                                                stokBahan[j] += laporanPerTanggal[l][j];
                                                bahanMasukSama = true;
                                                if (stokBahan[j] < 0) {
                                                    System.out.println(
                                                            "=======================iNPUT DATA KELUAR DAN RUSAK SESUAI JUMLAH STOK BAHAN SEKARANG=======================");
                                                    stokBahan[j] = stokBahan[j] + laporanPerTanggal[l + 1][j]
                                                            + laporanPerTanggal[l + 2][j];

                                                    laporanPerTanggal[l + 1][j] = 0.0;
                                                    laporanPerTanggal[l + 2][j] = 0.0;

                                                }

                                                sc.nextLine();
                                                System.out.print("Kembali ke Menu Data Masuk Dan Keluar (y/n)? : ");
                                                String pilihan = sc.nextLine();
                                                if (pilihan.equalsIgnoreCase("y")) {
                                                    i++;
                                                    t++;
                                                    break;
                                                } else if (pilihan.equalsIgnoreCase("n")) {
                                                    i--;
                                                    continue;
                                                }

                                            } else if (laporanPerTanggal[l][j] < 0.0) {

                                                System.out.println("=================================================\n"
                                                        + "Jumlah bahan masuk tidak valid\n"
                                                        + "=================================================");
                                                j--;
                                                continue;
                                            }
                                        }
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
                        for (int t = 0; t < laporanTgl.length; t++) {
                            if (tanggal1.isEqual(laporanTgl[t])) {
                                int l = t * 3;
                                for (int j = 0; j < namaBahan[0].length; j++) {
                                    if (a.equalsIgnoreCase(namaBahan[0][j])) {
                                        if (laporanPerTanggal[l + 1][j] == 0.0) {
                                            System.out.print("Masukkan jumlah " + namaBahan[0][j] + " yang keluar : ");
                                            laporanPerTanggal[l + 1][j] = sc.nextDouble();
                                            if (laporanPerTanggal[l + 1][j] <= stokBahan[j]
                                                    && laporanPerTanggal[l + 1][j] >= 0.0) {
                                                stokBahan[j] -= laporanPerTanggal[l + 1][j];
                                                bahanKeluarSama = true;

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

                                            } else if (laporanPerTanggal[l + 1][j] > stokBahan[j]) {

                                                System.out.println(
                                                        "=================================================================\n"
                                                                + "jumlah keluar melebihi stock bahan "
                                                                + namaBahan[0][j]
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
                                            stokBahan[j] += laporanPerTanggal[l + 1][j];
                                            System.out.print("Masukkan jumlah " + namaBahan[0][j] + " yang keluar : ");
                                            laporanPerTanggal[l + 1][j] = sc.nextDouble();
                                            if (laporanPerTanggal[l + 1][j] <= stokBahan[j]
                                                    && laporanPerTanggal[l + 1][j] >= 0.0) {
                                                stokBahan[j] -= laporanPerTanggal[l + 1][j];
                                                bahanKeluarSama = true;

                                                sc.nextLine();
                                                System.out.print("Kembali ke Menu Data Masuk Dan Keluar (y/n)? : ");
                                                String pilihan = sc.nextLine();
                                                if (pilihan.equalsIgnoreCase("y")) {
                                                    i++;
                                                    t++;
                                                    break;
                                                } else if (pilihan.equalsIgnoreCase("n")) {
                                                    i--;
                                                    continue;
                                                }

                                            } else if (laporanPerTanggal[l + 1][j] > stokBahan[j]) {

                                                System.out.println(
                                                        "=================================================================\n"
                                                                + "jumlah keluar melebihi stock bahan "
                                                                + namaBahan[0][j]
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
                        for (int t = 0; t < laporanTgl.length; t++) {
                            if (tanggal1.isEqual(laporanTgl[t])) {
                                int l = t * 3;
                                for (int j = 0; j < namaBahan[0].length; j++) {
                                    if (a.equalsIgnoreCase(namaBahan[0][j])) {
                                        if (laporanPerTanggal[l + 2][j] == 0.0) {
                                            System.out.print("Masukkan jumlah " + namaBahan[0][j] + " yang rusak : ");
                                            laporanPerTanggal[l + 2][j] = sc.nextDouble();
                                            if (laporanPerTanggal[l + 2][j] <= stokBahan[j]
                                                    && laporanPerTanggal[l + 2][j] >= 0.0) {
                                                stokBahan[j] -= laporanPerTanggal[l + 2][j];
                                                bahanKeluarSama = true;
                                                
                                                sc.nextLine();
                                                System.out.print("Masukkan penyebab " + namaBahan[0][j] + " rusak : ");
                                                penyebab[t][j] = sc.nextLine();

                                                System.out.print(
                                                        "Kembali ke Menu Data Masuk, Keluar, dan rusak (y/n)? : ");
                                                String pilihan = sc.nextLine();
                                                if (pilihan.equalsIgnoreCase("y")) {
                                                    i++;
                                                    break;
                                                } else if (pilihan.equalsIgnoreCase("n")) {
                                                    i--;
                                                    continue;
                                                }

                                            } else if (laporanPerTanggal[l + 2][j] > stokBahan[j]) {

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
                                            stokBahan[j] += laporanPerTanggal[l + 2][j];
                                            System.out.print("Masukkan jumlah " + namaBahan[0][j] + " yang rusak : ");
                                            laporanPerTanggal[l + 2][j] = sc.nextDouble();
                                            if (laporanPerTanggal[l + 2][j] <= stokBahan[j]
                                                    && laporanPerTanggal[l + 2][j] >= 0.0) {
                                                stokBahan[j] -= laporanPerTanggal[l + 2][j];
                                                bahanKeluarSama = true;
                                                
                                                sc.nextLine();
                                                System.out.print("Masukkan penyebab " + namaBahan[0][j] + " rusak : ");
                                                penyebab[t][j] = sc.nextLine();

                                                System.out.print(
                                                        "Kembali ke Menu Data Masuk, Keluar, dan Rusak (y/n)? : ");
                                                String pilihan = sc.nextLine();
                                                if (pilihan.equalsIgnoreCase("y")) {
                                                    i++;
                                                    t++;
                                                    break;
                                                } else if (pilihan.equalsIgnoreCase("n")) {
                                                    i--;
                                                    continue;
                                                }

                                            } else if (laporanPerTanggal[l + 2][j] > stokBahan[j]) {

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
                    boolean hapus = true;
                    while (hapus) {
                        System.out.println(
                                "==============================================\n" + " 1. Hapus Data Bahan Masuk\n"
                                        + " 2. Hapus Data Bahan Keluar\n" + " 3. Hapus Data Bahan Keluar\n"
                                        + " 4. Kembali\n" + "==============================================");
                        int pilih8 = Pilih();
                        switch (pilih8) {
                            case 1:
                                System.out.println("=====================================\n"
                                        + " Hapus Data Bahan Masuk\n" + "=====================================");
                                sc.nextLine();
                                String b = SearchName();
                                for (int i = 0; i < namaBahan.length - 1; i++) {
                                    for (int t = 0; t < laporanTgl.length; t++) {
                                        if (tanggal1.isEqual(laporanTgl[t])) {
                                            int l = t * 3;
                                            for (int j = 0; j < namaBahan[0].length; j++) {
                                                if (b.equalsIgnoreCase(namaBahan[i][j])) {
                                                    stokBahan[j] -= laporanPerTanggal[l][j];
                                                    laporanPerTanggal[l][j] = 0.0;
                                                    if (stokBahan[j] < 0) {
                                                        System.out.println(
                                                                "=======================iNPUT DATA KELUAR DAN RUSAK SESUAI JUMLAH STOK BAHAN SEKARANG=======================");
                                                        stokBahan[j] = stokBahan[j] + laporanPerTanggal[l + 1][j]
                                                                + laporanPerTanggal[l + 2][j];

                                                        laporanPerTanggal[l + 1][j] = 0.0;
                                                        laporanPerTanggal[l + 2][j] = 0.0;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                break;

                            case 2:
                                System.out.println("=====================================\n"
                                        + " Hapus Data Bahan Keluar\n" + "=====================================");
                                sc.nextLine();
                                String c = SearchName();
                                for (int i = 0; i < namaBahan.length - 1; i++) {
                                    for (int t = 0; t < laporanTgl.length; t++) {
                                        if (tanggal1.isEqual(laporanTgl[t])) {
                                            int l = t * 3;
                                            for (int j = 0; j < namaBahan[0].length; j++) {
                                                if (c.equalsIgnoreCase(namaBahan[i][j])) {
                                                    stokBahan[j] -= laporanPerTanggal[l + 1][j];
                                                    laporanPerTanggal[l + 1][j] = 0.0;
                                                }
                                            }
                                        }
                                    }
                                }
                                break;

                            case 3:
                                System.out.println("=====================================\n"
                                        + " Hapus Data Bahan Rusak\n" + "=====================================");
                                sc.nextLine();
                                String d = SearchName();
                                for (int i = 0; i < namaBahan.length - 1; i++) {
                                    for (int t = 0; t < laporanTgl.length; t++) {
                                        if (tanggal1.isEqual(laporanTgl[t])) {
                                            int l = t * 3;
                                            for (int j = 0; j < namaBahan[0].length; j++) {
                                                if (d.equalsIgnoreCase(namaBahan[i][j])) {
                                                    stokBahan[j] -= laporanPerTanggal[l + 2][j];
                                                    laporanPerTanggal[l + 2][j] = 0.0;
                                                }
                                            }
                                        }
                                    }
                                }
                                break;

                            case 4:
                                hapus = false;
                                break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("====================================");
                    System.out.println("|            DATA MASUK            |");
                    System.out.println("====================================");

                    for (int t = 0; t < laporanTgl.length; t++) {
                        if (tanggal1.isEqual(laporanTgl[t])) {
                            int l = t * 3;
                            for (int j = 0; j < namaBahan[0].length; j++) {
                                System.out.println(
                                        namaBahan[0][j] + " " + laporanPerTanggal[l][j] + " " + namaBahan[1][j]);
                            }
                        }
                    }

                    System.out.println("====================================");
                    System.out.println("|            DATA KELUAR           |");
                    System.out.println("====================================");
                    for (int t = 0; t < laporanTgl.length; t++) {
                        if (tanggal1.isEqual(laporanTgl[t])) {
                            int l = t * 3;
                            for (int j = 0; j < namaBahan[0].length; j++) {
                                System.out.println(
                                        namaBahan[0][j] + " " + laporanPerTanggal[l + 1][j] + " " + namaBahan[1][j]);
                            }
                        }
                    }
                    System.out.println("======================");
                    System.out.println("|  DATA BAHAN RUSAK  |");
                    System.out.println("======================");
                    for (int t = 0; t < laporanTgl.length; t++) {
                        if (tanggal1.isEqual(laporanTgl[t])) {
                            int l = t * 3;
                            for (int j = 0; j < namaBahan[1].length; j++) {
                                System.out.println(
                                        namaBahan[0][j] + " : " + laporanPerTanggal[l + 2][j] + " " + namaBahan[1][j]);
                            }
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

                case 6:
                    dataMKR = false;
                    break;
            }
        }
    }

    public static void laporanBahan(LocalDate[] laporanTgl, double[] stokBahan, LocalDate tanggal1) {
        boolean laporan = true;
        double keluarTerbanyak[][] = new double[laporanTgl.length][stokBahan.length];
        String namaBahan2[][] = new String[namaBahan.length][namaBahan[1].length];
        double swap1 = 0.0;
        String swap2 = " ", swap3 = " ";
        for (int i = 0; i < penyebab.length; i++) {
            for (int j = 0; j < penyebab[0].length; j++) {
            System.out.println(penyebab[i][j]);   
            }
        }
        for (int i = 0, k = 0; i < namaBahan.length; i++, k++) {
            for (int j = 0; j < namaBahan[i].length; j++) {
                namaBahan2[k][j] = namaBahan[i][j];
            }
        }
        for (int i = 1, k = 0; i < laporanPerTanggal.length; i += 3, k++) {
            for (int j = 0; j < laporanPerTanggal[i].length; j++) {
                keluarTerbanyak[k][j] = laporanPerTanggal[i][j];
            }
        }
        for (int i = 0; i < laporanPerTanggal.length; i += 1) {
            for (int j = 0; j < laporanPerTanggal[i].length; j++) {
                System.out.println(laporanPerTanggal[i][j]);
            }
            System.out.println();
        }
        while (laporan) {
            System.out.println(
                    "--------------------------\n" + "|   MENU LAPORAN BAHAN   |\n" + "--------------------------\n"
                            + " 1. Laporan Bahan\n" + " 2. Laporan Bahan Keluar Terbanyak\n"
                            + " 3. Catatan Bahan Rusak\n" + "--------------------------");
            int pilih9 = Pilih();
            switch (pilih9) {
                case 1:
                for (int t = 0; t < laporanTgl.length;t++){
                    System.out.println("================================================================================" + laporanTgl[t]  + "==============================================================================\n");
                    System.out.println("============================================================================================================================================================");
                    System.out.printf("| %-40s | %-25s | %-25s | %-25s | %-25s |\n", "               NAMA BAHAN", "        DATA MASUK", "         DATA KELUAR", "       DATA RUSAK", "         SATUAN");
                    System.out.println("============================================================================================================================================================");
                            int l = t * 3;
                            for (int j = 0; j < namaBahan[0].length; j++) {
                                System.out.printf("| %-40ss | %-25f | %-25f | %-25f | %-25s |\n", namaBahan[0][j], laporanPerTanggal[l][j], laporanPerTanggal[l+1][j], laporanPerTanggal[l+2][j], namaBahan[1][j] );
                            }
                            System.out.println("============================================================================================================================================================\n\n");
                    }
                    for (int t = 0; t < laporanTgl.length; t++) {
                    if (laporanTgl[t].isEqual(tanggal1)) {
                        for (int i = 0; i < penyebab[0].length; i++) {
                            if (penyebab[t][i] != null) {
                                System.out.println("Catatan: ");
                                System.out.println("bahan "+namaBahan[0][i] +" rusak karena "+penyebab[t][i]);
                            }
                        }
                    }
                }
                        System.out.println("\n================================STOCK=================================");
                        for (int j = 0; j < stokBahan.length; j++) {
                            System.out.println("Stock akhir " + namaBahan[0][j] + " sebanyak "
                                    + stokBahan[j] + " " + namaBahan[1][j]);
                        }
                    break;

                case 2:
                    for (int h = 0; h < laporanTgl.length; h++) {
                        System.out.println("\t");
                        System.out.println("==========================" + laporanTgl[h] + "==========================");
                        if (h != 0 || h % 2 == 0 || h % 2 == 1) {
                            for (int k = 0; k < keluarTerbanyak[0].length; k++) {
                                for (int i = 0; i < keluarTerbanyak.length; i++) {
                                    for (int j = 1; j < keluarTerbanyak[0].length; j++) {
                                        if (keluarTerbanyak[i][j] >= keluarTerbanyak[i][j - 1]) {
                                            swap1 = keluarTerbanyak[i][j - 1];
                                            keluarTerbanyak[i][j - 1] = keluarTerbanyak[i][j];
                                            keluarTerbanyak[i][j] = swap1;

                                            swap2 = namaBahan2[0][j - 1];
                                            namaBahan2[0][j - 1] = namaBahan2[0][j];
                                            namaBahan2[0][j] = swap2;

                                            swap3 = namaBahan2[1][j - 1];
                                            namaBahan2[1][j - 1] = namaBahan2[1][j];
                                            namaBahan2[1][j] = swap3;
                                        }
                                    }
                                }
                            }
                            for (int i = 0; i < keluarTerbanyak.length; i++) {
                                for (int j = 0; j < keluarTerbanyak[i].length; j++) {
                                    if (namaBahan2[1][j].equalsIgnoreCase("kg") && keluarTerbanyak[i][j] > 0.0) {
                                        System.out.println("Bahan yang keluar terbanyak pada tangggal " + laporanTgl[h]
                                                + " adalah " + namaBahan2[0][j] + " sebanyak " + keluarTerbanyak[i][j]
                                                + " " + namaBahan2[1][j]);
                                        break;
                                    }
                                }
                            }
                            for (int i = 0; i < keluarTerbanyak.length; i++) {
                                for (int j = 0; j < keluarTerbanyak[i].length; j++) {
                                    if (namaBahan2[1][j].equalsIgnoreCase("liter") && keluarTerbanyak[i][j] > 0.0) {
                                        System.out.println("Bahan yang keluar terbanyak pada tangggal " + laporanTgl[h]
                                                + " adalah " + namaBahan2[0][j] + " sebanyak " + keluarTerbanyak[i][j]
                                                + " " + namaBahan2[1][j]);
                                        break;
                                    }
                                }
                            }
                            for (int i = 0; i < keluarTerbanyak.length; i++) {
                                for (int j = 0; j < keluarTerbanyak[i].length; j++) {
                                    if (namaBahan2[1][j].equalsIgnoreCase("box") && keluarTerbanyak[i][j] > 0.0) {
                                        System.out.println("Bahan yang keluar terbanyak pada tangggal " + laporanTgl[h]
                                                + " adalah " + namaBahan2[0][j] + " sebanyak " + keluarTerbanyak[i][j]
                                                + " " + namaBahan2[1][j]);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    break;

                case 3:
                laporan = false;
                    break;
            }
        }
    }
}
    

