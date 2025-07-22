public class ShoppingCart {
    // Calculate total price with discounts
    public static double calculateTotal(double[] prices, String customerType)
    {
        double total = 0;
// First, calculate sum of all prices using a loop
        for (int i=0;i < prices.length;i++){
            total +=prices[i];
        }
// Then apply discount based on customer type using switch:
        switch (customerType){
            case "REGULAR":
                 total=total;break;
            case "PREMIUM":
                total= total - (total * 0.1);break;
            case "VIP":
                total= total - (total * 0.2);break;
        }
        return total;
    }
    // Find most expensive item
    public static double findMostExpensive(double[] prices) {
        double mostexpensive =0;
        if (prices.length==0){
            System.out.println("array is empty");
        }
        for (int i=0;i < prices.length;i++){
            if (mostexpensive<prices[i]){
                mostexpensive =prices[i];
            }

        }
        return mostexpensive;
// Handle empty array
    }
    // Count items above a certain price
    public static int countExpensiveItems(double[] prices, double threshold)
    {
// Count how many items cost more than threshold
        int count = 0;
        for (int i=0;i < prices.length;i++) {
            if (prices[i] > threshold) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        double[] cart = {25.99, 45.50, 12.99, 89.99, 15.75};
// Test with different customer types
// Find most expensive item
// Count items over $30
        System.out.println("Regular customer total: $" + calculateTotal(cart,
                "REGULAR"));
        System.out.println("Premium customer total: $" + calculateTotal(cart,
                "PREMIUM"));
        System.out.println("VIP customer total: $" + calculateTotal(cart,
                "VIP"));

        System.out.println("Most expensive item: " + findMostExpensive(cart));

        // Count items over $30
        System.out.println("Items over threshold: " + countExpensiveItems(cart, 25));
    }
    }
