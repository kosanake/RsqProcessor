package com.segment.processor;

/**
 * Greatest Common Divisor (with value modification)
 */
public class RsqGreatestCommonDevisorProcessor {
    private int[] tree;
    private int[] source;

    public RsqGreatestCommonDevisorProcessor(int[] source) {
        this.source = source;
        this.tree = new int[4 * source.length];
        build(0, 0, source.length - 1);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int query(int l, int r) {
        return query(0, 0, source.length - 1, l - 1, r - 1);
    }

    public void modify(int pos, int val) {
        modify(0, 0, source.length - 1, pos - 1, val);
    }

    private void modify(int v, int vl, int vr, int pos, int val) {
        if (vl == vr) {
            tree[v] = val;
            return;
        }

        int vm = vl + (vr - vl) / 2;
        if (pos <= vm)
            modify(2 * v + 1, vl, vm, pos, val);
        else
            modify(2 * v + 2, vm + 1, vr, pos, val);

        tree[v] = gcd(tree[2 * v + 1], tree[2 * v + 2]);
    }

    private int query(int v, int vl, int vr, int l, int r) {
        if (r < vl || l > vr)
            return 0;
        else if (vl >= l && vr <= r)
            return tree[v];

        int vm = vl + (vr - vl) / 2;
        int ql = query(2 * v + 1, vl, vm, l, r);
        int qr = query(2 * v + 2, vm + 1, vr, l, r);
        return gcd(ql, qr);
    }

    private void build(int v, int vl, int vr) {
        if (vl == vr) {
            tree[v] = source[vl];
            return;
        }
        int vm = vl + (vr - vl) / 2;
        build(2 * v + 1, vl, vm);
        build(2 * v + 2, vm + 1, vr);
        tree[v] = gcd(tree[2 * v + 1], tree[2 * v + 2]);
    }
}
