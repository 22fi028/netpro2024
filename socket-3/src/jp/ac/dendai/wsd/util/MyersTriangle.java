package jp.ac.dendai.wsd.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MyersTriangle{
    
    public static int judge(int a, int b, int c){
        if(a + b > c && b + c > a && c + a > b){
            if(a == b && b == c){
                return 3;
            }
            else if(a != b && b != c && c != a){
                return 1;
            }
            else if(a == b && c != a || b == c && a != b || c == a && b != c){
                return 2;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }

    public static void main(String [] args){
        MyersTriangle triangle = new MyersTriangle();
        triangle.TriangleTest();
        triangle.EstablishmentTest();
    }

    @Test
    void TriangleTest() {
        assertEquals(1, judge(2, 3, 4), "不等辺三角形の期待結果");
        assertEquals(3, judge(3, 3, 3), "正三角形の期待結果");
        assertEquals(2, judge(2, 2, 3), "二等辺三角形(a=b)の期待結果");
        assertEquals(2, judge(3, 2, 2), "二等辺三角形(b=c)の期待結果");
        assertEquals(2, judge(2, 3, 2), "二等辺三角形(c=a)の期待結果");
    }

    @Test
    void EstablishmentTest() {
        assertEquals(0, judge(2, 2, 5), "三角形成立条件不成立の場合の期待結果");
        assertEquals(0, judge(5, 2, 2), "三角形成立条件不成立の場合の期待結果");
        assertEquals(0, judge(2, 5, 2), "三角形成立条件不成立の場合の期待結果");
        assertEquals(0, judge(1, 2, 3), "三角形成立条件不成立の場合の期待結果");
    }
}
