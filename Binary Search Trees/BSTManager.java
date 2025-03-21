//Manager class for Binary Search Tree
//This class contains the implementation of the Binary Search Tree
//It asks the user for the choice of operation to be performed on the BST
//The user can add a member by entering the ID, First Name, Last Name, Address, and City
//The user can remove a member by entering the ID of the member to be removed
//The user can search for a member by entering the ID of the member to be searched
//The user can display the BST in In-Order, Pre-Order, and Post-Order


public class BSTManager {

    //Node class for the BST
    //Contains the member object and the left and right child of the node
    private class Node {
        Member member;
        Node left, right;
        
        public Node(Member member) {
            this.member = member;
            left = right = null;
        }
    }
    
    private Node root;
    
    //Constructor to initialize the root of the BST
    public void add(Member member) {
        root = addRecursive(root, member);
    }
    
    //Method to add a member to the BST
    private Node addRecursive(Node current, Member member) {
        if (current == null) return new Node(member);
        
        //If the memberID to be added is less than the current memberID, then move to the left child
        //If the memberID to be added is greater than the current memberID, then move to the right child
        if (member.memberId < current.member.memberId) {
            current.left = addRecursive(current.left, member);
        } else if (member.memberId > current.member.memberId) {
            current.right = addRecursive(current.right, member);
        }
        return current;
    }
    
    //Method to search for a member in the BST
    public Member search(int memberId) {
        return searchRecursive(root, memberId);
    }
    
    //Method to search for a member in the BST recursively
    private Member searchRecursive(Node current, int memberId) {
        if (current == null) return null;
        if (memberId == current.member.memberId) return current.member;
        return memberId < current.member.memberId ? searchRecursive(current.left, memberId) : searchRecursive(current.right, memberId);
    }
    
    //Method to remove a member from the BST
    public void remove(int memberId) {
        root = removeRecursive(root, memberId);
    }
    
    //Method to remove a member from the BST recursively
    private Node removeRecursive(Node current, int memberId) {
        if (current == null) return null;
        
        //If the memberID to be removed is less than the current memberID, then move to the left child
        //If the memberID to be removed is greater than the current memberID, then move to the right child
        if (memberId < current.member.memberId) {
            current.left = removeRecursive(current.left, memberId);
        } else if (memberId > current.member.memberId) {
            current.right = removeRecursive(current.right, memberId);
        } else {
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;
            
            Node smallest = findSmallest(current.right);
            current.member = smallest.member;
            current.right = removeRecursive(current.right, smallest.member.memberId);
        }
        return current;
    }
    
    //Method to find the smallest node in the BST
    private Node findSmallest(Node root) {
        return root.left == null ? root : findSmallest(root.left);
    }
    
    //Method to display the BST in In-Order of memberID
    public void inOrder() {
        inOrderRecursive(root);
    }
    
    //Method to display the BST in In-Order of memberID recursively
    private void inOrderRecursive(Node current) {
        if (current != null) {
            inOrderRecursive(current.left);
            System.out.println(current.member);
            inOrderRecursive(current.right);
        }
    }
    
    //Method to display the BST in Pre-Order of memberID
    public void preOrder() {
        preOrderRecursive(root);
    }
    
    //Method to display the BST in Pre-Order of memberID recursively
    private void preOrderRecursive(Node current) {
        if (current != null) {
            System.out.println(current.member);
            preOrderRecursive(current.left);
            preOrderRecursive(current.right);
        }
    }
    
    //Method to display the BST in Post-Order of memberID
    public void postOrder() {
        postOrderRecursive(root);
    }
    
    //Method to display the BST in Post-Order of memberID recursively
    private void postOrderRecursive(Node current) {
        if (current != null) {
            postOrderRecursive(current.left);
            postOrderRecursive(current.right);
            System.out.println(current.member);
        }
    }
}