package afterscl0623;

public class Problem {

    private Node header;
    private int size;

    public Problem() {

        header = new Node(null); // ù �����ÿ� ����Ǵ� ���
        size = 0; // ���ȿ��� �ƹ��͵� �����Ƿ� �翬�� size�� 0.
    }

    // �ܼ� ���� ����Ʈ ���
    private class Node {

        private Object data; // ��ü data ����
        private Node nextNode; // ���� ���� �̾��ִ� ��� ����

        Node(Object data) { //������

            this.data = data; // �Ű������� �޾ƿ� ��ü�� ����
            this.nextNode = null; // ���� ��尡 �����Ƿ� �ϴ��� null�� ����
        }

    }

    // index ��ġ�� ��� �����͸� ��ȯ�Ѵ�.
    public Object get(int index) {
        return getNode(index).data; //return Ÿ���� ���ؼ�  getNode �޼ҵ��� ������ ��ü�� ��ȯ��Ų��.
    }

    // index ��ġ�� ��带 ��ȯ�Ѵ�.
    private Node getNode(int index) {

        if (index < 0 || index >= size) { // ���� �ε����� 0���� �۰ų� size���� ũ�ٸ�
            throw new IndexOutOfBoundsException(
                    "Index : " + index + ", Size : " + size); // ����  ��½�Ű�� : IndexOfBoundsExcetion
        }

        Node node = header.nextNode; // ó������ �������� ���� ��� ����
        for (int i = 0; i < index; i++) { // �ε����� �� ��ŭ i++
            node = node.nextNode; // ����ؼ� �������� ���� ��� ����
        }

        return node; // ��� ��ȯ
    }

    // ù��° ����� �����͸� ��ȯ�Ѵ�.
    public Object getFirst() {
        return get(0); // �ش� ��ü�� ù��° ��� ��ȯ
    }

    // �ش� �������� ��� ��ġ index�� ��ȯ�Ѵ�.
    public int getNodeIndex(Object obj) {

        if (size <= 0) { // size�� 0���϶��
            return -1; // �޼ҵ� ������
        }

        int index = 0; // �ε��� 0 �ʱ�ȭ
        Node node = header.nextNode; // ù��° ����� ���� ��带 �Ѵ�.
        Object nodeData = node.data; // �ش� ����� �����͸� �ҷ��´�.

        // header���� ���� ���������� nodeData�� ���� ���Ѵ�.
        while (!obj.equals(nodeData)) { // �޾ƿ� ��ü�� ����� �����Ϳ� ��ġ�Ѵٸ�
            node = node.nextNode; // ���� ���� ����.

            if (node == null) { // ����� ���� null�̶��
                return -1; // �޼ҵ� ������
            }

            nodeData = node.data; // ���� ����� ������ ��������
            index++; // �ε����� �߰��Ѵ�.
        }

        return index; // �ε��� (ũ��)�� ȣ�� 
    }

    // data�� ����Ʈ�� ù��°�� �����Ѵ�.
    public void addFirst(Object data) { // 0��° �ε����� ������ ��ü�� �Ű������� �޾ƿͼ� ���� ���� �޼ҵ�

        Node newNode = new Node(data); // ���ο� ��� ����
        newNode.nextNode = header.nextNode; // �ش� ����� ���� ����� �ּҰ��� ����� �ּҰ��� ���Ͻ� �����ش�.
        header.nextNode = newNode; // ����� ���� ��带 �ش� ���� �̾��ش�.
        size++; // size�� ���� ��Ų��.

    }

    // index ��ġ�� data�� �����Ѵ�.
    public void add(int index, Object data) { // �ε����� ���� ��ü�� �Ű������� �޴´�.

        if (index == 0) { // �ε����� 0�̶��
            addFirst(data); // ù��°�� �����͸� �־��ش�.
            return;
        }

        Node previous = getNode(index - 1); // �ε����� �� ��带 �������� ���� �ܰ�
        Node next = previous.nextNode; // �ش� ����� ���� ����� �ּҰ����� �������ش�.

        Node newNode = new Node(data); // ���ο� ���
        previous.nextNode = newNode; // ���� ����� ���� ��带 ���ο� ���� �̾��ش�.
        newNode.nextNode = next; // �ش� ����� ���� ��带 ���������ν�, ��尡 ���������� �̾�����.
        size++; // ��尡 �ϳ� �߰��� �Ǿ�������, size�� ����
    }

    // ����Ʈ�� �������� data �� �����Ѵ�.
    public void addLast(Object data) { // �������� ���� ��ü�� �޼ҵ�
        add(size, data); // �ش� ������� ������ ��ü�� �־��ش�.
    }

