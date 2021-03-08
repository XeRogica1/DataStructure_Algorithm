package stack.recursion;


public class maze {
    public static void main(String[] args) {
        //二维数组构建迷宫，□表示空，■表示墙
        String[][] maze = new String[8][7];
        String[][] maze2 = new String[8][7];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = "□";
                maze2[i][j] = "□";
            }
        }
        //上下改为墙
        for (int i = 0; i < 7; i++) {
            maze[0][i] = "■";
            maze[7][i] = "■";
            maze2[0][i] = "■";
            maze2[7][i] = "■";
        }
        //左右改为墙
        for (int i = 0; i < 8; i++) {
            maze[i][0] = "■";
            maze[i][6] = "■";
            maze2[i][0] = "■";
            maze2[i][6] = "■";
        }
        maze[3][1] = "■";
        maze[3][2] = "■";
        maze[5][4] = "■";
        maze[6][4] = "■";
        maze2[3][1] = "■";
        maze2[3][2] = "■";
        maze2[5][4] = "■";
        maze2[6][4] = "■";

        //找路
        setWay(maze, 1, 1);
        //走过并记录的路
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("-------------------------------");
        //策略2找路并记录
        setWay2(maze2, 1, 1);
        for (int i = 0; i < maze2.length; i++) {
            for (int j = 0; j < maze2[i].length; j++) {
                System.out.print(maze2[i][j] + "\t");
            }
            System.out.println();
        }

    }

    //迷宫问题详述
    /*
    maze表示地图
    i,j表示开始位置
    终点为maze[6][5]，到达则说明找到路
    为□表示未走过，为■表示墙，为☑表示通路，为☒表示路已走过但不通
    策略，下=>右=>上=>左，走不通再回溯
    */
    public static boolean setWay(String[][] maze, int i, int j) {
        //找到终点
        if (maze[6][5].equals("☑")) {
            return true;
        } else {
            //这个点还没走过
            if (maze[i][j].equals("□")) {
                maze[i][j] = "☑";//该点可以走
                if (setWay(maze, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(maze, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(maze, i - 1, j)) {//向上走
                    return true;
                } else if (setWay(maze, i, j - 1)) {//向左走
                    return true;
                } else {
                    //四个方向都走返回false说明走不通，则设为☒
                    maze[i][j] = "☒";
                    return false;
                }
            } else {
                //maze[i][j]不为□，可能为■☑☒
                return false;
            }
        }
    }

    //修改策略为上=>右=>下=>左
    public static boolean setWay2(String[][] maze, int i, int j) {
        //找到终点
        if (maze[6][5].equals("☑")) {
            return true;
        } else {
            //这个点还没走过
            if (maze[i][j].equals("□")) {
                maze[i][j] = "☑";//该点可以走
                if (setWay2(maze, i - 1, j)) {//向上走
                    return true;
                } else if (setWay2(maze, i, j + 1)) {//向右走
                    return true;
                } else if (setWay2(maze, i + 1, j)) {//向下走
                    return true;
                } else if (setWay2(maze, i, j - 1)) {//向左走
                    return true;
                } else {
                    //四个方向都走返回false说明走不通，则设为☒
                    maze[i][j] = "☒";
                    return false;
                }
            } else {
                //maze[i][j]不为□，可能为■☑☒
                return false;
            }
        }
    }
}
