package ru.javarush.tepliakov.quest.quest.model;

import java.util.HashMap;
import java.util.Map;

public class TreeNode {
    private int id;
    private String data;

    private String linkToImage;
    private TreeNode parent;
    private Map<Integer, TreeNode> children;

    public TreeNode(int id, String data, String linkToImage) {
        this.id = id;
        this.data = data;
        this.linkToImage = linkToImage;
        this.parent = null;
        this.children = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public String getLinkToImage() {
        return linkToImage;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public void addChild(TreeNode child) {
        child.setParent(this);
        children.put(child.getId(), child);
    }

    public TreeNode getChildById(int id) {
        return children.get(id);
    }

    public void display() {
        System.out.println("Id: " + id + ", Data: " + data);
        if (parent != null) {
            System.out.println("Parent: " + parent.getId());
        }
        if (!children.isEmpty()) {
            System.out.print("Children: ");
            for (TreeNode child : children.values()) {
                System.out.print(child.getId() + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
