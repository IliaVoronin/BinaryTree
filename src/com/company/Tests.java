package com.company;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tests {

    private BinaryTree testTree = new BinaryTree();

    @Test
    public void addNode() {
        testTree.addNode(5);
        testTree.addNode(3);
        testTree.addNode(7);
        assertEquals("Value: 5", testTree.root.toString());
        assertEquals("Value: 3", testTree.root.leftChild.toString());
        assertEquals("Value: 7", testTree.root.rightChild.toString());
    }

    @Test
    public void contains() {
        testTree.addNode(1);
        assertEquals(true, testTree.contains(1));
        assertEquals(false, testTree.contains(999));
    }

    @Test
    public void findNode () {
        Node newNode = new Node(1);
        testTree.addNode(newNode);
        assertEquals("Value: 1", testTree.findNode(1).toString());
    }

    @Test
    public void deleteNode() {
        testTree.addNode(10);
        testTree.addNode(5);
        testTree.addNode(15);
        testTree.deleteNode(5);
        testTree.deleteNode(15);
        assertEquals(null,testTree.root.leftChild);
        assertEquals(null,testTree.root.rightChild);                         //удаление "листков"

        testTree.addNode(15);
        testTree.addNode(20);
        testTree.deleteNode(15);
        assertEquals("Value: 20", testTree.root.rightChild.toString());      //удаление элемента с правым ребенком

        testTree.addNode(13);
        testTree.deleteNode(20);
        assertEquals("Value: 13", testTree.root.rightChild.toString());      //удаление элемнта с левым ребенком

        testTree.addNode(11);
        testTree.addNode(14);
        testTree.deleteNode(13);
        assertEquals("Value: 14", testTree.root.rightChild.toString());      //удаление элемента с двумя детьми
        assertEquals("Value: 11", testTree.findNode(14).leftChild.toString());

    }

    @Test
    public void tooString() {
        testTree.addNode(50);
        testTree.addNode(30);
        testTree.addNode(10);
        testTree.addNode(40);
        testTree.addNode(5);
        testTree.addNode(15);
        testTree.addNode(35);
        testTree.addNode(45);
        assertEquals("5 10 15 30 35 40 45 50", testTree.toString());
    }

    @Test
    public void equals() {
        BinaryTree a = new BinaryTree();
        BinaryTree b = new BinaryTree();
        a.addNode(2);
        a.addNode(3);
        b.addNode(2);
        b.addNode(3);
        assertEquals(true, a.equals(b));
        b.addNode(1);
        assertEquals(false, a.equals(b));

    }

}
