package com.company;

import java.util.Objects;

public class BinaryTree {

    Node root;

    public void addNode(Node newNode) {   //добавление нового узла по его значению

        if (root == null) {

            root = newNode;

        } else {

            Node additionalNode = root;

            Node parentNode;

            while (true) {

                parentNode = additionalNode;

                if (newNode.value < additionalNode.value) {

                    additionalNode = additionalNode.leftChild;

                    if (additionalNode == null) {

                        parentNode.leftChild = newNode;

                        parentNode.leftChild.parent = parentNode;

                        return;

                    }

                } else {

                    additionalNode = additionalNode.rightChild;

                    if (additionalNode == null) {

                        parentNode.rightChild = newNode;

                        parentNode.rightChild.parent = parentNode;

                        return;

                    }

                }

            }

        }

    }

    public void addNode(int value) {   //добавление существующего узла

        Node newNode = new Node(value);

        addNode(newNode);

    }

    public Node findNode(int value) {      // поиск по значению узла

        Node additionalNode = root;

        while (additionalNode.value != value) {

            if (value < additionalNode.value) {

                additionalNode = additionalNode.leftChild;

            } else {

                additionalNode = additionalNode.rightChild;

            }

            if (additionalNode == null) {

                return null;

            }

        }

        return additionalNode;

    }

    public Node findNode(Node node) {     //поиск по узлу

        return findNode(node.value);

    }

    public boolean contains(int value) {   //содержание по значению узла

        return findNode(value) != null;

    }

    public boolean contains(Node node) {   //содержание по узлу

        return findNode(node.value) != null;

    }

    public boolean deleteNode(int value) {

        Node additionalNode = root;

        Node parentNode = root;

        Boolean isLeftChild = true;

        while (additionalNode.value != value) {        //поиск узла и его родителя

            parentNode = additionalNode;

            if (value < additionalNode.value) {

                isLeftChild = true;

                additionalNode = additionalNode.leftChild;

            } else {

                isLeftChild = false;

                additionalNode = additionalNode.rightChild;

            }

            if (additionalNode == null) {

                return false;

            }

        }

        if (additionalNode.leftChild == null && additionalNode.rightChild == null) {   //узел не имеет детей

            if (additionalNode == root) {

                root = null;

            } else if (isLeftChild) {

                parentNode.leftChild = null;

            } else {

                parentNode.rightChild = null;

            }

        } else if (additionalNode.rightChild == null) {                              //узел имеет только левого ребенка

            if (additionalNode == root) {

                root = additionalNode.leftChild;

            } else if (isLeftChild) {

                parentNode.leftChild = additionalNode.leftChild;

                parentNode.leftChild.parent = parentNode;

            } else {

                parentNode.rightChild = additionalNode.leftChild;

                parentNode.rightChild.parent = parentNode;

            }

        } else if (additionalNode.leftChild == null) {                                //узел имеет только правого ребенка

            if (additionalNode == root) {

                root = additionalNode.rightChild;

            } else if (isLeftChild) {

                parentNode.leftChild = additionalNode.rightChild;

                parentNode.leftChild.parent = parentNode;

            } else {

                parentNode.rightChild = additionalNode.rightChild;

                parentNode.rightChild.parent = parentNode;

            }

        } else {                                                                    //у узла есть оба ребенка

            Node replacementNode = getReplacementNode(additionalNode);

            if (additionalNode == root) {

                root = replacementNode;

            } else if (isLeftChild) {

                parentNode.leftChild = replacementNode;

                parentNode.leftChild.parent = parentNode;

            } else {

                parentNode.rightChild = replacementNode;

                parentNode.rightChild.parent = parentNode;

            }

            replacementNode.leftChild = additionalNode.leftChild;

            replacementNode.leftChild.parent = replacementNode;

        }

        return true;

    }

    private Node getReplacementNode(Node replacedNode) {

        Node replacementParent = replacedNode;

        Node replacement = replacedNode;

        Node additionalNode = replacedNode.rightChild;

        while (additionalNode != null) {

            replacementParent = replacement;

            replacement = additionalNode;

            additionalNode = additionalNode.leftChild;

        }

        if (replacement != replacedNode.rightChild) {

            replacementParent.leftChild = replacement.rightChild;

            replacement.rightChild = replacedNode.rightChild;

            if (replacement.rightChild != null) {

                replacement.rightChild.parent = replacement;

            }

        }

        return replacement;

    }

    public String toString() {

        return toString(root).trim();

    }

    private String toString(Node root) {

        String output = "";

        if (root == null) return "";

        output += toString(root.leftChild);

        output += " " + root.value;

        output += toString(root.rightChild);

        return output;
    }

    public boolean equals(BinaryTree other) {

        return toString(root).equals(toString(other.root));

    }

    @Override
    public int hashCode() {           // ???

        return Objects.hash(root);

    }

}

class Node {

    int value;

    Node parent;

    Node rightChild;

    Node leftChild;

    Node(int value) {

        this.value = value;

    }

    public String toString() {

        return "Value: " + value;

    }

}
