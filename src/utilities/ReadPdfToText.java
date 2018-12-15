package utilities;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadPdfToText {

    // == constants ==
    private ArrayList<StringBuilder> lines = new ArrayList<>();

    // == constructor ==
    public ReadPdfToText(File file) throws IOException {
        buildLines(file);
    }

    // == private methods ==
    private String buildAccountNumber(String[] strings) {
        StringBuilder accountNumber = new StringBuilder();
        for (String string : strings) {
            if (Utilities.defineAccountNumber(string)) {
                accountNumber.append(string + " ");
            }
        }
        return accountNumber.toString();
    }

/*    private StringBuilder buildDescription(String[] strings) {
        StringBuilder des = new StringBuilder();
        for (int i = 3; i < strings.length - 1; i++) {
            des.append(strings[i] + " ");
        }

        return des;
    }*/

    private void buildLines(File file) throws IOException {

        try {
            String accountNumber = "";
            String period = "";
            StringBuilder oneString = new StringBuilder();
            PrintWriter writer = new PrintWriter("items.txt", "UTF-8");

            PDDocument document = PDDocument.load(file);
            document.getClass();

            if (!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper textStripper = new PDFTextStripper();
                String str = textStripper.getText(document);
                Scanner scanner = new Scanner(str);
                String line;

                while (scanner.hasNext()) {
                    line = scanner.nextLine().trim();

                    // create account number
                    if (accountNumber == "" && line.length() > 0) {
                        if (Utilities.defineAccountNumberString(line)) {
                            String[] splitLineAccount = line.split(" ");
                            accountNumber = buildAccountNumber(splitLineAccount);
                        }
                    }

                    // create period
                    if (period == "") {
                        if (Utilities.definePeriod(line)) {
                            period = line;
                        }
                    }

                    if (line.length() > 0) {
                        oneString.append(line + " ");
                    }
                }


                // export data text
                writer.println(period);
                writer.println(accountNumber + "\n");

                String[] splitOneString = splitTheLastString(oneString.toString());


                for (int i = 0; i < splitOneString.length; i++) {
                    if (splitOneString[i].matches(".+\\b \\d{2}/\\d{2} \\b.+")) {
                        writer.println(splitOneString[i] + "\n");
                    }
                }
            }
            document.close();
            writer.close();


        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            System.out.println("Loading lines completed.");
        }
    }

    private String[] splitTheLastString(String string) {
        return string.split("(?<=\\.\\d\\d)");
    }

}
