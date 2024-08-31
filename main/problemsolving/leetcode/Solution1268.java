package problemsolving.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1268 {
    /*
     * 1 <= products.length <= 1000
     * 1 <= products[i].length <= 3000
     * 1 <= sum(products[i].length) <= 2 * 10^4
     * All the strings of products are unique.
     * products[i] consists of lowercase English letters.
     * 1 <= searchWord.length <= 1000
     * searchWord consists of lowercase English letters.
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans;
        ans = new ArrayList<List<String>>();
        Arrays.asList(products);
        List<String> productList = new ArrayList<String>();
        for (String product : products) {
            productList.add(product);
        }
        productList.sort((o1, o2) -> o1.compareTo(o2));

        for (int i = 0; i < searchWord.length(); i++) {
            for (int j = 0; j < productList.size(); j++) {
                if (productList.get(j).length() > i && productList.get(j).startsWith(searchWord.substring(0, i + 1))) {
                    continue;
                } else {
                    productList.remove(j);
                    j--;
                }
            }
            List<String> searchList = new ArrayList<String>();
            for (int j = 0; j < Math.min(3, productList.size()); j++) {
                searchList.add(productList.get(j));
            }
            ans.add(searchList);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1268 solution1268 = new Solution1268();
        List<List<String>> ans;
        ans = solution1268.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse");
        ans = solution1268.suggestedProducts(new String[]{"havana"}, "havana");
        ans = solution1268.suggestedProducts(new String[]{"bags", "baggage", "banner", "box", "cloths"}, "bags");
    }
}
