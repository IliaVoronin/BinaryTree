package com.company;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tests {

    BinaryTree testTree = new BinaryTree();

    @Test
    public void addNode() {
        testTree.addNode(5,"root");
        testTree.addNode(3,"leftChild");
        testTree.addNode(7,"rightChild");
        assertEquals("root 5", testTree.root.toString());
        assertEquals("leftChild 3", testTree.root.leftChild.toString());
        assertEquals("rightChild 7", testTree.root.rightChild.toString());
    }

    @Test
    public void contains() {
        testTree.addNode(1,"testName");
        assertEquals(true, testTree.contains(1));
        assertEquals(false, testTree.contains(999));
    }

    @Test
    public void findNode () {
        Node newNode = new Node(1,"testName");
        testTree.addNode(newNode);
        assertEquals("testName 1", testTree.findNode(1).toString());
    }

    @Test
    public void deleteNode() {
        testTree.addNode(10,"a");
        testTree.addNode(5,"b");
        testTree.addNode(15,"c");
        testTree.deleteNode(5);
        testTree.deleteNode(15);
        assertEquals(null,testTree.root.leftChild);
        assertEquals(null,testTree.root.rightChild);                     //удаление "листков"

        testTree.addNode(15,"b");
        testTree.addNode(20,"c");
        testTree.deleteNode(15);
        assertEquals("c 20", testTree.root.rightChild.toString());      //удаление элемента с правым ребенком

        testTree.addNode(13, "d");
        testTree.deleteNode(20);
        assertEquals("d 13", testTree.root.rightChild.toString());      //удаление элемнта с левым ребенком

        testTree.addNode(11,"e");
        testTree.addNode(14,"f");
        testTree.deleteNode(13);
        assertEquals("f 14", testTree.root.rightChild.toString());      //удаление элемента с двумя детьми
        assertEquals("e 11", testTree.findNode(14).leftChild.toString());
    }
}
