package factory;

import item.Expense;
import item.Item;
import utilities.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Factory {

    // == constants ==
    // == constructor ==
    // == public methods ==
    public void loadStatement(File file) throws IOException {

        try {
            Scanner scanner = new Scanner(file);
            String line;
            int count = 1;
            ArrayList<Item> items = new ArrayList<>();
            String accountNumber = "";
            String period = "";

            while (scanner.hasNext()) {
                line = scanner.nextLine().trim();

                // create items
                if (line.length() > 0) {
                    if (Utilities.defineAnItemLine(line)) { //(?s).*\b \d{2}/\d{2} \b.+ : (?s).* at the beginning makes . matches any character without exception

                        String[] splitItemLine = line.split(" ");
                        StringBuilder des = new StringBuilder();
                        double amount = Double.parseDouble(splitItemLine[splitItemLine.length - 1]);

                        for (int i = 3; i < splitItemLine.length - 1; i++) {
                            des.append(splitItemLine[i] + " ");
                        }
                        Expense expense = new Expense(splitItemLine[0], des.toString(), splitItemLine[1], splitItemLine[2],amount);
                        items.add(expense);
                    }else if(Utilities.defineAccountNumber(line)){
                        accountNumber = line;
                    }else if (Utilities.definePeriod(line)){
                        period = line;
                    }else {
                        System.out.println(line);
                    }
                }


            }
//            System.out.println(items.size());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("\n***Items has been loaded.***\n");
        }
    }
    // == private methods ==
}
