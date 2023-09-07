import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> objects = new ArrayList<>();
        System.out.print("Enter the number of objects: ");
        int number = input.nextInt();
        System.out.print("Enter the weights of the objects: ");
        for (int i = 0; i < number; i++) {
            objects.add(input.nextInt());
        }
        int container = 1;
        while (!objects.isEmpty()) {
            System.out.println("Container " + container++ + " contains objects with weight " + getContainer(objects, 10));
        }
    }
    public static String getContainer(ArrayList<Integer> obj, int max) {
        StringBuilder contents = new StringBuilder();
        ArrayList<Integer> itemsToRemove = new ArrayList<>();
        ArrayList<Integer> objCopy = new ArrayList<>(obj.subList(0, obj.size()));
        for (int i = 0; i < objCopy.size(); i++) {
            if (objCopy.get(i) <= max) {
                contents.append(objCopy.get(i)).append(" ");
                itemsToRemove.add(obj.indexOf(objCopy.get(i)));
                max -= objCopy.get(i);
            }
        }
        for (int i : itemsToRemove) {
            obj.remove(i);
        }
        return contents.toString();
    }
}
