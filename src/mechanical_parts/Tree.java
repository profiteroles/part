package mechanical_parts;

public class Tree<Node> {

    // nested Node Class
    private class Node<T> {

        // Variables
        public T data;
        public Node left;
        public Node right;

        // constructor of the Node class
        public Node(T data) {
            this.data = data;
        }
    }

    private Node rotationRR(Node parent){
        Node swap = parent.right;
        parent.right = swap.left;
        swap.left = parent;
        return swap;
    }

    private Node rotationLL ( Node parent){
        Node swap = parent.left;
        parent.left = swap.right;
        return swap;
        }

    private Node rotationLR(Node parent){
        Node swap = parent.left;
        parent.left = rotationRR(swap);
        return rotationLL(parent);
    }

    private Node rotationRL(Node parent){
        Node swap = parent.right;
        parent.right = rotationLL(parent);
        return rotationRL(parent);
    }

    // Root of a tree
    Node root;

    // Constructor
    public Tree() {
    }

    //finds the root of the tree
    public String findRoot() {

        if (root != null) {
            return root.data.toString();
        } else {
            return "Tree doesn't exist";
        }
    }

    //finds the node 
    private Node find(Node current, String target) {
        if (current.data == null) {
            return null;
        } else if (target == current.data) { //or replace with compareTo == 0 (same)
            return current;
        } else if (target.compareTo(current.data.toString()) < 0) {
            return find( current.left, target);
        } else if (target.compareTo(current.data.toString()) > 0) {
            return find(current.right, target);
        }
        return current;
    }
    
    //search key via find node
    public void find(String key) {
        try {
            if (find(root, key).data == key) {
                System.out.println("\"" + key + "\" was found!");
            }
        } catch (NullPointerException npe) {
            System.out.println("Nothing has Found");
        }
    }
    

    //add new Node
    public void add(String data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            root = recursiveInsert(root, newNode);
        }
    }

    //Balancely insert a new Node to a tree
    private Node recursiveInsert(Node current, Node newNode){
        if(current == null){
            current = newNode;
            return current;

            //if new Node smaller goes to left
        }else if( newNode.data.toString().compareTo(current.data.toString()) < 0){
            current.left = recursiveInsert(current.left, newNode);
            current = balanceTree(current);

            //if new Node Bigger than goes to the right
        }else if(newNode.data.toString().compareTo(current.data.toString()) > 0){
            current.right = recursiveInsert(current.right, newNode);
            current = balanceTree(current);
        }
        // becomes a new Node
        return current;
    }

    //tree starts from 0
    private Node resetTree(Node node){
        try{
            if(delete(node, node.data.toString()) != null){
                System.out.println("Tree is deleted");
            }
        }catch(NullPointerException npe){
            System.out.println("Tree is empty");

        }
        return null;
    }

    public void resetTree(){
        root = resetTree(root);
    }

    public void displayTree(){
        if(root == null){
            System.out.println("No tree is Exist");
            return;
        }
        displayTree(root);
        

    }

    private void displayTree(Node current){
        if(current != null){
            displayTree(current.left);
            System.out.println(current.data);
            displayTree(current.right);
        }
    }

    //delete function of private delete function
    public void delete(String selectedNode){
        try{
            root = delete(root, selectedNode);
            if(root.data != null){
                System.out.println(selectedNode + " is deleted!");
            }
        }catch(NullPointerException nuException ){
            System.out.println(selectedNode + " doesn't Exist");
        }
    }

    //Delete Function
    private Node delete(Node current, String target) {
        Node parent;
        if (current.data == null) {
            return null; //tree is empty
        } else {
            //left subtree
            if (target.compareTo(current.data.toString()) < 0) { //target < data
                current.left = delete(current.left, target);
                if (balanceFactor(current) == -2) {
                    if (balanceFactor(current.right) <= 0) {
                        current = rotationRR(current);
                    } else {
                        current = rotationRL(current);
                    }
                }
            } //right subtree
            else if (target.compareTo(current.data.toString()) > 0) { //target > data
                current.right = delete(current.right, target);
                if (balanceFactor(current) == 2) {
                    if (balanceFactor(current.left) >= 0) {
                        current = rotationLL(current);
                    } else {
                        current = rotationLR(current);
                    }
                }
            } //if target is found
            else {
                if (current.right != null) {
                    //delete its inorder successor
                    parent = current.right;
                    while (parent.left != null) {
                        parent = parent.left;
                    }
                    current.data = parent.data;
                    current.right = delete(current.right, parent.data.toString());
                    if (balanceFactor(current) == 2)//rebalancing
                    {
                        if (balanceFactor(current.left) >= 0) {
                            current = rotationLL(current);
                        } else {
                            current = rotationLR(current);
                        }
                    }
                } else { //if current.left != null
                    return current.left;
                }
            }
            return current;
        }
    }
    

    //Balances the tree
    private Node balanceTree(Node current){
        int balanceFactor = balanceFactor(current);
        if(balanceFactor > 1){
            if(balanceFactor(current.left) > 0){
                current = rotationLL(current);
            }else{
                current = rotationLR(current);
            }
        }else if(balanceFactor < -1 ){
            if(balanceFactor(current.right)  > 0){
                current = rotationRL(current);
            }else{
                current = rotationRR(current);
            }
        }
        return current;
    }

    private int max (int left, int right){
        return left > right ? left : right;
    }
    //check if the tree if tree is out of balance result one of the 3 {-1, 0, 1}
    private int balanceFactor(Node current){

        int left = getHeight(current.left);
        int right = getHeight(current.right);
        int balanceFactor = left - right;
        return balanceFactor;
    }

    private int getHeight(Node current){
        int height = 0;
        if(current !=null){
            int left = getHeight(current.left);
            int right = getHeight(current.right);
            int max = max(left, right);
            height = max + 1;
        }
        return height;
    }


}
