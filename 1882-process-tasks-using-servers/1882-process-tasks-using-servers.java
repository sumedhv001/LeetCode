import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> available = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) {
                return Integer.compare(a[2], b[2]);
            }
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        for (int i = 0; i < servers.length; i++) {
            available.offer(new int[]{servers[i], i, 0});
        }

        int[] ans = new int[tasks.length];
        int time = 0;
        int idx = 0;

        while (idx < tasks.length) {
            time = Math.max(time, idx);

            while (!busy.isEmpty() && busy.peek()[2] <= time) {
                available.offer(busy.poll());
            }

            if (available.isEmpty()) {
                time = busy.peek()[2];

                while (!busy.isEmpty() && busy.peek()[2] <= time) {
                    available.offer(busy.poll());
                }
            }

            int[] curr = available.poll();

            ans[idx] = curr[1];
            curr[2] = time + tasks[idx];

            busy.offer(curr);

            idx++;
        }

        return ans;
    }
}