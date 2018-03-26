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
        assertEquals("Value: 5", testTree.getRoot().toString());
        assertEquals("Value: 3", testTree.getRoot().getLeftChild().toString());
        assertEquals("Value: 7", testTree.getRoot().getRightChild().toString());
    }

    @Test
    public void contains() {
        testTree.addNode(1);
        assertEquals(true, testTree.contains(1));
        assertEquals(false, testTree.contains(999));
    }

    @Test
    public void findNode () {
        testTree.addNode(1);
        assertEquals("Value: 1", testTree.findNode(1).toString());
    }

    @Test
    public void deleteNode() {

        BinaryTree treeOne = new BinaryTree();
        treeOne.addNode(10);
        treeOne.addNode(5);
        treeOne.addNode(15);
        treeOne.deleteNode(5);
        treeOne.deleteNode(15);
        assertEquals(null,treeOne.getRoot().getLeftChild());
        assertEquals(null,treeOne.getRoot().getRightChild());                         //удаление "листков"

        BinaryTree treeTwo = new BinaryTree();
        treeTwo.addNode(10);
        treeTwo.addNode(15);
        treeTwo.addNode(20);
        treeTwo.deleteNode(15);
        assertEquals("Value: 20", treeTwo.getRoot().getRightChild().toString());      //удаление элемента с правым ребенком

        BinaryTree treeThree = new BinaryTree();
        treeThree.addNode(10);
        treeThree.addNode(20);
        treeThree.addNode(13);
        treeThree.deleteNode(20);
        assertEquals("Value: 13", treeThree.getRoot().getRightChild().toString());      //удаление элемнта с левым ребенком

        BinaryTree treeFour = new BinaryTree();
        treeFour.addNode(10);
        treeFour.addNode(13);
        treeFour.addNode(11);
        treeFour.addNode(14);
        treeFour.deleteNode(13);
        assertEquals("Value: 14", treeFour.getRoot().getRightChild().toString());      //удаление элемента с двумя детьми
        assertEquals("Value: 11", treeFour.findNode(14).getLeftChild().toString());

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

        BinaryTree c = new BinaryTree();
        BinaryTree d = new BinaryTree();
        c.addNode(1);
        d.addNode(2);
        assertEquals(false, c.equals(d));

    }
}
