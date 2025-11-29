package com.upuphone.runasone.channel;

import com.upuphone.runasone.utils.LogUtil;

class ILinkedImpl<T> implements ILinked<T> {
    /* access modifiers changed from: private */
    public Object[] allNodes;
    private int foot = 0;
    private String name;
    private int num;
    private Node root;

    public final class Node<T> {
        /* access modifiers changed from: private */
        public T data;
        /* access modifiers changed from: private */
        public Node next;

        public void addNode(Node node) {
            Node node2 = this.next;
            if (node2 == null) {
                this.next = node;
            } else {
                node2.addNode(node);
            }
        }

        public boolean containsNode(T t) {
            T t2 = this.data;
            if (t2 == null && t == null) {
                return true;
            }
            if (!(t2 == null || t == null)) {
                if (t2.equals(t)) {
                    return true;
                }
                Node node = this.next;
                if (node != null) {
                    return node.containsNode(t);
                }
            }
            return false;
        }

        public T getById(Integer num) {
            if (num.intValue() == ILinkedImpl.access$108(ILinkedImpl.this)) {
                return this.data;
            }
            Node node = this.next;
            if (node != null) {
                return node.getById(num);
            }
            return null;
        }

        public void modifyNode(Integer num, T t) {
            if (num.intValue() == ILinkedImpl.access$108(ILinkedImpl.this)) {
                this.data = t;
                return;
            }
            Node node = this.next;
            if (node != null) {
                node.modifyNode(num, t);
                return;
            }
            LogUtil.e("modifyNode index <" + num + "> is not exist");
        }

        public void removeNode(Node node, T t) {
            if (this.data.equals(t)) {
                node.next = this.next;
                return;
            }
            Node node2 = this.next;
            if (node2 != null) {
                node2.removeNode(this, t);
            }
        }

        public void returnAll() {
            ILinkedImpl.this.allNodes[ILinkedImpl.access$108(ILinkedImpl.this)] = this.data;
            Node node = this.next;
            if (node != null) {
                node.returnAll();
            }
        }

        private Node(T t) {
            this.data = t;
        }
    }

    public ILinkedImpl(String str) {
        this.name = str;
    }

    public static /* synthetic */ int access$108(ILinkedImpl iLinkedImpl) {
        int i = iLinkedImpl.foot;
        iLinkedImpl.foot = i + 1;
        return i;
    }

    public void add(T t) {
        if (t != null) {
            synchronized (this) {
                try {
                    Node node = new Node(t);
                    Node node2 = this.root;
                    if (node2 == null) {
                        this.root = node;
                    } else {
                        node2.addNode(node);
                    }
                    this.num++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public boolean contains(T t) {
        Node node;
        if (t == null || (node = this.root) == null) {
            return false;
        }
        return node.containsNode(t);
    }

    public int getCount() {
        return this.num;
    }

    public String getName() {
        return this.name;
    }

    public T getNodeById(Integer num2) {
        T t = null;
        if (this.num == 0 || num2.intValue() >= this.num) {
            return null;
        }
        synchronized (this) {
            try {
                this.foot = 0;
                Node node = this.root;
                if (node != null) {
                    t = node.getById(num2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t;
    }

    public boolean isEmpty() {
        return this.root == null || getCount() == 0;
    }

    public void modifyById(Integer num2, T t) {
        if (num2.intValue() < this.num) {
            synchronized (this) {
                try {
                    this.foot = 0;
                    Node node = this.root;
                    if (node != null) {
                        node.modifyNode(num2, t);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void remove(T t) {
        synchronized (this) {
            try {
                if (contains(t)) {
                    if (this.root.data.equals(t)) {
                        this.root = this.root.next;
                    } else {
                        Node node = this.root;
                        node.removeNode(node, t);
                    }
                    this.num--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeAll() {
        this.root = null;
        this.num = 0;
    }

    public void removeRoot() {
        synchronized (this) {
            try {
                Node node = this.root;
                if (node != null) {
                    this.root = node.next;
                    this.num--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Object[] returnAll() {
        if (isEmpty()) {
            return null;
        }
        synchronized (this) {
            this.foot = 0;
            this.allNodes = new Object[this.num];
            this.root.returnAll();
        }
        return this.allNodes;
    }
}
