import java.util.*;

public class StockTradingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Stock> stockMarket = new HashMap<>();

        // Sample stocks
        stockMarket.put("AAPL", new Stock("AAPL", 180.50));
        stockMarket.put("GOOG", new Stock("GOOG", 2750.30));
        stockMarket.put("TSLA", new Stock("TSLA", 695.20));
        stockMarket.put("AMZN", new Stock("AMZN", 3500.10));

        Portfolio portfolio = new Portfolio();

        while (true) {
            System.out.println("\n===== Stock Trading Platform =====");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n===== Market Data =====");
                    for (Stock s : stockMarket.values()) {
                        System.out.printf("%s: %.2f\n", s.getSymbol(), s.getPrice());
                    }
                    break;

                case 2:
                    System.out.print("Enter stock symbol to buy: ");
                    String buySymbol = scanner.next().toUpperCase();
                    if (stockMarket.containsKey(buySymbol)) {
                        System.out.print("Enter quantity: ");
                        int qty = scanner.nextInt();
                        portfolio.buyStock(buySymbol, qty);
                        System.out.println("Bought " + qty + " shares of " + buySymbol);
                    } else {
                        System.out.println("Stock not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter stock symbol to sell: ");
                    String sellSymbol = scanner.next().toUpperCase();
                    if (stockMarket.containsKey(sellSymbol)) {
                        System.out.print("Enter quantity: ");
                        int qty = scanner.nextInt();
                        portfolio.sellStock(sellSymbol, qty);
                        System.out.println("Sold " + qty + " shares of " + sellSymbol);
                    } else {
                        System.out.println("Stock not found!");
                    }
                    break;

                case 4:
                    portfolio.viewPortfolio(stockMarket);
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
