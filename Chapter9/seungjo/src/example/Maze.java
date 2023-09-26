package example;

public class Maze {
    // 미로의 크기와 구조를 나타내는 2차원 배열
    private int[][] maze;
    private int mazeSize;

    public Maze(int[][] maze) {
        this.maze = maze;
        this.mazeSize = maze.length;
    }

    // 미로를 탐색하고 경로를 찾는 메서드
    public boolean solveMaze(int x, int y) {
        // 기저 조건: 목적지에 도착한 경우
        if (x == mazeSize - 1 && y == mazeSize - 1) {
            return true; // 경로를 찾았음
        }

        // 현재 위치에서 이동할 수 있는 방향을 검사
        if (isSafe(x, y)) {
            // 현재 위치를 방문했다고 표시
            maze[x][y] = 1;

            // 오른쪽으로 이동 시도
            if (solveMaze(x + 1, y)) {
                return true;
            }
            // 아래로 이동 시도
            if (solveMaze(x, y + 1)) {
                return true;
            }

            // 해당 경로로는 도착할 수 없음을 표시
            maze[x][y] = 0;
        }

        return false; // 경로를 찾지 못함
    }

    // 현재 위치를 방문할 수 있는지 검사하는 메서드
    private boolean isSafe(int x, int y) {
        // 유효한 미로 내부 좌표인지 확인하고, 벽(장애물)이 아닌지 검사
        return x >= 0 && x < mazeSize && y >= 0 && y < mazeSize && maze[x][y] == 0;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0, 0},
                {0, 1, 0, 1},
                {0, 0, 0, 0},
                {0, 1, 1, 0}
        };

        Maze solver = new Maze(maze);
        if (solver.solveMaze(0, 0)) {
            System.out.println("경로를 찾았습니다.");
        } else {
            System.out.println("경로를 찾을 수 없습니다.");
        }
    }
}
