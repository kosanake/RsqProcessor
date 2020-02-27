package com.segment.processor;

/**
 * Sum on segment (with adding value to segment)
 */
public class RsqSegmentProcessor {
    int[] source;
    int[] tree;
    int[] stree;

    public RsqSegmentProcessor(int[] source) {
        this.source = source;
        tree = new int[4 * source.length];
        stree = new int[4 * source.length];
        build(0, 0, source.length - 1);
    }

    public int query(int l, int r) {
        return query(0, 0, source.length - 1, l - 1, r - 1);
    }

    public void modify(int l, int r, int val) {
        modify(0, 0, source.length  - 1, l - 1, r - 1, val);
    }

    private void push(int v, int vl, int vr) {
        if (stree[v] != 0) {
            tree[v] += stree[v] * (vr - vl + 1);
            if (vl != vr) {
                stree[2 * v + 1] += stree[v];
                stree[2 * v + 2] += stree[v];
            }
            stree[v] = 0;
        }
    }

    private void modify(int v, int vl, int vr, int l, int r, int val) {
        push(v, vl, vr);
        if (vr < l || vl > r) {
            return;
        } else if (vl >= l && vr <= r) {
            stree[v] = val;
            push(v, vl, vr);
            return;
        }
        int vm = vl + (vr - vl) / 2;
        modify(2 * v + 1, vl, vm, l, r, val);
        modify(2 * v + 2, vm + 1, vr, l, r, val);
        tree[v] = tree[2 * v + 1] + tree[2 * v + 2];
    }

    private int query(int v, int vl, int vr, int l, int r) {
        push(v, vl, vr);
        if (vr < l || vl > r) {
            return 0;
        } else if (vl >= l && vr <= r) {
            return tree[v];
        }
        int vm = vl + (vr - vl) / 2;
        int leftQuery = query(2 * v + 1, vl, vm, l, r);
        int rightQuery = query(2 * v + 2, vm + 1, vr, l, r);
        return leftQuery + rightQuery;
    }

    private void build(int v, int vl, int vr) {
        if (vl == vr) {
            tree[v] = source[vl];
            return;
        }
        int vm = vl + (vr - vl) / 2;
        build(2 * v + 1, vl, vm);
        build(2 * v + 2, vm + 1, vr);
        tree[v] = tree[2 * v + 1] + tree[2 * v + 2];
    }
}
