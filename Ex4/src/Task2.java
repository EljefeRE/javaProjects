
/*
2. Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди,
не удаляя. * реализовать вторую задачу через собственный класс используя в основе массив
 */
public class Task2 {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        System.out.println("Список пустой " + queue.isEmpty());
        System.out.println("Размер списка " + queue.getSize());
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Размер списка " + queue.getSize());
        System.out.println(queue.first());
        System.out.println("Размер списка " + queue.getSize());
        System.out.println(queue.dequeue());
        System.out.println("Размер списка " + queue.getSize());
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.first());
        System.out.println("Размер списка " + queue.getSize());
        System.out.println(queue.dequeue());
        System.out.println("Размер списка " + queue.getSize());

    }
}
