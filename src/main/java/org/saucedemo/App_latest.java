package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.Scanner;

public class App_latest {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", "C:\\Downloads");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "application/gzip,application/octet-stream,application/x-gzip");
        profile.setPreference("pdfjs.disabled", true);

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        // Launch Firefox
        FirefoxDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // Open login page first
        driver.get("https://kbits.build.lab126.a2z.com/");
        System.out.println("Login once in the browser, then press Enter to continue...");
        scanner.nextLine();  // wait for manual login

        // Open Excel workbook
//        Give the location of Excel file like this -> "C:\\Users\\chanckku\\Desktop\\Book1.xlsx""
        try (Workbook workbook = WorkbookFactory.create(new File(path))) {
            Sheet sheet = workbook.getSheetAt(0);

            // Loop through rows (skip header)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                String device = row.getCell(0).getStringCellValue();
                int fosVersion = (int) row.getCell(1).getNumericCellValue();
                int shipVersion = (int) row.getCell(2).getNumericCellValue();
                String buildVariant = row.getCell(3).getStringCellValue();
                String variant = row.getCell(4).getStringCellValue();

                // Construct download URL
                String filename = String.format("release-%s-RS%s_%s_%s.tgz",
                        device.toLowerCase(), fosVersion, variant, shipVersion);
                String downloadUrl = String.format(
                        "https://download.kbits.build.lab126.a2z.com/build_files/fast_download/%s_fireos_ship_%s/%s/%s/%s/%s",
                        device, fosVersion, buildVariant, shipVersion, variant, filename
                );

                // Open download URL in new tab (browser handles authentication)
                ((JavascriptExecutor) driver).executeScript("window.open(arguments[0]);", downloadUrl);
                System.out.println("Downloading: " + filename);

                // Optional: small wait to avoid overwhelming browser
                Thread.sleep(2000);
            }
        }

        System.out.println("All downloads started. Keep browser open until they finish.");
    }
}
//    }
//    public static void main(String[] args) throws InterruptedException, IOException {
//        String device;
//        String fos_version;
//        String ship_version;
//        String build_variant;
//        String variant;
//
//        Scanner scanner = new Scanner(System.in);
//
//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("browser.download.folderList", 2);
//        profile.setPreference("browser.download.dir", "C:\\Downloads");
//        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
//                "application/gzip,application/octet-stream,application/x-gzip");
//        profile.setPreference("pdfjs.disabled", true);
//
//        FirefoxOptions options = new FirefoxOptions();
//        options.setProfile(profile);
//
//        FirefoxDriver driver = new FirefoxDriver(options);
//        driver.manage().window().maximize();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//
//        driver.get("https://kbits.build.lab126.a2z.com/");
//        System.out.println("Login once, then press Enter to continue...");
//        scanner.nextLine();
//
//        try (Workbook workbook =
//                     WorkbookFactory.create(new File("C:\\Users\\chanckku\\Desktop\\Book1.xlsx"))) {
//
//            Sheet sheet = workbook.getSheetAt(0);
//
//            // start from row 1 (skip header)
//            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//
//                Row row = sheet.getRow(i);
//                if (row == null) continue;
//
//                String device1 = row.getCell(0).getStringCellValue();
//                int fosVersion = (int) row.getCell(1).getNumericCellValue();
//                int shipVersion = (int) row.getCell(2).getNumericCellValue();
//                String buildVariant = row.getCell(3).getStringCellValue();
//                String variant1 = row.getCell(4).getStringCellValue();
//
//
//                String filename = "release-%s-RS%s_%s_%s.tgz";
//                String filename1 = String.format(filename, device1.toLowerCase(), fosVersion, variant1, shipVersion);
//                String download_url = "https://download.kbits.build.lab126.a2z.com/build_files/fast_download/%s_fireos_ship_%s/%s/%s/%s/%s";
//                String download_url_final = String.format(download_url, device1, fosVersion, buildVariant, shipVersion, variant1, filename1);
////                System.out.println(download_url_final);
////                driver.get(download_url_final);
//
//
//                Set<Cookie> seleniumCookies = driver.manage().getCookies();
//                URL url = new URL(download_url_final);
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//                // Add cookies BEFORE connecting
//                for (Cookie c : seleniumCookies) {
//                    conn.addRequestProperty("Cookie", c.getName() + "=" + c.getValue());
//                }
//
//                int responseCode = conn.getResponseCode();
//                if (responseCode == 200) {
//                    try (InputStream in = conn.getInputStream()) {
//                        Files.copy(in, Paths.get("C:\\Downloads\\" + filename1));
//                    }
//                    System.out.println("Downloaded: " + filename1);
//                } else {
//                    System.out.println("Failed to download " + filename1 + " - HTTP " + responseCode);
//                }
//
//
//
//
//            }
//        }
//
////        https://download.kbits.build.lab126.a2z.com/build_files/fast_download/sunstone_fireos_ship_8338/Nightly/3339/user/release-sunstone-RS8338_user_3339.tgz
//
////
////        System.out.print("Enter device name: ");
////        device = scanner.nextLine();
////        System.out.print("Enter FOS Version: ");
////        fos_version = scanner.nextLine();
////        System.out.print("Enter Ship Version: ");
////        ship_version = scanner.nextLine();
////        System.out.print("Enter Build Variant: ");
////        build_variant = scanner.nextLine();
////        System.out.print("Enter Variant: ");
////        variant = scanner.nextLine();
//
//
////        Have Excel's location
////        Reader in = new FileReader("C:\\Users\\chanckku\\Desktop\\Book1.xlsx");
////        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
////        for (CSVRecord record : records) {
////            String device1 = record.get("Device");
////            String fos_version1 = record.get("FOS version");
////            String ship = record.get("Ship version");
////            String build = record.get("Build variant");
////            String variant1 = record.get("variant");
//
//
////            String device1 = record.get(0);
////            String fos_version1 = record.get(1);
////            String ship = record.get(2);
////            String build = record.get(3);
////            String variant1 = record.get(4);
////
////            System.out.println(device1);
////            System.out.println(fos_version1);
////            System.out.println(ship);
////            System.out.println(build);
////            System.out.println(variant1);
//
////        }
//
//
//
////        String filename = "release-%s-RS%s_%s_%s.tgz";
////        String filename1 = String.format(filename, device.toLowerCase(), fos_version, variant, ship_version.toLowerCase());
////        String download_url = "https://download.kbits.build.lab126.a2z.com/build_files/fast_download/%s_fireos_ship_%s/%s/%s/%s/%s";
////        String download_url_final = String.format(download_url, device, fos_version, build_variant, ship_version, variant, filename1);
////
////        FirefoxDriver driver = new FirefoxDriver();
////        driver.manage().window().maximize();
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
////        driver.get("https://kbits.build.lab126.a2z.com/");
////        System.out.println("Press Enter to continue: ");
////        String ans = scanner.nextLine();
////        driver.get(download_url_final);
//    }
//}
