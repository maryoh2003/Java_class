package afterscl0623;

public class Problem {

    private Node header;
    private int size;

    public Problem() {

        header = new Node(null); // 첫 생성시에 선언되는 노드
        size = 0; // 노드안에는 아무것도 없으므로 당연히 size는 0.
    }

    // 단순 연결 리스트 노드
    private class Node {

        private Object data; // 객체 data 선언
        private Node nextNode; // 다음 노드로 이어주는 노드 선언

        Node(Object data) { //생성자

            this.data = data; // 매개변수로 받아온 객체를 선언
            this.nextNode = null; // 다음 노드가 없으므로 일단은 null로 선언
        }

    }

    // index 위치의 노드 데이터를 반환한다.
    public Object get(int index) {
        return getNode(index).data; //return 타입을 통해서  getNode 메소드의 데이터 객체를 반환시킨다.
    }

    // index 위치의 노드를 반환한다.
    private Node getNode(int index) {

        if (index < 0 || index >= size) { // 만약 인덱스가 0보다 작거나 size보다 크다면
            throw new IndexOutOfBoundsException(
                    "Index : " + index + ", Size : " + size); // 예외  출력시키기 : IndexOfBoundsExcetion
        }

        Node node = header.nextNode; // 처음에서 다음으로 가는 노드 연결
        for (int i = 0; i < index; i++) { // 인덱스의 수 만큼 i++
            node = node.nextNode; // 계속해서 다음으로 가는 노드 연결
        }

        return node; // 노드 반환
    }

    // 첫번째 노드의 데이터를 반환한다.
    public Object getFirst() {
        return get(0); // 해당 객체의 첫번째 노드 반환
    }

    // 해당 데이터의 노드 위치 index를 반환한다.
    public int getNodeIndex(Object obj) {

        if (size <= 0) { // size가 0이하라면
            return -1; // 메소드 나오기
        }

        int index = 0; // 인덱스 0 초기화
        Node node = header.nextNode; // 첫번째 노드의 다음 노드를 한다.
        Object nodeData = node.data; // 해당 노드의 데이터를 불러온다.

        // header에서 부터 순차적으로 nodeData와 값을 비교한다.
        while (!obj.equals(nodeData)) { // 받아온 객체가 노드의 데이터와 일치한다면
            node = node.nextNode; // 다음 노드로 간다.

            if (node == null) { // 노드의 값이 null이라면
                return -1; // 메소드 나오기
            }

            nodeData = node.data; // 다음 노드의 데이터 가져오기
            index++; // 인덱스를 추가한다.
        }

        return index; // 인덱스 (크기)를 호출 
    }

    // data를 리스트의 첫번째에 삽입한다.
    public void addFirst(Object data) { // 0번째 인덱스에 데이터 객체를 매개변수로 받아와서 쓰기 위한 메소드

        Node newNode = new Node(data); // 새로운 노드 생성
        newNode.nextNode = header.nextNode; // 해당 노드의 다음 노드의 주소값을 헤더의 주소값과 동일시 시켜준다.
        header.nextNode = newNode; // 헤더의 다음 노드를 해당 노드로 이어준다.
        size++; // size를 증가 시킨다.

    }

    // index 위치에 data를 삽입한다.
    public void add(int index, Object data) { // 인덱스의 값과 객체를 매개변수로 받는다.

        if (index == 0) { // 인덱스가 0이라면
            addFirst(data); // 첫번째의 데이터를 넣어준다.
            return;
        }

        Node previous = getNode(index - 1); // 인덱스의 전 노드를 가져오기 위한 단계
        Node next = previous.nextNode; // 해당 노드의 다음 노드의 주소값으로 설정해준다.

        Node newNode = new Node(data); // 새로운 노드
        previous.nextNode = newNode; // 이전 노드의 다음 노드를 새로운 노드로 이어준다.
        newNode.nextNode = next; // 해당 노드의 다음 노드를 설정함으로써, 노드가 정상적으로 이어진다.
        size++; // 노드가 하나 추가가 되었음으로, size를 증가
    }

