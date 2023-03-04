package Ex1;

public class AVLTree<T> {
    private AVLNode<T> root;

    public AVLNode<T> insert(int key, T data){
        return insert(key, data, root);
    }

    public AVLNode<T> insert(int key,T data, AVLNode<T> node){
        if(node == null){
            return new AVLNode<>(key, data);
        }

        if(key < node.getKey()){
            node.setRight(insert(key, data, node.getLeft()));
        }
        else if(key > node.getKey()){
            node.setRight(insert(key, data, node.getRight()));
        }
        return balanceTree(key, node);
    }

    private AVLNode<T> balanceTree(int key, AVLNode<T> node){
        int balance = node.getBalance();

        if(balance > 1 ){
            //LL
            if(key < node.getLeft().getKey()){
                return AVLTreeHelper.rotateLeft(node);
            }
            //LR
            else if(key > node.getLeft().getKey()){
                AVLNode<T> tmpRoot = AVLTreeHelper.rotateRight(node.getLeft());
                node.setLeft(tmpRoot);
                return AVLTreeHelper.rotateLeft(node);
            }
        }

        if(balance < -1){
            //RR
            if(key > node.getRight().getKey()){
                return AVLTreeHelper.rotateRight(node);
            }
            //RL
            else if(key < node.getRight().getKey()){
                AVLNode<T> tmpRoot = AVLTreeHelper.rotateLeft(node.getRight());
                node.setRight(tmpRoot);
                return AVLTreeHelper.rotateRight(node);
            }
        }

        return node;
    }
}