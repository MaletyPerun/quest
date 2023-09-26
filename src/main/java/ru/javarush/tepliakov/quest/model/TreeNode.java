package ru.javarush.tepliakov.quest.model;

import java.util.HashMap;
import java.util.Map;

public class TreeNode {
    private long id;
    private String data;
    private TreeNode parent;
    private Map<Long, TreeNode> children;

    public TreeNode(long id, String data) {
        this.id = id;
        this.data = data;
        this.parent = null;
        this.children = new HashMap<>();
    }

    public long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public void addChild(TreeNode child) {
        child.setParent(this);
        children.put(child.getId(), child);
    }

    public TreeNode getChildById(long id) {
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
