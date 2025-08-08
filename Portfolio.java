import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<String, Integer> holdings = new HashMap<>();

    public void buyStock(String symbol, int quantity) {
        holdings.put(symbol, holdings.getOrDefault(symbol, 0) + quantity);
    }

    public void sellStock(String symbol, int quantity) {
        if (holdings.containsKey(symbol)) {
            int currentQty = holdings.get(symbol);
            if (quantity >= currentQty) {
                holdings.remove(symbol);
            } else {
                holdings.put(symbol, currentQty - quantity);
            }
        }
    }

    public void viewPortfolio(Map<String, Stock> stockMarket) {
        System.out.println("\n===== Your Portfolio =====");
        double totalValue = 0.0;
        for (String symbol : holdings.keySet()) {
            int qty = holdings.get(symbol);
            double price = stockMarket.get(symbol).getPrice();
            double value = qty * price;
            totalValue += value;
            System.out.printf("%s - Qty: %d | Price: %.2f | Value: %.2f\n", symbol, qty, price, value);
        }
        System.out.printf("Total Portfolio Value: %.2f\n", totalValue);
    }
}