    // 리스트의 마지막에 data 를 삽입한다.
    public void addLast(Object data) { // 마지막에 넣을 객체의 메소드
        add(size, data); // 해당 사이즈와 데이터 객체를 넣어준다.
    }

    // 리스트의 마지막에 data를 삽입한다.
    public void add(Object data) { // add의 메소드 객체를 다르게 해줌으로써 두 메소드는 다르다는 것을 의미하게 함.
        addLast(data); // addLast를 통한 객체 ( 해당 위의 메소드를 호출 )
    }

    // 첫번째 노드를 제거하고 데이터를 반환한다.
    public Object removeFirst() {

        Node firstNode = getNode(0); // 노드의 첫번째 값을 가져오게 한다.
        header.nextNode = firstNode.nextNode; // 헤더의 다음 노드를 첫번째 노드의 다음 노드로 이어준다.
        size--; // size를 줄인다.
        return firstNode.data; // 첫번째 노드의 데이터를 반환시켜준다.

    }

    // index 위치의 노드를 제거하고 데이터를 반환한다.
    public Object remove(int index) { // 제거하는 메소드이다.

        if (index < 0 || index >= size) { // 만약 인덱스가 0미만이거나 인덱스가 size 이상이라면

            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size); // 예외처리를 시켜준다. ( IndexOutOfBoundsException )

        } else if (index == 0) { // 만약 인덱스가 0이라면

            return removeFirst(); // 첫번째 인덱스를 지우는 메소드를 호출한다.

        }

        Node previous = getNode(index - 1); // 해당 노드의 이전 노드를 가져온다.
        Node removeNode = previous.nextNode; // 이전 노드의 다음 노드를 제거할 노드로 선언해준다.
        Node next = removeNode.nextNode; // 제거할  노드의 다음 노드를 가져온다.
        previous.nextNode = next; // 이전 노드의 다음 노드의 연결을 끊어주고, 제거할 노드의 다음 노드로 이어준다.
        size--; // size를 빼준다.

        return removeNode.data; // 리턴 값을 통해서 제거한 데이터의 값을 호출해준다.
    }

    // 리스트에서 data를 가진 노드를 제거하고 제거여부를 반환한다.
    public boolean remove(Object data) {

        int nodeIndex = getNodeIndex(data); // 노드 인덱스를 int형으로 선언해주고  해당 객체를 매개변수로 하는 인덱스의 값을 가져온다.

        if (nodeIndex == -1) { // 해당 객체를 가진 노드 값이 없다면 -1을 반환함으로써
            return false; // false를 반환한다.
        } else {
            remove(nodeIndex); // 아니면 해당 노드를 반환한다.
            return true; // 해당 노드가 삭제가 됬다는것을 알려주기 위한 true 반환.
        }
    }

    // 리스트의 마지막 노드를 제거하고 데이터를 반환한다.
    public Object removeLast() { // 마지막 노드를 제거하기 위한 메소드
        return remove(size - 1); // 전체 크기의 -1를 매개변수로 넣어서 해당 마지막 노드를 제거하는 메소드를 호출하라고 반환 시킨다.
    }

    // 리스트의 크기를 반환한다.
    public int size() {
        return size; // 크기 반환.
    }

    // 리스트의 데이터 String으로 반환
    public String toString() { // 데이터를 String으로 반환 시키기 위한 메소드

        StringBuffer result = new StringBuffer("["); // StringBuffer로 우리가 노드 값을 알 수 있게 출력해준다. 초기 값은 대괄호 열기.
        Node node = header.nextNode; // 헤더의 다음 노드를 노드로 선언해준다.

        if (node != null) { // 노드의 값이 null이 아니라면
            result.append(node.data); // 해당 StringBuffer에 노드 데이터를 추가해준다.
            node = node.nextNode; // 노드의 다음을 가져온다.

            while (node != null) { // 해당 노드의 데이터를 계속해서 가져오기 위한 수행.
                result.append(", "); // 구분하기 위한 선
                result.append(node.data); // node.data를 계속해서 추가해준다.
                node = node.nextNode; // 노드의 다음 노드를 추가해준다.
            }
        }

        result.append("]"); // 해당 작업이 끝났음을 알리기 위한 대괄호 닫기
        return result.toString();
    }

}
