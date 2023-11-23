package SIR;
import java.util.Scanner;


public class SistemInventoriRestoran {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] akun = {
                { "Reza", "Rifda", "Vemas" },
                { "1234", "5678", "9101" },
        };
        String namaBahan[][] = {
                { "Daging Sapi", "Daging Ayam", "Telor", "Kentang", "Roti", "Keju", "Selada", "Tomat", "Tepung",
                        "Ketimun", "Bawang Bombay", "Saos", "Mayones", "Minyak", "Air Mineral", "Coca-Cola",
                        "Teh Botol" },
                { "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "liter", "botol",
                        "botol", "botol" }
        };
        String[][] inputan = new String[1][2];
        double stokMasukKeluar[][] = new double[2][namaBahan[0].length];
        double stokRusak[] = new double[namaBahan[0].length];
        double stokBahan[] = new double[namaBahan[0].length];
        double stokAkhir[] = new double[17];
        Boolean inventori = true, login = true, mainMenu = true, dataB = false, menu1 = false, menu2 = false;
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

            switch (pilih) {
                case 1:
                    while (dataMaster) {

                        System.out.println("====================================");
                        System.out.println("|            DATA MASTER           |");
                        System.out.println("====================================");
                        System.out.println("| 1. Masukkan nama bahan           |");
                        System.out.println("| 2. Masukkan data bahan           |");
                        System.out.println("| 3. Hapus data bahan              |");
                        System.out.println("| 4. Lihat data bahan              |");
                        System.out.println("| 5. Keluar                        |");
                        System.out.println("====================================");
                        System.out.print(" Masuk ke menu : ");
                        pilih = sc.nextInt();
                        switch (pilih) {
                            case 1:
                                System.out.println("====================================");
                                System.out.println("|       MASUKKAN NAMA BAHAN        |");
                                System.out.println("====================================");
                                System.out.print(" Masukkan jumlah bahan baru: ");
                                n = sc.nextInt();

                                String namaBahanBaru[][] = new String[namaBahan.length][namaBahan[0].length + n];
                                double stokBahanBaru[] = new double[namaBahan[0].length + n];

                                for (int i = 0; i < namaBahan.length; i++) {
                                    for (int j = 0; j < namaBahan[i].length; j++) {
                                        namaBahanBaru[i][j] = namaBahan[i][j];
                                        stokBahanBaru[j] = stokBahan[j];
                                    }
                                }
                                for (int k = namaBahan[0].length; k < namaBahan[0].length + n; k++) {
                                    System.out.print(" Masukkan nama bahan baru : ");
                                    namaBahanBaru[0][k] = sc.next();

                                    System.out.print(" Masukkan satuan bahan baru : ");
                                    namaBahanBaru[1][k] = sc.next();
                                }
                                namaBahan = namaBahanBaru;
                                stokBahan = stokBahanBaru;
                                stokMasukKeluar = new double[2][namaBahan[0].length];
                                stokRusak = new double[namaBahan[0].length];
                                dataB = true;
                                break;
                            case 2:
                                System.out.println("====================================");
                                System.out.println("|       MASUKKAN DATA BAHAN        |");
                                System.out.println("====================================");
                                System.out.println("| 1. Masukkan Semua Data Bahan     |");
                                System.out.println("| 2. Masukkan Data Bahan Baru      |");
                                System.out.println("====================================");
                                System.out.print(" Masuk ke menu : ");
                                pilih = sc.nextInt();
                                if (pilih == 1){
                                    for (int i = 0; i < namaBahan.length - 1; i++) {
                                        for (int j = 0; j < namaBahan[i].length; j++) {
                                            if (stokBahan[j] == 0.0){
                                            System.out.print(namaBahan[i][j] + " : ");
                                            stokBahan[j] = sc.nextDouble();
                                            }
                                        }
                                    }
                                } else if (pilih == 2){
                                    if (dataB){
                                        for (int i = 0; i < namaBahan.length - 1; i++) {
                                            for (int j = namaBahan[i].length-n; j < namaBahan[i].length; j++) {
                                                System.out.print(namaBahan[i][j] + " : ");
                                                stokBahan[j] = sc.nextDouble();
                                            }
                                        }
                                    } else {
                                        System.out.println("=============================================");
                                        System.out.println("|  Masukkan Nama Bahan Baru Terlebih Dahulu |");
                                        System.out.println("=============================================");
                                    }
                                }
                                break;

                            case 3:
                            System.out.println("==========================================");
                            System.out.println("|            HAPUS DATA BAHAN            |");
                            System.out.println("==========================================");
                            sc.nextLine();
                            System.out.print(" Masukkan nama bahan yang ingin dihapus : ");
                            a = sc.nextLine();

                            for (int i = 0; i < namaBahan[0].length; i++) {
                                    if (namaBahan[0][i].equalsIgnoreCase(a)){
                                        hapusIndex = i;
                                        break;
                                    } 
                            }

                            String namaBahanHapus[][] = new String[namaBahan.length][namaBahan[0].length - 1];
                            double stokBahanHapus[] = new double[namaBahan[0].length - 1]; 
                            int k = 0;
                            if (hapusIndex != -1){

                                    for (int j = 0; j < namaBahan[0].length; j++){
                                        if (j != hapusIndex){
                                            if (k < namaBahanHapus[0].length){
                                                namaBahanHapus[0][k] = namaBahan[0][j];
                                                namaBahanHapus[1][k] = namaBahan[1][j];
                                                stokBahanHapus[k] = stokBahan[j];
                                                k++;
                                            }
                                        }
                                    }
                            }
                            
                            namaBahan = namaBahanHapus;
                            stokBahan = stokBahanHapus;
                            break;


                            case 4:
                                System.out.println("=============LIHAT DATA=============");
                                for (int i = 0; i < namaBahan.length - 1; i++) {
                                    for (int j = 0; j < namaBahan[i].length; j++){
                                        System.out.println(namaBahan[i][j] + " :" + " " + stokBahan[j] + " " + namaBahan[1][j]);
                                        }
                                    }
                                    break;


                                case 5:
                                dataMaster = false;
                                break;
                                

                        }
                    }
                    break ;

                    case 2:
                    while (dataMK) {
                        System.out.println("=====================================");
                        System.out.println("|      DATA MASUK DAN KELUAR        |");
                        System.out.println("=====================================");
                        System.out.println(" 1. Masukkan Data Masuk              ");
                        System.out.println(" 2. Masukkan Data Keluar             ");
                        System.out.println(" 3. Lihat Data Bahan Masuk Dan Keluar");
                        System.out.println(" 4. Keluar                           ");
                        System.out.println("=====================================");
                        System.out.print("  Pilih Menu : ");
                        pilih = sc.nextInt();
                        switch (pilih) {
                            case 1 :
                            System.out.println("====================================");
                            System.out.println("|             DATA MASUK           |");
                            System.out.println("====================================");
                            for (int i=0; i < namaBahan.length-1; i++) {
                                for (int j = 0; j < namaBahan[i].length; j++) {
                                System.out.print(" Masukkan jumlah " + namaBahan[i][j] + " yang masuk : ");
                                stokMasukKeluar[i][j] = sc.nextDouble();
                                }
                            }
                            menu1 = true;
                            System.out.println("====================================");
                            System.out.println("|          Kembali Ke Menu         |");
                            System.out.println("====================================");
                            System.out.println(" 1. Iya                             ");
                            System.out.println(" 2. Tidak                           ");
                            System.out.println("====================================");
                            System.out.print(" Masukkan pilihan : ");
                            pilih = sc.nextInt();
                            if (pilih == 1) {
                                break;
                            } else {
                                dataMK = false;
                            }
                            break;
                    
                            case 2 :
                            System.out.println("====================================");
                            System.out.println("|            DATA KELUAR           |");
                            System.out.println("====================================");
                            for (int i=1; i < stokMasukKeluar.length; i++) {
                                for (int j = 0; j < namaBahan[i].length; j++) {
                                System.out.print(" Masukkan jumlah " + namaBahan[0][j] + " yang keluar : ");
                                stokMasukKeluar[i][j] = sc.nextDouble();
                                }
                            }
                            menu2 = true;
                            System.out.println("====================================");
                            System.out.println("|          Kembali Ke Menu         |");
                            System.out.println("====================================");
                            System.out.println(" 1. Iya                             ");
                            System.out.println(" 2. Tidak                           ");
                            System.out.println("====================================");
                            System.out.print(" Masukkan pilihan : ");
                            pilih = sc.nextInt();
                            if (pilih == 1) {
                                break;
                            } else {
                                dataMK = false;
                            }
                            break;
                    
                            case 3 :
                            if (menu1 && menu2) {
                            System.out.println("====================================");
                            System.out.println("|            DATA MASUK            |");
                            System.out.println("====================================");
                            for (int i = 0; i < namaBahan.length-1; i++) {
                                for (int j = 0; j < namaBahan[i].length; j++) {
                                System.out.println(namaBahan[i][j] + " " + stokMasukKeluar[i][j] + " " + namaBahan[1][j]);
                                }
                            }
                            System.out.println("====================================");
                            System.out.println("|            DATA KELUAR           |");
                            System.out.println("====================================");
                            for (int i = 1; i < stokMasukKeluar.length; i++) {
                                for (int j = 0; j < namaBahan[i].length; j++) {
                                System.out.println(namaBahan[0][j] + " " + stokMasukKeluar[i][j] + " " + namaBahan[1][j]);
                                }
                            }
                            System.out.println("====================================");
                            System.out.println("|          Kembali Ke Menu         |");
                            System.out.println("====================================");
                            System.out.println(" 1. Iya                             ");
                            System.out.println(" 2. Tidak                           ");
                            System.out.println("====================================");
                            System.out.print(" Masukkan pilihan : ");
                            pilih = sc.nextInt();
                            if (pilih == 1) {
                                break;
                            } else {
                                dataMK = false;
                            }
                            break;
                        } else {
                            System.out.println("===================================================");
                            System.out.println("|  Masukkan data masuk dan keluar terlebih dahulu |");
                            System.out.println("===================================================");
                            System.out.println("====================================");
                            System.out.println("|          Kembali Ke Menu         |");
                            System.out.println("====================================");
                            System.out.println(" 1. Iya                             ");
                            System.out.println(" 2. Tidak                           ");
                            System.out.println("====================================");
                            System.out.print(" Masukkan pilihan : ");
                            pilih = sc.nextInt();
                            if (pilih == 1) {
                                break;
                            } else {
                                dataMK = false;
                            }
                            break;
                        }
                        case 4:
                        dataMK = false;
                        break;
                        }
                    }
                    break;

                    case 3:
                    while (dataR) {
                    System.out.println("=====================================");
                    System.out.println("|             DATA RUSAK            |");
                    System.out.println("=====================================");
                    System.out.println(" 1. Masukkan Data Rusak              ");
                    System.out.println(" 2. Lihat Data Bahan Rusak           ");
                    System.out.println(" 3. Keluar                           ");
                    System.out.println("=====================================");
                    System.out.print("  Pilih Menu : ");
                    pilih = sc.nextInt();
                    switch (pilih) {
                        case 1:
                        System.out.println("===============================");
                        System.out.println("|  MASUKKAN BAHAN YANG RUSAK  |");
                        System.out.println("===============================");
                        for(int i = 0;i<namaBahan.length-1;i++){
                            for (int j = 0; j < namaBahan[i].length; j++){
                                System.out.print("Masukkan jumlah " + namaBahan[i][j] + " yang rusak : ");
                                stokRusak[j] = sc.nextDouble();
                            }    
                        }
                        break;

                        case 2:
                        System.out.println("======================");
                        System.out.println("|  DATA BAHAN RUSAK  |");
                        System.out.println("======================");
                        for(int i = 0;i <namaBahan.length-1;i++){
                            for (int j = 0; j < namaBahan[i].length; j++){
                            System.out.println(namaBahan[i][j] + " : " + stokRusak[j] +" " +namaBahan[1][j]);
                            }
                        }
                        break;

                        case 3:
                        dataR = false;
                        break;
                    }
                }
                break;

                case 4:
                while(dataU){
                boolean perbaruiD = true;
                System.out.println("=====================================");
                System.out.println("|            UPDATE DATA            |");
                System.out.println("=====================================");
                System.out.println(" 1. Update Data ke Data Master       ");
                System.out.println(" 2. Perbarui Data");
                System.out.println(" 3. Keluar                           ");
                System.out.println("====================================="); 
                System.out.print("Pilih Menu : ");                   
                pilih = sc.nextInt();
                if (pilih == 1){
                for (int i = 0; i < stokAkhir.length; i++) {
                    stokAkhir[i] = stokBahan[i] + stokMasukKeluar[0][i] - stokMasukKeluar[1][i] - stokRusak[i];
                    stokBahan[i] = stokAkhir[i];
                    }
                    System.out.println("Data telah diupdate");
                } else if (pilih == 2){
                    String nama = " ";
                    while (perbaruiD) {
                    System.out.println("=====================================");
                    System.out.println("|           PERBARUI DATA           |");
                    System.out.println("=====================================");
                    System.out.println(" 1. Perbarui Data Master");
                    System.out.println(" 2. Perbarui Data Masuk");
                    System.out.println(" 3. Perbarui Data Keluar");
                    System.out.println(" 4. Perbarui Data Rusak");
                    System.out.println(" 5. Keluar");
                    System.out.println("=====================================");
                    System.out.print("Pilih Menu : ");
                    pilih = sc.nextInt();

                    switch (pilih) {
                        case 1:
                        System.out.println("=====================================");
                        System.out.println("|        PERBARUI DATA MASTER       |");
                        System.out.println("=====================================");
                        sc.nextLine();
                        System.out.print("Masukkan nama bahan yang ingin diperbarui : ");
                        nama = sc.nextLine();
                        for (int i = 0; i < namaBahan[0].length; i++){
                            if (nama.equalsIgnoreCase(namaBahan[0][i])){
                                System.out.print("Masukkan data bahan : ");
                                stokBahan[i] = sc.nextDouble();
                                break;
                            }
                        }
                        break;

                        case 2:
                        System.out.println("=====================================");
                        System.out.println("|        PERBARUI DATA MASUK       |");
                        System.out.println("=====================================");
                        sc.nextLine();
                        System.out.print("Masukkan nama bahan yang ingin diperbarui : ");
                        nama = sc.nextLine();
                        for (int i = 0; i < namaBahan[0].length; i++){
                            if (nama.equalsIgnoreCase(namaBahan[0][i])){
                                System.out.print("Masukkan data bahan : ");
                                stokMasukKeluar[0][i] = sc.nextDouble();
                                break;
                            }
                        }
                        break;

                        case 3:
                        System.out.println("=====================================");
                        System.out.println("|        PERBARUI DATA KELUAR       |");
                        System.out.println("=====================================");
                        sc.nextLine();
                        System.out.print("Masukkan nama bahan yang ingin diperbarui : ");
                        nama = sc.nextLine();
                        for (int i = 0; i < namaBahan[0].length; i++){
                            if (nama.equalsIgnoreCase(namaBahan[0][i])){
                                System.out.print("Masukkan data bahan : ");
                                stokMasukKeluar[1][i] = sc.nextDouble();
                                break;
                            }
                        }
                        break;

                        case 4:
                        System.out.println("=====================================");
                        System.out.println("|        PERBARUI DATA RUSAK        |");
                        System.out.println("=====================================");
                        sc.nextLine();
                        System.out.println("Masukkan nama bahan yang ingin diperbarui : ");
                        nama = sc.nextLine();
                        for (int i = 0; i < namaBahan[0].length; i++){
                            if (nama.equalsIgnoreCase(namaBahan[0][i])){
                                System.out.println("Masukkan data bahan : ");
                                stokRusak[i] = sc.nextDouble();
                                break;
                            }
                        }
                        break;
                        case 5:
                        perbaruiD = false;
                        break;
                    }
                }
                }else {
                    dataU = false;
                    break;
                }
            }
                break;

                case 5:
                while (laporan) {
                    System.out.println("--------------------------");
                    System.out.println("|   MENU LAPORAN BAHAN   |");
                    System.out.println("--------------------------");
                    System.out.println("1. Laporan Bahan Masuk");
                    System.out.println("2. Laporan Bahan Keluar");
                    System.out.println("3. Laporan Bahan Rusak");
                    System.out.println("4. Laporan Stok Bahan");
                    System.out.println("5. keluar");
                    System.out.println("--------------------------");
                    System.out.print("Masuk Ke Menu : ");
                    pilih = sc.nextInt();
        
                    switch (pilih) {
                        case 1:
                            System.out.println("-----------------------------");
                            System.out.println("|    LAPORAN BAHAN MASUK    |");
                            System.out.println("-----------------------------");
                            for (int i = 0; i < stokMasukKeluar[0].length; i++) {
                                System.out.println("Bahan " + namaBahan[0][i] + " Yang Masuk Hari Ini : "
                                        + stokMasukKeluar[0][i] + " " + namaBahan[1][i]);
                            }
                            System.out.println("-----------------------------");
                            System.out.println("1. Kembali Ke Menu");
                            System.out.println("-----------------------------");
                            System.out.print("Masukkan Pilihan Anda: ");
                            pilih = sc.nextInt();
                            if (pilih == 1) {
                                break;
                            }
                            break;
        
                        case 2:
                            System.out.println("-----------------------------");
                            System.out.println("|    LAPORAN BAHAN KELUAR   |");
                            System.out.println("-----------------------------");
                            for (int i = 0; i < stokMasukKeluar[0].length; i++) {
                                System.out.println("Bahan " + namaBahan[0][i] + " Yang Keluar Hari Ini : "
                                        + stokMasukKeluar[1][i] + " " + namaBahan[1][i]);
                            }
                            System.out.println("-----------------------------");
                            System.out.println("1. Kembali Ke Menu");
                            System.out.println("-----------------------------");
                            System.out.print("Masukkan Pilihan Anda: ");
                            pilih = sc.nextInt();
                            if (pilih == 1) {
                                break;
                            }
                            break;
        
                        case 3:
                            System.out.println("-----------------------------");
                            System.out.println("|    LAPORAN BAHAN RUSAK    |");
                            System.out.println("-----------------------------");
                            for (int i = 0; i < stokRusak.length; i++) {
                                System.out.println(
                                        "Bahan " + namaBahan[0][i] + " Yang Rusak Hari Ini : " + stokRusak[i] + " "
                                                + namaBahan[1][i]);
                            }
                            System.out.println("-----------------------------");
                            System.out.println("1. Kembali Ke Menu");
                            System.out.println("-----------------------------");
                            System.out.print("Masukkan Pilihan Anda: ");
                            pilih = sc.nextInt();
                            if (pilih == 1) {
                                break;
                            }
                            break;
        
                        case 4:
                            System.out.println("-----------------------------");
                            System.out.println("|    LAPORAN STOCK BAHAN    |");
                            System.out.println("-----------------------------");
                            for (int i = 0; i < stokAkhir.length; i++) {
                                stokAkhir[i] = stokBahan[i] + stokMasukKeluar[0][i] - stokMasukKeluar[1][i] - stokRusak[i];
                                System.out.println("Laporan Stok Bahan Hari ini " + namaBahan[0][i] + " : " + stokAkhir[i] + " "
                                        + namaBahan[1][i]);
                            }
                            System.out.println("-----------------------------");
                            System.out.println("1. Kembali Ke Menu");
                            System.out.println("-----------------------------");
                            System.out.print("Masukkan Pilihan Anda: ");
                            pilih = sc.nextInt();
                            if (pilih == 1) {
                                break;
                            } else {
                                laporan = false;
                            }
                            break;

                        case 5:
                            laporan = false;
                            break;
                    }
                }
                break;

                case 6:
                double keluarTerbanyak[] = new double[stokMasukKeluar[1].length];
                String namaBahan2[][] = new String[namaBahan.length][namaBahan[1].length];
                double swap = 0.0;
                String swap2 = "", swap3 = "";
                System.out.println("--------------------------------------");
                System.out.println("|    LAPORAN BAHAN KELUAR TERBANYAK  |");
                System.out.println("--------------------------------------");
                keluarTerbanyak = stokMasukKeluar[1];
                namaBahan2 = namaBahan;
                for (int i = 0; i < keluarTerbanyak.length; i++) {
                    for (int j = 1; j < keluarTerbanyak.length; j++){
                        if (keluarTerbanyak[j] > keluarTerbanyak[j-1]){
                            swap = keluarTerbanyak[j-1];
                            keluarTerbanyak[j-1] = keluarTerbanyak[j];
                            keluarTerbanyak[j] = swap;

                            swap2 = namaBahan2[0][j-1];
                            namaBahan2[0][j-1] = namaBahan2[0][j];
                            namaBahan2[0][j] = swap2;

                            swap3 = namaBahan2[1][j-1];
                            namaBahan2[1][j-1] = namaBahan2[1][j];
                            namaBahan2[1][j] = swap3;
                        }
                    }
                }
                
                    for (int j = 0; j < namaBahan2[0].length; j++){
                        System.out.println(namaBahan2[0][j] + " : " + keluarTerbanyak[j] + " " + namaBahan2[1][j]);
                    }
                
                break;

                case 7:
                mainMenu = false;
                break;
            }
        }
    }
        sc.close();
    }
}
