class Node {

    public char value;
    public Node prev;
    public Node(char v) { value = v; }
    public Node prev(Node p) { prev = p; return this; }
}

class Solution {

    public int solution(String s) {

        final Node head = new Node((char)0); Node pivot = head;

        for (int i=0,l=s.length(); i<l; i++)
        if  (pivot.value==s.charAt(i)) pivot = pivot.prev;
        else pivot = new Node(s.charAt(i)).prev(pivot);

        return pivot==head? 1: 0;
    }
}
