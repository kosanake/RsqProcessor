package com.segment.processor;

import javafx.util.Pair;

/**
 * GCD with vsalue modification
 */
public class RsqMaxIndexProcessor {
    private Pair<Integer, Integer>[] tree;
    private int[] source;

    public RsqMaxIndexProcessor(int[] source) {
        this.source = source;
        this.tree = new Pair[4 * source.length];
        build(0, 0, source.length - 1);
    }

    public Pair<Integer, Integer> query(int l, int r) {
        return query(0, 0, source.length - 1, l - 1, r - 1);
    }

    public void modify(int pos, int val) {
        modify(0, 0, source.length - 1, pos, val);
    }

    private void modify(int v, int vl, int vr, int pos, int val) {
        if (vl == vr) {
            tree[v] = new Pair<>(val, vl);
            return;
        }

        int vm = vl + (vr - vl) / 2;
        if (pos <= vm)
            modify(2 * v + 1, vl, vm, pos, val);
        else
            modify(2 * v + 2, vm + 1, vr, pos, val);

        if (tree[2 * v + 1].getKey() > tree[2 * v + 2].getKey())
            tree[v] = tree[2 * v + 1];
        else
            tree[v] = tree[2 * v + 2];
    }

    private Pair<Integer, Integer> query(int v, int vl, int vr, int l, int r) {
        if (r < vl || l > vr)
            return new Pair<>(Integer.MIN_VALUE, Integer.MIN_VALUE);
        else if (vl >= l && vr <= r)
            return tree[v];

        int vm = vl + (vr - vl) / 2;
        Pair<Integer, Integer> ql = query(2 * v + 1, vl, vm, l, r);
        Pair<Integer, Integer> qr = query(2 * v + 2, vm + 1, vr, l, r);
        if (ql.getKey() > qr.getKey())
            return ql;
        else
            return qr;
    }

    private void build(int v, int vl, int vr) {
        if (vl == vr) {
            tree[v] = new Pair<>(source[vl], vl);
            return;
        }
        int vm = vl + (vr - vl) / 2;
        build(2 * v + 1, vl, vm);
        build(2 * v + 2, vm + 1, vr);
        if (tree[2 * v + 1].getKey() > tree[2 * v + 2].getKey())
            tree[v] = tree[2 * v + 1];
        else
            tree[v] = tree[2 * v + 2];
    }
}