    // ����Ʈ�� �������� data�� �����Ѵ�.
    public void add(Object data) { // add�� �޼ҵ� ��ü�� �ٸ��� �������ν� �� �޼ҵ�� �ٸ��ٴ� ���� �ǹ��ϰ� ��.
        addLast(data); // addLast�� ���� ��ü ( �ش� ���� �޼ҵ带 ȣ�� )
    }

    // ù��° ��带 �����ϰ� �����͸� ��ȯ�Ѵ�.
    public Object removeFirst() {

        Node firstNode = getNode(0); // ����� ù��° ���� �������� �Ѵ�.
        header.nextNode = firstNode.nextNode; // ����� ���� ��带 ù��° ����� ���� ���� �̾��ش�.
        size--; // size�� ���δ�.
        return firstNode.data; // ù��° ����� �����͸� ��ȯ�����ش�.

    }

    // index ��ġ�� ��带 �����ϰ� �����͸� ��ȯ�Ѵ�.
    public Object remove(int index) { // �����ϴ� �޼ҵ��̴�.

        if (index < 0 || index >= size) { // ���� �ε����� 0�̸��̰ų� �ε����� size �̻��̶��

            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size); // ����ó���� �����ش�. ( IndexOutOfBoundsException )

        } else if (index == 0) { // ���� �ε����� 0�̶��

            return removeFirst(); // ù��° �ε����� ����� �޼ҵ带 ȣ���Ѵ�.

        }

        Node previous = getNode(index - 1); // �ش� ����� ���� ��带 �����´�.
        Node removeNode = previous.nextNode; // ���� ����� ���� ��带 ������ ���� �������ش�.
        Node next = removeNode.nextNode; // ������  ����� ���� ��带 �����´�.
        previous.nextNode = next; // ���� ����� ���� ����� ������ �����ְ�, ������ ����� ���� ���� �̾��ش�.
        size--; // size�� ���ش�.

        return removeNode.data; // ���� ���� ���ؼ� ������ �������� ���� ȣ�����ش�.
    }

    // ����Ʈ���� data�� ���� ��带 �����ϰ� ���ſ��θ� ��ȯ�Ѵ�.
    public boolean remove(Object data) {

        int nodeIndex = getNodeIndex(data); // ��� �ε����� int������ �������ְ�  �ش� ��ü�� �Ű������� �ϴ� �ε����� ���� �����´�.

        if (nodeIndex == -1) { // �ش� ��ü�� ���� ��� ���� ���ٸ� -1�� ��ȯ�����ν�
            return false; // false�� ��ȯ�Ѵ�.
        } else {
            remove(nodeIndex); // �ƴϸ� �ش� ��带 ��ȯ�Ѵ�.
            return true; // �ش� ��尡 ������ ��ٴ°��� �˷��ֱ� ���� true ��ȯ.
        }
    }

    // ����Ʈ�� ������ ��带 �����ϰ� �����͸� ��ȯ�Ѵ�.
    public Object removeLast() { // ������ ��带 �����ϱ� ���� �޼ҵ�
        return remove(size - 1); // ��ü ũ���� -1�� �Ű������� �־ �ش� ������ ��带 �����ϴ� �޼ҵ带 ȣ���϶�� ��ȯ ��Ų��.
    }

    // ����Ʈ�� ũ�⸦ ��ȯ�Ѵ�.
    public int size() {
        return size; // ũ�� ��ȯ.
    }

    // ����Ʈ�� ������ String���� ��ȯ
    public String toString() { // �����͸� String���� ��ȯ ��Ű�� ���� �޼ҵ�

        StringBuffer result = new StringBuffer("["); // StringBuffer�� �츮�� ��� ���� �� �� �ְ� ������ش�. �ʱ� ���� ���ȣ ����.
        Node node = header.nextNode; // ����� ���� ��带 ���� �������ش�.

        if (node != null) { // ����� ���� null�� �ƴ϶��
            result.append(node.data); // �ش� StringBuffer�� ��� �����͸� �߰����ش�.
            node = node.nextNode; // ����� ������ �����´�.

            while (node != null) { // �ش� ����� �����͸� ����ؼ� �������� ���� ����.
                result.append(", "); // �����ϱ� ���� ��
                result.append(node.data); // node.data�� ����ؼ� �߰����ش�.
                node = node.nextNode; // ����� ���� ��带 �߰����ش�.
            }
        }

        result.append("]"); // �ش� �۾��� �������� �˸��� ���� ���ȣ �ݱ�
        return result.toString();
    }

}
