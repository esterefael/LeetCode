/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/


class Solution {
    Node parent;
    public Node connect(Node root) {
        
        parent = root;
        
        while(parent != null){
            
            Node next1 = getNext();
            Node nextLevel = next1;

            while(parent != null){

                Node next2;
                if(parent.left == next1 && parent.right != null){
                    
                    next2 = parent.right;
                    parent = parent.next;                
                }
                else{
                    
                    if(parent.left == next1 && parent.right == null)
                        parent = parent.next;                        
                    next2 = getNext();                   
                } 

                next1.next = next2;
                next1 = next2;
            }
            parent = nextLevel;           
        }
        return root;
    }
    public Node getNext(){
        Node next = null;
        while(parent != null && next == null){
            
            next = parent.left;
            if(next == null){
                
                next = parent.right;
                parent = parent.next;
            }
        }
        return next;
    }
}