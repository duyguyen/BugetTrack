package factory;

import calculation.EndOfMonth;
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
    public EndOfMonth loadStatement(File file) throws IOException {
        ArrayList<Item> items = new ArrayList<>();
        String accountNumber = "";
        String period = "";

        try {
            Scanner scanner = new Scanner(file);
            String line;
            while (scanner.hasNext()) {
                line = scanner.nextLine().trim();

                // create items
                if (line.length() > 0) {
                    if (Utilities.defineAnItemLine(line)) { //(?s).*\b \d{2}/\d{2} \b.+ : (?s).* at the beginning makes . matches any character without exception


                        String[] splitItemLine = line.split(" ");
                        StringBuilder des = new StringBuilder();
                        double amount = Double.parseDouble(splitItemLine[splitItemLine.length - 1]);

                        if (Utilities.defineReferenceNumberSpending(splitItemLine[0].trim())||Utilities.defineReferenceNumberReward(splitItemLine[0].trim())){

                            for (int i = 3; i < splitItemLine.length - 1; i++) {
                                des.append(splitItemLine[i] + " ");
                            }
                            Expense expense = new Expense(splitItemLine[0], des.toString(), splitItemLine[1], splitItemLine[2],amount);
                            items.add(expense);
                        }else {
                            for (int i = 2; i < splitItemLine.length - 1; i++) {
                                des.append(splitItemLine[i] + " ");
                            }
                            Expense expense = new Expense(des.toString(), splitItemLine[0], splitItemLine[1],amount);
                            items.add(expense);
                        }
                    }else if(Utilities.defineAccountNumber(line)){
                        accountNumber = line;
                    }else if (Utilities.definePeriod(line)){
                        period = line;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("\n***Items has been loaded.***\n");
        }
        return new EndOfMonth(items, period, accountNumber);
    }
    // == private methods ==
}
