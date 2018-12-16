package calculation;

import item.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Statistic {

    // == constance variables ==

    public Statistic() {
        init();
    }

    // == init ==
    private void init() {

    }

    // == public methods ==

    public void calculate(ArrayList<Item> items) {
//        for (int i = 0; i < items.size(); i++) {
//            Item item = items.get(i);
//            System.out.println(i + 1 + ". " + item.getDescriptionOrCredit() + " : " + item.getAmount());
//        }

        ArrayList<String> allDes = excludeDuplicate(items);
        HashMap<String, Integer> density = new HashMap<>(); // find density
        double sumExpense = 0.0; // find sum expenses

        int count = 0; // count density
        for (String string : allDes) {
            for (int i = 0; i < items.size(); i++) {
                String str = items.get(i).getDescriptionOrCredit().trim();
                if (string.equalsIgnoreCase(str)) {
                    count++;
                }
            }
            density.put(string, count);
            count = 0;
        }

        for (String name: density.keySet()){
            System.out.println(name + " : " + density.get(name));
        }
    }


    public void totalOfTopStore(ArrayList<Item> items, StringBuilder topStores) {
        String[] topStoreSplit = splitString(topStores.toString(), "::");
        HashMap<String, Integer> totalEachTop = new HashMap<>();
        double total = 0;

        for (String string : topStoreSplit) {
            String[] str = splitString(string, " : ");
            for (Item item : items) {
                if (str[0].trim().equalsIgnoreCase(item.getDescriptionOrCredit().trim())) {
                    total += item.getAmount();
                }
            }

            totalEachTop.put(str[0], (int) total);
            total = 0;

        }


        for (String name : totalEachTop.keySet()) {
            System.out.println(name + " : " + totalEachTop.get(name));
        }

    }

    public StringBuilder theTopStore(HashMap<String, Integer> stores) {
        int top = 0;
        for (String name : stores.keySet()) {
            if (top < stores.get(name)) {
                top = stores.get(name);
            }
            System.out.println(name + " : " + stores.get(name));

        }
        return findTopStoreByDensity(stores, top);
    }

    public HashMap<String, Integer> desDensity(ArrayList<Item> items) {
        ArrayList<String> allDes = excludeDuplicate(items);
        HashMap<String, Integer> density = new HashMap<>();
        int count = 0;
        for (String string : allDes) {
            for (int i = 0; i < items.size(); i++) {
                String str = items.get(i).getDescriptionOrCredit().trim();
                if (string.equalsIgnoreCase(str)) {
                    count++;
                }
            }
            density.put(string, count);
            count = 0;
        }
        return density;
    }

    public double sumExpense(ArrayList<Item> items) {
        double sumExpense = 0.0;
        for (Item item : items) {
            sumExpense += item.getAmount();
        }
        return sumExpense;
    }

    // == private methods ==
    private String[] splitString(String string, String regex) {
        return string.split(regex);
    }

    private StringBuilder findTopStoreByDensity(HashMap<String, Integer> stores, int density) {
        StringBuilder topStores = new StringBuilder();

        for (String name : stores.keySet()) {
            if (density == stores.get(name)) {
                topStores.append(name + " : " + stores.get(name) + " :: ");
            }
        }

        return topStores;
    }

    private ArrayList<String> excludeDuplicate(ArrayList<Item> items) {
        ArrayList<String> allDes = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < items.size(); i++) {

            String str1 = items.get(i).getDescriptionOrCredit().trim();

            if (checkDuplicate(allDes, str1)) {
                allDes.add(str1);
            }
        }
        return allDes;
    }

    private boolean checkDuplicate(ArrayList<String> strings, String string) {
        boolean result = true;
        string.trim();
        for (String str : strings) {
            if (string.equalsIgnoreCase(str.trim())) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }
}
