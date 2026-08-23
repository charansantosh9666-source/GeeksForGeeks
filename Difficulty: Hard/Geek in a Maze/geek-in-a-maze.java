class Solution {
    static class State implements Comparable<State> {
                int r, c, upUsed, downUsed;

                State(int r, int c, int upUsed, int downUsed) {
                    this.r = r;
                    this.c = c;
                    this.upUsed = upUsed;
                    this.downUsed = downUsed;
                }

                @Override
                public int compareTo(State other) {
                    return Integer.compare(this.upUsed + this.downUsed, other.upUsed + other.downUsed);
                }
            }

            public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
                int rows = mat.length;
                int cols = mat[0].length;

                if (r < 0 || r >= rows || c < 0 || c >= cols || mat[r][c] == '#') {
                    return 0;
                }

                int[][] minUp = new int[rows][cols];
                int[][] minDown = new int[rows][cols];

                for (int i = 0; i < rows; i++) {
                    Arrays.fill(minUp[i], Integer.MAX_VALUE);
                    Arrays.fill(minDown[i], Integer.MAX_VALUE);
                }

                PriorityQueue<State> pq = new PriorityQueue<>();
                pq.offer(new State(r, c, 0, 0));
                minUp[r][c] = 0;
                minDown[r][c] = 0;

                boolean[][] visited = new boolean[rows][cols];
                int count = 0;

                int[][] directions = {
                    {-1, 0, 1, 0}, // UP
                    {1, 0, 0, 1},  // DOWN
                    {0, -1, 0, 0}, // LEFT
                    {0, 1, 0, 0}   // RIGHT
                };

                while (!pq.isEmpty()) {
                    State curr = pq.poll();

                    if (!visited[curr.r][curr.c]) {
                        visited[curr.r][curr.c] = true;
                        count++;
                    }

                    for (int[] dir : directions) {
                        int nr = curr.r + dir[0];
                        int nc = curr.c + dir[1];
                        int nUp = curr.upUsed + dir[2];
                        int nDown = curr.downUsed + dir[3];

                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && mat[nr][nc] != '#') {
                            if (nUp <= u && nDown <= d) {
                                if (nUp < minUp[nr][nc] || nDown < minDown[nr][nc]) {
                                    minUp[nr][nc] = Math.min(minUp[nr][nc], nUp);
                                    minDown[nr][nc] = Math.min(minDown[nr][nc], nDown);
                                    pq.offer(new State(nr, nc, nUp, nDown));
                                }
                            }
                        }
                    }
                }

                return count;
        }
    }
