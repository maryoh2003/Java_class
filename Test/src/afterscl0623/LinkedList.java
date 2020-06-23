package afterscl0623;

public class LinkedList {

    public static void main(String[] args){

        Problem list = new Problem();

        list.add(100);
        list.add(200);
        list.add(400);
        list.add(500);
        System.out.println(list);

        list.add(2, 300);
        list.addFirst(50);
        System.out.println(list);

        System.out.println(list.get(4));

        list.remove(2);
        list.remove(new Integer(400));
        System.out.println(list);

        list.removeFirst();
        list.removeLast();
        System.out.println(list);

        System.out.println("ũ�� : " + list.size());

    }

}