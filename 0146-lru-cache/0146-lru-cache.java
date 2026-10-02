class ListNode {

    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {

        this.key = key;
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class LRUCache {

    HashMap<Integer, ListNode> map = new HashMap<>();
    ListNode head = new ListNode(-1, -1);
    ListNode tail = new ListNode(-1, -1);
    int cap;

    public LRUCache(int capacity) {

        cap = capacity;
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {

        if(map.containsKey(key)){

            ListNode temp = map.get(key);
            int ans = temp.val;
           
            deleteNode(temp);
            addNode(temp);
        
            return ans;
        }
         
         return -1;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            ListNode temp = map.get(key);
            map.remove(key);
            deleteNode(temp);
        }

        if (map.size() == cap) {
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new ListNode(key, value));
        map.put(key, head.next);

    }

    public void addNode(ListNode newNode) {

        ListNode Next = head.next;
        head.next = newNode;
        newNode.next = Next;
        Next.prev = newNode;
        newNode.prev = head;
    }

    public void deleteNode(ListNode delNode) {

        ListNode prevv = delNode.prev;
        ListNode nextt = delNode.next;
        prevv.next = nextt;
        nextt.prev = prevv;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */