public class DataSetTester {
    public static void main(String[] args) {
        DataSet dataSet = new DataSet();
        dataSet.addValue(2);
        dataSet.addValue(5);
        System.out.println("Sum");
        System.out.println("Expected: 7, Got: " + dataSet.getSum());
        System.out.println("Average");
        System.out.println("Expected: 3.5, Got: " + dataSet.getAverage());
        System.out.println("Max");
        System.out.println("Expected: 5, Got: " + dataSet.getMax());
        System.out.println("Min");
        System.out.println("Expected: 2, Got: " + dataSet.getMin());
    }
}
