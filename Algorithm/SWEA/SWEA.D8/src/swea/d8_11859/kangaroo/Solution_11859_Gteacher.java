import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Solution_11859_Gteacher {

    // -------- FastScanner --------
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) { this.in = in; }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = readByte();
                if (c == -1) return Integer.MIN_VALUE;
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') { sign = -1; c = readByte(); }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    // -------- bit helpers (0..N-1) --------
    static void setBit(long[] bits, int idx) {
        bits[idx >>> 6] |= (1L << (idx & 63));
    }
    static boolean getBit(long[] bits, int idx) {
        return (bits[idx >>> 6] & (1L << (idx & 63))) != 0;
    }

    // -------- 16-bit precompute for max consecutive 1s --------
    static final int SIZE16 = 1 << 16;
    static int[] pre16 = new int[SIZE16];
    static int[] suf16 = new int[SIZE16];
    static int[] best16 = new int[SIZE16];

    static void build16Tables() {
        for (int v = 0; v < SIZE16; v++) {
            int pref = 0;
            while (pref < 16 && ((v >>> pref) & 1) == 1) pref++;
            pre16[v] = pref;

            int suf = 0;
            while (suf < 16 && ((v >>> (15 - suf)) & 1) == 1) suf++;
            suf16[v] = suf;

            int best = 0, cur = 0;
            for (int b = 0; b < 16; b++) {
                if (((v >>> b) & 1) == 1) {
                    cur++;
                    if (cur > best) best = cur;
                } else cur = 0;
            }
            best16[v] = best;
        }
    }

    // combine (left: prefL,sufL,bestL,lenL) + (right: prefR,sufR,bestR,lenR)
    static int[] combine(int prefL, int sufL, int bestL, int lenL,
                         int prefR, int sufR, int bestR, int lenR) {
        int pref = (prefL == lenL) ? (lenL + prefR) : prefL;
        int suf  = (sufR == lenR) ? (lenR + sufL) : sufR;
        int best = bestL;
        if (bestR > best) best = bestR;
        int cross = sufL + prefR;
        if (cross > best) best = cross;
        return new int[]{pref, suf, best, lenL + lenR};
    }

    // longest run of 1s in bitset words
    static int maxRun(long[] bits) {
        int cur = 0, ans = 0;
        for (int w = 0; w < bits.length; w++) {
            long v = bits[w];
            if (v == 0L) { cur = 0; continue; }
            if (v == -1L) {
                cur += 64;
                if (cur > ans) ans = cur;
                continue;
            }

            int s0 = (int)(v & 0xFFFFL);
            int s1 = (int)((v >>> 16) & 0xFFFFL);
            int s2 = (int)((v >>> 32) & 0xFFFFL);
            int s3 = (int)((v >>> 48) & 0xFFFFL);

            // segment summaries for 16 bits
            int[] seg = new int[]{pre16[s0], suf16[s0], best16[s0], 16};
            int[] seg1 = new int[]{pre16[s1], suf16[s1], best16[s1], 16};
            int[] seg2 = new int[]{pre16[s2], suf16[s2], best16[s2], 16};
            int[] seg3 = new int[]{pre16[s3], suf16[s3], best16[s3], 16};

            int[] t01 = combine(seg[0], seg[1], seg[2], seg[3], seg1[0], seg1[1], seg1[2], seg1[3]);
            int[] t23 = combine(seg2[0], seg2[1], seg2[2], seg2[3], seg3[0], seg3[1], seg3[2], seg3[3]);
            int[] word = combine(t01[0], t01[1], t01[2], t01[3], t23[0], t23[1], t23[2], t23[3]);

            int wordPref = word[0];
            int wordSuf  = word[1];
            int wordBest = word[2];

            if (wordBest > ans) ans = wordBest;
            int cross = cur + wordPref;
            if (cross > ans) ans = cross;

            cur = wordSuf;
        }
        return ans;
    }

    // binary search on bDescVal (descending) to get t = count(B >= C)
    static int countGE(int[] bDescVal, int C) {
        int lo = 0, hi = bDescVal.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (bDescVal[mid] >= C) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) throws Exception {
        build16Tables();

        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int T = fs.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = fs.nextInt();
            int M = fs.nextInt();

            int[] A = new int[N];
            int[] B = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = fs.nextInt();
                B[i] = fs.nextInt();
            }

            int[] Cq = new int[M];
            int[] Dq = new int[M];
            for (int j = 0; j < M; j++) {
                Cq[j] = fs.nextInt();
                Dq[j] = fs.nextInt();
            }

            // sort indices by A asc
            long[] keyA = new long[N];
            for (int i = 0; i < N; i++) keyA[i] = (((long)A[i]) << 32) | (i & 0xFFFFFFFFL);
            Arrays.sort(keyA);
            int[] idxByA = new int[N];
            for (int k = 0; k < N; k++) idxByA[k] = (int)keyA[k];

            // sort indices by B desc
            long[] keyB = new long[N];
            for (int i = 0; i < N; i++) keyB[i] = (((long)B[i]) << 32) | (i & 0xFFFFFFFFL);
            Arrays.sort(keyB);
            int[] idxByB = new int[N];
            int[] bDescVal = new int[N];
            for (int k = 0; k < N; k++) {
                int idx = (int)keyB[N - 1 - k]; // reverse => desc
                idxByB[k] = idx;
                bDescVal[k] = B[idx];
            }

            // queries sorted by D asc (keep original index j)
            long[] keyQ = new long[M];
            for (int j = 0; j < M; j++) keyQ[j] = (((long)Dq[j]) << 32) | (j & 0xFFFFFFFFL);
            Arrays.sort(keyQ);

            int words = (N + 63) >>> 6;

            // SA: indices with A <= current D (built incrementally)
            long[] SA = new long[words];

            // ---- B snapshots in blocks of K ----
            final int K = 64;                  // block size
            int baseCount = (N / K) + 1;       // snapshots for 0, K, 2K, ...
            long[] snap = new long[baseCount * words];
            long[] curB = new long[words];
            int pB = 0;
            // base=0: empty
            System.arraycopy(curB, 0, snap, 0, words);
            for (int base = 1; base < baseCount; base++) {
                for (int t = 0; t < K && pB < N; t++, pB++) {
                    setBit(curB, idxByB[pB]);
                }
                System.arraycopy(curB, 0, snap, base * words, words);
            }

            int[] ansJ = new int[M];
            long[] tmp = new long[words]; // valid bitset per query

            int pA = 0;
            for (int qi = 0; qi < M; qi++) {
                int j = (int) keyQ[qi];
                int D = Dq[j];
                int C = Cq[j];

                // update SA by D
                while (pA < N) {
                    int idx = idxByA[pA];
                    if (A[idx] <= D) {
                        setBit(SA, idx);
                        pA++;
                    } else break;
                }

                // t = # of indices with B >= C
                int t = countGE(bDescVal, C);
                int base = t / K;
                int start = base * K;

                // tmp = SA & snap[base]
                int off = base * words;
                for (int w = 0; w < words; w++) {
                    tmp[w] = SA[w] & snap[off + w];
                }

                // patch remainder indices [start, t)
                for (int r = start; r < t; r++) {
                    int idx = idxByB[r];
                    if (getBit(SA, idx)) setBit(tmp, idx);
                }

                ansJ[j] = maxRun(tmp);
            }

            long total = 0L;
            for (int j = 0; j < M; j++) {
                total += (long)(j + 1) * ansJ[j];
            }

            out.append('#').append(tc).append(' ').append(total).append('\n');
        }

        System.out.print(out);
    }
}
