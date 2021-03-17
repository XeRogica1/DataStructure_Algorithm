package knighttour;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class KnightTour {
    public static int X;//棋盘列
    public static int Y;//棋盘行
    public boolean[][] isVisited;//标记该位置是否访问
    public boolean isFinished;//标记是否完成

    public KnightTour(int x, int y) {
        X = x;
        Y = y;
        isVisited = new boolean[x][y];
    }

    //返回当前位置下一步可以走那些位置，将这些位置添加到集合中
    public static ArrayList<Point> nextPoint(Point curPoint) {
        ArrayList<Point> points = new ArrayList<>();
        Point p = new Point();
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y - 1) >= 0) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y - 2) >= 0) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y - 2) >= 0) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y - 1) >= 0) {
            points.add(new Point(p));
        }

        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y + 1) < Y) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y + 2) < Y) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y + 2) < Y) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y + 1) < Y) {
            points.add(new Point(p));
        }
        return points;
    }

    //将集合进行非递减排序
    public static void sort(ArrayList<Point> points) {
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int count1 = nextPoint(o1).size();
                int count2 = nextPoint(o2).size();
                return count1 - count2;
            }
        });
    }

    /**
     * @param chessBoard 棋盘
     * @param row        第几行
     * @param col        第几列
     * @param step       第几步
     */
    public void knightTour(int[][] chessBoard, int row, int col, int step) {
        //棋盘标记第几步，同时将该位置标记为已访问
        chessBoard[row][col] = step;
        isVisited[row][col] = true;
        //获取当前位置接下来的可行位置
        ArrayList<Point> points = nextPoint(new Point(col, row));
        sort(points);
        while (!points.isEmpty()) {
            //取出一个可行位置
            Point p = points.remove(0);
            //没访问过，递归
            if (!isVisited[p.y][p.x]) {
                knightTour(chessBoard, p.y, p.x, step + 1);
            }
        }
        //如果没有完成，则将改点重新置为0
        if (step < X * Y && !isFinished) {
            chessBoard[row][col] = 0;
            isVisited[row][col] = false;

        } else {
            isFinished = true;
        }
    }
}
