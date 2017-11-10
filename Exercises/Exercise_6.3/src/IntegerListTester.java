public class IntegerListTester {
    public static void main(String[] args) {
        IntegerList list = new IntegerList();
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(7);
        list.add(1);
        list.add(2);
        list.insert(10, 0);
        list.remove(1);
        list.swap(0, 1);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
        list.sort();
        System.out.println(list);
    }
}
