package wimi.nacosspring;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Long
 * @date 2020-04-19 16:20:05 周日
 */
public class RemoveParenthesis1085 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            if ("#".equals(str)) {
                return;
            }
            toPostTree(str);
        }
        in.close();
    }
    private static class Node {
        Object value;
        Node leftNode;
        Node rightNode;

        Node(Object value) {
            this.value = value;
        }
    }

    /**
     * 表达式树
     *
     * @param str 将字符串转换为表达式树
     */
    private static void toPostTree(String str) {
        Stack<Node> stack = new Stack<>();
        String s1 = toPostFix(str);
        String[] arr = s1.split("\\s");
        for (String s : arr) {
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s) || "^".equals(s)) {
                //取出两个数字
                Node node2 = stack.pop();
                Node node1 = stack.pop();
                Node root = new Node(s);
                root.leftNode = node1;
                root.rightNode = node2;
                stack.push(root);
            } else {
                Node node = new Node(s);
                stack.push(node);
            }
        }
        Node root = stack.pop();
        StringBuilder sb = new StringBuilder();
        print(root, sb);
        System.out.println(sb.toString());
    }

    /**
     * 打印表达式树
     *
     * @param root Node
     * @param sb   StringBuilder
     */
    private static void print(Node root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        if (root.leftNode != null &&
                (level((root.leftNode.value + "").toCharArray()[0]) < level((root.value + "").toCharArray()[0]))) {
            sb.append("(");
            print(root.leftNode, sb);
            sb.append(")");
        } else {
            print(root.leftNode, sb);
        }
        //如果当前
        sb.append(root.value);
        boolean flag = root.rightNode != null;
        boolean flag1 = flag && ("-".equals(root.value) && level((root.value + "").toCharArray()[0]) >= level((root.rightNode.value + "").toCharArray()[0]));
        boolean flag2 = flag && ("/".equals(root.value) && level((root.value + "").toCharArray()[0]) >= level((root.rightNode.value + "").toCharArray()[0]));
        boolean flag3 = flag && (level((root.rightNode.value + "").toCharArray()[0]) < level((root.value + "").toCharArray()[0]));
        if (flag1 || flag2 || flag3) {
            sb.append("(");
            print(root.rightNode, sb);
            sb.append(")");
        } else {
            print(root.rightNode, sb);
        }
    }

    /**
     * 将中缀表达式转换为后缀表达式
     *
     * @param str 传入要转换的中缀表达式
     * @return 转换后的后缀表达式
     */
    private static String toPostFix(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); ) {
            char c = str.charAt(i);
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                case '^':
                    char char1 = '(';
                    while (!stack.isEmpty() && level(c) <= level(stack.peek()) && stack.peek() != char1) {
                        sb.append(stack.pop()).append(" ");
                    }
                    stack.push(c);
                    i++;
                    break;
                case '(':
                    stack.push(c);
                    i++;
                    break;
                case ')':
                    char char2 = '(';
                    while (stack.peek() != char2) {
                        sb.append(stack.pop()).append(" ");
                    }
                    stack.pop();
                    i++;
                    break;
                default:
                    //取出数字
                    int num = 0;
                    char char0 = '0', char9 = '9';
                    while (c >= char0 && c <= char9) {
                        num = num * 10 + (c - char0);
                        if (i + 1 < str.length()) {
                            i++;
                            c = str.charAt(i);
                        } else {
                            i++;
                            break;
                        }
                    }
                    sb.append(num).append(" ");
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * 操作符等级
     *
     * @param c 字符
     * @return 操作符等级
     */
    private static int level(Character c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return Integer.MAX_VALUE;
        }
    }
}
