package Ex1;

public class AVLTreeHelper {
    public static <T> int getHeight(AVLNode<T> node){
        return node == null ? 0 : node.getHeight();
    }

    public static <T> AVLNode<T> rotateLeft(AVLNode<T> node){
        //turn left child to become node parent
        //reassign right child to left
        AVLNode<T> leftChild =  node.getLeft();
        AVLNode<T> tmp = leftChild.getRight();

        leftChild.setRight(node);
        node.setLeft(tmp);

        //update heights
        node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight()) + 1));
        leftChild.setHeight(Math.max(getHeight(leftChild.getLeft()), getHeight(leftChild.getRight()) + 1));

        //return result
        return leftChild;
    }

    public static <T> AVLNode<T> rotateRight(AVLNode<T> node){
        // turn right child to become node parent
        // reassign left child to right
        AVLNode<T> rightChild = node.getRight();
        AVLNode<T> tmp = rightChild.getLeft();

        rightChild.setLeft(node);
        node.setRight(tmp);

        // update heights
        node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        rightChild.setHeight(Math.max(getHeight(rightChild.getLeft()), getHeight(rightChild.getRight())) + 1);

        // return result
        return rightChild;
    }
}