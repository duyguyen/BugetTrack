package calculation;

import item.Item;
import stores.Store;

import java.util.ArrayList;
import java.util.HashMap;

public class Statistic {

    // == constance variables ==
    // == public methods ==
    public void theTopStore(ArrayList<Store> stores) {

        // set the top store
        stores.get(stores.size()-1).setTheTopStore(true);

        double topSpending = 0.0;
        for (Store store:stores){
            if (!store.isPayingDebt()){
//                System.out.println(store.getName() + " : " + store.getTotalSpending());
                if (topSpending<store.getTotalSpending()){
                    topSpending = store.getTotalSpending();
                }
            }
        }
//        System.out.println(topSpending);

    }

    public ArrayList<Store> createStores(ArrayList<Item> items) {

        ArrayList<Store> stores = new ArrayList<>();
        ArrayList<String> allDes = excludeDuplicate(items);
        int count = 0;
        double totalAmount = 0;

        for (String string : allDes) {
            for (int i = 0; i < items.size(); i++) {
                String str = items.get(i).getDescriptionOrCredit().trim();
                if (string.equalsIgnoreCase(str)) {
                    count++;
                    totalAmount += items.get(i).getAmount();
                }
            }
            // create store
            stores.add(new Store(string, count, Math.round(totalAmount * 100.0) / 100.0));
            count = 0;
            totalAmount = 0;
        }
        return stores;
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
